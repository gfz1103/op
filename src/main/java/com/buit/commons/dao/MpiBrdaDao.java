package com.buit.commons.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.buit.op.model.mphis.request.MphisJzxxjyRequest;
import com.buit.op.request.PacsGetHisPatientInfoRequest;
import com.buit.op.response.PacsGetHisPatientInfoResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.commons.model.MpiBrdaInfo;
import com.buit.commons.model.OpGhmxInfo;
import com.buit.op.response.MpiBrda;

/**
 * 门诊_病人档案<br>
 * 
 * @author yueyu
 */
@Mapper
public interface MpiBrdaDao extends EntityDao<MpiBrda, Integer> {

	/**
	 * 根据brid/mzhm获取病人性质
	 * 
	 * @author wy
	 * @param brid
	 * @return
	 */
	MpiBrdaInfo getBrxzInfo(@Param("brid") Integer brid, @Param("mzhm") String mzhm);

	/**
	 * 根据条件查询病人档案
	 * 
	 * @author wy
	 * @param ghmx
	 * @return
	 */
	MpiBrda getByCondition(OpGhmxInfo ghmx);

	/**
	 * 根据条件更改病人性质
	 * 
	 * @author wy
	 * @param brxz
	 * @param brid
	 */
	void updateBrxz(@Param("brxz") Integer brxz, @Param("brid") Integer brid);

	/**
	 * 根据个人编号查询门诊代码
	 * 
	 * @param grbh
	 * @return
	 */
	String getMzhmByGrbh(String grbh);

	/**
	 * 根据卡号和病人id查询病人档案信息
	 * 
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getBrdaInfo(Map<String, Object> map);

	/**
	 * 更新病人档案信息
	 * 
	 * @author wy
	 * @param mpiBrda
	 */
	void updateBrdaInfo(MpiBrda mpiBrda);

	/**
	 * 更新 联系人地址 联系人电话 联系人姓名
	 * 
	 * @param brda
	 */
	void updateLxdzLxdhLxRm(MpiBrda brda);

	/**
	 * 查询退费病人信息
	 * 
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getTfPersonInfo(Map<String, Object> map);

	/**
	 * 通过病人id跟医疗机构id查询病人档案信息
	 * 
	 * @param brid
	 * @param jgid
	 * @return
	 */
	MpiBrda getByBrid(@Param("brid") Integer brid, @Param("jgid") Integer jgid);

	/**
	 * 查询就诊卡信息,优先查找医保
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> getCardInfo(Map<String, Object> parameters);

	/**
	 * 根据cfsb查询病人信息
	 * 
	 * @param cfsb
	 * @return
	 */
	MpiBrda getbyCfsb(@Param("cfsb") Integer cfsb);

	/**
	 * 根据条件更改病人大病标志
	 *
	 * @author bjh
	 * @param brid
	 * @param dbtype
	 */
	void updateDbbz(Integer brid, String dbtype);

	/**
	 * 查询工伤大病标识
	 * 
	 * @author beijunhua
	 * @param brid
	 * @return
	 */
	List<Map<String, Object>> getGsDb(Integer brid);

	/**
	 * 挂号管理分诊病人信息调入
	 * 
	 * @param lsh
	 * @param kh
	 */
	void updateLshByJzkh(Integer lsh, String jzkh);

	/**
	 * 根据条件更改病人工伤认定号
	 *
	 * @author bjh
	 * @param brid
	 * @param gsrdh
	 */
	void updateGsrdh(String brid, String gsrdh);

    MpiBrda getWnBrdaInfo(MphisJzxxjyRequest request);

	MpiBrda getBySfzh(MphisJzxxjyRequest request);

	List<PacsGetHisPatientInfoResponse> getHisPatientInfo(PacsGetHisPatientInfoRequest req);

	List<MpiBrda> getBrdaByName(String name, Date csny, Integer brxb);
}
