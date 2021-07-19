package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author weijing
 * @Date 2021-03-30 10:11
 * @Description
 **/
@ApiModel("药品用法")
public class YpyfResponse {
    @ApiModelProperty(value = "项目类别 类别为3为注射卡")
    private String xmlb;

    @ApiModelProperty(value = "科室打印 1是 0否")
    private String kpdy;

    public String getXmlb() {
        return xmlb;
    }

    public void setXmlb(String xmlb) {
        this.xmlb = xmlb;
    }

    public String getKpdy() {
        return kpdy;
    }

    public void setKpdy(String kpdy) {
        this.kpdy = kpdy;
    }
}
