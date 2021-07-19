package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("生成签名二位码")
public class MkeyCreateSignQrcodeResponse {

    @ApiModelProperty("mkey业务流水号")
    private String bizSn;

    @ApiModelProperty("mkey 二维码base64")
    private String qrcode;

    public String getBizSn() {
        return bizSn;
    }

    public void setBizSn(String bizSn) {
        this.bizSn = bizSn;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
}
