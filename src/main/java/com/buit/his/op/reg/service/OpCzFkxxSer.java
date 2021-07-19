package com.buit.his.op.reg.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpCzFkxxDao;
import com.buit.commons.model.OpCzFkxx;
/**
 * 充值_充值收费付款信息<br>
 * @author WY
 */
@Service
public class OpCzFkxxSer extends BaseManagerImp<OpCzFkxx,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OpCzFkxxSer.class);
    
    @Autowired
    private OpCzFkxxDao opCzFkxxDao;
    
    @Override
    public OpCzFkxxDao getEntityMapper(){        
        return opCzFkxxDao;
    }
    
}
