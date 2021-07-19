
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：PrintGhxxReq<br>
 * 类描述：挂号打印请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "挂号打印请求")
public class PrintGhxxReq extends PageQuery {
	private static final long serialVersionUID = -7735625698532212274L;
	@ApiModelProperty(value = "识别序号 挂号主键")
	private Integer sbxh;
	@ApiModelProperty(value = "上级病人性质")
	private Integer brxz;
	@ApiModelProperty(value = "医保病人性质")
	private Integer ybsjbrxz;
	@ApiModelProperty(value = "挂号科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "就诊号码")
	private String jzhm;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "操作员")
	private String userName;

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public Integer getYbsjbrxz() {
		return ybsjbrxz;
	}

	public void setYbsjbrxz(Integer ybsjbrxz) {
		this.ybsjbrxz = ybsjbrxz;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getJzhm() {
		return jzhm;
	}

	public void setJzhm(String jzhm) {
		this.jzhm = jzhm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}