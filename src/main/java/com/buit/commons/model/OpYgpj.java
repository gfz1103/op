package com.buit.commons.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpYgpj<br>
 * 类描述：门诊_门诊员工票据
 * 
 * @author WY @ApiModel(value="门诊_门诊员工票据")
 */
public class OpYgpj extends PageQuery {
	@ApiModelProperty(value = "记录序号")
	/** 记录序号 */
	private Integer jlxh;
	@ApiModelProperty(value = "员工代码")
	/** 员工代码 */
	private Integer ygdm;
	@ApiModelProperty(value = "领用人名称")
	/** 领用人名称 */
	private String userName;
	@ApiModelProperty(value = "领用日期")
	/** 领用日期 */
	private Timestamp lyrq;
	@JsonIgnore
	@ApiModelProperty(value = "票据类型")
	/** 票据类型 */
	private Integer pjlx;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	/** 机构代码 */
	private Integer jgid;
	@ApiModelProperty(value = "起始号码")
	/** 起始号码 */
	private String qshm;
	@ApiModelProperty(value = "终止号码")
	/** 终止号码 */
	private String zzhm;
	@ApiModelProperty(value = "使用号码")
	/** 使用号码 */
	private String syhm;
	@ApiModelProperty(value = "使用判别")
	/** 使用判别 */
	private Integer sypb;
	@JsonIgnore
	@ApiModelProperty(value = "号码长度")
	/** 号码长度 */
	private Integer length;

	@ApiModelProperty(value = "截取判别")
	private Integer jqpb;

	/** 设置:记录序号 */
	public void setJlxh(Integer value) {
		this.jlxh = value;
	}

	/** 获取:记录序号 */
	public Integer getJlxh() {
		return jlxh;
	}

	/** 设置:员工代码 */
	public void setYgdm(Integer value) {
		this.ygdm = value;
	}

	/** 获取:员工代码 */
	public Integer getYgdm() {
		return ygdm;
	}

	public Timestamp getLyrq() {
		return lyrq;
	}

	public void setLyrq(Timestamp lyrq) {
		this.lyrq = lyrq;
	}

	/** 设置:票据类型 */
	public void setPjlx(Integer value) {
		this.pjlx = value;
	}

	/** 获取:票据类型 */
	public Integer getPjlx() {
		return pjlx;
	}

	/** 设置:机构代码 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/** 获取:机构代码 */
	public Integer getJgid() {
		return jgid;
	}

	/** 设置:使用判别 */
	public void setSypb(Integer value) {
		this.sypb = value;
	}

	/** 获取:使用判别 */
	public Integer getSypb() {
		return sypb;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getQshm() {
		return qshm;
	}

	public void setQshm(String qshm) {
		this.qshm = qshm;
	}

	public String getZzhm() {
		return zzhm;
	}

	public void setZzhm(String zzhm) {
		this.zzhm = zzhm;
	}

	public String getSyhm() {
		return syhm;
	}

	public void setSyhm(String syhm) {
		this.syhm = syhm;
	}

	public Integer getJqpb() {
		return jqpb;
	}

	public void setJqpb(Integer jqpb) {
		this.jqpb = jqpb;
	}
}
