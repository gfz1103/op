package com.buit.cis.op.dctwork.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @Author weijing
 * @Date 2021-03-26 09:29
 * @Description
 **/
@ApiModel(value = "处方打印返回参数")
public class CfPrintResponse {
    @ApiModelProperty(value = "是否为注射单 1是 0否")
    private String sfzsd;

    @ApiModelProperty(value = "类型 1西药 2中成药 3中草药")
    private String lx;

    @ApiModelProperty(value = "处方类型 1普通(普) 2精二处方(精) 3 儿科处方（儿）4麻、精一处方（麻、精一）")
    private String cflx;

//    @ApiModelProperty(value = "是否麻、精一处方 1是 0否")
//    private Integer cflx;

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

    @ApiModelProperty(value = "处方列表")
    private List<DrugDetailResponse> cfList;

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

    @ApiModelProperty(value = "挂号科室")
    private Integer ghks;

    @ApiModelProperty(value = "代煎药标志（草药） 1是 0否")
    private Integer djybz;

    @ApiModelProperty(value = "方名（草药）")
    private String fm;

    @ApiModelProperty(value = "煎服法（草药）")
    private String jff;

    @ApiModelProperty(value = "特殊要求（草药）")
    private String tsyq;

    @ApiModelProperty(value = "患者身份证明 证件类型")
    private String hzsfzmmc;
    @ApiModelProperty(value = "患者编号 证件编号")
    private String hzbh;


    //代办人信息（当处方中存在麻、精药品）
    @ApiModelProperty(value = "代办人姓名")
    private String dbrxm;
    @ApiModelProperty(value = "代办人联系电话")
    private String dbrlxdh;
    @ApiModelProperty(value = "身份证明 证件类型")
    private String sfzmmc;
    @ApiModelProperty(value = "编号 证件编号")
    private String bh;

    //代煎费
    @ApiModelProperty(value = "代煎费单价")
    private String djfdj;
    @ApiModelProperty(value = "代煎费总金额")
    private String djfzje;

    public String getDjfdj() {
        return djfdj;
    }

    public void setDjfdj(String djfdj) {
        this.djfdj = djfdj;
    }

    public String getDjfzje() {
        return djfzje;
    }

    public void setDjfzje(String djfzje) {
        this.djfzje = djfzje;
    }

    public String getHzsfzmmc() {
        return hzsfzmmc;
    }

    public void setHzsfzmmc(String hzsfzmmc) {
        this.hzsfzmmc = hzsfzmmc;
    }

    public String getHzbh() {
        return hzbh;
    }

    public void setHzbh(String hzbh) {
        this.hzbh = hzbh;
    }

    public String getDbrxm() {
        return dbrxm;
    }

    public void setDbrxm(String dbrxm) {
        this.dbrxm = dbrxm;
    }

    public String getDbrlxdh() {
        return dbrlxdh;
    }

    public void setDbrlxdh(String dbrlxdh) {
        this.dbrlxdh = dbrlxdh;
    }

    public String getSfzmmc() {
        return sfzmmc;
    }

    public void setSfzmmc(String sfzmmc) {
        this.sfzmmc = sfzmmc;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public Integer getDjybz() {
        return djybz;
    }

    public void setDjybz(Integer djybz) {
        this.djybz = djybz;
    }

    public String getFm() {
        return fm;
    }

    public void setFm(String fm) {
        this.fm = fm;
    }

    public String getJff() {
        return jff;
    }

    public void setJff(String jff) {
        this.jff = jff;
    }

    public String getTsyq() {
        return tsyq;
    }

    public void setTsyq(String tsyq) {
        this.tsyq = tsyq;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public String getSfzsd() {
        return sfzsd;
    }

    public void setSfzsd(String sfzsd) {
        this.sfzsd = sfzsd;
    }

    public String getCflx() {
        return cflx;
    }

    public void setCflx(String cflx) {
        this.cflx = cflx;
    }

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

    public List<DrugDetailResponse> getCfList() {
        return cfList;
    }

    public void setCfList(List<DrugDetailResponse> cfList) {
        this.cfList = cfList;
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

    public Integer getGhks() {
        return ghks;
    }

    public void setGhks(Integer ghks) {
        this.ghks = ghks;
    }
}
