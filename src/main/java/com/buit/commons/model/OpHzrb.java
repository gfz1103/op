package com.buit.commons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：OpHzrb<br>
 * 类描述：门诊_门诊收费日报
 * 
 * @author WY @ApiModel(value="门诊_门诊收费日报")
 */
public class OpHzrb extends PageQuery {
	// @ApiModelProperty(value="操作工号 | 操作工号+结帐日期 门诊收费个人日结时在该表中增加一条记录")
	/** 操作工号 | 操作工号+结帐日期 门诊收费个人日结时在该表中增加一条记录 */
	private String czgh;
	// @ApiModelProperty(value="结帐日期")
	/** 结帐日期 */
	private Timestamp jzrq;
	// @ApiModelProperty(value="机构ID")
	/** 机构ID */
	private Integer jgid;
	// @ApiModelProperty(value="起止票据")
	/** 起止票据 */
	private String qzpj;
	// @ApiModelProperty(value="总计金额")
	/** 总计金额 */
	private BigDecimal zjje;
	// @ApiModelProperty(value="现金金额 |
	// 现金金额、支票金额、帐户自负(帐户金额)、其它应收、货币误差从OP_MZXX的XJJE,ZPJE,ZHJE,QTYS,HBWC中合计得到")
	/**
	 * 现金金额 | 现金金额、支票金额、帐户自负(帐户金额)、其它应收、货币误差从OP_MZXX的XJJE,ZPJE,ZHJE,QTYS,HBWC中合计得到
	 */
	private BigDecimal xjje;
	// @ApiModelProperty(value="支票金额")
	/** 支票金额 */
	private BigDecimal zpje;
	// @ApiModelProperty(value="帐户支付")
	/** 帐户支付 */
	private BigDecimal zfzf;
	// @ApiModelProperty(value="其他应收")
	/** 其他应收 */
	private BigDecimal qtys;
	// @ApiModelProperty(value="货币误差")
	/** 货币误差 */
	private BigDecimal hbwc;
	// @ApiModelProperty(value="汇总日期")
	/** 汇总日期 */
	private Timestamp hzrq;
	// @ApiModelProperty(value="发票张数")
	/** 发票张数 */
	private Integer fpzs;
	// @ApiModelProperty(value="门诊类别")
	/** 门诊类别 */
	private Integer mzlb;
	// @ApiModelProperty(value="作废发票")
	/** 作废发票 */
	private String zffp;
	// @ApiModelProperty(value="作废金额")
	/** 作废金额 */
	private BigDecimal zfje;
	// @ApiModelProperty(value="作废张数")
	/** 作废张数 */
	private Integer zfzs;
	// @ApiModelProperty(value="jjzfje")
	/** jjzfje */
	private BigDecimal jjzfje;
	// @ApiModelProperty(value="tczc")
	/** tczc */
	private BigDecimal tczc;
	// @ApiModelProperty(value="bczhzf")
	/** bczhzf */
	private BigDecimal bczhzf;
	// @ApiModelProperty(value="dbzc")
	/** dbzc */
	private BigDecimal dbzc;
	// @ApiModelProperty(value="zxjzfy")
	/** zxjzfy */
	private BigDecimal zxjzfy;
	// @ApiModelProperty(value="grxjzf")
	/** grxjzf */
	private BigDecimal grxjzf;
	// @ApiModelProperty(value="azqgfy")
	/** azqgfy */
	private BigDecimal azqgfy;
	// @ApiModelProperty(value="各种收费类型统计")
	/** 各种收费类型统计 */
	private String ysqtfb;
	// @ApiModelProperty(value="wszf")
	/** wszf */
	private BigDecimal wszf;
	// @ApiModelProperty(value="posje")
	/** posje */
	private BigDecimal posje;
	// @ApiModelProperty(value="家床金额")
	/** 家床金额 */
	private BigDecimal jcje;
	// @ApiModelProperty(value="家床退缴款金额")
	/** 家床退缴款金额 */
	private BigDecimal jctjkje;
	// @ApiModelProperty(value="转科发票张数")
	/** 转科发票张数 */
	private Integer zkzs;
	// @ApiModelProperty(value="转科发票")
	/** 转科发票 */
	private String zkfp;

	/** 设置:操作工号 | 操作工号+结帐日期 门诊收费个人日结时在该表中增加一条记录 */
	public void setCzgh(String value) {
		this.czgh = value;
	}

	/** 获取:操作工号 | 操作工号+结帐日期 门诊收费个人日结时在该表中增加一条记录 */
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

	/** 设置:机构ID */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/** 获取:机构ID */
	public Integer getJgid() {
		return jgid;
	}

	/** 设置:起止票据 */
	public void setQzpj(String value) {
		this.qzpj = value;
	}

	/** 获取:起止票据 */
	public String getQzpj() {
		return qzpj;
	}

	/** 设置:总计金额 */
	public void setZjje(BigDecimal value) {
		this.zjje = value;
	}

	/** 获取:总计金额 */
	public BigDecimal getZjje() {
		return zjje;
	}

	/**
	 * 设置:现金金额 |
	 * 现金金额、支票金额、帐户自负(帐户金额)、其它应收、货币误差从OP_MZXX的XJJE,ZPJE,ZHJE,QTYS,HBWC中合计得到
	 */
	public void setXjje(BigDecimal value) {
		this.xjje = value;
	}

	/**
	 * 获取:现金金额 |
	 * 现金金额、支票金额、帐户自负(帐户金额)、其它应收、货币误差从OP_MZXX的XJJE,ZPJE,ZHJE,QTYS,HBWC中合计得到
	 */
	public BigDecimal getXjje() {
		return xjje;
	}

	/** 设置:支票金额 */
	public void setZpje(BigDecimal value) {
		this.zpje = value;
	}

	/** 获取:支票金额 */
	public BigDecimal getZpje() {
		return zpje;
	}

	/** 设置:帐户支付 */
	public void setZfzf(BigDecimal value) {
		this.zfzf = value;
	}

	/** 获取:帐户支付 */
	public BigDecimal getZfzf() {
		return zfzf;
	}

	/** 设置:其他应收 */
	public void setQtys(BigDecimal value) {
		this.qtys = value;
	}

	/** 获取:其他应收 */
	public BigDecimal getQtys() {
		return qtys;
	}

	/** 设置:货币误差 */
	public void setHbwc(BigDecimal value) {
		this.hbwc = value;
	}

	/** 获取:货币误差 */
	public BigDecimal getHbwc() {
		return hbwc;
	}

	/** 设置:汇总日期 */
	public void setHzrq(Timestamp value) {
		this.hzrq = value;
	}

	/** 获取:汇总日期 */
	public Timestamp getHzrq() {
		return hzrq;
	}

	/** 设置:发票张数 */
	public void setFpzs(Integer value) {
		this.fpzs = value;
	}

	/** 获取:发票张数 */
	public Integer getFpzs() {
		return fpzs;
	}

	/** 设置:门诊类别 */
	public void setMzlb(Integer value) {
		this.mzlb = value;
	}

	/** 获取:门诊类别 */
	public Integer getMzlb() {
		return mzlb;
	}

	/** 设置:作废发票 */
	public void setZffp(String value) {
		this.zffp = value;
	}

	/** 获取:作废发票 */
	public String getZffp() {
		return zffp;
	}

	/** 设置:作废金额 */
	public void setZfje(BigDecimal value) {
		this.zfje = value;
	}

	/** 获取:作废金额 */
	public BigDecimal getZfje() {
		return zfje;
	}

	/** 设置:作废张数 */
	public void setZfzs(Integer value) {
		this.zfzs = value;
	}

	/** 获取:作废张数 */
	public Integer getZfzs() {
		return zfzs;
	}

	/** 设置:jjzfje */
	public void setJjzfje(BigDecimal value) {
		this.jjzfje = value;
	}

	/** 获取:jjzfje */
	public BigDecimal getJjzfje() {
		return jjzfje;
	}

	/** 设置:tczc */
	public void setTczc(BigDecimal value) {
		this.tczc = value;
	}

	/** 获取:tczc */
	public BigDecimal getTczc() {
		return tczc;
	}

	/** 设置:bczhzf */
	public void setBczhzf(BigDecimal value) {
		this.bczhzf = value;
	}

	/** 获取:bczhzf */
	public BigDecimal getBczhzf() {
		return bczhzf;
	}

	/** 设置:dbzc */
	public void setDbzc(BigDecimal value) {
		this.dbzc = value;
	}

	/** 获取:dbzc */
	public BigDecimal getDbzc() {
		return dbzc;
	}

	/** 设置:zxjzfy */
	public void setZxjzfy(BigDecimal value) {
		this.zxjzfy = value;
	}

	/** 获取:zxjzfy */
	public BigDecimal getZxjzfy() {
		return zxjzfy;
	}

	/** 设置:grxjzf */
	public void setGrxjzf(BigDecimal value) {
		this.grxjzf = value;
	}

	/** 获取:grxjzf */
	public BigDecimal getGrxjzf() {
		return grxjzf;
	}

	/** 设置:azqgfy */
	public void setAzqgfy(BigDecimal value) {
		this.azqgfy = value;
	}

	/** 获取:azqgfy */
	public BigDecimal getAzqgfy() {
		return azqgfy;
	}

	/** 设置:各种收费类型统计 */
	public void setYsqtfb(String value) {
		this.ysqtfb = value;
	}

	/** 获取:各种收费类型统计 */
	public String getYsqtfb() {
		return ysqtfb;
	}

	/** 设置:wszf */
	public void setWszf(BigDecimal value) {
		this.wszf = value;
	}

	/** 获取:wszf */
	public BigDecimal getWszf() {
		return wszf;
	}

	/** 设置:posje */
	public void setPosje(BigDecimal value) {
		this.posje = value;
	}

	/** 获取:posje */
	public BigDecimal getPosje() {
		return posje;
	}

	/** 设置:家床金额 */
	public void setJcje(BigDecimal value) {
		this.jcje = value;
	}

	/** 获取:家床金额 */
	public BigDecimal getJcje() {
		return jcje;
	}

	/** 设置:家床退缴款金额 */
	public void setJctjkje(BigDecimal value) {
		this.jctjkje = value;
	}

	/** 获取:家床退缴款金额 */
	public BigDecimal getJctjkje() {
		return jctjkje;
	}

	/** 设置:转科发票张数 */
	public void setZkzs(Integer value) {
		this.zkzs = value;
	}

	/** 获取:转科发票张数 */
	public Integer getZkzs() {
		return zkzs;
	}

	/** 设置:转科发票 */
	public void setZkfp(String value) {
		this.zkfp = value;
	}

	/** 获取:转科发票 */
	public String getZkfp() {
		return zkfp;
	}

}
