
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MzfpYpResp<br>
 * 类描述：收费结算发票打印药品返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "收费结算发票打印药品返回")
public class MzfpYpResp extends PageQuery {
	private static final long serialVersionUID = -4516237327658866382L;
	@ApiModelProperty(value = "项目编码")
	private String mxbm;
	@ApiModelProperty(value = "项目名称")
	private String mxmc;
	@ApiModelProperty(value = "药品规格")
	private String mxgg;
	@ApiModelProperty(value = "药品数量")
	private BigDecimal mxsl;
	@ApiModelProperty(value = "药品单价")
	private BigDecimal mxdj;
	@ApiModelProperty(value = "药品金额")
	private BigDecimal mxje;
	@ApiModelProperty(value = "药房单位")
	private String yfdw;


	public String getMxbm() {
		return mxbm;
	}

	public void setMxbm(String mxbm) {
		this.mxbm = mxbm;
	}

	public String getMxmc() {
		return mxmc;
	}

	public void setMxmc(String mxmc) {
		this.mxmc = mxmc;
	}

	public String getMxgg() {
		return mxgg;
	}

	public void setMxgg(String mxgg) {
		this.mxgg = mxgg;
	}

	public BigDecimal getMxsl() {
		return mxsl;
	}

	public void setMxsl(BigDecimal mxsl) {
		this.mxsl = mxsl;
	}

	public BigDecimal getMxdj() {
		return mxdj;
	}

	public void setMxdj(BigDecimal mxdj) {
		this.mxdj = mxdj;
	}

	public BigDecimal getMxje() {
		return mxje;
	}

	public void setMxje(BigDecimal mxje) {
		this.mxje = mxje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getYfdw() {
		return yfdw;
	}

	public void setYfdw(String yfdw) {
		this.yfdw = yfdw;
	}
}