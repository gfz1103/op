package com.buit.commons.serviceImpl;

import com.buit.commons.dao.OpZt01Dao;
import com.buit.commons.response.OpZt01AccountingSrfResp;
import com.buit.op.request.IOpZt01AccountingSrfReq;
import com.buit.op.response.IOpZt01AccountingSrfResp;
import com.buit.op.service.OpZt01Service;
import com.buit.utill.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/10/15 14:26
 */
@DubboService(timeout = 10000)
public class OpZt01ServiceImpl implements OpZt01Service {
    @Autowired
    private OpZt01Dao opZt01Dao;

    @Override
    public PageInfo<IOpZt01AccountingSrfResp> queryProjectStackAccounting(IOpZt01AccountingSrfReq req) {
        PageInfo<OpZt01AccountingSrfResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> opZt01Dao.queryProjectStackAccounting(req)
        );
        return BeanUtil.toPage(pageInfo, IOpZt01AccountingSrfResp.class);
    }
}
