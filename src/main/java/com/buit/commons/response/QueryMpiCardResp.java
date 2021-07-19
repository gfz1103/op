package com.buit.commons.response;

import java.util.Date;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryMPICardResp<br>
 * 类描述：卡号查询卡信息返回
 * 
 * @author wy
 * 
 */
@ApiModel(value = "卡号查询卡信息返回")
public class QueryMpiCardResp extends PageQuery {
	@ApiModelProperty(value = "病人ID")
	private Integer brid;
	@ApiModelProperty(value = "卡类型 | 01=健康卡 02=市民卡 03=医保卡 09=其他卡")
	private String cardtypecode;
	@ApiModelProperty(value = "卡号")
	private String cardno;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "身份证号")
	private String idcard;
	@ApiModelProperty(value = "登记时间")
	private Date fksj;
	@ApiModelProperty(value = "状态 | 0=正常 1=挂失 2=注销")
	private String status;
	@ApiModelProperty(value = "卡表主键")
	private String cardid;

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public String getCardtypecode() {
		return cardtypecode;
	}

	public void setCardtypecode(String cardtypecode) {
		this.cardtypecode = cardtypecode;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Date getFksj() {
		return fksj;
	}

	public void setFksj(Date fksj) {
		this.fksj = fksj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

}