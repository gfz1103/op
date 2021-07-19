
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsCancelRegisterReq<br>
 * 类描述：退号请求<br>
 * 
 * @author wangyang
 */
@ApiModel(value = "退号请求")
public class MsCancelRegisterReq extends PageQuery {
	@ApiModelProperty(value = "医保信息")
	private String fphm;
	@ApiModelProperty(value = "就诊卡号")
	private String jzhm;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "识别序号 | 唯一标示一次挂号的序号")
	private Integer sbxh;
	@ApiModelProperty(value = "病人性质")
	private Integer brxz;
	@JsonIgnore
	@ApiModelProperty(value = "用户ID")
	private Integer ygdm;
	@JsonIgnore
	@ApiModelProperty(value = "ip")
	private String ip;

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public String getJzhm() {
		return jzhm;
	}

	public void setJzhm(String jzhm) {
		this.jzhm = jzhm;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

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

	public Integer getYgdm() {
		return ygdm;
	}

	public void setYgdm(Integer ygdm) {
		this.ygdm = ygdm;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}