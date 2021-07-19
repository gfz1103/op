
package com.buit.commons.request;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpYgpj<br>
 * 类描述：票据号码维护<br>
 * 
 * @author WY
 */
@ApiModel(value = "票据号码维护")
public class OpYgpjReq extends PageQuery {
	@ApiModelProperty(value = "记录序号 修改时需要")
	private Integer jlxh;
	@JsonIgnore
	@ApiModelProperty(value = "员工代码")
	private Integer ygdm;
	@JsonIgnore
	@ApiModelProperty(value = "领用日期")
	private Timestamp lyrq;
	@NotNull(message = "票据类型不能为空")
	@ApiModelProperty(value = "票据类型：1：就诊号码维护；    2：发票号码维护；3：门诊号码维护")
	private Integer pjlx;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "起始号码")
	private String qshm;
	@JsonIgnore
	@ApiModelProperty(value = "终止号码")
	private String zzhm;
	@JsonIgnore
	@ApiModelProperty(value = "使用号码")
	private String syhm;
	@JsonIgnore
	@ApiModelProperty(value = "使用判别")
	private Integer sypb;

	/**
	 * 设置:记录序号
	 */
	public void setJlxh(Integer value) {
		this.jlxh = value;
	}

	/**
	 * 获取:记录序号
	 */
	public Integer getJlxh() {
		return jlxh;
	}

	/**
	 * 设置:员工代码
	 */
	public void setYgdm(Integer value) {
		this.ygdm = value;
	}

	/**
	 * 获取:员工代码
	 */
	public Integer getYgdm() {
		return ygdm;
	}

	/**
	 * 设置:领用日期
	 */
	public void setLyrq(Timestamp value) {
		this.lyrq = value;
	}

	/**
	 * 获取:领用日期
	 */
	public Timestamp getLyrq() {
		return lyrq;
	}

	/**
	 * 设置:票据类型
	 */
	public void setPjlx(Integer value) {
		this.pjlx = value;
	}

	/**
	 * 获取:票据类型
	 */
	public Integer getPjlx() {
		return pjlx;
	}

	/**
	 * 设置:机构代码
	 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/**
	 * 获取:机构代码
	 */
	public Integer getJgid() {
		return jgid;
	}

	/**
	 * 设置:起始号码
	 */
	public void setQshm(String value) {
		this.qshm = value;
	}

	/**
	 * 获取:起始号码
	 */
	public String getQshm() {
		return qshm;
	}

	/**
	 * 设置:终止号码
	 */
	public void setZzhm(String value) {
		this.zzhm = value;
	}

	/**
	 * 获取:终止号码
	 */
	public String getZzhm() {
		return zzhm;
	}

	/**
	 * 设置:使用号码
	 */
	public void setSyhm(String value) {
		this.syhm = value;
	}

	/**
	 * 获取:使用号码
	 */
	public String getSyhm() {
		return syhm;
	}

	/**
	 * 设置:使用判别
	 */
	public void setSypb(Integer value) {
		this.sypb = value;
	}

	/**
	 * 获取:使用判别
	 */
	public Integer getSypb() {
		return sypb;
	}
}
