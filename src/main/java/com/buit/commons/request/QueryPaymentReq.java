
package com.buit.commons.request;

import java.util.ArrayList;
import java.util.List;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryPaymentReq<br>
 * 类描述：结算查询请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "结算查询请求")
public class QueryPaymentReq extends PageQuery {
	private static final long serialVersionUID = 859908939363621685L;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "员工代码")
	private Integer ygdm;
	@JsonIgnore
	@ApiModelProperty(value = "员工姓名")
	private String ygxm;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "查询请求数组")
	private List<QueryPayReq> queryPayReqList = new ArrayList<QueryPayReq>();
	@JsonIgnore
	@ApiModelProperty(value = "结算信息")
	private JsxxReq jsxxReq;

	@ApiModelProperty(value = "是否医保")
	private Integer isYb;
	@ApiModelProperty(value = "挂号科室")
	private String ghks;
	@ApiModelProperty(value = "病人性质")
	private String brxz;
	@ApiModelProperty(value = "ip")
	private String ip;
	@ApiModelProperty(value = "卡类型")
	private String cardtype;
	@ApiModelProperty(value = "卡号")
	private String cardid;
	@ApiModelProperty(value = "账户标志")
	private String accountattr;
	@ApiModelProperty(value = "是否大病")
	private String isDb;
	@ApiModelProperty(value = "病人id")
	private Integer brid;

	public List<QueryPayReq> getQueryPayReqList() {
		return queryPayReqList;
	}

	public void setQueryPayReqList(List<QueryPayReq> queryPayReqList) {
		this.queryPayReqList = queryPayReqList;
	}

	public JsxxReq getJsxxReq() {
		return jsxxReq;
	}

	public void setJsxxReq(JsxxReq jsxxReq) {
		this.jsxxReq = jsxxReq;
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

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getIsYb() {
		return isYb;
	}

	public void setIsYb(Integer isYb) {
		this.isYb = isYb;
	}

	public String getGhks() {
		return ghks;
	}

	public void setGhks(String ghks) {
		this.ghks = ghks;
	}

	public String getBrxz() {
		return brxz;
	}

	public void setBrxz(String brxz) {
		this.brxz = brxz;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getAccountattr() {
		return accountattr;
	}

	public void setAccountattr(String accountattr) {
		this.accountattr = accountattr;
	}

	public String getIsDb() {
		return isDb;
	}

	public void setIsDb(String isDb) {
		this.isDb = isDb;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public String getYgxm() {
		return ygxm;
	}

	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}
}