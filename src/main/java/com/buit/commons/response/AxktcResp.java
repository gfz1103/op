
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：AxktcResp<br>
 * 类描述：查询爱心卡套餐返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "查询爱心卡套餐返回")
public class AxktcResp extends PageQuery {
	@ApiModelProperty(value = "爱心卡类型")
	private String lx;
	@ApiModelProperty(value = "套餐编码")
	private String tcbm;

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public String getTcbm() {
		return tcbm;
	}

	public void setTcbm(String tcbm) {
		this.tcbm = tcbm;
	}

}