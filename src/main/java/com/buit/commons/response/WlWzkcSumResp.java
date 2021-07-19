
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：WlWzkc<br>
 * 类描述：物资库存(WL_WZKC)<br>
 * @author 老花生
 */
@ApiModel(value="物资库存(WL_WZKC)")
public class WlWzkcSumResp extends  PageQuery{

    @ApiModelProperty(value="物资名称")
    private String wzmc;
    @ApiModelProperty(value="物资数量")
    private BigDecimal wzsl;
    @ApiModelProperty(value="预扣数量")
    private BigDecimal yksl;

    public String getWzmc() {
        return wzmc;
    }

    public void setWzmc(String wzmc) {
        this.wzmc = wzmc;
    }

    public BigDecimal getWzsl() {
        return wzsl;
    }

    public void setWzsl(BigDecimal wzsl) {
        this.wzsl = wzsl;
    }

    public BigDecimal getYksl() {
        return yksl;
    }

    public void setYksl(BigDecimal yksl) {
        this.yksl = yksl;
    }
}