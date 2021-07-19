
package com.buit.commons.response;

import java.sql.Date;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryAllPsDjCountResp<br>
 * 类描述：皮试工作量统计人次返回"<br>
 * 
 * @author WY
 */
@ApiModel(value = "皮试工作量统计人次返回")
public class QueryAllPsDjCountResp extends PageQuery {
	@ApiModelProperty(value = "皮试日期")
	private Date psrq;
	@ApiModelProperty(value = "人次")
	private Integer count;

	public Date getPsrq() {
		return psrq;
	}

	public void setPsrq(Date psrq) {
		this.psrq = psrq;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}