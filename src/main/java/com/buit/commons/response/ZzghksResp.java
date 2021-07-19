
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：ZzghksResp<br>
 * 类描述：自助挂号科室返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "自助挂号科室返回")
public class ZzghksResp extends PageQuery {
	@ApiModelProperty(value = "病人ID")
	private Integer brid;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "识别序号")
	private Integer sbxh;
	@ApiModelProperty(value = "挂号费")
	private BigDecimal ghf;
	@ApiModelProperty(value = "挂号费")
	private BigDecimal zlf;
	@ApiModelProperty(value = "专家费用")
	private BigDecimal zjfy;
	@ApiModelProperty(value = "病历金额")
	private BigDecimal blje;

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

	public BigDecimal getGhf() {
		return ghf;
	}

	public void setGhf(BigDecimal ghf) {
		this.ghf = ghf;
	}

	public BigDecimal getZlf() {
		return zlf;
	}

	public void setZlf(BigDecimal zlf) {
		this.zlf = zlf;
	}

	public BigDecimal getZjfy() {
		return zjfy;
	}

	public void setZjfy(BigDecimal zjfy) {
		this.zjfy = zjfy;
	}

	public BigDecimal getBlje() {
		return blje;
	}

	public void setBlje(BigDecimal blje) {
		this.blje = blje;
	}

}