package com.buit.commons.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.SyGytj;
import com.buit.commons.request.SyGytjReq;
import com.buit.commons.response.SyGytjResp;

/**
 * 输液/注射给药途径设置<br>
 * 
 * @author WY
 */
@Mapper
public interface SyGytjDao extends EntityDao<SyGytj, Integer> {
	/**
	 * 查询给药途径列表
	 * 
	 * @param req
	 * @return
	 */
	List<SyGytjResp> doQueryGytjList(SyGytjReq req);

	/**
	 * 输液注射给药途径删除
	 * 
	 * @param syGytj
	 */
	void doDeleteGytj(SyGytj syGytj);
}
