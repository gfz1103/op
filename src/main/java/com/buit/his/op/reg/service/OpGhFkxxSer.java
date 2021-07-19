package com.buit.his.op.reg.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpGhFkxxDao;
import com.buit.commons.model.OpGhFkxx;
/**
 * 门诊挂号付款信息<br>
 * @author WY
 */
@Service
public class OpGhFkxxSer extends BaseManagerImp<OpGhFkxx,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OpGhFkxxSer.class);
    
    @Autowired
    private OpGhFkxxDao opGhFkxxDao;
    
    @Override
    public OpGhFkxxDao getEntityMapper(){        
        return opGhFkxxDao;
    }
    
}
