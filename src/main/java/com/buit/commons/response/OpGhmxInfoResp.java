
package com.buit.commons.response;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpGhmxInfoResp<br>
 * 类描述：结算后挂号明细信息<br>
 * 
 * @author WY
 */
@ApiModel(value = "结算后挂号明细信息")
public class OpGhmxInfoResp extends PageQuery {
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "门诊号码")
	private String mzhm;
	@ApiModelProperty(value = "病人性质 ")
	private Integer brxz;
	@ApiModelProperty(value = "就诊状态 ")
	private Integer jzzt;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "挂号时间")
	private Timestamp ghsj;

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public String getMzhm() {
		return mzhm;
	}

	public void setMzhm(String mzhm) {
		this.mzhm = mzhm;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public Integer getJzzt() {
		return jzzt;
	}

	public void setJzzt(Integer jzzt) {
		this.jzzt = jzzt;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Timestamp getGhsj() {
		return ghsj;
	}

	public void setGhsj(Timestamp ghsj) {
		this.ghsj = ghsj;
	}

}
