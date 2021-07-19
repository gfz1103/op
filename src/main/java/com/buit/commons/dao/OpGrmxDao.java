package com.buit.commons.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpGrmx;

/**
 * 门诊_挂号日报明细<br>
 * 
 * @author WY
 */
@Mapper
public interface OpGrmxDao extends EntityDao<OpGrmx, String> {

	/**
	 * 条件删除
	 * 
	 * @param parameters
	 */
	void doDeleteByCondition(Map<String, Object> parameters);

}
