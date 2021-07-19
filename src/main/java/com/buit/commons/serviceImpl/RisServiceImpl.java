package com.buit.commons.serviceImpl;

import cn.hutool.core.date.DateUtil;
import com.buit.commons.dao.ApiPacsReportDao;
import com.buit.commons.dao.CisJcsq01Dao;
import com.buit.commons.dao.MpiBrdaDao;
import com.buit.commons.model.ApiPacsReport;
import com.buit.commons.model.CisJcsq01;
import com.buit.constans.TableName;
import com.buit.op.request.PacsGetHisPatientInfoRequest;
import com.buit.op.request.PacsHisIsSetCrisisRequest;
import com.buit.op.response.PacsGetHisPatientInfoResponse;
import com.buit.op.service.RisService;
import com.buit.utill.MzUtil;
import com.buit.utill.RedisFactory;
import org.apache.commons.lang.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@DubboService(timeout = 10000)
public class RisServiceImpl implements RisService {

    @Autowired
    private MpiBrdaDao mpiBrdaDao;
    @Autowired
    private ApiPacsReportDao apiPacsReportDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private CisJcsq01Dao cisJcsq01Dao;

    @Override
    public List<PacsGetHisPatientInfoResponse> getHisPatientInfo(PacsGetHisPatientInfoRequest req) {
        List<PacsGetHisPatientInfoResponse> pacsGetHisPatientInfoRespList =  mpiBrdaDao.getHisPatientInfo(req);
        pacsGetHisPatientInfoRespList.forEach(o -> {
            if (o.getBIRTHDATE() != null) {
                Map<String, Object> agMap = MzUtil.getPersonAge(DateUtil.parseDate(o.getBIRTHDATE()), null);
                if (!agMap.isEmpty()) {
                    String ages = String.valueOf(agMap.get("ages"));
                    if(ages.contains("岁")){
                        o.setAGETYPE("岁");
                        o.setAGE(String.valueOf(agMap.get("age")));
                    }else if(ages.contains("月")){
                        o.setAGETYPE("月");
                        o.setAGE(String.valueOf((ages.split("月"))[0]));
                    }else if(ages.contains("天")){
                        o.setAGETYPE("天");
                        o.setAGE(String.valueOf((ages.split("天"))[0]));
                    }else {
                        o.setAGETYPE("天");
                        o.setAGE("1");
                    }
//                    o.setAGE(ages);
                }
            }
        });
        return pacsGetHisPatientInfoRespList;
    }

    @Override
    public Boolean hisIsSetCrisis(PacsHisIsSetCrisisRequest req) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ApiPacsReport apiPacsReport = new ApiPacsReport();
        CisJcsq01 jcsq = cisJcsq01Dao.getById(Integer.valueOf(req.getSTUDY_ID()));
        if(jcsq == null){
            return false;
        }
        if(StringUtils.isNotEmpty(req.getReport_ID())){
            apiPacsReportDao.delByReportId(req.getReport_ID());
        }
        apiPacsReport.setReqId(req.getSTUDY_ID());
        apiPacsReport.setReportId(req.getReport_ID());
        apiPacsReport.setPatientNo(req.getPatient_NO());
        apiPacsReport.setReporter(req.getReporter());
        apiPacsReport.setAuditor(req.getAuditor());
        apiPacsReport.setWritedate(req.getWriteDate());
        apiPacsReport.setAuditdate(req.getAuditDate());
        apiPacsReport.setBodypart(Arrays.toString(req.getBodyPart()).replace("[","").replace("]",""));
        apiPacsReport.setExamname(Arrays.toString(req.getExamName()).replace("[","").replace("]",""));
        apiPacsReport.setExammethod(Arrays.toString(req.getExamMethod()).replace("[","").replace("]",""));
        apiPacsReport.setDiagdesc(req.getDiagDesc());
        apiPacsReport.setDiagname(req.getDiagName());
        apiPacsReport.setImgUrl(req.getImageList());
        String sqlx = jcsq.getSqlx();
        if("1".equals(sqlx)){
            apiPacsReport.setJzlsh(jcsq.getJzlsh());
            apiPacsReport.setPatType("0");
        }else{
            apiPacsReport.setZyh(jcsq.getZyh());
            apiPacsReport.setPatType("1");
        }
        apiPacsReport.setReqData(sdf.format(jcsq.getSqsj()));
        apiPacsReport.setId(redisFactory.getTableKey(TableName.DB_NAME, TableName.API_PACS_REPORT));
        apiPacsReportDao.insert(apiPacsReport);
        return true;
    }
}
