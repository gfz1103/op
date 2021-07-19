package com.buit.cis.op.dctwork.ybtspost.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author weijing
 * @Date 2021-04-13 08:56
 * @Description
 **/
@ApiModel(value = "录入处方数据")
public class CfRequest {
    @ApiModelProperty(value = "就诊流水号",required=true)
    @NotBlank(message = "就诊流水号必填")
    private String jzlsh;

    @ApiModelProperty(value = "药品序号",required=true)
    @NotNull(message = "药品序号必填")
    private Integer ypxh;

    @ApiModelProperty(value = "药品名称",required=true)
    @NotNull(message = "药品名称必填")
    private String ypmc;

    @ApiModelProperty(value = "药品产地",required=true)
    @NotNull(message = "药品产地必填")
    private Integer ypcd;

    @ApiModelProperty(value = "药品规格(剂量)",required=true)
    @NotBlank(message = "药品规格（剂量）必填")
    private String ypgg;

    @ApiModelProperty(value = "单次用药数量",required=true)
    @NotNull(message = "单次用药数量必填")
    private BigDecimal dcypsl;

    @ApiModelProperty(value = "单次用药单位",required=true)
    @NotBlank(message = "单次用药单位必填")
    private String dcypdw;

    @ApiModelProperty(value = "用药途径代码",required=true)
    @NotBlank(message = "用药途径代码必填")
    private String yytjdm;

    @ApiModelProperty(value = "用药途径",required=true)
    @NotBlank(message = "用药途径必填")
    private String yytj;

    @ApiModelProperty(value = "用药频次代码",required=true)
    @NotBlank(message = "用药频次代码必填")
    private String yypcdm;

    @ApiModelProperty(value = "用药频次",required=true)
    @NotBlank(message = "用药频次必填")
    private String yypc;

    @ApiModelProperty(value = "发药数量",required=true)
    @NotNull(message = "发药数量必填")
    private BigDecimal fysl;

    @ApiModelProperty(value = "发药数量单位",required=true)
    @NotBlank(message = "发药数量单位必填")
    private String fysldw;

    @ApiModelProperty(value = "用药天数",required=true)
    @NotNull(message = "用药天数必填")
    private BigDecimal yyts;

    @ApiModelProperty(value = "药品单价",required=true)
    @NotNull(message = "药品单价必填")
    private BigDecimal ypdj;

    @ApiModelProperty(value = "编码类型 10：医保发布的统编明细项目代码 11：非医保发布的医院内自编明细项目代码",hidden = true)
    private String bmlx;

    @ApiModelProperty(value = "费用类别",hidden = true)
    private String fylb;

    @ApiModelProperty(value = "医院药品代码",hidden = true)
    private String yyypdm;

    @ApiModelProperty(value = "医保药品代码",hidden = true)
    private String ybypdm;

    @ApiModelProperty(value = "包装规格单位",hidden = true)
    private String bzggdw;

    @ApiModelProperty(value = "包装规格单位内含基本使用数量",hidden = true)
    private String bzdwsly;

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
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

    public Integer getYpcd() {
        return ypcd;
    }

    public void setYpcd(Integer ypcd) {
        this.ypcd = ypcd;
    }

    public String getYpgg() {
        return ypgg;
    }

    public void setYpgg(String ypgg) {
        this.ypgg = ypgg;
    }

    public BigDecimal getDcypsl() {
        return dcypsl;
    }

    public void setDcypsl(BigDecimal dcypsl) {
        this.dcypsl = dcypsl;
    }

    public String getDcypdw() {
        return dcypdw;
    }

    public void setDcypdw(String dcypdw) {
        this.dcypdw = dcypdw;
    }

    public String getYytjdm() {
        return yytjdm;
    }

    public void setYytjdm(String yytjdm) {
        this.yytjdm = yytjdm;
    }

    public String getYytj() {
        return yytj;
    }

    public void setYytj(String yytj) {
        this.yytj = yytj;
    }

    public String getYypcdm() {
        return yypcdm;
    }

    public void setYypcdm(String yypcdm) {
        this.yypcdm = yypcdm;
    }

    public String getYypc() {
        return yypc;
    }

    public void setYypc(String yypc) {
        this.yypc = yypc;
    }

    public BigDecimal getFysl() {
        return fysl;
    }

    public void setFysl(BigDecimal fysl) {
        this.fysl = fysl;
    }

    public String getFysldw() {
        return fysldw;
    }

    public void setFysldw(String fysldw) {
        this.fysldw = fysldw;
    }

    public BigDecimal getYyts() {
        return yyts;
    }

    public void setYyts(BigDecimal yyts) {
        this.yyts = yyts;
    }

    public BigDecimal getYpdj() {
        return ypdj;
    }

    public void setYpdj(BigDecimal ypdj) {
        this.ypdj = ypdj;
    }

    public String getBmlx() {
        return bmlx;
    }

    public void setBmlx(String bmlx) {
        this.bmlx = bmlx;
    }

    public String getFylb() {
        return fylb;
    }

    public void setFylb(String fylb) {
        this.fylb = fylb;
    }

    public String getYyypdm() {
        return yyypdm;
    }

    public void setYyypdm(String yyypdm) {
        this.yyypdm = yyypdm;
    }

    public String getYbypdm() {
        return ybypdm;
    }

    public void setYbypdm(String ybypdm) {
        this.ybypdm = ybypdm;
    }

    public String getBzggdw() {
        return bzggdw;
    }

    public void setBzggdw(String bzggdw) {
        this.bzggdw = bzggdw;
    }

    public String getBzdwsly() {
        return bzdwsly;
    }

    public void setBzdwsly(String bzdwsly) {
        this.bzdwsly = bzdwsly;
    }
}
