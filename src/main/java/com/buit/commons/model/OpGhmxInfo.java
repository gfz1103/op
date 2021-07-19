package com.buit.commons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpGhmxInfo<br>
 * 类描述：门诊_挂号明细表
 * 
 * @author wy
 */
@ApiModel(value = "门诊_挂号明细表")
public class OpGhmxInfo extends PageQuery {
	private static final long serialVersionUID = 3395365235181886210L;
	@ApiModelProperty(value = "识别序号 | 唯一标示一次挂号的序号")
	private Integer sbxh;
	@ApiModelProperty(value = "科室代码 | 挂号科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "科室名称")
	private String ksmc;
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "病人ID号 | 是一个内码，其它数据表与该表相联系的字段")
	private Integer brid;
	@ApiModelProperty(value = "退号标志 | 0.正常挂号 1.退号 2.废号(因修改当前就诊号产生)")
	private Integer thbz;
	@ApiModelProperty(value = "挂号时间")
	private Timestamp ghsj;
	@JsonIgnore
	@ApiModelProperty(value = "查询开始时间")
	private Timestamp beginOfDay;
	@JsonIgnore
	@ApiModelProperty(value = "查询结束时间")
	private Timestamp endOfDay;
	@ApiModelProperty(value = "门诊科室 | 该挂号科室对应的门诊科室代码")
	private Integer mzks;
	@ApiModelProperty(value = "医生代码 | 若所挂科室为专家科室，则该代码为专家医生代码，否则为空")
	private String ysdm;
	@ApiModelProperty(value = "门诊类别")
	private Integer mzlb;
	@ApiModelProperty(value = "就诊结束")
	private Integer jzjs;
	@ApiModelProperty(value = "挂号医生")
	private String ghys;
	@ApiModelProperty(value = "就诊号码")
	private String jzhm;
	@ApiModelProperty(value = "挂号金额 | 挂号金额、诊疗金额、专家费用、病历金额、该四项金额为总计部分，而非自负部分，前三项需在系统参数中设置对应的收费项目")
	private BigDecimal ghje;
	@ApiModelProperty(value = "诊疗金额")
	private BigDecimal zlje;
	@ApiModelProperty(value = "专家费用")
	private BigDecimal zjfy;
	@ApiModelProperty(value = "病历金额")
	private BigDecimal blje;
	@ApiModelProperty(value = "现金金额 | 若挂号金额+诊疗金额专+家费用+病历金额 = 现金金额+支票金额+帐户金额+货币误差+其它应收")
	private BigDecimal xjje;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "性质名称")
	private String xzmc;
	@ApiModelProperty(value = "病人性质")
	private Integer brxz;
	@ApiModelProperty(value = "EMPI")
	private String empiid;
	@ApiModelProperty(value = "门诊号码 | 唯一一处记载病人门诊号码的地方，在程序中用于刷卡登记或查询相关记录使用")
	private String mzhm;
	@ApiModelProperty(value = "门诊就诊流水号")
	private String jzlsh;
	@ApiModelProperty(value = "付款方式")
	private Integer fkfs;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "磁卡金额")
	private BigDecimal ckje;
	@ApiModelProperty(value = "就诊状态")
	private Integer jzzt;
	@ApiModelProperty(value = "值班类别")
	private String ghlb;
	@ApiModelProperty(value = "支票金额")
	private BigDecimal zpje;
	@ApiModelProperty(value = "减免金额")
	private BigDecimal jmje;

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

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public Integer getThbz() {
		return thbz;
	}

	public void setThbz(Integer thbz) {
		this.thbz = thbz;
	}

	public Timestamp getGhsj() {
		return ghsj;
	}

	public void setGhsj(Timestamp ghsj) {
		this.ghsj = ghsj;
	}

	public Timestamp getBeginOfDay() {
		return beginOfDay;
	}

	public void setBeginOfDay(Timestamp beginOfDay) {
		this.beginOfDay = beginOfDay;
	}

	public Timestamp getEndOfDay() {
		return endOfDay;
	}

	public void setEndOfDay(Timestamp endOfDay) {
		this.endOfDay = endOfDay;
	}

	public Integer getMzks() {
		return mzks;
	}

	public void setMzks(Integer mzks) {
		this.mzks = mzks;
	}

	public String getYsdm() {
		return ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
	}

	public Integer getMzlb() {
		return mzlb;
	}

	public void setMzlb(Integer mzlb) {
		this.mzlb = mzlb;
	}

	public Integer getJzjs() {
		return jzjs;
	}

	public void setJzjs(Integer jzjs) {
		this.jzjs = jzjs;
	}

	public String getGhys() {
		return ghys;
	}

	public void setGhys(String ghys) {
		this.ghys = ghys;
	}

	public String getJzhm() {
		return jzhm;
	}

	public void setJzhm(String jzhm) {
		this.jzhm = jzhm;
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

	public BigDecimal getZjfy() {
		return zjfy;
	}

	public void setZjfy(BigDecimal zjfy) {
		this.zjfy = zjfy;
	}

	public BigDecimal getBlje() {
		return blje;
	}

	public void setBlje(BigDecimal blje) {
		this.blje = blje;
	}

	public BigDecimal getXjje() {
		return xjje;
	}

	public void setXjje(BigDecimal xjje) {
		this.xjje = xjje;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getXzmc() {
		return xzmc;
	}

	public void setXzmc(String xzmc) {
		this.xzmc = xzmc;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public String getEmpiid() {
		return empiid;
	}

	public void setEmpiid(String empiid) {
		this.empiid = empiid;
	}

	public String getMzhm() {
		return mzhm;
	}

	public void setMzhm(String mzhm) {
		this.mzhm = mzhm;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public Integer getFkfs() {
		return fkfs;
	}

	public void setFkfs(Integer fkfs) {
		this.fkfs = fkfs;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public BigDecimal getCkje() {
		return ckje;
	}

	public void setCkje(BigDecimal ckje) {
		this.ckje = ckje;
	}

	public Integer getJzzt() {
		return jzzt;
	}

	public void setJzzt(Integer jzzt) {
		this.jzzt = jzzt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getGhlb() {
		return ghlb;
	}

	public void setGhlb(String ghlb) {
		this.ghlb = ghlb;
	}

	public BigDecimal getZpje() {
		return zpje;
	}

	public void setZpje(BigDecimal zpje) {
		this.zpje = zpje;
	}

	public BigDecimal getJmje() {
		return jmje;
	}

	public void setJmje(BigDecimal jmje) {
		this.jmje = jmje;
	}
}
