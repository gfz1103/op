package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.ApiLisReport;
import com.buit.commons.request.ApiLisReportReq;
import com.buit.op.response.ApiLisReportResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口检验<br>
 *
 * @author 老花生
 */
@Mapper
public interface ApiLisReportDao extends EntityDao<ApiLisReport, Integer> {

    List<ApiLisReportResp> queryLisPage(ApiLisReportReq apilisreport);

    /**
     * 查询检验报告
     *
     * @param brid    门诊：就诊流水号, 住院：住院号
     * @param patType 病人类型：0-门诊、1-住院、2-体检
     * @return
     */
    List<ApiLisReportResp> queryLisReport(@Param("brid") String brid, @Param("patType") String patType);

    /**
     * 查询检验明细报告
     *
     * @param reportItemId 报告项目序号
     * @return
     */
    List<ApiLisReportResp> queryLisReportDetail(@Param("reportItemId") String reportItemId);

    void cancel(String report_id);
}
