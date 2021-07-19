package com.buit.commons.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckInventoryResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/1 19:07
 */
@ApiModel(value="校验库存信息-返回")
public class CheckInventoryResp {
    @ApiModelProperty(value="标志 1：有库存 -1：无库存")
    private Integer sign;
    @ApiModelProperty(value="库存总量")
    private BigDecimal kczl;

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public BigDecimal getKczl() {
        return kczl;
    }

    public void setKczl(BigDecimal kczl) {
        this.kczl = kczl;
    }
}
