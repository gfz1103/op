package com.buit.commons.dao;

import com.buit.cis.op.dctwork.response.FeeYlsfxmdjMechanismResp;
import com.buit.cis.op.dctwork.response.SrfsfJyResp;
import com.buit.commons.EntityDao;
import com.buit.commons.model.FeeYlsfxmdj;
import com.buit.system.request.QueryFeeYlsfxmdjReq;
import com.buit.system.response.QueryJsJcResp;
import com.buit.system.response.SrfFeeYlsfxmdjResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 公用_医院医疗明细项目<br>
 *
 * @author 老花生
 */
@Mapper
public interface FeeYlsfxmdjDao extends EntityDao<FeeYlsfxmdj, String> {

	/**
	 * 查询医疗明细信息
	 *
	 * @param feeYlsfxmdj
	 * @return
	 */
	List<FeeYlsfxmdj> getYlmxInfo(FeeYlsfxmdj feeYlsfxmdj);

	/**
	 * 查询费用单价
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getFydj(Map<String, Object> map);

	/**
     * 检验 输入法查询
     */
    List<SrfFeeYlsfxmdjResp> querySrfJy(QueryFeeYlsfxmdjReq req);
    /**
     * 门诊收费 检验 输入法查询
     */
    List<SrfsfJyResp> querySrfsfJy(Map<String, Object> par);

	/**
	 * 查询
	 *
	 * @param map
	 * @return
	 */
	Map<String, Object> getJgbz(Map<String, Object> map);

	/**
	 * 检验 输入法查询 -挂号收费专用
	 *
	 * @param par
	 * @return
	 */
	List<QueryJsJcResp> doQueryJsjc(Map<String, Object> par);

	/**
	 * 查询机构收费项目明细列表
	 * @Title: queryInstitutionalFeeCollection
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param parameters
	 * @param @return    设定文件
	 * @return List<FeeYlsfxmdjMechanismResp>    返回类型
	 * @author 龚方舟
	 * @throws
	 */
	List<FeeYlsfxmdjMechanismResp> queryInstitutionalFeeCollection(Map<String, Object> parameters);

	/**
	 * 作废或取消作废收费项目明细
	 * @Title: logoutProject
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param zfpb
	 * @param @param fyxh
	 * @param @param jgid    设定文件
	 * @return void    返回类型
	 * @author 龚方舟
	 * @throws
	 */
    void logoutProject(@Param("zfpb") Integer zfpb, @Param("fyxh") Integer fyxh, @Param("jgid") Integer jgid);


 	/**
 	 * 收费项目选择调入
 	 * @Title: selectInsert
 	 * @Description: TODO(这里用一句话描述这个方法的作用)
 	 * @param @param jgid
 	 * @param @param fyxhList    设定文件
 	 * @return void    返回类型
 	 * @author 龚方舟
 	 * @throws
 	 */
 	void selectInsert(@Param("jgid") Integer jgid, @Param("fyxhList") List<Integer> fyxhList);

    /**
     * 收费项目批量调入
     * @Title: batchInsert
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param jgid
     * @param @param fygb    设定文件
     * @return void    返回类型
     * @author 龚方舟
     * @throws
     */
 	void batchInsert(@Param("jgid") Integer jgid, @Param("fygb") Integer fygb);

    /**
     * 更新医疗明细调价价格
     * @Title: updatePriceAdjustment
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return void    返回类型
     * @author 龚方舟
     * @throws
     */
    void updatePriceAdjustment(@Param("jgid") Integer jgid, @Param("tjdh") Integer tjdh);
}
