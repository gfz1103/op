package com.buit.commons.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.SkinXmldsfxm;
import com.buit.commons.request.SkinXmldsfxmAddReq;
import com.buit.commons.response.SkinXmldsfxmResp;

/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface SkinXmldsfxmDao extends EntityDao<SkinXmldsfxm, Integer> {

	/**
	 * 根据皮试ID获取联动收费项目
	 * 
	 * @param skinXmldsfxm
	 * @return
	 */
	List<SkinXmldsfxmResp> doQueryLdsfxmList(SkinXmldsfxm skinXmldsfxm);

	/**
	 * 联动收费项目新增
	 * 
	 * @param list
	 */
	void doSaveLdsfxm(List<SkinXmldsfxmAddReq> list);

}
