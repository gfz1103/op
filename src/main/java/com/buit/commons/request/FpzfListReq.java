
package com.buit.commons.request;

import java.sql.Date;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：FpzfListReq<br>
 * 类描述：可作废的发票列表<br>
 * 
 * @author WY
 */
@ApiModel(value = "可作废的发票列表")
public class FpzfListReq extends PageQuery {
	@JsonIgnore
	@ApiModelProperty(value = "收费日期")
	private Date sfrq;
	@ApiModelProperty(value = "开始时间")
	private Date beginDay;
	@ApiModelProperty(value = "结束时间")
	private Date endDay;
	@ApiModelProperty(value = "发票号码 ")
	private String fphm;
	@ApiModelProperty(value = "作废类型判别:0:卡号 1：发票号码")
	private Integer zfpb;

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

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public Integer getZfpb() {
		return zfpb;
	}

	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}

}