package com.buit.commons.dao;

import com.buit.cis.op.dctwork.response.CzPrintResponse;
import com.buit.commons.EntityDao;
import com.buit.commons.model.OpGhmxInfo;
import com.buit.commons.request.QueryAuxiliaryJyDetailReq;
import com.buit.commons.request.QueryDisposalEntryListReq;
import com.buit.commons.response.InitPatientDisposeResp;
import com.buit.commons.response.QueryAuxiliaryJyDetailResp;
import com.buit.commons.response.QueryAuxiliaryReportListResp;
import com.buit.his.request.RequestUpdateInfo;
import com.buit.op.model.OpYjcf01;
import com.buit.op.response.OpYjcfEmrResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 门诊_门诊医技单<br>
 *
 * @author 老花生
 */
@Mapper
public interface OpYjcf01Dao extends EntityDao<OpYjcf01, Integer> {

	/**
	 * 初始化病人信息查询诊断
	 *
	 * @param opYjcf01
	 * @return
	 */
	List<InitPatientDisposeResp> initPatientDispose(OpYjcf01 opYjcf01);

	/**
	 * 查询医技数量
	 *
	 * @param opYjcf01 查询参数
	 * @return
	 */
	Long getYjCount(OpYjcf01 opYjcf01);

	/**
	 * 查询医技数量
	 *
	 * @param opGhmxInfo 查询参数
	 * @return
	 */
	Long getYjCountOne(OpGhmxInfo opGhmxInfo);

	/**
	 * 更新执行科室、申检医生、申检科室
	 *
	 * @param parameters 查询参数
	 */
	void updateZxksYsdmKsdm(Map<String, Object> parameters);

	/**
	 * 根据医技序号查询数量
	 *
	 * @param params 查询参数
	 * @return
	 */
	Long getCountByYjxh(Map<String, Object> params);

	/**
	 * 更新申请ID
	 *
	 * @param par
	 */
	void updateSqid(Map<String, Object> par);

	/**
	 * 获取医技信息
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getYjInfo(Map<String, Object> map);

	/**
	 * 根据医技序号查询fwblsh
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	Map<String, Object> getFwblshByYjxh(Map<String, Object> map);

	/**
	 * 根据医技序号删除
	 *
	 * @author wy
	 * @param map
	 */
	void deleteByYjxh(Map<String, Object> map);

	/**
	 * 根据医技序号更新号码
	 *
	 * @param map
	 * @return
	 */
	int updateHmByYjxh(Map<String, Object> map);

	/**
	 * 根据门诊序号查询识别序号
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getSbxhByMzxh(Map<String, Object> map);

	/**
	 * 获得数量
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	Integer getYj01Count(Map<String, Object> map);

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
	 * 根据条件查询数量
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

//	/**
//	 * 获得是被序号
//	 *
//	 * @author wy
//	 * @param map
//	 * @return
//	 */
//	List<Map<String, Object>> getYjSbxhs(Map<String, Object> map);

	/**
	 * 查询医技号码
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getYjxh(Map<String, Object> map);

	/**
	 * 退费明细
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getTfDetail(Map<String, Object> map);

	/**
	 * 多表关联
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	Map<String, Object> getOpYjcf01Cic(Map<String, Object> map);

	/**
	 * 更新
	 *
	 * @author wy
	 * @param map
	 */
	void updateFphmMzxh(Map<String, Object> map);

	/**
	 * 查询识别序号
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getSbxh(Map<String, Object> map);

	/**
	 * 查询检查金额
	 *
	 * @param params
	 * @return
	 */
	Map<String, Object> queryJcje(Map<String, Object> params);

	/**
	 * 根据就诊序号查询合计金额
	 *
	 * @param jzxh
	 * @return
	 */
	List<BigDecimal> queryHjjeByJzxh(@Param("jzxh") Integer jzxh);

	/**
	 * 取消作废
	 *
	 * @param map
	 */
	void updateCalcelZfpb(Map<String, Object> map);

	/**
	 * 根据识别序号删除附加处方
	 *
	 * @param params
	 */
	void deleteFjglBySbxh(Map<String, Object> params);

	/**
	 * 预保存更新
	 *
	 * @param map
	 */
	void updateBySaveSettle(OpYjcf01 nsYj01);

	/**
	 * 根据就诊序号，发票号码不等于空的数量
	 *
	 * @param parameters
	 */
	long queryCountByJzxhFpxhNotNull(Map<String, Object> parameters);

	/**
	 * 根据识别序号查询门诊序号、作废判别
	 *
	 * @param parametersMZXH
	 * @return
	 */
	Map<String, Object> queryMzxhZfpbBySbxh(Map<String, Object> parametersMZXH);

	/**
	 * 查询是否已收费
	 *
	 * @param parameters
	 */
	long getIsSfByYjxh(Map<String, Object> parameters);

	/**
	 * 判断是否需要审核
	 *
	 * @param params
	 */
	Long queryIsNeedVerify(Map<String, Object> params);

	/**
	 * 查询执行科室
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryZxks(Map<String, Object> parameters);

	/**
	 * 医技费用
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryYjFy(Map<String, Object> parameters);

	/**
	 * 医技药品
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryYjYp(Map<String, Object> parameters);

	/**
	 * 医技诊断序号
	 *
	 * @param yjxhs
	 * @return
	 */
	List<Map<String, Object>> getJzxh(String yjxhs);

	/**
	 * @name: queryYjPrintPatientInfo
	 * @description: 医技打印查询用户信息
	 * @param parameters
	 * @return: void
	 * @date: 2020/8/31 17:05
	 * @auther: 老花生
	 *
	 */
	List<Map<String, Object>> queryYjPrintPatientInfo(Map<String, Object> parameters);

	/**
	 * @name: queryAuxiliaryReportList
	 * @description: 查询辅助报告检查申请列表
	 * @param req
	 * @return: java.util.List<com.buit.cis.op.dctwork.response.QueryAuxiliaryReportListResp>
	 * @date: 2020/9/2 16:10
	 * @auther: 朱智
	 *
	 */
	List<QueryAuxiliaryReportListResp> queryAuxiliaryJyReportList(QueryDisposalEntryListReq req);

	/**
	 * @name: queryAuxiliaryJyDetail
	 * @description: 查询辅助报告检验明细信息
	 * @param req
	 * @return: java.util.List<com.buit.cis.op.dctwork.response.QueryAuxiliaryJyDetailResp>
	 * @date: 2020/9/3 10:20
	 * @auther: 朱智
	 *
	 */
	List<QueryAuxiliaryJyDetailResp> queryAuxiliaryJyDetail(QueryAuxiliaryJyDetailReq req);

	/**
	 * 判断是否开医技
	 *
	 * @param jzlsh
	 * @return
	 */
	Integer doQueryCountByJzlsh(String jzlsh);

	/**
     * 根据医技序号修改检查状态
     *
     * @param mapPar
     */
    void updateJcztByYjxh(Map<String, Object> mapPar);

    /**
     * 更新检查状态
     *
     * @author wy
     * @param map
     */
    void updateJczt(Map<String, Object> map);

	/**
	 * 通过手术申请单id查询医技主表数据
	 * @param sssqId
	 * @return
	 */
	OpYjcf01 queryBySssqId(@Param("sssqId") Integer sssqId);

	void updateFphmByMzxh(@Param("cdFphm") String cdFphm,@Param("ysMzxh") Integer ysMzxh);

	List<RequestUpdateInfo> getLisRequestUpdate(String valueOf);

	List<OpYjcf01> getListByYjxhs(String yjxh, List<Integer> yjxhs, Integer xmlx, Integer type);

	/**
	 * 查询当前医技序号（yjxh）下是否存在不同组的处置数据
	 * @param yjxh
	 * @param yjzh
	 * @return
	 */
	int getNotSameGroup(Integer yjxh,Integer yjzh);

	/**
	 * 查询就诊流水号和医技组号查询下的医技数据
	 * @param jzlsh
	 * @param yjzh
	 * @return
	 */
	List<Integer> getyjxhList(String jzlsh,Integer yjzh);

	/**
	 * 门诊病历查询检验检查治疗申请单
	 * @param jzlsh
	 * @return
	 */
	List<OpYjcfEmrResp> queryYjcfToEmr(String jzlsh);

	/**
	 * 通过cfsb和fjlb查询处方附加项目
	 * @param cfsb
	 * @param fjlb 处方附加项目 2为处方皮试项目 3为处方的代煎费
	 * @return
	 */
	List<OpYjcf01> getCfFjxm(Integer cfsb,Integer fjlb);

	/**
	 * 查询处置打印数据
	 * @param jzlsh
	 * @return
	 */
	CzPrintResponse getCzPrintData(String jzlsh);

	/**
	 * 通过治疗申请单ID查询医技数据
	 * @param zlsqdid
	 * @return
	 */
	List<OpYjcf01> getcf01Byzlsqdid(Integer zlsqdid);

	/**
	 * 通过医技序号更新执行科室
	 * @param yjxh
	 * @param zxks
	 */
	void updateZxksByYjxh(Integer yjxh, Integer zxks);
}
