   
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpZt01AccountingSrfResp<br> 
 * 类描述：住院_费用记账项目组套输入法<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="住院_费用记账项目组套_accountingsrfResp")
public class OpZt01AccountingSrfResp extends PageQuery{
	
	@ApiModelProperty(value="费用序号")
	private Integer fyxh;
	
	@ApiModelProperty(value="费用名称")
	private String fymc;
		
	@ApiModelProperty(value="是否为组套")
	private Integer iszt;

	public Integer getFyxh() {
		return fyxh;
	}

	public void setFyxh(Integer fyxh) {
		this.fyxh = fyxh;
	}

	public String getFymc() {
		return fymc;
	}

	public void setFymc(String fymc) {
		this.fymc = fymc;
	}

	public Integer getIszt() {
		return iszt;
	}

	public void setIszt(Integer iszt) {
		this.iszt = iszt;
	}
	
	
}
