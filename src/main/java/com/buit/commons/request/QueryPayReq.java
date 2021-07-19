
package com.buit.commons.request;

import java.math.BigDecimal;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryPayReq<br>
 * 类描述：查询结算请求子集合<br>
 * 
 * @author WY
 */
@ApiModel(value = "查询结算请求子集合")
public class QueryPayReq {
	@ApiModelProperty(value = "备注名称(自备药)")
	private String bzmc;
	@ApiModelProperty(value = "备注信息")
	private String bzxx;
	@ApiModelProperty(value = "处方号码 ")
	private String cfhm;
	@ApiModelProperty(value = "处方类型")
	private Integer cflx;
	@ApiModelProperty(value = "处方类型名称")
	private String cflxText;
	@ApiModelProperty(value = "处方识别")
	private Integer cfsb;
	@ApiModelProperty(value = "处方贴数")
	private Integer cfts;
	@ApiModelProperty(value = "处方")
	private String cfNew;
	@ApiModelProperty(value = "单据来源")
	private Integer djly;
	@ApiModelProperty(value = "代煎药标志")
	private Integer djybz;
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "费用归并")
	private Integer fygb;
	@ApiModelProperty(value = "归并名称")
	private String gbmc;
	@ApiModelProperty(value = "给药途径")
	private Integer gytj;
	@ApiModelProperty(value = "给药途径名称")
	private String gytjText;
	@ApiModelProperty(value = "划价金额")
	private BigDecimal hjje;
	@ApiModelProperty(value = "")
	private String jldw;
	@ApiModelProperty(value = "煎药类型")
	private Integer jylx;
	@ApiModelProperty(value = "煎药类型名称")
	private String jylxText;
	@ApiModelProperty(value = "开方日期")
	private Timestamp kfrq;
	@ApiModelProperty(value = "")
	private Integer kpdy;
	@ApiModelProperty(value = "")
	private String kpdyText;
	@ApiModelProperty(value = "抗生素标志")
	private Integer ksbz;
	@ApiModelProperty(value = "抗生素标志名称")
	private String ksbzText;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "科室名称")
	private String ksdmText;
	@ApiModelProperty(value = "每日次数")
	private Integer mrcs;
	@ApiModelProperty(value = "皮试结果")
	private Integer psjg;
	@ApiModelProperty(value = "皮试判别")
	private Integer pspb;
	@ApiModelProperty(value = "识别序号 | 唯一标示一次挂号的序号")
	private Integer sbxh;
	@ApiModelProperty(value = "审方工号")
	private String sfgh;
	@ApiModelProperty(value = "审方结果")
	private BigDecimal sfjg;
	@ApiModelProperty(value = "审方意见")
	private String sfyj;
	@ApiModelProperty(value = "")
	private Integer tsyp;
	@ApiModelProperty(value = "")
	private String tsypText;
	@ApiModelProperty(value = "类型")
	private Integer type;
	@ApiModelProperty(value = "类型名称")
	private String typeText;
	@ApiModelProperty(value = "")
	private String xmspbh;
	@ApiModelProperty(value = "一次剂量")
	private BigDecimal ycjl;
	@ApiModelProperty(value = "一次数量")
	private BigDecimal ycsl;
	@ApiModelProperty(value = "ycyl")
	private Integer ycyl;
	@ApiModelProperty(value = "药房包装")
	private Integer yfbz;
	@ApiModelProperty(value = "药房单位")
	private String yfdw;
	@ApiModelProperty(value = "药房规格")
	private String yfgg;
	@ApiModelProperty(value = "药房识别")
	private Integer yfsb;
	@ApiModelProperty(value = "药品产地")
	private Integer ypcd;
	@ApiModelProperty(value = "药品产地名称")
	private String ypcdText;
	@ApiModelProperty(value = "药品单价")
	private BigDecimal ypdj;
	@ApiModelProperty(value = "药品单价_y")
	private BigDecimal ypdjY;
	@ApiModelProperty(value = "")
	private Integer ypjl;
	@ApiModelProperty(value = "药品名称")
	private String ypmc;
	@ApiModelProperty(value = "药品数量")
	private BigDecimal ypsl;
	@ApiModelProperty(value = "药品序号")
	private Integer ypxh;
	@ApiModelProperty(value = "药品用法")
	private String ypyf;
	@ApiModelProperty(value = "药品用法名称")
	private String ypyfText;
	@ApiModelProperty(value = "药品组号")
	private Integer ypzh;
	@ApiModelProperty(value = "药品组号展示")
	private Integer ypzhShow;
	@ApiModelProperty(value = "煎法")
	private Integer ypzs;
	@ApiModelProperty(value = "煎法名称")
	private String ypzsText;
	@ApiModelProperty(value = "医生代码 ")
	private String ysdm;
	@ApiModelProperty(value = "医生代码 名称")
	private String ysdmText;
	@ApiModelProperty(value = "用药天数")
	private Integer yyts;
	@ApiModelProperty(value = "自负比例")
	private BigDecimal zfbl;
	@ApiModelProperty(value = "自负判别")
	private Integer zfpb;
	@ApiModelProperty(value = "帐户金额")
	private BigDecimal zhje;
	@ApiModelProperty(value = "折扣比例")
	private BigDecimal zkbl;
	@ApiModelProperty(value = "折扣金额")
	private BigDecimal zkje;
	@ApiModelProperty(value = "组套编号")
	private Integer ztbh;
	@ApiModelProperty(value = "执行科室")
	private Integer zxks;
	@ApiModelProperty(value = "执行科室名称")
	private String zxksText;
	@ApiModelProperty(value = "医技序号")
	private Integer yjxh;
	@ApiModelProperty(value = "减免金额")
	private BigDecimal jmje;
	@ApiModelProperty(value = "就诊流水号")
	private String jzlsh;

	public String getBzmc() {
		return bzmc;
	}

	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}

	public String getCfhm() {
		return cfhm;
	}

	public void setCfhm(String cfhm) {
		this.cfhm = cfhm;
	}

	public Integer getCflx() {
		return cflx;
	}

	public void setCflx(Integer cflx) {
		this.cflx = cflx;
	}

	public String getCflxText() {
		return cflxText;
	}

	public void setCflxText(String cflxText) {
		this.cflxText = cflxText;
	}

	public Integer getCfsb() {
		return cfsb;
	}

	public void setCfsb(Integer cfsb) {
		this.cfsb = cfsb;
	}

	public Integer getCfts() {
		return cfts;
	}

	public void setCfts(Integer cfts) {
		this.cfts = cfts;
	}

	public String getCfNew() {
		return cfNew;
	}

	public void setCfNew(String cfNew) {
		this.cfNew = cfNew;
	}

	public Integer getDjly() {
		return djly;
	}

	public void setDjly(Integer djly) {
		this.djly = djly;
	}

	public Integer getDjybz() {
		return djybz;
	}

	public void setDjybz(Integer djybz) {
		this.djybz = djybz;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
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

	public Integer getGytj() {
		return gytj;
	}

	public void setGytj(Integer gytj) {
		this.gytj = gytj;
	}

	public String getGytjText() {
		return gytjText;
	}

	public void setGytjText(String gytjText) {
		this.gytjText = gytjText;
	}

	public BigDecimal getHjje() {
		return hjje;
	}

	public void setHjje(BigDecimal hjje) {
		this.hjje = hjje;
	}

	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

	public Integer getJylx() {
		return jylx;
	}

	public void setJylx(Integer jylx) {
		this.jylx = jylx;
	}

	public String getJylxText() {
		return jylxText;
	}

	public void setJylxText(String jylxText) {
		this.jylxText = jylxText;
	}

	public Timestamp getKfrq() {
		return kfrq;
	}

	public void setKfrq(Timestamp kfrq) {
		this.kfrq = kfrq;
	}

	public Integer getKpdy() {
		return kpdy;
	}

	public void setKpdy(Integer kpdy) {
		this.kpdy = kpdy;
	}

	public String getKpdyText() {
		return kpdyText;
	}

	public void setKpdyText(String kpdyText) {
		this.kpdyText = kpdyText;
	}

	public Integer getKsbz() {
		return ksbz;
	}

	public void setKsbz(Integer ksbz) {
		this.ksbz = ksbz;
	}

	public String getKsbzText() {
		return ksbzText;
	}

	public void setKsbzText(String ksbzText) {
		this.ksbzText = ksbzText;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getKsdmText() {
		return ksdmText;
	}

	public void setKsdmText(String ksdmText) {
		this.ksdmText = ksdmText;
	}

	public Integer getMrcs() {
		return mrcs;
	}

	public void setMrcs(Integer mrcs) {
		this.mrcs = mrcs;
	}

	public Integer getPsjg() {
		return psjg;
	}

	public void setPsjg(Integer psjg) {
		this.psjg = psjg;
	}

	public Integer getPspb() {
		return pspb;
	}

	public void setPspb(Integer pspb) {
		this.pspb = pspb;
	}

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

	public String getSfgh() {
		return sfgh;
	}

	public void setSfgh(String sfgh) {
		this.sfgh = sfgh;
	}

	public BigDecimal getSfjg() {
		return sfjg;
	}

	public void setSfjg(BigDecimal sfjg) {
		this.sfjg = sfjg;
	}

	public String getSfyj() {
		return sfyj;
	}

	public void setSfyj(String sfyj) {
		this.sfyj = sfyj;
	}

	public Integer getTsyp() {
		return tsyp;
	}

	public void setTsyp(Integer tsyp) {
		this.tsyp = tsyp;
	}

	public String getTsypText() {
		return tsypText;
	}

	public void setTsypText(String tsypText) {
		this.tsypText = tsypText;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTypeText() {
		return typeText;
	}

	public void setTypeText(String typeText) {
		this.typeText = typeText;
	}

	public String getXmspbh() {
		return xmspbh;
	}

	public void setXmspbh(String xmspbh) {
		this.xmspbh = xmspbh;
	}

	public BigDecimal getYcjl() {
		return ycjl;
	}

	public void setYcjl(BigDecimal ycjl) {
		this.ycjl = ycjl;
	}

	public BigDecimal getYcsl() {
		return ycsl;
	}

	public void setYcsl(BigDecimal ycsl) {
		this.ycsl = ycsl;
	}

	public Integer getYcyl() {
		return ycyl;
	}

	public void setYcyl(Integer ycyl) {
		this.ycyl = ycyl;
	}

	public Integer getYfbz() {
		return yfbz;
	}

	public void setYfbz(Integer yfbz) {
		this.yfbz = yfbz;
	}

	public String getYfdw() {
		return yfdw;
	}

	public void setYfdw(String yfdw) {
		this.yfdw = yfdw;
	}

	public String getYfgg() {
		return yfgg;
	}

	public void setYfgg(String yfgg) {
		this.yfgg = yfgg;
	}

	public Integer getYfsb() {
		return yfsb;
	}

	public void setYfsb(Integer yfsb) {
		this.yfsb = yfsb;
	}

	public Integer getYpcd() {
		return ypcd;
	}

	public void setYpcd(Integer ypcd) {
		this.ypcd = ypcd;
	}

	public String getYpcdText() {
		return ypcdText;
	}

	public void setYpcdText(String ypcdText) {
		this.ypcdText = ypcdText;
	}

	public BigDecimal getYpdj() {
		return ypdj;
	}

	public void setYpdj(BigDecimal ypdj) {
		this.ypdj = ypdj;
	}

	public BigDecimal getYpdjY() {
		return ypdjY;
	}

	public void setYpdjY(BigDecimal ypdjY) {
		this.ypdjY = ypdjY;
	}

	public Integer getYpjl() {
		return ypjl;
	}

	public void setYpjl(Integer ypjl) {
		this.ypjl = ypjl;
	}

	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	public BigDecimal getYpsl() {
		return ypsl;
	}

	public void setYpsl(BigDecimal ypsl) {
		this.ypsl = ypsl;
	}

	public Integer getYpxh() {
		return ypxh;
	}

	public void setYpxh(Integer ypxh) {
		this.ypxh = ypxh;
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

	public Integer getYpzh() {
		return ypzh;
	}

	public void setYpzh(Integer ypzh) {
		this.ypzh = ypzh;
	}

	public Integer getYpzhShow() {
		return ypzhShow;
	}

	public void setYpzhShow(Integer ypzhShow) {
		this.ypzhShow = ypzhShow;
	}

	public Integer getYpzs() {
		return ypzs;
	}

	public void setYpzs(Integer ypzs) {
		this.ypzs = ypzs;
	}

	public String getYpzsText() {
		return ypzsText;
	}

	public void setYpzsText(String ypzsText) {
		this.ypzsText = ypzsText;
	}

	public String getYsdm() {
		return ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
	}

	public String getYsdmText() {
		return ysdmText;
	}

	public void setYsdmText(String ysdmText) {
		this.ysdmText = ysdmText;
	}

	public Integer getYyts() {
		return yyts;
	}

	public void setYyts(Integer yyts) {
		this.yyts = yyts;
	}

	public BigDecimal getZfbl() {
		return zfbl;
	}

	public void setZfbl(BigDecimal zfbl) {
		this.zfbl = zfbl;
	}

	public Integer getZfpb() {
		return zfpb;
	}

	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}

	public BigDecimal getZhje() {
		return zhje;
	}

	public void setZhje(BigDecimal zhje) {
		this.zhje = zhje;
	}

	public BigDecimal getZkbl() {
		return zkbl;
	}

	public void setZkbl(BigDecimal zkbl) {
		this.zkbl = zkbl;
	}

	public Integer getZtbh() {
		return ztbh;
	}

	public void setZtbh(Integer ztbh) {
		this.ztbh = ztbh;
	}

	public Integer getZxks() {
		return zxks;
	}

	public void setZxks(Integer zxks) {
		this.zxks = zxks;
	}

	public String getZxksText() {
		return zxksText;
	}

	public void setZxksText(String zxksText) {
		this.zxksText = zxksText;
	}

	public BigDecimal getZkje() {
		return zkje;
	}

	public void setZkje(BigDecimal zkje) {
		this.zkje = zkje;
	}

	public Integer getYjxh() {
		return yjxh;
	}

	public void setYjxh(Integer yjxh) {
		this.yjxh = yjxh;
	}

	public BigDecimal getJmje() {
		return jmje;
	}

	public void setJmje(BigDecimal jmje) {
		this.jmje = jmje;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}
}