package com.buit.commons.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpGhmxZk;

/**
 * 挂号明细_转科信息<br>
 * 
 * @author WY
 */
@Mapper
public interface OpGhmxZkDao extends EntityDao<OpGhmxZk, String> {
	/**
	 * 根据识别序号更改转科状态
	 * 
	 * @param map
	 */
	void updateSfxzk(Map<String, Object> map);

	/**
	 * 更新结账日期
	 * 
	 * @param map
	 */
	void doUpdateJzrq(Map<String, Object> map);

	/**
	 * 结账日期置空
	 * 
	 * @param parameters
	 */
	void doUpdateJzrqToNull(Map<String, Object> parameters);

}
