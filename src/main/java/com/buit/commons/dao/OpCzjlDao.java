package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.response.OpCzjlResp;
import com.buit.op.model.OpCzjl;

/**
 * 充值卡操作记录<br>
 * 
 * @author WY
 */
@Mapper
public interface OpCzjlDao extends EntityDao<OpCzjl, Integer> {

	/**
	 * 查询余额
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAmount(Map<String, Object> map);

	/**
	 * 查询操作记录
	 * 
	 * @param opCzjl
	 * @return
	 */
	List<OpCzjlResp> doQueryCzjlList(OpCzjl opCzjl);

	/**
	 *
	 * @param fphm
	 * @return
	 */
	List<Map<String, Object>> queryCzjlDyfp(String fphm);
}
