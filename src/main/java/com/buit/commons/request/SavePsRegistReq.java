
package com.buit.commons.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SavePsRegistReq<br>
 * 类描述：皮试登记<br>
 * 
 * @author WY
 */
@ApiModel(value = "皮试登记")
public class SavePsRegistReq {
	@JsonIgnore
	@ApiModelProperty(value = "医疗机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "注射科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "病人ID")
	private Integer brid;
	@ApiModelProperty(value = "病人卡号")
	private String jzkh;
	@ApiModelProperty(value = "登记人代码")
	private Integer djrdm;
	@ApiModelProperty(value = "待登记处方列表")
	private List<SavePsCfRegistReq> cfList = new ArrayList<SavePsCfRegistReq>();

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public List<SavePsCfRegistReq> getCfList() {
		return cfList;
	}

	public void setCfList(List<SavePsCfRegistReq> cfList) {
		this.cfList = cfList;
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

	public Integer getDjrdm() {
		return djrdm;
	}

	public void setDjrdm(Integer djrdm) {
		this.djrdm = djrdm;
	}

}