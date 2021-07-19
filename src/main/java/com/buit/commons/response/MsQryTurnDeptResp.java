
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsQryTurnDeptResp<br>
 * 类描述：转科卡号查询返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "转科卡号查询返回")
public class MsQryTurnDeptResp extends PageQuery {
	private static final long serialVersionUID = -1660665021628842035L;
	@ApiModelProperty(value = "病人编号")
	private Integer brid;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "就诊号码")
	private Integer jzhm;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "挂号科室")
	private String ghks;
	@ApiModelProperty(value = "医生代码")
	private String ysdm;
	@ApiModelProperty(value = "挂号时间")
	private Timestamp ghsj;
	@ApiModelProperty(value = "就诊状态 ")
	private Integer jzzt;
	@ApiModelProperty(value = "挂号费 ")
	private BigDecimal ghf;
	@ApiModelProperty(value = "诊疗费 ")
	private BigDecimal zlf;
	@ApiModelProperty(value = "识别序号")
	private Integer sbxh;
	@ApiModelProperty(value = "专家费用")
	private BigDecimal zjfy;
	@ApiModelProperty(value = "员工姓名")
	private String ygxm;
	@ApiModelProperty(value = "就诊状态描述")
	private String jzztText;
	@ApiModelProperty(value = "就诊流水号")
	private String jzlsh;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "出生年月")
	private Timestamp csny;
	@ApiModelProperty(value = "年龄")
	private Integer age;

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

	public Integer getJzhm() {
		return jzhm;
	}

	public void setJzhm(Integer jzhm) {
		this.jzhm = jzhm;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getGhks() {
		return ghks;
	}

	public void setGhks(String ghks) {
		this.ghks = ghks;
	}

	public String getYsdm() {
		return ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
	}

	public Timestamp getGhsj() {
		return ghsj;
	}

	public void setGhsj(Timestamp ghsj) {
		this.ghsj = ghsj;
	}

	public Integer getJzzt() {
		return jzzt;
	}

	public void setJzzt(Integer jzzt) {
		this.jzzt = jzzt;
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

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

	public BigDecimal getZjfy() {
		return zjfy;
	}

	public void setZjfy(BigDecimal zjfy) {
		this.zjfy = zjfy;
	}

	public String getYgxm() {
		return ygxm;
	}

	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}

	public String getJzztText() {
		return jzztText;
	}

	public void setJzztText(String jzztText) {
		this.jzztText = jzztText;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

	public Timestamp getCsny() {
		return csny;
	}

	public void setCsny(Timestamp csny) {
		this.csny = csny;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}