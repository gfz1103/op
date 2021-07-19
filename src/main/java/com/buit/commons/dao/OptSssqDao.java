package com.buit.commons.dao;

import java.util.List;

import com.buit.commons.model.OptSssq;
import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.request.OptSssqPageReq;
import com.buit.commons.response.OptSssqPageResp;

/**
 * 手术申请<br>
 * @author 老花生
 */
@Mapper
public interface OptSssqDao extends EntityDao<OptSssq,Integer>{

    /**
     * 根据条件查询（门诊）
     * @param req
     * @return
     */
    List<OptSssqPageResp> findByEntityMz(OptSssqPageReq req);

    /**
     * 根据条件查询（住院）
     * @param req
     * @return
     */
    List<OptSssqPageResp> findByEntityZy(OptSssqPageReq req);

    /**
     * 根据条件查询（全部门诊）
     * @param req
     * @return
     */
    List<OptSssqPageResp> findByEntityAllMz(OptSssqPageReq req);

    /**
     * 根据条件查询（全部住院）
     * @param req
     * @return
     */
    List<OptSssqPageResp> findByEntityAllZy(OptSssqPageReq req);
}
