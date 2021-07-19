package com.buit.commons.request;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class OpFkxxReq {

    @ApiModelProperty(value = "付款方式")
    private Integer fkfs;

    @ApiModelProperty(value = "付款金额")
    private BigDecimal fkje;

    public Integer getFkfs() {
        return fkfs;
    }

    public void setFkfs(Integer fkfs) {
        this.fkfs = fkfs;
    }

    public BigDecimal getFkje() {
        return fkje;
    }

    public void setFkje(BigDecimal fkje) {
        this.fkje = fkje;
    }
}
