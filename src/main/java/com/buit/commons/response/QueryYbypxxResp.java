package com.buit.commons.response;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName QueryYbypxxResp
 * @Description 获取医保药品信息-返回
 * @Author 老花生
 * @Date 2020/7/2 11:11
 */
@ApiModel(value="获取医保药品信息-返回")
public class QueryYbypxxResp {

    @ApiModelProperty(value="医保规格")
    private String ybgg;
    @ApiModelProperty(value="医保商品名称")
    private String ybspmc;
    @ApiModelProperty(value="医保单位")
    private String ybdw;
    @ApiModelProperty(value="启用标志")
    private Integer qybz;
    @ApiModelProperty(value="结束日期")
    private Date jsrq;
    @ApiModelProperty(value="医保编码")
    private String ybbm;
    @ApiModelProperty(value="启用日期")
    private Date qyrq;
    @ApiModelProperty(value="医保药品名称")
    private String ybmc;

    public String getYbgg() {
        return ybgg;
    }

    public void setYbgg(String ybgg) {
        this.ybgg = ybgg;
    }

    public String getYbspmc() {
        return ybspmc;
    }

    public void setYbspmc(String ybspmc) {
        this.ybspmc = ybspmc;
    }

    public String getYbdw() {
        return ybdw;
    }

    public void setYbdw(String ybdw) {
        this.ybdw = ybdw;
    }

    public Integer getQybz() {
        return qybz;
    }

    public void setQybz(Integer qybz) {
        this.qybz = qybz;
    }

    public Date getJsrq() {
        return jsrq;
    }

    public void setJsrq(Date jsrq) {
        this.jsrq = jsrq;
    }

    public String getYbbm() {
        return ybbm;
    }

    public void setYbbm(String ybbm) {
        this.ybbm = ybbm;
    }

    public Date getQyrq() {
        return qyrq;
    }

    public void setQyrq(Date qyrq) {
        this.qyrq = qyrq;
    }

    public String getYbmc() {
        return ybmc;
    }

    public void setYbmc(String ybmc) {
        this.ybmc = ybmc;
    }
}
