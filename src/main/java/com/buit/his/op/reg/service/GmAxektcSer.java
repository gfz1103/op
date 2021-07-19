package com.buit.his.op.reg.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.GmAxektcDao;
import com.buit.commons.model.GmAxektc;
/**
 * <br>
 * @author WY
 */
@Service
public class GmAxektcSer extends BaseManagerImp<GmAxektc,String> {
    
    static final Logger logger = LoggerFactory.getLogger(GmAxektcSer.class);
    
    @Autowired
    private GmAxektcDao gmAxektcDao;
    
    @Override
    public GmAxektcDao getEntityMapper(){        
        return gmAxektcDao;
    }
    
}
