package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import com.buit.op.response.IOpFkxxResp;
import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpFkxx;
import org.apache.ibatis.annotations.Param;

/**
 * 门诊_门诊收费付款信息<br>
 * 
 * @author WY
 */
@Mapper
public interface OpFkxxDao extends EntityDao<OpFkxx, Integer> {
	/**
	 * 查询付款信息
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getFkxxByCondition(Map<String, Object> map);

	/**
	 * 查询付款信息
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getFkxxInfo(Map<String, Object> map);

	/**
	 * 查询付款金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkje(Map<String, Object> parameters);

	/**
	 * 付款金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkjeA(Map<String, Object> parameters);

	/**
	 * 根据就诊日期查询付款金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkjeByJzrq(Map<String, Object> parameters);

	/**
	 * 根据汇总日期查询付款金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkxxByHzrq(Map<String, Object> parameters);

	/**
	 * 查询付款金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkxxFkjeByHzrq(Map<String, Object> parameters);

	/**
	 * 查询付款信息
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkxx(Map<String, Object> parameters);

	/**
	 * 查询付款信息
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryHzcxFkxx(Map<String, Object> parameters);

	/**
	 * 收费汇总 付款信息
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryHzcxFkxxA(Map<String, Object> parameters);

	/**
	 * 付款信息
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryXmflhzFkxx(Map<String, Object> parameters);

	/**
	 * 根据门诊序号查询付款详情
	 * */
    List<IOpFkxxResp> queryByMzxh(@Param("mzxh") Integer mzxh);
}
