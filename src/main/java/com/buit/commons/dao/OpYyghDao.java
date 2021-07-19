package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpYygh;
import com.buit.commons.request.LoadAppointedInfoReq;
import com.buit.commons.request.ModifyAppointedInfoReq;
import com.buit.commons.request.OpYyghQueryReq;
import com.buit.commons.request.QueryYyksYsInfoReq;
import com.buit.commons.response.LoadAppointedInfoResp;
import com.buit.commons.response.OpYyghQueryResp;
import com.buit.commons.response.QueryYyksYsInfoResp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * 门诊_预约挂号<br>
 * 
 * @author WY
 */
@Mapper
public interface OpYyghDao extends EntityDao<OpYygh, Integer> {
	/**
	 * 将过期的预约挂号置标志2
	 * 
	 * @param jgid
	 * @param yyrq
	 */
	void updateGhbz(@Param("jgid") Integer jgid, @Param("yyrq") Timestamp yyrq);

	/**
	 * 根据条件获取已挂人数
	 * 
	 * @param opYygh
	 * @return
	 */
	Integer getYgrs(OpYygh opYygh);

	/**
	 * 根据条件获取预约人数
	 * 
	 * @param opYygh
	 * @return
	 */
	Integer getYyrs(OpYygh opYygh);

	/**
	 * 更新挂号标志和是否取号
	 * 
	 * @param map
	 */
	void updateGhbzAndSfqh(Map<String, Object> map);

	/**
	 * 获取等待次数和
	 * 
	 * @param map
	 * @return
	 */
	Integer getDdcs(Map<String, Object> map);

	/**
	 * 更新预约挂号信息
	 * 
	 * @param map
	 */
	void updateYyghInfo(Map<String, Object> map);

	/**
	 * 更新预约状态（收费）
	 * 
	 * @param map
	 */
	void updateYyStatus(Map<String, Object> map);

	/**
	 * 预约查询
	 * 
	 * @param opyygh
	 * @return
	 */
	List<OpYyghQueryResp> queryYyxx(OpYyghQueryReq opyygh);

	/**
	 * 查询预约信息
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getYyghInfo(Map<String, Object> map);

	/**
	 * 根据其他条件查询
	 * @param req
	 * @return
	 */
    List<LoadAppointedInfoResp> findByOtherEntity(LoadAppointedInfoReq req);

	/**
	 * 查询预约次数
	 * @param parameter
	 * @return
	 */
	Map<String, Object> getYyCount(Map<String, Object> parameter);

	/**
	 * 更改门诊预约信息
	 * @param req
	 */
	void updateMzYy(ModifyAppointedInfoReq req);


	/**
	 * @name: queryYyksYsInfo
	 * @description: 查询预约科室医生
	 * @param req
	 * @return: java.util.List<com.buit.cis.op.dctwork.response.QueryYyksYsInfoResp>
	 * @date: 2020/8/31 10:49
	 * @auther: 老花生
	 *
	 */
    List<QueryYyksYsInfoResp> queryYyksYsInfo(QueryYyksYsInfoReq req);
}
