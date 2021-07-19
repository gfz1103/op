package com.buit.commons.dao;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.PubJmbr;

/**
 * 妇幼病人<br>
 * 
 * @author WY
 */
@Mapper
public interface PubJmbrDao extends EntityDao<PubJmbr, String> {

	/**
	 * 新增修改减免患者
	 * 
	 * @param pubJmbr
	 */
	void updateFybrInfo(PubJmbr pubJmbr);

	/**
	 * 判断是否为减免病人
	 * 
	 * @param cardno
	 * @param brxz
	 * @return
	 */
	Integer doQueryIsJmbr(String cardno, Integer brxz);

}
