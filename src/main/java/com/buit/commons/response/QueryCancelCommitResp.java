
package com.buit.commons.response;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryCancelCommitResp<br>
 * 类描述：取消结账返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "取消结账返回")
public class QueryCancelCommitResp {
	@ApiModelProperty(value = "结账日期")
	private Date jzrq;
	@ApiModelProperty(value = "操作工号")
	private Integer czgh;
	@ApiModelProperty(value = "汇总日期")
	private Date hzrq;

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

}