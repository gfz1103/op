
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：GetAnAppointResp<br>
 * 类描述：调入卡号查询预约信息返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "调入卡号查询预约信息返回")
public class GetAnAppointResp extends PageQuery {
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "门诊号码")
	private String mzhm;
	@ApiModelProperty(value = "叫号号码")
	private String jhhm;
	@ApiModelProperty(value = "科室名称")
	private String ksdmText;
	@ApiModelProperty(value = "医生代码")
	private String ysdm;
	@ApiModelProperty(value = "预约序号")
	private Integer yyxh;
	@ApiModelProperty(value = "预约来源")
	private String yyly;
	@ApiModelProperty(value = "当前预约科室是否排班")
	private boolean isExistKspb;
	@ApiModelProperty(value = "当前预约科室医生是否排班")
	private boolean isExistYspb;

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public String getMzhm() {
		return mzhm;
	}

	public void setMzhm(String mzhm) {
		this.mzhm = mzhm;
	}

	public String getJhhm() {
		return jhhm;
	}

	public void setJhhm(String jhhm) {
		this.jhhm = jhhm;
	}

	public String getKsdmText() {
		return ksdmText;
	}

	public void setKsdmText(String ksdmText) {
		this.ksdmText = ksdmText;
	}

	public String getYsdm() {
		return ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
	}

	public Integer getYyxh() {
		return yyxh;
	}

	public void setYyxh(Integer yyxh) {
		this.yyxh = yyxh;
	}

	public boolean isExistKspb() {
		return isExistKspb;
	}

	public void setExistKspb(boolean isExistKspb) {
		this.isExistKspb = isExistKspb;
	}

	public boolean isExistYspb() {
		return isExistYspb;
	}

	public void setExistYspb(boolean isExistYspb) {
		this.isExistYspb = isExistYspb;
	}

	public String getYyly() {
		return yyly;
	}

	public void setYyly(String yyly) {
		this.yyly = yyly;
	}
}