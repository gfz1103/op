package com.buit.cis.op.dctwork.service.mkey.sign;


import com.buit.cis.op.dctwork.service.mkey.sign.service.DoctorMkeySignService;

import java.util.HashMap;
import java.util.Map;

public class DoctorMkeySignServiceHolder {

    private Map<DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType, DoctorMkeySignService> serviceMap = new HashMap<>();

    public void registerService(DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType type, DoctorMkeySignService service){
        serviceMap.put(type, service);
    }

    public DoctorMkeySignService getService(DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType type){
        return serviceMap.get(type);
    }
}
