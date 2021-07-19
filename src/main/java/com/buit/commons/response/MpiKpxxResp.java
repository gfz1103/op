
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MpiKpxxResp<br>
 * 类描述：充值卡管理<br>
 * 
 * @author WY
 */
@ApiModel(value = "充值卡管理")
public class MpiKpxxResp extends PageQuery {
	@ApiModelProperty(value = "编号(主键ID)")
	private Integer cardid;
	@ApiModelProperty(value = "卡号")
	private String cardno;
	@ApiModelProperty(value = "卡类型 | 98=医保卡 04=就诊卡")
	private String cardtypecode;
	@ApiModelProperty(value = "发卡时间")
	private Timestamp fksj;
	@ApiModelProperty(value = "操作IP")
	private String czip;
	@ApiModelProperty(value = "操作工号")
	private String czgh;
	@ApiModelProperty(value = "病人ID")
	private String brid;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "身份证")
	private String idcard;
	@ApiModelProperty(value = "卡内余额")
	private BigDecimal knye;
	@ApiModelProperty(value = "状态 | 0=挂失 1=正常 2=注销")
	private String status;
	@ApiModelProperty(value = "状态名称")
	private String statusText;
	@ApiModelProperty(value = "卡类型名称")
	private String cardtypecodeText;

	/**
	 * 设置:编号(主键ID)
	 */
	public void setCardid(Integer value) {
		this.cardid = value;
	}

	/**
	 * 获取:编号(主键ID)
	 */
	public Integer getCardid() {
		return cardid;
	}

	/**
	 * 设置:卡号
	 */
	public void setCardno(String value) {
		this.cardno = value;
	}

	/**
	 * 获取:卡号
	 */
	public String getCardno() {
		return cardno;
	}

	/**
	 * 设置:卡类型 | 98=医保卡 04=就诊卡
	 */
	public void setCardtypecode(String value) {
		this.cardtypecode = value;
	}

	/**
	 * 获取:卡类型 | 98=医保卡 04=就诊卡
	 */
	public String getCardtypecode() {
		return cardtypecode;
	}

	/**
	 * 设置:发卡时间
	 */
	public void setFksj(Timestamp value) {
		this.fksj = value;
	}

	/**
	 * 获取:发卡时间
	 */
	public Timestamp getFksj() {
		return fksj;
	}

	/**
	 * 设置:操作IP
	 */
	public void setCzip(String value) {
		this.czip = value;
	}

	/**
	 * 获取:操作IP
	 */
	public String getCzip() {
		return czip;
	}

	/**
	 * 设置:操作工号
	 */
	public void setCzgh(String value) {
		this.czgh = value;
	}

	/**
	 * 获取:操作工号
	 */
	public String getCzgh() {
		return czgh;
	}

	/**
	 * 设置:病人ID,关联MPI_DemographicInfo表EMPIID字段
	 */
	public void setBrid(String value) {
		this.brid = value;
	}

	/**
	 * 获取:病人ID,关联MPI_DemographicInfo表EMPIID字段
	 */
	public String getBrid() {
		return brid;
	}

	/**
	 * 设置:病人姓名
	 */
	public void setBrxm(String value) {
		this.brxm = value;
	}

	/**
	 * 获取:病人姓名
	 */
	public String getBrxm() {
		return brxm;
	}

	/**
	 * 设置:身份证
	 */
	public void setIdcard(String value) {
		this.idcard = value;
	}

	/**
	 * 获取:身份证
	 */
	public String getIdcard() {
		return idcard;
	}

	/**
	 * 设置:卡内余额
	 */
	public void setKnye(BigDecimal value) {
		this.knye = value;
	}

	/**
	 * 获取:卡内余额
	 */
	public BigDecimal getKnye() {
		return knye;
	}

	/**
	 * 设置:状态 | 0=挂失 1=正常 2=注销
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * 获取:状态 | 0=挂失 1=正常 2=注销
	 */
	public String getStatus() {
		return status;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getCardtypecodeText() {
		return cardtypecodeText;
	}

	public void setCardtypecodeText(String cardtypecodeText) {
		this.cardtypecodeText = cardtypecodeText;
	}

}
