package com.buit.commons.dao;

import com.buit.cis.op.dctwork.response.PubFyxzFyxzResp;
import com.buit.commons.EntityDao;
import com.buit.commons.model.PubFyxz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 公用_费用禁用<br>
 * @author ZHOUHAISHENG
 */
@Mapper
public interface PubFyxzDao extends EntityDao<PubFyxz,Integer>{

	/**
	 * 获取费用禁用信息
	 * @author wy
	 * @param pubFyxz
	 * @return
	 */
	Map<String, Object> getFyjyInfo(PubFyxz pubFyxz);

	/**
	 * 中心维护-病人性质-费用限制
	 * @param brxz 病人性质代码
	 * @return
	 */
	List<PubFyxzFyxzResp> queryFyxzList(@Param("brxz") Integer brxz, @Param("pydm") String pydm);

	/**
	 * 删除
	 * @param brxz
	 * @param fyxh
	 */
	void deleteById(@Param("brxz") Integer brxz, @Param("fyxh") Integer fyxh);

}
