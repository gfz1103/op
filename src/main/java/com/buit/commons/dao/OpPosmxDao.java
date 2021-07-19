package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.op.model.OpPosmx;

/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface OpPosmxDao extends EntityDao<OpPosmx, Integer> {

	/**
	 * 根据发票号码获取post交易号码
	 * 
	 * @param fphm
	 * @return
	 */
	Integer getPosTraceNumber(String fphm);

	/**
	 * 根据发票号码查询pos号码
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getPosNumbers(Map<String, Object> map);

	/**
	 * 更新发票号码
	 * 
	 * @param map
	 */
	void updateFphm(Map<String, Object> map);

	/**
	 * 获取交易号码 map版
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> getPm(Map<String, Object> map);

}
