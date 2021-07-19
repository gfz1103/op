package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpRbmx;
import com.buit.commons.model.OpRbmxSfmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 门诊_收费日报明细<br>
 * 
 * @author WY
 */
@Mapper
public interface OpRbmxDao extends EntityDao<OpRbmx, String> {

	/**
	 * 条件删除
	 * 
	 * @param parameters
	 */
	void doDeleteByCondition(Map<String, Object> parameters);

	/**
	 * 日报明细金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryRbmxje(Map<String, Object> parameters);

	/**
	 * 收费项目
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySfxmJe(Map<String, Object> parameters);

	void insertRbmxsfmx(OpRbmxSfmx OpRbmxSfmx);

	void doDeleteRbmxByJzrq(String jzrq,int mzlb,int jgid,int czgh);
	void doDeleteByRbmxsfxmxJzrq(String jzrq,int mzlb,int jgid,int czgh);

	void updateHzrq(String hzksrq,String hzjsrq,int mzlb,int jgid);
	void updateHzrqToNull(String hzrq,int mzlb,int jgid);

	List<Map<String ,Object>> doQueryHzCount(String hzksrq,String hzjsrq,int jgid,int mzlb);
}
