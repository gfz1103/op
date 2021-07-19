
package com.buit.commons.request;

import java.sql.Date;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryRegisteredReq<br>
 * 类描述：挂号查询<br>
 * 
 * @author WY
 */
@ApiModel(value = "挂号查询")
public class QueryRegisteredReq extends PageQuery {
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "就诊号码")
	private String jzhm;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "开始时间")
	private Date beginDay;
	@ApiModelProperty(value = "结束时间")
	private Date endDay;
	@ApiModelProperty(value = "医生代码")
	private Integer ysdm;
	@ApiModelProperty(value = "挂号操作工号")
	private Integer ghczgh;
	@ApiModelProperty(value = "退号操作工号")
	private Integer thczgh;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "挂号类别")
	private String ghlb;
	@ApiModelProperty(value = "病人性质")
	private Integer brxz;
	@ApiModelProperty(value = "查询起始发票号")
	private Integer beginFphm;
	@ApiModelProperty(value = "查询结束发票号")
	private Integer endFphm;
	@ApiModelProperty(value = "大病项目编码")
	private String dbbz;
	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getJzhm() {
		return jzhm;
	}

	public void setJzhm(String jzhm) {
		this.jzhm = jzhm;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public Date getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(Date beginDay) {
		this.beginDay = beginDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public Integer getYsdm() {
		return ysdm;
	}

	public void setYsdm(Integer ysdm) {
		this.ysdm = ysdm;
	}

	public Integer getGhczgh() {
		return ghczgh;
	}

	public void setGhczgh(Integer ghczgh) {
		this.ghczgh = ghczgh;
	}

	public Integer getThczgh() {
		return thczgh;
	}

	public void setThczgh(Integer thczgh) {
		this.thczgh = thczgh;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getGhlb() {
		return ghlb;
	}

	public void setGhlb(String ghlb) {
		this.ghlb = ghlb;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public Integer getBeginFphm() {
		return beginFphm;
	}

	public void setBeginFphm(Integer beginFphm) {
		this.beginFphm = beginFphm;
	}

	public Integer getEndFphm() {
		return endFphm;
	}

	public void setEndFphm(Integer endFphm) {
		this.endFphm = endFphm;
	}

	public String getDbbz() {
		return dbbz;
	}

	public void setDbbz(String dbbz) {
		this.dbbz = dbbz;
	}
}