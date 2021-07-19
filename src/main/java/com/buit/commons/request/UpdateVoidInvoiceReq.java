
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：UpdateVoidInvoiceReq<br>
 * 类描述：发票作废请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "发票作废请求")
public class UpdateVoidInvoiceReq extends PageQuery {
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "提交")
	private boolean nocommit;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "员工代码")
	private Integer ygdm;
	@JsonIgnore
	@ApiModelProperty(value = "员工姓名")
	private String ygxm;
	@JsonIgnore
	@ApiModelProperty(value = "ip")
	private String ip;
	@ApiModelProperty(value = "门诊就诊流水号")
	private String jzlsh;
	@ApiModelProperty(value = "是否医保")
	private Integer isYb;
	@ApiModelProperty(value = "卡类型")
	private String cardtype;
	@ApiModelProperty(value = "卡号")
	private String carddata;

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public boolean isNocommit() {
		return nocommit;
	}

	public void setNocommit(boolean nocommit) {
		this.nocommit = nocommit;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getYgdm() {
		return ygdm;
	}

	public void setYgdm(Integer ygdm) {
		this.ygdm = ygdm;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public Integer getIsYb() {
		return isYb;
	}

	public void setIsYb(Integer isYb) {
		this.isYb = isYb;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCarddata() {
		return carddata;
	}

	public void setCarddata(String carddata) {
		this.carddata = carddata;
	}

	public String getYgxm() {
		return ygxm;
	}

	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}
}