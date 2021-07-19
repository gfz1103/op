package com.buit.commons.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import cn.hutool.core.date.DateTime;
import com.buit.commons.request.QueryRegisteredReq;
import com.buit.commons.response.*;
import com.buit.his.op.reg.response.YyglResp;
import com.buit.op.model.mphis.entity.*;
import com.buit.op.model.mphis.response.MphisGhysResponse;
import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpGhks;
import com.buit.commons.model.OpGhksOffice;
import com.buit.utill.ParamUtil;
import org.apache.ibatis.annotations.Param;

/**
 * 门诊_挂号科室<br>
 *
 * @author WY
 */
@Mapper
public interface OpGhksDao extends EntityDao<OpGhks, Integer> {

	/**
	 * 判断当前科室是否已被分配业务权限
	 *
	 * @param ksdm
	 * @return
	 */
	Integer isAuth(Integer ksdm);

	/**
	 * 挂号科室维护新增或修改时门诊列表
	 *
	 * @param hospitalId
	 * @return
	 */
	List<OpGhksOffice> getMzksList(Integer hospitalId);

	/**
	 * 次进入挂号页面初始化已挂人数和预约人数
	 *
	 * @param jzxh
	 * @param ygrs
	 * @param yyrs
	 * @param jgid
	 * @param ksdm
	 */
	void initGhrs(@Param("jzxh") Integer jzxh, @Param("ygrs") Integer ygrs, @Param("yyrs") Integer yyrs,
			@Param("jgid") Integer jgid, @Param("ksdm") Integer ksdm);

	/**
	 * 查询未排班的科室
	 *
	 * @param ghrq
	 * @param zblb
	 * @param jgid
	 * @param beginOfDay
	 * @param endOfDay
	 * @return
	 */
	List<OpGhks> getGhksNoPb(@Param("ghrq") Timestamp ghrq,
									@Param("zblb") String zblb,
									@Param("jgid") Integer jgid,
									@Param("beginOfDay") Timestamp beginOfDay,
									@Param("endOfDay") Timestamp endOfDay,
									@Param("internet") String internet);

	/**
	 * 根据预约标识查询科室列表
	 *
	 * @param jgid
	 * @param mzlb
	 * @param ghrq
	 * @param zblb
	 * @param beginOfDay
	 * @param endOfDay
	 * @return
	 */
	List<OpGhks> getGhksListByYyTagOne(@Param("jgid") Integer jgid,
											  @Param("mzlb") Integer mzlb,
											  @Param("ghrq") Timestamp ghrq,
											  @Param("zblb") String zblb,
											  @Param("beginOfDay") Timestamp beginOfDay,
											  @Param("endOfDay") Timestamp endOfDay,
											  @Param("jzmz") Integer jzmz,
											  @Param("dbtype") String dbtype,
											  @Param("internet") String internet);

	/**
	 * 根据预约标识查询科室列表
	 *
	 * @param jgid
	 * @param mzlb
	 * @param ghrq
	 * @param zblb
	 * @param beginOfDay
	 * @param endOfDay
	 * @return
	 */
	List<OpGhks> getGhksListByYyTagTwo(@Param("jgid") Integer jgid,
											  @Param("mzlb") Integer mzlb,
											  @Param("ghrq") Timestamp ghrq,
											  @Param("zblb") String zblb,
											  @Param("beginOfDay") Timestamp beginOfDay,
											  @Param("endOfDay") Timestamp endOfDay,
											  @Param("jzmz") Integer jzmz,
											  @Param("internet") String internet);

	/**
	 * 退号更新已挂人数
	 *
	 * @param map
	 */
	void updateYgrs(Map<String, Object> map);

	/**
	 * 挂号时更新已挂人数、预约人数
	 *
	 * @param map
	 */
	void updateYgrsAndYyrs(Map<String, Object> map);

	/**
	 * 挂号时更新已挂人数、就诊序号
	 *
	 * @param map
	 */
	void updateYgrsAndJzxh(Map<String, Object> map);

	/**
	 * 转科已挂人数加1
	 *
	 * @param map
	 */
	void updateYgrsAdd(Map<String, Object> map);

	/**
	 * 查询老科室代码
	 *
	 * @param put
	 * @return
	 */
	Map<String, Object> getOldKsdm(ParamUtil put);

	/**
	 * 更新预约人数
	 *
	 * @param saveInformation
	 */
	void updateYyrs(Map<String, Object> saveInformation);

	/**
	 * 获取门诊科室和科室代码列表
	 *
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getMzksAndKsdm(Map<String, Object> map);

	/**
	 * 预约管理-查询
	 *
	 * @param parameters
	 */
	List<YyglResp> yyglQuery(Map<String, Object> parameters);

	/**
	 * 查询科室收费
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> checkKsfy(Map<String, Object> map);

	/**
	 * 获取挂号科室对应的门诊科室
	 *
	 * @param jgid
	 * @return
	 */
	List<QueryOfficeCodeResp> doQueryOfficeCode(Integer jgid);

	/**
	 * 挂号查询
	 *
	 * @param map
	 * @return
	 */
//	List<Map<String, Object>> doRegisteredQuery(Map<String, Object> map);
	List<QueryRegisteredResp> doRegisteredQuery(QueryRegisteredReq req);

	/**
	 * 患者档案登记
	 *
	 * @param jzkh
	 * @param jgid
	 * @return
	 */
	List<QueryBrdaListResp> doQueryList(String jzkh, Integer jgid);

	/**
	 * 科室名称 科室位置
	 *
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryKsmcAndKswz(Map<String, Object> parameters);

	/**
	 * 更新挂号科室
	 *
	 * @param map
	 */
	void lessYgrsAndJzxh(Map<String, Object> map);

	/**
	 * 查询是否工伤
	 *
	 * @param ksdm
	 * @return
	 */
	Map<String, Object> getSfgs(String ksdm, Integer jgid);

	/**
	 * 判断当日上下午挂号限额
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQueryGhxeByDay(Map<String, Object> parameters);

	/**
	 * @name: queryWaitMs
	 * @description: 查询待选择挂号科室信息
	 * @param opMzzs
	 * @return: java.util.List<com.buit.his.op.reg.model.OpGhks>
	 * @date: 2020/9/16 15:35
	 * @auther: 朱智
	 *
	 */
	List<OpGhks> queryWaitMs(OpGhks opMzzs);

	/**
	 * @name: changeFwtId
	 * @description: 根据zsid集合更新服务台id
	 * @param fwtid
	 * @param ksdmList
	 * @return: void
	 * @date: 2020/9/4 14:25
	 * @auther: 朱智
	 *
	 */
	void changeFwtId(@Param("fwtid") Integer fwtid, @Param("ksdmList") List<Integer> ksdmList);

	/**
	 * 挂号管理查询分诊病人信息
	 *
	 * @param jzkh
	 * @param brxm
	 * @param jgid
	 * @param fzrq
	 * @param beginOfDay
	 * @param endOfDay
	 * @return
	 */
	List<QueryYjfzbrResp> doQueryYjfzbrInfo(@Param("jzkh") String jzkh, @Param("brxm") String brxm,
			@Param("jgid") Integer jgid, @Param("fzrq") Date fzrq, @Param("beginOfDay") Timestamp beginOfDay,
			@Param("endOfDay") Timestamp endOfDay);

	 List<PubBrxzsResp> doQueryBrxzInfo();

	List<OpGhks> getInternetGhks(@Param("jgid") Integer jgid, String keyword);

	List<MphisGhysResponse> getInternetGhksPersonnel(@Param("ksdm") Integer ksdm, @Param("jgid") Integer jgid, String keyword);

	List<MphisGhysResponse> getGhysList(@org.apache.ibatis.annotations.Param("ysdm") List<Integer> ysdms);

	String isInternet(Integer mzks);


	/**
	 * 医院字典(监管上报)
	 */
	List<TbDicHospital> yyzd(Integer jgid);

	/**
	 * 科室字典(监管上报)
	 */
	List<TbDicDepartment> kszd(Integer jgid);

	/**
	 * 医务人员字典(监管上报)
	 */
	List<TbDicPractitioner> ywryzd(Integer jgid);
	/**
	 * 药品信息(监管上报)
	 */
	List<TbDicMedicines> ypxx(Integer jgid);

	/**
	 * 互联网医院业务量统计 (监管上报)
	 */
	List<TbTjHlwyyYwl> ywltj(Integer jgid, DateTime dateTime);

	/**
	 * 互联网医院业务收入统计 (监管上报)
	 */
	List<TbTjHlwyyYwsr> ywsrtj(Integer jgid,  DateTime dateTime);

	/**
	 * 互联网服务收费表 (监管上报)
	 */
	List<TbYlHlwyyFwsf> fwsf(Integer jgid,  DateTime dateTime);

	/**
	 * 互联网服务收费明细表 (监管上报)
	 */
	List<TbYlHlwyyFwsfmx> fwsfmx(Integer jgid,  DateTime dateTime);

	/**
	 * 互联网电子医嘱信息 (监管上报)
	 */
	List<TbYlDzyzxx> dzyzxx(Integer jgid,  DateTime dateTime);

	/**
	 * 互联网电子处方明细 (监管上报)
	 */
	List<TbYlDzcfmx> dzcfmx(Integer jgid,  DateTime dateTime);

	/**
	 * 挂号单信息 (监管上报)
	 */
	List<TbYlGhdxx> ghdxx(Integer jgid,  DateTime dateTime);

	/**
	 * 在线复诊记录 (监管上报)
	 */
	List<TbYlZxfzjl> zxfzjl(Integer jgid,  DateTime dateTime);

	/**
	 * 药品配送信息 (监管上报)
	 */
	List<TbYlYppsxx> yppsxx(Integer jgid,  DateTime dateTime);

    List<Integer> getXxKsdmList(Integer ksdm);

    Boolean checkZyhz(String jzkh);

    Integer checkGhksInfo(String ksmc, Integer mzks, Integer ksdm);
}
