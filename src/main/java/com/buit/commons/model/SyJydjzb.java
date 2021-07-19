package com.buit.commons.model;

import java.sql.Date;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SyJydjzb<br>
 * 类描述：输液/注射接药登记主表
 * 
 * @author WY @ApiModel(value="输液/注射接药登记主表")
 */
public class SyJydjzb extends PageQuery {
	// @ApiModelProperty(value="医疗机构代码")
	/** 医疗机构代码 */
	private Integer jgid;
	// @ApiModelProperty(value="输液科室代码")
	/** 科室代码 主键 HIS科室代码 */
	private Integer ksdm;
	// @ApiModelProperty(value="登记单号")
	/** 登记单号 */
	private String djdh;
	// @ApiModelProperty(value="科室类别 1输液室/2注射室")
	/** 科室类别 1输液室/2注射室 */
	private String kslb;
	// @ApiModelProperty(value="登记时间")
	/** 登记时间 */
	private Timestamp djsj;
	// @ApiModelProperty(value="病人ID")
	private Integer brid;
	// @ApiModelProperty(value="卡号")
	/** 卡号 */
	private String jzkh;
	// @ApiModelProperty(value="输液/注射日期")
	/** 输液/注射日期 */
	private Date syrq;
	// @ApiModelProperty(value="登记人代码")
	/** 登记人代码 */
	private Integer djrdm;
	// @ApiModelProperty(value="状态 1 输液/注射中/2 输液/注射完成")
	/** 状态 1 输液/注射中/2 输液/注射完成 */
	private String zt;
	// @ApiModelProperty(value="完成时间")
	/** 完成时间 */
	private Timestamp wcsj;
	// @ApiModelProperty(value="完成操作人代码")
	/** 完成操作人代码 */
	private String wcczrdm;
	@ApiModelProperty(value = "开始时间")
	private Timestamp beginDay;
	@ApiModelProperty(value = "结束时间")
	private Timestamp endDay;
	@ApiModelProperty(value = "发票号码")
	private String fphm;

	/** 设置:医疗机构代码 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/** 获取:医疗机构代码 */
	public Integer getJgid() {
		return jgid;
	}

	/** 设置:科室代码 主键 HIS科室代码 */
	public void setKsdm(Integer value) {
		this.ksdm = value;
	}

	/** 获取:科室代码 主键 HIS科室代码 */
	public Integer getKsdm() {
		return ksdm;
	}

	/** 设置:登记单号 */
	public void setDjdh(String value) {
		this.djdh = value;
	}

	/** 获取:登记单号 */
	public String getDjdh() {
		return djdh;
	}

	/** 设置:科室类别 1输液室/2注射室 */
	public void setKslb(String value) {
		this.kslb = value;
	}

	/** 获取:科室类别 1输液室/2注射室 */
	public String getKslb() {
		return kslb;
	}

	/** 设置:登记时间 */
	public void setDjsj(Timestamp value) {
		this.djsj = value;
	}

	/** 获取:登记时间 */
	public Timestamp getDjsj() {
		return djsj;
	}

	/** 设置:卡号 */
	public void setJzkh(String value) {
		this.jzkh = value;
	}

	/** 获取:卡号 */
	public String getJzkh() {
		return jzkh;
	}

	/** 设置:输液/注射日期 */
	public void setSyrq(Date value) {
		this.syrq = value;
	}

	/** 获取:输液/注射日期 */
	public Date getSyrq() {
		return syrq;
	}

	public Integer getDjrdm() {
		return djrdm;
	}

	public void setDjrdm(Integer djrdm) {
		this.djrdm = djrdm;
	}

	/** 设置:状态 1 输液/注射中/2 输液/注射完成 */
	public void setZt(String value) {
		this.zt = value;
	}

	/** 获取:状态 1 输液/注射中/2 输液/注射完成 */
	public String getZt() {
		return zt;
	}

	/** 设置:完成时间 */
	public void setWcsj(Timestamp value) {
		this.wcsj = value;
	}

	/** 获取:完成时间 */
	public Timestamp getWcsj() {
		return wcsj;
	}

	/** 设置:完成操作人代码 */
	public void setWcczrdm(String value) {
		this.wcczrdm = value;
	}

	/** 获取:完成操作人代码 */
	public String getWcczrdm() {
		return wcczrdm;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public Timestamp getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(Timestamp beginDay) {
		this.beginDay = beginDay;
	}

	public Timestamp getEndDay() {
		return endDay;
	}

	public void setEndDay(Timestamp endDay) {
		this.endDay = endDay;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

}