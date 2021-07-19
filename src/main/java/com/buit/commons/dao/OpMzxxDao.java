package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpMzxx;
import com.buit.commons.request.DrugsTypkReq;
import com.buit.commons.response.OpZt01Resp;
import com.buit.commons.response.QueryFphmResp;
import com.buit.system.response.QueryJsJcResp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 门诊_门诊收费信息<br>
 *
 * @author WY
 */
@Mapper
public interface OpMzxxDao extends EntityDao<OpMzxx, Integer> {

	/**
	 * 获得处方信息
	 *
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getCfInfo(Map<String, Object> map);

	/**
	 * union ALL获得处方信息
	 *
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAllCfInfo(Map<String, Object> map);

	/**
	 * 发票作废查询
	 *
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getFpzfInfo(Map<String, Object> map);

	/**
	 * 获取门诊信息
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	Map<String, Object> getMzxxByCondition(Map<String, Object> map);

	/**
	 * 更新
	 *
	 * @author wy
	 * @param map
	 */
	void updateZfpb(Map<String, Object> map);

	/**
	 * 查询数量
	 *
	 * @param map
	 * @return
	 */
	Integer getCountByConditiion(Map<String, Object> map);

	/**
	 * 获取发票作废列表
	 *
	 * @author wy
	 * @param opMzxx
	 * @return
	 */
	List<OpMzxx> getFpzfList(OpMzxx opMzxx);

	/**
	 * 更改作废标识
	 *
	 * @author wy
	 * @param map
	 */
	void updateZfpbByCondition(Map<String, Object> map);

	/**
	 * 收费结算开处方 时的组套输入法
	 *
	 * @param Req
	 * @return
	 */
	List<OpZt01Resp> doQueryJcZtInfo(DrugsTypkReq Req);

	/**
	 * 退费和发票作废病人信息分页查询
	 *
	 * @param fphm
	 * @param hospitalId
	 * @return
	 */
	List<OpMzxx> doQueryMzxxFpxx(@Param("fphm") String fphm, @Param("jgid") Integer jgid);

	/**
	 * 获取结账日期
	 *
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> doQueryJzrq(Map<String, Object> map);

	/**
	 * 收费信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySfxx(Map<String, Object> parameters);

	/**
	 * 收费作废信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySfzfxx(Map<String, Object> parameters);

	/**
	 * 收费明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySfmx(Map<String, Object> parameters);

	/**
	 * 收费作废明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySfzfmx(Map<String, Object> parameters);

	/**
	 * 性质明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryXzmx(Map<String, Object> parameters);

	/**
	 * 性质作废明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryXzzfmx(Map<String, Object> parameters);

	/**
	 * 付款信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkxx(Map<String, Object> parameters);

	/**
	 * 付款作废信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkzfxx(Map<String, Object> parameters);

	/**
	 * 发票信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFpxx(Map<String, Object> parameters);

	/**
	 * 发票作废信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFpzfxx(Map<String, Object> parameters);

	/**
	 * 检查作废发票信息
	 *
	 * @param parameters
	 * @return
	 */
//	List<Map<String, Object>> doQueryJczffpxx(Map<String, Object> parameters);

//	/**
//	 *
//	 * @param parameters
//	 * @return
//	 */
//	List<Map<String, Object>> doQueryJjhjfpxx(Map<String, Object> parameters);

	/**
	 * 挂号明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhmx(Map<String, Object> parameters);

	/**
	 * 挂号退号明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhthmx(Map<String, Object> parameters);

	/**
	 * 挂号统计明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGrmx(Map<String, Object> parameters);

	/**
	 * 挂号统计退号明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGrthmx(Map<String, Object> parameters);

	/**
	 * 挂号付款信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhfkxx(Map<String, Object> parameters);

	/**
	 * 退号付款信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhfkzfxx(Map<String, Object> parameters);

	/**
	 * 检查项目
	 *
	 * @param jcparameters
	 * @return
	 */
//	List<Map<String, Object>> doQueryJcxm(Map<String, Object> jcparameters);

	/**
	 * 应交款
	 *
	 * @param yjkparameters
	 * @return
	 */
//	Map<String, Object> doQueryYjk(Map<String, Object> yjkparameters);

	/**
	 * 应交款作废
	 *
	 * @param yjkparameters
	 * @return
	 */
//	Map<String, Object> doQueryYjkzf(Map<String, Object> yjkparameters);

	/**
	 * 缴款合计
	 *
	 * @param params
	 * @return
	 */
//	Map<String, Object> doQueryJkhj(Map<String, Object> params);

	/**
	 * 就诊号码作废
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryJzhmzf(Map<String, Object> parameters);

	/**
	 * 收费日报结账日期
	 *
	 * @param jzrq
	 * @return
	 */
	Map<String, Object> doQuerySfrbJzrq(Map<String, Object> jzrq);

	/**
	 * 挂号日报结账日期
	 *
	 * @param jzrq
	 * @return
	 */
	Map<String, Object> doQueryGhrbJzrq(Map<String, Object> jzrq);

	/**
	 * 最近收费日期
	 *
	 * @param sfrqorghrq
	 * @return
	 */
	Map<String, Object> doQueryMinSfrq(Map<String, Object> sfrqorghrq);

	/**
	 * 最近挂号时间
	 *
	 * @param sfrqorghrq
	 * @return
	 */
	Map<String, Object> doQueryMinGhsj(Map<String, Object> sfrqorghrq);

	/**
	 * 查询病人性质等其他费用
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryBrxz(Map<String, Object> parameters);

	/**
	 * 查询就诊号码病人ID
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryJzhmBrid(Map<String, Object> parameters);

	/**
	 * 收费日报结账日期
	 *
	 * @param jzrq
	 * @return
	 */
	List<Map<String, Object>> doQuerySfrbJzrqList(Map<String, Object> jzrq);

	/**
	 * 挂号日报结账日期
	 *
	 * @param jzrq
	 * @return
	 */
	List<Map<String, Object>> doQueryGhrbJzrqList(Map<String, Object> jzrq);

	/**
	 * 结算结账日期
	 *
	 * @param jsMap
	 * @return
	 */
//	List<Map<String, Object>> doQueryJsJzrq(Map<String, Object> jsMap);

	/**
	 * 查询门诊信息金额和
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQuerySumMzxxJe(Map<String, Object> parameters);

	/**
	 * 查询挂号信息金额和
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQuerySumGhmxJe(Map<String, Object> parameters);

	/**
	 * 结算金额
	 *
	 * @param parameters
	 * @return
	 */
//	Map<String, Object> doQueryJcjsJe(Map<String, Object> parameters);

	/**
	 *
	 * @param parameters
	 * @return
	 */
//	Integer doQueryJszfCount(Map<String, Object> parameters);

	/**
	 * 根据收费日期查询数量
	 *
	 * @param parameters
	 * @return
	 */
	Integer doQueryCountBySfrq(Map<String, Object> parameters);

	/**
	 * 根据检查日期查询数量
	 *
	 * @param parameters
	 * @return
	 */
//	Integer doQueryCountByJsrq(Map<String, Object> parameters);

	/**
	 * 查询发票号码发票张数
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFphmFpzs(Map<String, Object> parameters);

	/**
	 * 金额
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryMzxxJe(Map<String, Object> parameters);

	/**
	 * 作废金额
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryMzxxJeZf(Map<String, Object> parameters);

	/**
	 * 收费明细作废
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySfmxZf(Map<String, Object> parameters);

	/**
	 * 性质明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryXzmxFphm(Map<String, Object> parameters);

	/**
	 * 性质明细作废
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryXzmxZf(Map<String, Object> parameters);

	/**
	 * 发票信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFpxxRb(Map<String, Object> parameters);

	/**
	 * 发票信息作废
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFpxxRbZf(Map<String, Object> parameters);

	/**
	 * 挂号日报
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhmxRb(Map<String, Object> parameters);

	/**
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGrmxRb(Map<String, Object> parameters);

	/**
	 * 挂号付款信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhFkxxRb(Map<String, Object> parameters);

	/**
	 * 就诊号码作废
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryJzhmZfRb(Map<String, Object> parameters);

	/**
	 * 收费金额
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySfje(Map<String, Object> parameters);

	/**
	 * 门诊收费日报
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQueryHzrb(Map<String, Object> parameters);

	/**
	 * 总计金额
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryZjje(Map<String, Object> parameters);

	/**
	 * 挂号日报
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQueryGhrb(Map<String, Object> parameters);

	/**
	 * 挂号日报明细
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQueryGhrbmx(Map<String, Object> parameters);

	/**
	 * 收费日报上次结账日期
	 *
	 * @param jzrqMap
	 * @return
	 */
	Map<String, Object> doQueryMaxHzrbJzrq(Map<String, Object> jzrqMap);

	/**
	 * 挂号日报上次结账日期
	 *
	 * @param jzrqMap
	 * @return
	 */
	Map<String, Object> doQueryMaxGhrbJzrq(Map<String, Object> jzrqMap);

	/**
	 * 收费日报付款明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySfrbFkmx(Map<String, Object> parameters);

	/**
	 * 挂号日报收费明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhrbFkmx(Map<String, Object> parameters);

//	/**
//	 * 查询总计金额
//	 *
//	 * @param jcparameters
//	 * @return
//	 */
//	List<Map<String, Object>> doQuerySumZjje(Map<String, Object> jcparameters);

	/**
	 * 缴款金额
	 *
	 * @param yjkparameters
	 * @return
	 */
//	Map<String, Object> doQueryTbkkJkJe(Map<String, Object> yjkparameters);

	/**
	 * 缴款作废金额
	 *
	 * @param yjkparameters
	 * @return
	 */
//	Map<String, Object> doQueryJkjeZf(Map<String, Object> yjkparameters);

//	/**
//	 * 缴款合计
//	 *
//	 * @param params
//	 * @return
//	 */
//	Map<String, Object> doQuerySumJkhj(Map<String, Object> params);

	/**
	 * 挂号明细金额
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGrmxJeRb(Map<String, Object> parameters);

	/**
	 * 退号明晰
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGrthmxRb(Map<String, Object> parameters);

	/**
	 * 减免金额
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryJmje(Map<String, Object> parameters);

	/**
	 * 减免金额作废
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryJmjeZf(Map<String, Object> parameters);

	/**
	 * 收费日报
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySfmxRb(Map<String, Object> parameters);

	/**
	 * 收费明细作废
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySfzfmxRb(Map<String, Object> parameters);

	/**
	 * 性质明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryXzmxRb(Map<String, Object> parameters);

	/**
	 * 性质明细作废
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryxzmxZfRb(Map<String, Object> parameters);

	/**
	 * 付款信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkxxRb(Map<String, Object> parameters);

	/**
	 * 付款信息作废
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkxxZf(Map<String, Object> parameters);

	/**
	 * 发票号码张数
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFphmFpzsRb(Map<String, Object> parameters);

	/**
	 * 发票作废信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFpzfxxRb(Map<String, Object> parameters);

	/**
	 * 检查作废发票
	 *
	 * @param parameters
	 * @return
	 */
//	List<Map<String, Object>> doQueryJczffpxxRb(Map<String, Object> parameters);

	/**
	 *
	 * @param parameters
	 * @return
	 */
//	List<Map<String, Object>> doQueryJjhjfpxxRb(Map<String, Object> parameters);

	/**
	 * 挂号明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhmxRbA(Map<String, Object> parameters);

	/**
	 * 退号明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhthmxRb(Map<String, Object> parameters);

	/**
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGrmxRbA(Map<String, Object> parameters);

	/**
	 * 挂号付款信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhFkxxA(Map<String, Object> parameters);

	/**
	 * 付款信息作废
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhfkxxZf(Map<String, Object> parameters);

//	/**
//	 * 检查项目
//	 *
//	 * @param jcparameters
//	 * @return
//	 */
//	List<Map<String, Object>> doQueryJcxmRb(Map<String, Object> jcparameters);

	/**
	 * 应交款
	 *
	 * @param parameters
	 * @return
	 */
//	Map<String, Object> doQueryYjkRb(Map<String, Object> parameters);

	/**
	 * 应交款作废
	 *
	 * @param parameters
	 * @return
	 */
//	Map<String, Object> doQueryJkZf(Map<String, Object> parameters);

	/**
	 *
	 * @param params
	 * @return
	 */
	Map<String, Object> doQueryJjhj(Map<String, Object> params);

	/**
	 * 就诊号码作废
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryJzhmzfRbA(Map<String, Object> parameters);

	/**
	 * 收费日报
	 *
	 * @param jzrq
	 * @return
	 */
	Map<String, Object> doQuerySfrbA(Map<String, Object> jzrq);

	/**
	 * 挂号日报
	 *
	 * @param jzrq
	 * @return
	 */
	Map<String, Object> doQueryGhrbA(Map<String, Object> jzrq);

	/**
	 * 查询付款方式
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkfs(Map<String, Object> parameters);

	/**
	 * 查询病人性质
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryBrxzRb(Map<String, Object> parameters);

	/**
	 * 就诊号码病人ID
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryJzhmBridRb(Map<String, Object> parameters);

	/**
	 * 门诊信息金额
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryMzxxJeInfo(Map<String, Object> parameters);

	/**
	 * 查询就诊卡号
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQueryJzkh(Map<String, Object> parameters);

	/**
	 * pos、支付宝金额
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQueryMzxxPosAndZfbJe(Map<String, Object> parameters);

	/**
	 * 门诊信息金额
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQueryMzxxJeA(Map<String, Object> parameters);

	/**
	 * 门诊信息金额
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQueryMzxxJeB(Map<String, Object> parameters);

	/**
	 * 医技金额
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQueryMzxxYjJe(Map<String, Object> parameters);

	/**
	 * 发票张数发票号码
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFphmFpzsRbA(Map<String, Object> parameters);

	/**
	 * 根据条件修改结账日期
	 *
	 * @param parameters
	 */
	void doUpdateJzrq(Map<String, Object> parameters);

	/**
	 * 清空结账日期
	 *
	 * @param parameters
	 */
	void doUpdateJzrqToNull(Map<String, Object> parameters);

	/**
	 * 发票查询
	 *
	 * @param params
	 * @return
	 */
	List<QueryFphmResp> doQueryFphmInfo(Map<String, Object> params);

	/**
	 * 查询门诊清单
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQueryMzqd(Map<String, Object> parameters);

	/**
	 * 收费明细
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryMzxxSfmx(Map<String, Object> parameters);

	/**
	 * 根据结账日期查询病人性质
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryBrxzByJzrq(Map<String, Object> parameters);

	/**
	 * 门诊信息收费项目
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryMzxxSfxm(Map<String, Object> parameters);

	/**
	 * 根据汇总日期查询病人性质
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryBrxzByHzrq(Map<String, Object> parameters);

	/**
	 * 查询治疗项目信息
	 *
	 * @param parameters1
	 * @return
	 */
	List<Map<String, Object>> getAllZlInfo(Map<String, Object> parameters1);

	/**
	 * 更新汇总日期
	 *
	 * @param parameters
	 */
	void doUpdateHzrq(Map<String, Object> parameters);

	/**
	 * 查询病人性质
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryBrxzQtysByHzrq(Map<String, Object> parameters);

	/**
	 * 查询病人性质信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryBrxzInfo(Map<String, Object> parameters);

	/**
	 * 汇总时间置空
	 *
	 * @param
	 */
	void updateHzrqToNull(String hzrq,int mzlb,int jgid);

	/**
	 * 汇总查询 病人性质
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryHzcxBrxz(Map<String, Object> parameters);

	/**
	 * 汇总查询病人性质
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryHzcxBrxzA(Map<String, Object> parameters);

	/**
	 * 项目分类汇总
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryXmflhz(Map<String, Object> parameters);

	/**
	 * 未结账收费
	 *
	 * @param parametersUser
	 * @return
	 */
	List<Map<String, Object>> doQueryWjzsf(Map<String, Object> parametersUser);

	/**
	 * 查询付款金额
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkje(Map<String, Object> parameters);

	/**
	 * 条件查询发票号码
	 *
	 * @param parametersUser
	 * @return
	 */
	List<Map<String, Object>> doQueryFphmByCondition(Map<String, Object> parametersUser);

	/**
	 * 未结账收费汇总查询
	 *
	 * @param parametersUser
	 * @return
	 */
	List<Map<String, Object>> doQueryWjzsfhz(Map<String, Object> parametersUser);

	/**
	 * 未结账收费付款金额
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryWjzsfhzJe(Map<String, Object> parameters);

	/**
	 * 获取信息
	 *
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getYktypkInfo(Map<String, Object> map);

	/**
	 * 检验 输入法查询 -挂号收费专用
	 *
	 * @param par
	 * @return
	 */
	List<QueryJsJcResp> doQueryJsjc(Map<String, Object> par);

	/**
	 * 获取医保发票门诊信息
	 *
	 * @author  bjh
	 * @param mzxh
	 * @return
	 */
	List<Map<String, Object>> doQueryybxxInfo(String mzxh);
	/**
	 * 通过就诊流水号查询收费数据
	 * @param jzlsh
	 * @return
	 */
	List<OpMzxx> getOpMzxxByJzlsh(String jzlsh);

	void updateFphmByMzxh(String cdFphm, Integer mzxh);

	OpMzxx getByFphm(String fphm);

	List<Map<String,Object>> getGhks(String jzlsh);

	/**
	 * 获取收费明细list
	 * @param jzksrq
	 * @param jzjsrq
	 * @param mzlb
	 * @param userid
	 * @param jgid
	 * @return
	 */
	List<Map<String,Object>> doQuerySfxmList(String jzksrq,String jzjsrq, int mzlb,String userid,String jgid);

	List<Map<String,Object>> doQueryFkxxMap(String jzksrq,String jzjsrq,int mzlb,int userid,int jgid);


	Map<String,Object> doQueryGhybMap(String jzksrq,String jzjsrq,int mzlb,int userid,int jgid);
	Map<String,Object> doQuerySfybMap(String jzksrq,String jzjsrq,int mzlb,int userid,int jgid);

	List<Map<String,Object>> doQuerySjh(String jzksrq,String jzjsrq,int mzlb,int userid,int jgid);
	List<Map<String,Object>> doQueryFph(String jzksrq,String jzjsrq,int mzlb,int userid,int jgid);


	List<Map<String,Object>> doQuerySfrbList(int userid,int jgid,int mzlb);

	/**
	 * 获取最后一次结账日期
	 * @return
	 */
	Map<String, Object> getLastJzrq(int czgh,int jgid,int mzlb);

	/**
	 * 获取第一次挂号收费日期
	 * @param czgh
	 * @param jgid
	 * @param mzlb
	 * @return
	 */
	List<Map<String,Object>> getFirstGhsfrq(int czgh,int jgid,int mzlb);

	List<Map<String,Object>> getOprbmxbyjzrq(String jzjsrq,int mzlb,int userid,int jgid);

	Map<String,Object> doQueryOprbmxsfmxbyjzrq(String jzjsrq,int mzlb,int userid,int jgid);

	void doUpdateJzrqByRb(String jzksrq,String jzjsrq,int mzlb,int jgid,int czgh);
	void doUpdateZfJzrqByRb(String jzksrq,String jzjsrq,int mzlb,int jgid,int czgh);

	Map<String, Object> getLastHzJzrq(int jgid,int mzlb);
	List<Map<String, Object>> getFirstHzrq(int jgid,int mzlb);


	List<Map<String, Object>> doQueryHzRyList(String hzksrq,String hzjsrq, int mzlb,String jgid);
	List<Map<String, Object>> doQuerySfxmhzList(String czgh,String hzksrq,String hzjsrq, int mzlb,String jgid);

	List<Map<String,Object>> doQueryHzRyedList(String hzjsrq, int mzlb,String jgid);
	List<Map<String, Object>> doQuerySfxmhzedList(String czgh,String hzjsrq, int mzlb,String jgid);

	List<Map<String,Object>> doQuerySfrbhzList(int jgid,int mzlb);

	void updateHzrq(String hzksrq,String hzjsrq,int mzlb,int jgid);
	void updateZfHzrq(String hzksrq,String hzjsrq,int mzlb,int jgid);
	void updateZfHzrqToNull(String hzrq,int mzlb,int jgid);

	/**
	 * 查询是否已汇总
	 *
	 * @param jzrq
	 * @return
	 */
	List<Map<String, Object>> doQueryHzrq(String jzrq);
}
