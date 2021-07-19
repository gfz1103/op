package com.buit.commons.model;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpGhksOffice<br>
 * 类描述：
 * 
 * @author WY
 * 
 */
@ApiModel(value = "挂号科室门诊列表")
public class OpGhksOffice extends PageQuery {
	@ApiModelProperty(value = "科室ID")
	private Integer id;
	@ApiModelProperty(value = "科室代码")
	private String officecode;
	@ApiModelProperty(value = "科室名称")
	private String officename;
	@ApiModelProperty(value = "机构代码")
	private String organizcode;
	@ApiModelProperty(value = "拼音代码")
	private String pycode;
	@ApiModelProperty(value = "状态")
	private String logoff;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOfficecode() {
		return officecode;
	}

	public void setOfficecode(String officecode) {
		this.officecode = officecode;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public String getOrganizcode() {
		return organizcode;
	}

	public void setOrganizcode(String organizcode) {
		this.organizcode = organizcode;
	}

	public String getPycode() {
		return pycode;
	}

	public void setPycode(String pycode) {
		this.pycode = pycode;
	}

	public String getLogoff() {
		return logoff;
	}

	public void setLogoff(String logoff) {
		this.logoff = logoff;
	}

}
