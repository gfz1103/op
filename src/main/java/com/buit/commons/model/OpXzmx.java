package com.buit.commons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：OpXzmx<br>
 * 类描述：门诊_日报性质明细
 * 
 * @author WY @ApiModel(value="门诊_日报性质明细")
 */
public class OpXzmx extends PageQuery {
	// @ApiModelProperty(value="操作工号")
	/** 操作工号 */
	private String czgh;
	// @ApiModelProperty(value="结帐日期")
	/** 结帐日期 */
	private Timestamp jzrq;
	// @ApiModelProperty(value="病人性质")
	/** 病人性质 */
	private Integer brxz;
	// @ApiModelProperty(value="机构ID")
	/** 机构ID */
	private Integer jgid;
	// @ApiModelProperty(value="收费金额")
	/** 收费金额 */
	private BigDecimal sfje;
	// @ApiModelProperty(value="发票张数")
	/** 发票张数 */
	private Integer fpzs;
	// @ApiModelProperty(value="mzlb")
	/** mzlb */
	private Integer mzlb;

	/** 设置:操作工号 */
	public void setCzgh(String value) {
		this.czgh = value;
	}

	/** 获取:操作工号 */
	public String getCzgh() {
		return czgh;
	}

	/** 设置:结帐日期 */
	public void setJzrq(Timestamp value) {
		this.jzrq = value;
	}

	/** 获取:结帐日期 */
	public Timestamp getJzrq() {
		return jzrq;
	}

	/** 设置:病人性质 */
	public void setBrxz(Integer value) {
		this.brxz = value;
	}

	/** 获取:病人性质 */
	public Integer getBrxz() {
		return brxz;
	}

	/** 设置:机构ID */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/** 获取:机构ID */
	public Integer getJgid() {
		return jgid;
	}

	/** 设置:收费金额 */
	public void setSfje(BigDecimal value) {
		this.sfje = value;
	}

	/** 获取:收费金额 */
	public BigDecimal getSfje() {
		return sfje;
	}

	/** 设置:发票张数 */
	public void setFpzs(Integer value) {
		this.fpzs = value;
	}

	/** 获取:发票张数 */
	public Integer getFpzs() {
		return fpzs;
	}

	/** 设置:mzlb */
	public void setMzlb(Integer value) {
		this.mzlb = value;
	}

	/** 获取:mzlb */
	public Integer getMzlb() {
		return mzlb;
	}

}
