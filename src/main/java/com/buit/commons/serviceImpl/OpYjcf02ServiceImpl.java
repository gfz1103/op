package com.buit.commons.serviceImpl;

import com.buit.commons.dao.OpYjcf02Dao;
import com.buit.op.model.OpYjcf02;
import com.buit.op.service.OpYjcf02Service;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Description 医技明细接口实现
 * @Author 老花生
 * @Date 2020/10/13 10:28
 */
@DubboService(timeout = 10000)
public class OpYjcf02ServiceImpl implements OpYjcf02Service {
    @Autowired
    private OpYjcf02Dao opYjcf02Dao;

    @Override
    public OpYjcf02 getById(Integer id) {
        return opYjcf02Dao.getById(id);
    }

    @Override
    public List<OpYjcf02> doQueryBySBxhOrZtsbxh(Integer sbxh, Integer ztbz) {
        return opYjcf02Dao.doQueryBySBxhOrZtsbxh(sbxh, ztbz);
    }

    @Override
    public void updateZxztAndZxcs(Map<String, Object> paraMap) {
        opYjcf02Dao.updateZxztAndZxcs(paraMap);
    }

    @Override
    public void insert(OpYjcf02 yjcf02) {
        opYjcf02Dao.insert(yjcf02);
    }

    @Override
    public int queryByYlxhAndJzlsh(Integer jgid, Integer ylxh, String jzlsh) {
        return opYjcf02Dao.queryByYlxhAndJzlsh(jgid, ylxh, jzlsh);
    }

    @Override
    public Integer getMaxYjzh(String jzlsh, Integer jgid) {
        Integer maxYjzh = opYjcf02Dao.getMaxYjzh(jzlsh, jgid);
        if (maxYjzh == null){
            maxYjzh = 1;//组号从1开始
        }else {
            maxYjzh ++;
        }
        return maxYjzh;
    }

}
