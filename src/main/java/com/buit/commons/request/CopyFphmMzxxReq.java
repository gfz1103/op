package com.buit.commons.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * 类名称：CopyFphmMzxxReq<br>
 * 类描述：复制发票号码门诊信息请求
 * 
 * @author WY
 * 
 */
@ApiModel(value = "复制发票号码门诊信息请求")
public class CopyFphmMzxxReq extends PageQuery {
	@ApiModelProperty(value = "门诊序号")
	private Integer age;
	@ApiModelProperty(value = "病人编号")
	private Integer brid;
	@ApiModelProperty(value = "病人性别 ")
	private Integer brxb;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "病人性质 ")
	private Integer brxz;
	@ApiModelProperty(value = "出生年月")
	private Date csny;
	@ApiModelProperty(value = "挂号关联")
	private Integer ghgl;
	@ApiModelProperty(value = "挂号科室")
	private Integer ghks;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "科室名称")
	private String ksmc;
	@ApiModelProperty(value = "门诊号码")
	private Integer mzhm;
	@ApiModelProperty(value = "门诊类别 ")
	private Integer mzlb;
	@ApiModelProperty(value = "身份证号")
	private String sfzh;
	@ApiModelProperty(value = "性质控制大类")
	private String xzdl;
	@ApiModelProperty(value = "诊断序号")
	private Integer zdxh;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public Date getCsny() {
		return csny;
	}

	public void setCsny(Date csny) {
		this.csny = csny;
	}

	public Integer getGhgl() {
		return ghgl;
	}

	public void setGhgl(Integer ghgl) {
		this.ghgl = ghgl;
	}

	public Integer getGhks() {
		return ghks;
	}

	public void setGhks(Integer ghks) {
		this.ghks = ghks;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public Integer getMzhm() {
		return mzhm;
	}

	public void setMzhm(Integer mzhm) {
		this.mzhm = mzhm;
	}

	public Integer getMzlb() {
		return mzlb;
	}

	public void setMzlb(Integer mzlb) {
		this.mzlb = mzlb;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getXzdl() {
		return xzdl;
	}

	public void setXzdl(String xzdl) {
		this.xzdl = xzdl;
	}

	public Integer getZdxh() {
		return zdxh;
	}

	public void setZdxh(Integer zdxh) {
		this.zdxh = zdxh;
	}

}