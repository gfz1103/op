
package com.buit.commons.response;

import java.sql.Date;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpYyghQueryResp<br>
 * 类描述：门诊_预约挂号-查询返回<br>
 * @author WY
 */
@ApiModel(value="门诊_预约挂号-查询返回")
public class OpYyghQueryResp {
    @ApiModelProperty(value="病人ID")
    private Integer brid;
    @ApiModelProperty(value="是否取号")
    private Integer sfqh;
    @ApiModelProperty(value="取号员工")
    private String qhyg;
    @ApiModelProperty(value="取号时间")
    private Timestamp qhsj;
    @ApiModelProperty(value="卡号")
    private String cardno;
    @ApiModelProperty(value="病人性质 | 与patientProperties.xml字典关联")
    private Integer brxz;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="病人性别 | GB/T 2261.1-2003 与gender.xml字典关联")
    private Integer brxb;
    @ApiModelProperty(value="出生年月")
    private Date csny;
    @ApiModelProperty(value="身份证号")
    private String sfzh;
    @ApiModelProperty(value="预约序号")
    private Integer yyxh;
    @ApiModelProperty(value="科室代码")
    private String ksdm;
    @ApiModelProperty(value="医生代码")
    private String ysdm;
    @ApiModelProperty(value="挂号日期")
    private Date ghsj;
    @ApiModelProperty(value="预约日期")
    private Date yyrq;
    @ApiModelProperty(value="值班类别")
    private String zblb;
    @ApiModelProperty(value="叫号号码")
    private String jhhm;
    @ApiModelProperty(value="挂号标志 | 0.预约 1.履约 2.失约 3.收费 4.退约")
    private Integer ghbz;
    @ApiModelProperty(value="联系电话")
    private String lxdh;

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

    public String getQhyg() {
        return qhyg;
    }

    public void setQhyg(String qhyg) {
        this.qhyg = qhyg;
    }

    public Timestamp getQhsj() {
        return qhsj;
    }

    public void setQhsj(Timestamp qhsj) {
        this.qhsj = qhsj;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
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

    public Date getCsny() {
        return csny;
    }

    public void setCsny(Date csny) {
        this.csny = csny;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public Integer getYyxh() {
        return yyxh;
    }

    public void setYyxh(Integer yyxh) {
        this.yyxh = yyxh;
    }

    public String getKsdm() {
        return ksdm;
    }

    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }

    public String getYsdm() {
        return ysdm;
    }

    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }

    public Date getGhsj() {
        return ghsj;
    }

    public void setGhsj(Date ghsj) {
        this.ghsj = ghsj;
    }

    public Date getYyrq() {
        return yyrq;
    }

    public void setYyrq(Date yyrq) {
        this.yyrq = yyrq;
    }

    public String getZblb() {
        return zblb;
    }

    public void setZblb(String zblb) {
        this.zblb = zblb;
    }

    public String getJhhm() {
        return jhhm;
    }

    public void setJhhm(String jhhm) {
        this.jhhm = jhhm;
    }

    public Integer getGhbz() {
        return ghbz;
    }

    public void setGhbz(Integer ghbz) {
        this.ghbz = ghbz;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }
}
