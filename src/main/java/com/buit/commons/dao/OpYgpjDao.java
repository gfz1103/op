package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpYgpj;

/**
 * 门诊_门诊员工票据<br>
 * 
 * @author WY
 */
@Mapper
public interface OpYgpjDao extends EntityDao<OpYgpj, Integer> {
	/**
	 * 判断所有号码是否重复
	 * 
	 * @param opYgpj
	 * @return
	 */
	Integer doInvoiceNumberValid(OpYgpj opYgpj);

	/**
	 * 判断号码段是否冲突
	 * 
	 * @param opYgpj
	 * @return
	 */
	Integer doNumberRangeValidOne(OpYgpj opYgpj);

	/**
	 * 判断号码段是否冲突
	 * 
	 * @param opYgpj
	 * @return
	 */
	Integer doNumberRangeValidTwo(OpYgpj opYgpj);

	/**
	 * 查询记录序号
	 * 
	 * @param jgid
	 * @param ygdm
	 * @param pjlx
	 * @return
	 */
	Integer getJlxhCount(@Param("jgid") Integer jgid, @Param("ygdm") Integer ygdm, @Param("pjlx") Integer pjlx);

	/**
	 * 获取第一位使用号码
	 * 
	 * @param jgid
	 * @param ygdm
	 * @param pjlx
	 * @return
	 */
	List<OpYgpj> getFirstSyhm(@Param("jgid") Integer jgid, @Param("ygdm") Integer ygdm,
			@Param("pjlx") Integer pjlx);

	/**
	 * 根据记录号更新号码
	 * 
	 * @param syhm
	 * @param zzhm
	 * @param jlxh
	 * @param sypb
	 */
	void updateHm(@Param("syhm") String syhm, @Param("zzhm") String zzhm, @Param("jlxh") Integer jlxh,
			@Param("sypb") Integer sypb, @Param("jqpb") Integer jqpb);

	/**
	 * 使用号码加1
	 * 
	 * @param map
	 */
	void updateSyhm(Map<String, Object> map);

	/**
	 * 查询票据信息
	 * 
	 * @param opYgpj
	 * @return
	 */
	List<OpYgpj> getYgpjInfo(OpYgpj opYgpj);

	Integer checkSypb(Integer ygdm, Integer jlxh, Integer pjlx, Integer jgid);

}
