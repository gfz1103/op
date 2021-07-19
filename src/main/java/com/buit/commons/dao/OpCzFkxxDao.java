package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import com.buit.commons.request.OpCzFkxxReq;
import com.buit.commons.response.MpiKpxxPrintFpResp;
import com.buit.commons.response.OpCzFkxxResp;
import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpCzFkxx;

/**
 * 充值_充值收费付款信息<br>
 * 
 * @author WY
 */
@Mapper
public interface OpCzFkxxDao extends EntityDao<OpCzFkxx, Integer> {

	/**
	 * 充值付款信息
	 * 
	 * @param parameter
	 * @return
	 */
	List<Map<String, Object>> doQueryCzFkxx(Map<String, Object> parameter);

	/**
	 * 充值付款信息fields
	 * 
	 * @param parameter
	 * @return
	 */
	List<Map<String, Object>> doQueryCzrbFields(Map<String, Object> parameter);

    List<OpCzFkxxResp> doQueryCzFkxxList(OpCzFkxxReq opCzFkxxReq);

	MpiKpxxPrintFpResp doPrintFpxx(Integer jlxh);
}
