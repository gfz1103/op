package com.buit.commons.dao;

import com.buit.cis.op.dctwork.request.SaveKjywsqlyReq;
import com.buit.cis.op.dctwork.response.DrugDetailResponse;
import com.buit.commons.EntityDao;
import com.buit.commons.request.QueryPayReq;
import com.buit.op.model.mphis.response.MphisCfxqmxResponse;
import com.buit.op.response.IOpCf02Resp;
import com.buit.op.response.OpCf02;
import com.buit.op.response.OpCfToEmrResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 门诊_门诊处方明细表<br>
 *
 * @author yueyu
 */
@Mapper
public interface OpCf02Dao extends EntityDao<OpCf02, Integer> {
	/**
	 * 根据处方识别查询未扫描pda的数量
	 *
	 * @param cfsb 处方识别1
	 * @return
	 */
	Integer countByCfsbAndSmbzIsNull(@Param("cfsb") Integer cfsb);

	/**
	 * 查询处方明细
	 *
	 * @param cfsb 处方识别
	 * @return
	 */
	List<OpCf02> queryByCfsb(@Param("cfsb") Integer cfsb);

	/**
	 * 批量新增处方明细
	 *
	 * @param cf02List
	 * @return
	 */
	void batchInsert(@Param("list") List<OpCf02> cf02List);

	/**
	 * 获取序号
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getSbxhList(Map<String, Object> map);

	/**
	 * 更新药品序号
	 *
	 * @param map
	 */
	void updateYpxh(Map<String, Object> map);

	/**
	 * 根据识别序号更新金额
	 *
	 * @author wy
	 * @param map
	 */
	void updateJeBySbxh(Map<String, Object> map);

	/**
	 * 根据处方识别查询数量
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	Integer getCountByCfsb(Map<String, Object> map);

	/**
	 * 根据主键删除 Map版
	 *
	 * @author wy
	 * @param map
	 */
	void deleteBySbxh(Map<String, Object> map);

	/**
	 * 根据识别序号更新自负比例
	 *
	 * @author wy
	 * @param map
	 */
	void updateZfblBySbxh(Map<String, Object> map);

	/**
	 * 查询药品信息
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getYpInfo(Map<String, Object> map);

	/**
	 * 获得识别序号
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getSbxh(Map<String, Object> map);

//	/**
//	 * 根据cfsb查询pda病人药品明细
//	 *
//	 * @param cfsb
//	 * @return
//	 */
//	List<PadDrugDetailResp> queryPdaDetail(@Param("cfsb") Integer cfsb);

	/**
	 * 查询处方金额
	 *
	 * @param params
	 * @return
	 */
	Map<String, Object> queryCfje(Map<String, Object> params);

	/**
	 * 根据处方识别查询合计金额
	 *
	 * @param cfsbs
	 * @return
	 */
	List<BigDecimal> queryHjjeByCfsb(@Param("cfsbs") String cfsbs);

	/**
	 * 预保存更新
	 *
	 * @param map
	 */
	void updateBySaveSettle(OpCf02 opCf02);

	/**
	 *
	 * @param yzxcs
	 * @param cfsb
	 * @param ypzh
	 * @param ypxh
	 */
	void updateZxcs(Integer yzxcs, Integer cfsb, Integer ypzh, Integer ypxh);

	/**
	 * 更新皮试结果
	 *
	 * @param opcf02
	 */
	void updatePsjg(OpCf02 opcf02);

//	/**
//	 * 查询退药处方明细
//	 */
//	List<RefundDrugDetailResp> queryRefundDrugDetail(@Param("cfsb") Integer cfsb);
//
//	/**
//	 * 查询处方发药药品明细
//	 */
//	List<QueryDrugDetailResp> queryGrantDrugDetail(@Param("cfsb") Integer cfsb, @Param("yfsb") Integer yfsb,
//			@Param("jgid") Integer jgid);

	/**
	 * @name: deleteByCfsb
	 * @description: 根据处方识别删除处方02
	 * @param oldCfsb
	 * @return: void
	 * @date: 2020/8/18 13:45
	 * @auther: 老花生
	 *
	 */
	void deleteByCfsb(Integer oldCfsb);

	/**
	 * @name: queryPspbYpxhHjjeTsypZfblByCfsb
	 * @description:
	 * @param parameters
	 * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
	 * @date: 2020/8/26 13:40
	 * @auther: 老花生
	 *
	 */
	List<Map<String, Object>> queryPspbYpxhHjjeTsypZfblByCfsb(Map<String, Object> parameters);

	/**
	 * 发票查询门诊清单
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryMzqd(Map<String, Object> parameters);

	/**
	 *
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> doQueryYhje(Map<String, Object> params);

//	/**
//	 * 查询取消发药打印药品明细
//	 * */
//    List<DrugYfYlDto> queryCancelGrantDrugPrint(@Param("cfsb") Integer cfsb);
//
//    /**
//	 * 查询直接发药西药处方单打印明细
//	 * */
//    List<GrantDrugXyDetailDto> queryXyListPrint(@Param("cfsb") Integer cfsb);
//
//    /**
//	 * 查询儿科处方套打药品明细
//	 * */
//    List<PediatricPatternPrintDrugDto> queryPediatricDrug(@Param("cfsb") Integer cfsb);
//
//    /**
//	 * 查询普通处方白打药品明细
//	 * */
//	List<GeneralWhiteCombatDetailDto> queryGeneralWihiteCombatDetail(@Param("cfsb") Integer cfsb);

	/**
	 * 根据sbxh更新医技02或处方02表的减免金额
	 *
	 * @param jmje
	 * @param sbxh
	 */
	void updateJmjeBySbxh(@Param("jmje") BigDecimal jmje, @Param("sbxh") Integer sbxh);

	/**
	 * 更新处方皮试执行状态
	 *
	 * @param map
	 */
	void updatePszxzt(Map<String, Object> map);

	/**
	 * @name: getCfDetails
	 * @description: 处方点评明细接口
	 * @return: java.util.List<com.buit.op.response.IOpCf02Resp>
	 * @date: 2020/10/20 10:01
	 * @auther: 老花生
	 *
	 */
    List<IOpCf02Resp> getCfDetails(@Param("cfsbList") List<Integer> cfsbList);

    /**
     * @name: updateKjywsqly
     * @description: 保存抗菌药物申请理由
     * @param req
     * @return: void
     * @date: 2020/10/30 10:02
     * @auther: 老花生
     *
     */
    void updateKjywsqly(SaveKjywsqlyReq req);

	/**
	 * 【互联网医院】查询处方详情
	 * @param jzlsh
	 * @param cfh
	 * @return
	 */
	List<MphisCfxqmxResponse> queryCfDetail(@Param("jzlsh") String jzlsh, @Param("cfh") String cfh);

	/**
	 * 查询处方中的药品详情
	 * @param cfsb
	 * @return
	 */
	String getCfDrug(Integer cfsb);

	/**
	 * 处方打印 查询处方详情
	 * @param cfsb
	 * @return
	 */
	List<DrugDetailResponse> drugDetail(@Param("cfsb") Integer cfsb);

	void updateYlslAndJe(QueryPayReq o);

	/**
	 * 查询门诊病历处方详情
	 * @param jzlsh
	 * @return
	 */
	List<OpCfToEmrResp> queryOpCfToEmr(String jzlsh);
}
