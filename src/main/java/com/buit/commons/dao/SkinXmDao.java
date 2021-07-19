package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.SkinXm;
import com.buit.commons.response.SkinXmHzResp;
import com.buit.commons.response.SkinXmResp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <br>
 *
 * @author WY
 */
@Mapper
public interface SkinXmDao extends EntityDao<SkinXm, Integer> {

	/**
	 * 皮试列表查询
	 *
	 * @param skinXm
	 * @return
	 */
	List<SkinXmResp> doQuerySkinTestList(SkinXm skinXm);

	/**
	 * 查询项目名称是否存在
	 *
	 * @param psmc
	 * @param psid
	 * @return
	 */
	Integer isExistPsmc(@Param("jgid") Integer jgid, @Param("psmc") String psmc, @Param("psid") Integer psid);

	/**
	 * 皮试项目修改
	 *
	 * @param skinXm
	 */
	void updatePsxm(SkinXm skinXm);

	/**
	 * 皮试项目删除
	 *
	 * @param skinXm
	 */
	void doDeleteSkinTest(SkinXm skinXm);

	/**
	 * 门诊处方皮试药品带出皮试项目
	 *
	 * @param skinXm
	 * @return
	 */
	List<SkinXmHzResp> doQueryPsxmHz(SkinXm skinXm);

	List<SkinXmHzResp> getpsxmByDrugs(List<Integer> drugs);
}
