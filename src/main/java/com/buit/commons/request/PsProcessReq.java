
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：PsProcessReq<br>
 * 类描述：<br>
 * 
 * @author WY
 */
@ApiModel(value = "开始皮试请求")
public class PsProcessReq extends PageQuery {
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "注射科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "登记单号")
	private String djdh;
	@ApiModelProperty(value = "皮试结果  3阳 2阴")
	private Integer psjg;
	@ApiModelProperty(value = "填写人代码")
	private Integer txrdm;

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

	public String getDjdh() {
		return djdh;
	}

	public void setDjdh(String djdh) {
		this.djdh = djdh;
	}

	public Integer getPsjg() {
		return psjg;
	}

	public void setPsjg(Integer psjg) {
		this.psjg = psjg;
	}

	public Integer getTxrdm() {
		return txrdm;
	}

	public void setTxrdm(Integer txrdm) {
		this.txrdm = txrdm;
	}

}