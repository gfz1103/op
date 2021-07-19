package com.buit.his.op.reg.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpFkxxDao;
import com.buit.commons.model.OpFkxx;
/**
 * 门诊_门诊收费付款信息<br>
 * @author WY
 */
@Service
public class OpFkxxSer extends BaseManagerImp<OpFkxx,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OpFkxxSer.class);
    
    @Autowired
    private OpFkxxDao opFkxxDao;
    
    @Override
    public OpFkxxDao getEntityMapper(){        
        return opFkxxDao;
    }
    
}
