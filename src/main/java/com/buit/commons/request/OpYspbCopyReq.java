package com.buit.commons.request;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpYspb<br>
 * 类描述：门诊_门诊医生排班复制<br>
 * 
 * @author wangyang
 */
@ApiModel(value = "医生排班复制请求")
public class OpYspbCopyReq extends PageQuery {
	private static final long serialVersionUID = 661363868178662493L;
	@ApiModelProperty(value = "科室代码")
	/** 所在科室 */
	private Integer ksdm;
	@ApiModelProperty(value = "医生代码")
	/** 所在科室 */
	private String ysdm;
	@NotNull(message = "开始时间不能为空")
	@ApiModelProperty(value = "复制开始时间")
	/** 复制开始时间 */
	private Date beginDay;
	@NotNull(message = "结束时间不能为空")
	@ApiModelProperty(value = "复制结束时间")
	/** 复制结束时间 */
	private Date endDay;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "查询开始时间")
	private Timestamp beginOfDay;
	@JsonIgnore
	@ApiModelProperty(value = "查询结束时间")
	private Timestamp endOfDay;
	@ApiModelProperty(value = "挂号限额")
	private Integer ghxe;
	@ApiModelProperty(value = "预约限额")
	private Integer yyxe;
	@ApiModelProperty(value = "服务类型，1：坐诊 2：上门")
	private Integer fwlx;
	@ApiModelProperty(value = "值班类别")
	private String zblb;

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
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

	public String getYsdm() {
		return ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
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

	public Integer getGhxe() {
		return ghxe;
	}

	public void setGhxe(Integer ghxe) {
		this.ghxe = ghxe;
	}

	public Integer getYyxe() {
		return yyxe;
	}

	public void setYyxe(Integer yyxe) {
		this.yyxe = yyxe;
	}

	public Integer getFwlx() {
		return fwlx;
	}

	public void setFwlx(Integer fwlx) {
		this.fwlx = fwlx;
	}

	public String getZblb() {
		return zblb;
	}

	public void setZblb(String zblb) {
		this.zblb = zblb;
	}

}
