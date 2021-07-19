package com.buit.commons.serviceImpl;

import cn.hutool.core.collection.CollUtil;
import com.buit.commons.dao.OpZydjDao;
import com.buit.commons.model.OpZydj;
import com.buit.op.request.OpZydjQueryCardnoPageReq;
import com.buit.op.request.OpZydjUpdateStatusReq;
import com.buit.op.response.OpZydjResp;
import com.buit.op.service.OpZydjService;
import com.buit.utill.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/10/30 16:09
 */
@DubboService(timeout = 10000)
public class OpZydjServiceImpl implements OpZydjService {
    @Autowired
    private OpZydjDao opZydjDao;

    @Override
    public void updateSqzt(OpZydjUpdateStatusReq opZydj) {
        opZydjDao.updateSqzt(opZydj);
    }

    @Override
    public PageInfo<OpZydjResp> findMzzydj(OpZydjQueryCardnoPageReq req) {
        PageInfo<OpZydjResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                    () -> opZydjDao.findMzzydj(req.getCardno(),req.getSqlx())
            );
        return pageInfo;
    }

    @Override
    public OpZydjResp getById(Integer djid) {
        OpZydj obj = opZydjDao.getById(djid);
        return BeanUtil.toBean(obj, OpZydjResp.class);
    }

    @Override
    public OpZydjResp getByJzkhAndSqlx(String jzkh, String sqlx) {
        List<OpZydjResp> opZydjRespList = opZydjDao.findByJzkhAndSqlx(jzkh, sqlx);
        if(CollUtil.isNotEmpty(opZydjRespList)){
            return opZydjRespList.get(0);
        }
        return null;
    }
}
