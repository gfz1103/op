
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：明细上传-住院费用明细库<br>
 * 
 * @author beijunhua
 */
@ApiModel(value = "明细上传-住院费用明细库")
public class MxscZyfymxkResp extends PageQuery {
	@ApiModelProperty(value = "流水号")
	private String LSH;
	@ApiModelProperty(value = "卡号")
	private String YBID;
	@ApiModelProperty(value = "科室编码")
	private String KSBM;
	@ApiModelProperty(value = "科室名称")
	private String KSMC;
	@ApiModelProperty(value = "医生工号")
	private String YSGH;
	@ApiModelProperty(value = "医生姓名")
	private String YSXM;
	@ApiModelProperty(value = "费用类别")
	private String FYLB;
	@ApiModelProperty(value = "项目编码")
	private String XMBM;
	@ApiModelProperty(value = "项目名称")
	private String XMMC;
	@ApiModelProperty(value = "项目单位")
	private String XMDW;
	@ApiModelProperty(value = "项目单价")
	private String XMDJ;
	@ApiModelProperty(value = "项目数量")
	private String XMSL;

	@ApiModelProperty(value = "项目金额")
	private String XMJE;
	@ApiModelProperty(value = "交易金额")
	private String XMJYJE;
	@ApiModelProperty(value = "医保范围金额")
	private String YBFWJE;
	@ApiModelProperty(value = "报销标志")
	private String BXBZ;
	@ApiModelProperty(value = "交易时间")
	private String JYSJ;
	@ApiModelProperty(value = "医保类型")
	private String YBLX;
	@ApiModelProperty(value = "结算类型")
	private String JSLX;
	@ApiModelProperty(value = "退费标志")
	private String TFBZ;
	@ApiModelProperty(value = "减负标志")
	private String JFBZ;
	@ApiModelProperty(value = "细分流水号")
	private String XFXMLSH;
	@ApiModelProperty(value = "药品通用名")
	private String TYMC;
	@ApiModelProperty(value = "注册证号")
	private String ZCZH;
	@ApiModelProperty(value = "明细项目规格")
	private String MXXMGG;
	@ApiModelProperty(value = "明细项目使用日期")
	private String MXXMSYRQ;

	public String getLSH() {
		return LSH;
	}

	public void setLSH(String LSH) {
		this.LSH = LSH;
	}

	public String getYBID() {
		return YBID;
	}

	public void setYBID(String YBID) {
		this.YBID = YBID;
	}

	public String getKSBM() {
		return KSBM;
	}

	public void setKSBM(String KSBM) {
		this.KSBM = KSBM;
	}

	public String getKSMC() {
		return KSMC;
	}

	public void setKSMC(String KSMC) {
		this.KSMC = KSMC;
	}

	public String getYSGH() {
		return YSGH;
	}

	public void setYSGH(String YSGH) {
		this.YSGH = YSGH;
	}

	public String getYSXM() {
		return YSXM;
	}

	public void setYSXM(String YSXM) {
		this.YSXM = YSXM;
	}

	public String getFYLB() {
		return FYLB;
	}

	public void setFYLB(String FYLB) {
		this.FYLB = FYLB;
	}

	public String getXMBM() {
		return XMBM;
	}

	public void setXMBM(String XMBM) {
		this.XMBM = XMBM;
	}

	public String getXMMC() {
		return XMMC;
	}

	public void setXMMC(String XMMC) {
		this.XMMC = XMMC;
	}

	public String getXMDW() {
		return XMDW;
	}

	public void setXMDW(String XMDW) {
		this.XMDW = XMDW;
	}

	public String getXMDJ() {
		return XMDJ;
	}

	public void setXMDJ(String XMDJ) {
		this.XMDJ = XMDJ;
	}

	public String getXMSL() {
		return XMSL;
	}

	public void setXMSL(String XMSL) {
		this.XMSL = XMSL;
	}

	public String getXMJE() {
		return XMJE;
	}

	public void setXMJE(String XMJE) {
		this.XMJE = XMJE;
	}

	public String getXMJYJE() {
		return XMJYJE;
	}

	public void setXMJYJE(String XMJYJE) {
		this.XMJYJE = XMJYJE;
	}

	public String getYBFWJE() {
		return YBFWJE;
	}

	public void setYBFWJE(String YBFWJE) {
		this.YBFWJE = YBFWJE;
	}

	public String getBXBZ() {
		return BXBZ;
	}

	public void setBXBZ(String BXBZ) {
		this.BXBZ = BXBZ;
	}

	public String getJYSJ() {
		return JYSJ;
	}

	public void setJYSJ(String JYSJ) {
		this.JYSJ = JYSJ;
	}

	public String getYBLX() {
		return YBLX;
	}

	public void setYBLX(String YBLX) {
		this.YBLX = YBLX;
	}

	public String getJSLX() {
		return JSLX;
	}

	public void setJSLX(String JSLX) {
		this.JSLX = JSLX;
	}

	public String getTFBZ() {
		return TFBZ;
	}

	public void setTFBZ(String TFBZ) {
		this.TFBZ = TFBZ;
	}

	public String getJFBZ() {
		return JFBZ;
	}

	public void setJFBZ(String JFBZ) {
		this.JFBZ = JFBZ;
	}

	public String getXFXMLSH() {
		return XFXMLSH;
	}

	public void setXFXMLSH(String XFXMLSH) {
		this.XFXMLSH = XFXMLSH;
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

	public String getMXXMSYRQ() {
		return MXXMSYRQ;
	}

	public void setMXXMSYRQ(String MXXMSYRQ) {
		this.MXXMSYRQ = MXXMSYRQ;
	}
}