
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：LoadProjectSetResp<br>
 * 类描述：处置组套获取项目组套明细返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "处置组套获取项目组套明细返回")
public class LoadProjectSetResp extends PageQuery {
	@ApiModelProperty(value = "每日次数")
	private Integer mrcs;
	@ApiModelProperty(value = "药品组号")
	private Integer ypzh;
	@ApiModelProperty(value = "使用频次")
	private Integer sypc;
	@ApiModelProperty(value = "使用频次名称")
	private Integer sypcText;
	@ApiModelProperty(value = "药品名称")
	private String ypmc;
	@ApiModelProperty(value = "费用归并")
	private Integer fygb;
	@ApiModelProperty(value = "组套编号")
	private Integer ztbh;
	@ApiModelProperty(value = "给药途径")
	private Integer gytj;
	@ApiModelProperty(value = "给药途径名称")
	private Integer gytjText;
	@ApiModelProperty(value = "药品用法")
	private String ypyf;
	@ApiModelProperty(value = "药品用法名称")
	private String ypyfText;
	@ApiModelProperty(value = "药品单价")
	private BigDecimal ypdj;
	@ApiModelProperty(value = "药品数量")
	private Integer ypsl;
	@ApiModelProperty(value = "费用科室")
	private Integer fyks;
	@ApiModelProperty(value = "备注名称(自备药)")
	private String bzmc;
	@ApiModelProperty(value = "合计金额")
	private BigDecimal hjje;
	@ApiModelProperty(value = "药品序号")
	private Integer ypxh;
	@ApiModelProperty(value = "自负比例")
	private BigDecimal zfbl;
	@ApiModelProperty(value = "归并名称")
	private String gbmc;
	@ApiModelProperty(value = "零售价格")
	private BigDecimal lsjg;
	@ApiModelProperty(value = "药房单位")
	private String yfdw;
	@ApiModelProperty(value = "类型")
	private String type;
	@ApiModelProperty(value = "项目类型")
	private Integer xmlx;

	public Integer getMrcs() {
		return mrcs;
	}

	public void setMrcs(Integer mrcs) {
		this.mrcs = mrcs;
	}

	public Integer getYpzh() {
		return ypzh;
	}

	public void setYpzh(Integer ypzh) {
		this.ypzh = ypzh;
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

	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	public Integer getFygb() {
		return fygb;
	}

	public void setFygb(Integer fygb) {
		this.fygb = fygb;
	}

	public Integer getZtbh() {
		return ztbh;
	}

	public void setZtbh(Integer ztbh) {
		this.ztbh = ztbh;
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

	public BigDecimal getYpdj() {
		return ypdj;
	}

	public void setYpdj(BigDecimal ypdj) {
		this.ypdj = ypdj;
	}

	public Integer getYpsl() {
		return ypsl;
	}

	public void setYpsl(Integer ypsl) {
		this.ypsl = ypsl;
	}

	public Integer getFyks() {
		return fyks;
	}

	public void setFyks(Integer fyks) {
		this.fyks = fyks;
	}

	public String getBzmc() {
		return bzmc;
	}

	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}

	public BigDecimal getHjje() {
		return hjje;
	}

	public void setHjje(BigDecimal hjje) {
		this.hjje = hjje;
	}

	public Integer getYpxh() {
		return ypxh;
	}

	public void setYpxh(Integer ypxh) {
		this.ypxh = ypxh;
	}

	public BigDecimal getZfbl() {
		return zfbl;
	}

	public void setZfbl(BigDecimal zfbl) {
		this.zfbl = zfbl;
	}

	public String getGbmc() {
		return gbmc;
	}

	public void setGbmc(String gbmc) {
		this.gbmc = gbmc;
	}

	public BigDecimal getLsjg() {
		return lsjg;
	}

	public void setLsjg(BigDecimal lsjg) {
		this.lsjg = lsjg;
	}

	public String getYfdw() {
		return yfdw;
	}

	public void setYfdw(String yfdw) {
		this.yfdw = yfdw;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getXmlx() {
		return xmlx;
	}

	public void setXmlx(Integer xmlx) {
		this.xmlx = xmlx;
	}

}