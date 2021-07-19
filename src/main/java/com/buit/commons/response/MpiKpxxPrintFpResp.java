package com.buit.commons.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;


@ApiModel(value="充值_充值收费发票信息")
public class MpiKpxxPrintFpResp {
    @ApiModelProperty(value="记录序号")
    private Integer jlxh;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="充值日期")
    private Timestamp czrq;
    @ApiModelProperty(value="充值方式")
    private Integer czfs;
    @ApiModelProperty(value="充值金额")
    private BigDecimal czje;
    @ApiModelProperty(value="操作工号")
    private String czgh;
    @ApiModelProperty(value="票据号码")
    private String czpj;
    @ApiModelProperty(value="就诊卡号")
    private String jzkh;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="收费员姓名")
    private String czxm;
    @ApiModelProperty(value="病人性别")
    private String brxb;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public Timestamp getCzrq() {
        return czrq;
    }

    public void setCzrq(Timestamp czrq) {
        this.czrq = czrq;
    }

    public Integer getCzfs() {
        return czfs;
    }

    public void setCzfs(Integer czfs) {
        this.czfs = czfs;
    }

    public BigDecimal getCzje() {
        return czje;
    }

    public void setCzje(BigDecimal czje) {
        this.czje = czje;
    }

    public String getCzgh() {
        return czgh;
    }

    public void setCzgh(String czgh) {
        this.czgh = czgh;
    }

    public String getCzpj() {
        return czpj;
    }

    public void setCzpj(String czpj) {
        this.czpj = czpj;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getCzxm() {
        return czxm;
    }

    public void setCzxm(String czxm) {
        this.czxm = czxm;
    }

    public String getBrxb() {
        return brxb;
    }

    public void setBrxb(String brxb) {
        this.brxb = brxb;
    }
}
