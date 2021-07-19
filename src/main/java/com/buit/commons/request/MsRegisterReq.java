
package com.buit.commons.request;

import java.sql.Date;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsRegisterReq<br>
 * 类描述：挂号请求<br>
 * 
 * @author wangyang
 */
@ApiModel(value = "挂号请求")
public class MsRegisterReq extends PageQuery {
	private static final long serialVersionUID = 1096388084349111956L;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "病人ID号")
	private Integer brid;
	@ApiModelProperty(value = "挂号时间")
	private Date ghsj;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "值班类别")
	private String zblb;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public Date getGhsj() {
		return ghsj;
	}

	public void setGhsj(Date ghsj) {
		this.ghsj = ghsj;
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

	public String getZblb() {
		return zblb;
	}

	public void setZblb(String zblb) {
		this.zblb = zblb;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}