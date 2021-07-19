package com.buit.cis.op.dctwork.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：FeeYlsfxmdjMechanismResp<br>
 * 类描述：机构收费项目维护明细<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_明细项目_mechanismResp")
public class FeeYlsfxmdjMechanismResp extends PageQuery{
    @ApiModelProperty(value="机构代码")
    private Integer jgid;

    @ApiModelProperty(value="费用序号")
    private Integer fyxh;

    @ApiModelProperty(value="费用名称")
    private String fymc;

    @ApiModelProperty(value="费用归并")
    private Integer fygb;

    @ApiModelProperty(value="费用单位")
    private String fydw;

    @ApiModelProperty(value="拼音代码")
    private String pydm;

    @ApiModelProperty(value="费用单价")
    private BigDecimal fydj;

    @ApiModelProperty(value="门诊使用")
    private Integer mzsy;

    @ApiModelProperty(value="住院使用")
    private Integer zysy;

    @ApiModelProperty(value="医技使用")
    private Integer yjsy;

    @ApiModelProperty(value="特殊检查")
    private Integer tjfy;

    @ApiModelProperty(value="特殊治疗")
    private Integer txzl;

    @ApiModelProperty(value="五笔代码")
    private String wbdm;

    @ApiModelProperty(value="角形代码")
    private String jxdm;

    @ApiModelProperty(value="笔画代码")
    private String bhdm;

    @ApiModelProperty(value="项目类别 | 4.检验 5.检查 6.手术 7.治疗 8.护理 9.饮食 10.卫材 99.其他")
    private Integer xmlx;

    @ApiModelProperty(value="其他代码")
    private String qtdm;

    @ApiModelProperty(value="费用科室")
    private Integer fyks;

    @ApiModelProperty(value="自动插入")
    private Integer zdcr;

    @ApiModelProperty(value="限制使用标志 | 0:不限制,1:限制")
    private Integer xzsy;

    @ApiModelProperty(value="限制使用为1时,此处填写限制天数")
    private Integer xzts;

    @ApiModelProperty(value="限制使用为1时,此处填写限制次数")
    private Integer xzcs;

    @ApiModelProperty(value="商保价格")
    private BigDecimal sbjg;

    @ApiModelProperty(value="CPT CODE")
    private String cptcode;

    @ApiModelProperty(value="英文名称")
    private String ywmc;

    @ApiModelProperty(value="打折比例")
    private BigDecimal dzbl;

    @ApiModelProperty(value="标准价格")
    private BigDecimal bzjg;

    @ApiModelProperty(value="价格标志")
    private Integer jgbz;

    @ApiModelProperty(value="项目编码")
    private String xmbm;

    @ApiModelProperty(value="黄码编码")
    private String hmbm;

    @ApiModelProperty(value="作废判别")
    private Integer zfpb;

    @ApiModelProperty(value="计费医嘱")
    private Integer jfyz;

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getFyxh() {
		return fyxh;
	}

	public void setFyxh(Integer fyxh) {
		this.fyxh = fyxh;
	}

	public String getFymc() {
		return fymc;
	}

	public void setFymc(String fymc) {
		this.fymc = fymc;
	}

	public Integer getFygb() {
		return fygb;
	}

	public void setFygb(Integer fygb) {
		this.fygb = fygb;
	}

	public String getFydw() {
		return fydw;
	}

	public void setFydw(String fydw) {
		this.fydw = fydw;
	}

	public String getPydm() {
		return pydm;
	}

	public void setPydm(String pydm) {
		this.pydm = pydm;
	}

	public BigDecimal getFydj() {
		return fydj;
	}

	public void setFydj(BigDecimal fydj) {
		this.fydj = fydj;
	}

	public Integer getMzsy() {
		return mzsy;
	}

	public void setMzsy(Integer mzsy) {
		this.mzsy = mzsy;
	}

	public Integer getZysy() {
		return zysy;
	}

	public void setZysy(Integer zysy) {
		this.zysy = zysy;
	}

	public Integer getYjsy() {
		return yjsy;
	}

	public void setYjsy(Integer yjsy) {
		this.yjsy = yjsy;
	}

	public Integer getTjfy() {
		return tjfy;
	}

	public void setTjfy(Integer tjfy) {
		this.tjfy = tjfy;
	}

	public Integer getTxzl() {
		return txzl;
	}

	public void setTxzl(Integer txzl) {
		this.txzl = txzl;
	}

	public String getWbdm() {
		return wbdm;
	}

	public void setWbdm(String wbdm) {
		this.wbdm = wbdm;
	}

	public String getJxdm() {
		return jxdm;
	}

	public void setJxdm(String jxdm) {
		this.jxdm = jxdm;
	}

	public String getBhdm() {
		return bhdm;
	}

	public void setBhdm(String bhdm) {
		this.bhdm = bhdm;
	}

	public Integer getXmlx() {
		return xmlx;
	}

	public void setXmlx(Integer xmlx) {
		this.xmlx = xmlx;
	}

	public String getQtdm() {
		return qtdm;
	}

	public void setQtdm(String qtdm) {
		this.qtdm = qtdm;
	}

	public Integer getFyks() {
		return fyks;
	}

	public void setFyks(Integer fyks) {
		this.fyks = fyks;
	}

	public Integer getZdcr() {
		return zdcr;
	}

	public void setZdcr(Integer zdcr) {
		this.zdcr = zdcr;
	}

	public Integer getXzsy() {
		return xzsy;
	}

	public void setXzsy(Integer xzsy) {
		this.xzsy = xzsy;
	}

	public Integer getXzts() {
		return xzts;
	}

	public void setXzts(Integer xzts) {
		this.xzts = xzts;
	}

	public Integer getXzcs() {
		return xzcs;
	}

	public void setXzcs(Integer xzcs) {
		this.xzcs = xzcs;
	}

	public BigDecimal getSbjg() {
		return sbjg;
	}

	public void setSbjg(BigDecimal sbjg) {
		this.sbjg = sbjg;
	}

	public String getCptcode() {
		return cptcode;
	}

	public void setCptcode(String cptcode) {
		this.cptcode = cptcode;
	}

	public String getYwmc() {
		return ywmc;
	}

	public void setYwmc(String ywmc) {
		this.ywmc = ywmc;
	}

	public BigDecimal getDzbl() {
		return dzbl;
	}

	public void setDzbl(BigDecimal dzbl) {
		this.dzbl = dzbl;
	}

	public BigDecimal getBzjg() {
		return bzjg;
	}

	public void setBzjg(BigDecimal bzjg) {
		this.bzjg = bzjg;
	}

	public Integer getJgbz() {
		return jgbz;
	}

	public void setJgbz(Integer jgbz) {
		this.jgbz = jgbz;
	}

	public String getXmbm() {
		return xmbm;
	}

	public void setXmbm(String xmbm) {
		this.xmbm = xmbm;
	}

	public String getHmbm() {
		return hmbm;
	}

	public void setHmbm(String hmbm) {
		this.hmbm = hmbm;
	}

	public Integer getZfpb() {
		return zfpb;
	}

	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}

	public Integer getJfyz() {
		return jfyz;
	}

	public void setJfyz(Integer jfyz) {
		this.jfyz = jfyz;
	}


}
