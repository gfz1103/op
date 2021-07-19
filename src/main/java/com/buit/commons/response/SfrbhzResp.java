
package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 类名称：SfrbResp<br>
 * 类描述：收费日报汇总查询返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "收费日报汇总查询返回")
public class SfrbhzResp {
	@ApiModelProperty(value = "汇总日期")
	private Date hzrq;
	@ApiModelProperty(value = "汇总开始日期")
	private Date hzksrq;
	@ApiModelProperty(value = "汇总结束日期")
	private Date hzjsrq;
	@ApiModelProperty(value = "操作工号")
	private Integer czgh;


	public Date getHzrq() {
		return hzrq;
	}

	public void setHzrq(Date hzrq) {
		this.hzrq = hzrq;
	}

	public Integer getCzgh() {
		return czgh;
	}

	public void setCzgh(Integer czgh) {
		this.czgh = czgh;
	}

	public Date getHzksrq() {
		return hzksrq;
	}

	public void setHzksrq(Date hzksrq) {
		this.hzksrq = hzksrq;
	}

	public Date getHzjsrq() {
		return hzjsrq;
	}

	public void setHzjsrq(Date hzjsrq) {
		this.hzjsrq = hzjsrq;
	}
}