
package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryUnPsdjmxResp<br>
 * 类描述：查询病人未执行的皮试项目登记明细列表返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "查询病人未执行的皮试项目登记明细列表返回")
public class QueryUnPsdjmxResp {
	@ApiModelProperty(value = "处方号码")
	private Integer cfhm;
	@ApiModelProperty(value = "处方组号")
	private Integer cfzh;
	@ApiModelProperty(value = "药品序号")
	private Integer ypxh;

	public Integer getCfhm() {
		return cfhm;
	}

	public void setCfhm(Integer cfhm) {
		this.cfhm = cfhm;
	}

	public Integer getCfzh() {
		return cfzh;
	}

	public void setCfzh(Integer cfzh) {
		this.cfzh = cfzh;
	}

	public Integer getYpxh() {
		return ypxh;
	}

	public void setYpxh(Integer ypxh) {
		this.ypxh = ypxh;
	}

}