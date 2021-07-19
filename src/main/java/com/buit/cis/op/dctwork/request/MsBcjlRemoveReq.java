
package com.buit.cis.op.dctwork.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：MsBcjlRemoveReq<br>
 * 类描述：门诊_门诊病历 | 病程记录-清除请求<br>
 * @author 老花生
 */
@ApiModel(value="门诊_门诊病历 | 病程记录-清除请求")
public class MsBcjlRemoveReq {
    @ApiModelProperty(value="就诊序号")
    private Integer clinicId;

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }
}