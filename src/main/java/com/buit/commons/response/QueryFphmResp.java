
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 类名称：QueryFphmResp<br>
 * 类描述：发票查询返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "发票查询返回")
public class QueryFphmResp extends PageQuery {
	private static final long serialVersionUID = 1545812146988829911L;
	@ApiModelProperty(value = "门诊号码")
	private String mzhm;
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "真实发票号码 ")
	private String zsfphm;
	@ApiModelProperty(value = "病人ID")
	private Integer brid;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "病人性质")
	private Integer brxz;
	@ApiModelProperty(value = "收费员")
	private Integer ysfy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "收费日期")
	private Timestamp sfrq;
	@ApiModelProperty(value = "总金额")
	private BigDecimal zjje;
	@ApiModelProperty(value = "金额")
	private BigDecimal zfje;
	@ApiModelProperty(value = "作废判别标志 0-未作废 1-作废 2-已重打发票 3-重打作废")
	private String zfpb;
	@ApiModelProperty(value = "作废日期")
	private Timestamp zfrq;
	@ApiModelProperty(value = "结账日期")
	private Timestamp jzrq;
	@ApiModelProperty(value = "汇总日期")
	private Timestamp hzrq;
	@ApiModelProperty(value = "现金支付")
	private BigDecimal xjje;
	@ApiModelProperty(value = "支票支付")
	private BigDecimal zpje;
	@ApiModelProperty(value = "支付宝支付")
	private BigDecimal zfbje;
	@ApiModelProperty(value = "微信支付")
	private BigDecimal wxje;
	@ApiModelProperty(value = "POS机支付")
	private BigDecimal posje;
	@ApiModelProperty(value = "账户支付")
	private BigDecimal zhje;
	@ApiModelProperty(value = "其他支付")
	private BigDecimal qtys;
//	@ApiModelProperty(value = "中心号码")
//	@ApiModelProperty(value = "收费项目")
	@ApiModelProperty(value = "收费方式")
	private Integer sffs;
	@ApiModelProperty(value = "门诊类别")
	private Integer mzlb;
	@ApiModelProperty(value = "卡号")
	private String jzkh;
	@ApiModelProperty(value = "合并标志")
	private Integer hbbz;

	public String getMzhm() {
		return mzhm;
	}

	public void setMzhm(String mzhm) {
		this.mzhm = mzhm;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public String getZsfphm() {
		return zsfphm;
	}

	public void setZsfphm(String zsfphm) {
		this.zsfphm = zsfphm;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public Integer getYsfy() {
		return ysfy;
	}

	public void setYsfy(Integer ysfy) {
		this.ysfy = ysfy;
	}

	public Timestamp getSfrq() {
		return sfrq;
	}

	public void setSfrq(Timestamp sfrq) {
		this.sfrq = sfrq;
	}

	public BigDecimal getZjje() {
		return zjje;
	}

	public void setZjje(BigDecimal zjje) {
		this.zjje = zjje;
	}

	public BigDecimal getZfje() {
		return zfje;
	}

	public void setZfje(BigDecimal zfje) {
		this.zfje = zfje;
	}

	public Timestamp getZfrq() {
		return zfrq;
	}

	public void setZfrq(Timestamp zfrq) {
		this.zfrq = zfrq;
	}

	public Timestamp getJzrq() {
		return jzrq;
	}

	public void setJzrq(Timestamp jzrq) {
		this.jzrq = jzrq;
	}

	public Timestamp getHzrq() {
		return hzrq;
	}

	public void setHzrq(Timestamp hzrq) {
		this.hzrq = hzrq;
	}

	public BigDecimal getXjje() {
		return xjje;
	}

	public void setXjje(BigDecimal xjje) {
		this.xjje = xjje;
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

	public Integer getSffs() {
		return sffs;
	}

	public void setSffs(Integer sffs) {
		this.sffs = sffs;
	}

	public Integer getMzlb() {
		return mzlb;
	}

	public void setMzlb(Integer mzlb) {
		this.mzlb = mzlb;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public Integer getHbbz() {
		return hbbz;
	}

	public void setHbbz(Integer hbbz) {
		this.hbbz = hbbz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getZfpb() {
		return zfpb;
	}

	public void setZfpb(String zfpb) {
		this.zfpb = zfpb;
	}

	public BigDecimal getZpje() {
		return zpje;
	}

	public void setZpje(BigDecimal zpje) {
		this.zpje = zpje;
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