
package com.buit.commons.response;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryDjCfListResp<br>
 * 类描述：查询病人已收费、已发药、未输液的输液处方返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "输液注射工作量统计每日输液数据返回")
public class QueryDjCfListResp {
	@ApiModelProperty(value = "输液序号")
	private Integer xh;
	@ApiModelProperty(value = "登记时间")
	private Timestamp djsj;
	@ApiModelProperty(value = "药品名称")
	private String ypmc;
	@ApiModelProperty(value = "药品规格")
	private String ypgg;
	@ApiModelProperty(value = "药品产地")
	private Integer ypcd;
	@ApiModelProperty(value = "药品剂量")
	private Integer ypjl;
	@ApiModelProperty(value = "药品剂量")
	private String jldw;
	@ApiModelProperty(value = "使用频次")
	private String sypc;
	@ApiModelProperty(value = "给药途径")
	private Integer gytj;
	@ApiModelProperty(value = "用药天数")
	private Integer yyts;
	@ApiModelProperty(value = "药品数量")
	private Integer ypsl;
	@ApiModelProperty(value = "医生代码")
	private Integer ysdm;
	@ApiModelProperty(value = "备注说明")
	private String bzmc;
	@ApiModelProperty(value = "完成时间")
	private Timestamp wcsj;
	@ApiModelProperty(value = "处方号码")
	private Integer cfhm;
	@ApiModelProperty(value = "处方组号")
	private Integer cfzh;

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public Timestamp getDjsj() {
		return djsj;
	}

	public void setDjsj(Timestamp djsj) {
		this.djsj = djsj;
	}

	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	public String getYpgg() {
		return ypgg;
	}

	public void setYpgg(String ypgg) {
		this.ypgg = ypgg;
	}

	public Integer getYpcd() {
		return ypcd;
	}

	public void setYpcd(Integer ypcd) {
		this.ypcd = ypcd;
	}

	public Integer getYpjl() {
		return ypjl;
	}

	public void setYpjl(Integer ypjl) {
		this.ypjl = ypjl;
	}

	public String getSypc() {
		return sypc;
	}

	public void setSypc(String sypc) {
		this.sypc = sypc;
	}

	public Integer getGytj() {
		return gytj;
	}

	public void setGytj(Integer gytj) {
		this.gytj = gytj;
	}

	public Integer getYyts() {
		return yyts;
	}

	public void setYyts(Integer yyts) {
		this.yyts = yyts;
	}

	public Integer getYpsl() {
		return ypsl;
	}

	public void setYpsl(Integer ypsl) {
		this.ypsl = ypsl;
	}

	public Integer getYsdm() {
		return ysdm;
	}

	public void setYsdm(Integer ysdm) {
		this.ysdm = ysdm;
	}

	public String getBzmc() {
		return bzmc;
	}

	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}

	public Timestamp getWcsj() {
		return wcsj;
	}

	public void setWcsj(Timestamp wcsj) {
		this.wcsj = wcsj;
	}

	public Integer getCfhm() {
		return cfhm;
	}

	public void setCfhm(Integer cfhm) {
		this.cfhm = cfhm;
	}

	public Integer getCfzh() {
		return cfzh;
	}

	public void setCfzh(Integer cfzh) {
		this.cfzh = cfzh;
	}

	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

}