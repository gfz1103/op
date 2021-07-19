package com.buit.commons.dao;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.SyCfzxqk;

/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface SyCfzxqkDao extends EntityDao<SyCfzxqk, Integer> {
	/**
	 * 更新输液次数
	 * 
	 * @param syCfzxqk
	 */
	void updateZxcs(SyCfzxqk syCfzxqk);

	/**
	 * 根据条件查询处方是否登记过
	 * 
	 * @param jgid
	 * @param cfhm
	 * @param cfzh
	 * @return
	 */
	Integer getZxqkCountByCondition(Integer jgid, Integer cfhm, Integer cfzh);

}
