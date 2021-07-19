package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpGhrb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 门诊_挂号日报<br>
 * 
 * @author WY
 */
@Mapper
public interface OpGhrbDao extends EntityDao<OpGhrb, String> {

	/**
	 * 条件删除
	 * 
	 * @param parameters
	 */
	void doDeleteByCondition(Map<String, Object> parameters);

	/**
	 * 查询上次汇总日期
	 * 
	 * @param jzrq
	 * @return
	 */
	Map<String, Object> doQueryMaxHzrq(Map<String, Object> jzrq);

	/**
	 * 查询最小结账日期
	 * 
	 * @param sfrqorghrq
	 * @return
	 */
	Map<String, Object> doQueryMinJzrq(Map<String, Object> sfrqorghrq);

	/**
	 * 根据结账日期查询工号
	 * 
	 * @param ghrbjzrqparameters
	 * @return
	 */
	List<Map<String, Object>> doQueryByJzrq(Map<String, Object> ghrbjzrqparameters);

	/**
	 * 更新汇总时间
	 * 
	 * @param parameters
	 */
	void doUpdateHzrq(Map<String, Object> parameters);

	/**
	 * 查询上一次汇总日期
	 * 
	 * @param hzrqMap
	 * @return
	 */
	Map<String, Object> doQueryByHzrq(Map<String, Object> hzrqMap);

	/**
	 * 查询汇总时间
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryHzrq(Map<String, Object> parameters);

	/**
	 * 挂号日报数据
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryBeforeValid(Map<String, Object> parameters);

	/**
	 * 汇总时间置空
	 * 
	 * @param parameters
	 */
	void updateHzrqToNull(Map<String, Object> parameters);

	/**
	 * 挂号日报总金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGHrbSumje(Map<String, Object> parameters);

	/**
	 * 挂号日报合计金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySumJe(Map<String, Object> parameters);

}
