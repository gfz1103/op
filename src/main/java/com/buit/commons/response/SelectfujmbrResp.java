
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SelectfujmbrResp<br>
 * 类描述：查询妇幼减免病人返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "查询妇幼减免病人返回")
public class SelectfujmbrResp extends PageQuery {
	@ApiModelProperty(value = "fyetbrxz")
	private Integer fyetbrxz;
	@ApiModelProperty(value = "newbrxz")
	private Integer newbrxz;

	public Integer getFyetbrxz() {
		return fyetbrxz;
	}

	public void setFyetbrxz(Integer fyetbrxz) {
		this.fyetbrxz = fyetbrxz;
	}

	public Integer getNewbrxz() {
		return newbrxz;
	}

	public void setNewbrxz(Integer newbrxz) {
		this.newbrxz = newbrxz;
	}

}