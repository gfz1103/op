
package com.buit.commons.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryTFPaymentReq<br>
 * 类描述：退费结算计算请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "退费结算计算请求")
public class QueryTfPaymentReq extends PageQuery {
	private static final long serialVersionUID = -8656368457802317522L;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "员工ID")
	private Integer ygdm;
	@ApiModelProperty(value = "货币误差")
	private BigDecimal hbwc;
	@ApiModelProperty(value = "退费门诊信息")
	private QueryTfPayMzxxReq mzxx;
	@ApiModelProperty(value = "结算信息")
	private JsxxReq jsxxReq;
	@ApiModelProperty(value = "请求body")
	private List<QueryPayReq> body = new ArrayList<QueryPayReq>();

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getYgdm() {
		return ygdm;
	}

	public void setYgdm(Integer ygdm) {
		this.ygdm = ygdm;
	}

	public QueryTfPayMzxxReq getMzxx() {
		return mzxx;
	}

	public void setMzxx(QueryTfPayMzxxReq mzxx) {
		this.mzxx = mzxx;
	}

	public JsxxReq getJsxxReq() {
		return jsxxReq;
	}

	public void setJsxxReq(JsxxReq jsxxReq) {
		this.jsxxReq = jsxxReq;
	}

	public List<QueryPayReq> getBody() {
		return body;
	}

	public void setBody(List<QueryPayReq> body) {
		this.body = body;
	}

	public BigDecimal getHbwc() {
		return hbwc;
	}

	public void setHbwc(BigDecimal hbwc) {
		this.hbwc = hbwc;
	}

}