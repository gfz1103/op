package com.buit.cis.op.dctwork.service.mkey.sign.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.buit.cis.op.dctwork.service.mkey.code.MkeyStatus;
import com.buit.cis.op.dctwork.service.mkey.consts.RedisKeys;
import com.buit.cis.op.dctwork.service.mkey.consts.SecurityStatus;
import com.buit.cis.op.dctwork.service.mkey.consts.Status;
import com.buit.cis.op.dctwork.service.mkey.result.LoginResult;
import com.buit.commons.BaseException;
import com.buit.commons.dao.MkeyRecordCertDao;
import com.buit.commons.dao.MkeyRecordDao;
import com.buit.commons.dao.MkeyRecordSealDao;
import com.buit.commons.dao.MkeyRecordTsDao;
import com.buit.commons.model.MkeyRecordCert;
import com.buit.commons.model.MkeyRecordSeal;
import com.buit.commons.model.MkeyRecordTs;
import com.buit.op.model.mphis.response.MkeyRecord;
import com.buit.op.service.mphis.MphisOpService;
import com.buit.op.service.mphis.mkey.consts.Action;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 * @Author sunjx
 * @Date 2020-07-20 13:35
 * @Description
 **/
public abstract class DoctorMkeySignService {
    static final Logger log = LoggerFactory.getLogger(DoctorMkeySignService.class);

    private static final int MKEY_BIZSN_TIMEOUT_SEC = 120;

    @Autowired
    private MkeyRecordDao mkeyRecordMapper;

    @Autowired
    private MkeyRecordCertDao mkeyRecordCertMapper;

    @Autowired
    private MkeyRecordSealDao mkeyRecordSealMapper;

    @Autowired
    private MkeyRecordTsDao mkeyRecordTsMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    private RedisMessageSender redisMessageSender;

    //CA??????????????????
    @DubboReference
    private MphisOpService mphisOpService;

    @Autowired
    private Snowflake snowflake;

    //???????????????????????????
    public abstract String data(Integer dataId);

    //???????????????
    @Transactional
    public MkeyRecord callBackProcess(String bizSn){
        MkeyRecord record = mkeyRecordMapper.selectByBizsn(bizSn);

        LoginResult result = new LoginResult();
        result.setBizSn(bizSn);

        if(!stringRedisTemplate.hasKey(String.format(RedisKeys.MKEY_BIZSN_KEY, bizSn))){
            //????????????ws??????
            result.setMkeyCode(String.valueOf(SecurityStatus.NOT_EXIST_BIZSN.getCode()));
            result.setMkeyMsg(SecurityStatus.NOT_EXIST_BIZSN.getMsg());

            JSON json = JSONUtil.parse(result);
            stringRedisTemplate.opsForValue().set(String.format(RedisKeys.CALLBACK_BIZSN_KEY, bizSn), json.toString(), MKEY_BIZSN_TIMEOUT_SEC, TimeUnit.SECONDS);
            return record;
        }

        if(record.getActionType().equals(Action.CONFIRM.getValue())){
            result.setMkeyCode(String.valueOf(MkeyStatus.CONFIRM.getCode()));
            result.setMkeyMsg("???????????????");
            JSON json = JSONUtil.parse(result);
            stringRedisTemplate.opsForValue().set(String.format(RedisKeys.CALLBACK_BIZSN_KEY, bizSn), json.toString(), MKEY_BIZSN_TIMEOUT_SEC, TimeUnit.SECONDS);
        }else if(record.getActionType().equals(Action.SIGN.getValue())){
            MkeyRecordCert cert = mkeyRecordCertMapper.selectByRecordId(record.getId());
            if(null == cert || StrUtil.isBlank(cert.getCert())){
                log.error("???mkey ???????????????=> ??????????????????, bizSn:{}", bizSn);
                throw BaseException.create("ERROR_CA_0006");
            }

            //????????????
            if(!mphisOpService.qrcodeNotiryVerify(bizSn, cert.getCert(), record.getSignAlg(), record.getSignValue())){
                log.error("???mkey ???????????????=> ?????????????????????, bizSn:{}", bizSn);
                result.setMkeyCode(String.valueOf(MkeyStatus.VERIFY_FAIL.getCode()));
                result.setMkeyMsg("????????????,?????????");
            }else{
                try {
                    //??????????????????????????????
                    MkeyRecordSeal seal = new MkeyRecordSeal();
                    seal.setId(Long.valueOf(snowflake.nextId()).intValue());
                    seal.setRecordId(record.getId());
                    seal.setSeal(mphisOpService.getSeal(record.getMkeyUserId()));
                    seal.setUserId(record.getUserId());
                    seal.setCreateTime(new Timestamp(System.currentTimeMillis()));
                    seal.setUpdateTime(new Timestamp(System.currentTimeMillis()));
                    mkeyRecordSealMapper.insert(seal);

                    //???????????????
                    MkeyRecordTs ts = new MkeyRecordTs();
                    ts.setRecordId(Long.valueOf(snowflake.nextId()).intValue());
                    ts.setRecordId(record.getId());
                    ts.setTs(mphisOpService.getTimeStamp(record.getSignData()));
                    ts.setCreateTime(new Timestamp(System.currentTimeMillis()));
                    ts.setUpdateTime(new Timestamp(System.currentTimeMillis()));
                    mkeyRecordTsMapper.insert(ts);

                    result.setMkeyCode(String.valueOf(Status.SUCCESS.getCode()));
                    result.setMkeyMsg("??????");

                    //???????????????????????????
                    success(record.getDataId());
                }catch(BaseException e){
                    log.error("???mkey ???????????????=> ??????, bizSn:{}", bizSn, e);
                    result.setMkeyCode(e.getCode());
                    result.setMkeyMsg(e.getMessage());
                }catch (Exception e) {
                    log.error("???mkey ???????????????=> ????????????, bizSn:{}", bizSn, e);
                    result.setMkeyCode(String.valueOf(Status.ERROR.getCode()));
                    result.setMkeyMsg("??????");
                }
            }

            JSON json = JSONUtil.parse(result);
            stringRedisTemplate.opsForValue().set(String.format(RedisKeys.CALLBACK_BIZSN_KEY, bizSn), json.toString(), MKEY_BIZSN_TIMEOUT_SEC, TimeUnit.SECONDS);
        }else{
            log.error("???mkey ???????????????=> ??????action, bizSn:{}, action:{}, signAlg:{}, signValue:{}, id:{}", bizSn, record.getActionType(), record.getSignAlg(), record.getSignValue(), record.getMkeyUserId());
        }
        return record;
    }

    //???????????????????????????
    public abstract void success(Integer dataId);

    //????????????????????????
    public abstract void check(String mkeyUserId, Integer dataId);
}
