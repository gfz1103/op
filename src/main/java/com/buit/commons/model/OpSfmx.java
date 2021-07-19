package com.buit.commons.model;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

/**
 * 类名称：OpSfmx<br>
 * 类描述：门诊_收费明细表
 * 
 * @author WY @ApiModel(value="门诊_收费明细表")
 */
public class OpSfmx extends PageQuery {
	// @ApiModelProperty(value="门诊序号")
	/** 门诊序号 */
	private Integer mzxh;
	// @ApiModelProperty(value="收费项目 | 和DIC_SFXMLB的SFXM关联")
	/** 收费项目 | 和DIC_SFXMLB的SFXM关联 */
	private Integer sfxm;
	// @ApiModelProperty(value="机构代码")
	/** 机构代码 */
	private Integer jgid;
	// @ApiModelProperty(value="总计金额 | 该收费项目的总金额")
	/** 总计金额 | 该收费项目的总金额 */
	private BigDecimal zjje;
	// @ApiModelProperty(value="自负金额 | 该收费项目的自负金额 当该病人使用帐户，ZFJE中为该项目纯自负部分")
	/** 自负金额 | 该收费项目的自负金额 当该病人使用帐户，ZFJE中为该项目纯自负部分 */
	private BigDecimal zfje;
	// @ApiModelProperty(value="发票号码 | 通过此字段与OP_MZXX关联")
	/** 发票号码 | 通过此字段与OP_MZXX关联 */
	private String fphm;
	// @ApiModelProperty(value="纯自负金额")
	/** 纯自负金额 */
	private BigDecimal czf;
	// @ApiModelProperty(value="分类自负金额")
	/** 分类自负金额 */
	private BigDecimal flzf;
	// @ApiModelProperty(value="门诊就诊流水号")
	private String jzlsh;

	private BigDecimal jmje;

	/** 设置:门诊序号 */
	public void setMzxh(Integer value) {
		this.mzxh = value;
	}

	/** 获取:门诊序号 */
	public Integer getMzxh() {
		return mzxh;
	}

	/** 设置:收费项目 | 和DIC_SFXMLB的SFXM关联 */
	public void setSfxm(Integer value) {
		this.sfxm = value;
	}

	/** 获取:收费项目 | 和DIC_SFXMLB的SFXM关联 */
	public Integer getSfxm() {
		return sfxm;
	}

	/** 设置:机构代码 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/** 获取:机构代码 */
	public Integer getJgid() {
		return jgid;
	}

	/** 设置:总计金额 | 该收费项目的总金额 */
	public void setZjje(BigDecimal value) {
		this.zjje = value;
	}

	/** 获取:总计金额 | 该收费项目的总金额 */
	public BigDecimal getZjje() {
		return zjje;
	}

	/** 设置:自负金额 | 该收费项目的自负金额 当该病人使用帐户，ZFJE中为该项目纯自负部分 */
	public void setZfje(BigDecimal value) {
		this.zfje = value;
	}

	/** 获取:自负金额 | 该收费项目的自负金额 当该病人使用帐户，ZFJE中为该项目纯自负部分 */
	public BigDecimal getZfje() {
		return zfje;
	}

	/** 设置:发票号码 | 通过此字段与OP_MZXX关联 */
	public void setFphm(String value) {
		this.fphm = value;
	}

	/** 获取:发票号码 | 通过此字段与OP_MZXX关联 */
	public String getFphm() {
		return fphm;
	}

	/** 设置:纯自负金额 */
	public void setCzf(BigDecimal value) {
		this.czf = value;
	}

	/** 获取:纯自负金额 */
	public BigDecimal getCzf() {
		return czf;
	}

	/** 设置:分类自负金额 */
	public void setFlzf(BigDecimal value) {
		this.flzf = value;
	}

	/** 获取:分类自负金额 */
	public BigDecimal getFlzf() {
		return flzf;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public BigDecimal getJmje() {
		return jmje;
	}

	public void setJmje(BigDecimal jmje) {
		this.jmje = jmje;
	}
}
