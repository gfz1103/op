package com.buit.commons.serviceImpl;

import com.buit.commons.dao.OpFkxxDao;
import com.buit.op.response.IOpFkxxResp;
import com.buit.op.service.OpFkxxService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description
 * @Author yueyu
 * @Date 2021/4/12 10:37
 */
@DubboService
public class OpFkxxServiceImpl implements OpFkxxService {

    @Autowired
    OpFkxxDao opFkxxDao;

    @Override
    public List<IOpFkxxResp> queryByMzxh(Integer mzxh) {
        return opFkxxDao.queryByMzxh(mzxh);
    }
}
