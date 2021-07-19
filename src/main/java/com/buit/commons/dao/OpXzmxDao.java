package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpXzmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;


/**
 * 门诊_日报性质明细<br>
 * 
 * @author WY
 */
@Mapper
public interface OpXzmxDao extends EntityDao<OpXzmx, String> {

	/**
	 * 条件删除
	 * 
	 * @param parameters
	 */
	void doDeleteByCondition(Map<String, Object> parameters);

}
