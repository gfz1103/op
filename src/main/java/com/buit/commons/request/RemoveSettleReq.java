
package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 类名称：RemoveSettleReq<br>
 * 类描述：收费计算删除数据请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "收费计算删除数据请求")
public class RemoveSettleReq implements Serializable {
	@ApiModelProperty(value = "处方类型")
	private Integer cflx;
	@ApiModelProperty(value = "处方识别")
	private Integer cfsb;
	@ApiModelProperty(value = "识别序号")
	private Integer sbxh;

	public Integer getCflx() {
		return cflx;
	}

	public void setCflx(Integer cflx) {
		this.cflx = cflx;
	}

	public Integer getCfsb() {
		return cfsb;
	}

	public void setCfsb(Integer cfsb) {
		this.cfsb = cfsb;
	}

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

}