
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：FeeXmzxks<br>
 * 类描述：<br>
 * @author 老花生
 */
@ApiModel(value="物资和字典查询返回对象")
public class FeeXmzxksAndWlwzzdResp extends  PageQuery{
    @ApiModelProperty(value="物资名称")
    private String wzmc;
    @ApiModelProperty(value="物资序号")
    private Integer wzxh;
    @ApiModelProperty(value="物资数量")
    private BigDecimal wzsl;

    public String getWzmc() {
        return wzmc;
    }

    public void setWzmc(String wzmc) {
        this.wzmc = wzmc;
    }

    public Integer getWzxh() {
        return wzxh;
    }

    public void setWzxh(Integer wzxh) {
        this.wzxh = wzxh;
    }

    public BigDecimal getWzsl() {
        return wzsl;
    }

    public void setWzsl(BigDecimal wzsl) {
        this.wzsl = wzsl;
    }
}
