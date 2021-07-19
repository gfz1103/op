
package com.buit.commons.response;

import java.util.ArrayList;
import java.util.List;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsQueryDJResp<br>
 * 类描述：收费结算单据查询<br>
 * 
 * @author WY
 */
@ApiModel(value = "收费结算单据查询")
public class MsQueryDjResp extends PageQuery {
	@ApiModelProperty(value = "数量")
	private Integer count;
	@ApiModelProperty(value = "开单期限")
	private Integer kdrq;
	@ApiModelProperty(value = "诊断序号")
	private Integer zdxh;
	@ApiModelProperty(value = "疾病名称")
	private String jbmc;
	@ApiModelProperty(value = "处方信息")
	private List<MsCfInfoResp> listDj = new ArrayList<MsCfInfoResp>();

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getKdrq() {
		return kdrq;
	}

	public void setKdrq(Integer kdrq) {
		this.kdrq = kdrq;
	}

	public Integer getZdxh() {
		return zdxh;
	}

	public void setZdxh(Integer zdxh) {
		this.zdxh = zdxh;
	}

	public String getJbmc() {
		return jbmc;
	}

	public void setJbmc(String jbmc) {
		this.jbmc = jbmc;
	}

	public List<MsCfInfoResp> getListDj() {
		return listDj;
	}

	public void setListDj(List<MsCfInfoResp> listDj) {
		this.listDj = listDj;
	}

}