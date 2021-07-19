
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：医保明细对账<br>
 * 
 * @author beijunhua
 */
@ApiModel(value = "医保明细对账")
public class MxdzResp extends PageQuery {
	@ApiModelProperty(value = "本地当年账户总额")
	private BigDecimal bd_dnzf;
	@ApiModelProperty(value = "本地历年账户总额")
	private BigDecimal bd_lnzf;
	@ApiModelProperty(value = "本地现金支付总额")
	private BigDecimal bd_xjzf;
	@ApiModelProperty(value = "本地统筹支付总额")
	private BigDecimal bd_tczf;
	@ApiModelProperty(value = "本地地方附加总额")
	private BigDecimal bd_fjzf;
	@ApiModelProperty(value = "本地分类自付总额")
	private BigDecimal bd_flzf;
	@ApiModelProperty(value = "本地纯自付总额")
	private BigDecimal bd_czf;
	@ApiModelProperty(value = "本地流水号")
	private BigDecimal bd_lsh;

	@ApiModelProperty(value = "门诊当年账户总额")
	private BigDecimal op_dnzf;
	@ApiModelProperty(value = "门诊历年账户总额")
	private BigDecimal op_lnzf;
	@ApiModelProperty(value = "门诊现金支付总额")
	private BigDecimal op_xjzf;
	@ApiModelProperty(value = "门诊统筹支付总额")
	private BigDecimal op_tczf;
	@ApiModelProperty(value = "门诊地方附加总额")
	private BigDecimal op_fjzf;
	@ApiModelProperty(value = "门诊分类自付总额")
	private BigDecimal op_flzf;
	@ApiModelProperty(value = "门诊纯自付总额")
	private BigDecimal op_czf;
	@ApiModelProperty(value = "门诊流水号")
	private BigDecimal op_lsh;

	@ApiModelProperty(value = "住院当年账户总额")
	private BigDecimal im_dnzf;
	@ApiModelProperty(value = "住院历年账户总额")
	private BigDecimal im_lnzf;
	@ApiModelProperty(value = "住院现金支付总额")
	private BigDecimal im_xjzf;
	@ApiModelProperty(value = "住院统筹支付总额")
	private BigDecimal im_tczf;
	@ApiModelProperty(value = "住院地方附加总额")
	private BigDecimal im_fjzf;
	@ApiModelProperty(value = "住院分类自付总额")
	private BigDecimal im_flzf;
	@ApiModelProperty(value = "住院纯自付总额")
	private BigDecimal im_czf;
	@ApiModelProperty(value = "住院流水号")
	private BigDecimal im_lsh;

	public BigDecimal getBd_dnzf() {
		return bd_dnzf;
	}

	public void setBd_dnzf(BigDecimal bd_dnzf) {
		this.bd_dnzf = bd_dnzf;
	}

	public BigDecimal getBd_lnzf() {
		return bd_lnzf;
	}

	public void setBd_lnzf(BigDecimal bd_lnzf) {
		this.bd_lnzf = bd_lnzf;
	}

	public BigDecimal getBd_xjzf() {
		return bd_xjzf;
	}

	public void setBd_xjzf(BigDecimal bd_xjzf) {
		this.bd_xjzf = bd_xjzf;
	}

	public BigDecimal getBd_tczf() {
		return bd_tczf;
	}

	public void setBd_tczf(BigDecimal bd_tczf) {
		this.bd_tczf = bd_tczf;
	}

	public BigDecimal getBd_fjzf() {
		return bd_fjzf;
	}

	public void setBd_fjzf(BigDecimal bd_fjzf) {
		this.bd_fjzf = bd_fjzf;
	}

	public BigDecimal getBd_flzf() {
		return bd_flzf;
	}

	public void setBd_flzf(BigDecimal bd_flzf) {
		this.bd_flzf = bd_flzf;
	}

	public BigDecimal getBd_czf() {
		return bd_czf;
	}

	public void setBd_czf(BigDecimal bd_czf) {
		this.bd_czf = bd_czf;
	}

	public BigDecimal getBd_lsh() {
		return bd_lsh;
	}

	public void setBd_lsh(BigDecimal bd_lsh) {
		this.bd_lsh = bd_lsh;
	}

	public BigDecimal getOp_dnzf() {
		return op_dnzf;
	}

	public void setOp_dnzf(BigDecimal op_dnzf) {
		this.op_dnzf = op_dnzf;
	}

	public BigDecimal getOp_lnzf() {
		return op_lnzf;
	}

	public void setOp_lnzf(BigDecimal op_lnzf) {
		this.op_lnzf = op_lnzf;
	}

	public BigDecimal getOp_xjzf() {
		return op_xjzf;
	}

	public void setOp_xjzf(BigDecimal op_xjzf) {
		this.op_xjzf = op_xjzf;
	}

	public BigDecimal getOp_tczf() {
		return op_tczf;
	}

	public void setOp_tczf(BigDecimal op_tczf) {
		this.op_tczf = op_tczf;
	}

	public BigDecimal getOp_fjzf() {
		return op_fjzf;
	}

	public void setOp_fjzf(BigDecimal op_fjzf) {
		this.op_fjzf = op_fjzf;
	}

	public BigDecimal getOp_flzf() {
		return op_flzf;
	}

	public void setOp_flzf(BigDecimal op_flzf) {
		this.op_flzf = op_flzf;
	}

	public BigDecimal getOp_czf() {
		return op_czf;
	}

	public void setOp_czf(BigDecimal op_czf) {
		this.op_czf = op_czf;
	}

	public BigDecimal getOp_lsh() {
		return op_lsh;
	}

	public void setOp_lsh(BigDecimal op_lsh) {
		this.op_lsh = op_lsh;
	}

	public BigDecimal getIm_dnzf() {
		return im_dnzf;
	}

	public void setIm_dnzf(BigDecimal im_dnzf) {
		this.im_dnzf = im_dnzf;
	}

	public BigDecimal getIm_lnzf() {
		return im_lnzf;
	}

	public void setIm_lnzf(BigDecimal im_lnzf) {
		this.im_lnzf = im_lnzf;
	}

	public BigDecimal getIm_xjzf() {
		return im_xjzf;
	}

	public void setIm_xjzf(BigDecimal im_xjzf) {
		this.im_xjzf = im_xjzf;
	}

	public BigDecimal getIm_tczf() {
		return im_tczf;
	}

	public void setIm_tczf(BigDecimal im_tczf) {
		this.im_tczf = im_tczf;
	}

	public BigDecimal getIm_fjzf() {
		return im_fjzf;
	}

	public void setIm_fjzf(BigDecimal im_fjzf) {
		this.im_fjzf = im_fjzf;
	}

	public BigDecimal getIm_flzf() {
		return im_flzf;
	}

	public void setIm_flzf(BigDecimal im_flzf) {
		this.im_flzf = im_flzf;
	}

	public BigDecimal getIm_czf() {
		return im_czf;
	}

	public void setIm_czf(BigDecimal im_czf) {
		this.im_czf = im_czf;
	}

	public BigDecimal getIm_lsh() {
		return im_lsh;
	}

	public void setIm_lsh(BigDecimal im_lsh) {
		this.im_lsh = im_lsh;
	}
}