package com.buit.commons.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SkinXmHzResp<br>
 * 类描述：<br>
 * 
 * @author WY
 */
@ApiModel(value = "皮试项目汇总")
public class SkinXmHzResp {
	private static final long serialVersionUID = -1615410835010496073L;
	@ApiModelProperty(value = "皮试ID")
	private Integer psid;
	@ApiModelProperty(value = "皮试名称")
	private String psmc;
	@ApiModelProperty(value = "单位")
	private String dw;
	@ApiModelProperty(value = "数量")
	private Integer sl;
	@ApiModelProperty(value = "金额")
	private BigDecimal je;
	@ApiModelProperty(value = "费用序号")
	private Integer fyxh;

	public Integer getPsid() {
		return psid;
	}

	public void setPsid(Integer psid) {
		this.psid = psid;
	}

	public String getPsmc() {
		return psmc;
	}

	public void setPsmc(String psmc) {
		this.psmc = psmc;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public Integer getSl() {
		return sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getFyxh() {
		return fyxh;
	}

	public void setFyxh(Integer fyxh) {
		this.fyxh = fyxh;
	}

}
