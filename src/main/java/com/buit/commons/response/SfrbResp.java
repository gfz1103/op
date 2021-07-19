
package com.buit.commons.response;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SfrbResp<br>
 * 类描述：收费日报查询返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "收费日报查询返回")
public class SfrbResp {
	@ApiModelProperty(value = "结账日期")
	private Date jzrq;
	@ApiModelProperty(value = "结账开始日期")
	private Date jzksrq;
	@ApiModelProperty(value = "操作工号")
	private Integer czgh;
	@ApiModelProperty(value = "汇总日期")
	private Date hzrq;
	@ApiModelProperty(value = "日报id")
	private String rbid;

	public Date getJzrq() {
		return jzrq;
	}

	public void setJzrq(Date jzrq) {
		this.jzrq = jzrq;
	}

	public Integer getCzgh() {
		return czgh;
	}

	public void setCzgh(Integer czgh) {
		this.czgh = czgh;
	}

	public Date getHzrq() {
		return hzrq;
	}

	public void setHzrq(Date hzrq) {
		this.hzrq = hzrq;
	}

	public String getRbid() {
		return rbid;
	}

	public void setRbid(String rbid) {
		this.rbid = rbid;
	}

	public Date getJzksrq() {
		return jzksrq;
	}

	public void setJzksrq(Date jzksrq) {
		this.jzksrq = jzksrq;
	}
}