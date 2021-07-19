package com.buit.commons.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author weijing
 * @Date 2021-04-16 16:27
 * @Description
 **/
@ApiModel(value = "入院登记单（入院证）打印返回数据")
public class RydjPrintDataResponse {
    @ApiModelProperty(value = "机构名称")
    private String jgmc;
    @ApiModelProperty(value = "门诊科室名称")
    private String mzksmc;
    @ApiModelProperty(value = "就诊卡号")
    private String jzkh;
    @ApiModelProperty(value = "登记日期")
    private String djrq;
    @ApiModelProperty(value = "患者姓名")
    private String hzxm;
    @ApiModelProperty(value = "性别")
    private String xb;
    @ApiModelProperty(value = "年龄")
    private String nl;
    @ApiModelProperty(value = "门诊号（就诊流水号）")
    private String mzh;
    @ApiModelProperty(value = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date csrq;
    @ApiModelProperty(value = "身份证号")
    private String sfzh;
    @ApiModelProperty(value = "医保/自费")
    private String brxz;
    @ApiModelProperty(value = "住址")
    private String zz;
    @ApiModelProperty(value = "门、急诊诊断")
    private String mjzzd;
    @ApiModelProperty(value = "拟入院病区")
    private String nrybq;
    @ApiModelProperty(value = "拟入院科别")
    private String nrykb;
    @ApiModelProperty(value = "预缴费用")
    private String yjfy;
    @ApiModelProperty(value = "联系人")
    private String lxr;
    @ApiModelProperty(value = "与患者关系")
    private String lxrgx;
    @ApiModelProperty(value = "联系人电话")
    private String lxdh;
    @ApiModelProperty(value = "医生姓名")
    private String ysxm;
    @ApiModelProperty(value = "备注 入院主要目的 前端翻译")
    private String bz;

    @ApiModelProperty(value = "省编码",hidden = true)
    private Integer shengbm;
    @ApiModelProperty(value = "市编码",hidden = true)
    private Integer shibm;
    @ApiModelProperty(value = "县编码",hidden = true)
    private Integer xianbm;
    @ApiModelProperty(value = "详细住址",hidden = true)
    private String xxdz;


    public Integer getShengbm() {
        return shengbm;
    }

    public void setShengbm(Integer shengbm) {
        this.shengbm = shengbm;
    }

    public Integer getShibm() {
        return shibm;
    }

    public void setShibm(Integer shibm) {
        this.shibm = shibm;
    }

    public Integer getXianbm() {
        return xianbm;
    }

    public void setXianbm(Integer xianbm) {
        this.xianbm = xianbm;
    }

    public String getXxdz() {
        return xxdz;
    }

    public void setXxdz(String xxdz) {
        this.xxdz = xxdz;
    }

    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    public String getMzksmc() {
        return mzksmc;
    }

    public void setMzksmc(String mzksmc) {
        this.mzksmc = mzksmc;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public String getDjrq() {
        return djrq;
    }

    public void setDjrq(String djrq) {
        this.djrq = djrq;
    }

    public String getHzxm() {
        return hzxm;
    }

    public void setHzxm(String hzxm) {
        this.hzxm = hzxm;
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

    public String getMzh() {
        return mzh;
    }

    public void setMzh(String mzh) {
        this.mzh = mzh;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getBrxz() {
        return brxz;
    }

    public void setBrxz(String brxz) {
        this.brxz = brxz;
    }

    public String getZz() {
        return zz;
    }

    public void setZz(String zz) {
        this.zz = zz;
    }

    public String getMjzzd() {
        return mjzzd;
    }

    public void setMjzzd(String mjzzd) {
        this.mjzzd = mjzzd;
    }

    public String getNrybq() {
        return nrybq;
    }

    public void setNrybq(String nrybq) {
        this.nrybq = nrybq;
    }

    public String getNrykb() {
        return nrykb;
    }

    public void setNrykb(String nrykb) {
        this.nrykb = nrykb;
    }

    public String getYjfy() {
        return yjfy;
    }

    public void setYjfy(String yjfy) {
        this.yjfy = yjfy;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getLxrgx() {
        return lxrgx;
    }

    public void setLxrgx(String lxrgx) {
        this.lxrgx = lxrgx;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getYsxm() {
        return ysxm;
    }

    public void setYsxm(String ysxm) {
        this.ysxm = ysxm;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
