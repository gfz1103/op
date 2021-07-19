
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：LoadMedcineSetReq<br>
 * 类描述：处方组套查询请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "处方组套查询请求")
public class LoadMedcineSetReq extends PageQuery {
	@ApiModelProperty(value = "组套编号")
	private Integer ztbh;
	@ApiModelProperty(value = "药品序号")
	private Integer ypxh;
	@ApiModelProperty(value = "病人性质")
	private Integer brxz;
	@ApiModelProperty(value = "药房ID")
	private Integer pharmacyId;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;

	public Integer getZtbh() {
		return ztbh;
	}

	public void setZtbh(Integer ztbh) {
		this.ztbh = ztbh;
	}

	public Integer getYpxh() {
		return ypxh;
	}

	public void setYpxh(Integer ypxh) {
		this.ypxh = ypxh;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public Integer getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(Integer pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

}