
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryTfPaymentResp<br>
 * 类描述：退费计算返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "退费计算返回")
public class QueryTfPaymentResp extends PageQuery {
	@ApiModelProperty(value = "结算信息")
	private JsxxResp body;
	@ApiModelProperty(value = "退费金额")
	private TfJeResp showjs;

	public JsxxResp getBody() {
		return body;
	}

	public void setBody(JsxxResp body) {
		this.body = body;
	}

	public TfJeResp getShowjs() {
		return showjs;
	}

	public void setShowjs(TfJeResp showjs) {
		this.showjs = showjs;
	}
}