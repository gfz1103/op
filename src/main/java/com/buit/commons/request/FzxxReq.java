
package com.buit.commons.request;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：FzxxReq<br>
 * 类描述：退费处方请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "退费处方请求")
public class FzxxReq extends PageQuery {
	@ApiModelProperty(value = "处方识别")
	private Integer cfsb;
	@ApiModelProperty(value = "处方类型| 1:西药处方 2：中药处方 3：草药处方")
	private Integer cflx;

	public Integer getCfsb() {
		return cfsb;
	}

	public void setCfsb(Integer cfsb) {
		this.cfsb = cfsb;
	}

	public Integer getCflx() {
		return cflx;
	}

	public void setCflx(Integer cflx) {
		this.cflx = cflx;
	}

}