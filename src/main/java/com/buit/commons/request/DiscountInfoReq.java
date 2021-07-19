
package com.buit.commons.request;

import java.util.ArrayList;
import java.util.List;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：DiscountInfoReq<br>
 * 类描述：折扣信息保存请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "折扣信息保存请求")
public class DiscountInfoReq extends PageQuery {
	@ApiModelProperty(value = "付费方式")
	private Integer fffs;
	@ApiModelProperty(value = "门诊信息")
	private MzxxReq mzxxReq;
	@ApiModelProperty(value = "折扣信息列表")
	private List<QueryPayReq> list = new ArrayList<QueryPayReq>();

	public Integer getFffs() {
		return fffs;
	}

	public void setFffs(Integer fffs) {
		this.fffs = fffs;
	}

	public MzxxReq getMzxxReq() {
		return mzxxReq;
	}

	public void setMzxxReq(MzxxReq mzxxReq) {
		this.mzxxReq = mzxxReq;
	}

	public List<QueryPayReq> getList() {
		return list;
	}

	public void setList(List<QueryPayReq> list) {
		this.list = list;
	}

}