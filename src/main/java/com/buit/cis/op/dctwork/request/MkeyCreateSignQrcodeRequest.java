package com.buit.cis.op.dctwork.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("扫码签名请求")
public class MkeyCreateSignQrcodeRequest {

    /**
     * @see com.buit.cis.op.dctwork.service.mkey.sign.DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType
     */
    @ApiModelProperty("签名业务类型 1登录 2处方签名")
    @NotNull(message = "签名业务类型必传")
    private Integer type;

    @ApiModelProperty("签名业务ID 处方签名存处方主键，登录存登录人的编码等")
    @NotNull(message = "签名业务ID必传")
    private Integer dataId;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }
}
