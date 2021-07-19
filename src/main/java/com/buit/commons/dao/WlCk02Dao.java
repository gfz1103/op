package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.WlCk02;

/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface WlCk02Dao extends EntityDao<WlCk02, Integer> {
	/**
	 * 查询
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getCkInfoOne(Map<String, Object> map);
	
	/**
	 * 查询
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getCkInfoTwo(Map<String, Object> map);
}
