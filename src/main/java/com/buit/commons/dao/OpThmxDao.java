package com.buit.commons.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpThmx;

/**
 * 门诊_退号明细<br>
 * 
 * @author WY
 */
@Mapper
public interface OpThmxDao extends EntityDao<OpThmx, Integer> {

	/**
	 * 退号明细数量
	 * 
	 * @param parameters
	 * @return
	 */
	Integer doQueryThmxCount(Map<String, Object> parameters);

	/**
	 * 更新结账日期
	 * 
	 * @param parameters
	 */
	void doUpdateJzrq(Map<String, Object> parameters);

	/**
	 * 结账日期置空
	 * 
	 * @param parameters
	 */
	void doUpdateJzrqToNull(Map<String, Object> parameters);

	/**
	 * 更新汇总时间
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
