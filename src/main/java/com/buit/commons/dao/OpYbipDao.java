package com.buit.commons.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpYbip;

/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface OpYbipDao extends EntityDao<OpYbip, Integer> {

	/**
	 * 获取IP
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> getIp(Map<String, Object> map);

	/**
	 * 根据识别序号更新IP
	 * 
	 * @param map
	 */
	void updateIpBySbxh(Map<String, Object> map);

}
