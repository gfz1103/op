
package com.buit.commons.request;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryDjmxReq<br>
 * 类描述：<br>
 * 
 * @author WY
 */
@ApiModel(value = "查询登记明细请求")
public class QueryDjmxReq extends PageQuery {
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "皮试科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "登记单号")
	private String djdh;

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
	 * 设置:皮试科室代码
	 */
	public void setKsdm(Integer value) {
		this.ksdm = value;
	}

	/**
	 * 获取:皮试科室代码
	 */
	public Integer getKsdm() {
		return ksdm;
	}

	/**
	 * 设置:登记单号
	 */
	public void setDjdh(String value) {
		this.djdh = value;
	}

	/**
	 * 获取:登记单号
	 */
	public String getDjdh() {
		return djdh;
	}

}