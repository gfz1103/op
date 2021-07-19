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
import com.buit.commons.dao.MkeyRecordTsDao;
import com.buit.commons.dao.MkeyUserDao;
import com.buit.commons.model.MkeyRecordCert;
import com.buit.commons.model.MkeyRecordTs;
import com.buit.commons.model.MkeyUser;
import com.buit.op.model.mphis.response.MkeyRecord;
import com.buit.op.service.mphis.MphisOpService;
import com.buit.op.service.mphis.mkey.consts.Action;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

@Service
public class DoctorMkeyLoginService extends DoctorMkeySignService {
    static final Logger log = LoggerFactory.getLogger(DoctorMkeyLoginService.class);

    private static final int MKEY_BIZSN_TIMEOUT_SEC = 120;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    private RedisMessageSender redisMessageSender;

    //CA认证相关接口
    @DubboReference
    private MphisOpService mphisOpService;

//    @Autowired
//    private LoginService loginService;

    @Autowired
    private MkeyRecordDao mkeyRecordMapper;

    @Autowired
    private MkeyRecordCertDao mkeyRecordCertMapper;

    @Autowired
    private Snowflake snowflake;

    @Autowired
    private MkeyRecordTsDao mkeyRecordTsMapper;

    @Autowired
    private MkeyUserDao mkeyUserMapper;

    @Override
    public String data(Integer dataId) {
        return "login";
    }

    @Override
    @Transactional
    public MkeyRecord callBackProcess(String bizSn) {
        MkeyRecord record = mkeyRecordMapper.selectByBizsn(bizSn);

        log.debug("【mkey 登录回调】=> bizSn:{}, action:{}, signAlg:{}, signValue:{}, id:{}", bizSn, record.getActionType(), record.getSignAlg(), record.getSignValue(), record.getMkeyUserId());

        LoginResult result = new LoginResult();
        result.setBizSn(bizSn);

        if(!stringRedisTemplate.hasKey(String.format(RedisKeys.MKEY_BIZSN_KEY, bizSn))){
            //发送登录ws消息
            result.setMkeyCode(String.valueOf(SecurityStatus.NOT_EXIST_BIZSN.getCode()));
            result.setMkeyMsg("扫码超时,或二维码过期,请重新扫码登录");

            JSON json = JSONUtil.parse(result);
            stringRedisTemplate.opsForValue().set(String.format(RedisKeys.CALLBACK_BIZSN_KEY, bizSn), json.toString(), MKEY_BIZSN_TIMEOUT_SEC, TimeUnit.SECONDS);
            //发送ws消息
            //redisMessageSender.sendUserLoginByMkey(new JSONObject(result));
            return record;
        }

        if(record.getActionType().equals(Action.CONFIRM.getValue())){
            result.setMkeyCode(String.valueOf(MkeyStatus.CONFIRM.getCode()));
            result.setMkeyMsg("扫码确认中");
            JSON json = JSONUtil.parse(result);
            stringRedisTemplate.opsForValue().set(String.format(RedisKeys.CALLBACK_BIZSN_KEY, bizSn), json.toString(), MKEY_BIZSN_TIMEOUT_SEC, TimeUnit.SECONDS);
        }else if(record.getActionType().equals(Action.LOGIN.getValue())){
            MkeyRecordCert cert = mkeyRecordCertMapper.selectByRecordId(record.getId());
            if(null == cert || StrUtil.isBlank(cert.getCert())){
                log.error("【mkey 扫码回调】=> 查询证书为空, bizSn:{}", bizSn);
                throw BaseException.create(MkeyStatus.CERT_NULL.getMsg());
            }

            //验证签名
            if(!mphisOpService.qrcodeNotiryVerify(bizSn, cert.getCert(), record.getSignAlg(), record.getSignValue())){
                log.error("【mkey 扫码登录回调】=> 签名验证不通过, bizSn:{}", bizSn);
                result.setMkeyCode(String.valueOf(MkeyStatus.VERIFY_FAIL.getCode()));
                result.setMkeyMsg("扫码登录异常,请重试");
            }else{
                try {
                    //可信时间戳
                    MkeyRecordTs ts = new MkeyRecordTs();
                    ts.setRecordId(Long.valueOf(snowflake.nextId()).intValue());
                    ts.setRecordId(record.getId());
                    ts.setTs(mphisOpService.getTimeStamp(record.getSignData()));
                    ts.setCreateTime(new Timestamp(System.currentTimeMillis()));
                    ts.setUpdateTime(new Timestamp(System.currentTimeMillis()));
                    mkeyRecordTsMapper.insert(ts);

                    //登录
                    result.setMkeyCode(String.valueOf(Status.SUCCESS.getCode()));
                    result.setMkeyMsg("扫码登录成功");

                    //成功后业务数据处理
                    success(record.getDataId());
                }catch (BaseException e){
                    log.error("【mkey 扫码回调】=> 异常, bizSn:{}", bizSn, e);
                    result.setMkeyCode(String.valueOf(Integer.valueOf(e.getCode())));
                    result.setMkeyMsg(e.getMessage());
                }catch (Exception e) {
                    log.error("【mkey 扫码回调】=> 未知异常, bizSn:{}", bizSn, e);
                    result.setMkeyCode(String.valueOf(Status.ERROR.getCode()));
                    result.setMkeyMsg("失败");
                }
            }

            JSON json = JSONUtil.parse(result);
            stringRedisTemplate.opsForValue().set(String.format(RedisKeys.CALLBACK_BIZSN_KEY, bizSn), json.toString(), MKEY_BIZSN_TIMEOUT_SEC, TimeUnit.SECONDS);
        }else{
            log.error("【mkey 登录回调】=> 未知action, bizSn:{}, action:{}, signAlg:{}, signValue:{}, id:{}", bizSn, record.getActionType(), record.getSignAlg(), record.getSignValue(), record.getMkeyUserId());
        }
        return record;
    }

    @Override
    public void success(Integer dataId) {}

    @Override
    public void check(String mkeyUserId, Integer dataId) throws BaseException{
        MkeyUser mkeyUser = mkeyUserMapper.selectByMkeyUserId(mkeyUserId);
        if(null == mkeyUser){
            log.error("查询CA用户信息失败:mkeyUserID:{}",mkeyUserId);
            throw BaseException.create("ERROR_CA_0003");
        }
        //判断扫码用户是否匹配
        if (dataId != null && !dataId.equals(mkeyUser.getSysUserId())){
            log.error("【mkey 登录】=> CA账号不匹配, sysUserId:{}, dataId:{}", mkeyUser.getSysUserId(), dataId);
            throw BaseException.create("ERROR_CA_0002");
        }

    }
}
