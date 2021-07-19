package com.buit.cis.op.dctwork.service.mkey;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.buit.cis.op.dctwork.service.mkey.consts.Consts;
import com.buit.cis.op.dctwork.service.mkey.consts.RedisKeys;
import com.buit.cis.op.dctwork.service.mkey.consts.Status;
import com.buit.cis.op.dctwork.service.mkey.result.LoginResult;
import com.buit.cis.op.dctwork.service.mkey.sign.DoctorMkeySignServiceConsts;
import com.buit.cis.op.dctwork.service.mkey.sign.DoctorMkeySignServiceHolder;
import com.buit.cis.op.dctwork.service.mkey.sign.service.DoctorMkeySignService;
import com.buit.commons.BaseException;
import com.buit.commons.dao.MkeyRecordCertDao;
import com.buit.commons.dao.MkeyRecordDao;
import com.buit.commons.dao.MkeyUserDao;
import com.buit.commons.model.MkeyRecordCert;
import com.buit.commons.model.MkeyUser;
import com.buit.op.model.mphis.response.MkeyRecord;
import com.buit.op.service.mphis.MphisOpService;
import com.buit.op.service.mphis.mkey.consts.Action;
import com.buit.op.service.mphis.mkey.consts.Mode;
import com.buit.op.service.mphis.mkey.consts.MsgWrap;
import com.buit.op.service.mphis.mkey.result.MkeyCertResult;
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
public class DoctorMkeyService {
    static final Logger log = LoggerFactory.getLogger(DoctorMkeyService.class);

    //扫码过期时间
    private static final int MKEY_BIZSN_TIMEOUT_SEC = 120;

    private static final String CHAR_SET = "UTF-8";

    @Autowired
    private MkeyRecordDao mkeyRecordMapper;

    @Autowired
    private MkeyUserDao mkeyUserMapper;

    @Autowired
    private MkeyRecordCertDao mkeyRecordCertMapper;

    //CA认证相关接口
    @DubboReference
    private MphisOpService mphisOpService;

    @Autowired
    private DoctorMkeySignServiceHolder signServiceHolder;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    private RedisMessageSender redisMessageSender;

    @Transactional
    public String qrcode(String bizSn, DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType type, Integer dataId, Mode mode, Action action, MsgWrap wrap) {
        DoctorMkeySignService signService = signServiceHolder.getService(type);

        MkeyRecord record = new MkeyRecord();
        record.setBizSn(bizSn);
        record.setActionType(null);
        record.setMsgWrapper(wrap.getValue());
        record.setMode(mode.getValue());
        record.setDataType(type.getValue());
        record.setDataId(dataId);
        record.setSignData(signService.data(dataId));
        record.setStatus(Consts.Status.NOMAL.getKey());
        record.setCreateTime(new Timestamp(System.currentTimeMillis()));
        record.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        record.setNotifyTime(new Timestamp(System.currentTimeMillis()));
        mkeyRecordMapper.insert(record);

        //调用接口生成二位码
        String qrcode = mphisOpService.qrcode(bizSn, record.getSignData(), getNotifyUrl(type), mode, action, wrap);

        //缓存
        stringRedisTemplate.opsForValue().set(String.format(RedisKeys.MKEY_BIZSN_KEY, bizSn), bizSn, MKEY_BIZSN_TIMEOUT_SEC, TimeUnit.SECONDS);

        return qrcode;
    }

    @Transactional
    public MkeyRecord notify(String bizSn, String action, String cert, String signAlg, String signValue, String mkeyUserId, String ret, String msg) {
        if(StrUtil.isNotBlank(cert)){
            cert = URLUtil.decode(cert, CHAR_SET);
        }

        if(StrUtil.isNotBlank(signValue)){
            signValue = URLUtil.decode(signValue, CHAR_SET);
        }

        MkeyRecord record = mkeyRecordMapper.selectByBizsn(bizSn);
        if(null == record){
            log.error("【mkey 扫码签名回调】=> 根据流水号查询不到签名记录, bizSn:{}", bizSn);
            return null;
        }

        DoctorMkeySignService signService = signServiceHolder.getService(DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType.getByValue(record.getDataType()));

        //是否可以签名校验
        try {
            signService.check(mkeyUserId, record.getDataId());
        }catch (BaseException e) {
            LoginResult result = new LoginResult();
            result.setBizSn(bizSn);
            result.setMkeyCode(e.getCode());
            result.setMkeyMsg(e.getMessage());
            JSON json = JSONUtil.parse(result);
            stringRedisTemplate.opsForValue().set(String.format(RedisKeys.CALLBACK_BIZSN_KEY, bizSn), json.toString(), MKEY_BIZSN_TIMEOUT_SEC, TimeUnit.SECONDS);
            return record;
        } catch (Exception e){
            LoginResult result = new LoginResult();
            result.setBizSn(bizSn);
            result.setMkeyCode(String.valueOf(Status.ERROR.getCode()));
            result.setMkeyMsg(Status.ERROR.getMsg());
            JSON json = JSONUtil.parse(result);
            stringRedisTemplate.opsForValue().set(String.format(RedisKeys.CALLBACK_BIZSN_KEY, bizSn), json.toString(), MKEY_BIZSN_TIMEOUT_SEC, TimeUnit.SECONDS);
            return record;
        }

        record.setActionType(action);
        record.setSignAlg(signAlg);
        record.setSignValue(signValue);
        record.setMkeyUserId(mkeyUserId);
        record.setRet(ret);
        record.setMsg(msg);
        record.setNotifyTime(new Timestamp(System.currentTimeMillis()));
        mkeyRecordMapper.updateSelectiveById(record);

        if(StrUtil.isNotBlank(cert)){
            //证书
            MkeyRecordCert recordCert = new MkeyRecordCert();
            recordCert.setCert(cert);
            recordCert.setRecordId(record.getId());
            recordCert.setCreateTime(new Timestamp(System.currentTimeMillis()));
            recordCert.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            mkeyRecordCertMapper.insert(recordCert);
        }

        if(!action.equals(Action.CONFIRM.getValue())){
            MkeyUser mkeyUser = mkeyUserMapper.selectByMkeyUserId(mkeyUserId);
            if(null == mkeyUser){
                return signService.callBackProcess(bizSn);
            }

            record.setUserId(mkeyUser.getSysUserId());
            mkeyRecordMapper.updateSelectiveById(record);
        }

        return signService.callBackProcess(bizSn);
    }

    @Transactional
    public void saveMkeyUser(MkeyUser mkeyUser) {
        if(null == mkeyUser.getId()){
            mkeyUser.setStatus(Consts.Status.NOMAL.getKey());
            mkeyUserMapper.insert(mkeyUser);
        }else{
            //mkeyUserMapper.updateSelectiveById(mkeyUser);
        }
    }

    /**
     * 获取当前bizSn的扫码回调状态
     * @param bizSn
     * @return
     */
    public JSONObject getCallBackStatus(String bizSn){
        String json = stringRedisTemplate.opsForValue().get(String.format(RedisKeys.CALLBACK_BIZSN_KEY, bizSn));
        if (StrUtil.isBlank(json)){
            return null;
        }
        JSONObject jsonObject = JSONUtil.parseObj(json);
        return jsonObject;
    }

    /**
     * 通过用户ID查询患者的证书序列号
     * @param sysUserId
     * @return
     */
    public String getCazsxlh(String sysUserId){
        if (StrUtil.isBlank(sysUserId)){
            return null;
        }
        //查询mkey_user
        MkeyUser user = mkeyUserMapper.selectBySysUserId(sysUserId);
        if (user == null){
            return null;
        }

        MkeyCertResult cert = mphisOpService.getCert(user.getMkeyUserId());
        if (cert != null){
            //数据写入到mkey_user
            MkeyUser mkeyUser = new MkeyUser();
            mkeyUser.setId(user.getId());
            mkeyUser.setCaZsxlh(cert.getCert());
            mkeyUser.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            mkeyUserMapper.updateMkeyUser(mkeyUser);

            return cert.getCert();
        }

        return null;
    }

    /**
     * 通过用户注册的手机号查询证书序列号
     * @param mkeyUserId
     * @return
     */
    public String getCazsxlhByMkeyUser(String mkeyUserId) throws BaseException{
        if (StrUtil.isBlank(mkeyUserId)){
            return null;
        }

        MkeyCertResult cert = mphisOpService.getCert(mkeyUserId);
        if (cert == null){
            throw BaseException.create("ERROR_CA_0001");
        }

        return cert.getCertSn();
    }

    private String getNotifyUrl(DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType type){
        if(type == DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType.LOGIN){
            return URLUtil.encode(mphisOpService.getNotifyUrl(type.getValue()));
        }else if(type == DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType.SIGN){
            return URLUtil.encode(mphisOpService.getNotifyUrl(type.getValue()));
        }else {
            return null;
        }
    }
}
