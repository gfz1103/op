package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户MKEY生成登录二维码返回")
public class MkeyCreateLoginQrcodeResponse {

    @ApiModelProperty("业务流水号")
    private String bizSn;

    @ApiModelProperty("二维码的base64编码的URLendcode 编码")
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
