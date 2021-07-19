package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author weijing
 * @Date 2021-03-26 17:23
 * @Description
 **/
@ApiModel(value = "疾病证明打印数据")
public class JbzmPrintResponse {
    @ApiModelProperty(value = "编号")
    private String bh;

    @ApiModelProperty(value = "姓名")
    private String xm;

    @ApiModelProperty(value = "性别")
    private String xb;

    @ApiModelProperty(value = "年龄")
    private String nl;

    @ApiModelProperty(value = "科室名称")
    private String ksmc;

    @ApiModelProperty(value = "门诊号")
    private String mzh;

    @ApiModelProperty(value = "就诊时间 20201212")
    private String jzrq;

    @ApiModelProperty(value = "诊断")
    private String zd;

    @ApiModelProperty(value = "建议类型 1免修体育课 2休假n天 3休学n学期 4其他")
    private String jylx;

    @ApiModelProperty(value = "建议值 对于建议类型为2和3的n的值，4为其他建议的值")
    private String jyz;

    @ApiModelProperty(value = "诊治医师")
    private String zzys;

    @ApiModelProperty(value = "证明时间-年")
    private String zmsj_n;

    @ApiModelProperty(value = "证明时间-月")
    private String zmsj_y;

    @ApiModelProperty(value = "证明时间-日")
    private String zmsj_r;

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
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

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public String getMzh() {
        return mzh;
    }

    public void setMzh(String mzh) {
        this.mzh = mzh;
    }

    public String getJzrq() {
        return jzrq;
    }

    public void setJzrq(String jzrq) {
        this.jzrq = jzrq;
    }

    public String getZd() {
        return zd;
    }

    public void setZd(String zd) {
        this.zd = zd;
    }

    public String getJylx() {
        return jylx;
    }

    public void setJylx(String jylx) {
        this.jylx = jylx;
    }

    public String getJyz() {
        return jyz;
    }

    public void setJyz(String jyz) {
        this.jyz = jyz;
    }

    public String getZzys() {
        return zzys;
    }

    public void setZzys(String zzys) {
        this.zzys = zzys;
    }

    public String getZmsj_n() {
        return zmsj_n;
    }

    public void setZmsj_n(String zmsj_n) {
        this.zmsj_n = zmsj_n;
    }

    public String getZmsj_y() {
        return zmsj_y;
    }

    public void setZmsj_y(String zmsj_y) {
        this.zmsj_y = zmsj_y;
    }

    public String getZmsj_r() {
        return zmsj_r;
    }

    public void setZmsj_r(String zmsj_r) {
        this.zmsj_r = zmsj_r;
    }
}
