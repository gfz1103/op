package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Author weijing
 * @Date 2021-03-26 09:41
 * @Description
 **/
@ApiModel(value = "处方药品详情")
public class DrugDetailResponse {
    @ApiModelProperty(value = "处方贴数 针对草药方")
    private String cfts;

    @ApiModelProperty(value = "煎法 针对草药方")
    private String jf;

    @ApiModelProperty(value = "药品名称")
    private String ypmc;

    @ApiModelProperty(value = "药品规格")
    private String ypgg;

    @ApiModelProperty(value = "一次剂量 搭配jldw")
    private BigDecimal ycjl;

    @ApiModelProperty(value = "剂量单位")
    private String jldw;

    @ApiModelProperty(value = "用药频次 每日一次")
    private String yypc;

    @ApiModelProperty(value = "给药途径 口服/静滴")
    private String gytj;

    @ApiModelProperty(value = "开药总量 搭配zldw")
    private BigDecimal ypzl;

    @ApiModelProperty(value = "总量单位")
    private String zldw;

    @ApiModelProperty(value = "组号 分组使用")
    private Integer ypzh;

    @ApiModelProperty(value = "备注信息")
    private String bzxx;

    public String getBzxx() {
        return bzxx;
    }

    public void setBzxx(String bzxx) {
        this.bzxx = bzxx;
    }

    public String getCfts() {
        return cfts;
    }

    public void setCfts(String cfts) {
        this.cfts = cfts;
    }

    public String getJf() {
        return jf;
    }

    public void setJf(String jf) {
        this.jf = jf;
    }

    public Integer getYpzh() {
        return ypzh;
    }

    public void setYpzh(Integer ypzh) {
        this.ypzh = ypzh;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getYpgg() {
        return ypgg;
    }

    public void setYpgg(String ypgg) {
        this.ypgg = ypgg;
    }

    public BigDecimal getYcjl() {
        return ycjl;
    }

    public void setYcjl(BigDecimal ycjl) {
        this.ycjl = ycjl;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public String getYypc() {
        return yypc;
    }

    public void setYypc(String yypc) {
        this.yypc = yypc;
    }

    public String getGytj() {
        return gytj;
    }

    public void setGytj(String gytj) {
        this.gytj = gytj;
    }

    public BigDecimal getYpzl() {
        return ypzl;
    }

    public void setYpzl(BigDecimal ypzl) {
        this.ypzl = ypzl;
    }

    public String getZldw() {
        return zldw;
    }

    public void setZldw(String zldw) {
        this.zldw = zldw;
    }
}
