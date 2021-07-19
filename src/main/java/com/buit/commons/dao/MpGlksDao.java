package com.buit.commons.dao;

import com.buit.commons.EntityDao;

import com.buit.commons.model.MpGlks;
import com.buit.commons.model.OpGhks;
import com.buit.commons.request.MpGlksReq;
import com.buit.commons.response.MpGlksResp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 互联网科室HIS挂号科室关联表<br>
 * @author DESKTOP-1OEG1QM
 */
@Mapper
public interface MpGlksDao extends EntityDao<MpGlks,Integer>{

    List<MpGlksResp> getList(MpGlksReq mpGlksReq);

}
