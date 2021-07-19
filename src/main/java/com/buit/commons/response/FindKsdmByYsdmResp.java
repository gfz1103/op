
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：FindKsdmByYsdmResp<br>
 * 类描述：根据医生工号查找对应的挂号科室返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "根据医生工号查找对应的挂号科室返回")
public class FindKsdmByYsdmResp extends PageQuery {
	@ApiModelProperty(value = "多个科室代码字符串")
	private String ksdm;
	@ApiModelProperty(value = "第一个科室代码")
	private String firstKs;

	public String getKsdm() {
		return ksdm;
	}

	public void setKsdm(String ksdm) {
		this.ksdm = ksdm;
	}

	public String getFirstKs() {
		return firstKs;
	}

	public void setFirstKs(String firstKs) {
		this.firstKs = firstKs;
	}

}