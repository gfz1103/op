package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpSbbh;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 设备编号表<br>
 * @author GONGFANGZHOU
 */
@Mapper
public interface OpSbbhDao extends EntityDao<OpSbbh,Integer>{

    /**
     * 查询检查类型
     * @return
     */
    List<Map<String, Object>> getJklx();
}
