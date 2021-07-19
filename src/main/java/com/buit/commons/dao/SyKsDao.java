package com.buit.commons.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.SyKs;
import com.buit.commons.request.SyKsAddReq;
import com.buit.commons.response.SyKsResp;

import org.apache.ibatis.annotations.Param;

/**
 * 输液/注射科室设置<br>
 * 
 * @author WY
 */
@Mapper
public interface SyKsDao extends EntityDao<SyKs, String> {

	/**
	 * 查询输液科室列表
	 * 
	 * @param jgid
	 * @return
	 */
	List<SyKsResp> doQuerySyksList(@Param("jgid") Integer jgid, @Param("ksdm") Integer ksdm,
			@Param("kslb") String kslb, @Param("zt") String zt);

	/**
	 * 输液科室启用停用
	 * 
	 * @param req
	 */
	void doUpdateZt(SyKsAddReq req);

	/**
	 * 获取一下顺序号
	 * 
	 * @param jgid
	 * @param ksdm
	 * @param xysxh
	 * @param kslb
	 */
	void doUpdateNextSxh(@Param("jgid") Integer jgid, @Param("ksdm") Integer ksdm, @Param("xysxh") String xysxh,
			@Param("kslb") String kslb);

	/**
	 * 更新输液/注射科室
	 * 
	 * @param req
	 */
	void doUpdateSyKs(SyKs req);

	/**
	 * 校验条码规则重复
	 * 
	 * @param jgid
	 * @param kslb
	 * @param sxhws
	 * @return
	 */
	Integer doValidDjdh(@Param("jgid") Integer jgid, @Param("tmscgz") String tmscgz, @Param("kslb") String kslb,
			@Param("sxhws") Integer sxhws, @Param("ksdm") Integer ksdm);

}
