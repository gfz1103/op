package com.buit.commons.dao;

import com.buit.cis.op.dctwork.response.BqzmPrintResponse;
import com.buit.cis.op.dctwork.response.JbzmPrintResponse;
import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpBqzm;
import org.apache.ibatis.annotations.Param;

/**
 * 病区证明<br>
 * @author 老花生
 */
@Mapper
public interface OpBqzmDao extends EntityDao<OpBqzm,Integer>{
    /**
     * 查询病情证明打印数据
     * @param bqid
     * @return
     */
    BqzmPrintResponse getBqzmPrintData(@Param("bqid") Integer bqid);

    /**
     * 查询疾病证明打印数据
     * @param bqid
     * @return
     */
    JbzmPrintResponse getJbzmPrintData(@Param("bqid") Integer bqid);
}
