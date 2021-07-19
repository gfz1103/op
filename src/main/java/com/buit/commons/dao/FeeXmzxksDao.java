package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.FeeXmzxks;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <br>
 * @author 老花生
 */
@Mapper
public interface FeeXmzxksDao extends EntityDao<FeeXmzxks,Integer> {

    /**
     * 物资信息
     * @param parMap    查询参数
     * @param parMap
     * @return
     */
    List<Map<String, Object>> queryObj(Map<String, Object> parMap);

    /**
     * 查询物资信息
     * @param parameterswzxh    查询对象
     * @return
     */
    List<Map<String, Object>> findSuppliesInfo(Map<String, Object> parameterswzxh);
}
