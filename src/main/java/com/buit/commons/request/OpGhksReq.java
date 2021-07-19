
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpGhks<br>
 * 类描述：门诊_挂号科室<br>
 * 
 * @author WY
 */
@ApiModel(value = "门诊_挂号科室")
public class OpGhksReq extends PageQuery {
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "拼音代码")
	private String pydm;

	/**
	 * 设置:机构代码
	 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/**
	 * 获取:机构代码
	 */
	public Integer getJgid() {
		return jgid;
	}

	/**
	 * 设置:拼音代码
	 */
	public void setPydm(String value) {
		this.pydm = value;
	}

	/**
	 * 获取:拼音代码
	 */
	public String getPydm() {
		return pydm;
	}

}
