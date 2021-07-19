
package com.buit.commons.response;

import java.sql.Date;

import com.buit.commons.PageQuery;
import com.buit.op.model.OpGhmx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsRegisterResp<br>
 * 类描述：挂号返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "挂号返回")
public class MsRegisterResp extends PageQuery {
	private static final long serialVersionUID = 8279003876201052535L;
	@ApiModelProperty(value = "挂号明细")
	private OpGhmx opghmx;
	@ApiModelProperty(value = "就诊号码")
	private String jzhm;
	@ApiModelProperty(value = "识别序号")
	private Integer sbxh;
	@ApiModelProperty(value = "出生年月")
	private Date csny;

	public OpGhmx getMsghmx() {
		return opghmx;
	}

	public void setMsghmx(OpGhmx opghmx) {
		this.opghmx = opghmx;
	}

	public String getJzhm() {
		return jzhm;
	}

	public void setJzhm(String jzhm) {
		this.jzhm = jzhm;
	}

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

	public Date getCsny() {
		return csny;
	}

	public void setCsny(Date csny) {
		this.csny = csny;
	}

}
