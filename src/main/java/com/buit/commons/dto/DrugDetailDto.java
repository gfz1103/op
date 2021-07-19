package com.buit.commons.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/8/14 16:12
 */
public class DrugDetailDto {

    @ApiModelProperty("药品序号")
    private Integer ypxh;
    @ApiModelProperty("药品名称")
    private String ypmc;
    @ApiModelProperty("药品规格")
    private String yfgg;
    @ApiModelProperty("药品批号")
    private String ypph;
    @ApiModelProperty("药房单位")
    private String yfdw;
    @ApiModelProperty("药品产地")
    private Integer ypcd;
    @ApiModelProperty("产地名称")
    private String cdmc;
    @ApiModelProperty("零售价格")
    private BigDecimal lsjg;
    @ApiModelProperty("进货价格")
    private BigDecimal jhjg;

    public BigDecimal getJhjg() {
        return jhjg;
    }

    public void setJhjg(BigDecimal jhjg) {
        this.jhjg = jhjg;
    }

    public Integer getYpxh() {
        return ypxh;
    }

    public void setYpxh(Integer ypxh) {
        this.ypxh = ypxh;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getYfgg() {
        return yfgg;
    }

    public void setYfgg(String yfgg) {
        this.yfgg = yfgg;
    }

    public String getYpph() {
        return ypph;
    }

    public void setYpph(String ypph) {
        this.ypph = ypph;
    }

    public String getYfdw() {
        return yfdw;
    }

    public void setYfdw(String yfdw) {
        this.yfdw = yfdw;
    }

    public Integer getYpcd() {
        return ypcd;
    }

    public void setYpcd(Integer ypcd) {
        this.ypcd = ypcd;
    }

    public String getCdmc() {
        return cdmc;
    }

    public void setCdmc(String cdmc) {
        this.cdmc = cdmc;
    }

    public BigDecimal getLsjg() {
        return lsjg;
    }

    public void setLsjg(BigDecimal lsjg) {
        this.lsjg = lsjg;
    }
}
