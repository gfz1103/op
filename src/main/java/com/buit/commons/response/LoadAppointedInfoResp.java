package com.buit.commons.response;

import java.sql.Date;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName LoadAppointedInfoResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/2 14:27
 */
@ApiModel(value="加载预约信息-返回")
public class LoadAppointedInfoResp {
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="预约日期")
    private Date yyrq;
    @ApiModelProperty(value="联系电话")
    private String lxdh;
    @ApiModelProperty(value="病人ID")
    private Integer brid;
    @ApiModelProperty(value="是否取号")
    private Integer sfqh;
    @ApiModelProperty(value="取号时间")
    private Timestamp qhsj;
    @ApiModelProperty(value="医生代码")
    private Integer ysdm;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="指标类别")
    private String zblb;
    @ApiModelProperty(value="出生年月")
    private String csny;
    @ApiModelProperty(value="叫号号码")
    private String jhhm;
    @ApiModelProperty(value="卡号")
    private String cardno;
    @ApiModelProperty(value="病人性质")
    private String brxz;
    @ApiModelProperty(value="挂号时间")
    private Timestamp ghsj;
    @ApiModelProperty(value="身份证号")
    private String sfzh;
    @ApiModelProperty(value="取号员工")
    private String qhyg;
    @ApiModelProperty(value="病人性别")
    private String brxb;
    @ApiModelProperty(value="挂号标志")
    private Integer ghbz;
    @ApiModelProperty(value="预约序号")
    private Integer yyxh;
    @ApiModelProperty(value="年龄")
    private Integer nl;

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Date getYyrq() {
        return yyrq;
    }

    public void setYyrq(Date yyrq) {
        this.yyrq = yyrq;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getSfqh() {
        return sfqh;
    }

    public void setSfqh(Integer sfqh) {
        this.sfqh = sfqh;
    }

    public Timestamp getQhsj() {
        return qhsj;
    }

    public void setQhsj(Timestamp qhsj) {
        this.qhsj = qhsj;
    }

    public Integer getYsdm() {
        return ysdm;
    }

    public void setYsdm(Integer ysdm) {
        this.ysdm = ysdm;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public String getZblb() {
        return zblb;
    }

    public void setZblb(String zblb) {
        this.zblb = zblb;
    }

    public String getCsny() {
        return csny;
    }

    public void setCsny(String csny) {
        this.csny = csny;
    }

    public String getJhhm() {
        return jhhm;
    }

    public void setJhhm(String jhhm) {
        this.jhhm = jhhm;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getBrxz() {
        return brxz;
    }

    public void setBrxz(String brxz) {
        this.brxz = brxz;
    }

    public Timestamp getGhsj() {
        return ghsj;
    }

    public void setGhsj(Timestamp ghsj) {
        this.ghsj = ghsj;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getQhyg() {
        return qhyg;
    }

    public void setQhyg(String qhyg) {
        this.qhyg = qhyg;
    }

    public String getBrxb() {
        return brxb;
    }

    public void setBrxb(String brxb) {
        this.brxb = brxb;
    }

    public Integer getGhbz() {
        return ghbz;
    }

    public void setGhbz(Integer ghbz) {
        this.ghbz = ghbz;
    }

    public Integer getYyxh() {
        return yyxh;
    }

    public void setYyxh(Integer yyxh) {
        this.yyxh = yyxh;
    }

    public Integer getNl() {
        return nl;
    }

    public void setNl(Integer nl) {
        this.nl = nl;
    }
}
