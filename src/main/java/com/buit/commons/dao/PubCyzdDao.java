package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.PubCyzd;
import com.buit.commons.request.PubCyzdReq;
import com.buit.commons.response.PubCyzdResp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 公用_个人常用诊断表<br>
 * @author 老花生
 */
@Mapper
public interface PubCyzdDao extends EntityDao<PubCyzd,Integer> {

    /**
     * 查询个人常用诊断
     * @param pubcyzd    请求对象
     * @return
     */
    List<PubCyzdResp> query(PubCyzdReq pubcyzd);

    /**
     * 根据用户ID删除保存诊断
     * @param userId
     */
    void removeByUserId(Integer userId);
}
