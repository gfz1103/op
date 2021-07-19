package com.buit.ecis.pretriage.service;


import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.ecis.pretriage.dao.ErPreBrqxDao;
import com.buit.ecis.pretriage.model.ErPreBrqx;
import com.buit.ecis.pretriage.request.ErPreBrqxAddReq;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 病人去向<br>
 * @author 朱智
 */
@Service
public class ErPreBrqxSer extends BaseManagerImp<ErPreBrqx,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(ErPreBrqxSer.class);
    
    @Autowired
    private ErPreBrqxDao erPreBrqxDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public ErPreBrqxDao getEntityMapper(){        
        return erPreBrqxDao;
    }

    /**
     * @name: add
     * @description: 新增
     * @param erPreBrqx
     * @return: void
     * @date: 2020/9/13 9:43
     * @auther: 朱智
     *
     */
    public void add(ErPreBrqxAddReq erPreBrqx) {
        Integer id = redisFactory.getTableKey(TableName.DB_NAME, TableName.ER_PRE_BRQX);
        erPreBrqx.setQxid(id);
        erPreBrqx.setZt("1");
        erPreBrqxDao.insert(erPreBrqx);
    }
}
