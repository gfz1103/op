package com.buit.commons.serviceImpl;

import com.buit.commons.dao.OpYsJzlsDao;
import com.buit.op.model.OpYsJzls;
import com.buit.op.service.OpYsJzlsService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 就诊历史接口实现
 * @Author 老花生
 * @Date 2020/10/13 11:19
 */
@DubboService(timeout = 10000)
public class OpYsJzlsServiceImpl implements OpYsJzlsService {
    @Autowired
    private OpYsJzlsDao opYsJzlsDao;

    @Override
    public List<OpYsJzls> findByEntity(Object obj) {
        return opYsJzlsDao.findByEntity(obj);
    }
}
