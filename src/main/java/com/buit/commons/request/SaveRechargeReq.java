
package com.buit.commons.request;

import java.math.BigDecimal;
import java.sql.Date;

import com.buit.commons.PageQuery;
import com.buit.op.model.OpPosmx;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SaveRechargeReq<br>
 * 类描述：充值请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "充值请求")
public class SaveRechargeReq extends PageQuery {
	@ApiModelProperty(value = "病人ID")
	private Integer brid;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "卡片ID")
	private Integer cardid;
	@ApiModelProperty(value = "卡号")
	private String cardno;
	@ApiModelProperty(value = "卡类型 | 01=健康卡 02=市民卡 03=医保卡 09=其他卡")
	private String cardtypecode;
	@ApiModelProperty(value = "充值方式")
	private Integer czfs;
	@ApiModelProperty(value = "充值后余额")
	private BigDecimal czhye;
	@ApiModelProperty(value = "充值金额")
	private BigDecimal czje;
	@ApiModelProperty(value = "发卡时间")
	private Date fksj;
	@ApiModelProperty(value = "身份证号")
	private String idcard;
	@ApiModelProperty(value = "卡内余额")
	private BigDecimal knye;
	@ApiModelProperty(value = "状态")
	private String status;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "用户ID")
	private Integer ygdm;
	@JsonIgnore
	@ApiModelProperty(value = "ip")
	private String ip;

	@ApiModelProperty(value = "pos结算")
	private OpPosmx pos;

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public Integer getCardid() {
		return cardid;
	}

	public void setCardid(Integer cardid) {
		this.cardid = cardid;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCardtypecode() {
		return cardtypecode;
	}

	public void setCardtypecode(String cardtypecode) {
		this.cardtypecode = cardtypecode;
	}

	public Integer getCzfs() {
		return czfs;
	}

	public void setCzfs(Integer czfs) {
		this.czfs = czfs;
	}

	public BigDecimal getCzhye() {
		return czhye;
	}

	public void setCzhye(BigDecimal czhye) {
		this.czhye = czhye;
	}

	public BigDecimal getCzje() {
		return czje;
	}

	public void setCzje(BigDecimal czje) {
		this.czje = czje;
	}

	public Date getFksj() {
		return fksj;
	}

	public void setFksj(Date fksj) {
		this.fksj = fksj;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public BigDecimal getKnye() {
		return knye;
	}

	public void setKnye(BigDecimal knye) {
		this.knye = knye;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}
