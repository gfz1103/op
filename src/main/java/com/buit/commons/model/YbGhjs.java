package com.buit.commons.model;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 类名称：YbGhjs<br>
 * 类描述：医保挂号结算表,暂时只增加主键和OP_GHMX关联的键,其他的键按地方返回的医保卡字段增加
 * 
 * @author WY
 * 
 */
@ApiModel(value = "医保挂号结算表,暂时只增加主键和OP_GHMX关联的键,其他的键按地方返回的医保卡字段增加")
public class YbGhjs {
	@ApiModelProperty(value="卡类型")
private String cardtype;
	@ApiModelProperty(value="卡号")
private String cardid;
	@ApiModelProperty(value="令牌")
	private String ecToken;
	@ApiModelProperty(value="账户标志")
private String accountattr;
	@ApiModelProperty(value="总金额")
private String totalexpense;
	@ApiModelProperty(value="医保结算金额")
private String ybjsfwfyze;
	@ApiModelProperty(value="非医保结算金额")
private String fybjsfwfyze;
	@ApiModelProperty(value="诊疗费")
private String zlf;
	@ApiModelProperty(value="挂号费")
private String ghf;
	@ApiModelProperty(value="减免结算标志")
private String jmjsbz;
	@ApiModelProperty(value="结算申请序号")
private String jssqxh;
	@ApiModelProperty(value="工伤认定号")
private String gsrdh;
	@ApiModelProperty(value="大病代码")
private String dbtype;
	@ApiModelProperty(value="医疗类别")
private String yllb;
	@ApiModelProperty(value="是否大病")
	private String isdb;
	@ApiModelProperty(value="医保金额")
	private BigDecimal qtys;

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getAccountattr() {
		return accountattr;
	}

	public void setAccountattr(String accountattr) {
		this.accountattr = accountattr;
	}

	public String getTotalexpense() {
		return totalexpense;
	}

	public void setTotalexpense(String totalexpense) {
		this.totalexpense = totalexpense;
	}

	public String getYbjsfwfyze() {
		return ybjsfwfyze;
	}

	public void setYbjsfwfyze(String ybjsfwfyze) {
		this.ybjsfwfyze = ybjsfwfyze;
	}

	public String getFybjsfwfyze() {
		return fybjsfwfyze;
	}

	public void setFybjsfwfyze(String fybjsfwfyze) {
		this.fybjsfwfyze = fybjsfwfyze;
	}

	public String getZlf() {
		return zlf;
	}

	public void setZlf(String zlf) {
		this.zlf = zlf;
	}

	public String getGhf() {
		return ghf;
	}

	public void setGhf(String ghf) {
		this.ghf = ghf;
	}

	public String getJmjsbz() {
		return jmjsbz;
	}

	public void setJmjsbz(String jmjsbz) {
		this.jmjsbz = jmjsbz;
	}

	public String getJssqxh() {
		return jssqxh;
	}

	public void setJssqxh(String jssqxh) {
		this.jssqxh = jssqxh;
	}

	public String getGsrdh() {
		return gsrdh;
	}

	public void setGsrdh(String gsrdh) {
		this.gsrdh = gsrdh;
	}

	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}

	public String getYllb() {
		return yllb;
	}

	public void setYllb(String yllb) {
		this.yllb = yllb;
	}

	public String getEcToken() {
		return ecToken;
	}

	public void setEcToken(String ecToken) {
		this.ecToken = ecToken;
	}

	public String getIsdb() {
		return isdb;
	}

	public void setIsdb(String isdb) {
		this.isdb = isdb;
	}

	// @ApiModelProperty(value="主键")
	/** 主键 */
/*	private Integer sbxh;
	@ApiModelProperty(value = "和OP_GHMX主键关联")
	*//** 和OP_GHMX主键关联 *//*
	private Integer ghgl;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	*//** 机构ID *//*
	private Integer jgid;
	@ApiModelProperty(value = "作废判别,0未作废,1作废")
	*//** 作废判别,0未作废,1作废 *//*
	private Integer zfpb;
	@ApiModelProperty(value = "个人编号")
	private Integer grbh;*/

/*	*//** 设置:主键 *//*
	public void setSbxh(Integer value) {
		this.sbxh = value;
	}

	*//** 获取:主键 *//*
	public Integer getSbxh() {
		return sbxh;
	}

	*//** 设置:和OP_GHMX主键关联 *//*
	public void setGhgl(Integer value) {
		this.ghgl = value;
	}

	*//** 获取:和OP_GHMX主键关联 *//*
	public Integer getGhgl() {
		return ghgl;
	}

	*//** 设置:机构ID *//*
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	*//** 获取:机构ID *//*
	public Integer getJgid() {
		return jgid;
	}

	*//** 设置:作废判别,0未作废,1作废 *//*
	public void setZfpb(Integer value) {
		this.zfpb = value;
	}

	*//** 获取:作废判别,0未作废,1作废 *//*
	public Integer getZfpb() {
		return zfpb;
	}

	public Integer getGrbh() {
		return grbh;
	}

	public void setGrbh(Integer grbh) {
		this.grbh = grbh;
	}*/

	public BigDecimal getQtys() {
		return qtys;
	}

	public void setQtys(BigDecimal qtys) {
		this.qtys = qtys;
	}
}
