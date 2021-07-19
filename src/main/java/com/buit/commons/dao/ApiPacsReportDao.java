package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.ApiPacsReport;
import com.buit.op.response.ApiPacsReportResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口检查<br>
 *
 * @author 老花生
 */
@Mapper
public interface ApiPacsReportDao extends EntityDao<ApiPacsReport, Integer> {

    /**
     * @param jzlsh   门诊就诊流水号
     * @param zyh     住院号
     * @param patType 病人类型：0-门诊、1-住院、2-体检
     * @return
     */
    List<ApiPacsReportResp> queryPacsReport(@Param("jzlsh") String jzlsh, @Param("zyh") Integer zyh, @Param("patType") String patType);

    void delByReportId(@Param("reportId") String reportId);
}
