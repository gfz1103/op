
package com.buit.commons.response;

import java.util.ArrayList;
import java.util.List;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：ZfQueryFphmResp<br>
 * 类描述：发票作废发票查询返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "发票作废发票查询返回")
public class ZfQueryFphmResp extends PageQuery {

	@ApiModelProperty(value = "重打判别")
	private Integer cdpb;
	@ApiModelProperty(value = "是否医保")
	private Integer isYb;

	@ApiModelProperty(value = "病人信息")
	private FpzfBrdaResp fpzfBrdaResp;
	@ApiModelProperty(value = "处方信息列表")
	private List<CfInfoResp> resultList = new ArrayList<CfInfoResp>();

	public Integer getCdpb() {
		return cdpb;
	}

	public void setCdpb(Integer cdpb) {
		this.cdpb = cdpb;
	}

	public FpzfBrdaResp getFpzfBrdaResp() {
		return fpzfBrdaResp;
	}

	public void setFpzfBrdaResp(FpzfBrdaResp fpzfBrdaResp) {
		this.fpzfBrdaResp = fpzfBrdaResp;
	}

	public List<CfInfoResp> getResultList() {
		return resultList;
	}

	public void setResultList(List<CfInfoResp> resultList) {
		this.resultList = resultList;
	}

	public Integer getIsYb() {
		return isYb;
	}

	public void setIsYb(Integer isYb) {
		this.isYb = isYb;
	}
}