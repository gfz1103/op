
package com.buit.commons.request;

import java.util.ArrayList;
import java.util.List;

import com.buit.commons.PageQuery;
import com.buit.op.model.OpPosmx;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SaveRefundSettleReq<br>
 * 类描述：退费结算信息请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "退费结算信息请求")
public class SaveRefundSettleReq extends PageQuery {
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "付费方式")
	private Integer fffs;
	@ApiModelProperty(value = "退费处理门诊信息")
	private SaveRefundSettleMzxxReq mzxx;
	@ApiModelProperty(value = "结算数据列表")
	private List<QueryPayReq> data = new ArrayList<QueryPayReq>();
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "员工ID")
	private Integer ygdm;
	@JsonIgnore
	@ApiModelProperty(value = "ip")
	private String ip;
	@ApiModelProperty(value = "pos结算")
	private OpPosmx pos;
	@ApiModelProperty(value = "卡号")
	private String cardno;
	@ApiModelProperty(value = "卡类型")
	private String cardtype;
	@ApiModelProperty(value = "账户标志")
	private String Accountattr;
	@ApiModelProperty(value = "员工姓名")
	private String ygxm;

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public Integer getFffs() {
		return fffs;
	}

	public void setFffs(Integer fffs) {
		this.fffs = fffs;
	}

	public SaveRefundSettleMzxxReq getMzxx() {
		return mzxx;
	}

	public void setMzxx(SaveRefundSettleMzxxReq mzxx) {
		this.mzxx = mzxx;
	}

	public List<QueryPayReq> getData() {
		return data;
	}

	public void setData(List<QueryPayReq> data) {
		this.data = data;
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

	public OpPosmx getPos() {
		return pos;
	}

	public void setPos(OpPosmx pos) {
		this.pos = pos;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getYgxm() {
		return ygxm;
	}

	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}

	public String getAccountattr() {
		return Accountattr;
	}

	public void setAccountattr(String accountattr) {
		Accountattr = accountattr;
	}
}
