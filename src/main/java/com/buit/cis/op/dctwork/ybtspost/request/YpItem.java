package com.buit.cis.op.dctwork.ybtspost.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Author weijing
 * @Date 2021-04-09 13:46
 * @Description
 **/
@ApiModel(value = "药品节点")
public class YpItem {
    @ApiModelProperty(value = "编码类型 10：医保发布的统编明细项目代码 11：非医保发布的医院内自编明细项目代码")
    private String BMLX;

    @ApiModelProperty(value = "费用类别")
    private String FYLB;

    @ApiModelProperty(value = "药品名称")
    private String YPMC;

    @ApiModelProperty(value = "医院药品代码")
    private String YYYPDM;

    @ApiModelProperty(value = "医保药品代码")
    private String YBYPDM;

    @ApiModelProperty(value = "包装规格单位")
    private String BZGGDW;

    @ApiModelProperty(value = "包装规格单位内含基本使用数量")
    private String BZDWSLY;

    @ApiModelProperty(value = "药品规格(剂量)")
    private String YPGG;

    @ApiModelProperty(value = "单次用药数量")
    private BigDecimal DCYPSL;

    @ApiModelProperty(value = "单次用药单位")
    private String DCYPDW;

    @ApiModelProperty(value = "用药途径代码")
    private String YYTJDM;

    @ApiModelProperty(value = "用药途径")
    private String YYTJ;

    @ApiModelProperty(value = "用药频次代码")
    private String YYPCDM;

    @ApiModelProperty(value = "用药频次")
    private String YYPC;

    @ApiModelProperty(value = "发药数量")
    private BigDecimal FYSL;

    @ApiModelProperty(value = "发药数量单位")
    private String FYSLDW;

    @ApiModelProperty(value = "用药天数")
    private BigDecimal YYTS;

    @ApiModelProperty(value = "药品单价")
    private BigDecimal YPDJ;

    public String getBMLX() {
        return BMLX;
    }

    public void setBMLX(String BMLX) {
        this.BMLX = BMLX;
    }

    public String getFYLB() {
        return FYLB;
    }

    public void setFYLB(String FYLB) {
        this.FYLB = FYLB;
    }

    public String getYPMC() {
        return YPMC;
    }

    public void setYPMC(String YPMC) {
        this.YPMC = YPMC;
    }

    public String getYYYPDM() {
        return YYYPDM;
    }

    public void setYYYPDM(String YYYPDM) {
        this.YYYPDM = YYYPDM;
    }

    public String getYBYPDM() {
        return YBYPDM;
    }

    public void setYBYPDM(String YBYPDM) {
        this.YBYPDM = YBYPDM;
    }

    public String getBZGGDW() {
        return BZGGDW;
    }

    public void setBZGGDW(String BZGGDW) {
        this.BZGGDW = BZGGDW;
    }

    public String getBZDWSLY() {
        return BZDWSLY;
    }

    public void setBZDWSLY(String BZDWSLY) {
        this.BZDWSLY = BZDWSLY;
    }

    public String getYPGG() {
        return YPGG;
    }

    public void setYPGG(String YPGG) {
        this.YPGG = YPGG;
    }

    public BigDecimal getDCYPSL() {
        return DCYPSL;
    }

    public void setDCYPSL(BigDecimal DCYPSL) {
        this.DCYPSL = DCYPSL;
    }

    public String getDCYPDW() {
        return DCYPDW;
    }

    public void setDCYPDW(String DCYPDW) {
        this.DCYPDW = DCYPDW;
    }

    public String getYYTJDM() {
        return YYTJDM;
    }

    public void setYYTJDM(String YYTJDM) {
        this.YYTJDM = YYTJDM;
    }

    public String getYYTJ() {
        return YYTJ;
    }

    public void setYYTJ(String YYTJ) {
        this.YYTJ = YYTJ;
    }

    public String getYYPCDM() {
        return YYPCDM;
    }

    public void setYYPCDM(String YYPCDM) {
        this.YYPCDM = YYPCDM;
    }

    public String getYYPC() {
        return YYPC;
    }

    public void setYYPC(String YYPC) {
        this.YYPC = YYPC;
    }

    public BigDecimal getFYSL() {
        return FYSL;
    }

    public void setFYSL(BigDecimal FYSL) {
        this.FYSL = FYSL;
    }

    public String getFYSLDW() {
        return FYSLDW;
    }

    public void setFYSLDW(String FYSLDW) {
        this.FYSLDW = FYSLDW;
    }

    public BigDecimal getYYTS() {
        return YYTS;
    }

    public void setYYTS(BigDecimal YYTS) {
        this.YYTS = YYTS;
    }

    public BigDecimal getYPDJ() {
        return YPDJ;
    }

    public void setYPDJ(BigDecimal YPDJ) {
        this.YPDJ = YPDJ;
    }
}
