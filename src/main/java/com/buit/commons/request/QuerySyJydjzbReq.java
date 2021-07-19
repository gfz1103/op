
package com.buit.commons.request;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SyJydjzb<br>
 * 类描述：分页查询输液/注射接药登记主表<br>
 * 
 * @author WY
 */
@ApiModel(value = "分页查询输液/注射接药登记主表请求")
public class QuerySyJydjzbReq extends PageQuery {
	private static final long serialVersionUID = -3362797509834862903L;
	@JsonIgnore
	@ApiModelProperty(value = "医疗机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "输液科室代码 ")
	private Integer ksdm;
	@ApiModelProperty(value = "状态 1 输液/注射中/2 输液/注射完成")
	private String zt;
	@NotBlank(message = "科室类别不能为空")
	@ApiModelProperty(value = "科室类别 : 1:输液室  2:注射室")
	private String kslb;

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getKslb() {
		return kslb;
	}

	public void setKslb(String kslb) {
		this.kslb = kslb;
	}

}