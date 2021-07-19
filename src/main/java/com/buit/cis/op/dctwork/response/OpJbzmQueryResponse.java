package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @Author weijing
 * @Date 2021-03-29 10:07
 * @Description
 **/
@ApiModel(value = "疾病证明查询返回")
public class OpJbzmQueryResponse {
    @ApiModelProperty(value="主键ID 修改时必传")
    private Integer bqid;

    @ApiModelProperty(value="类型:1 门诊 2 住院")
    private Integer lx;

    @ApiModelProperty(value="门诊号码")
    private String mzhm;

    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;

    @ApiModelProperty(value="卡号")
    private String cardno;

    @ApiModelProperty(value="身份证号码")
    private String sfzh;

    @ApiModelProperty(value="姓名")
    private String brxm;

    @ApiModelProperty(value="性别")
    private Integer brxb;

    @ApiModelProperty(value="就诊日期")
    private Timestamp jzrq;

    @ApiModelProperty(value="科室")
    private Integer jzks;

    @ApiModelProperty(value="诊断")
    private String brzd;

    @ApiModelProperty(value="建议类型 1免修体育课 2休假n天 3休学n学期 4其他")
    private String jylx;

    @ApiModelProperty(value="建议值 对于建议类型为2和3的为n的值，4为其他建议")
    private String jyz;

    @ApiModelProperty(value="接诊医生")
    private Integer jzys;

    @ApiModelProperty(value="单据类型 1病情证明单 2疾病证明单")
    private String djlx;

    @ApiModelProperty(value="开具证明时间")
    private Timestamp kjzmsj;

    public Integer getBqid() {
        return bqid;
    }

    public void setBqid(Integer bqid) {
        this.bqid = bqid;
    }

    public Integer getLx() {
        return lx;
    }

    public void setLx(Integer lx) {
        this.lx = lx;
    }

    public String getMzhm() {
        return mzhm;
    }

    public void setMzhm(String mzhm) {
        this.mzhm = mzhm;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Integer getBrxb() {
        return brxb;
    }

    public void setBrxb(Integer brxb) {
        this.brxb = brxb;
    }

    public Timestamp getJzrq() {
        return jzrq;
    }

    public void setJzrq(Timestamp jzrq) {
        this.jzrq = jzrq;
    }

    public Integer getJzks() {
        return jzks;
    }

    public void setJzks(Integer jzks) {
        this.jzks = jzks;
    }

    public String getBrzd() {
        return brzd;
    }

    public void setBrzd(String brzd) {
        this.brzd = brzd;
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

    public Integer getJzys() {
        return jzys;
    }

    public void setJzys(Integer jzys) {
        this.jzys = jzys;
    }

    public String getDjlx() {
        return djlx;
    }

    public void setDjlx(String djlx) {
        this.djlx = djlx;
    }

    public Timestamp getKjzmsj() {
        return kjzmsj;
    }

    public void setKjzmsj(Timestamp kjzmsj) {
        this.kjzmsj = kjzmsj;
    }
}
