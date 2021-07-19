package com.buit.commons.request;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpYspbDelReq<br>
 * 类描述：门诊医生排班删除<br>
 * 
 * @author wangyang
 */
@ApiModel(value = "门诊医生排班删除")
public class OpYspbDelReq extends PageQuery {
	@ApiModelProperty(value = "工作日期：默认传当前日期, 格式：yyyy-MM-dd ")
	private Date gzrq;
	@NotNull(message = "值班类别不能为空")
	@ApiModelProperty(value = "值班类别：1.上午  2.下午   默认传1")
	private String zblb;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "医生代码 ")
	private Integer ysdm;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "查询开始时间")
	private Timestamp beginOfDay;
	@JsonIgnore
	@ApiModelProperty(value = "查询结束时间")
	private Timestamp endOfDay;

	public Date getGzrq() {
		return gzrq;
	}

	public void setGzrq(Date gzrq) {
		this.gzrq = gzrq;
	}

	public String getZblb() {
		return zblb;
	}

	public void setZblb(String zblb) {
		this.zblb = zblb;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Timestamp getBeginOfDay() {
		return beginOfDay;
	}

	public void setBeginOfDay(Timestamp beginOfDay) {
		this.beginOfDay = beginOfDay;
	}

	public Timestamp getEndOfDay() {
		return endOfDay;
	}

	public void setEndOfDay(Timestamp endOfDay) {
		this.endOfDay = endOfDay;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Integer getYsdm() {
		return ysdm;
	}

	public void setYsdm(Integer ysdm) {
		this.ysdm = ysdm;
	}

}
