
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsQryDjReq<br>
 * 类描述：收费结算单据查询请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "收费结算单据查询请求")
public class MsQryDjReq extends PageQuery {
	@ApiModelProperty(value = "病人编号")
	private Integer brid;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "查询条件天数")
	private Integer cnds;

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

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getCnds() {
		return cnds;
	}

	public void setCnds(Integer cnds) {
		this.cnds = cnds;
	}

}