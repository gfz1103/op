package com.buit.his.op.reg.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpCzjlDao;
import com.buit.op.model.OpCzjl;
/**
 * 充值卡操作记录<br>
 * @author WY
 */
@Service
public class OpCzjlSer extends BaseManagerImp<OpCzjl,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OpCzjlSer.class);
    
    @Autowired
    private OpCzjlDao opCzjlDao;
    
    @Override
    public OpCzjlDao getEntityMapper(){        
        return opCzjlDao;
    }
    
}
