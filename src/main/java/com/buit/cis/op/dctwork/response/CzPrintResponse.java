package com.buit.cis.op.dctwork.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @Author weijing
 * @Date 2021-04-22 18:54
 * @Description
 **/
@ApiModel(value = "处置打印返回参数")
public class CzPrintResponse {
    @ApiModelProperty(value = "患者姓名")
    private String hzxm;

    @ApiModelProperty(value = "患者性别 1男 2女")
    private String hzxb;

    @ApiModelProperty(value = "患者年龄")
    private String hznl;

    @ApiModelProperty(value = "患者联系电话")
    private String hzlxdh;

    @ApiModelProperty(value = "患者出生日期 yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date csrq;

    @ApiModelProperty(value = "费别 1医保 2非医保")
    private String fb;

    @ApiModelProperty(value = "医保/就诊卡号")
    private String jzkh;

    @ApiModelProperty(value = "门诊/住院病例号")
    private String blh;

    @ApiModelProperty(value = "科别/病区-床位号")
    private String ks_bqh;

    @ApiModelProperty(value = "临床诊断")
    private String lczd;

    @ApiModelProperty(value = "症候（草药）")
    private String zh;

    @ApiModelProperty(value = "开具日期-年")
    private String kjrq_n;

    @ApiModelProperty(value = "开具日期-月")
    private String kyrq_y;

    @ApiModelProperty(value = "开具日期-日")
    private String kjrq_r;

    @ApiModelProperty(value = "皮试结果")
    private String psjg;

    @ApiModelProperty(value = "审核")
    private String sh;

    @ApiModelProperty(value = "调配")
    private String tp;

    @ApiModelProperty(value = "医师")
    private String ys;

    @ApiModelProperty(value = "核对")
    private String hd;

    @ApiModelProperty(value = "发药")
    private String fy;

    @ApiModelProperty(value = "药品金额")
    private String ypje;

    @ApiModelProperty(value = "处置项目")
    private List<CzDetailResponse> czDetail;


    public String getHzxm() {
        return hzxm;
    }

    public void setHzxm(String hzxm) {
        this.hzxm = hzxm;
    }

    public String getHzxb() {
        return hzxb;
    }

    public void setHzxb(String hzxb) {
        this.hzxb = hzxb;
    }

    public String getHznl() {
        return hznl;
    }

    public void setHznl(String hznl) {
        this.hznl = hznl;
    }

    public String getHzlxdh() {
        return hzlxdh;
    }

    public void setHzlxdh(String hzlxdh) {
        this.hzlxdh = hzlxdh;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public String getBlh() {
        return blh;
    }

    public void setBlh(String blh) {
        this.blh = blh;
    }

    public String getKs_bqh() {
        return ks_bqh;
    }

    public void setKs_bqh(String ks_bqh) {
        this.ks_bqh = ks_bqh;
    }

    public String getLczd() {
        return lczd;
    }

    public void setLczd(String lczd) {
        this.lczd = lczd;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public String getKjrq_n() {
        return kjrq_n;
    }

    public void setKjrq_n(String kjrq_n) {
        this.kjrq_n = kjrq_n;
    }

    public String getKyrq_y() {
        return kyrq_y;
    }

    public void setKyrq_y(String kyrq_y) {
        this.kyrq_y = kyrq_y;
    }

    public String getKjrq_r() {
        return kjrq_r;
    }

    public void setKjrq_r(String kjrq_r) {
        this.kjrq_r = kjrq_r;
    }

    public String getPsjg() {
        return psjg;
    }

    public void setPsjg(String psjg) {
        this.psjg = psjg;
    }

    public String getSh() {
        return sh;
    }

    public void setSh(String sh) {
        this.sh = sh;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getYs() {
        return ys;
    }

    public void setYs(String ys) {
        this.ys = ys;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getFy() {
        return fy;
    }

    public void setFy(String fy) {
        this.fy = fy;
    }

    public String getYpje() {
        return ypje;
    }

    public void setYpje(String ypje) {
        this.ypje = ypje;
    }

    public List<CzDetailResponse> getCzDetail() {
        return czDetail;
    }

    public void setCzDetail(List<CzDetailResponse> czDetail) {
        this.czDetail = czDetail;
    }
}
