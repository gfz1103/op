package com.buit.cis.op.dctwork.service;


import com.buit.commons.BaseManagerImp;

import com.buit.commons.dao.MpGlksDao;
import com.buit.commons.model.MpGlks;
import com.buit.commons.request.MpGlksReq;
import com.buit.utill.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 互联网科室HIS挂号科室关联表<br>
 * @author DESKTOP-1OEG1QM
 */
@Service
public class MpGlksSer extends BaseManagerImp<MpGlks,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(MpGlksSer.class);
    
    @Autowired
    private MpGlksDao mpGlksDao;
    
    @Override
    public MpGlksDao getEntityMapper(){        
        return mpGlksDao;
    }

    public MpGlks saveOrUpdate(MpGlks mpGlksReq) {
        MpGlks mpGlks = mpGlksDao.getById(mpGlksReq.getGhks());
        if(Objects.nonNull(mpGlks)){
            mpGlks.setGlks(mpGlksReq.getGlks());
            mpGlksDao.update(mpGlks);
        }else {
            mpGlks = BeanUtil.toBean(mpGlksReq, MpGlks.class);
            mpGlksDao.insert(mpGlks);
        }
        return mpGlks;
    }
}
