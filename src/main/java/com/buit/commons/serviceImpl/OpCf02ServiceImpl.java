package com.buit.commons.serviceImpl;

import com.buit.commons.dao.OpCf02Dao;
import com.buit.op.response.*;
import com.buit.op.service.OpCf02Service;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/10/10 16:50
 */
@DubboService(timeout = 10000)
public class OpCf02ServiceImpl implements OpCf02Service {
    @Autowired
    private OpCf02Dao opCf02Dao;


    @Override
    public Integer countByCfsbAndSmbzIsNull(Integer cfsb) {
        return opCf02Dao.countByCfsbAndSmbzIsNull(cfsb);
    }

    @Override
    public List<OpCf02> queryByCfsb(Integer cfsb) {
        return opCf02Dao.queryByCfsb(cfsb);
    }

    @Override
    public void batchInsert(List<OpCf02> cf02List) {
        opCf02Dao.batchInsert(cf02List);
    }

    @Override
    public List<OpCfToEmrResp> queryOpCfToEmr(String jzlsh) {
        return opCf02Dao.queryOpCfToEmr(jzlsh);
    }
}
