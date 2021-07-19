package com.buit.commons.response;

import com.buit.commons.dto.DrugDetailDto;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/8/14 16:11
 */
public class RefundDrugDetailResp extends DrugDetailDto {

    @ApiModelProperty("发药数量")
    private BigDecimal fysl;
    @ApiModelProperty("退药数量")
    private BigDecimal tysl;
    @ApiModelProperty("处方组号")
    private Integer ypzh;
    @ApiModelProperty("识别序号")
    private Integer sbxh;

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public Integer getYpzh() {
        return ypzh;
    }

    public void setYpzh(Integer ypzh) {
        this.ypzh = ypzh;
    }

    public BigDecimal getFysl() {
        return fysl;
    }

    public void setFysl(BigDecimal fysl) {
        this.fysl = fysl;
    }

    public BigDecimal getTysl() {
        return tysl;
    }

    public void setTysl(BigDecimal tysl) {
        this.tysl = tysl;
    }
}
