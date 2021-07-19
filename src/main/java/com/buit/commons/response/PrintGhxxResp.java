
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：PrintGhxxResp<br>
 * 类描述：挂号打印返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "挂号打印返回")
public class PrintGhxxResp extends PageQuery {
	private static final long serialVersionUID = 7036741740822122438L;
	@ApiModelProperty(value = "科室名称")
	private String ksmc;
	@ApiModelProperty(value = "科室位置  OP_GHMX中ddxx")
	private String kswz;
	@ApiModelProperty(value = "就诊序号")
	private String jzxh;
	@ApiModelProperty(value = "社会保障卡 OP_GHMX中jzkh")
	private String shbzk;
	@ApiModelProperty(value = "就诊号码")
	private String jzhm;
	@ApiModelProperty(value = "医保类型  PUB_BRXZ中病人性质")
	private String yblx;
	@JsonIgnore
	@ApiModelProperty(value = "就诊记录序号")
	private String jzjlxh;
	@ApiModelProperty(value = "检查费  OP_GHMX中ghje")
	private BigDecimal jcf;
	@ApiModelProperty(value = "专家费")
	private BigDecimal zjfy;
	@ApiModelProperty(value = "减免金额")
	private BigDecimal jmje;
	@ApiModelProperty(value = "诊疗费")
	private BigDecimal zlf;
	@ApiModelProperty(value = "其他费")
	private BigDecimal qtf;
	@ApiModelProperty(value = "挂号类别")
	private String ghlb;
	@ApiModelProperty(value = "合计金额")
	private BigDecimal hjje;

	@ApiModelProperty(value = "医生名称")
	private String ysmc;
	@ApiModelProperty(value = "现金支付")
	private BigDecimal xjzf;
	@ApiModelProperty(value = "个人账户支付")
	private BigDecimal grzhzf;
	@ApiModelProperty(value = "医保统筹支付")
	private BigDecimal ybtczf;
	@ApiModelProperty(value = "附加支付")
	private BigDecimal fjzf;
	@ApiModelProperty(value = "分类自负")
	private BigDecimal flzf;
	@ApiModelProperty(value = "自负")
	private BigDecimal zf;
	@ApiModelProperty(value = "自费")
	private BigDecimal zfei;
	@ApiModelProperty(value = "当年账户余额")
	private BigDecimal dnzhye;
	@ApiModelProperty(value = "历年账户余额")
	private BigDecimal lnzhye;
	@ApiModelProperty(value = "中心流水号")
	private String zxlsh;
	@ApiModelProperty(value = "支付宝金额")
	private BigDecimal zfbje;
	@ApiModelProperty(value = "付款方式")
	private Integer fkfs;
	@ApiModelProperty(value = "付款名称")
	private String fkmc;
	@ApiModelProperty(value = "充值卡支付金额")
	private BigDecimal czkzf;
	@ApiModelProperty(value = "充值卡余额")
	private BigDecimal czkye;
	@ApiModelProperty(value = "等待次数")
	private Integer ddcs;
	@ApiModelProperty(value = "当前时间")
	private String now;
	@ApiModelProperty(value = "姓名")
	private String name;
	@ApiModelProperty(value = "挂号打印机名称")
	private String ghdyjmc;
	@ApiModelProperty(value = "病历金额")
	private BigDecimal blje;
	@ApiModelProperty(value = "磁卡金额")
	private BigDecimal ckje;
	@ApiModelProperty(value = "打印方式 1-公立医院发票 2-私立医院票据")
	private Integer dyfs;
	@ApiModelProperty(value = "纳税人识别号，发票打印使用")
	private String nsrsbh;
	@ApiModelProperty(value = "就诊流水号")
	private String jzlsh;
	@ApiModelProperty(value = "收款员工号")
	private String skygh;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "发票预览")
	private String fpyl;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public String getKswz() {
		return kswz;
	}

	public void setKswz(String kswz) {
		this.kswz = kswz;
	}

	public String getJzxh() {
		return jzxh;
	}

	public void setJzxh(String jzxh) {
		this.jzxh = jzxh;
	}

	public String getShbzk() {
		return shbzk;
	}

	public void setShbzk(String shbzk) {
		this.shbzk = shbzk;
	}

	public String getJzhm() {
		return jzhm;
	}

	public void setJzhm(String jzhm) {
		this.jzhm = jzhm;
	}

	public String getYblx() {
		return yblx;
	}

	public void setYblx(String yblx) {
		this.yblx = yblx;
	}

	public String getJzjlxh() {
		return jzjlxh;
	}

	public void setJzjlxh(String jzjlxh) {
		this.jzjlxh = jzjlxh;
	}

	public BigDecimal getJcf() {
		return jcf;
	}

	public void setJcf(BigDecimal jcf) {
		this.jcf = jcf;
	}

	public BigDecimal getZjfy() {
		return zjfy;
	}

	public void setZjfy(BigDecimal zjfy) {
		this.zjfy = zjfy;
	}

	public BigDecimal getJmje() {
		return jmje;
	}

	public void setJmje(BigDecimal jmje) {
		this.jmje = jmje;
	}

	public BigDecimal getZlf() {
		return zlf;
	}

	public void setZlf(BigDecimal zlf) {
		this.zlf = zlf;
	}

	public BigDecimal getQtf() {
		return qtf;
	}

	public void setQtf(BigDecimal qtf) {
		this.qtf = qtf;
	}

	public String getGhlb() {
		return ghlb;
	}

	public void setGhlb(String ghlb) {
		this.ghlb = ghlb;
	}

	public BigDecimal getHjje() {
		return hjje;
	}

	public void setHjje(BigDecimal hjje) {
		this.hjje = hjje;
	}

	public String getYsmc() {
		return ysmc;
	}

	public void setYsmc(String ysmc) {
		this.ysmc = ysmc;
	}

	public BigDecimal getXjzf() {
		return xjzf;
	}

	public void setXjzf(BigDecimal xjzf) {
		this.xjzf = xjzf;
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

	public BigDecimal getZf() {
		return zf;
	}

	public void setZf(BigDecimal zf) {
		this.zf = zf;
	}

	public BigDecimal getZfei() {
		return zfei;
	}

	public void setZfei(BigDecimal zfei) {
		this.zfei = zfei;
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

	public String getZxlsh() {
		return zxlsh;
	}

	public void setZxlsh(String zxlsh) {
		this.zxlsh = zxlsh;
	}

	public BigDecimal getZfbje() {
		return zfbje;
	}

	public void setZfbje(BigDecimal zfbje) {
		this.zfbje = zfbje;
	}

	public Integer getFkfs() {
		return fkfs;
	}

	public void setFkfs(Integer fkfs) {
		this.fkfs = fkfs;
	}

	public String getFkmc() {
		return fkmc;
	}

	public void setFkmc(String fkmc) {
		this.fkmc = fkmc;
	}

	public BigDecimal getCzkzf() {
		return czkzf;
	}

	public void setCzkzf(BigDecimal czkzf) {
		this.czkzf = czkzf;
	}

	public BigDecimal getCzkye() {
		return czkye;
	}

	public void setCzkye(BigDecimal czkye) {
		this.czkye = czkye;
	}

	public Integer getDdcs() {
		return ddcs;
	}

	public void setDdcs(Integer ddcs) {
		this.ddcs = ddcs;
	}

	public String getNow() {
		return now;
	}

	public void setNow(String now) {
		this.now = now;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGhdyjmc() {
		return ghdyjmc;
	}

	public void setGhdyjmc(String ghdyjmc) {
		this.ghdyjmc = ghdyjmc;
	}

	public BigDecimal getBlje() {
		return blje;
	}

	public void setBlje(BigDecimal blje) {
		this.blje = blje;
	}

	public BigDecimal getCkje() {
		return ckje;
	}

	public void setCkje(BigDecimal ckje) {
		this.ckje = ckje;
	}

	public Integer getDyfs() {
		return dyfs;
	}

	public void setDyfs(Integer dyfs) {
		this.dyfs = dyfs;
	}

	public String getNsrsbh() {
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public String getSkygh() {
		return skygh;
	}

	public void setSkygh(String skygh) {
		this.skygh = skygh;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getFpyl() {
		return fpyl;
	}

	public void setFpyl(String fpyl) {
		this.fpyl = fpyl;
	}
}
