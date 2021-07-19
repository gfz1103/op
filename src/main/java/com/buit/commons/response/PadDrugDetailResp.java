package com.buit.commons.response;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/7/5 16:48
 */
public class PadDrugDetailResp {

    @ApiModelProperty("药品数量")
    private BigDecimal ypsl;
    @ApiModelProperty("药品名称")
    private String ypmc;
    @ApiModelProperty("药品单位")
    private String ypdw;
    @ApiModelProperty("药品规格")
    private String ypgg;
    @ApiModelProperty("药品用法")
    private String ypyf;
    private String yptm;

    public BigDecimal getYpsl() {
        return ypsl;
    }

    public void setYpsl(BigDecimal ypsl) {
        this.ypsl = ypsl;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getYpdw() {
        return ypdw;
    }

    public void setYpdw(String ypdw) {
        this.ypdw = ypdw;
    }

    public String getYpgg() {
        return ypgg;
    }

    public void setYpgg(String ypgg) {
        this.ypgg = ypgg;
    }

    public String getYpyf() {
        return ypyf;
    }

    public void setYpyf(String ypyf) {
        this.ypyf = ypyf;
    }

    public String getYptm() {
        return yptm;
    }

    public void setYptm(String yptm) {
        this.yptm = yptm;
    }
}
