
package com.buit.commons.request;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：GHDetailsReq<br>
 * 类描述：挂号详细信息请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "挂号详细信息请求")
public class GhDetailsReq{
	@ApiModelProperty(value = "挂号费用")
	private BigDecimal ghfy;
	@ApiModelProperty(value = "挂号金额")
	private BigDecimal ghje;
	@ApiModelProperty(value = "诊疗金额")
	private BigDecimal zlje;
	@ApiModelProperty(value = "病例金额")
	private BigDecimal blje;
	@ApiModelProperty(value = "专家费用")
	private BigDecimal zjfy;
	@ApiModelProperty(value = "识别序号")
	private Integer sbxh;

	public BigDecimal getGhfy() {
		return ghfy;
	}

	public void setGhfy(BigDecimal ghfy) {
		this.ghfy = ghfy;
	}

	public BigDecimal getGhje() {
		return ghje;
	}

	public void setGhje(BigDecimal ghje) {
		this.ghje = ghje;
	}

	public BigDecimal getZlje() {
		return zlje;
	}

	public void setZlje(BigDecimal zlje) {
		this.zlje = zlje;
	}

	public BigDecimal getBlje() {
		return blje;
	}

	public void setBlje(BigDecimal blje) {
		this.blje = blje;
	}

	public BigDecimal getZjfy() {
		return zjfy;
	}

	public void setZjfy(BigDecimal zjfy) {
		this.zjfy = zjfy;
	}

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

}