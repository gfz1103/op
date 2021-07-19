
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：CfInfoResp<br>
 * 类描述：处方信息<br>
 * 
 * @author WY
 */
@ApiModel(value = "处方信息")
public class CfInfoResp extends PageQuery {
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