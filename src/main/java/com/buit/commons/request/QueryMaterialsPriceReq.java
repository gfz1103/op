
package com.buit.commons.request;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryMaterialsPriceReq<br>
 * 类描述：划价收费获取物资价格请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "划价收费获取物资价格请求")
public class QueryMaterialsPriceReq extends PageQuery {
	@ApiModelProperty(value = "药品序号")
	private Integer medId;
	@ApiModelProperty(value = "门诊科室")
	private Integer ksdm;
	@ApiModelProperty(value = "药品序号")
	private Integer ypxh;
	@ApiModelProperty(value = "零售价格")
	private BigDecimal lsjg;
	@ApiModelProperty(value = "药品数量")
	private Integer ypsl;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;

	public Integer getMedId() {
		return medId;
	}

	public void setMedId(Integer medId) {
		this.medId = medId;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Integer getYpxh() {
		return ypxh;
	}

	public void setYpxh(Integer ypxh) {
		this.ypxh = ypxh;
	}

	public BigDecimal getLsjg() {
		return lsjg;
	}

	public void setLsjg(BigDecimal lsjg) {
		this.lsjg = lsjg;
	}

	public Integer getYpsl() {
		return ypsl;
	}

	public void setYpsl(Integer ypsl) {
		this.ypsl = ypsl;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

}