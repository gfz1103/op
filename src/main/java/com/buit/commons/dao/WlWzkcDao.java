package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.WlWzkc;

/**
 * 物资库存(WL_WZKC)<br>
 * @author 老花生
 */
@Mapper
public interface WlWzkcDao extends EntityDao<WlWzkc,Integer> {

    /**
     * 更新预扣数量
     * @param wlWzkcUpdate
     */
    void updateYjsl(WlWzkc wlWzkcUpdate);

    /**
     * 统计物资数量、预扣数量统计
     * @param map
     * @return
     */
    List<Map<String, Object>> querySumNum(Map<String, Object> map);

    /**
     * 查询物资金额
     * @param parameterswzjg
     * @return
     */
    List<Map<String, Object>> findSuppliesAmount(Map<String, Object> parameterswzjg);

    /**
     * 更新预扣数量
     * @param parametersykslupd
     */
    void updateyksl(Map<String, Object> parametersykslupd);
}
