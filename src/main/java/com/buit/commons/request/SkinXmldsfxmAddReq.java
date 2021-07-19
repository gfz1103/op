package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SkinXmldsfxm<br>
 * 类描述：<br>
 * 
 * @author WY
 */
@ApiModel(value = "项目联动收费新增请求")
public class SkinXmldsfxmAddReq extends PageQuery {
	private static final long serialVersionUID = 4325297431009745468L;
	@JsonIgnore
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

	public Integer getXmlx() {
		return xmlx;
	}

	public void setXmlx(Integer xmlx) {
		this.xmlx = xmlx;
	}

}
