package com.buit.commons.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.SkinDjmx;

/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface SkinDjmxDao extends EntityDao<SkinDjmx, Integer> {

	/**
	 * 删除登记明细表
	 * 
	 * @param skinDjmx
	 */
	void deleteByDjdh(SkinDjmx skinDjmx);

	/**
	 * 根据登记单号查询皮试明细
	 * 
	 * @param skinDjmx
	 * @return
	 */
	List<SkinDjmx> doQuerySkinDjmxByDjdh(SkinDjmx skinDjmx);

}
