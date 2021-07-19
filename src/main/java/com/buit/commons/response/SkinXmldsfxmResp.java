package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SkinXmldsfxm<br>
 * 类描述：<br>
 * 
 * @author WY
 */
@ApiModel(value = "项目联动收费返回")
public class SkinXmldsfxmResp extends PageQuery {
	private static final long serialVersionUID = -1615410835010496073L;
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "皮试ID")
	private Integer psid;
	@ApiModelProperty(value = "收费项目代码")
	private Integer sfxmdm;
	@ApiModelProperty(value = "序号")
	private Integer xh;
	@ApiModelProperty(value = "数量")
	private Integer sl;
	@ApiModelProperty(value = "名称")
	private String ypmc;
	@ApiModelProperty(value = "规格")
	private String ypgg;
	@ApiModelProperty(value = "单位")
	private String ypdw;
	@ApiModelProperty(value = "药价")
	private BigDecimal ypdj;
	@ApiModelProperty(value = "项目类型：1：药品  2：项目  3：材料")
	private Integer xmlx;

	/**
	 * 设置:机构ID
	 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/**
	 * 获取:机构ID
	 */
	public Integer getJgid() {
		return jgid;
	}

	/**
	 * 设置:皮试ID
	 */
	public void setPsid(Integer value) {
		this.psid = value;
	}

	/**
	 * 获取:皮试ID
	 */
	public Integer getPsid() {
		return psid;
	}

	/**
	 * 设置:收费项目代码
	 */
	public void setSfxmdm(Integer value) {
		this.sfxmdm = value;
	}

	/**
	 * 获取:收费项目代码
	 */
	public Integer getSfxmdm() {
		return sfxmdm;
	}

	/**
	 * 设置:序号
	 */
	public void setXh(Integer value) {
		this.xh = value;
	}

	/**
	 * 获取:序号
	 */
	public Integer getXh() {
		return xh;
	}

	/**
	 * 设置:数量
	 */
	public void setSl(Integer value) {
		this.sl = value;
	}

	/**
	 * 获取:数量
	 */
	public Integer getSl() {
		return sl;
	}

	public String getYpgg() {
		return ypgg;
	}

	public void setYpgg(String ypgg) {
		this.ypgg = ypgg;
	}

	public String getYpdw() {
		return ypdw;
	}

	public void setYpdw(String ypdw) {
		this.ypdw = ypdw;
	}

	public BigDecimal getYpdj() {
		return ypdj;
	}

	public void setYpdj(BigDecimal ypdj) {
		this.ypdj = ypdj;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	public Integer getXmlx() {
		return xmlx;
	}

	public void setXmlx(Integer xmlx) {
		this.xmlx = xmlx;
	}

}
