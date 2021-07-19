package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpGhyj;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;


/**
 * 门诊_挂号预检<br>
 * 
 * @author WY
 */
@Mapper
public interface OpGhyjDao extends EntityDao<OpGhyj, Integer> {

	/**
	 * 更新挂号标志
	 * 
	 * @param map
	 */
	void updateMsGhbz(Map<String, Object> map);

}
