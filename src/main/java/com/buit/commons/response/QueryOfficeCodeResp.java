package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryOfficeCodeResp<br>
 * 类描述：查询挂号科室对应的门诊科室<br>
 * 
 * @author wy
 */
@ApiModel(value = "查询挂号科室对应的门诊科室")
public class QueryOfficeCodeResp extends PageQuery {
	@ApiModelProperty(value = "挂号科室代码")
	private Integer ghks;
	@ApiModelProperty(value = "挂号科室名称")
	private String ksmc;
	@ApiModelProperty(value = "门诊科室代码")
	private Integer officeCode;

	public Integer getGhks() {
		return ghks;
	}

	public void setGhks(Integer ghks) {
		this.ghks = ghks;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public Integer getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(Integer officeCode) {
		this.officeCode = officeCode;
	}

}