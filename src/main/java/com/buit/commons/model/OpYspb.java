package com.buit.commons.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpYspb<br>
 * 类描述：门诊_门诊医生排班
 * 
 * @author wangyang
 */
@ApiModel(value = "门诊医生排班实体")
public class OpYspb extends PageQuery {
	@ApiModelProperty(value = "工作日期 | 在该表中保存每天排班情况")
	/** 工作日期 | 在该表中保存每天排班情况 */
	private Timestamp gzrq;
	@ApiModelProperty(value = "科室代码")
	/** 科室代码 */
	private Integer ksdm;
	@ApiModelProperty(value = "医生代码")
	/** 医生代码 */
	private String ysdm;
	@ApiModelProperty(value = "值班类别 | 值班类别：1.上午 2.下午")
	/** 值班类别 | 值班类别：1.上午 2.下午 修改为从op_bcsj表取时间段标识 */
	private String zblb;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	/** 机构代码 */
	private Integer jgid;
	@ApiModelProperty(value = "挂号限额")
	/** 挂号限额 */
	private Integer ghxe;
	@ApiModelProperty(value = "已挂人数")
	/** 已挂人数 */
	private Integer ygrs;
	@ApiModelProperty(value = "预约人数")
	/** 预约人数 */
	private Integer yyrs;
	@ApiModelProperty(value = "就诊序号")
	/** 就诊序号 */
	private Integer jzxh;
	@ApiModelProperty(value = "预约限额")
	/** 预约限额 */
	private Integer yyxe;
	@ApiModelProperty(value = "停挂标志 | 用于导诊系统 0.可挂号 1.不可挂号")
	/** 停挂标志 | 用于导诊系统 0.可挂号 1.不可挂号 */
	private Integer tgbz;
	@ApiModelProperty(value = "服务类型，1：出诊 2：上门")
	/** 服务类型，1：出诊 2：上门 */
	private Integer fwlx;
	@ApiModelProperty(value = "诊室ID")
	/** 诊室ID */
	private String zsid;
	@ApiModelProperty(value = "是否停诊(1是,0否)")
	/** 是否停诊(1是,0否) */
	private String sftz;
	@ApiModelProperty(value = "科室名称")
	/** 科室名称 */
	private String ksmc;
	@ApiModelProperty(value = "医生名称")
	/** 医生名称 */
	private String personName;
	@JsonIgnore
	@ApiModelProperty(value = "查询开始时间")
	private Timestamp beginOfDay;
	@JsonIgnore
	@ApiModelProperty(value = "查询结束时间")
	private Timestamp endOfDay;
	@ApiModelProperty(value = "预约日期")
	private String yyrq;
	@JsonIgnore
	@ApiModelProperty(value = "关键字查询")
	private String keyword;


	public Timestamp getGzrq() {
		return gzrq;
	}

	public void setGzrq(Timestamp gzrq) {
		this.gzrq = gzrq;
	}

	/** 设置:科室代码 */
	public void setKsdm(Integer value) {
		this.ksdm = value;
	}

	/** 获取:科室代码 */
	public Integer getKsdm() {
		return ksdm;
	}

	/** 设置:医生代码 */
	public void setYsdm(String value) {
		this.ysdm = value;
	}

	/** 获取:医生代码 */
	public String getYsdm() {
		return ysdm;
	}

	/** 设置:值班类别 | 值班类别：1.上午 2.下午 */
	public void setZblb(String value) {
		this.zblb = value;
	}

	/** 获取:值班类别 | 值班类别：1.上午 2.下午 */
	public String getZblb() {
		return zblb;
	}

	/** 设置:机构代码 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/** 获取:机构代码 */
	public Integer getJgid() {
		return jgid;
	}

	/** 设置:挂号限额 */
	public void setGhxe(Integer value) {
		this.ghxe = value;
	}

	/** 获取:挂号限额 */
	public Integer getGhxe() {
		return ghxe;
	}

	/** 设置:已挂人数 */
	public void setYgrs(Integer value) {
		this.ygrs = value;
	}

	/** 获取:已挂人数 */
	public Integer getYgrs() {
		return ygrs;
	}

	/** 设置:预约人数 */
	public void setYyrs(Integer value) {
		this.yyrs = value;
	}

	/** 获取:预约人数 */
	public Integer getYyrs() {
		return yyrs;
	}

	/** 设置:就诊序号 */
	public void setJzxh(Integer value) {
		this.jzxh = value;
	}

	/** 获取:就诊序号 */
	public Integer getJzxh() {
		return jzxh;
	}

	/** 设置:预约限额 */
	public void setYyxe(Integer value) {
		this.yyxe = value;
	}

	/** 获取:预约限额 */
	public Integer getYyxe() {
		return yyxe;
	}

	/** 设置:停挂标志 | 用于导诊系统 0.可挂号 1.不可挂号 */
	public void setTgbz(Integer value) {
		this.tgbz = value;
	}

	/** 获取:停挂标志 | 用于导诊系统 0.可挂号 1.不可挂号 */
	public Integer getTgbz() {
		return tgbz;
	}

	/** 设置:服务类型，1：出诊 2：上门 */
	public void setFwlx(Integer value) {
		this.fwlx = value;
	}

	/** 获取:服务类型，1：出诊 2：上门 */
	public Integer getFwlx() {
		return fwlx;
	}

	/** 设置:诊室ID */
	public void setZsid(String value) {
		this.zsid = value;
	}

	/** 获取:诊室ID */
	public String getZsid() {
		return zsid;
	}

	/** 设置:是否停诊(1是,0否) */
	public void setSftz(String value) {
		this.sftz = value;
	}

	/** 获取:是否停诊(1是,0否) */
	public String getSftz() {
		return sftz;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
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

	public String getYyrq() {
		return yyrq;
	}

	public void setYyrq(String yyrq) {
		this.yyrq = yyrq;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
