
package com.buit.commons.request;

import java.sql.Date;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryFphmReq<br>
 * 类描述：发票查询<br>
 * 
 * @author WY
 */
@ApiModel(value = "发票查询")
public class QueryFphmReq extends PageQuery {
	private static final long serialVersionUID = 6421078753890437339L;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "收费日期")
	private Date sfrq;
	@ApiModelProperty(value = "起始发票号码")
	private String beginFphm;
	@ApiModelProperty(value = "结束发票号码")
	private String endFphm;
	@ApiModelProperty(value = "开始收费日期")
	private Date beginSfrq;
	@ApiModelProperty(value = "结束收费日期")
	private Date endSfrq;
	@ApiModelProperty(value = "病人性质")
	private Integer brxz;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "操作工号")
	private Integer czgh;
	@JsonIgnore
	@ApiModelProperty(value = "卡类型")
	private String cardTypeCode;

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Date getSfrq() {
		return sfrq;
	}

	public void setSfrq(Date sfrq) {
		this.sfrq = sfrq;
	}

	public String getBeginFphm() {
		return beginFphm;
	}

	public void setBeginFphm(String beginFphm) {
		this.beginFphm = beginFphm;
	}

	public String getEndFphm() {
		return endFphm;
	}

	public void setEndFphm(String endFphm) {
		this.endFphm = endFphm;
	}

	public Date getBeginSfrq() {
		return beginSfrq;
	}

	public void setBeginSfrq(Date beginSfrq) {
		this.beginSfrq = beginSfrq;
	}

	public Date getEndSfrq() {
		return endSfrq;
	}

	public void setEndSfrq(Date endSfrq) {
		this.endSfrq = endSfrq;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

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

	public Integer getCzgh() {
		return czgh;
	}

	public void setCzgh(Integer czgh) {
		this.czgh = czgh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCardTypeCode() {
		return cardTypeCode;
	}

	public void setCardTypeCode(String cardTypeCode) {
		this.cardTypeCode = cardTypeCode;
	}

}