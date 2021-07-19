package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpSfrbFkmx;

/**
 * 门诊_门诊收费日报付款明细<br>
 * 
 * @author WY
 */
@Mapper
public interface OpSfrbFkmxDao extends EntityDao<OpSfrbFkmx, String> {

	/**
	 * 条件删除
	 * 
	 * @param parameters
	 */
	void doDeleteByCondition(Map<String, Object> parameters);

	/**
	 * 已结帐未汇总收费付款数据
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryBeforeValid(Map<String, Object> parameters);

}
