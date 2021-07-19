package com.buit.cis.op.dctwork.service;


import com.buit.commons.BaseManagerImp;

import com.buit.commons.dao.MpBlackListDao;
import com.buit.commons.model.MpBlackList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 黑名单表<br>
 * @author DESKTOP-1OEG1QM
 */
@Service
public class MpBlackListSer extends BaseManagerImp<MpBlackList,Long> {
    
    static final Logger logger = LoggerFactory.getLogger(MpBlackListSer.class);
    
    @Autowired
    private MpBlackListDao mpBlackListDao;
    
    @Override
    public MpBlackListDao getEntityMapper(){        
        return mpBlackListDao;
    }
    
}
