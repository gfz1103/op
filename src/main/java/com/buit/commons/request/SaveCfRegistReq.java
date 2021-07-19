
package com.buit.commons.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SaveCfRegistReq<br>
 * 类描述：输液登记处方列表<br>
 * 
 * @author WY
 */
@ApiModel(value = "输液登记处方列表")
public class SaveCfRegistReq {
	@JsonIgnore
	@ApiModelProperty(value = "医疗机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "输液科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "处方号码")
	private Integer cfhm;
	@ApiModelProperty(value = "处方组号")
	private Integer cfzh;
	@ApiModelProperty(value = "药品序号")
	private Integer ypxh;
	@ApiModelProperty(value = "门诊序号")
	private Integer mzhm;
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "已执行次数")
	private Integer yzxcs;
	@ApiModelProperty(value = "需要执行总次数")
	private Integer xyzxzcs;

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

	public Integer getYpxh() {
		return ypxh;
	}

	public void setYpxh(Integer ypxh) {
		this.ypxh = ypxh;
	}

	public Integer getMzhm() {
		return mzhm;
	}

	public void setMzhm(Integer mzhm) {
		this.mzhm = mzhm;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public Integer getYzxcs() {
		return yzxcs;
	}

	public void setYzxcs(Integer yzxcs) {
		this.yzxcs = yzxcs;
	}

	public Integer getXyzxzcs() {
		return xyzxzcs;
	}

	public void setXyzxzcs(Integer xyzxzcs) {
		this.xyzxzcs = xyzxzcs;
	}

}