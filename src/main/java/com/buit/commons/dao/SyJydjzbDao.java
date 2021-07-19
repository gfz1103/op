package com.buit.commons.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.SyJydjUser;
import com.buit.commons.model.SyJydjzb;
import com.buit.commons.response.QueryAllDjCountResp;
import com.buit.commons.response.QueryDjCfListResp;
import com.buit.commons.response.QuerySyJydjzbResp;
import com.buit.commons.response.QuerySyptdyResp;
import com.buit.commons.response.QueryUnRegistResp;

import org.apache.ibatis.annotations.Param;

/**
 * 输液/注射接药登记主表<br>
 * 
 * @author WY
 */
@Mapper
public interface SyJydjzbDao extends EntityDao<SyJydjzb, String> {

	/**
	 * 输液接药分页查询
	 * 
	 * @param req
	 * @return
	 */
	List<QuerySyJydjzbResp> doQuerySyJydjList(SyJydjzb syJydjzb);

	List<QuerySyJydjzbResp> findByDjdhs(@Param("jgid") Integer jgid, @Param("djdhs")String djdhs);

	/**
	 * 查询病人已收费、已发药、未输液的输液处方
	 * 
	 * @param req
	 * @return
	 */
	List<QueryUnRegistResp> doQueryUnregistList(SyJydjzb syJydjzb);

	/**
	 * 查询输液登记用户信息
	 * 
	 * @param req
	 * @return
	 */
	List<SyJydjUser> doQuerySyDjUser(SyJydjzb syJydjzb);

	String queryBrzd(
			@Param("djdh") String djdh,
			@Param("kslb") String kslb,
			@Param("ksdm") Integer ksdm,
			@Param("jgid") Integer jgid);

	/**
	 * 开始输液
	 */
	void startShuYe(
			@Param("djdhs") String djdhs,
			@Param("jgid") Integer jgid,
			@Param("ksrdm") Integer ksrdm,
			@Param("kssj") Timestamp kssj);

	/**
	 * 批量更新输液状态
	 * 
	 * @param djdhs
	 * @param jgid
	 */
	void doUpdateSyZt(
			@Param("djdhs") String djdhs,
			@Param("jgid") Integer jgid,
			@Param("wcczrdm") Integer wcczrdm,
			@Param("wcsj") Timestamp wcsj);

	/**
	 * 根据输液日期统计每日人次
	 * 
	 * @param syJydjzb
	 * @return
	 */
	List<QueryAllDjCountResp> doQueryAllDjCount(SyJydjzb syJydjzb);

	/**
	 * 输液注射工作量统计每日输液数据
	 * 
	 * @param syJydjzb
	 * @return
	 */
	List<QueryDjCfListResp> doQueryDjCfList(SyJydjzb syJydjzb);

	/**
	 * 输液瓶贴打印人员信息
	 * 
	 * @param djdh
	 * @param kslb
	 * @param ksdm
	 * @param jgid
	 * @return
	 */
	QuerySyptdyResp doQuerySyptdy(String djdh, String kslb, Integer ksdm, Integer jgid);

}
