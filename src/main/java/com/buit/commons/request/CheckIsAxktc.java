
package com.buit.commons.request;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：CheckIsAxktc<br>
 * 类描述：检查是否是爱心卡套餐<br>
 * 
 * @author WY
 */
@ApiModel(value = "检查是否是爱心卡套餐")
public class CheckIsAxktc extends PageQuery {
	@ApiModelProperty(value = "套餐编号")
	private String tcbh;
	@ApiModelProperty(value = "医技序号")
	private Integer yjxh;
	@ApiModelProperty(value = "处方识别")
	private Integer cfsb;

	public String getTcbh() {
		return tcbh;
	}

	public void setTcbh(String tcbh) {
		this.tcbh = tcbh;
	}

	public Integer getYjxh() {
		return yjxh;
	}

	public void setYjxh(Integer yjxh) {
		this.yjxh = yjxh;
	}

	public Integer getCfsb() {
		return cfsb;
	}

	public void setCfsb(Integer cfsb) {
		this.cfsb = cfsb;
	}

}