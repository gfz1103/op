
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MzfpBaseResp<br>
 * 类描述：收费结算发票打印基本信息返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "收费结算发票打印基本信息返回")
public class MzfpBaseResp extends PageQuery {
	private static final long serialVersionUID = 2103597545259185319L;
	@ApiModelProperty(value = "F")
	private String F;
	@ApiModelProperty(value = "B")
	private String B;
	@ApiModelProperty(value = "J")
	private String J;
	@ApiModelProperty(value = "W")
	private String W;
	@ApiModelProperty(value = "Q")
	private String Q;
	@ApiModelProperty(value = "SW")
	private String SW;
	@ApiModelProperty(value = "S")
	private String S;
	@ApiModelProperty(value = "Y")
	private String Y;
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "虚拟发票")
	private String xnfp;
	@ApiModelProperty(value = "机构名称")
	private String jgmc;
	@ApiModelProperty(value = "打印时间")
	private Timestamp yyyy;
	@ApiModelProperty(value = "发票付款名称")
	private String fpfkmc;
	@ApiModelProperty(value = "姓名")
	private String xm;
	@ApiModelProperty(value = "pos金额")
	private BigDecimal posje;
	@ApiModelProperty(value = "其他应收")
	private String jz;
	@ApiModelProperty(value = "发药窗口")
	private String fyck;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "门诊号码")
	private String xlh;
	@ApiModelProperty(value = "就诊卡号")
	private String shbzk;
	@ApiModelProperty(value = "页码")
	private String page;
	@ApiModelProperty(value = "费别")
	private String jsfs;
	@ApiModelProperty(value = "找回金额")
	private BigDecimal tzje;
	@ApiModelProperty(value = "支付宝金额")
	private BigDecimal zfbje;
	@ApiModelProperty(value = "收费员名称")
	private String sfy;
	@ApiModelProperty(value = "收费员工号")
	private String sfygh;
	@ApiModelProperty(value = "发票付款方式")
	private Integer fpfkfs;
	@ApiModelProperty(value = "医生姓名")
	private String ysxm;
	@ApiModelProperty(value = "医生代码")
	private Integer ysdm;
	@ApiModelProperty(value = "收款金额")
	private BigDecimal jkje;
	@ApiModelProperty(value = "应收金额|总额")
	private BigDecimal fpfkje;


	@ApiModelProperty(value = "自负")
	private BigDecimal hjje;
	@ApiModelProperty(value = "医院减免金额|优惠")
	private BigDecimal jmje;
	@ApiModelProperty(value = "现金金额|实际金额")
	private BigDecimal grjf;
	@ApiModelProperty(value = "个人支付")
	private BigDecimal grzf;
	@ApiModelProperty(value = "个人账户支付")
	private BigDecimal grzhzf;
	@ApiModelProperty(value = "医保统筹支付")
	private BigDecimal ybtczf;
	@ApiModelProperty(value = "附加支付")
	private BigDecimal fjzf;
	@ApiModelProperty(value = "现金支付")
	private String xjzf;
	@ApiModelProperty(value = "分类自负")
	private BigDecimal flzf;
	@ApiModelProperty(value = "自负")
	private BigDecimal zf;
	@ApiModelProperty(value = "自费")
	private BigDecimal zifei;
	@ApiModelProperty(value = "当年账户余额")
	private BigDecimal dnzhye;
	@ApiModelProperty(value = "历年账户余额")
	private BigDecimal lnzhye;

	@ApiModelProperty(value = "中心流水号")
	private String zxlsh;

	@ApiModelProperty(value = "收费员")
	private Integer uid;
	@ApiModelProperty(value = "")
	private String xjzfFlzf;
	@ApiModelProperty(value = "")
	private String xjzfZifei;

	public String getF() {
		return F;
	}

	public void setF(String f) {
		F = f;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getJ() {
		return J;
	}

	public void setJ(String j) {
		J = j;
	}

	public String getW() {
		return W;
	}

	public void setW(String w) {
		W = w;
	}

	public String getQ() {
		return Q;
	}

	public void setQ(String q) {
		Q = q;
	}

	public String getSW() {
		return SW;
	}

	public void setSW(String sW) {
		SW = sW;
	}

	public String getS() {
		return S;
	}

	public void setS(String s) {
		S = s;
	}

	public String getY() {
		return Y;
	}

	public void setY(String y) {
		Y = y;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public String getXnfp() {
		return xnfp;
	}

	public void setXnfp(String xnfp) {
		this.xnfp = xnfp;
	}

	public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public Timestamp getYyyy() {
		return yyyy;
	}

	public void setYyyy(Timestamp yyyy) {
		this.yyyy = yyyy;
	}

	public String getFpfkmc() {
		return fpfkmc;
	}

	public void setFpfkmc(String fpfkmc) {
		this.fpfkmc = fpfkmc;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public BigDecimal getPosje() {
		return posje;
	}

	public void setPosje(BigDecimal posje) {
		this.posje = posje;
	}

	public String getJz() {
		return jz;
	}

	public void setJz(String jz) {
		this.jz = jz;
	}

	public String  getFyck() {
		return fyck;
	}

	public void setFyck(String fyck) {
		this.fyck = fyck;
	}

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

	public String getXlh() {
		return xlh;
	}

	public void setXlh(String xlh) {
		this.xlh = xlh;
	}

	public BigDecimal getJkje() {
		return jkje;
	}

	public void setJkje(BigDecimal jkje) {
		this.jkje = jkje;
	}

	public String getShbzk() {
		return shbzk;
	}

	public void setShbzk(String shbzk) {
		this.shbzk = shbzk;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public BigDecimal getFpfkje() {
		return fpfkje;
	}

	public void setFpfkje(BigDecimal fpfkje) {
		this.fpfkje = fpfkje;
	}

	public String getJsfs() {
		return jsfs;
	}

	public void setJsfs(String jsfs) {
		this.jsfs = jsfs;
	}

	public BigDecimal getTzje() {
		return tzje;
	}

	public void setTzje(BigDecimal tzje) {
		this.tzje = tzje;
	}

	public BigDecimal getGrjf() {
		return grjf;
	}

	public void setGrjf(BigDecimal grjf) {
		this.grjf = grjf;
	}

	public BigDecimal getZfbje() {
		return zfbje;
	}

	public void setZfbje(BigDecimal zfbje) {
		this.zfbje = zfbje;
	}

	public BigDecimal getHjje() {
		return hjje;
	}

	public void setHjje(BigDecimal hjje) {
		this.hjje = hjje;
	}

	public String getSfy() {
		return sfy;
	}

	public void setSfy(String sfy) {
		this.sfy = sfy;
	}

	public BigDecimal getJmje() {
		return jmje;
	}

	public void setJmje(BigDecimal jmje) {
		this.jmje = jmje;
	}

	public Integer getFpfkfs() {
		return fpfkfs;
	}

	public void setFpfkfs(Integer fpfkfs) {
		this.fpfkfs = fpfkfs;
	}

	public String getYsxm() {
		return ysxm;
	}

	public void setYsxm(String ysxm) {
		this.ysxm = ysxm;
	}

	public Integer getYsdm() {
		return ysdm;
	}

	public void setYsdm(Integer ysdm) {
		this.ysdm = ysdm;
	}

	public BigDecimal getGrzhzf() {
		return grzhzf;
	}

	public void setGrzhzf(BigDecimal grzhzf) {
		this.grzhzf = grzhzf;
	}

	public BigDecimal getYbtczf() {
		return ybtczf;
	}

	public void setYbtczf(BigDecimal ybtczf) {
		this.ybtczf = ybtczf;
	}

	public BigDecimal getFjzf() {
		return fjzf;
	}

	public void setFjzf(BigDecimal fjzf) {
		this.fjzf = fjzf;
	}

	public BigDecimal getFlzf() {
		return flzf;
	}

	public void setFlzf(BigDecimal flzf) {
		this.flzf = flzf;
	}

	public BigDecimal getZifei() {
		return zifei;
	}

	public void setZifei(BigDecimal zifei) {
		this.zifei = zifei;
	}

	public BigDecimal getDnzhye() {
		return dnzhye;
	}

	public void setDnzhye(BigDecimal dnzhye) {
		this.dnzhye = dnzhye;
	}

	public BigDecimal getLnzhye() {
		return lnzhye;
	}

	public void setLnzhye(BigDecimal lnzhye) {
		this.lnzhye = lnzhye;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getXjzfFlzf() {
		return xjzfFlzf;
	}

	public void setXjzfFlzf(String xjzfFlzf) {
		this.xjzfFlzf = xjzfFlzf;
	}

	public String getXjzfZifei() {
		return xjzfZifei;
	}

	public void setXjzfZifei(String xjzfZifei) {
		this.xjzfZifei = xjzfZifei;
	}

	public BigDecimal getGrzf() {
		return grzf;
	}

	public void setGrzf(BigDecimal grzf) {
		this.grzf = grzf;
	}

	public BigDecimal getZf() {
		return zf;
	}

	public void setZf(BigDecimal zf) {
		this.zf = zf;
	}

	public String getZxlsh() {
		return zxlsh;
	}

	public void setZxlsh(String zxlsh) {
		this.zxlsh = zxlsh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSfygh() {
		return sfygh;
	}

	public void setSfygh(String sfygh) {
		this.sfygh = sfygh;
	}

	public String getXjzf() {
		return xjzf;
	}

	public void setXjzf(String xjzf) {
		this.xjzf = xjzf;
	}
}