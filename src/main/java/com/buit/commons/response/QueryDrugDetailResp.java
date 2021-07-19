package com.buit.commons.response;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/8/17 9:19
 */
public class QueryDrugDetailResp {

    @ApiModelProperty("药品名称")
    private String ypmc;
    @ApiModelProperty("产地名称")
    private String cdmc;
    @ApiModelProperty("通用名称")
    private String tymc;
    @ApiModelProperty("识别序号")
    private Integer sbxh;
    @ApiModelProperty("处方识别")
    private Integer cfsb;
    @ApiModelProperty("药品编码")
    private String ypbm;
    @ApiModelProperty("药房规格")
    private String yfgg;
    @ApiModelProperty("药品序号")
    private Integer ypxh;
    @ApiModelProperty("药房单位")
    private String yfdw;
    @ApiModelProperty("药品数量")
    private BigDecimal ypsl;
    @ApiModelProperty("药品单价")
    private BigDecimal ypdj;
    @ApiModelProperty("合计金额")
    private BigDecimal hjje;
    @ApiModelProperty("支付比例")
    private BigDecimal zfbl;
    @ApiModelProperty("处方贴数")
    private Integer cfts;
    @ApiModelProperty("频次")
    private String ypyf;
    @ApiModelProperty("一次计量")
    private BigDecimal ycjl;
    @ApiModelProperty("药品用法")
    private String gytj;
    @ApiModelProperty("天数")
    private Integer yyts;
    @ApiModelProperty("库存数量")
    private BigDecimal kcsl;
    @ApiModelProperty("药品产地")
    private Integer ypcd;
    @ApiModelProperty("转方药品")
    private Integer zfyp;

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getCdmc() {
        return cdmc;
    }

    public void setCdmc(String cdmc) {
        this.cdmc = cdmc;
    }

    public String getTymc() {
        return tymc;
    }

    public void setTymc(String tymc) {
        this.tymc = tymc;
    }

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public Integer getCfsb() {
        return cfsb;
    }

    public void setCfsb(Integer cfsb) {
        this.cfsb = cfsb;
    }

    public String getYpbm() {
        return ypbm;
    }

    public void setYpbm(String ypbm) {
        this.ypbm = ypbm;
    }

    public String getYfgg() {
        return yfgg;
    }

    public void setYfgg(String yfgg) {
        this.yfgg = yfgg;
    }

    public Integer getYpxh() {
        return ypxh;
    }

    public void setYpxh(Integer ypxh) {
        this.ypxh = ypxh;
    }

    public String getYfdw() {
        return yfdw;
    }

    public void setYfdw(String yfdw) {
        this.yfdw = yfdw;
    }

    public BigDecimal getYpsl() {
        return ypsl;
    }

    public void setYpsl(BigDecimal ypsl) {
        this.ypsl = ypsl;
    }

    public BigDecimal getYpdj() {
        return ypdj;
    }

    public void setYpdj(BigDecimal ypdj) {
        this.ypdj = ypdj;
    }

    public BigDecimal getHjje() {
        return hjje;
    }

    public void setHjje(BigDecimal hjje) {
        this.hjje = hjje;
    }

    public BigDecimal getZfbl() {
        return zfbl;
    }

    public void setZfbl(BigDecimal zfbl) {
        this.zfbl = zfbl;
    }

    public Integer getCfts() {
        return cfts;
    }

    public void setCfts(Integer cfts) {
        this.cfts = cfts;
    }

    public String getYpyf() {
        return ypyf;
    }

    public void setYpyf(String ypyf) {
        this.ypyf = ypyf;
    }

    public BigDecimal getYcjl() {
        return ycjl;
    }

    public void setYcjl(BigDecimal ycjl) {
        this.ycjl = ycjl;
    }

    public String getGytj() {
        return gytj;
    }

    public void setGytj(String gytj) {
        this.gytj = gytj;
    }

    public Integer getYyts() {
        return yyts;
    }

    public void setYyts(Integer yyts) {
        this.yyts = yyts;
    }

    public BigDecimal getKcsl() {
        return kcsl;
    }

    public void setKcsl(BigDecimal kcsl) {
        this.kcsl = kcsl;
    }

    public Integer getYpcd() {
        return ypcd;
    }

    public void setYpcd(Integer ypcd) {
        this.ypcd = ypcd;
    }

    public Integer getZfyp() {
        return zfyp;
    }

    public void setZfyp(Integer zfyp) {
        this.zfyp = zfyp;
    }
}
