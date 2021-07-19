package com.buit.ecis.pretriage.service;


import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.ecis.pretriage.dao.ErPreZsjlDao;
import com.buit.ecis.pretriage.model.ErPreZsjl;
import com.buit.ecis.pretriage.request.ErPreZsjlAddReq;
import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;
import com.buit.utill.WubiUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 主诉记录<br>
 * @author 朱智
 */
@Service
public class ErPreZsjlSer extends BaseManagerImp<ErPreZsjl,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(ErPreZsjlSer.class);
    
    @Autowired
    private ErPreZsjlDao erPreZsjlDao;
    @Autowired
    private RedisFactory redisFactory;
    
    @Override
    public ErPreZsjlDao getEntityMapper(){        
        return erPreZsjlDao;
    }

    /**
     * @name: add
     * @description: 新增
     * @param req
     * @return: void
     * @date: 2020/9/11 14:52
     * @auther: 朱智
     *
     */
    public void add(ErPreZsjlAddReq req) {
        Integer id = redisFactory.getTableKey(TableName.DB_NAME, TableName.ER_PRE_ZSJL);
        req.setZsmsid(id);
        req.setPym(PinyinUtils.getSimplePinYin(req.getZsms()));
        req.setWbm(WubiUtils.getSimpleWuBi(req.getZsms()));
        erPreZsjlDao.insert(req);
    }
}
