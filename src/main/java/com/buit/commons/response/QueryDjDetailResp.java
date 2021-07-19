
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryDjDetailResp<br>
 * 类描述：单据明细信息查询返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "单据明细信息查询返回")
public class QueryDjDetailResp extends PageQuery {
	private static final long serialVersionUID = -5326688968807164474L;
	@ApiModelProperty(value = "组套编号")
	private Integer ztbh;
	@ApiModelProperty(value = "病人编号")
	private Integer brid;
	@ApiModelProperty(value = "医技序号")
	private Integer yjxh;
	@ApiModelProperty(value = "药品组号")
	private Integer ypzh;
	@ApiModelProperty(value = "单据类型名称")
	private String djlxText;
	@ApiModelProperty(value = "识别序号 ")
	private Integer sbxh;
	@ApiModelProperty(value = "药品序号")
	private Integer ypxh;
	@ApiModelProperty(value = "药品名称")
	private String ypmc;
	@ApiModelProperty(value = "处方号码 ")
	private String cfhm;
	@ApiModelProperty(value = "开方日期")
	private Timestamp kfrq;
	@ApiModelProperty(value = "处方类型")
	private Integer cflx;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "医生代码 ")
	private String ysdm;
	@ApiModelProperty(value = "单据来源")
	private Integer djly;
	@ApiModelProperty(value = "药房单位")
	private String yfdw;
	@ApiModelProperty(value = "处方识别")
	private Integer cfsb;
	@ApiModelProperty(value = "药房规格")
	private String yfgg;
	@ApiModelProperty(value = "药品单价")
	private BigDecimal ypdj;
	@ApiModelProperty(value = "药品单价")
	private BigDecimal ypdjY;
	@ApiModelProperty(value = "药品数量")
	private BigDecimal ypsl;
	@ApiModelProperty(value = "发药标志 | 0：未发药处方 1：已发药处方 3：退药处方")
	private Integer fybz;
	@ApiModelProperty(value = "划价金额")
	private BigDecimal hjje;
	@ApiModelProperty(value = "自负比例")
	private BigDecimal zfbl;
	@ApiModelProperty(value = "药品用法")
	private String ypyf;
	@ApiModelProperty(value = "费用归并")
	private Integer fygb;
	@ApiModelProperty(value = "名称缩写")
	private String gbmc;
	@ApiModelProperty(value = "处方贴数")
	private Integer cfts;
	@ApiModelProperty(value = "一次数量")
	private BigDecimal ycsl;
	@ApiModelProperty(value = "执行次数")
	private Integer zxcs;
	@ApiModelProperty(value = "自负判别")
	private Integer zfpb;
	@ApiModelProperty(value = "执行科室")
	private Integer zxks;
	@ApiModelProperty(value = "折扣比例")
	private BigDecimal zkbl;
	@ApiModelProperty(value = "折扣比例")
	private BigDecimal zkje;
	@ApiModelProperty(value = "帐户金额")
	private BigDecimal zhje;
	@ApiModelProperty(value = "药品产地")
	private Integer ypcd;
	@ApiModelProperty(value = "代煎药标志")
	private Integer djybz;
	@ApiModelProperty(value = "药房识别")
	private Integer yfsb;
	@ApiModelProperty(value = "审方结果")
	private BigDecimal sfjg;
	@ApiModelProperty(value = "药品组合排序只做展示使用")
	private Integer ypzhSort;
	@ApiModelProperty(value = "门诊就诊流水号")
	private String jzlsh;
	@ApiModelProperty(value = "减免金额")
	private BigDecimal jmje;

	public Integer getZxcs() {
		return zxcs;
	}

	public void setZxcs(Integer zxcs) {
		this.zxcs = zxcs;
	}

	public Integer getFybz() {
		return fybz;
	}

	public void setFybz(Integer fybz) {
		this.fybz = fybz;
	}

	public Integer getZtbh() {
		return ztbh;
	}

	public void setZtbh(Integer ztbh) {
		this.ztbh = ztbh;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public Integer getYjxh() {
		return yjxh;
	}

	public void setYjxh(Integer yjxh) {
		this.yjxh = yjxh;
	}

	public Integer getYpzh() {
		return ypzh;
	}

	public void setYpzh(Integer ypzh) {
		this.ypzh = ypzh;
	}

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

	public Integer getYpxh() {
		return ypxh;
	}

	public void setYpxh(Integer ypxh) {
		this.ypxh = ypxh;
	}

	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	public String getCfhm() {
		return cfhm;
	}

	public void setCfhm(String cfhm) {
		this.cfhm = cfhm;
	}

	public Timestamp getKfrq() {
		return kfrq;
	}

	public void setKfrq(Timestamp kfrq) {
		this.kfrq = kfrq;
	}

	public Integer getCflx() {
		return cflx;
	}

	public void setCflx(Integer cflx) {
		this.cflx = cflx;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getYsdm() {
		return ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
	}

	public Integer getDjly() {
		return djly;
	}

	public void setDjly(Integer djly) {
		this.djly = djly;
	}

	public String getYfdw() {
		return yfdw;
	}

	public void setYfdw(String yfdw) {
		this.yfdw = yfdw;
	}

	public Integer getCfsb() {
		return cfsb;
	}

	public void setCfsb(Integer cfsb) {
		this.cfsb = cfsb;
	}

	public String getYfgg() {
		return yfgg;
	}

	public void setYfgg(String yfgg) {
		this.yfgg = yfgg;
	}

	public BigDecimal getYpdj() {
		return ypdj;
	}

	public void setYpdj(BigDecimal ypdj) {
		this.ypdj = ypdj;
	}

	public BigDecimal getYpsl() {
		return ypsl;
	}

	public void setYpsl(BigDecimal ypsl) {
		this.ypsl = ypsl;
	}

	public BigDecimal getHjje() {
		return hjje;
	}

	public void setHjje(BigDecimal hjje) {
		this.hjje = hjje;
	}

	public BigDecimal getZfbl() {
		return zfbl;
	}

	public void setZfbl(BigDecimal zfbl) {
		this.zfbl = zfbl;
	}

	public String getYpyf() {
		return ypyf;
	}

	public void setYpyf(String ypyf) {
		this.ypyf = ypyf;
	}

	public Integer getFygb() {
		return fygb;
	}

	public void setFygb(Integer fygb) {
		this.fygb = fygb;
	}

	public String getGbmc() {
		return gbmc;
	}

	public void setGbmc(String gbmc) {
		this.gbmc = gbmc;
	}

	public Integer getCfts() {
		return cfts;
	}

	public void setCfts(Integer cfts) {
		this.cfts = cfts;
	}

	public BigDecimal getYcsl() {
		return ycsl;
	}

	public void setYcsl(BigDecimal ycsl) {
		this.ycsl = ycsl;
	}

	public Integer getZfpb() {
		return zfpb;
	}

	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}

	public Integer getZxks() {
		return zxks;
	}

	public void setZxks(Integer zxks) {
		this.zxks = zxks;
	}

	public BigDecimal getZkbl() {
		return zkbl;
	}

	public void setZkbl(BigDecimal zkbl) {
		this.zkbl = zkbl;
	}

	public BigDecimal getZhje() {
		return zhje;
	}

	public void setZhje(BigDecimal zhje) {
		this.zhje = zhje;
	}

	public Integer getYpcd() {
		return ypcd;
	}

	public void setYpcd(Integer ypcd) {
		this.ypcd = ypcd;
	}

	public Integer getDjybz() {
		return djybz;
	}

	public void setDjybz(Integer djybz) {
		this.djybz = djybz;
	}

	public Integer getYfsb() {
		return yfsb;
	}

	public void setYfsb(Integer yfsb) {
		this.yfsb = yfsb;
	}

	public BigDecimal getSfjg() {
		return sfjg;
	}

	public void setSfjg(BigDecimal sfjg) {
		this.sfjg = sfjg;
	}

	public String getDjlxText() {
		return djlxText;
	}

	public void setDjlxText(String djlxText) {
		this.djlxText = djlxText;
	}

	public BigDecimal getYpdjY() {
		return ypdjY;
	}

	public void setYpdjY(BigDecimal ypdjY) {
		this.ypdjY = ypdjY;
	}

	public Integer getYpzhSort() {
		return ypzhSort;
	}

	public void setYpzhSort(Integer ypzhSort) {
		this.ypzhSort = ypzhSort;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public BigDecimal getJmje() {
		return jmje;
	}

	public void setJmje(BigDecimal jmje) {
		this.jmje = jmje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BigDecimal getZkje() {
		return zkje;
	}

	public void setZkje(BigDecimal zkje) {
		this.zkje = zkje;
	}
}