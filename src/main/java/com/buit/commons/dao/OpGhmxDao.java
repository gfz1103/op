package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.MsGhInfo;
import com.buit.commons.model.OpGhks;
import com.buit.commons.model.OpGhmxInfo;
import com.buit.commons.request.OpGhmxReq;
import com.buit.commons.response.OpGhmxResp;
import com.buit.op.model.OpGhmx;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * 门诊_挂号明细表<br>
 *
 * @author 老花生
 */
@Mapper
public interface OpGhmxDao extends EntityDao<OpGhmx, Integer> {

	/**
	 * 查询待诊列表
	 *
	 * @param req
	 * @return
	 */
	List<OpGhmxResp> queryDz(OpGhmxReq req);

	/**
	 * 查询诊中列表
	 *
	 * @param req
	 * @return
	 */
	List<OpGhmxResp> queryZg(OpGhmxReq req);

	/**
	 * 查询已诊（束诊）列表
	 *
	 * @param req
	 * @return
	 */
	List<OpGhmxResp> queryYz(OpGhmxReq req);

	/**
	 * 当前班次的收费挂号预约到当前班次就不再是预约了,而变成了挂号
	 *
	 * @param opGhmx
	 */
	void updateYybz(OpGhmx opGhmx);

	/**
	 * 更新挂号表的诊断序号
	 *
	 * @param req
	 */
	void updateBySbxh(Map<String, Object> req);

	/**
	 * 根据条件查询挂号信息
	 *
	 * @param opGhmxInfo 查询条件
	 * @return
	 */
	List<OpGhmxInfo> getGhmxByCondition(OpGhmxInfo opGhmxInfo);

	/**
	 * 根据识别序号查询挂号费
	 *
	 * @param opGhmxInfo
	 * @return
	 */
	BigDecimal getGhf(OpGhmxInfo opGhmxInfo);

	/**
	 * 第一次挂免费号，第二个正常挂号收取挂号费
	 *
	 * @param opGhmxInfo
	 * @return
	 */
	List<OpGhmxInfo> getGhmxInfo(OpGhmxInfo opGhmxInfo);

	/**
	 * 查询挂号明细数量
	 *
	 * @param opGhmxInfo
	 * @return
	 */
	Integer getGhmxCount(OpGhmxInfo opGhmxInfo);

	/**
	 * 处方识别数量
	 *
	 * @param opGhmxInfo
	 * @return
	 */
	Integer getCfsbCount(OpGhmxInfo opGhmxInfo);

	/**
	 * 医技序号数量
	 *
	 * @param opGhmxInfo
	 * @return
	 */
	Integer getYjxhCount(OpGhmxInfo opGhmxInfo);

	/**
	 * 多表关联获取挂号明细信息
	 *
	 * @param opGhmxInfo
	 * @return
	 */
	List<OpGhmxInfo> getGhmx(OpGhmxInfo opGhmxInfo);

	/**
	 * 获取就诊号码数量
	 *
	 * @param jzxh
	 * @return
	 */
	Integer getJzxhCount(Integer jzxh);

	/**
	 * 获取医保挂号数量
	 *
	 * @param opGhmxInfo
	 * @return
	 */
	Integer getYbghCount(OpGhmxInfo opGhmxInfo);

	/**
	 * 更改退号标志
	 *
	 * @param map
	 */
	void updateThbz(Map<String, Object> map);

	/**
	 * 根据识别序号查询门诊科室
	 *
	 * @param sbxh 识别序号
	 * @return
	 */
	Map<String, Object> findMzks(Integer sbxh);

	/**
	 * 查询科室名称、科室id
	 *
	 * @param parametersmzks 查询对象
	 * @return
	 */
	Map<String, Object> findDeptInfo(Map<String, Object> parametersmzks);

	/**
	 * 当日某科室挂号次数 查询时增加退号标志判断
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	Map<String, Object> getSbxhCount(Map<String, Object> map);

	/**
	 * 根据病人id和机构id查询挂号明细
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	Integer getGhmxCzpbl(Map<String, Object> map);

	/**
	 * 获取最大排队序号
	 *
	 * @param map
	 * @return
	 */
	Integer getMaxPdxh(Map<String, Object> map);

	/**
	 * 获取等待次数和
	 *
	 * @param map
	 * @return
	 */
	Integer getSumDdcs(Map<String, Object> map);

	/**
	 * 更新挂号信息
	 *
	 * @param map
	 */
	void updateGhmxInfo(Map<String, Object> map);

	/**
	 * 更新 就诊状态
	 *
	 * @param params
	 */
	void updateJzzt(Map<String, Object> params);

	/**
	 * 更新未结束就诊状态
	 *
	 * @param params
	 */
	void updateJzztNotOver(Map<String, Object> params);

	/**
	 * 更新就诊状态、就诊医生
	 *
	 * @param params
	 */
	void updateJzztJzys(Map<String, Object> params);

	/**
	 * 转科根据卡号查询信息
	 *
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getTurnDeptInfo(Map<String, Object> map);

	/**
	 * 更新挂号明细 map版key值都大写 所以新写了一个
	 *
	 * @param map
	 */
	void updateGhmx(Map<String, Object> map);

	/**
	 * 获取诊断序号
	 *
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getZdxh(Map<String, Object> map);

	/**
	 * 获取科室代码和科室名称
	 *
	 * @param map
	 * @return
	 */
	Map<String, Object> getKsInfo(Map<String, Object> map);

	/**
	 * 得到自助挂号科室
	 *
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getZzghksList(Map<String, Object> map);

	/**
	 * 更新挂号金额
	 *
	 * @param map
	 */
	void updateGhmxGhje(Map<String, Object> map);

	/**
	 * 更新就诊状态
	 *
	 * @author wy
	 * @param map
	 */
	void updateJzztByCondition(Map<String, Object> map);

	/**
	 * 根据识别序号更新诊断序号
	 *
	 * @author wy
	 * @param map
	 */
	void updateZdxhBySbxh(Map<String, Object> map);

	/**
	 * 挂号信息查询
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getGhmxDetail(Map<String, Object> map);

	/**
	 * 判断有效期内是否有挂号信息
	 *
	 * @param params
	 * @return
	 */
	Integer getMaxSbxh(Map<String, Object> params);

	/**
	 * 更新为就诊中根据sbxh
	 *
	 * @param parameters
	 */
	void updateInConsultationBySbxh(Map<String, Object> parameters);

	/**
	 * 新为就诊中根据sbxh、jzys
	 *
	 * @param parameters
	 */
	void updateInConsultationBySbxhAndJzys(Map<String, Object> parameters);

	/**
	 * 根据就诊序号更新就诊状态
	 *
	 * @param params
	 */
	void updateJzztByJzxh(Map<String, Object> params);

	/**
	 * 根据就诊状态，识别序号更新就诊状态
	 *
	 * @param params
	 */
	void updateJzztByJzztSbxh(Map<String, Object> params);

	/**
	 * 根据就诊状态，识别序号更新就诊状态,就诊医生
	 *
	 * @param params
	 */
	void updateJzztJzysByJzztSbxh(Map<String, Object> params);

	/**
	 * //获取病人今日已挂号的科室、科室医生和门诊就诊流水号
	 *
	 * @param opGhmxInfo
	 * @return
	 */
	List<MsGhInfo> getGhInfoList(OpGhmxInfo opGhmxInfo);

	/**
	 * 根据挂号时间查询数量
	 *
	 * @param parameters
	 * @return
	 */
	Integer doQueryCountByGhsj(Map<String, Object> parameters);

	/**
	 * 获取最大排队序号
	 *
	 * @return
	 */
	List<Map<String, Object>> doQueryMaxPdxh();

	/**
	 * 挂号金额信息
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhmxInfo(Map<String, Object> parameters);

	/**
	 * 通过就诊号码取就诊卡号
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQueryJzkh(Map<String, Object> parameters);

	/**
	 * 查询等待次数和排队序号
	 *
	 * @param dayinmap
	 * @return
	 */
	List<Map<String, Object>> doQueryDdcsAndPdxh(Map<String, Object> dayinmap);

	/**
	 * 更新结账日期
	 *
	 * @param parameters
	 */
	void doUpdateJzrq(Map<String, Object> parameters);

	/**
	 * 更新结账日期
	 *
	 * @param parameters
	 */
	void doUpdateJzrqByCondition(Map<String, Object> parameters);

	/**
	 * 结账日期置空
	 *
	 * @param parameters
	 */
	void doUpdateJzrqToNull(Map<String, Object> parameters);

	/**
	 * 查询挂号费用
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhfy(Map<String, Object> parameters);

	/**
	 * 根据结账日期查询挂号费用
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGhfyByJzrq(Map<String, Object> parameters);

	/**
	 * 门诊收费汇总日报门诊挂号收费汇总报表(未结账)
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySumGhje(Map<String, Object> parameters);

	/**
	 * 挂号信息合计
	 *
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> doQuerySumGhmx(Map<String, Object> params);

	/**
	 * 收费员工作量统计
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySfygzl(Map<String, Object> parameters);

	/**
	 * 查询挂号记录
	 *
	 * @param ssbxh
	 * @return
	 */
	long getGhjl(String ssbxh);

	/**
	 * 医保备份表
	 *
	 * @param msghmx
	 */
	void insertShybbf(OpGhmx msghmx);

	/**
	 * 删除挂号明细
	 *
	 * @param ssbxh
	 */
	void deleteBySbxh(String ssbxh);

	/**
	 * 更新汇总时间
	 *
	 * @param parameters
	 */
	void doUpdateHzrq(Map<String, Object> parameters);

	/**
	 * 汇总时间置空
	 *
	 * @param parameters
	 */
	void updateHzrqToNull(String hzrq,int mzlb,int jgid);

	/**
	 * 发票张数和总计金额
	 *
	 * @param parametersUser
	 * @return
	 */
	List<Map<String, Object>> doQueryFpzsAndZjje(Map<String, Object> parametersUser);

	/**
	 * 查询数量
	 *
	 * @param parametersUser
	 * @return
	 */
	Map<String, Object> doQueryCountByCondition(Map<String, Object> parametersUser);

	/**
	 * @name: updateYsdmByJzlsh
	 * @description: 根据就诊流水号更新医生代码
	 * @param jzlsh
	 * @param ysdm
	 * @return: void
	 * @date: 2020/9/7 17:44
	 * @auther: 朱智
	 *
	 */
	void updateYsdmByJzlsh(@Param("jzlsh") String jzlsh, @Param("ysdm") Integer ysdm);

	/**
	 * 货币误差
	 *
	 * @param parameters
	 * @return
	 */
	BigDecimal doQueryHbwcByDay(Map<String, Object> parameters);

	/**
	 * 根据时间查询范围内的退号号码
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryZfFphm(Map<String, Object> parameters);

	/**
	 * 条件查询GHMX
	 *
	 * @param opGhmx
	 * @return
	 */
	OpGhmx getByConditions(OpGhmx opGhmx);


	/**
	 * 判断能否退号退费
	 *
	 * @param parma
	 * @param type
	 * @param jgid
	 * @return Integer
	 */
	Boolean checkRefund(String parma, String type, Integer jgid);


	/**
	 * 通过主键修改挂号表状态
	 * @param ghxh
	 */
	void updateJzztBySbxh(Integer ghxh,Integer jzzt);


	/**
	 * 判断科室是否为儿科科室
	 * @param ghks
	 * @return
	 */
	Integer sfekks(@Param("ghks") Integer ghks);

	/**
	 * 查询挂完号未来就诊的挂号数据(查询三天未就诊的数据)
	 * @param currentDate
	 * @return
	 */
	List<OpGhmx> getwjz(Timestamp currentDate,String day);

	OpGhks getGhKsByGhmx(OpGhmxInfo opGhmxInfo);

	void doUpdateJzrqByRb(String jzksrq,String jzjsrq,int mzlb,int jgid,int czgh);
	void doUpdateThJzrqByRb(String jzksrq,String jzjsrq,int mzlb,int jgid,int czgh);
	void updateHzrq(String hzksrq,String hzjsrq,int mzlb,int jgid);
	void updateThHzrq(String hzksrq,String hzjsrq,int mzlb,int jgid);
	void updateThHzrqToNull(String hzrq,int mzlb,int jgid);

	/**
	 * 挂号发票获取医保相关信息
	 * @param sbxh
	 * @return
	 */
	List<Map<String,Object>> queryGhybxx(long sbxh);
}
