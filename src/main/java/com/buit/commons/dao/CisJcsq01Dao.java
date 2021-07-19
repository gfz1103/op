package com.buit.commons.dao;

import com.buit.apply.request.CisJcsq01QueryReq;
import com.buit.apply.request.QueryAuxiliaryJcReportListReq;
import com.buit.apply.request.YjyySaveReq;
import com.buit.apply.response.CisJcsq01PageResp;
import com.buit.apply.response.CisJcsq01QueryResp;
import com.buit.apply.response.LoadPatientInfoResp;
import com.buit.apply.response.QueryAuxiliaryJcReportListResp;
import com.buit.commons.EntityDao;
import com.buit.commons.model.CisJcsq01;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 检查申请单<br>
 *
 * @author 老花生
 */
@Mapper
public interface CisJcsq01Dao extends EntityDao<CisJcsq01, Integer> {

	/**
	 * 检查申请单数量
	 *
	 * @param jc01Params
	 * @return
	 */
	Long getJcSqdCount(Map<String, Object> jc01Params);

	/**
	 * 按条件查询方法门诊
	 *
	 * @param req
	 * @return
	 */
	List<CisJcsq01PageResp> findByEntityMz(Map req);

	/**
	 * 按条件查询方法住院
	 *
	 * @param req
	 * @return
	 */
	List<CisJcsq01PageResp> findByEntityZy(Map req);

	/**
	 * 门诊或住院医技预约保存
	 *
	 * @param req
	 */
	void updateAppointment(YjyySaveReq req);

	/**
	 * 医技取消(门诊或者住院)
	 *
	 * @param jcxh
	 */
	void cancelYjMzOrZy(@Param("jcxh") Integer jcxh);

	/**
	 * 医技取消(体检)
	 *
	 * @param jcxh
	 */
	void cancelYjTj(@Param("jcxh") Integer jcxh);

	/**
	 * 更新检查状态
	 *
	 * @author wy
	 * @param map
	 */
	void updateJczt(Map<String, Object> map);

	/**
	 * 根据检查序号更新检查状态
	 *
	 * @author wy
	 * @param map
	 */
	void updateJcztByJcxh(Map<String, Object> map);

	/**
	 * 医嘱删除检查 @Title: deleteInspectByJlxh @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param jlxh 设定文件 @return void 返回类型 @author
	 * 龚方舟 @throws
	 */
	void deleteInspectByJlxh(Long jlxh);

	/**
	 * 查询诊间医技预病人信息-门诊
	 *
	 * @param searchValue
	 * @return
	 */
	List<LoadPatientInfoResp> loadPatientInfoMz(@Param("searchType") Integer searchType,
												@Param("searchValue") String searchValue);

	/**
	 * 查询诊间医技预病人信息-住院
	 *
	 * @param searchValue
	 * @return
	 */
	List<LoadPatientInfoResp> loadPatientInfoZy(@Param("searchValue") String searchValue);

	/**
	 * 查询诊间医技预病人信息-体检
	 *
	 * @param searchValue
	 * @return
	 */
	List<LoadPatientInfoResp> loadPatientInfoTj(@Param("searchValue") String searchValue);

	/**
	 * 根据检查序号删除
	 *
	 * @param map
	 */
	void deleteByJcxh(Map<String, Object> map);

	/**
	 * 查询检查申请单集合
	 *
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> queryJcsqdList(Map<String, Object> param);

	/**
	 * 查询门诊病人信息
	 *
	 * @param jzxh
	 * @return
	 */
	Map<String, Object> queryMzBrxx(Integer jzxh);

	/**
	 * 查询住院病人信息
	 *
	 * @param zthm
	 * @return
	 */
	Map<String, Object> queryZyBrxx(String zthm);

	/**
	 * 查询体检病人信息
	 *
	 * @param tjbh
	 * @return
	 */
	Map<String, Object> queryTjBrxx(String tjbh);

	/**
	 * 住院检查申请单查询 @Title: queryZyJcSqdList @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param cisJcsq01QueryResp @param @return
	 * 设定文件 @return List<CisJcsq01QueryResp> 返回类型 @author 龚方舟 @throws
	 */
	List<CisJcsq01QueryResp> queryZyJcSqdList(CisJcsq01QueryReq cisJcsq01QueryReq);

	/**
	 * @name: queryMzPrintInfo
	 * @description: 门诊打印信息
	 * @param parameters
	 * @return: java.util.Map<java.lang.String,java.lang.Object>
	 * @date: 2020/8/27 19:08
	 * @auther: 老花生
	 *
	 */
	Map<String, Object> queryMzPrintInfo(Map<String, Object> parameters);

	/**
	 * @name: queryZyPrintInfo
	 * @description: 住院打印信息
	 * @param parameters
	 * @return: java.util.Map<java.lang.String,java.lang.Object>
	 * @date: 2020/8/27 19:08
	 * @auther: 老花生
	 *
	 */
	Map<String, Object> queryZyPrintInfo(Map<String, Object> parameters);

	/**
	 * 根据医技序号修改检查状态
	 *
	 * @param mapPar
	 */
	void updateJcztByYjxh(Map<String, Object> mapPar);

	/**
	 * @name: queryAuxiliaryJcReportList
	 * @description: 辅助报告检查列表
	 * @param req
	 * @return: java.util.List<com.buit.cis.op.dctwork.response.QueryAuxiliaryJcReportListResp>
	 * @date: 2020/9/4 9:35
	 * @auther: 朱智
	 *
	 */
	List<QueryAuxiliaryJcReportListResp> queryAuxiliaryJcReportList(QueryAuxiliaryJcReportListReq req);

	/**
	 * 根据医技序号修改检查状态
	 *
	 * @param mapPar
	 */
	void updateJcztByOneYjxh(Map<String, Object> mapPar);

	/**
	 * 根据住院号查询检查申请
	 * @param zyh
	 * @return
	 */
	List<QueryAuxiliaryJcReportListResp> queryApiPacsReportList(Integer zyh);
}
