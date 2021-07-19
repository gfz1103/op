package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName SaveClinicTherapeuticResp
 * @Description 诊疗方案调入-返回
 * @Author 老花生
 * @Date 2020/7/17 17:16
 */
@ApiModel(value="诊疗方案调入-返回")
public class SaveClinicTherapeuticResp {
    @ApiModelProperty(value="门诊病历模板")
    private GyBlmbResp gyBlmb;
    @ApiModelProperty(value="错误消息")
    private String errorMsg;

    public GyBlmbResp getGyBlmb() {
        return gyBlmb;
    }

    public void setGyBlmb(GyBlmbResp gyBlmb) {
        this.gyBlmb = gyBlmb;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
