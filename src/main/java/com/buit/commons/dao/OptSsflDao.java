package com.buit.commons.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OptSsfl;
import com.buit.commons.request.OptSsflReq;
import com.buit.commons.response.OptSsflResp;

/**
 * <br>
 * @author 老花生
 */
@Mapper
public interface OptSsflDao extends EntityDao<OptSsfl,Integer> {

    /**
     * 根据科室、医生、或者查询全院手术信息
     * @param req
     */
    List<OptSsflResp> queryByReq(OptSsflReq req);
}
