package com.buit.commons.dao;

import com.buit.cis.op.dctwork.response.CfPrintResponse;
import com.buit.cis.op.dctwork.response.YpyfResponse;
import com.buit.commons.EntityDao;
import com.buit.commons.model.Dzfdd;
import com.buit.commons.model.DzfddBack;
import com.buit.commons.model.OpCf01;
import com.buit.commons.response.PatientPrescriptionDetailsResp;
import com.buit.commons.response.QueryYbypxxResp;
import com.buit.op.dto.ICancelGrantDrugDto;
import com.buit.op.dto.ICfypDetailDto;
import com.buit.op.dto.IGrantDrugParamDto;
import com.buit.op.dto.IJmcfxxDto;
import com.buit.op.enums.IQueryConditionEnum;
import com.buit.op.model.mphis.response.MphisCfxqResponse;
import com.buit.op.model.mphis.response.MphisYspInfoResponse;
import com.buit.op.request.*;
import com.buit.op.response.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * 门诊_门诊处方表<br>
 *
 * @author yueyu
 */
@Mapper
public interface OpCf01Dao extends EntityDao<OpCf01, Integer> {

	/**
	 * 待发药记录查询
	 *
	 * @param yfsb               机构代码
	 * @param queryDispensingReq
	 * @return
	 */
	List<IQueryDispensingResp> doQueryDispensing(@Param("yfsb") Integer yfsb,
												 @Param("req") IQueryDispensingReq queryDispensingReq,
												 @Param("keys") List<IQueryConditionEnum> keys);

	/**
	 * 根据处方识别查询处方信息
	 *
	 * @param cfsb 处方识别
	 * @return
	 */
	IQueryPrescribingInformationResp doQueryPrescribingInformation(@Param("cfsb") Integer cfsb);

	/**
	 * 根据处方识别关联OP_CF02查询处方处方药品信息
	 *
	 * @param cfsb 处方识别
	 * @return
	 */
	List<ICfypDetailDto> queryCfypDetailJoinOpCf02(@Param("cfsb") Integer cfsb);

	/**
	 * 修改发药信息数据
	 *
	 * @param updateDto 修改参数
	 * @return
	 */
	void updateFyxx(IOpCf01UpdateDto updateDto);

	/**
	 * 根据处方识别查询处方明细
	 *
	 * @param cfsbs
	 */
	List<PatientPrescriptionDetailsResp> queryPrescriptionDetails(@Param("cfsbs") List<Integer> cfsbs);

	/**
	 * 根据处方识别查询取消发药处方明细
	 *
	 * @param cfsb
	 */
	ICancelDispensingCfDetailResp queryCancelDispensingCfDetailByCfsb(@Param("cfsb") Integer cfsb);

	/**
	 * 根据cfsb修改fybz和fyrq
	 *
	 * @param fybz
	 * @param fyrq
	 * @param cfsb
	 */
	void updateFybzAndFyrqByCfsb(@Param("fybz") int fybz, @Param("fyrq") Timestamp fyrq, @Param("cfsb") Integer cfsb);

	/**
	 * 获得处方信息
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getCfInfo(Map<String, Object> map);

	/**
	 * 根据处方识别查询fwblsh
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	Map<String, Object> getFwblshByCfsb(Map<String, Object> map);

	/**
	 * 根据主键删除信息 Map
	 *
	 * @author wy
	 * @param map
	 */
	void deleteByCfsb(Map<String, Object> map);

	/**
	 * 更新处方信息
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	int updateCfInfo(Map<String, Object> map);

	/**
	 * 获得数量
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	Integer getCf01Count(Map<String, Object> map);

	/**
	 * 根据是否VIP查询价格
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	BigDecimal getAmountByVip(Map<String, Object> map);

	/**
	 * 查询发票信息
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getByFphm(Map<String, Object> map);

	/**
	 * 获得数量
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	Integer getCountByCondition(Map<String, Object> map);

	/**
	 * 更新
	 *
	 * @author wy
	 * @param map
	 */
	void updateZfpb(Map<String, Object> map);

	/**
	 * 退费明细
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getTfDetail(Map<String, Object> map);

	/**
	 * 处方信息
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getCf01(Map<String, Object> map);

	/**
	 * 更新
	 *
	 * @author wy
	 * @param map
	 */
	void updateFphmMzxh(Map<String, Object> map);

	/**
	 * 根据yfsb、fyck查询pda信息
	 *
	 * @param req
	 */
	List<IPharmacyPdaResp> queryPdaByYfsbAndFyck(IPharmacyPdaReq req);

	/**
	 * 查询处方识别根据就诊序号并且发票不能为空
	 *
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> queryCfsbByJzxhFphmIsNull(Map<String, Object> params);

	/**
	 * 取消作废
	 *
	 * @param map
	 */
	void updateCancelZfpb(Map<String, Object> map);

	/**
	 * 查询已经收费的处方数
	 *
	 * @param params
	 * @return
	 */
	long queryChargeCount(Map<String, Object> params);

	/**
	 * 预保存更新
	 *
	 */
	void updateBySaveSettle(OpCf01 opCf01);

	/**
	 * 根据就诊序号，发票号码不等于空的数量
	 *
	 * @param parameters
	 * @return
	 */
	long queryCountByJzxhFpxhNotNull(Map<String, Object> parameters);

	/**
	 * 取消发药列表查询
	 *
	 * @param req
	 * @param cond
	 * @return
	 */
	List<ICancelDispensingResp> queryCancelList(@Param("req") ICancelDispensingReq req,
												@Param("cond") List<IQueryConditionEnum> cond);

	/**
	 * 获取最小叫号号码
	 *
	 * @param jhhmMap
	 * @return
	 */
	Map<String, Object> doQueryMinJhhm(Map<String, Object> jhhmMap);

	/**
	 * 处方明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryCfDetail(Map<String, Object> parameters);

	/**
	 * 查询发药窗口
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFyck(Map<String, Object> parameters);

	/**
	 * 查询处方药品
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryCfYp(Map<String, Object> parameters);

	/**
	 * 查询药房识别
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryYfsb(Map<String, Object> parameters);

	/**
	 * 药品信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQUeryYpA(Map<String, Object> parameters);

	/**
	 * @name: getCfPringFields
	 * @description: 处方打印 列查询
	 * @param parameters
	 * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
	 * @date: 2020/8/26 10:50
	 * @auther: 老花生
	 *
	 */
	List<Map<String, Object>> getCfPringFields(Map<String, Object> parameters);

	/**
	 * @name: getCfPringParameters
	 * @description: 处方打印 列查属性
	 * @param parameters
	 * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
	 * @date: 2020/8/26 11:06
	 * @auther: 老花生
	 *
	 */
	List<Map<String, Object>> getCfPringParameters(Map<String, Object> parameters);

	/**
	 * 获取处方打印数据
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> getPrintData(Map<String, Object> parameters);

	/**
	 * 处方诊断序号
	 *
	 * @param cfsbs
	 * @return
	 */
	List<Map<String, Object>> getJzxh(String cfsbs);

//	/**
//	 * 查询发药处方明细打印数据
//	 */
//	List<GrantDrugDetailDto> queryPrintDrugDetail(@Param("cfsb") Integer cfsb, @Param("jgid") Integer jgid);

	/**
	 * 查询发药处方病人信息
	 */
	IGrantDrugParamDto queryPrintBrInfo(@Param("cfsb") Integer cfsb, @Param("jgid") Integer jgid);

	/**
	 * 查询取消发药打印信息
	 */
	ICancelGrantDrugDto queryCancelGrantDrugPrintCfByCfsb(@Param("cfsb") Integer cfsb);

	/**
	 * 查询精麻处方打印数据
	 */
	IJmcfxxDto queryJmcfxx(@Param("cfsb") Integer cfsb);
//
//	/**
//	 * 查询处方药品明细
//	 */
//	List<AnaesthesiaPrescriptionDetailDto> queryYpDetail(@Param("cfsb") Integer cfsb);
//
//	/**
//	 * 查询当月精麻处方序号
//	 */
//	String countCfno(@Param("cfsb") Integer cfsb, @Param("tsyp") Integer tsyp, @Param("month") String month);
//
//	/**
//	 * 查询普通处方信息打印白打
//	 */
//	GeneralWhiteCombatDto queryGeneralWhiteCombatParam(@Param("cfsb") Integer cfsb);

	/**
	 * 判断是否开过处方
	 *
	 * @param jzlsh
	 * @return
	 */
	Integer doQueryCountByJzlsh(String jzlsh);

	/**
	 * @name: apiGetList
	 * @description: 接口查询cf列表
	 * @param req
	 * @return: java.util.List<com.buit.his.pha.op_pharmacy.model.OpCf01>
	 * @date: 2020/9/25 14:47
	 * @auther: 朱智
	 *
	 */
    List<OpCf01RespModel> apiGetList(OpCf01ReqModel req);

    /**
     * @name: updateShztByCfsb
     * @description: 根据处方识别更新审核状态
     * @param param
     * @return: java.lang.Long
     * @date: 2020/9/27 15:07
     * @auther: 朱智
     *
     */
    void updateShztByCfsb(Map<String, Object> param);

    /**
     * @name: findByYpxhYpcd
     * @description: 获取医保药品信息
     * @param parameters
     * @return: java.util.List<com.buit.commons.response.QueryYbypxxResp>
     * @date: 2020/10/14 13:55
     * @auther: 老花生
     *
     */
    List<QueryYbypxxResp> findByYpxhYpcd(Map<String, Object> parameters);

    /**
     * @name: extractCfByCount
     * @description: 根据数量来抽取处方
     * @param req
     * @return: void
     * @date: 2020/10/21 19:35
     * @auther: 老花生
     *
     */
	List<OpCf01RespModel> extractCfByCount(ExtractCfReq req);

	/**
	 * @name: extractCfByDateKsfw
	 * @description: 根据时间、科室范围查询数量
	 * @param req
	 * @return: void
	 * @date: 2020/10/22 14:12
	 * @auther: 老花生
	 *
	 */
    List<Map<String, Object>> getNumByDateKsfw(ExtractCfReq req);

	/**
	 * @name: extractCfByDateKsfw
	 * @description: 根据时间范围、医生范围查询每个医生符合的数量
	 * @param req
	 * @return: void
	 * @date: 2020/10/22 14:12
	 * @auther: 老花生
	 *
	 */
	List<Map<String, Object>> getNumByDateYsfw(ExtractCfReq req);

    /**
     * @name: extractCfByKsNum
     * @description: 根据科室数量抽取
     * @param ksNumList
     * @return: void
     * @date: 2020/10/22 14:36
     * @auther: 老花生
     *
     */
	List<OpCf01RespModel> extractCfByKsNum(@Param("ksNumList") List<Map<String, Object>> ksNumList);

	/**
	 * @name: extractCfByKsNum
	 * @description: 根据医生数量抽取
	 * @param ksNumList
	 * @return: void
	 * @date: 2020/10/22 14:36
	 * @auther: 老花生
	 *
	 */
	List<OpCf01RespModel> extractCfByYsNum(@Param("ysNumList") List<Map<String, Object>> ysNumList);

	/**
	 * @name: updateKjywxx
	 * @description: 更新抗菌药物信息
	 * @param list
	 * @return: void
	 * @date: 2020/10/30 9:18
	 * @auther: 老花生
	 *
	 */
    void updateKjywxx(IUpdateKjywxxReq list);

	/**
	 * 判断处方是否为 精二 处方   判断TSYP=7
	 * @param cfsb
	 * @return
	 */
	int getJeCf(Integer cfsb);

	/**
	 * 判断处方是否为 麻、精一 处方
	 * @param cfsb
	 * @return
	 */
	int getMjyCf(Integer cfsb);

	/**
	 * 查询指定处方指定类型的处方数据  麻、精一  精二 等
	 * @param cfsb
	 * @param zdlxList  指定类型 0 普通 1麻醉 2精神一 3剧毒 4危险 5花试 6胰岛素 7精神二 8二类精神 9抗菌药物 10血液制剂 11抗肿瘤 12肠外营养 13高危药品 15高价药品
	 * @return
	 */
	int getAppointTypeCf(Integer cfsb,List<String> zdlxList);

	/**
	 * 查询指定药品指定类型的处方数据  麻、精一  精二 等
	 * @param ypxhList   药品序号集合
	 * @param zdlxList  指定类型 0 普通 1麻醉 2精神一 3剧毒 4危险 5花试 6胰岛素 7精神二 8二类精神 9抗菌药物 10血液制剂 11抗肿瘤 12肠外营养 13高危药品 15高价药品
	 * @return
	 */
	int getAppointTypeDrug(List<Integer> ypxhList,List<String> zdlxList);

	/**
	 * 【互联网医院】通过就诊流水号处方号查询互联网医院的处方主信息
	 * @param jzlsh
	 * @param cfh
	 * @return
	 */
	List<MphisCfxqResponse> queryCfxx(@Param("jzlsh") String jzlsh, @Param("cfh") String cfh);


	/**
	 * 根据就诊流水号查询处方
	 * @param jzlsh
	 * @return
	 */
	List<OpCf01RespModel> queryCfbyJzlsh(@Param("jzlsh") String jzlsh);

	List<OpCf01> queryCfByCfsbs(@Param("cfh") List<String> cfh, @Param("jzlsh") String jzlsh);


	/**
	 * 查询全部互联网医院待支付处方
	 * @param dzfdd
	 * @return
	 */
	List<DzfddBack> queryNotCost(Dzfdd dzfdd);

	/**
	 * 【互联网医院】查询治疗中的医生的环信账号
	 * @param jzlsh
	 * @return
	 */
	MphisYspInfoResponse getNameByjzlsh(@Param("jzlsh") String jzlsh);

    /**
     * 查询医生详细信息
     * @param ysdmList
     * @return
     */
    List<YsMessageResponse> getysMessage(@Param("ysdmList") List<String> ysdmList);

	/**
	 * 通过就诊流水号查询对应医生基本信息
	 * @param jzlsh
	 * @return
	 */
	YsMessageResponse getYsMessageByJzlsh(@Param("jzlsh") String jzlsh);

	/**
	 *通过就诊流水号查询处方列表
	 * @param jzlsh
	 * @return
	 */
	List<String> getCfhListByJzlsh(@Param("jzlsh") String jzlsh);

	/**
	 * 处方打印返回数据
	 * @param cfsb
	 * @return
	 */
	CfPrintResponse getCfPrintData(@Param("cfsb") Integer cfsb);

	/**
	 * 查询处方的药品是否全部为静滴和静注药品
	 * @param cfsb
	 * @return
	 */
	List<YpyfResponse> sfwzsd(@Param("cfsb") Integer cfsb);

	void updateFphmByMzxh(@Param("cdFphm") String cdFphm,@Param("ysMzxh") Integer ysMzxh);

	List<Long> getJmdCfsb(@Param("cfsbXy") List<Long> cfsbXy);

	Integer getCkbhByRule(Long yfsb);
}
