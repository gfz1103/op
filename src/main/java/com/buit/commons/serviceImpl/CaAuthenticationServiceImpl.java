package com.buit.commons.serviceImpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.cis.op.dctwork.service.mkey.DoctorMkeyService;
import com.buit.commons.BaseException;
import com.buit.commons.dao.MkeyUserDao;
import com.buit.commons.model.MkeyUser;
import com.buit.op.request.MkeyUserReq;
import com.buit.op.service.CaAuthenticationService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * @Author weijing
 * @Date 2021-03-03 10:00
 * @Description
 **/
@DubboService(timeout = 10000)
public class CaAuthenticationServiceImpl implements CaAuthenticationService {
    static final Logger log = LoggerFactory.getLogger(CaAuthenticationServiceImpl.class);

    @Autowired
    private DoctorMkeyService doctorMkeyService;

    @Autowired
    private MkeyUserDao mkeyUserDao;

    /**
     *通过用户注册的手机号查询证书序列号
     * @param mkeyUserId
     * @return
     */
    @Override
    public String getCazsxlhByMkeyUser(String mkeyUserId) throws BaseException {
        return doctorMkeyService.getCazsxlhByMkeyUser(mkeyUserId);
    }

    /**
     *保存医生环信信息
     * @param mkeyUserReq
     */
    @Override
    public void saveMkeyUser(MkeyUserReq mkeyUserReq) {
        MkeyUser mkeyUser = BeanUtil.toBean(mkeyUserReq, MkeyUser.class);
        //数据非空判断
        if (mkeyUser.getSysUserId() == null || StrUtil.isBlank(mkeyUser.getMkeyUserId()) || StrUtil.isBlank(mkeyUser.getCaZsxlh())){
            log.error("数据不完整无法保存CA数据:sysUserID:{},mkeyUserID:{},caZsxlh:{}",mkeyUser.getSysUserId(),mkeyUser.getMkeyUserId(),mkeyUser.getCaZsxlh());
            return;
        }
        //查询数据是否已经存在
        MkeyUser user = mkeyUserDao.selectBySysUserId(String.valueOf(mkeyUser.getSysUserId()));
        if (user == null){
            log.info("开始新增mkeyUser表");
            mkeyUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
            mkeyUser.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            mkeyUser.setStatus(1);
            mkeyUserDao.insert(mkeyUser);
            log.info("完成新增mkeyUser表");
        }else {
            log.info("开始修改mkeyUser表");
            user.setMkeyUserId(mkeyUser.getMkeyUserId());
            user.setCaZsxlh(mkeyUser.getCaZsxlh());
            user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            mkeyUserDao.updateCaZsxlh(user);
            log.info("完成修改mkeyUser表");
        }
    }
}
