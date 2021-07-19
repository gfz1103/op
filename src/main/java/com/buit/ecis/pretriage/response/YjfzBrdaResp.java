
package com.buit.ecis.pretriage.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：YjfzBrdaResp<br>
 * 类描述：建档需要的预检分诊信息<br>
 * 
 * @author 汪洋
 */
@ApiModel(value = "建档需要的预检分诊信息")
public class YjfzBrdaResp {
	@ApiModelProperty(value = "急诊流水号")
	private Integer lsh;
	@ApiModelProperty(value = "医疗机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "证件类型")
	private String zjlx;
	@ApiModelProperty(value = "证件号码")
	private String sfzh;
	@ApiModelProperty(value = "病人年龄")
	private Integer ages;
	@ApiModelProperty(value = "联系电话")
	private String brdh;
	@ApiModelProperty(value = "现住址_省区市")
	private Integer xzzSqs;
	@ApiModelProperty(value = "现住址_市")
	private Integer xzzS;
	@ApiModelProperty(value = "现住址_县")
	private Integer xzzX;
	@ApiModelProperty(value = "详细地址")
	private String xzzQtdz;
	@ApiModelProperty(value = "调入状态：0：未调入 1：已调入")
	private String drzt;

	public Integer getLsh() {
		return lsh;
	}

	public void setLsh(Integer lsh) {
		this.lsh = lsh;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
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

	public String getZjlx() {
		return zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public Integer getAges() {
		return ages;
	}

	public void setAges(Integer ages) {
		this.ages = ages;
	}

	public String getBrdh() {
		return brdh;
	}

	public void setBrdh(String brdh) {
		this.brdh = brdh;
	}

	public Integer getXzzSqs() {
		return xzzSqs;
	}

	public void setXzzSqs(Integer xzzSqs) {
		this.xzzSqs = xzzSqs;
	}

	public Integer getXzzS() {
		return xzzS;
	}

	public void setXzzS(Integer xzzS) {
		this.xzzS = xzzS;
	}

	public Integer getXzzX() {
		return xzzX;
	}

	public void setXzzX(Integer xzzX) {
		this.xzzX = xzzX;
	}

	public String getXzzQtdz() {
		return xzzQtdz;
	}

	public void setXzzQtdz(String xzzQtdz) {
		this.xzzQtdz = xzzQtdz;
	}

	public String getDrzt() {
		return drzt;
	}

	public void setDrzt(String drzt) {
		this.drzt = drzt;
	}

}