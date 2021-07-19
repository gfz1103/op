package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.response.OpYsJzlsListResp;
import com.buit.op.model.OpYsJzls;
import com.buit.op.model.mphis.request.MphisFzypRequest;
import com.buit.op.model.mphis.request.MphisJzxxjyRequest;
import com.buit.op.model.mphis.response.MphisJzzpdResponse;
import com.buit.op.response.MpiBrda;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * 门诊_就诊历史<br>
 * @author 老花生
 */
@Mapper
public interface OpYsJzlsDao extends EntityDao<OpYsJzls,Integer> {

    /**
     * 删除根据就诊序号
     * @param params
     */
    void deleteByjzxh(Map<String, Object> params);

    /**
     * 更新就诊状态、结束时间
     * @param params
     */
    void updateJzztJssj(Map<String, Object> params);

    /**
     * 更新就诊状态、结束时间、医生代码
     * @param params
     */
    void updateJzztJssjYsdm(Map<String, Object> params);

	/**
	 * 查询jzxh信息
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	public Map<String, Object> getJzxhInfo(Map<String, Object> map);

	/**
	 * 更新就诊状态、科室代码
	 * @param record
	 */
    void updateJzztKsdm(Map<String, Object> record);

	/**
	 * 更新就诊状态、科室代码、医生代码
	 * @param record
	 */
	void updateJzztKsdmYsdm(Map<String, Object> record);

	List<OpYsJzlsListResp> queryJzls(OpYsJzls query);

	/**
	 * 互联网医院复诊预判
	 * @param request
	 * @return
	 */
	int fzyp(MphisFzypRequest request);

	/**
	 * 查询就诊状态
	 * @param jzlsh
	 * @return
	 */
	MphisJzzpdResponse queryJzzt(@Param("jzlsh") String jzlsh);

	/**
	 * 查询指定日期前一天未结束的就诊数据
	 * @param currentDate
	 * @return
	 */
	List<OpYsJzls> queryYsZljl(Timestamp currentDate);

	/**
	 * 更新结束就诊时间和状态
	 * @param opYsJzls
	 */
	void updatejssjAndZt(OpYsJzls opYsJzls);

	MpiBrda getWnJzls(MphisJzxxjyRequest request);
}
