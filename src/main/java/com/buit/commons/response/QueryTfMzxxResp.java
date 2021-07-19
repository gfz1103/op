
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryTfMzxxResp<br>
 * 类描述：退费处理门诊信息返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "退费处理门诊信息返回")
public class QueryTfMzxxResp extends PageQuery {
	@ApiModelProperty(value = "发票号码 ")
	private String fphm;
	@ApiModelProperty(value = "结账日期")
	private Timestamp jzrq;
	@ApiModelProperty(value = "虚拟发票")
	private String xnfp;
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "退号判别 ")
	private Integer thpb;
	@ApiModelProperty(value = "其他应收")
	private BigDecimal qtys;
	@ApiModelProperty(value = "门诊类别")
	private Integer mzlb;
	@ApiModelProperty(value = "汇总日期")
	private Timestamp hzrq;
	@ApiModelProperty(value = "货币误差")
	private BigDecimal hbwc;
	@ApiModelProperty(value = "门诊序号")
	private Integer mzxh;
	@ApiModelProperty(value = "付款方式")
	private Integer fkfs;
	@ApiModelProperty(value = "医疗证号")
	private String fyzh;
	@ApiModelProperty(value = "基金支付")
	private BigDecimal jjzfje;
	@ApiModelProperty(value = "挂号关联 ")
	private Integer ghgl;
	@ApiModelProperty(value = "现金金额")
	private BigDecimal xjje;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "mzjzje")
	private BigDecimal mzjzje;
	@ApiModelProperty(value = "交款金额")
	private BigDecimal jkje;
	@ApiModelProperty(value = "fyetbrxz")
	private String fyetbrxz;
	@ApiModelProperty(value = "收费方式")
	private Integer sffs;
	@ApiModelProperty(value = "操作工号")
	private String czgh;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "移动出诊发票补打 ")
	private String ydczfpbd;
	@ApiModelProperty(value = "发票关联 ")
	private String fpgl;
	@ApiModelProperty(value = "退找金额")
	private BigDecimal tzje;
	@ApiModelProperty(value = "病人编号")
	private Integer brid;
	@ApiModelProperty(value = "帐户金额")
	private BigDecimal zhje;
	@ApiModelProperty(value = "个人编号")
	private String grbh;
	@ApiModelProperty(value = "移动出诊收费 ")
	private String ydczsf;
	@ApiModelProperty(value = "支票金额")
	private BigDecimal zpje;
	@ApiModelProperty(value = "总计金额")
	private BigDecimal zjje;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "自负金额")
	private BigDecimal zfje;
	@ApiModelProperty(value = "收费日期")
	private Timestamp sfrq;
	@ApiModelProperty(value = "合并标志 ")
	private Integer hbbz;
	@ApiModelProperty(value = "门诊关联")
	private Integer mzgl;
	@ApiModelProperty(value = "病人性质 ")
	private Integer brxz;
	@ApiModelProperty(value = "帐户类别 ")
	private Integer zhlb;
	@ApiModelProperty(value = "自费判别")
	private Integer zfpb;
	@ApiModelProperty(value = "fyetdjid")
	private Integer fyetdjid;
	@ApiModelProperty(value = "fyetjmje")
	private BigDecimal fyetjmje;
	@ApiModelProperty(value = "发票张数")
	private Integer fpzs;
	@ApiModelProperty(value = "坏账金额")
	private BigDecimal hzje;
	@ApiModelProperty(value = "单位序号")
	private Integer dwxh;
	@ApiModelProperty(value = "门诊就诊流水号")
	private String jzlsh;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "医生代码")
	private Integer ysdm;

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public Timestamp getJzrq() {
		return jzrq;
	}

	public void setJzrq(Timestamp jzrq) {
		this.jzrq = jzrq;
	}

	public String getXnfp() {
		return xnfp;
	}

	public void setXnfp(String xnfp) {
		this.xnfp = xnfp;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getThpb() {
		return thpb;
	}

	public void setThpb(Integer thpb) {
		this.thpb = thpb;
	}

	public BigDecimal getQtys() {
		return qtys;
	}

	public void setQtys(BigDecimal qtys) {
		this.qtys = qtys;
	}

	public Integer getMzlb() {
		return mzlb;
	}

	public void setMzlb(Integer mzlb) {
		this.mzlb = mzlb;
	}

	public Timestamp getHzrq() {
		return hzrq;
	}

	public void setHzrq(Timestamp hzrq) {
		this.hzrq = hzrq;
	}

	public BigDecimal getHbwc() {
		return hbwc;
	}

	public void setHbwc(BigDecimal hbwc) {
		this.hbwc = hbwc;
	}

	public Integer getMzxh() {
		return mzxh;
	}

	public void setMzxh(Integer mzxh) {
		this.mzxh = mzxh;
	}

	public Integer getFkfs() {
		return fkfs;
	}

	public void setFkfs(Integer fkfs) {
		this.fkfs = fkfs;
	}

	public String getFyzh() {
		return fyzh;
	}

	public void setFyzh(String fyzh) {
		this.fyzh = fyzh;
	}

	public BigDecimal getJjzfje() {
		return jjzfje;
	}

	public void setJjzfje(BigDecimal jjzfje) {
		this.jjzfje = jjzfje;
	}

	public Integer getGhgl() {
		return ghgl;
	}

	public void setGhgl(Integer ghgl) {
		this.ghgl = ghgl;
	}

	public BigDecimal getXjje() {
		return xjje;
	}

	public void setXjje(BigDecimal xjje) {
		this.xjje = xjje;
	}

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

	public BigDecimal getMzjzje() {
		return mzjzje;
	}

	public void setMzjzje(BigDecimal mzjzje) {
		this.mzjzje = mzjzje;
	}

	public BigDecimal getJkje() {
		return jkje;
	}

	public void setJkje(BigDecimal jkje) {
		this.jkje = jkje;
	}

	public String getFyetbrxz() {
		return fyetbrxz;
	}

	public void setFyetbrxz(String fyetbrxz) {
		this.fyetbrxz = fyetbrxz;
	}

	public Integer getSffs() {
		return sffs;
	}

	public void setSffs(Integer sffs) {
		this.sffs = sffs;
	}

	public String getCzgh() {
		return czgh;
	}

	public void setCzgh(String czgh) {
		this.czgh = czgh;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getYdczfpbd() {
		return ydczfpbd;
	}

	public void setYdczfpbd(String ydczfpbd) {
		this.ydczfpbd = ydczfpbd;
	}

	public String getFpgl() {
		return fpgl;
	}

	public void setFpgl(String fpgl) {
		this.fpgl = fpgl;
	}

	public BigDecimal getTzje() {
		return tzje;
	}

	public void setTzje(BigDecimal tzje) {
		this.tzje = tzje;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public BigDecimal getZhje() {
		return zhje;
	}

	public void setZhje(BigDecimal zhje) {
		this.zhje = zhje;
	}

	public String getGrbh() {
		return grbh;
	}

	public void setGrbh(String grbh) {
		this.grbh = grbh;
	}

	public String getYdczsf() {
		return ydczsf;
	}

	public void setYdczsf(String ydczsf) {
		this.ydczsf = ydczsf;
	}

	public BigDecimal getZpje() {
		return zpje;
	}

	public void setZpje(BigDecimal zpje) {
		this.zpje = zpje;
	}

	public BigDecimal getZjje() {
		return zjje;
	}

	public void setZjje(BigDecimal zjje) {
		this.zjje = zjje;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public BigDecimal getZfje() {
		return zfje;
	}

	public void setZfje(BigDecimal zfje) {
		this.zfje = zfje;
	}

	public Timestamp getSfrq() {
		return sfrq;
	}

	public void setSfrq(Timestamp sfrq) {
		this.sfrq = sfrq;
	}

	public Integer getHbbz() {
		return hbbz;
	}

	public void setHbbz(Integer hbbz) {
		this.hbbz = hbbz;
	}

	public Integer getMzgl() {
		return mzgl;
	}

	public void setMzgl(Integer mzgl) {
		this.mzgl = mzgl;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public Integer getZhlb() {
		return zhlb;
	}

	public void setZhlb(Integer zhlb) {
		this.zhlb = zhlb;
	}

	public Integer getZfpb() {
		return zfpb;
	}

	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}

	public Integer getFyetdjid() {
		return fyetdjid;
	}

	public void setFyetdjid(Integer fyetdjid) {
		this.fyetdjid = fyetdjid;
	}

	public BigDecimal getFyetjmje() {
		return fyetjmje;
	}

	public void setFyetjmje(BigDecimal fyetjmje) {
		this.fyetjmje = fyetjmje;
	}

	public Integer getFpzs() {
		return fpzs;
	}

	public void setFpzs(Integer fpzs) {
		this.fpzs = fpzs;
	}

	public BigDecimal getHzje() {
		return hzje;
	}

	public void setHzje(BigDecimal hzje) {
		this.hzje = hzje;
	}

	public Integer getDwxh() {
		return dwxh;
	}

	public void setDwxh(Integer dwxh) {
		this.dwxh = dwxh;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public Integer getYsdm() {
		return ysdm;
	}

	public void setYsdm(Integer ysdm) {
		this.ysdm = ysdm;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}
}