package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpSfmx;
import com.buit.commons.response.MzfpSfxmResp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 门诊_收费明细表<br>
 * 
 * @author WY
 */
@Mapper
public interface OpSfmxDao extends EntityDao<OpSfmx, Integer> {

	/**
	 * 查询收费项目
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQuerySfxmByCondition(Map<String, Object> parameters);

    void updateFphmByMzxh(String cdFphm, Integer ysMzxh);

    List<MzfpSfxmResp> queryDyInfo(Integer mzxh);
}
