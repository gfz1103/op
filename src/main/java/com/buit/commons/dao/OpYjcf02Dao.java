package com.buit.commons.dao;

import com.buit.cis.op.dctwork.response.CzDetailResponse;
import com.buit.cis.op.dctwork.response.YjztDetailResp;
import com.buit.commons.EntityDao;
import com.buit.commons.model.CzData;
import com.buit.commons.request.QueryJysqdReq;
import com.buit.commons.request.QueryPayReq;
import com.buit.commons.response.LoadAdditionResp;
import com.buit.commons.response.QueryJysqdResp;
import com.buit.his.request.RequestUpdateDetail;
import com.buit.op.model.OpYjcf02;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 门诊_门诊医技单明细表<br>
 *
 * @author 老花生
 */
@Mapper
public interface OpYjcf02Dao extends EntityDao<OpYjcf02, Integer> {
	/**
	 * 查询对象
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> findObjByObj(Map<String, Object> parameters);

	/**
	 * 更新数量、划价金额
	 *
	 * @param parametersupd
	 */
	void updateYldjAndHjje(Map<String, Object> parametersupd);

	/**
	 * 更新药品单价
	 *
	 * @param parametersupd
	 */
	void updateYpdj(Map<String, Object> parametersupd);

	/**
	 * 获取序号
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getSbxhInfo(Map<String, Object> map);

	/**
	 * 更新
	 *
	 * @param map
	 */
	void updateYlxh(Map<String, Object> map);

	/**
	 * 根据识别序号更新金额
	 *
	 * @author wy
	 * @param map
	 */
	void updateJeBySbxh(Map<String, Object> map);

	/**
	 * 根据YJXH序号查询数量
	 *
	 * @param map
	 * @return
	 */
	Integer getCountByYjxh(Map<String, Object> map);

	/**
	 * 根据主键删除 Map版
	 *
	 * @param map
	 */
	void deleteBySbxh(Map<String, Object> map);

	/**
	 * 查询 yj02信息
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	Map<String, Object> getYj02Info(Map<String, Object> map);

	/**
	 * 根据识别序号更新自负比例
	 *
	 * @author wy
	 * @param map
	 */
	void updateZfblBySbxh(Map<String, Object> map);

	/**
	 * 查询识别序号
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getSbxh(Map<String, Object> map);

	/**
	 * 查询 yj02信息
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getYj02Cic(Map<String, Object> map);

	/**
	 * 载入附加项目
	 *
	 * @param jzxh
	 * @return
	 */
	List<LoadAdditionResp> loadAddition(@Param("jzxh") Integer jzxh);

	/**
	 * 查询处置列表
	 *
	 * @param query
	 * @return
	 */
	List<Map<String, Object>> queryDisposalEntryList(Map<String, Object> query);

//	/**
//	 * 根据识别序号删除附加处方
//	 * @param params
//	 */
//    void deleteFjglBySbxh(Map<String, Object> params);

	/**
	 * 预保存更新
	 * @param nsYj02
	 */
	void updateBySaveSettle(OpYjcf02 nsYj02);

	/**
	 * 根据处方识别查询医技序号
	 *
	 * @param params
	 * @return
	 */
	List<Integer> queryYjxhByCfsb(Map<String, Object> params);

	/**
	 * 根据医技序号集合删除
	 *
	 * @param yjxhList
	 */
	void deleteBySbxhList(@Param("yjxhList") List<Integer> yjxhList);

	/**
	 * 根据识别序号查询发票号码、作废判别
	 *
	 * @param parametersMZXH
	 */
	CzData queryFphmZfbzBySbxh(Map<String, Object> parametersMZXH);

	/**
	 * 根据识别序号查询Zt信息发票号码、作废判别
	 *
	 * @param parametersMZXH
	 */
	CzData queryZtFphmZfbzBySbxh(Map<String, Object> parametersMZXH);

	/**
	 * 根据医技序号删除
	 */
	void deleteByYjxh(Map<String, Object> params);

	/**
	 * 修改下一条为医技主项
	 *
	 * @param parameters
	 */
	void updateYjzxBySbxh(Map<String, Object> parameters);

	/**
	 * 查询医疗数量
	 *
	 * @param params
	 * @return
	 */
	Map<String, Object> queryYlsl(Map<String, Object> params);

	/**
	 * 发票查询门诊清单
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryMzqd(Map<String, Object> parameters);

	/**
	 * @name: queryYjxhFymcYldjHjjeByYjxh
	 * @description: 根据医技序号查询费用名称、医疗单价、合计金额等信息
	 * @param parametersmx
	 * @return: void
	 * @date: 2020/8/31 16:45
	 * @auther: 老花生
	 *
	 */
	List<Map<String, Object>> queryFymcYldjHjjeByYjxh(Map<String, Object> parametersmx);


	/**
	 * 通过sbxh查询医技信息
	 * @param parametersmx
	 * @return
	 */
	List<Map<String, Object>> queryFymcHjjeBySbxh(Map<String, Object> parametersmx);


	/**
	 * 通过ZtysSbxh查询医技信息
	 * @param parametersmx
	 * @return
	 */
	List<Map<String, Object>> queryFymcByZtysSbxh(Map<String, Object> parametersmx);

	/**
	 * 更新执行状态和执行次数
	 *
	 * @param paraMap
	 */
	void updateZxztAndZxcs(Map<String, Object> paraMap);

	/**
	 * 根据snxh或者ztsbxh查询医技
	 *
	 * @param sbxh
	 * @param ztbz
	 * @return
	 */
	List<OpYjcf02> doQueryBySBxhOrZtsbxh(Integer sbxh, Integer ztbz);

	/**
	 * 根据sbxh更新医技02或处方02表的减免金额
	 *
	 * @param jmje
	 * @param sbxh
	 */
	void updateJmjeBySbxh(@Param("jmje") BigDecimal jmje, @Param("sbxh") Integer sbxh);

	/**
	 * 通过医技序号删除数据
	 * @param yjxh
	 */
	void deleteByYjxhForSssq(@Param("yjxh") Integer yjxh);

	/**
	 * 通过（jgid，ylxh(医疗序号)和jzlsh）判断当次就诊医技项目是否已经存在
	 * @param jgid
	 * @param ylxh
	 * @param jzlsh
	 * @return
	 */
	int queryByYlxhAndJzlsh(@Param("jgid") Integer jgid,@Param("ylxh") Integer ylxh,@Param("jzlsh") String jzlsh);

	/**
	 * 通过ZTYZSBXH（组套医嘱识别序号）查询医技的组套详细信息
	 * @param ztyzsbxh
	 * @return
	 */
	List<YjztDetailResp> queryZtDetail(@Param("ztyzsbxh") Integer ztyzsbxh);

	/**
	 * 查询门诊检验申请单数据
	 * @param req
	 * @return
	 */
	List<QueryJysqdResp> queryJysqdMessage(QueryJysqdReq req);

	void updateYlslAndJe(QueryPayReq req);

    List<RequestUpdateDetail> getLisRequestUpdate(String yjxhList);

	/**
	 * 修改处置更新明细数据
	 * @param yj02
	 */
	void updateyJcf02(OpYjcf02 yj02);

	/**
	 * 通过ztyzsbxh删除数据
	 * @param ztyzsbxh
	 */
	void deleteByZtyzsbxh(Integer ztyzsbxh);

	/**
	 * 通过就诊流水号和医技组号删除
	 * @param jzlsh
	 * @param yjzh
	 */
	void deleteByjzlshAndYjzh(String jzlsh,Integer yjzh);

	/**
	 * 通过就诊流水号查询最大组号
	 * @param jzlsh
	 * @param jgid
	 * @return
	 */
	Integer getMaxYjzh(String jzlsh,Integer jgid);

	/**
	 * 获取同组中是否存在组套数据
	 * @param jzlsh
	 * @param yjzh
	 * @return
	 */
	List<Integer> getSameGroupZt(String jzlsh,Integer yjzh);

	//处置打印相关 begin——————————————————————————————————————————————
	/**
	 * 通过就诊流水号查询处置详情数据
	 * @param jzlsh
	 * @return
	 */
	List<CzDetailResponse> getCzByJzlsh(String jzlsh);

	/**
	 * 通过就诊流水号和医技组号查询处置详情
	 * @param yjzhList
	 * @param jzlsh
	 * @return
	 */
	List<CzDetailResponse> getCzByYjzhAndJzlsh(List<Integer> yjzhList,String jzlsh);

	/**
	 * 通过ztsbxh和jzlsh查询处置详情
	 * @param ztsbxh
	 * @param jzlsh
	 * @return
	 */
	List<CzDetailResponse> getCzByztsbxhAndJzlsh(Integer ztsbxh,String jzlsh);

	/**
	 * 通过sbxh和jzlsh查询处置详情
	 * @param sbxh
	 * @param jzlsh
	 * @return
	 */
	List<CzDetailResponse> getCzBySbxhAndJzlsh(Integer sbxh,String jzlsh);

	List<OpYjcf02> getBySbxhList(@Param("list") List<Integer> sbxhList);

    //处置打印相关 end ————————————————————————————————————————————————

	/**
	 * 查询草药方代煎费信息
	 * @param cfsb
	 * @param jgid
	 */
	OpYjcf02 getDjf(Integer cfsb,Integer jgid);
}
