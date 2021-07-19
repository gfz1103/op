package com.buit.commons.model;

import java.sql.Date;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpYygh<br>
 * 类描述：门诊_预约挂号
 * 
 * @author WY @ApiModel(value="门诊_预约挂号")
 */
public class OpYygh extends PageQuery {
	// @ApiModelProperty(value="预约序号")
	/** 预约序号 */
	private Integer yyxh;
	// @ApiModelProperty(value="机构代码")
	/** 机构代码 */
	private Integer jgid;
	// @ApiModelProperty(value="预约密码")
	/** 预约密码 */
	private String yymm;
	// @ApiModelProperty(value="病人ID")
	/** 病人ID */
	private Integer brid;
	// @ApiModelProperty(value="挂号日期")
	/** 挂号日期 */
	private Timestamp ghsj;
	// @ApiModelProperty(value="科室代码")
	/** 科室代码 */
	private Integer ksdm;
	// @ApiModelProperty(value="值班类别")
	/** 值班类别 */
	private String zblb;
	// @ApiModelProperty(value="医生代码")
	/** 医生代码 */
	private String ysdm;
	// @ApiModelProperty(value="预约类别")
	/** 预约类别 */
	private Integer yylb;
	// @ApiModelProperty(value="挂号标志 | 0.预约 1.履约 2.失约 3.收费 4.退约")
	/** 挂号标志 | 0.预约 1.履约 2.失约 3.收费 4.退约 */
	private Integer ghbz;
	// @ApiModelProperty(value="预约日期")
	/** 预约日期 */
	private Date yyrq;
	// @ApiModelProperty(value="就诊序号")
	/** 就诊序号 */
	private Integer jzxh;
	// @ApiModelProperty(value="识别序号")
	/** 识别序号 */
	private Integer sbxh;
	// @ApiModelProperty(value="注册ID")
	/** 注册ID */
	private Integer zcid;
	// @ApiModelProperty(value="登记工号")
	/** 登记工号 */
	private String djgh;
	// @ApiModelProperty(value="是否取号")
	/** 是否取号 */
	private Integer sfqh;
	// @ApiModelProperty(value="取号员工")
	/** 取号员工 */
	private String qhyg;
	// @ApiModelProperty(value="取号时间")
	/** 取号时间 */
	private Timestamp qhsj;
	// @ApiModelProperty(value="诊室id")
	/** 诊室id */
	private String zsid;
	// @ApiModelProperty(value="更改预约日期次数")
	/** 更改预约日期次数 */
	private Integer ggcs;
	// @ApiModelProperty(value="最后更改工号")
	/** 最后更改工号 */
	private String gggh;
	// @ApiModelProperty(value="最后更改时间")
	/** 最后更改时间 */
	private Timestamp ggsj;
	// @ApiModelProperty(value="排队（优先）号码")
	/** 排队（优先）号码 */
	private String pdhm;
	// @ApiModelProperty(value="叫号号码")
	/** 叫号号码 */
	private String jhhm;
	// @ApiModelProperty(value="卡号")
	/** 卡号 */
	private String cardno;
	// @ApiModelProperty(value="ddcs")
	/** ddcs */
	private Integer ddcs;
	// @ApiModelProperty(value="pdxh")
	/** pdxh */
	private Integer pdxh;
	@JsonIgnore
	@ApiModelProperty(value = "查询开始时间")
	private Timestamp beginOfDay;
	@JsonIgnore
	@ApiModelProperty(value = "查询结束时间")
	private Timestamp endOfDay;
	// @ApiModelProperty(value="就诊流水号")
	/** 就诊流水号 */
	private String jzlsh;

	/** 设置:预约序号 */
	public void setYyxh(Integer value) {
		this.yyxh = value;
	}

	/** 获取:预约序号 */
	public Integer getYyxh() {
		return yyxh;
	}

	/** 设置:机构代码 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/** 获取:机构代码 */
	public Integer getJgid() {
		return jgid;
	}

	/** 设置:预约密码 */
	public void setYymm(String value) {
		this.yymm = value;
	}

	/** 获取:预约密码 */
	public String getYymm() {
		return yymm;
	}

	/** 设置:病人ID */
	public void setBrid(Integer value) {
		this.brid = value;
	}

	/** 获取:病人ID */
	public Integer getBrid() {
		return brid;
	}

	/** 设置:挂号日期 */
	public void setGhsj(Timestamp value) {
		this.ghsj = value;
	}

	/** 获取:挂号日期 */
	public Timestamp getGhsj() {
		return ghsj;
	}

	/** 设置:科室代码 */
	public void setKsdm(Integer value) {
		this.ksdm = value;
	}

	/** 获取:科室代码 */
	public Integer getKsdm() {
		return ksdm;
	}

	/** 设置:值班类别 */
	public void setZblb(String value) {
		this.zblb = value;
	}

	/** 获取:值班类别 */
	public String getZblb() {
		return zblb;
	}

	/** 设置:医生代码 */
	public void setYsdm(String value) {
		this.ysdm = value;
	}

	/** 获取:医生代码 */
	public String getYsdm() {
		return ysdm;
	}

	/** 设置:预约类别 */
	public void setYylb(Integer value) {
		this.yylb = value;
	}

	/** 获取:预约类别 */
	public Integer getYylb() {
		return yylb;
	}

	/** 设置:挂号标志 | 0.预约 1.履约 2.失约 3.收费 4.退约 */
	public void setGhbz(Integer value) {
		this.ghbz = value;
	}

	/** 获取:挂号标志 | 0.预约 1.履约 2.失约 3.收费 4.退约 */
	public Integer getGhbz() {
		return ghbz;
	}

	/** 设置:预约日期 */
	public void setYyrq(Date value) {
		this.yyrq = value;
	}

	/** 获取:预约日期 */
	public Date getYyrq() {
		return yyrq;
	}

	/** 设置:就诊序号 */
	public void setJzxh(Integer value) {
		this.jzxh = value;
	}

	/** 获取:就诊序号 */
	public Integer getJzxh() {
		return jzxh;
	}

	/** 设置:识别序号 */
	public void setSbxh(Integer value) {
		this.sbxh = value;
	}

	/** 获取:识别序号 */
	public Integer getSbxh() {
		return sbxh;
	}

	/** 设置:注册ID */
	public void setZcid(Integer value) {
		this.zcid = value;
	}

	/** 获取:注册ID */
	public Integer getZcid() {
		return zcid;
	}

	/** 设置:登记工号 */
	public void setDjgh(String value) {
		this.djgh = value;
	}

	/** 获取:登记工号 */
	public String getDjgh() {
		return djgh;
	}

	/** 设置:是否取号 */
	public void setSfqh(Integer value) {
		this.sfqh = value;
	}

	/** 获取:是否取号 */
	public Integer getSfqh() {
		return sfqh;
	}

	/** 设置:取号员工 */
	public void setQhyg(String value) {
		this.qhyg = value;
	}

	/** 获取:取号员工 */
	public String getQhyg() {
		return qhyg;
	}

	/** 设置:取号时间 */
	public void setQhsj(Timestamp value) {
		this.qhsj = value;
	}

	/** 获取:取号时间 */
	public Timestamp getQhsj() {
		return qhsj;
	}

	/** 设置:诊室id */
	public void setZsid(String value) {
		this.zsid = value;
	}

	/** 获取:诊室id */
	public String getZsid() {
		return zsid;
	}

	/** 设置:更改预约日期次数 */
	public void setGgcs(Integer value) {
		this.ggcs = value;
	}

	/** 获取:更改预约日期次数 */
	public Integer getGgcs() {
		return ggcs;
	}

	/** 设置:最后更改工号 */
	public void setGggh(String value) {
		this.gggh = value;
	}

	/** 获取:最后更改工号 */
	public String getGggh() {
		return gggh;
	}

	/** 设置:最后更改时间 */
	public void setGgsj(Timestamp value) {
		this.ggsj = value;
	}

	/** 获取:最后更改时间 */
	public Timestamp getGgsj() {
		return ggsj;
	}

	/** 设置:排队（优先）号码 */
	public void setPdhm(String value) {
		this.pdhm = value;
	}

	/** 获取:排队（优先）号码 */
	public String getPdhm() {
		return pdhm;
	}

	/** 设置:叫号号码 */
	public void setJhhm(String value) {
		this.jhhm = value;
	}

	/** 获取:叫号号码 */
	public String getJhhm() {
		return jhhm;
	}

	/** 设置:卡号 */
	public void setCardno(String value) {
		this.cardno = value;
	}

	/** 获取:卡号 */
	public String getCardno() {
		return cardno;
	}

	/** 设置:ddcs */
	public void setDdcs(Integer value) {
		this.ddcs = value;
	}

	/** 获取:ddcs */
	public Integer getDdcs() {
		return ddcs;
	}

	/** 设置:pdxh */
	public void setPdxh(Integer value) {
		this.pdxh = value;
	}

	/** 获取:pdxh */
	public Integer getPdxh() {
		return pdxh;
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

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}
}
