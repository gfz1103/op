package com.buit.commons.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 类名称：FeeYpxz<br>
 * 类描述：公用_药品禁用<br>
 *
 * @author "MLeo"
 */

public class FeeYpxz extends PageQuery {
    @ApiModelProperty(value = "病人性质")
    private Integer brxz;
    @ApiModelProperty(value = "药品序号")
    private Integer ypxh;
    @ApiModelProperty(value = "自负比例")
    private BigDecimal zfbl;
    @ApiModelProperty(value = "药品限额")
    private BigDecimal ypxe;

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


}
