package com.buit.cis.op.dctwork.service;


import com.buit.apply.response.QueryAuxiliaryJcReportListResp;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.ApiPacsReportDao;
import com.buit.commons.dao.CisJcsq01Dao;
import com.buit.commons.model.ApiPacsReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 接口检查<br>
 * @author 老花生
 */
@Service
public class ApiPacsReportSer extends BaseManagerImp<ApiPacsReport,Integer> {
    static final Logger logger = LoggerFactory.getLogger(ApiPacsReportSer.class);

    @Autowired
    private ApiPacsReportDao apiPacsReportDao;

    @Autowired
    private CisJcsq01Dao cisJcsq01Dao;


    @Override
    public ApiPacsReportDao getEntityMapper(){
        return apiPacsReportDao;
    }

    public List<QueryAuxiliaryJcReportListResp> queryApiPacsReportList(Integer zyh){
        return cisJcsq01Dao.queryApiPacsReportList(zyh);
    }
}
