package com.buit.commons.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.WlKfdz;

/**
 * <br>
 * @author 老花生
 */
@Mapper
public interface WlKfdzDao extends EntityDao<WlKfdz,Integer> {
    /**
     * 查询对象
     * @param map 查询信息
     * @return
     */
    Map<String, Object> findObjByMap(Map<String, Object> map);

    /**
     * 查询库房序号
     * @param parameterskfxh    查询对象
     * @return
     */
    Map<String, Object> findKfxh(Map<String, Object> parameterskfxh);
    
	/**
	 * 根据科室代码查询数量
	 * 
	 * @author wy
	 * @param map
	 * @return
	 */
	Integer getCountByKsdm(Map<String, Object> map);
    
}
