package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Author weijing
 * @Date 2021-01-12 09:42
 * @Description
 **/
@ApiModel("医技组套详情信息")
public class YjztDetailResp {
    @ApiModelProperty("医技序号")
    private Integer yjxh;

    @ApiModelProperty("项目名称（费用名称）")
    private String xmmc;

    @ApiModelProperty("单价")
    private BigDecimal yldj;

    @ApiModelProperty("自负比例")
    private BigDecimal zfbl;

    @ApiModelProperty("医疗数量")
    private BigDecimal ylsl;

    @ApiModelProperty("划价金额")
    private BigDecimal hjje;

    public Integer getYjxh() {
        return yjxh;
    }

    public void setYjxh(Integer yjxh) {
        this.yjxh = yjxh;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public BigDecimal getYldj() {
        return yldj;
    }

    public void setYldj(BigDecimal yldj) {
        this.yldj = yldj;
    }

    public BigDecimal getZfbl() {
        return zfbl;
    }

    public void setZfbl(BigDecimal zfbl) {
        this.zfbl = zfbl;
    }

    public BigDecimal getYlsl() {
        return ylsl;
    }

    public void setYlsl(BigDecimal ylsl) {
        this.ylsl = ylsl;
    }

    public BigDecimal getHjje() {
        return hjje;
    }

    public void setHjje(BigDecimal hjje) {
        this.hjje = hjje;
    }
}
