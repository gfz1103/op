package com.buit.his.op.infusion.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.SkinDjmxDao;
import com.buit.commons.model.SkinDjmx;
/**
 * <br>
 * @author WY
 */
@Service
public class SkinDjmxSer extends BaseManagerImp<SkinDjmx,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SkinDjmxSer.class);
    
    @Autowired
    private SkinDjmxDao skinDjmxDao;
    
    @Override
    public SkinDjmxDao getEntityMapper(){        
        return skinDjmxDao;
    }
    
}
