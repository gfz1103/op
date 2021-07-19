package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpZffp;
import com.buit.commons.response.QueryVoidInvoiceResp;

import org.apache.ibatis.annotations.Param;

@Mapper
public interface OpZffpDao extends EntityDao<OpZffp, Integer> {

	/**
	 * 获取作废发票列表
	 * 
	 * @param jgid
	 * @param ygdm
	 * @return
	 */
	List<QueryVoidInvoiceResp> doQueryVoidInvoice(@Param("jgid") Integer jgid, @Param("ygdm") Integer ygdm);

	/**
	 * 
	 * @param parameters
	 * @return
	 */
	Integer doQueryZffpCount(Map<String, Object> parameters);

	/**
	 * 更新结账日期
	 * 
	 * @param parameters
	 */
	void doUpdateJzrq(Map<String, Object> parameters);

	/**
	 * 查询作废发票信息
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryZffp(Map<String, Object> parameters);

	/**
	 * 结账日期置空
	 * 
	 * @param parameters
	 */
	void doUpdateJzrqToNull(Map<String, Object> parameters);

	/**
	 * 更新作废发票汇总日期
	 * 
	 * @param parameters
	 */
	void doUpdateHzrq(Map<String, Object> parameters);

	/**
	 * 汇总时间置空
	 * 
	 * @param parameters
	 */
	void updateHzrqToNull(Map<String, Object> parameters);

}
