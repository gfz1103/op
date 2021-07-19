package com.buit.commons.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.buit.commons.dto.OpYspbZtDto;
import com.buit.op.model.mphis.response.MphisGhysPbDto;
import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpYspb;
import com.buit.commons.response.OpZblbResp;
import com.buit.commons.response.QueryYspbResp;
import org.apache.ibatis.annotations.Param;

/**
 * 门诊_门诊医生排班<br>
 * 
 * @author wangyang
 */
@Mapper
public interface OpYspbDao extends EntityDao<OpYspb, Timestamp> {
	/**
	 * 医生排班
	 * 
	 * @param opYspb
	 * @return
	 */
	List<OpYspb> getYspbList(OpYspb opYspb);

	/**
	 * 医生排班复制一周数据
	 * 
	 * @param list
	 */
	void insertForEach(List<OpYspb> list);

	/**
	 * 根据条件删除医生排班信息
	 * 
	 * @param opYspb
	 */
	void delYspbByCondition(OpYspb opYspb);

	/**
	 * 退号更新医生排班已挂人数
	 * 
	 * @param map
	 */
	void updateByTh(Map<String, Object> map);

	/**
	 * 挂号管理-医生排班列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getGhYspbList(Map<String, Object> map);

	/**
	 * 就诊序号加1
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> getJzxhIncrease(Map<String, Object> map);

	/**
	 * 挂号时更新已挂人数、预约人数
	 * 
	 * @param map
	 */
	void updateYgrs(Map<String, Object> map);

	/**
	 * 挂号时更新已挂人数、就诊序号
	 * 
	 * @param map
	 */
	void updateYgrsAndJzxh(Map<String, Object> map);

	/**
	 * 医生排班已挂人数减1
	 * 
	 * @param map
	 */
	void updateYgrsSub(Map<String, Object> map);

	/**
	 * 医生排班已挂人数加1
	 * 
	 * @param map
	 */
	void updateYgrsAdd(Map<String, Object> map);

	/**
	 * 更新预约人数
	 * 
	 * @param saveInformation
	 */
	void updateYyrs(Map<String, Object> saveInformation);

	/**
	 * 获取就诊人数、暂挂人数
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getHzrsAndZgrs(Map<String, Object> map);

	/**
	 * 查询专家是否排班
	 * 
	 * @param map
	 * @return
	 */
	Integer getZjPb(Map<String, Object> map);

	/**
	 * 查询医生排班
	 * 
	 * @param par
	 * @return
	 */
	List<QueryYspbResp> queryYspb(Map<String, Object> par);

	/**
	 * 查询医生特定科室特定时间的值班类别
	 * 
	 * @param opYspb
	 * @return
	 */
	List<OpZblbResp> doVaildYspbByZblb(OpYspb opYspb);

	List<MphisGhysPbDto> getInternetYspbByCondition(@Param("opYspb") OpYspb opYspb, Integer pageSize);

	List<OpYspbZtDto> countYspbToday(@Param("ysdm") List<Integer> ysdm);

	List<OpYspbZtDto> countYspbFuture(@Param("ysdm") List<Integer> ysdm);
}
