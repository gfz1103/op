
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：CheckKsfyResp<br>
 * 类描述：检查科室费用<br>
 * 
 * @author WY
 */
@ApiModel(value = "检查科室费用")
public class CheckKsfyResp extends PageQuery {
	@ApiModelProperty(value = "诊疗费")
	private BigDecimal zlf;
	@ApiModelProperty(value = "挂号费")
	private BigDecimal ghf;

	public BigDecimal getZlf() {
		return zlf;
	}

	public void setZlf(BigDecimal zlf) {
		this.zlf = zlf;
	}

	public BigDecimal getGhf() {
		return ghf;
	}

	public void setGhf(BigDecimal ghf) {
		this.ghf = ghf;
	}

}