
package com.buit.commons.request;


import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryPsAllergyReq<br>
 * 类描述：皮试阳性率统计请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "皮试阳性率统计请求")
public class QueryPsAllergyReq {
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "皮试开始时间")
	private Date beginDay;
	@ApiModelProperty(value = "皮试结束时间")
	private Date endDay;
	@ApiModelProperty(value = "输液科室代码")
	private Integer ksdm;

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Date getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(Date beginDay) {
		this.beginDay = beginDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

}