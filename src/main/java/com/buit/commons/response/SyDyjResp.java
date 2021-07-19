
package com.buit.commons.response;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SyDyj<br>
 * 类描述：打印机<br>
 * 
 * @author WY
 */
@ApiModel(value = "打印机")
public class SyDyjResp extends PageQuery {
	private static final long serialVersionUID = 7455209463022777347L;
	@JsonIgnore
	@ApiModelProperty(value = "医疗机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "输液科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "瓶贴打印机")
	private String ptdyj;
	@ApiModelProperty(value = "巡回单打印机")
	private String xhddyj;

	/**
	 * 设置:医疗机构代码
	 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/**
	 * 获取:医疗机构代码
	 */
	public Integer getJgid() {
		return jgid;
	}

	/**
	 * 设置:输液科室代码
	 */
	public void setKsdm(Integer value) {
		this.ksdm = value;
	}

	/**
	 * 获取:输液科室代码
	 */
	public Integer getKsdm() {
		return ksdm;
	}

	/**
	 * 设置:瓶贴打印机
	 */
	public void setPtdyj(String value) {
		this.ptdyj = value;
	}

	/**
	 * 获取:瓶贴打印机
	 */
	public String getPtdyj() {
		return ptdyj;
	}

	/**
	 * 设置:巡回单打印机
	 */
	public void setXhddyj(String value) {
		this.xhddyj = value;
	}

	/**
	 * 获取:巡回单打印机
	 */
	public String getXhddyj() {
		return xhddyj;
	}
}