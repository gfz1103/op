
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：明细上传-出院诊断库<br>
 * 
 * @author beijunhua
 */
@ApiModel(value = "明细上传-出院诊断库")
public class MxscMxxmxfkResp extends PageQuery {
	@ApiModelProperty(value = "流水号")
	private String LSH;
	@ApiModelProperty(value = "就诊流水号")
	private String JZLSH;
	@ApiModelProperty(value = "明细项目编码")
	private String MXXMBM;
	@ApiModelProperty(value = "明细项目细分流水号")
	private String XFLSH;
	@ApiModelProperty(value = "明细项目名编码")
	private String MXXMZLBM;
	@ApiModelProperty(value = "明细项目名称(子类)")
	private String MXXMMC;
	@ApiModelProperty(value = "明细项目单位(子类)")
	private String MXXMDW;
	@ApiModelProperty(value = "明细项目单价(子类)")
	private String MXXMDJ;
	@ApiModelProperty(value = "明细项目数量(子类)")
	private String MXXMSL;
	@ApiModelProperty(value = "明细项目金额(子类)")
	private String MXXMJE;
	@ApiModelProperty(value = "报销标志(子类)")
	private String BXBZ;
	@ApiModelProperty(value = "药品通用名/医用品牌(子类)")
	private String TYMC;
	@ApiModelProperty(value = "注册证号(子类)")
	private String ZCZH;
	@ApiModelProperty(value = "明细项目规格(子类)")
	private String MXXMGG;
	@ApiModelProperty(value = "收费退费标志")
	private String TFBZ;
	@ApiModelProperty(value = "明细项目使用日期")
	private String XMSYRQ;

	public String getLSH() {
		return LSH;
	}

	public void setLSH(String LSH) {
		this.LSH = LSH;
	}

	public String getJZLSH() {
		return JZLSH;
	}

	public void setJZLSH(String JZLSH) {
		this.JZLSH = JZLSH;
	}

	public String getMXXMBM() {
		return MXXMBM;
	}

	public void setMXXMBM(String MXXMBM) {
		this.MXXMBM = MXXMBM;
	}

	public String getXFLSH() {
		return XFLSH;
	}

	public void setXFLSH(String XFLSH) {
		this.XFLSH = XFLSH;
	}

	public String getMXXMZLBM() {
		return MXXMZLBM;
	}

	public void setMXXMZLBM(String MXXMZLBM) {
		this.MXXMZLBM = MXXMZLBM;
	}

	public String getMXXMMC() {
		return MXXMMC;
	}

	public void setMXXMMC(String MXXMMC) {
		this.MXXMMC = MXXMMC;
	}

	public String getMXXMDW() {
		return MXXMDW;
	}

	public void setMXXMDW(String MXXMDW) {
		this.MXXMDW = MXXMDW;
	}

	public String getMXXMDJ() {
		return MXXMDJ;
	}

	public void setMXXMDJ(String MXXMDJ) {
		this.MXXMDJ = MXXMDJ;
	}

	public String getMXXMSL() {
		return MXXMSL;
	}

	public void setMXXMSL(String MXXMSL) {
		this.MXXMSL = MXXMSL;
	}

	public String getMXXMJE() {
		return MXXMJE;
	}

	public void setMXXMJE(String MXXMJE) {
		this.MXXMJE = MXXMJE;
	}

	public String getBXBZ() {
		return BXBZ;
	}

	public void setBXBZ(String BXBZ) {
		this.BXBZ = BXBZ;
	}

	public String getTYMC() {
		return TYMC;
	}

	public void setTYMC(String TYMC) {
		this.TYMC = TYMC;
	}

	public String getZCZH() {
		return ZCZH;
	}

	public void setZCZH(String ZCZH) {
		this.ZCZH = ZCZH;
	}

	public String getMXXMGG() {
		return MXXMGG;
	}

	public void setMXXMGG(String MXXMGG) {
		this.MXXMGG = MXXMGG;
	}

	public String getTFBZ() {
		return TFBZ;
	}

	public void setTFBZ(String TFBZ) {
		this.TFBZ = TFBZ;
	}

	public String getXMSYRQ() {
		return XMSYRQ;
	}

	public void setXMSYRQ(String XMSYRQ) {
		this.XMSYRQ = XMSYRQ;
	}
}