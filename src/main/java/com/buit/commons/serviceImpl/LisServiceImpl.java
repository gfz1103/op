package com.buit.commons.serviceImpl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.buit.commons.BaseException;
import com.buit.commons.dao.ApiLisReportDao;
import com.buit.commons.model.ApiLisReport;
import com.buit.op.request.*;
import com.buit.op.service.LisService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@DubboService(timeout = 10000)
public class LisServiceImpl implements LisService {
    @Autowired
    private ApiLisReportDao apiLisReportDao;

    @Override
    public void reportUpload(LisReportUploadRequest req) {
        List<LisReportUploadNormalReq> lisReportUploadNormalList = req.getNormal();
        List<LisReportUploadGerminfoReq> lisReportUploadGerminfoList = req.getGerminfo();
        List<LisReportUploadAntiinfoReq> lisReportUploadAntiinfoList = req.getAntiinfo();

        ApiLisReport apiLisReport = new ApiLisReport();
        apiLisReport.setReportNo(req.getReport_id());
        apiLisReport.setSampleNo(req.getSample_no());
        apiLisReport.setBarcode(req.getBarcode());
        apiLisReport.setJzkh(req.getPatient_id());
        apiLisReport.setSpecimenType(req.getSample_type());
        apiLisReport.setReqData(req.getReq_date());
        apiLisReport.setSamplingDate(req.getSampling_date());
        apiLisReport.setReceiptDate(req.getReceipt_date());
        apiLisReport.setReceiptDate1(req.getReceipt_date1());
        apiLisReport.setTestDate(req.getTest_date());
        apiLisReport.setAudittime(req.getReport_date());
        apiLisReport.setReqDoctor(req.getReq_doctor());
        apiLisReport.setTestDoctor(req.getTest_doctor());
        apiLisReport.setAuditor(req.getReport_doctor());
        apiLisReport.setReportType(req.getReport_type());
        apiLisReport.setBrId(req.getPatient_id());
        apiLisReport.setJgid(req.getHospital_id());
        apiLisReport.setBgdlbbm(req.getBgdlbbm());
        apiLisReport.setBgdlb(req.getBgdlb());
        if("门诊".equals(req.getPatient_Type())){
            apiLisReport.setPatType("0");
        }else if("住院".equals(req.getPatient_Type())){
            apiLisReport.setPatType("1");
        }

        if(CollUtil.isNotEmpty(lisReportUploadNormalList)){
            lisReportUploadNormalList.forEach(o -> {
                ApiLisReport normalApiLisReport = ObjectUtil.clone(apiLisReport);
                normalApiLisReport.setReportItemId(o.getFeeitem_no());
                normalApiLisReport.setReportItemName(o.getFeeitem_name());
                normalApiLisReport.setItemCode(o.getItem_code());
                normalApiLisReport.setItemName(o.getItem_name());
                normalApiLisReport.setResult(o.getResult());
                normalApiLisReport.setTextRange(o.getRef());
                normalApiLisReport.setUnits(o.getUnit());
                normalApiLisReport.setDanger(o.getLimit_flag());
                normalApiLisReport.setItemReompt(o.getResult_flag());
                normalApiLisReport.setReqNo(o.getRequestno());
                apiLisReportDao.insert(normalApiLisReport);
            });
        }

        if(CollUtil.isNotEmpty(lisReportUploadGerminfoList)){
            lisReportUploadGerminfoList.forEach( o -> {
                ApiLisReport germApiLisReport = ObjectUtil.clone(apiLisReport);
                germApiLisReport.setReportItemId(o.getFeeitem_no());
                germApiLisReport.setReportItemName(o.getFeeitem_name());
                germApiLisReport.setAntiGermCode(o.getGerm_code());
                germApiLisReport.setAntiGermName(o.getGerm_name());
                germApiLisReport.setGermResult(o.getResult());
                germApiLisReport.setGermResultType(o.getResult_type());
                germApiLisReport.setRemark(o.getBz());
                germApiLisReport.setReqNo(o.getRequestno());
                apiLisReportDao.insert(germApiLisReport);
            });
        }

        if(CollUtil.isNotEmpty(lisReportUploadAntiinfoList)){
            lisReportUploadAntiinfoList.forEach( o -> {
                ApiLisReport antiApiLisReport = ObjectUtil.clone(apiLisReport);
                antiApiLisReport.setReportItemId(o.getFeeitem_no());
                antiApiLisReport.setReportItemName(o.getFeeitem_name());
                antiApiLisReport.setAntiGermCode(o.getGerm_code());
                antiApiLisReport.setAntiGermName(o.getGerm_name());
                antiApiLisReport.setAntiCode(o.getAnti_code());
                antiApiLisReport.setAntiName(o.getAnti_name());
                antiApiLisReport.setAntiResult(o.getAnti_result());
                antiApiLisReport.setAntiResult1(o.getAnti_result1());
                antiApiLisReport.setReqNo(o.getRequestno());
                apiLisReportDao.insert(antiApiLisReport);
            });
        }
    }

    @Override
    public void reportCancel(LisReportCancelRequest req) {
        if(Objects.isNull(req.getReport_id())){
            throw BaseException.create("ERROR_LIS_PACS_0001");
        }
        apiLisReportDao.cancel(req.getReport_id());
    }


}
