
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryTfFkxxResp<br>
 * 类描述：退费处理付款方式返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "退费处理付款方式返回")
public class QueryTfFkxxResp extends PageQuery {
	@ApiModelProperty(value = "付款金额")
	private BigDecimal fkje;
	@ApiModelProperty(value = "付款名称")
	private String fkmc;
	@ApiModelProperty(value = "付款方式")
	private Integer fkfs;

	public BigDecimal getFkje() {
		return fkje;
	}

	public void setFkje(BigDecimal fkje) {
		this.fkje = fkje;
	}

	public String getFkmc() {
		return fkmc;
	}

	public void setFkmc(String fkmc) {
		this.fkmc = fkmc;
	}

	public Integer getFkfs() {
		return fkfs;
	}

	public void setFkfs(Integer fkfs) {
		this.fkfs = fkfs;
	}

}