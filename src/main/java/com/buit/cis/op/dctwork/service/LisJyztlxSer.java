package com.buit.cis.op.dctwork.service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.LisJyztlxDao;
import com.buit.commons.dao.OpZt01Dao;
import com.buit.commons.model.LisJyztlx;
import com.buit.commons.model.OpZt01;
import com.buit.commons.request.LisJyztlxReq;
import com.buit.constans.TableName;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 组套类型维护<br>
 * @author 老花生
 */
@Service
public class LisJyztlxSer extends BaseManagerImp<LisJyztlx,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(LisJyztlxSer.class);
    
    @Autowired
    private LisJyztlxDao lisJyztlxDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private OpZt01Dao opZt01Dao;
    
    @Override
    public LisJyztlxDao getEntityMapper(){        
        return lisJyztlxDao;
    }

    /**
     * 新增
     * @param req
     */
    public void add(LisJyztlxReq req) {
        LisJyztlx lisJyztlx = BeanUtil.toBean(req, LisJyztlx.class);
//        lisJyztlx.setId(redisFactory.getTableKey(TableName.DB_NAME, TableName.LIS_JYZTLX));
        lisJyztlx.setZxbz("0");
        lisJyztlxDao.insert(lisJyztlx);
    }

    /**
     * 注销
     * @param id
     */
    public void saveLogoutZtlx(Integer id) {
        OpZt01 opZt01 = new OpZt01();
        opZt01.setZtlx(id);
        List<OpZt01> zt01List = opZt01Dao.findByEntity(opZt01);
        if(!zt01List.isEmpty()){
            throw BaseException.create("ERROR_DCTWORK_OP_0016");
        }
        LisJyztlx ztlx = lisJyztlxDao.getById(id);
        ztlx.setZxbz("1");
        lisJyztlxDao.update(ztlx);
    }
}
