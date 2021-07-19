
package com.buit.commons.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SyGytj<br>
 * 类描述：输液/注射给药途径设置<br>
 * 
 * @author WY
 */
@ApiModel(value = "输液/注射给药途径设置")
public class SyGytjReq {
	@ApiModelProperty(value = "医疗机构代码")
	@JsonIgnore
	private Integer jgid;
	@ApiModelProperty(value = "输液科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "给药途径代码")
	private String gytjdm;
	@NotBlank(message = "科室类别不能为空")
	@ApiModelProperty(value = "科室类别  1输液室/2注射室")
	private String kslb;
	@ApiModelProperty(value = "拼音代码")
	private String pydm;

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
	 * 设置:给药途径代码
	 */
	public void setGytjdm(String value) {
		this.gytjdm = value;
	}

	/**
	 * 获取:给药途径代码
	 */
	public String getGytjdm() {
		return gytjdm;
	}

	/**
	 * 设置:科室类别 1输液室/2注射室
	 */
	public void setKslb(String value) {
		this.kslb = value;
	}

	/**
	 * 获取:科室类别 1输液室/2注射室
	 */
	public String getKslb() {
		return kslb;
	}

	public String getPydm() {
		return pydm;
	}

	public void setPydm(String pydm) {
		this.pydm = pydm;
	}

}