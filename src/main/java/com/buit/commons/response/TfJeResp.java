
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：TfJeResp<br>
 * 类描述：退费金额返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "退费金额返回")
public class TfJeResp extends PageQuery {
	@ApiModelProperty(value = "退费金额")
	private BigDecimal tfje;
	@ApiModelProperty(value = "应收款")
	private BigDecimal ysk;
	@ApiModelProperty(value = "pos号码")
	private String posTraceNumber;

	public BigDecimal getTfje() {
		return tfje;
	}

	public void setTfje(BigDecimal tfje) {
		this.tfje = tfje;
	}

	public BigDecimal getYsk() {
		return ysk;
	}

	public void setYsk(BigDecimal ysk) {
		this.ysk = ysk;
	}

	public String getPosTraceNumber() {
		return posTraceNumber;
	}

	public void setPosTraceNumber(String posTraceNumber) {
		this.posTraceNumber = posTraceNumber;
	}

}