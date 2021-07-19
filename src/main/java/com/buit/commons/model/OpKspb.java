package com.buit.commons.model;

import java.sql.Date;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpKspb<br>
 * 类描述：门诊_科室排班
 * 
 * @author wangyang
 */
@ApiModel(value = "门诊_科室排班")
public class OpKspb extends PageQuery {
	@ApiModelProperty(value = "挂号日期")
	/** 挂号日期 */
	private Date ghrq;
	@ApiModelProperty(value = "值班类别")
	/** 值班类别 */
	private String zblb;
	@ApiModelProperty(value = "挂号科室  SYS_DICT_CONFIG:13")
	/** 挂号科室 */
	private String ghks;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	/** 机构代码 */
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "就诊序号")
	/** 就诊序号 */
	private Integer jzxh;
	@ApiModelProperty(value = "挂号限额")
	/** 挂号限额 */
	private Integer ghxe;
	@JsonIgnore
	@ApiModelProperty(value = "已挂人数")
	/** 已挂人数 */
	private Integer ygrs;
	@JsonIgnore
	@ApiModelProperty(value = "预约人数")
	/** 预约人数 */
	private Integer yyrs;
	@ApiModelProperty(value = "预约限额")
	/** 预约限额 */
	private Integer yyxe;
	@ApiModelProperty(value = "停挂标志")
	/** 停挂标志 */
	private Integer tgbz;
	@ApiModelProperty(value = "科室名称")
	/** 科室名称 */
	private String ksmc;
	@ApiModelProperty(value = "门诊名称")
	/** 门诊名称 */
	private String mzmc;
	@ApiModelProperty(value = "科室排班标识")
	/** 科室排班标识 */
	private Integer kspb;
	@JsonIgnore
	@ApiModelProperty(value = "查询开始时间")
	private Timestamp beginOfDay;
	@JsonIgnore
	@ApiModelProperty(value = "查询结束时间")
	private Timestamp endOfDay;
	@ApiModelProperty(value = "门诊科室ID")
	private Integer officeCode;
	@ApiModelProperty(value = "关键字查询")
	private String keyword;
	public Date getGhrq() {
		return ghrq;
	}

	public void setGhrq(Date ghrq) {
		this.ghrq = ghrq;
	}

	public String getZblb() {
		return zblb;
	}

	public void setZblb(String zblb) {
		this.zblb = zblb;
	}

	public String getGhks() {
		return ghks;
	}

	public void setGhks(String ghks) {
		this.ghks = ghks;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getJzxh() {
		return jzxh;
	}

	public void setJzxh(Integer jzxh) {
		this.jzxh = jzxh;
	}

	public Integer getGhxe() {
		return ghxe;
	}

	public void setGhxe(Integer ghxe) {
		this.ghxe = ghxe;
	}

	public Integer getYgrs() {
		return ygrs;
	}

	public void setYgrs(Integer ygrs) {
		this.ygrs = ygrs;
	}

	public Integer getYyrs() {
		return yyrs;
	}

	public void setYyrs(Integer yyrs) {
		this.yyrs = yyrs;
	}

	public Integer getYyxe() {
		return yyxe;
	}

	public void setYyxe(Integer yyxe) {
		this.yyxe = yyxe;
	}

	public Integer getTgbz() {
		return tgbz;
	}

	public void setTgbz(Integer tgbz) {
		this.tgbz = tgbz;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public String getMzmc() {
		return mzmc;
	}

	public void setMzmc(String mzmc) {
		this.mzmc = mzmc;
	}

	public Integer getKspb() {
		return kspb;
	}

	public void setKspb(Integer kspb) {
		this.kspb = kspb;
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

	public Integer getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(Integer officeCode) {
		this.officeCode = officeCode;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
