package com.buit.commons.model;

import java.sql.Date;

import com.buit.commons.PageQuery;

/**
 * 类名称：OpFpdyjl<br>
 * 类描述：
 * 
 * @author WY @ApiModel(value="")
 */
public class OpFpdyjl extends PageQuery {
	// @ApiModelProperty(value="dysj")
	/** dysj */
	private Date dysj;
	// @ApiModelProperty(value="fphm")
	/** fphm */
	private String fphm;
	// @ApiModelProperty(value="dynr")
	/** dynr */
	private String dynr;
	// @ApiModelProperty(value="fpzs")
	/** fpzs */
	private Integer fpzs;

	/** 设置:dysj */
	public void setDysj(Date value) {
		this.dysj = value;
	}

	/** 获取:dysj */
	public Date getDysj() {
		return dysj;
	}

	/** 设置:fphm */
	public void setFphm(String value) {
		this.fphm = value;
	}

	/** 获取:fphm */
	public String getFphm() {
		return fphm;
	}

	/** 设置:dynr */
	public void setDynr(String value) {
		this.dynr = value;
	}

	/** 获取:dynr */
	public String getDynr() {
		return dynr;
	}

	/** 设置:fpzs */
	public void setFpzs(Integer value) {
		this.fpzs = value;
	}

	/** 获取:fpzs */
	public Integer getFpzs() {
		return fpzs;
	}

}
