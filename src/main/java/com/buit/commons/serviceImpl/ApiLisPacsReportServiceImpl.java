package com.buit.commons.serviceImpl;

import com.buit.commons.dao.ApiLisReportDao;
import com.buit.commons.dao.ApiPacsReportDao;
import com.buit.op.response.ApiLisReportResp;
import com.buit.op.response.ApiPacsReportResp;
import com.buit.op.service.ApiLisPacsReportService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 类名：ApiLisPacsReportServiceImpl
 * 描述：检验、检查
 *
 * @author : liushijie
 * 2021/2/24
 **/
@DubboService(timeout = 10000)
public class ApiLisPacsReportServiceImpl implements ApiLisPacsReportService {
    @Autowired
    ApiLisReportDao apiLisReportDao;
    @Autowired
    ApiPacsReportDao apiPacsReportDao;
    static final Logger logger = LoggerFactory.getLogger(ApiLisPacsReportServiceImpl.class);

    @Override
    public List<ApiLisReportResp> queryLisReport(String brid, String patType) {
        return apiLisReportDao.queryLisReport(brid, patType);
    }

    @Override
    public List<ApiLisReportResp> queryLisReportDetail(String reportItemId) {
        return apiLisReportDao.queryLisReportDetail(reportItemId);
    }

    @Override
    public List<ApiPacsReportResp> queryPacsReport(String jzlsh, Integer zyh, String patType) {
        logger.info("查询检查报告,jzlsh:"+jzlsh+",zyh:"+zyh+",patType:"+patType);
        return apiPacsReportDao.queryPacsReport(jzlsh, zyh, patType);
    }
}
