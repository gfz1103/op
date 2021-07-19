
package com.buit.commons.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SaveRegistReq<br>
 * 类描述：输液登记<br>
 * 
 * @author WY
 */
@ApiModel(value = "输液登记")
public class SaveRegistReq {
	@JsonIgnore
	@ApiModelProperty(value = "医疗机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "输液科室代码")
	private Integer ksdm;
	@NotBlank(message = "科室类别不能为空")
	@ApiModelProperty(value = "科室类别 1:输液室  2:注射室")
	private String kslb;
	@ApiModelProperty(value = "病人ID")
	private Integer brid;
	@ApiModelProperty(value = "病人卡号")
	private String jzkh;
	@ApiModelProperty(value = "登记人代码")
	private Integer djrdm;
	@ApiModelProperty(value = "待登记处方列表")
	private List<SaveCfRegistReq> cfList = new ArrayList<SaveCfRegistReq>();

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

	public String getKslb() {
		return kslb;
	}

	public void setKslb(String kslb) {
		this.kslb = kslb;
	}

	public List<SaveCfRegistReq> getCfList() {
		return cfList;
	}

	public void setCfList(List<SaveCfRegistReq> cfList) {
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