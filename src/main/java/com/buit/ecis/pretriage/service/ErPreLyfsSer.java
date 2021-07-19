package com.buit.ecis.pretriage.service;


import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.ecis.pretriage.dao.ErPreLyfsDao;
import com.buit.ecis.pretriage.model.ErPreLyfs;
import com.buit.ecis.pretriage.request.ErPreLyfsReq;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 来院方式<br>
 * @author 朱智
 */
@Service
public class ErPreLyfsSer extends BaseManagerImp<ErPreLyfs,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(ErPreLyfsSer.class);
    
    @Autowired
    private ErPreLyfsDao erPreLyfsDao;
    @Autowired
    private RedisFactory redisFactory;
    
    @Override
    public ErPreLyfsDao getEntityMapper(){        
        return erPreLyfsDao;
    }

    /** 
     * @name: add
     * @description: TODO  
     * @param erPreLyfs
     * @return: void
     * @date: 2020/9/10 15:12
     * @auther: 朱智
     * 
     */
    public void add(ErPreLyfsReq erPreLyfs) {
        Integer id = redisFactory.getTableKey(TableName.DB_NAME, TableName.ER_PRE_LYFS);
        erPreLyfs.setLyfsid(id);
        erPreLyfs.setZt("0");
        erPreLyfsDao.insert(erPreLyfs);
    }
}
