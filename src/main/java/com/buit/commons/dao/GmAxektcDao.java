package com.buit.commons.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.GmAxektc;

/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface GmAxektcDao extends EntityDao<GmAxektc, String> {

	/**
	 * 获得爱心卡类型
	 * 
	 * @author wy
	 * @param map
	 * @return
	 */
	Map<String, Object> getAxklx(Map<String, Object> map);

}
