package com.buit.commons.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SyJydjUser<br>
 * 类描述：输液/注射接药登记用户信息
 * 
 * @author wy
 * 
 */
@ApiModel(value = "输液/注射接药登记用户信息")
public class SyJydjUser {
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "病人年龄")
	private String age;
//	@ApiModelProperty(value = "门诊号码")
//	private String mzhm;
	@JsonIgnore
	@ApiModelProperty(value = "出生年月")
	private Timestamp csny;
	@ApiModelProperty(value = "病人ID")
	private Integer brid;
	@ApiModelProperty(value = "病人卡号")
	private String jzkh;

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

//	public String getMzhm() {
//		return mzhm;
//	}
//
//	public void setMzhm(String mzhm) {
//		this.mzhm = mzhm;
//	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Timestamp getCsny() {
		return csny;
	}

	public void setCsny(Timestamp csny) {
		this.csny = csny;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

}