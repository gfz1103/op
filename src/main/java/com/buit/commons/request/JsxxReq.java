
package com.buit.commons.request;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：JsxxReq<br>
 * 类描述：结算信息请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "结算信息请求")
public class JsxxReq extends PageQuery {
	private static final long serialVersionUID = -4335337073935209660L;
	@ApiModelProperty(value = "总计金额")
	private BigDecimal zjje;
	@ApiModelProperty(value = "自负金额")
	private BigDecimal zfje;
	@ApiModelProperty(value = "")
	private BigDecimal jjzf;
	@ApiModelProperty(value = "总和支付")
	private BigDecimal zhzf;
	@ApiModelProperty(value = "结算次数")
	private Integer jscs;
	@ApiModelProperty(value = "医疗类别")
	private Integer yllb;
	@ApiModelProperty(value = "医技序号")
	private Integer jyxh;
	@ApiModelProperty(value = "")
	private Integer yylsh;

	public BigDecimal getZjje() {
		return zjje;
	}

	public void setZjje(BigDecimal zjje) {
		this.zjje = zjje;
	}

	public BigDecimal getZfje() {
		return zfje;
	}

	public void setZfje(BigDecimal zfje) {
		this.zfje = zfje;
	}

	public BigDecimal getJjzf() {
		return jjzf;
	}

	public void setJjzf(BigDecimal jjzf) {
		this.jjzf = jjzf;
	}

	public BigDecimal getZhzf() {
		return zhzf;
	}

	public void setZhzf(BigDecimal zhzf) {
		this.zhzf = zhzf;
	}

	public Integer getJscs() {
		return jscs;
	}

	public void setJscs(Integer jscs) {
		this.jscs = jscs;
	}

	public Integer getYllb() {
		return yllb;
	}

	public void setYllb(Integer yllb) {
		this.yllb = yllb;
	}

	public Integer getJyxh() {
		return jyxh;
	}

	public void setJyxh(Integer jyxh) {
		this.jyxh = jyxh;
	}

	public Integer getYylsh() {
		return yylsh;
	}

	public void setYylsh(Integer yylsh) {
		this.yylsh = yylsh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}