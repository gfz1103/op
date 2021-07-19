
package com.buit.commons.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：非实时结算门诊费用明细库<br>
 * 
 * @author beijunhua
 */
@ApiModel(value = "非实时结算门诊费用明细库")
public class YbbbFssscopResp extends PageQuery {
	@ApiModelProperty(value = "医疗机构代码")
	private String YYID;
	@ApiModelProperty(value = "凭证号码")
	private String YBID;
	@ApiModelProperty(value = "门诊号")
	private String MZHM;
	@ApiModelProperty(value = "身份证")
	private String BXID;
	@ApiModelProperty(value = "科别编码")
	private String KSID;
	@ApiModelProperty(value = "科别名称")
	private String KSNA;
	@ApiModelProperty(value = "医生工号")
	private String YSGH;
	@ApiModelProperty(value = "医生姓名")
	private String YSXM;
	@ApiModelProperty(value = "处方编号")
	private String CFHM;
	@ApiModelProperty(value = "费用类别")
	private String FYLB;
	@ApiModelProperty(value = "明细项目编码")
	private String XMBM;
	@ApiModelProperty(value = "明细项目名称")
	private String XMMC;
	@ApiModelProperty(value = "明细项目单位")
	private String XMDW;
	@ApiModelProperty(value = "明细项目单价")
	private String XMDJ;
	@ApiModelProperty(value = "药品通用名/材料")
	private String TYMC;
	@ApiModelProperty(value = "注册证号")
	private String ZCZH;
	@ApiModelProperty(value = "明细项目规格")
	private String MXGG;
	@ApiModelProperty(value = "明细项目数量")
	private String XMSL;
	@ApiModelProperty(value = "明细项目金额")
	private String XMJE;
	@ApiModelProperty(value = "明细项目交易费用金额")
	private String JYTOTFY;
	@ApiModelProperty(value = "明细项目医保结算范围金额")
	private String TOTFY;
	@ApiModelProperty(value = "可报标志")
	private String BXBZ;
	@ApiModelProperty(value = "人员类型")
	private String RYLX;
	@ApiModelProperty(value = "收费、退费标志")
	private String TFBZ;
	@ApiModelProperty(value = "就诊日期")
	private String JZDATE;

	public String getYYID() {
		return YYID;
	}

	public void setYYID(String YYID) {
		this.YYID = YYID;
	}

	public String getYBID() {
		return YBID;
	}

	public void setYBID(String YBID) {
		this.YBID = YBID;
	}

	public String getMZHM() {
		return MZHM;
	}

	public void setMZHM(String MZHM) {
		this.MZHM = MZHM;
	}

	public String getBXID() {
		return BXID;
	}

	public void setBXID(String BXID) {
		this.BXID = BXID;
	}

	public String getKSID() {
		return KSID;
	}

	public void setKSID(String KSID) {
		this.KSID = KSID;
	}

	public String getKSNA() {
		return KSNA;
	}

	public void setKSNA(String KSNA) {
		this.KSNA = KSNA;
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

	public String getCFHM() {
		return CFHM;
	}

	public void setCFHM(String CFHM) {
		this.CFHM = CFHM;
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

	public String getMXGG() {
		return MXGG;
	}

	public void setMXGG(String MXGG) {
		this.MXGG = MXGG;
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

	public String getJYTOTFY() {
		return JYTOTFY;
	}

	public void setJYTOTFY(String JYTOTFY) {
		this.JYTOTFY = JYTOTFY;
	}

	public String getTOTFY() {
		return TOTFY;
	}

	public void setTOTFY(String TOTFY) {
		this.TOTFY = TOTFY;
	}

	public String getBXBZ() {
		return BXBZ;
	}

	public void setBXBZ(String BXBZ) {
		this.BXBZ = BXBZ;
	}

	public String getRYLX() {
		return RYLX;
	}

	public void setRYLX(String RYLX) {
		this.RYLX = RYLX;
	}

	public String getTFBZ() {
		return TFBZ;
	}

	public void setTFBZ(String TFBZ) {
		this.TFBZ = TFBZ;
	}

	public String getJZDATE() {
		return JZDATE;
	}

	public void setJZDATE(String JZDATE) {
		this.JZDATE = JZDATE;
	}
}