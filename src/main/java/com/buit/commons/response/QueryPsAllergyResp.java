
package com.buit.commons.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryPsAllergyResp<br>
 * 类描述：皮试阳性率统计返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "皮试阳性率统计返回")
public class QueryPsAllergyResp {
	@ApiModelProperty(value = "皮试项目ID")
	private Integer psid;
	@ApiModelProperty(value = "皮试项目名称")
	private String psmc;
	@ApiModelProperty(value = "总人数")
	private Integer count;
	@ApiModelProperty(value = "阳性人数")
	private Integer yxCount;
	@ApiModelProperty(value = "阴性人数")
	private Integer yyxCount;
	@ApiModelProperty(value = "阳性率")
	private String yxRate;

	public Integer getPsid() {
		return psid;
	}

	public void setPsid(Integer psid) {
		this.psid = psid;
	}

	public String getPsmc() {
		return psmc;
	}

	public void setPsmc(String psmc) {
		this.psmc = psmc;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getYxCount() {
		return yxCount;
	}

	public void setYxCount(Integer yxCount) {
		this.yxCount = yxCount;
	}

	public Integer getYyxCount() {
		return yyxCount;
	}

	public void setYyxCount(Integer yyxCount) {
		this.yyxCount = yyxCount;
	}

	public String getYxRate() {
		return yxRate;
	}

	public void setYxRate(String yxRate) {
		this.yxRate = yxRate;
	}

}