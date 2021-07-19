
package com.buit.commons.response;

import com.buit.commons.PageQuery;
import com.buit.commons.request.SaveRefundSettleMzxxReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SaveRefundSettleResp<br>
 * 类描述：退费结算信息返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "退费结算信息返回")
public class SaveRefundSettleResp extends PageQuery {
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "退费处理门诊信息")
	private SaveRefundSettleMzxxReq mzxx;

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public SaveRefundSettleMzxxReq getMzxx() {
		return mzxx;
	}

	public void setMzxx(SaveRefundSettleMzxxReq mzxx) {
		this.mzxx = mzxx;
	}

}