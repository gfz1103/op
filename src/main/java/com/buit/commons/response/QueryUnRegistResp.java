
package com.buit.commons.response;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryUnRegistResp<br>
 * 类描述：查询病人已收费、已发药、未输液的输液处方返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "查询病人已收费、已发药、未输液的输液处方列表返回")
public class QueryUnRegistResp {
	@ApiModelProperty(value = "药品序号")
	private Integer ypxh;
	@ApiModelProperty(value = "开方日期")
	private Date kfrq;
	@ApiModelProperty(value = "药品名称")
	private String ypmc;
	@ApiModelProperty(value = "药品规格")
	private String ypgg;
	@ApiModelProperty(value = "药品产地")
	private Integer ypcd;
	@ApiModelProperty(value = "药品剂量")
	private Integer ypjl;
	@ApiModelProperty(value = "剂量单位")
	private String jldw;
	@ApiModelProperty(value = "使用频次")
	private String sypc;
	@ApiModelProperty(value = "给药途径")
	private Integer gytj;
	@ApiModelProperty(value = "用药天数")
	private Integer yyts;
	@ApiModelProperty(value = "药品总量")
	private BigDecimal ypsl;
	@ApiModelProperty(value = "备注说明")
	private String bzmc;
	@ApiModelProperty(value = "门诊科室")
	private Integer ksdm;
	@ApiModelProperty(value = "医生代码")
	private Integer ysdm;
	@ApiModelProperty(value = "已执行次数")
	private Integer yzxcs;
	@ApiModelProperty(value = "需要执行总次数")
	private Integer xyzxzcs;
	@ApiModelProperty(value = "门诊号码")
	private Integer mzhm;
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "处方号码")
	private Integer cfhm;
	@ApiModelProperty(value = "处方组号")
	private Integer cfzh;
	@ApiModelProperty(value = "输液序号")
	private Integer xh;
	@ApiModelProperty(value = "输液条码")
	private String sytm;
	@ApiModelProperty(value = "识别序号")
	private Integer sbxh;
	@ApiModelProperty(value = "皮试结果 0需要皮试但还没皮试结果 1无需皮试 3阳 2阴")
	private Integer psjg;

	public Integer getPsjg() {
		return psjg;
	}

	public void setPsjg(Integer psjg) {
		this.psjg = psjg;
	}

	public String getSytm() {
		return sytm;
	}

	public void setSytm(String sytm) {
		this.sytm = sytm;
	}

	public Integer getYpxh() {
		return ypxh;
	}

	public void setYpxh(Integer ypxh) {
		this.ypxh = ypxh;
	}

	public Date getKfrq() {
		return kfrq;
	}

	public void setKfrq(Date kfrq) {
		this.kfrq = kfrq;
	}

	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	public String getYpgg() {
		return ypgg;
	}

	public void setYpgg(String ypgg) {
		this.ypgg = ypgg;
	}

	public Integer getYpcd() {
		return ypcd;
	}

	public void setYpcd(Integer ypcd) {
		this.ypcd = ypcd;
	}

	public Integer getYpjl() {
		return ypjl;
	}

	public void setYpjl(Integer ypjl) {
		this.ypjl = ypjl;
	}

	public String getSypc() {
		return sypc;
	}

	public void setSypc(String sypc) {
		this.sypc = sypc;
	}

	public Integer getGytj() {
		return gytj;
	}

	public void setGytj(Integer gytj) {
		this.gytj = gytj;
	}

	public Integer getYyts() {
		return yyts;
	}

	public void setYyts(Integer yyts) {
		this.yyts = yyts;
	}

	public BigDecimal getYpsl() {
		return ypsl;
	}

	public void setYpsl(BigDecimal ypsl) {
		this.ypsl = ypsl;
	}

	public String getBzmc() {
		return bzmc;
	}

	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Integer getYsdm() {
		return ysdm;
	}

	public void setYsdm(Integer ysdm) {
		this.ysdm = ysdm;
	}

	public Integer getYzxcs() {
		return yzxcs;
	}

	public void setYzxcs(Integer yzxcs) {
		this.yzxcs = yzxcs;
	}

	public Integer getMzhm() {
		return mzhm;
	}

	public void setMzhm(Integer mzhm) {
		this.mzhm = mzhm;
	}

	public Integer getXyzxzcs() {
		return xyzxzcs;
	}

	public void setXyzxzcs(Integer xyzxzcs) {
		this.xyzxzcs = xyzxzcs;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public Integer getCfhm() {
		return cfhm;
	}

	public void setCfhm(Integer cfhm) {
		this.cfhm = cfhm;
	}

	public Integer getCfzh() {
		return cfzh;
	}

	public void setCfzh(Integer cfzh) {
		this.cfzh = cfzh;
	}

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

}