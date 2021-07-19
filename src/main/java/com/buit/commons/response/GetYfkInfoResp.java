
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：GetYfkInfoResp<br>
 * 类描述：根据发票号码查询预付款<br>
 * 
 * @author WY
 */
@ApiModel(value = "根据发票号码查询预付款")
public class GetYfkInfoResp extends PageQuery {
	@ApiModelProperty(value = "金额")
	private BigDecimal amount;
	@ApiModelProperty(value = "余额")
	private BigDecimal ye;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getYe() {
		return ye;
	}

	public void setYe(BigDecimal ye) {
		this.ye = ye;
	}

}