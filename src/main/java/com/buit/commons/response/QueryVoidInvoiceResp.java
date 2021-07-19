
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryVoidInvoiceResp<br>
 * 类描述：发票作废列表<br>
 * 
 * @author WY
 */
@ApiModel(value = "发票作废列表返回")
public class QueryVoidInvoiceResp extends PageQuery {
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "发票号码 ")
	private String fphm;
	@ApiModelProperty(value = "结账日期")
	private Timestamp jzrq;
	@ApiModelProperty(value = "病人性质名称")
	private String brxzText;
	@ApiModelProperty(value = "作废日期")
	private Timestamp zfrq;
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "门诊类别")
	private Integer mzlb;
	@ApiModelProperty(value = "总计金额")
	private BigDecimal zjje;
	@ApiModelProperty(value = "汇总日期")
	private Timestamp hzrq;
	@ApiModelProperty(value = "收费日期")
	private Timestamp sfrq;
	@ApiModelProperty(value = "操作工号名称")
	private String czghText;
	@ApiModelProperty(value = "门诊序号")
	private Integer mzxh;
	@ApiModelProperty(value = "病人性质 ")
	private Integer brxz;
	@ApiModelProperty(value = "操作工号")
	private String czgh;

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public Timestamp getJzrq() {
		return jzrq;
	}

	public void setJzrq(Timestamp jzrq) {
		this.jzrq = jzrq;
	}

	public Timestamp getZfrq() {
		return zfrq;
	}

	public void setZfrq(Timestamp zfrq) {
		this.zfrq = zfrq;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getMzlb() {
		return mzlb;
	}

	public void setMzlb(Integer mzlb) {
		this.mzlb = mzlb;
	}

	public BigDecimal getZjje() {
		return zjje;
	}

	public void setZjje(BigDecimal zjje) {
		this.zjje = zjje;
	}

	public Timestamp getHzrq() {
		return hzrq;
	}

	public void setHzrq(Timestamp hzrq) {
		this.hzrq = hzrq;
	}

	public Timestamp getSfrq() {
		return sfrq;
	}

	public void setSfrq(Timestamp sfrq) {
		this.sfrq = sfrq;
	}

	public Integer getMzxh() {
		return mzxh;
	}

	public void setMzxh(Integer mzxh) {
		this.mzxh = mzxh;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public String getCzgh() {
		return czgh;
	}

	public void setCzgh(String czgh) {
		this.czgh = czgh;
	}

	public String getBrxzText() {
		return brxzText;
	}

	public void setBrxzText(String brxzText) {
		this.brxzText = brxzText;
	}

	public String getCzghText() {
		return czghText;
	}

	public void setCzghText(String czghText) {
		this.czghText = czghText;
	}

}