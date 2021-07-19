
package com.buit.commons.request;

import java.sql.Date;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryAllPsDjCountReq<br>
 * 类描述：皮试工作量统计人次请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "皮试工作量统计人次请求")
public class QueryAllPsDjCountReq {
	@JsonIgnore
	@ApiModelProperty(value = "医疗机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "输液科室代码 ")
	private Integer ksdm;
	@ApiModelProperty(value = "开始时间")
	private Date beginDay;
	@ApiModelProperty(value = "结束时间")
	private Date endDay;

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

}