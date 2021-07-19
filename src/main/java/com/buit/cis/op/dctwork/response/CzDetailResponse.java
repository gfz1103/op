package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Author weijing
 * @Date 2021-04-22 18:57
 * @Description
 **/
@ApiModel(value = "处置项目详情数据")
public class CzDetailResponse {
    @ApiModelProperty(value = "项目名称")
    private String xmmc;

    @ApiModelProperty(value = "数量")
    private String ylsl;

    @ApiModelProperty(value = "项目单位")
    private String xmdw;

    @ApiModelProperty(value = "医技组号")
    private Integer yjzh;

    @ApiModelProperty(value = "医疗单价")
    private BigDecimal yldj;

    @ApiModelProperty(value = "合计金额")
    private BigDecimal hjje;

    public BigDecimal getYldj() {
        return yldj;
    }

    public void setYldj(BigDecimal yldj) {
        this.yldj = yldj;
    }

    public BigDecimal getHjje() {
        return hjje;
    }

    public void setHjje(BigDecimal hjje) {
        this.hjje = hjje;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getYlsl() {
        return ylsl;
    }

    public void setYlsl(String ylsl) {
        this.ylsl = ylsl;
    }

    public String getXmdw() {
        return xmdw;
    }

    public void setXmdw(String xmdw) {
        this.xmdw = xmdw;
    }

    public Integer getYjzh() {
        return yjzh;
    }

    public void setYjzh(Integer yjzh) {
        this.yjzh = yjzh;
    }
}
