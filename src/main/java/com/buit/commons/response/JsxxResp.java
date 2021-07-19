
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：JsxxResp<br>
 * 类描述：退费结算信息返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "退费结算信息返回")
public class JsxxResp extends PageQuery {
	@ApiModelProperty(value = "")
	private BigDecimal jjzf;
	@ApiModelProperty(value = "总和支付")
	private BigDecimal zhzf;
	@ApiModelProperty(value = "付款方式")
	private Integer fkfs;
	@ApiModelProperty(value = "付款名称")
	private String fkmc;
	@ApiModelProperty(value = "总计金额")
	private BigDecimal zjje;
	@ApiModelProperty(value = "自负金额")
	private BigDecimal zfje;
	@ApiModelProperty(value = "应收款")
	private BigDecimal ysk;
	@ApiModelProperty(value = "发票号码 ")
	private String fphm;
	@ApiModelProperty(value = "发票张数")
	private Integer fpzs;
	@ApiModelProperty(value = "最后发票号码 ")
	private String lastfphm;

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

	public Integer getFkfs() {
		return fkfs;
	}

	public void setFkfs(Integer fkfs) {
		this.fkfs = fkfs;
	}

	public String getFkmc() {
		return fkmc;
	}

	public void setFkmc(String fkmc) {
		this.fkmc = fkmc;
	}

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

	public BigDecimal getYsk() {
		return ysk;
	}

	public void setYsk(BigDecimal ysk) {
		this.ysk = ysk;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public Integer getFpzs() {
		return fpzs;
	}

	public void setFpzs(Integer fpzs) {
		this.fpzs = fpzs;
	}

	public String getLastfphm() {
		return lastfphm;
	}

	public void setLastfphm(String lastfphm) {
		this.lastfphm = lastfphm;
	}

}