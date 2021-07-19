
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SelectfujmbrReq<br>
 * 类描述：查询妇幼减免病人<br>
 * 
 * @author WY
 */
@ApiModel(value = "查询妇幼减免病人")
public class SelectfujmbrReq extends PageQuery {
	@ApiModelProperty(value = "就诊科室")
	private Integer jzks;
	@ApiModelProperty(value = "妇幼病人性质")
	private String fubrxz;
	@ApiModelProperty(value = "年龄")
	private String fuage;
	@ApiModelProperty(value = "病人ID")
	private String fubrid;
	@ApiModelProperty(value = "病人性别")
	private String fubrxb;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "员工ID")
	private Integer ygdm;

	public Integer getJzks() {
		return jzks;
	}

	public void setJzks(Integer jzks) {
		this.jzks = jzks;
	}

	public String getFubrxz() {
		return fubrxz;
	}

	public void setFubrxz(String fubrxz) {
		this.fubrxz = fubrxz;
	}

	public String getFuage() {
		return fuage;
	}

	public void setFuage(String fuage) {
		this.fuage = fuage;
	}

	public String getFubrid() {
		return fubrid;
	}

	public void setFubrid(String fubrid) {
		this.fubrid = fubrid;
	}

	public String getFubrxb() {
		return fubrxb;
	}

	public void setFubrxb(String fubrxb) {
		this.fubrxb = fubrxb;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getYgdm() {
		return ygdm;
	}

	public void setYgdm(Integer ygdm) {
		this.ygdm = ygdm;
	}

}