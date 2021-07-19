
package com.buit.commons.request;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SaveTransferReq<br>
 * 类描述：余额转出请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "余额转出请求")
public class SaveTransferReq extends PageQuery {
	@ApiModelProperty(value = "转入ID")
	private String bridIn;
	@ApiModelProperty(value = "转出ID")
	private String bridOut;
	@ApiModelProperty(value = "转入病人姓名")
	private String brxmIn;
	@ApiModelProperty(value = "转出病人姓名")
	private String brxmOut;
	@ApiModelProperty(value = "转入卡ID")
	private Integer cardIdIn;
	@ApiModelProperty(value = "转出卡ID")
	private Integer cardIdOut;
	@ApiModelProperty(value = "转入卡号")
	private String cardNoIn;
	@ApiModelProperty(value = "转出卡号")
	private String cardNoOut;
	@ApiModelProperty(value = "转入卡类型")
	private String cardTypeCodeIn;
	@ApiModelProperty(value = "转出卡类型")
	private String cardTypeCodeOut;
	@ApiModelProperty(value = "转入身份证")
	private String idcardIn;
	@ApiModelProperty(value = "转出身份证")
	private String idcardOut;
	@ApiModelProperty(value = "转入卡内余额")
	private BigDecimal knyeIn;
	@ApiModelProperty(value = "转出卡内余额")
	private BigDecimal knyeOut;
	@ApiModelProperty(value = "转出金额")
	private BigDecimal knyeOutTransfered;
	@ApiModelProperty(value = "转账金额")
	private BigDecimal knyeTransfered;
	@JsonIgnore
	@ApiModelProperty(value = "员工ID")
	private Integer ygdm;
	@JsonIgnore
	@ApiModelProperty(value = "ip")
	private String ip;

	public String getBridIn() {
		return bridIn;
	}

	public void setBridIn(String bridIn) {
		this.bridIn = bridIn;
	}

	public String getBridOut() {
		return bridOut;
	}

	public void setBridOut(String bridOut) {
		this.bridOut = bridOut;
	}

	public String getBrxmIn() {
		return brxmIn;
	}

	public void setBrxmIn(String brxmIn) {
		this.brxmIn = brxmIn;
	}

	public String getBrxmOut() {
		return brxmOut;
	}

	public void setBrxmOut(String brxmOut) {
		this.brxmOut = brxmOut;
	}

	public Integer getCardIdIn() {
		return cardIdIn;
	}

	public void setCardIdIn(Integer cardIdIn) {
		this.cardIdIn = cardIdIn;
	}

	public Integer getCardIdOut() {
		return cardIdOut;
	}

	public void setCardIdOut(Integer cardIdOut) {
		this.cardIdOut = cardIdOut;
	}

	public String getCardNoIn() {
		return cardNoIn;
	}

	public void setCardNoIn(String cardNoIn) {
		this.cardNoIn = cardNoIn;
	}

	public String getCardNoOut() {
		return cardNoOut;
	}

	public void setCardNoOut(String cardNoOut) {
		this.cardNoOut = cardNoOut;
	}

	public String getCardTypeCodeIn() {
		return cardTypeCodeIn;
	}

	public void setCardTypeCodeIn(String cardTypeCodeIn) {
		this.cardTypeCodeIn = cardTypeCodeIn;
	}

	public String getCardTypeCodeOut() {
		return cardTypeCodeOut;
	}

	public void setCardTypeCodeOut(String cardTypeCodeOut) {
		this.cardTypeCodeOut = cardTypeCodeOut;
	}

	public String getIdcardIn() {
		return idcardIn;
	}

	public void setIdcardIn(String idcardIn) {
		this.idcardIn = idcardIn;
	}

	public String getIdcardOut() {
		return idcardOut;
	}

	public void setIdcardOut(String idcardOut) {
		this.idcardOut = idcardOut;
	}

	public BigDecimal getKnyeIn() {
		return knyeIn;
	}

	public void setKnyeIn(BigDecimal knyeIn) {
		this.knyeIn = knyeIn;
	}

	public BigDecimal getKnyeOut() {
		return knyeOut;
	}

	public void setKnyeOut(BigDecimal knyeOut) {
		this.knyeOut = knyeOut;
	}

	public BigDecimal getKnyeOutTransfered() {
		return knyeOutTransfered;
	}

	public void setKnyeOutTransfered(BigDecimal knyeOutTransfered) {
		this.knyeOutTransfered = knyeOutTransfered;
	}

	public BigDecimal getKnyeTransfered() {
		return knyeTransfered;
	}

	public void setKnyeTransfered(BigDecimal knyeTransfered) {
		this.knyeTransfered = knyeTransfered;
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

}