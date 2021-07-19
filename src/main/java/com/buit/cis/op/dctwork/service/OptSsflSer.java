package com.buit.cis.op.dctwork.service;


import cn.hutool.core.bean.BeanUtil;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OptSsflDao;
import com.buit.commons.model.OptSsfl;
import com.buit.commons.request.OptSsflAddReq;
import com.buit.constans.TableName;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <br>
 * @author 老花生
 */
@Service
public class OptSsflSer extends BaseManagerImp<OptSsfl,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OptSsflSer.class);
    
    @Autowired
    private OptSsflDao optSsflDao;
    @Autowired
    private RedisFactory redisFactory;
    
    @Override
    public OptSsflDao getEntityMapper(){        
        return optSsflDao;
    }

    /**
     * 新增手术
     * @param req
     */
    public void add(OptSsflAddReq req) {
        OptSsfl optssfl = BeanUtil.toBean(req, OptSsfl.class);
        List<OptSsfl> ret = optSsflDao.findByEntity(optssfl);
        if(!ret.isEmpty()){
            throw BaseException.create("ERROR_DCTWORK_OP_0001");
        }
        optssfl.setId(redisFactory.getTableKey(TableName.DB_NAME, TableName.OPT_SSFL));
        optSsflDao.insert(optssfl);
    }
}
