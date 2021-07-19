package com.buit.commons.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.SkinDjzb;
import com.buit.commons.model.SyJydjUser;
import com.buit.commons.request.SavePsCfRegistReq;
import com.buit.commons.response.PsDjResp;
import com.buit.commons.response.QueryAllPsDjCountResp;
import com.buit.commons.response.QueryPsAllergyResp;
import com.buit.commons.response.QueryPsDjListResp;
import com.buit.commons.response.QueryUnPsdjmxResp;
import com.buit.commons.response.QueryUnPsxmResp;
import com.buit.commons.response.QueryUnRegistResp;

import org.apache.ibatis.annotations.Param;

/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface SkinDjzbDao extends EntityDao<SkinDjzb, Integer> {
	/**
	 * 查询输液登记用户信息
	 * 
	 * @param req
	 * @return
	 */
	List<SyJydjUser> doQuerySyDjUser(SkinDjzb skinDjzb);

	/**
	 * 查询病人已收费、未执行的皮试项目
	 * 
	 * @param skinDjzb
	 * @return
	 */
	List<QueryUnPsxmResp> doQueryUnPsxmList(SkinDjzb skinDjzb);

	/**
	 * 获取每日最大皮试序号加1
	 * 
	 * @param skinDjzb
	 * @return
	 */
	Integer getMaxPsxhByDay(SkinDjzb skinDjzb);

	/**
	 * 根据皮试id获取对应药品
	 * 
	 * @param psCfRegist
	 * @return
	 */
	List<QueryUnPsdjmxResp> doQueryUnPsdjmxList(SavePsCfRegistReq psCfRegist);

	/**
	 * 皮试列表分页查询
	 * 
	 * @param skinDjzb
	 * @return
	 */
	List<PsDjResp> doQueryPsDjList(SkinDjzb skinDjzb);

	/**
	 * 修改皮试状态
	 * 
	 * @param skinDjzb
	 */
	void updateZt(SkinDjzb skinDjzb);

	/**
	 * 删除登记主表
	 * 
	 * @param skinDjzb
	 */
	void deleteByDjdh(SkinDjzb skinDjzb);

	/**
	 * 根据登记单号查询皮试信息
	 * 
	 * @param djdh
	 * @return
	 */
	SkinDjzb doQueryPsDjByDjdh(@Param("jgid") Integer jgid, @Param("ksdm") Integer ksdm,
			@Param("djdh") String djdh);

	/**
	 * 根据登记单号查询登记明细
	 * 
	 * @param skinDjzb
	 * @return
	 */
	List<QueryUnRegistResp> doQueryPsdjmxList(SkinDjzb skinDjzb);

	/**
	 * 皮试工作量统计人次
	 * 
	 * @param skinDjzb
	 * @return
	 */
	List<QueryAllPsDjCountResp> doQueryAllDjCount(SkinDjzb skinDjzb);

	/**
	 * 皮试工作量统计每日输液数据
	 * 
	 * @param skinDjzb
	 * @return
	 */
	List<QueryPsDjListResp> doQueryDjList(SkinDjzb skinDjzb);

	/**
	 * 皮试阳性率统计
	 * 
	 * @param skinDjzb
	 * @return
	 */
	List<QueryPsAllergyResp> doQueryPsAllergy(SkinDjzb skinDjzb);

}
