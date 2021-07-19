package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.PubJmlx;
import com.buit.commons.model.PubJmlxJm;
import org.apache.ibatis.annotations.Mapper;


/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface PubJmlxDao extends EntityDao<PubJmlx, Integer> {

	/**
	 * 新增修改妇幼单位
	 * 
	 * @param pubJmlx
	 */
	void updateFydwInfo(PubJmlx pubJmlx);

	/**
	 * 通过卡号查询是否减免
	 * 
	 * @param jzkh
	 * @return
	 */
	PubJmlxJm doQueryJmByFyzh(String jzkh);

}
