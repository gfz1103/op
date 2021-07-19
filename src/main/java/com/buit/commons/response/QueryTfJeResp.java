
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryTfJeResp<br>
 * 类描述：退费处理金额信息返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "退费处理金额信息返回")
public class QueryTfJeResp extends PageQuery {
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "自费判别")
	private Integer zfpb;
	@ApiModelProperty(value = "退费金额")
	private BigDecimal tfje;
	@ApiModelProperty(value = "门诊序号")
	private Integer mzxh;

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public Integer getZfpb() {
		return zfpb;
	}

	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}

	public BigDecimal getTfje() {
		return tfje;
	}

	public void setTfje(BigDecimal tfje) {
		this.tfje = tfje;
	}

	public Integer getMzxh() {
		return mzxh;
	}

	public void setMzxh(Integer mzxh) {
		this.mzxh = mzxh;
	}

}