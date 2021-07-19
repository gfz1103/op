package com.buit.commons.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpKspb;
import com.buit.commons.response.OpZblbResp;
import org.apache.ibatis.annotations.Param;

/**
 * 门诊_科室排班<br>
 * 
 * @author wangyang
 */
@Mapper
public interface OpKspbDao extends EntityDao<OpKspb, Timestamp> {
	/**
	 * 科室排班分页查询
	 * 
	 * @param opKspb
	 * @return
	 */
	List<OpKspb> getKspbList(OpKspb opKspb);

	/**
	 * 根据条件删除科室排班信息
	 * 
	 * @param opKspb
	 */
	void delKspbByCondition(OpKspb opKspb);

	/**
	 * 条件查询科室排班列表
	 * 
	 * @param opKspb
	 * @return
	 */
	List<OpKspb> getDeptList(OpKspb opKspb);

	/**
	 * 查询当日排班的科室和就诊序号
	 * 
	 * @param opKspb
	 * @return
	 */
	List<OpKspb> getCurrentKspbList(OpKspb opKspb);

	/**
	 * //清当前班次的科室排班中的就诊序号,已挂人数和预约人数
	 * 
	 * @param opKspb
	 */
	void initKspb(OpKspb opKspb);

	/**
	 * 退号更新排班表已挂人数和就诊序号
	 * 
	 * @param map
	 */
	void updateByTh(Map<String, Object> map);

	/**
	 * 就诊序号加1
	 *
	 * @param map
	 * @return
	 */
	Map<String, Object> getJzxhIncrease(Map<String, Object> map);

	/**
	 * 挂号时更新已挂人数、就诊序号
	 *
	 * @param map
	 */
	void updateYgrsAndJzxh(Map<String, Object> map);

	/**
	 * 科室排班分页查询
	 *
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getYyKspbList(Map<String, Object> map);

	/**
	 * 批量插入科室排班
	 * 
	 * @param opKspbList
	 */
	void insertForEach(List<OpKspb> list);

	/**
	 * 根据日期查询排班信息
	 * 
	 * @param kspbToday
	 * @return
	 */
	List<OpKspb> doQueryKspbByDate(OpKspb kspbToday);

	/**
	 * 挂号时更新已挂人数、就诊序号
	 *
	 * @param map
	 */
	void lessYgrsAndJzxh(Map<String, Object> map);

	/**
	 * 查询当前科室排了哪些值班类别
	 * 
	 * @param kspb
	 * @return
	 */
	List<OpZblbResp> doValidKspbZblb(OpKspb kspb);
}
