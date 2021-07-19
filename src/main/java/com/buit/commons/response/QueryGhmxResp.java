
package com.buit.commons.response;

import java.util.ArrayList;
import java.util.List;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryGhmxResp<br>
 * 类描述：算后挂号明细返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "结算后挂号明细返回")
public class QueryGhmxResp extends PageQuery {
	@ApiModelProperty(value = "数量")
	private Integer count;
	@ApiModelProperty(value = "挂号明细列表")
	private List<OpGhmxInfoResp> resultList = new ArrayList<OpGhmxInfoResp>();

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<OpGhmxInfoResp> getResultList() {
		return resultList;
	}

	public void setResultList(List<OpGhmxInfoResp> resultList) {
		this.resultList = resultList;
	}

}
