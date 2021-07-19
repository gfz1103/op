package com.buit.commons.dao;


import com.buit.commons.EntityDao;
import com.buit.commons.model.OpBrzd;
import com.buit.commons.request.OpBrzdSaveReq;
import com.buit.commons.response.OpBrzdPatientResp;
import com.buit.commons.response.OpBrzdResp;
import com.buit.commons.response.OpYsJzlsListResp;
import com.buit.op.response.BrzdDto;
import com.buit.op.response.BrzdResp;
import com.buit.op.response.EmrBrzdResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 门诊_病人诊断<br>
 * @author 老花生
 */
@Mapper
public interface OpBrzdDao extends EntityDao<OpBrzd,Integer> {

    /**
     * 自定义查询
     * @param brzd  请求参数
     * @return
     */
    List<OpBrzdResp> customQuery(OpBrzd brzd);

    /**
     * 查询患者诊断
     * @param brzd  请求参数
     * @param brzd
     * @return
     */
    List<OpBrzdPatientResp> patientDiagnosis(OpBrzd brzd);

    /**
     * 根据病人ID、就诊序号删除记录
     * @param req
     */
    void deleteByBridJzxh(OpBrzdSaveReq req);

    /**
     * 根据就诊序号集合查询相应诊断
     * @param list
     */
    List<Map<String, Object>> queryBrzdListByJzxhList(@Param("list") List<OpYsJzlsListResp> list);

    /**
     * @name: queryBrzdByJzxh
     * @description: 根据就诊序号查询病人诊断
     * @param jzxh
     * @return: java.util.List<java.lang.String>
     * @date: 2020/8/27 19:56
     * @auther: 老花生
     *
     */
    List<String> queryBrzdByJzxh(@Param("jzxh") String jzxh);

    /**
     * 医保查询患者诊断
     * @param parmjzxh  请求参数
     * @param parmjzxh
     * @return
     */
    List<Map<String, Object>> getZd(Map<String,Object> parmjzxh);
    /**
     * 医保就诊流水号查询患者诊断
     * @param JZLSH  请求参数
     * @return
     */
    List<Map<String, Object>> getZdForSf(String JZLSH);
	/**
	 * 判断是否开诊断
	 *
	 * @param jzlsh
	 * @return
	 */
	Integer doQueryCountByJzlsh(String jzlsh);

    /**
     * 查询病人诊断
     * */
    List<BrzdDto> queryBrzdDtoByJzxh(@Param("jzxh") Integer jzxh);

    /**
     * 根据就诊流水号，查询诊断名称
     * @param jzlsh
     * @return
     */
    List<EmrBrzdResp> getZdmcByJzlsh(@Param("jzlsh") String jzlsh);

    /**
     * 通过就诊流水号查询诊断
     * @param jzlsh
     * @return
     */
    List<BrzdResp> getBrzdByJzlsh(@Param("jzlsh") String jzlsh);
}
