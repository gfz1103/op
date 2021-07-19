package com.buit.commons.model;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

/**
 * 类名称：OpFkxx<br>
 * 类描述：门诊_门诊收费付款信息
 * 
 * @author WY @ApiModel(value="门诊_门诊收费付款信息")
 */
public class OpFkxx extends PageQuery {
	// @ApiModelProperty(value="记录序号")
	/** 记录序号 */
	private Integer jlxh;
	// @ApiModelProperty(value="机构代码")
	/** 机构代码 */
	private Integer jgid;
	// @ApiModelProperty(value="门诊序号")
	/** 门诊序号 */
	private Integer mzxh;
	// @ApiModelProperty(value="付款方式")
	/** 付款方式 */
	private Integer fkfs;
	// @ApiModelProperty(value="付款金额")
	/** 付款金额 */
	private BigDecimal fkje;
	// @ApiModelProperty(value="付款号码")
	/** 付款号码 */
	private String fkhm;
	// @ApiModelProperty(value="门诊就诊流水号")
	private String jzlsh;

	/** 设置:记录序号 */
	public void setJlxh(Integer value) {
		this.jlxh = value;
	}

	/** 获取:记录序号 */
	public Integer getJlxh() {
		return jlxh;
	}

	/** 设置:机构代码 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/** 获取:机构代码 */
	public Integer getJgid() {
		return jgid;
	}

	/** 设置:门诊序号 */
	public void setMzxh(Integer value) {
		this.mzxh = value;
	}

	/** 获取:门诊序号 */
	public Integer getMzxh() {
		return mzxh;
	}

	/** 设置:付款方式 */
	public void setFkfs(Integer value) {
		this.fkfs = value;
	}

	/** 获取:付款方式 */
	public Integer getFkfs() {
		return fkfs;
	}

	/** 设置:付款金额 */
	public void setFkje(BigDecimal value) {
		this.fkje = value;
	}

	/** 获取:付款金额 */
	public BigDecimal getFkje() {
		return fkje;
	}

	/** 设置:付款号码 */
	public void setFkhm(String value) {
		this.fkhm = value;
	}

	/** 获取:付款号码 */
	public String getFkhm() {
		return fkhm;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

}
