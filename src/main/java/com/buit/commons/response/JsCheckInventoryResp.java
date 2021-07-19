
package com.buit.commons.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：检查库存查询返回<br>
 * 
 * @author 汪洋
 */
@ApiModel(value = "检查库存查询返回")
public class JsCheckInventoryResp {
	@ApiModelProperty(value = "零售价格")
	private BigDecimal lsjg;
	@ApiModelProperty(value = "库存数量")
	private BigDecimal kczl;
	@ApiModelProperty(value = "标识")
	private Integer sign;

	public BigDecimal getLsjg() {
		return lsjg;
	}

	public void setLsjg(BigDecimal lsjg) {
		this.lsjg = lsjg;
	}

	public BigDecimal getKczl() {
		return kczl;
	}

	public void setKczl(BigDecimal kczl) {
		this.kczl = kczl;
	}

	public Integer getSign() {
		return sign;
	}

	public void setSign(Integer sign) {
		this.sign = sign;
	}

}