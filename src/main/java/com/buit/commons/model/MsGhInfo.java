package com.buit.commons.model;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsGhInfo<br>
 * 类描述：病人每日挂号信息
 * 
 * @author WY
 * 
 */
@ApiModel(value = "病人每日挂号信息")
public class MsGhInfo {
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "科室名称")
	private String ksmc;
	@ApiModelProperty(value = "医生代码")
	private Integer ysdm;
	@ApiModelProperty(value = "就诊流水号")
	private String jzlsh;
	@ApiModelProperty(value = "挂号时间")
	private Date ghsj;
	@ApiModelProperty(value = "挂号关联 | 该收费单与哪次挂号相联系,GHGL字段与OP_GHMX中SBXH关联")
	private Integer ghgl;
	@ApiModelProperty(value = "诊断序号")
	private Integer zdxh;
	@ApiModelProperty(value = "挂号病人性质")
	private Integer brxz;

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public Integer getYsdm() {
		return ysdm;
	}

	public void setYsdm(Integer ysdm) {
		this.ysdm = ysdm;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public Date getGhsj() {
		return ghsj;
	}

	public void setGhsj(Date ghsj) {
		this.ghsj = ghsj;
	}

	public Integer getGhgl() {
		return ghgl;
	}

	public void setGhgl(Integer ghgl) {
		this.ghgl = ghgl;
	}

	public Integer getZdxh() {
		return zdxh;
	}

	public void setZdxh(Integer zdxh) {
		this.zdxh = zdxh;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}
}
