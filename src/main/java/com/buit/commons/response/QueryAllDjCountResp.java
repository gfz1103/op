
package com.buit.commons.response;

import java.sql.Date;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryAllDjCountResp<br>
 * 类描述：输液注射工作量统计人次返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "输液注射工作量统计人次返回")
public class QueryAllDjCountResp extends PageQuery {
	@ApiModelProperty(value = "输液/注射日期")
	private Date syrq;
	@ApiModelProperty(value = "人次")
	private Integer count;

	public Date getSyrq() {
		return syrq;
	}

	public void setSyrq(Date syrq) {
		this.syrq = syrq;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}