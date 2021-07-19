
package com.buit.commons.request;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

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
@ApiModel(value = "输液注射工作量统计每日输液数据请求")
public class QueryDjCfListReq extends PageQuery {
	@JsonIgnore
	@ApiModelProperty(value = "医疗机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "输液科室代码 ")
	private Integer ksdm;
	@ApiModelProperty(value = "状态 1 输液/注射中/2 输液/注射完成")
	private String zt;
	@NotBlank(message = "科室类别不能为空")
	@ApiModelProperty(value = "科室类别 : 1:输液室  2:注射室")
	private String kslb;
	@ApiModelProperty(value = "输液日期")
	private Date syrq;

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

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getKslb() {
		return kslb;
	}

	public void setKslb(String kslb) {
		this.kslb = kslb;
	}

	public Date getSyrq() {
		return syrq;
	}

	public void setSyrq(Date syrq) {
		this.syrq = syrq;
	}

}