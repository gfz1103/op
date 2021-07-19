package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpSeq;

/**
 * 暂时用来解决发票虚拟自增序号<br>
 * 
 * @author WY
 */
@Mapper
public interface OpSeqDao extends EntityDao<OpSeq, String> {

	/**
	 * 根据当前日期查询当前序号
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getDqxh(Map<String, Object> map);

	/**
	 * 根据当前日期更新当前序号加1
	 * 
	 * @param map
	 */
	void updateDqxh(Map<String, Object> map);

}
