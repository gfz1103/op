
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：LoadMedcineSetResp<br>
 * 类描述：处方组套查询返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "处方组套查询返回")
public class LoadMedcineSetResp extends PageQuery {
	@ApiModelProperty(value = "药房识别")
	private Integer pharmId;
	@ApiModelProperty(value = "药品序号")
	private Integer medId;
	@ApiModelProperty(value = "药品产地")
	private Integer medsource;
	@ApiModelProperty(value = "项目数量")
	private Integer quantity;
	@ApiModelProperty(value = "零售价格")
	private BigDecimal lsjg;
	@ApiModelProperty(value = "药品名称")
	private String ypmc;
	@ApiModelProperty(value = "药品组号")
	private Integer ypzh;
	@ApiModelProperty(value = "一次剂量")
	private BigDecimal ycjl;
	@ApiModelProperty(value = "用药天数")
	private Integer yyts;
	@ApiModelProperty(value = "药品数量")
	private Integer ypsl;
	@ApiModelProperty(value = "合计金额")
	private BigDecimal hjje;
	@ApiModelProperty(value = "药品用法")
	private String ypyf;
	@ApiModelProperty(value = "药品用法名称")
	private String ypyfText;
	@ApiModelProperty(value = "给药途径")
	private Integer gytj;
	@ApiModelProperty(value = "给药途径名称")
	private Integer gytjText;
	@ApiModelProperty(value = "备注名称(自备药)")
	private String bzmc;
	@ApiModelProperty(value = "每日次数")
	private Integer mrcs;
	@ApiModelProperty(value = "使用频次")
	private Integer sypc;
	@ApiModelProperty(value = "使用频次名称")
	private Integer sypcText;
	@ApiModelProperty(value = "自负比例")
	private BigDecimal zfbl;
	@ApiModelProperty(value = "组套编号")
	private Integer ztbh;

	public Integer getPharmId() {
		return pharmId;
	}

	public void setPharmId(Integer pharmId) {
		this.pharmId = pharmId;
	}

	public Integer getMedId() {
		return medId;
	}

	public void setMedId(Integer medId) {
		this.medId = medId;
	}

	public Integer getMedsource() {
		return medsource;
	}

	public void setMedsource(Integer medsource) {
		this.medsource = medsource;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getLsjg() {
		return lsjg;
	}

	public void setLsjg(BigDecimal lsjg) {
		this.lsjg = lsjg;
	}

	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	public Integer getYpzh() {
		return ypzh;
	}

	public void setYpzh(Integer ypzh) {
		this.ypzh = ypzh;
	}

	public BigDecimal getYcjl() {
		return ycjl;
	}

	public void setYcjl(BigDecimal ycjl) {
		this.ycjl = ycjl;
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

	public BigDecimal getHjje() {
		return hjje;
	}

	public void setHjje(BigDecimal hjje) {
		this.hjje = hjje;
	}

	public String getYpyf() {
		return ypyf;
	}

	public void setYpyf(String ypyf) {
		this.ypyf = ypyf;
	}

	public String getYpyfText() {
		return ypyfText;
	}

	public void setYpyfText(String ypyfText) {
		this.ypyfText = ypyfText;
	}

	public Integer getGytj() {
		return gytj;
	}

	public void setGytj(Integer gytj) {
		this.gytj = gytj;
	}

	public Integer getGytjText() {
		return gytjText;
	}

	public void setGytjText(Integer gytjText) {
		this.gytjText = gytjText;
	}

	public String getBzmc() {
		return bzmc;
	}

	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}

	public Integer getMrcs() {
		return mrcs;
	}

	public void setMrcs(Integer mrcs) {
		this.mrcs = mrcs;
	}

	public Integer getSypc() {
		return sypc;
	}

	public void setSypc(Integer sypc) {
		this.sypc = sypc;
	}

	public Integer getSypcText() {
		return sypcText;
	}

	public void setSypcText(Integer sypcText) {
		this.sypcText = sypcText;
	}

	public BigDecimal getZfbl() {
		return zfbl;
	}

	public void setZfbl(BigDecimal zfbl) {
		this.zfbl = zfbl;
	}

	public Integer getZtbh() {
		return ztbh;
	}

	public void setZtbh(Integer ztbh) {
		this.ztbh = ztbh;
	}

}