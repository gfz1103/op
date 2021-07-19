package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpMzlb;

import org.apache.ibatis.annotations.Param;

/**
 * 门诊_门诊类别<br>
 * 
 * @author WY
 */
@Mapper
public interface OpMzlbDao extends EntityDao<OpMzlb, Integer> {

	/**
	 * 获取门诊类别
	 * 
	 * @param jgid
	 * @param ip
	 * @return
	 */
	Integer getMzlb(@Param("jgid") Integer jgid, @Param("ip") String ip);

	/**
	 * 获得医保机构ID
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> getYbjgid(Map<String, Object> map);

	/**
	 * 根据门诊类别查询医保IP
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getYbIp(Map<String, Object> map);

	/**
	 * 根据ip查询医保机构代码
	 *
	 * @param jgid,ip
	 * @return
	 */
	Map<String, Object> getYbjgdm(Integer jgid,String ip);

	/**
	 * 根据门诊类别查询医保名称
	 * @param mzlb
	 * @return
	 */
	long findYbmcCount(String mzlb);

	Map<String,Object> getYbmc(String mzlb);

	List<Map<String,Object>> getMxzd(Map<String,Object> paramMap);

}
