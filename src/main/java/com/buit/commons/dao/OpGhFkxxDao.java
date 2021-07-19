package com.buit.commons.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpGhFkxx;

/**
 * 门诊挂号付款信息<br>
 * 
 * @author WY
 */
@Mapper
public interface OpGhFkxxDao extends EntityDao<OpGhFkxx, Integer> {

	/**
	 * 通过识别序号查询挂号付款信息
	 * 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> doQueryBySbxh(Map<String, Object> param);

	/**
	 * 删除挂号付款信息
	 * 
	 * @param ssbxh
	 */
	void deleteBySbxh(String ssbxh);

	/**
	 * 当日现金金额求和
	 * 
	 * @param parameters
	 * @return
	 */
	BigDecimal doSumFkjeByFkfs(Map<String, Object> parameters);

}
