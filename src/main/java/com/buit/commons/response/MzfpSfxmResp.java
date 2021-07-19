
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MzfpSfxmResp<br>
 * 类描述：收费结算发票打印收费项目返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "收费结算发票打印收费项目返回")
public class MzfpSfxmResp extends PageQuery {
	private static final long serialVersionUID = -554469667905211799L;
	@ApiModelProperty(value = "收费项目")
	private String sfxm;
	@ApiModelProperty(value = "项目金额")
	private BigDecimal xmje;

	public String getSfxm() {
		return sfxm;
	}

	public void setSfxm(String sfxm) {
		this.sfxm = sfxm;
	}

	public BigDecimal getXmje() {
		return xmje;
	}

	public void setXmje(BigDecimal xmje) {
		this.xmje = xmje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}