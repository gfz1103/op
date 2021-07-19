package com.buit.commons.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.PubPelplehealthteach;
import com.buit.commons.request.PubPelplehealthteachPageReq;
import com.buit.commons.response.PubPelplehealthteachPageResp;

/**
 * 老年人健康教育<br>
 * @author 老花生
 */
@Mapper
public interface PubPelplehealthteachDao extends EntityDao<PubPelplehealthteach,String> {

    /**
     * 分页查询
     * @param req
     * @return
     */
    List<PubPelplehealthteachPageResp> queryPage(PubPelplehealthteachPageReq req);
}
