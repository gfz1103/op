package com.buit.cis.op.dctwork.service;



import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.MpPsxxDao;
import com.buit.commons.model.MpPsxx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 互联网医院配送信息表<br>
 * @author DESKTOP-1OEG1QM
 */
@Service
public class MpPsxxSer extends BaseManagerImp<MpPsxx,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(MpPsxxSer.class);
    
    @Autowired
    private MpPsxxDao mpPsxxDao;
    
    @Override
    public MpPsxxDao getEntityMapper(){
        return mpPsxxDao;
    }
    
}
