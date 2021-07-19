
package com.buit.commons.request;

import java.sql.Date;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryUnSkinTestReq<br>
 * 类描述：查询病人已收费、未执行的皮试项目请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "查询病人已收费、未执行的皮试项目请求")
public class QueryUnSkinTestReq extends PageQuery {
	@JsonIgnore
	@ApiModelProperty(value = "医疗机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "发票号")
	private String fphm;
	@ApiModelProperty(value = "卡号")
	private String jzkh;
	@ApiModelProperty(value = "收费日期")
	private Date sfrq;
	@ApiModelProperty(value = "开始时间")
	private Date beginDay;
	@ApiModelProperty(value = "结束时间")
	private Date endDay;

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public Date getSfrq() {
		return sfrq;
	}

	public void setSfrq(Date sfrq) {
		this.sfrq = sfrq;
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

}