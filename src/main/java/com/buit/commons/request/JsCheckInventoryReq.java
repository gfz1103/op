
package com.buit.commons.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：检查库存查询请求<br>
 * 
 * @author 汪洋
 */
@ApiModel(value = "检查库存查询请求")
public class JsCheckInventoryReq {
	@NotNull(message = "药房编号不能为空")
	@ApiModelProperty(value = "药房编号", required = true)
	private Integer pharmId;
	@NotNull(message = "药品编号不能为空")
	@ApiModelProperty(value = "药品编号", required = true)
	private Integer medId;
	@NotNull(message = "药品产地不能为空")
	@ApiModelProperty(value = "药品产地", required = true)
	private Integer medsource;
	@ApiModelProperty(value = "药品总量", required = true)
	private String quantity;
	@ApiModelProperty(value = "零售价格", required = true)
	private BigDecimal lsjg;
	@ApiModelProperty(value = "药品名称", required = true)
	private String ypmc;

	public Integer getPharmId() {
		return pharmId;
	}

	public void setPharmId(Integer pharmId) {
		this.pharmId = pharmId;
	}

	public Integer getMedId() {
		return medId;
	}

	public void setMedId(Integer medId) {
		this.medId = medId;
	}

	public Integer getMedsource() {
		return medsource;
	}

	public void setMedsource(Integer medsource) {
		this.medsource = medsource;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getLsjg() {
		return lsjg;
	}

	public void setLsjg(BigDecimal lsjg) {
		this.lsjg = lsjg;
	}

	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

}