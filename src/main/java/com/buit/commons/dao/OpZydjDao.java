package com.buit.commons.dao;

import com.buit.cis.op.dctwork.response.OpZydjPageResp;
import com.buit.commons.EntityDao;
import com.buit.commons.model.OpZydj;
import com.buit.commons.response.RydjPrintDataResponse;
import com.buit.op.request.OpZydjUpdateStatusReq;
import com.buit.op.response.OpZydjResp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 住院病人入院登记
 * <br>
 * @author zhouhaisheng
 */
@Mapper
public interface OpZydjDao extends EntityDao<OpZydj,Integer> {
    /**
     * 门诊住院申请列表查询
     * @param opZydj
     * @return
     */
    List<OpZydjResp> findMzzydj(String opZydj,String sqlx);

    /**
     * 查询住院登记单列表
     * @param par
     * @return
     */
    List<OpZydjPageResp> getHospitalizedRegisterList(Map<String,Object> par);

    /**
     * 修改住院登记单
     * @param req
     */
    void updateSqzt(OpZydjUpdateStatusReq req);

    /**
     * @name: getPrintInfo
     * @description: 获取打印信息
     * @param map_par
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @date: 2020/8/27 15:56
     * @auther: 老花生
     *
     */
    Map<String, Object> getPrintInfo(Map<String, Object> map_par);

    /**
     * 通过就诊流水号查询住院/留观登记单信息
     * @param jzlsh
     * @return
     */
    OpZydj findZydjByJzlsh(String jzlsh);

    /**
     * 查询入院登记打印数据
     * @param djid
     * @return
     */
    RydjPrintDataResponse getRydjPrintData(Integer djid);

    List<OpZydjResp> findByJzkhAndSqlx(String jzkh, String sqlx);
}
