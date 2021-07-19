package com.buit.commons.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpGhmxZjjsZsfp;

/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface OpGhmxZjjsZsfpDao extends EntityDao<OpGhmxZjjsZsfp, Integer> {

	/**
	 * 结账日期置空
	 * 
	 * @param parameters
	 */
	void doUpdateJzrqToNull(Map<String, Object> parameters);
}
