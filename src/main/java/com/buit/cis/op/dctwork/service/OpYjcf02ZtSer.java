package com.buit.cis.op.dctwork.service;


import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpYjcf02ZtDao;
import com.buit.op.model.OpYjcf02Zt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 门诊_门诊医技单明细表_组套<br>
 * @author 老花生
 */
@Service
public class OpYjcf02ZtSer extends BaseManagerImp<OpYjcf02Zt,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OpYjcf02ZtSer.class);
    
    @Autowired
    private OpYjcf02ZtDao opYj02ZtDao;
    
    @Override
    public OpYjcf02ZtDao getEntityMapper(){        
        return opYj02ZtDao;
    }
    
}
