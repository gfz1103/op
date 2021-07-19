package com.buit.commons.serviceImpl;

import com.buit.commons.dao.OpYjcf02ZtDao;
import com.buit.op.model.OpYjcf02Zt;
import com.buit.op.service.OpYjcf02ZtService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/10/13 16:14
 */
@DubboService(timeout = 10000)
public class OpYjcf02ZtServiceImpl implements OpYjcf02ZtService {
    @Autowired
    private OpYjcf02ZtDao opYjcf02ZtDao;
    @Override
    public Map<String, Object> getZtBySbxh(Map<String, Object> parm) {
        return opYjcf02ZtDao.getZtBySbxh(parm);
    }


    @Override
    public void insert(OpYjcf02Zt opYjcf02Zt) {
        opYjcf02ZtDao.insert(opYjcf02Zt);
    }

    @Override
    public void updateYjxh(List<Integer> ids, int yjxh) {
        opYjcf02ZtDao.updateYjxh(ids, yjxh);
    }
}
