package com.buit.commons.response;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SkinXm<br>
 * 类描述：<br>
 * 
 * @author WY
 */
@ApiModel(value = "皮试列表返回")
public class SkinXmResp extends PageQuery {
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "皮试ID")
	private Integer psid;
	@ApiModelProperty(value = "皮试项目名称")
	private String psmc;
	@ApiModelProperty(value = "皮试时长(分钟)")
	private Integer pssc;
	@ApiModelProperty(value = "皮试类型:1:领药前皮试  2: 领药后皮试")
	private String pslx;
	@ApiModelProperty(value = "状态 0：启用  1：停用")
	private String zt;
	@ApiModelProperty(value = "拼音码")
	private String pydm;
	@ApiModelProperty(value = "五笔码")
	private String wbdm;
	@ApiModelProperty(value = "单位")
	private String dw;

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
	 * 设置:皮试项目名称
	 */
	public void setPsmc(String value) {
		this.psmc = value;
	}

	/**
	 * 获取:皮试项目名称
	 */
	public String getPsmc() {
		return psmc;
	}

	/**
	 * 设置:皮试时长(分钟)
	 */
	public void setPssc(Integer value) {
		this.pssc = value;
	}

	/**
	 * 获取:皮试时长(分钟)
	 */
	public Integer getPssc() {
		return pssc;
	}

	/**
	 * 设置:皮试类型:1:领药前皮试 2: 领药后皮试
	 */
	public void setPslx(String value) {
		this.pslx = value;
	}

	/**
	 * 获取:皮试类型:1:领药前皮试 2: 领药后皮试
	 */
	public String getPslx() {
		return pslx;
	}

	/**
	 * 设置:状态 0：启用 1：停用
	 */
	public void setZt(String value) {
		this.zt = value;
	}

	/**
	 * 获取:状态 0：启用 1：停用
	 */
	public String getZt() {
		return zt;
	}

	/**
	 * 设置:拼音码
	 */
	public void setPydm(String value) {
		this.pydm = value;
	}

	/**
	 * 获取:拼音码
	 */
	public String getPydm() {
		return pydm;
	}

	/**
	 * 设置:五笔码
	 */
	public void setWbdm(String value) {
		this.wbdm = value;
	}

	/**
	 * 获取:五笔码
	 */
	public String getWbdm() {
		return wbdm;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

}
