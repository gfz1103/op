package com.buit.commons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：OpRbmx<br>
 * 类描述：门诊_收费日报明细
 * 
 * @author WY @ApiModel(value="门诊_收费日报明细")
 */
public class OpRbmx extends PageQuery {
	// @ApiModelProperty(value="操作工号 | 操作工号+结帐日期+收费项目通过CZGH+JZRQ和OP_HZRB关联
	// 收费项目和DIC_SFXMLB中SFXM关联")
	/** 操作工号 | 操作工号+结帐日期+收费项目通过CZGH+JZRQ和OP_HZRB关联 收费项目和DIC_SFXMLB中SFXM关联 */
	private String czgh;
	// @ApiModelProperty(value="结帐日期")
	/** 结帐日期 */
	private String rbid;
	private Timestamp jzrq;
	// @ApiModelProperty(value="收费项目")
	/** 收费项目 */
	private Integer sfxm;
	private String sfmc;
	// @ApiModelProperty(value="机构ID")
	/** 机构ID */
	private Integer jgid;
	// @ApiModelProperty(value="收费金额")
	/** 收费金额 */
	private BigDecimal sfje;
	private BigDecimal zjje;
	private BigDecimal zkje;
	private BigDecimal sjje;
	private Timestamp jzksrq;
	// @ApiModelProperty(value="mzlb")
	/** mzlb */
	private Integer mzlb;

	/** 设置:操作工号 | 操作工号+结帐日期+收费项目通过CZGH+JZRQ和OP_HZRB关联 收费项目和DIC_SFXMLB中SFXM关联 */
	public void setCzgh(String value) {
		this.czgh = value;
	}

	/** 获取:操作工号 | 操作工号+结帐日期+收费项目通过CZGH+JZRQ和OP_HZRB关联 收费项目和DIC_SFXMLB中SFXM关联 */
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

	/** 设置:收费项目 */
	public void setSfxm(Integer value) {
		this.sfxm = value;
	}

	/** 获取:收费项目 */
	public Integer getSfxm() {
		return sfxm;
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

	/** 设置:mzlb */
	public void setMzlb(Integer value) {
		this.mzlb = value;
	}

	/** 获取:mzlb */
	public Integer getMzlb() {
		return mzlb;
	}

	public String getRbid() {
		return rbid;
	}

	public void setRbid(String rbid) {
		this.rbid = rbid;
	}

	public String getSfmc() {
		return sfmc;
	}

	public void setSfmc(String sfmc) {
		this.sfmc = sfmc;
	}

	public BigDecimal getZjje() {
		return zjje;
	}

	public void setZjje(BigDecimal zjje) {
		this.zjje = zjje;
	}

	public BigDecimal getZkje() {
		return zkje;
	}

	public void setZkje(BigDecimal zkje) {
		this.zkje = zkje;
	}

	public BigDecimal getSjje() {
		return sjje;
	}

	public void setSjje(BigDecimal sjje) {
		this.sjje = sjje;
	}

	public Timestamp getJzksrq() {
		return jzksrq;
	}

	public void setJzksrq(Timestamp jzksrq) {
		this.jzksrq = jzksrq;
	}
}
