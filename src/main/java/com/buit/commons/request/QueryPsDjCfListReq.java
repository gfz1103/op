
package com.buit.commons.request;

import java.sql.Date;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryDjCfListReq<br>
 * 类描述：输液注射工作量统计人次请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "皮试工作量统计每日输液数据请求")
public class QueryPsDjCfListReq extends PageQuery {
	@JsonIgnore
	@ApiModelProperty(value = "医疗机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "输液科室代码 ")
	private Integer ksdm;
	@ApiModelProperty(value = "皮试日期")
	private Date psrq;

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

	public Date getPsrq() {
		return psrq;
	}

	public void setPsrq(Date psrq) {
		this.psrq = psrq;
	}

}