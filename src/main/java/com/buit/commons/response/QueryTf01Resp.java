
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryTF01Resp<br>
 * 类描述：退费信息返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "退费信息返回")
public class QueryTf01Resp extends PageQuery {
	@ApiModelProperty(value = "科室名称")
	private String ksmc;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "发票号码 ")
	private String fphm;
	@ApiModelProperty(value = "处方类型| 1:西药处方 2：中药处方 3：草药处方")
	private Integer cflx;
	@ApiModelProperty(value = "处方识别")
	private Integer cfsb;
	@ApiModelProperty(value = "登记类型名称")
	private String djlxText;
	@ApiModelProperty(value = "发药标志")
	private Integer fybz;
	@ApiModelProperty(value = "处方贴数")
	private Integer cfts;
	@ApiModelProperty(value = "医生名称")
	private String ysmc;
	@ApiModelProperty(value = "自费判别")
	private Integer zfpb;
	@ApiModelProperty(value = "单据来源")
	private Integer djly;
	@ApiModelProperty(value = "医生代码 ")
	private String ysdm;
	@ApiModelProperty(value = "备注信息")
	private String bzxx;

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public Integer getCflx() {
		return cflx;
	}

	public void setCflx(Integer cflx) {
		this.cflx = cflx;
	}

	public Integer getCfsb() {
		return cfsb;
	}

	public void setCfsb(Integer cfsb) {
		this.cfsb = cfsb;
	}

	public String getDjlxText() {
		return djlxText;
	}

	public void setDjlxText(String djlxText) {
		this.djlxText = djlxText;
	}

	public Integer getFybz() {
		return fybz;
	}

	public void setFybz(Integer fybz) {
		this.fybz = fybz;
	}

	public Integer getCfts() {
		return cfts;
	}

	public void setCfts(Integer cfts) {
		this.cfts = cfts;
	}

	public String getYsmc() {
		return ysmc;
	}

	public void setYsmc(String ysmc) {
		this.ysmc = ysmc;
	}

	public Integer getZfpb() {
		return zfpb;
	}

	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}

	public Integer getDjly() {
		return djly;
	}

	public void setDjly(Integer djly) {
		this.djly = djly;
	}

	public String getYsdm() {
		return ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}
}
