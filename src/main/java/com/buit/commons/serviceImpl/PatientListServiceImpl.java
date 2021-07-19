package com.buit.commons.serviceImpl;

import com.buit.cis.op.dctwork.service.PatientListSer;
import com.buit.op.response.SaveInitClinicInfoResp;
import com.buit.op.service.PatientListService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Description 患者列表接口实现
 * @Author 老花生
 * @Date 2020/10/14 13:38
 */
@DubboService(timeout = 10000)
public class PatientListServiceImpl implements PatientListService {
    @Autowired
    private PatientListSer patientListSer;

    @Override
    public SaveInitClinicInfoResp saveInitClinicInfo(Map<String, Object> body, Integer userId, Integer jgid, String ip) {
        return patientListSer.saveInitClinicInfo(body, userId, jgid, ip);
    }
}
