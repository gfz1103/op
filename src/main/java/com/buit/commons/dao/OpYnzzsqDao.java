package com.buit.commons.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpYnzzsq;

/**
 * 院内转诊申请<br>
 * @author 老花生
 */
@Mapper
public interface OpYnzzsqDao extends EntityDao<OpYnzzsq,Integer> {

    /**
     * 更新转诊科室、目前诊断、转诊目的
     * @param parameters
     */
    void updateZzksSqzdZzmd(Map<String, Object> parameters);
}
