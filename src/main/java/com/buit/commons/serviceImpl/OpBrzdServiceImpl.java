package com.buit.commons.serviceImpl;

import com.buit.commons.dao.OpBrzdDao;
import com.buit.op.response.BrzdDto;
import com.buit.op.response.BrzdResp;
import com.buit.op.response.EmrBrzdResp;
import com.buit.op.service.OpBrzdService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Description 病人诊断接口实现
 * @Author 老花生
 * @Date 2020/10/10 15:23
 */
@DubboService(timeout = 10000)
public class OpBrzdServiceImpl implements OpBrzdService {
    @Autowired
    private OpBrzdDao opBrzdDao;

    @Override
    public List<BrzdDto> queryBrzdDtoByJzxh(Integer jzxh) {
        return opBrzdDao.queryBrzdDtoByJzxh(jzxh);
    }

    @Override
    public List<String> queryBrzdByJzxh(String jzxh) {
        return opBrzdDao.queryBrzdByJzxh(jzxh);
    }

    @Override
    public List<Map<String, Object>> getZd(Map<String, Object> parmjzxh) {
        return opBrzdDao.getZd(parmjzxh);
    }

    @Override
    public List<EmrBrzdResp> getZdmcByJzlsh(String jzlsh) {
        return opBrzdDao.getZdmcByJzlsh(jzlsh);
    }

    /**
     * 通过就诊流水号查询病人诊断
     * @param jzlsh
     * @return
     */
    @Override
    public List<BrzdResp> getBrzdByJzlsh(String jzlsh) {
        return opBrzdDao.getBrzdByJzlsh(jzlsh);
    }
}
