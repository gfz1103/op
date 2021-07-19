package com.buit.commons.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.WlXhmx;

/**
 * 消耗明细(WL_XHMX)<br>
 * @author 老花生
 */
@Mapper
public interface WlXhmxDao extends EntityDao<WlXhmx,Integer> {
    
	/**
	 * 更新状态标志
	 * 
	 * @author wy
	 * @param map
	 */
	void updateZtbz(Map<String, Object> map);
}
