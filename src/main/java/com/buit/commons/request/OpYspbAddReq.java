package com.buit.commons.request;

import java.sql.Date;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpYspbAddReq<br>
 * 类描述：门诊_门诊医生排班<br>
 * 
 * @author wangyang
 */
@ApiModel(value = "门诊医生排班请求")
public class OpYspbAddReq extends PageQuery {
	@ApiModelProperty(value = "工作日期 | 在该表中保存每天排班情况")
	/** 工作日期 | 在该表中保存每天排班情况 */
	private Date gzrq;
	@ApiModelProperty(value = "科室代码")
	/** 科室代码 */
	private Integer ksdm;
	@ApiModelProperty(value = "医生代码")
	/** 医生代码 */
	private String ysdm;
	@ApiModelProperty(value = "值班类别 | 值班类别：1.上午 2.下午")
	/** 值班类别 | 值班类别：1.上午 2.下午 */
	private String zblb;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	/** 机构代码 */
	private Integer jgid;
	@ApiModelProperty(value = "挂号限额")
	/** 挂号限额 */
	private Integer ghxe;
	@ApiModelProperty(value = "预约限额")
	/** 预约限额 */
	private Integer yyxe;
	@ApiModelProperty(value = "服务类型，1：出诊 2：上门")
	/** 服务类型，1：出诊 2：上门 */
	private Integer fwlx;

	public Date getGzrq() {
		return gzrq;
	}

	public void setGzrq(Date gzrq) {
		this.gzrq = gzrq;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getYsdm() {
		return ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
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

}
