
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsCfInfoResp<br>
 * 类描述：处方信息<br>
 * 
 * @author WY
 */
@ApiModel(value = "处方信息")
public class MsCfInfoResp extends PageQuery {
	@ApiModelProperty(value = "挂号科室")
	private Integer ghks;
	@ApiModelProperty(value = "挂号识别")
	private Integer ghsb;
	@ApiModelProperty(value = "有效期")
	private Integer xq;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "处方类型| 1:西药处方 2：中药处方 3：草药处方")
	private Integer cflx;
	@ApiModelProperty(value = "登记类型名称")
	private String djlxText;
	@ApiModelProperty(value = "开单日期")
	private Timestamp kdrq;
	@ApiModelProperty(value = "开单科室")
	private Integer kdks;
	@ApiModelProperty(value = "开单医生")
	private Integer kdys;
	@ApiModelProperty(value = "处方识别")
	private Integer cfsb;
	@ApiModelProperty(value = "执行科室")
	private Integer zxks;
	@ApiModelProperty(value = "划价金额")
	private BigDecimal hjje;
	@ApiModelProperty(value = "历史标志")
	private Integer lsbz;
	@ApiModelProperty(value = "就诊序号")
	private Integer jzxh;
	@ApiModelProperty(value = "门诊就诊流水号")
	private String jzlsh;
	@ApiModelProperty(value = "单据来源")
	private Integer djly;
	@ApiModelProperty(value = "单据来源名称")
	private String djlyText;

	public Integer getGhks() {
		return ghks;
	}

	public void setGhks(Integer ghks) {
		this.ghks = ghks;
	}

	public Integer getGhsb() {
		return ghsb;
	}

	public void setGhsb(Integer ghsb) {
		this.ghsb = ghsb;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Integer getCflx() {
		return cflx;
	}

	public void setCflx(Integer cflx) {
		this.cflx = cflx;
	}

	public Integer getXq() {
		return xq;
	}

	public void setXq(Integer xq) {
		this.xq = xq;
	}

	public String getDjlxText() {
		return djlxText;
	}

	public void setDjlxText(String djlxText) {
		this.djlxText = djlxText;
	}

	public String getDjlyText() {
		return djlyText;
	}

	public void setDjlyText(String djlyText) {
		this.djlyText = djlyText;
	}

	public Timestamp getKdrq() {
		return kdrq;
	}

	public void setKdrq(Timestamp kdrq) {
		this.kdrq = kdrq;
	}

	public Integer getKdks() {
		return kdks;
	}

	public void setKdks(Integer kdks) {
		this.kdks = kdks;
	}

	public Integer getKdys() {
		return kdys;
	}

	public void setKdys(Integer kdys) {
		this.kdys = kdys;
	}

	public Integer getCfsb() {
		return cfsb;
	}

	public void setCfsb(Integer cfsb) {
		this.cfsb = cfsb;
	}

	public Integer getZxks() {
		return zxks;
	}

	public void setZxks(Integer zxks) {
		this.zxks = zxks;
	}

	public BigDecimal getHjje() {
		return hjje;
	}

	public void setHjje(BigDecimal hjje) {
		this.hjje = hjje;
	}

	public Integer getLsbz() {
		return lsbz;
	}

	public void setLsbz(Integer lsbz) {
		this.lsbz = lsbz;
	}

	public Integer getJzxh() {
		return jzxh;
	}

	public void setJzxh(Integer jzxh) {
		this.jzxh = jzxh;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public Integer getDjly() {
		return djly;
	}

	public void setDjly(Integer djly) {
		this.djly = djly;
	}

}