package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpHzrb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 门诊_门诊收费日报<br>
 * 
 * @author WY
 */
@Mapper
public interface OpHzrbDao extends EntityDao<OpHzrb, String> {

	/**
	 * 查询结账日期和操作工号
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryJzrqAndCzgh(Map<String, Object> parameters);

	/**
	 * 查询结账日期
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryJzrq(Map<String, Object> parameters);

	/**
	 * 获取最大结账日期
	 * 
	 * @param jzmaxparameters
	 * @return
	 */
	List<Map<String, Object>> doQueryMaxJzrq(Map<String, Object> jzmaxparameters);

	/**
	 * 条件删除
	 * 
	 * @param parameters
	 */
	void doDeleteByCondition(Map<String, Object> parameters);

	/**
	 * 查询操作工号
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryHzrbCzgh(Map<String, Object> parameters);

	/**
	 * 挂号日报信息
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryHzrbInfo(Map<String, Object> parameters);

	/**
	 * 根据结账日期查询操作工号
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryHzrbCzghByJzrq(Map<String, Object> parameters);

	/**
	 * 查询金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryHzrbJe(Map<String, Object> parameters);

	/**
	 * 查询上次汇总时间
	 * 
	 * @param jzrq
	 * @return
	 */
	Map<String, Object> doQueryMaxHzrq(Map<String, Object> jzrq);

	/**
	 * 获取最小结账日期
	 * 
	 * @param sfrqorghrq
	 * @return
	 */
	Map<String, Object> doQueryMinJzrq(Map<String, Object> sfrqorghrq);

	/**
	 * 根据结账日期查询工号
	 * 
	 * @param hzrbjzrqparameters
	 * @return
	 */
	List<Map<String, Object>> doQueryCzghByJzrq(Map<String, Object> hzrbjzrqparameters);

	/**
	 * 根据汇总日期查询工号
	 * 
	 * @param hzrbhzrqparameters
	 * @return
	 */
	List<Map<String, Object>> doQueryCzghByHzrq(Map<String, Object> hzrbhzrqparameters);

	/**
	 * 更新汇总时间
	 * 
	 * @param parameters
	 */
	void doUpdateHzrq(Map<String, Object> parameters);

	/**
	 * 查询汇总金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryHzje(Map<String, Object> parameters);

	/**
	 * 查询上次汇总日期
	 * 
	 * @param hzrqMap
	 * @return
	 */
	Map<String, Object> doQueryByHzrq(Map<String, Object> hzrqMap);

	/**
	 * 查询汇总日期
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryHzrq(Map<String, Object> parameters);

	/**
	 * 查询最大汇总时间
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryAllMaxHzrq(Map<String, Object> parameters);

	/**
	 * 收费日报数据
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
	 * 汇总查询
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryHzcx(Map<String, Object> parameters);

	/**
	 * 汇总日报合计金额
	 * 
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQueryHzSumje(Map<String, Object> parameters);

}
