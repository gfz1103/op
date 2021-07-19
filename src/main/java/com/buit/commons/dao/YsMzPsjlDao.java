package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.YsMzPsjl;

/**
 * 门诊_门诊皮试记录<br>
 * @author 老花生
 */
@Mapper
public interface YsMzPsjlDao extends EntityDao<YsMzPsjl,Integer> {

    /**
     * 根据病人编号、药品编号
     * @param param
     * @return
     */
    List<Map<String, Object>> queryByBrbhYpbh(Map<String, Object> param);
}
