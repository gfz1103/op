package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：FeeYpxzYpxzResp<br>
 * 类描述：病人性质药品限制<br>
 *
 * @author liushijie
 */
@ApiModel(value = "病人性质药品限制")
public class FeeYpxzYpxzResp {
    @ApiModelProperty(value = "病人性质")
    private Integer brxz;
    @ApiModelProperty(value = "药品序号")
    private Integer ypxh;
    @ApiModelProperty(value = "自负比例")
    private BigDecimal zfbl;
    @ApiModelProperty(value = "药品限额")
    private BigDecimal ypxe;
    @ApiModelProperty(value = "药品名称")
    private String ypmc;
    @ApiModelProperty(value = "药品规格")
    private String ypgg;
    @ApiModelProperty(value = "药品单位")
    private String ypdw;

    /**
     * 设置:病人性质
     */
    public void setBrxz(Integer value) {
        this.brxz = value;
    }

    /**
     * 获取:病人性质
     */
    public Integer getBrxz() {
        return brxz;
    }

    /**
     * 设置:药品序号
     */
    public void setYpxh(Integer value) {
        this.ypxh = value;
    }

    /**
     * 获取:药品序号
     */
    public Integer getYpxh() {
        return ypxh;
    }

    /**
     * 设置:自负比例
     */
    public void setZfbl(BigDecimal value) {
        this.zfbl = value;
    }

    /**
     * 获取:自负比例
     */
    public BigDecimal getZfbl() {
        return zfbl;
    }

    /**
     * 设置:药品限额
     */
    public void setYpxe(BigDecimal value) {
        this.ypxe = value;
    }

    /**
     * 获取:药品限额
     */
    public BigDecimal getYpxe() {
        return ypxe;
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

    public String getYpdw() {
        return ypdw;
    }

    public void setYpdw(String ypdw) {
        this.ypdw = ypdw;
    }
}
