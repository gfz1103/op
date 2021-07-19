package com.buit.cis.op.dctwork.service;

import cn.hutool.core.bean.BeanUtil;
import com.buit.cis.op.dctwork.request.OpJbzmQueryReq;
import com.buit.cis.op.dctwork.request.Opjbzmreq;
import com.buit.cis.op.dctwork.response.JbzmPrintResponse;
import com.buit.cis.op.dctwork.response.OpJbzmQueryResponse;
import com.buit.commons.SysUser;
import com.buit.commons.dao.OpBqzmDao;
import com.buit.commons.enums.StatusEnum;
import com.buit.commons.model.OpBqzm;
import com.buit.constans.TableName;
import com.buit.utill.RedisFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @Author weijing
 * @Date 2021-03-26 15:34
 * @Description
 **/
@Service
public class CisJbzmService {
    static final Logger logger = LoggerFactory.getLogger(OpBqzmSer.class);

    @Autowired
    private OpBqzmDao opBqzmDao;

    @Autowired
    private RedisFactory redisFactory;

    /**
     * 查询疾病证明单
     * @param req
     */
    public PageInfo<OpJbzmQueryResponse> queryJbzm(OpJbzmQueryReq req, SysUser user){
        req.setDjlx(StatusEnum.Djlx.JBZMD.getCode());//疾病证明单
        OpBqzm bqzm = com.buit.utill.BeanUtil.toBean(req, OpBqzm.class);
        bqzm.setJzys(user.getUserId());
        bqzm.setSortColumns("BQID");
        PageInfo<OpJbzmQueryResponse> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> opBqzmDao.findByEntity(bqzm)
        );
        return pageInfo;
    }

    /**
     * 查询病情证明单打印数据
     * @param bqid
     * @return
     */
    public JbzmPrintResponse getJbzmPrintData(Integer bqid){
        if (bqid == null){
            return null;
        }
        return opBqzmDao.getJbzmPrintData(bqid);
    }

    /**
     * 新增/修改病情证明
     * @param opjbzmreq
     * @param user
     */
    public void addOrUpdateOpJbzm(Opjbzmreq opjbzmreq, SysUser user){
        opjbzmreq.setDjlx(StatusEnum.Djlx.JBZMD.getCode());
        opjbzmreq.setJzys(user.getUserId());

        if (opjbzmreq.getBqid() == null){
            //新增
            opjbzmreq.setBqid(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_BQZM));
            opjbzmreq.setKjzmsj(new Timestamp(System.currentTimeMillis()));
            opBqzmDao.insert(BeanUtil.toBean(opjbzmreq, OpBqzm.class));
        }else {
            //修改
            opBqzmDao.update(BeanUtil.toBean(opjbzmreq, OpBqzm.class));
        }
    }
}
