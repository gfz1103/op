package com.buit.commons.model;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SyKs<br>
 * 类描述：输液/注射科室设置
 * 
 * @author WY @ApiModel(value="输液/注射科室设置")
 */
public class SyKs extends PageQuery {
	// @ApiModelProperty(value="医疗机构代码")
	/** 医疗机构代码 */
	private Integer jgid;
	// @ApiModelProperty(value="输液科室代码")
	/** 输液科室代码 */
	private Integer ksdm;
	// @ApiModelProperty(value="科室类别 1输液室/2注射室")
	/** 科室类别 1输液室/2注射室 */
	private String kslb;
	// @ApiModelProperty(value="条码生成规则 : 1.年+顺序号 2.年+月+顺序号 3.年+月+日+顺序号 4.前缀+顺序号")
	/** 条码生成规则 : 1.年+顺序号 2.年+月+顺序号 3.年+月+日+顺序号 4.前缀+顺序号 */
	private String tmscgz;
	// @ApiModelProperty(value="前缀")
	/** 前缀 */
	private String qz;
	// @ApiModelProperty(value="顺序号位数")
	/** 顺序号位数 */
	private Integer sxhws;
	// @ApiModelProperty(value="下一顺序号")
	/** 下一顺序号 */
	private String xysxh;
	@ApiModelProperty(value = "状态 0:启用  1:停用")
	private String zt;

	/** 设置:医疗机构代码 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/** 获取:医疗机构代码 */
	public Integer getJgid() {
		return jgid;
	}

	/** 设置:输液科室代码 */
	public void setKsdm(Integer value) {
		this.ksdm = value;
	}

	/** 获取:输液科室代码 */
	public Integer getKsdm() {
		return ksdm;
	}

	/** 设置:科室类别 1输液室/2注射室 */
	public void setKslb(String value) {
		this.kslb = value;
	}

	/** 获取:科室类别 1输液室/2注射室 */
	public String getKslb() {
		return kslb;
	}

	/** 设置:条码生成规则 : 1.年+顺序号 2.年+月+顺序号 3.年+月+日+顺序号 4.前缀+顺序号 */
	public void setTmscgz(String value) {
		this.tmscgz = value;
	}

	/** 获取:条码生成规则 : 1.年+顺序号 2.年+月+顺序号 3.年+月+日+顺序号 4.前缀+顺序号 */
	public String getTmscgz() {
		return tmscgz;
	}

	/** 设置:前缀 */
	public void setQz(String value) {
		this.qz = value;
	}

	/** 获取:前缀 */
	public String getQz() {
		return qz;
	}

	/** 设置:顺序号位数 */
	public void setSxhws(Integer value) {
		this.sxhws = value;
	}

	/** 获取:顺序号位数 */
	public Integer getSxhws() {
		return sxhws;
	}

	public String getXysxh() {
		return xysxh;
	}

	public void setXysxh(String xysxh) {
		this.xysxh = xysxh;
	}

	/** 设置:状态 0停用/1启用 */
	public void setZt(String value) {
		this.zt = value;
	}

	/** 获取:状态 0停用/1启用 */
	public String getZt() {
		return zt;
	}

}