package com.buit.cis.op.dctwork.service;



import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpCfpsDao;
import com.buit.commons.model.OpCfps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 处方皮试<br>
 * @author 朱智
 */
@Service
public class OpCfpsSer extends BaseManagerImp<OpCfps,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OpCfpsSer.class);
    
    @Autowired
    private OpCfpsDao opCfpsDao;
    
    @Override
    public OpCfpsDao getEntityMapper(){        
        return opCfpsDao;
    }
    
}
