package com.buit.cis.op.dctwork.service.mkey.sign.service;

import com.buit.commons.BaseException;
import com.buit.commons.dao.MkeyUserDao;
import com.buit.commons.dao.OpCf01Dao;
import com.buit.commons.dao.OpCf02Dao;
import com.buit.commons.model.MkeyUser;
import com.buit.commons.model.OpCf01;
import com.buit.system.response.HrPersonnelModel;
import com.buit.system.service.HrPersonnelService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author sunjx
 * @Date 2020-07-20 14:53
 * @Description
 **/
@Service
public class DoctorMkeySignDoctorService extends DoctorMkeySignService {
    static final Logger log = LoggerFactory.getLogger(DoctorMkeySignDoctorService.class);

    @Autowired
    private OpCf01Dao opCf01Dao;

    @Autowired
    private OpCf02Dao opCf02Dao;

    @Autowired
    private MkeyUserDao mkeyUserMapper;

    @DubboReference
    private HrPersonnelService hrPersonnelService;

    @Override
    public String data(Integer dataId) {
        //查询处方表
        OpCf01 opCf01 = opCf01Dao.getById(dataId);
        if (opCf01 == null){
            return null;
        }
        //查询处方详情表
        String cfDrug = opCf02Dao.getCfDrug(opCf01.getCfsb());
        //查询医生代码
        HrPersonnelModel personnel = hrPersonnelService.getPersonnelById(Integer.valueOf(opCf01.getYsdm()));

        StringBuilder builder = new StringBuilder();
        builder.append("处方号："+ opCf01.getCfhm()+"\n");
        builder.append("开方医生："+personnel != null?personnel.getPersonname():""+"\n");
        builder.append("开方时间："+ opCf01.getKfrq()+"\n");
        builder.append("处方药品："+cfDrug);
        return builder.toString();
    }

    @Override
    @Transactional
    public void success(Integer dataId) {
//        BizPrescription prescription = new BizPrescription();
//        prescription.setId(dataId);
//        prescription.setKfyssfqm(DataStatus.sfqm.YES.getKey());
//        prescription.setCfzt(DataStatus.Cfzt.DSH.getKey());//处方状态更改为待审核
//        bizPrescriptionMapper.updateSelectiveById(prescription);
        log.debug("【开方医生数据签名成功】=> dataid:{}", dataId);
    }

    @Override
    public void check(String mkeyUserId, Integer dataId) throws BaseException{
        //查询处方表
        OpCf01 opCf01 = opCf01Dao.getById(dataId);

        if(null == opCf01){
            throw BaseException.create("ERROR_CA_0005");
        }

        //查询医生代码
        HrPersonnelModel personnel = hrPersonnelService.getPersonnelById(Integer.valueOf(opCf01.getYsdm()));

        MkeyUser mkeyUser = mkeyUserMapper.selectByMkeyUserId(mkeyUserId);

        if(null == personnel || null == mkeyUser){
            throw BaseException.create("ERROR_CA_0003");
        }
        if(!personnel.getPersonid().equals(mkeyUser.getSysUserId())){
            log.error("【mkey 签名】=> 签名人不匹配, mkeyUserId:{}, dataId:{}", mkeyUserId, dataId);
            throw BaseException.create("ERROR_CA_0004");
        }

    }
}
