package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.GhrbReport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface GhrbReportDao extends EntityDao<GhrbReport, Integer> {

	/**
	 * 获取报表数据
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getParameters(Map<String, Object> map);

	/**
	 * 挂号工作量统计
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> getCountWorksFields(Map<String, Object> parameters);

}
