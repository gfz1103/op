
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryRegisteredResp<br>
 * 类描述：挂号查询返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "挂号查询返回")
public class QueryRegisteredResp extends PageQuery {
	@ApiModelProperty(value = "门诊类别 ")
	private Integer mzlb;
	@ApiModelProperty(value = "真实发票号码 ")
	private String zsfphm;
	@ApiModelProperty(value = "就诊卡号 ")
	private String jzkh;
	@ApiModelProperty(value = "门诊号码")
	private String mzhm;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "病人ID")
	private Integer brid;
	@ApiModelProperty(value = "病人性质")
	private Integer brxz;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "科室名称")
	private String ksmc;
	@ApiModelProperty(value = "识别序号")
	private Integer sbxh;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "医生姓名")
	private String ysxm;
	@ApiModelProperty(value = "挂号时间")
	private Timestamp ghsj;
	@ApiModelProperty(value = "挂号费")
	private BigDecimal ghf;
	@ApiModelProperty(value = "诊疗费")
	private BigDecimal zlf;
	@ApiModelProperty(value = "专家费")
	private BigDecimal zjf;
	@ApiModelProperty(value = "病历费")
	private BigDecimal blf;
	@ApiModelProperty(value = "挂号金额")
	private BigDecimal ghje;
	@ApiModelProperty(value = "诊疗金额")
	private BigDecimal zlje;
	@ApiModelProperty(value = "病历金额")
	private BigDecimal blje;
	@ApiModelProperty(value = "总计费用")
	private BigDecimal zjfy;
	@ApiModelProperty(value = "退号标志")
	private Integer thbz;
	@ApiModelProperty(value = "现金金额")
	private BigDecimal xjje;
	@ApiModelProperty(value = "支票金额")
	private BigDecimal zpje;
	@ApiModelProperty(value = "帐户金额")
	private BigDecimal zhje;
	@ApiModelProperty(value = "其他应收")
	private BigDecimal qtys;
	@ApiModelProperty(value = "合计金额")
	private BigDecimal hjje;
	@ApiModelProperty(value = "就诊号码")
	private String jzhm;
	@ApiModelProperty(value = "挂号操作工号")
	private Integer czgh;
	@ApiModelProperty(value = "退号操作工号")
	private Integer thgh;
	@ApiModelProperty(value = "退号日期")
	private Timestamp thrq;

	@ApiModelProperty(value = "支付宝支付")
	private BigDecimal zfbje;
	@ApiModelProperty(value = "微信支付")
	private BigDecimal wxje;
	@ApiModelProperty(value = "POS机支付")
	private BigDecimal posje;

	public Integer getMzlb() {
		return mzlb;
	}

	public void setMzlb(Integer mzlb) {
		this.mzlb = mzlb;
	}

	public String getZsfphm() {
		return zsfphm;
	}

	public void setZsfphm(String zsfphm) {
		this.zsfphm = zsfphm;
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

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getYsxm() {
		return ysxm;
	}

	public void setYsxm(String ysxm) {
		this.ysxm = ysxm;
	}

	public Timestamp getGhsj() {
		return ghsj;
	}

	public void setGhsj(Timestamp ghsj) {
		this.ghsj = ghsj;
	}

	public BigDecimal getGhf() {
		return ghf;
	}

	public void setGhf(BigDecimal ghf) {
		this.ghf = ghf;
	}

	public BigDecimal getZlf() {
		return zlf;
	}

	public void setZlf(BigDecimal zlf) {
		this.zlf = zlf;
	}

	public BigDecimal getZjf() {
		return zjf;
	}

	public void setZjf(BigDecimal zjf) {
		this.zjf = zjf;
	}

	public BigDecimal getBlf() {
		return blf;
	}

	public void setBlf(BigDecimal blf) {
		this.blf = blf;
	}

	public BigDecimal getGhje() {
		return ghje;
	}

	public void setGhje(BigDecimal ghje) {
		this.ghje = ghje;
	}

	public BigDecimal getZlje() {
		return zlje;
	}

	public void setZlje(BigDecimal zlje) {
		this.zlje = zlje;
	}

	public BigDecimal getBlje() {
		return blje;
	}

	public void setBlje(BigDecimal blje) {
		this.blje = blje;
	}

	public BigDecimal getZjfy() {
		return zjfy;
	}

	public void setZjfy(BigDecimal zjfy) {
		this.zjfy = zjfy;
	}

	public Integer getThbz() {
		return thbz;
	}

	public void setThbz(Integer thbz) {
		this.thbz = thbz;
	}

	public BigDecimal getXjje() {
		return xjje;
	}

	public void setXjje(BigDecimal xjje) {
		this.xjje = xjje;
	}

	public BigDecimal getZpje() {
		return zpje;
	}

	public void setZpje(BigDecimal zpje) {
		this.zpje = zpje;
	}

	public BigDecimal getZhje() {
		return zhje;
	}

	public void setZhje(BigDecimal zhje) {
		this.zhje = zhje;
	}

	public BigDecimal getQtys() {
		return qtys;
	}

	public void setQtys(BigDecimal qtys) {
		this.qtys = qtys;
	}

	public BigDecimal getHjje() {
		return hjje;
	}

	public void setHjje(BigDecimal hjje) {
		this.hjje = hjje;
	}

	public String getJzhm() {
		return jzhm;
	}

	public void setJzhm(String jzhm) {
		this.jzhm = jzhm;
	}

	public Integer getCzgh() {
		return czgh;
	}

	public void setCzgh(Integer czgh) {
		this.czgh = czgh;
	}

	public Integer getThgh() {
		return thgh;
	}

	public void setThgh(Integer thgh) {
		this.thgh = thgh;
	}

	public Timestamp getThrq() {
		return thrq;
	}

	public void setThrq(Timestamp thrq) {
		this.thrq = thrq;
	}

	public BigDecimal getZfbje() {
		return zfbje;
	}

	public void setZfbje(BigDecimal zfbje) {
		this.zfbje = zfbje;
	}

	public BigDecimal getWxje() {
		return wxje;
	}

	public void setWxje(BigDecimal wxje) {
		this.wxje = wxje;
	}

	public BigDecimal getPosje() {
		return posje;
	}

	public void setPosje(BigDecimal posje) {
		this.posje = posje;
	}
}