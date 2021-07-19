package com.buit.commons.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.DiyGhmxZzgh;

/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface DiyGhmxZzghDao extends EntityDao<DiyGhmxZzgh, Integer> {
	/**
	 * 更新挂号信息
	 * 
	 * @param map
	 */
	void updateGhmxZzghInfo(Map<String, Object> map);
}
