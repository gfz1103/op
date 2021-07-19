package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author weijing
 * @Date 2021-03-26 16:40
 * @Description
 **/
@ApiModel(value = "病情证明打印数据")
public class BqzmPrintResponse {
    @ApiModelProperty(value = "姓名")
    private String xm;

    @ApiModelProperty(value = "性别")
    private String xb;

    @ApiModelProperty(value = "出生日期")
    private String csrq;

    @ApiModelProperty(value = "年龄")
    private String nl;

    @ApiModelProperty(value = "门诊（住院）号")
    private String mz_jyh;

    @ApiModelProperty(value = "就诊时间 2020年12月12日")
    private String jzsj;

    @ApiModelProperty(value = "科室名称")
    private String ksmc;

    @ApiModelProperty(value = "诊断")
    private String zd;

    @ApiModelProperty(value = "休息天数")
    private String xxts;

    @ApiModelProperty(value = "休息开始时间 2020年12月12日 上午")
    private String xxkssj;

    @ApiModelProperty(value = "休息结束时间 2020年12月13日下午")
    private String xxjssj;

    @ApiModelProperty(value = "诊治医师")
    private String zzys;

    @ApiModelProperty(value = "开具证明时间")
    private String zmsj;

    @ApiModelProperty(value = "备注")
    private String bz;

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getMz_jyh() {
        return mz_jyh;
    }

    public void setMz_jyh(String mz_jyh) {
        this.mz_jyh = mz_jyh;
    }

    public String getJzsj() {
        return jzsj;
    }

    public void setJzsj(String jzsj) {
        this.jzsj = jzsj;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public String getZd() {
        return zd;
    }

    public void setZd(String zd) {
        this.zd = zd;
    }

    public String getXxts() {
        return xxts;
    }

    public void setXxts(String xxts) {
        this.xxts = xxts;
    }

    public String getXxkssj() {
        return xxkssj;
    }

    public void setXxkssj(String xxkssj) {
        this.xxkssj = xxkssj;
    }

    public String getXxjssj() {
        return xxjssj;
    }

    public void setXxjssj(String xxjssj) {
        this.xxjssj = xxjssj;
    }

    public String getZzys() {
        return zzys;
    }

    public void setZzys(String zzys) {
        this.zzys = zzys;
    }

    public String getZmsj() {
        return zmsj;
    }

    public void setZmsj(String zmsj) {
        this.zmsj = zmsj;
    }
}
