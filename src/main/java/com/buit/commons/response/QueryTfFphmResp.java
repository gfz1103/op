
package com.buit.commons.response;

import java.util.List;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryTfFphmResp<br>
 * 类描述：查询退费号码返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "查询退费号码返回")
public class QueryTfFphmResp extends PageQuery {
	@ApiModelProperty(value = "付款方式")
	private List<QueryTfFkxxResp> fkxxs;
	@ApiModelProperty(value = "门诊信息")
	private QueryTfJeResp body;
	@ApiModelProperty(value = "数据详情")
	private List<QueryDjDetailResp> details;
	@ApiModelProperty(value = "门诊信息")
	private QueryTfMzxxResp mzxx;

	public List<QueryTfFkxxResp> getFkxxs() {
		return fkxxs;
	}

	public void setFkxxs(List<QueryTfFkxxResp> fkxxs) {
		this.fkxxs = fkxxs;
	}

	public QueryTfJeResp getBody() {
		return body;
	}

	public void setBody(QueryTfJeResp body) {
		this.body = body;
	}

	public List<QueryDjDetailResp> getDetails() {
		return details;
	}

	public void setDetails(List<QueryDjDetailResp> details) {
		this.details = details;
	}

	public QueryTfMzxxResp getMzxx() {
		return mzxx;
	}

	public void setMzxx(QueryTfMzxxResp mzxx) {
		this.mzxx = mzxx;
	}
}