package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpGhrbFkmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 门诊_挂号日报付款明细<br>
 * 
 * @author WY
 */
@Mapper
public interface OpGhrbFkmxDao extends EntityDao<OpGhrbFkmx, String> {

	/**
	 * 条件删除
	 * 
	 * @param parameters
	 */
	void doDeleteByCondition(Map<String, Object> parameters);

	/**
	 * 已结帐未汇总挂号付款数据
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryBeforeValid(Map<String, Object> parameters);

}
