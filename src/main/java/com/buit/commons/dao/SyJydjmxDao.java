package com.buit.commons.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.SyJydjmx;
import com.buit.commons.response.QueryUnRegistResp;

/**
 * 输液/注射接药登记明细表<br>
 * 
 * @author WY
 */
@Mapper
public interface SyJydjmxDao extends EntityDao<SyJydjmx, Integer> {

	/**
	 * 获取每日最大输液序号
	 * 
	 * @param syJydjmx
	 */
	Integer getMaxSyxh(SyJydjmx syJydjmx);

	/**
	 * 查询相同组号相同药品是否在输液中
	 * 
	 * @param syJydjmx
	 * @return
	 */
	Integer doExistSyProcessing(SyJydjmx syJydjmx);

	/**
	 * 查询病人的输液处方
	 * 
	 * @param djdh
	 * @param jgid
	 * @return
	 */
	List<QueryUnRegistResp> doQueryRegistList(String djdh, Integer ksdm, Integer jgid);

}
