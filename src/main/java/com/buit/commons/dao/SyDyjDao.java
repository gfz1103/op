package com.buit.commons.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.SyDyj;
import com.buit.commons.response.SyDyjResp;

/**
 * 打印机<br>
 * 
 * @author WY
 */
@Mapper
public interface SyDyjDao extends EntityDao<SyDyj, Integer> {

	/**
	 * 输液瓶贴打印机列表
	 * 
	 * @param ksdm
	 * @return
	 */
	List<SyDyjResp> doQuerySyptdyj(Integer ksdm, Integer jgid);

	/**
	 * 输液巡回单打印机列表
	 * 
	 * @param ksdm
	 * @param jgid
	 * @return
	 */
	List<SyDyjResp> doQuerySyxhddyj(Integer ksdm, Integer jgid);

	/**
	 * 查询瓶贴打印机数量
	 * 
	 * @param syDyj
	 * @return
	 */
	Integer doQuerySyptdyjCount(SyDyj syDyj);

	/**
	 * 查询巡回单打印机数量
	 * 
	 * @param syDyj
	 * @return
	 */
	Integer doQuerySyxhddyjCount(SyDyj syDyj);

}
