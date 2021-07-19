package com.buit.cis.op.dctwork.service.mkey.sign;

import com.buit.cis.op.dctwork.service.mkey.sign.service.DoctorMkeyLoginService;
import com.buit.cis.op.dctwork.service.mkey.sign.service.DoctorMkeySignDoctorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorMkeySignServiceConfig {

    @Bean
    public DoctorMkeySignServiceHolder doctorMkeySignServiceHolder(DoctorMkeyLoginService loginSignService,
                                                                   DoctorMkeySignDoctorService signDoctorService){
        DoctorMkeySignServiceHolder holder = new DoctorMkeySignServiceHolder();
        holder.registerService(DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType.LOGIN, loginSignService);
        holder.registerService(DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType.SIGN, signDoctorService);
        return holder;
    }
}
