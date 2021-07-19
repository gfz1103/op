
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 类名称：OpGhks<br>
 * 类描述：门诊_挂号科室新增<br>
 *
 * @author WY
 */
@ApiModel(value = "门诊_挂号科室新增")
public class OpGhksAddReq extends PageQuery {
	private static final long serialVersionUID = 9106095491798149557L;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@NotBlank(message = "科室名称不能为空")
	@ApiModelProperty(value = "科室名称", required = true)
	private String ksmc;
	@NotNull(message = "门诊科室不能为空")
	@ApiModelProperty(value = "门诊科室  SYS_DICT_CONFIG:10", required = true)
	private Integer mzks;
	@ApiModelProperty(value = "普通门诊")
	private Integer ptmz;
	@ApiModelProperty(value = "专家门诊 | 0.普通门诊    1.专家门诊")
	private Integer zjmz;
	@ApiModelProperty(value = "专科门诊")
	private Integer zkmz;
	@ApiModelProperty(value = "特需门诊")
	private Integer txmz;
	@ApiModelProperty(value = "拼音代码")
	private String pydm;
	@ApiModelProperty(value = "五笔代码")
	private String wbdm;
	@ApiModelProperty(value = "数字代码")
	private String szdm;
	@ApiModelProperty(value = "角形代码")
	private String jxdm;
	@ApiModelProperty(value = "其他代码")
	private String qtdm;
	@NotNull(message = "挂号费不能为空")
	@ApiModelProperty(value = "挂号费")
	private BigDecimal ghf;
	@NotNull(message = "诊疗费不能为空")
	@ApiModelProperty(value = "诊疗费")
	private BigDecimal zlf;
	@ApiModelProperty(value = "门诊类别 SYS_DICT_CONFIG:11", required = true)
	private Integer mzlb;
	@ApiModelProperty(value = "地点信息")
	private String ddxx;
	@NotBlank(message = "科室分机号不能为空")
	@ApiModelProperty(value = "科室分机号", required = true)
	private String ksfjh;
	@ApiModelProperty(value = "启用叫号")
	private Integer sfqy;
	@ApiModelProperty(value = "录入疾控报卡")
	private Integer lrjkbk;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "挂号关联")
	private Integer ghlb;
	@JsonIgnore
	@ApiModelProperty(value = "挂号限额")
	/** 挂号限额 */
	private Integer ghxe;
	@JsonIgnore
	@ApiModelProperty(value = "节假日挂号费")
	/** 节假日挂号费 */
	private BigDecimal jjrghf;
	@JsonIgnore
	@ApiModelProperty(value = "就诊序号")
	/** 就诊序号 */
	private Integer jzxh;
	@JsonIgnore
	@ApiModelProperty(value = "体验费")
	/** 体验费 */
	private BigDecimal tjf;
	@JsonIgnore
	@ApiModelProperty(value = "体检判别 | 0.非体检科室  1.体检科室 在体检挂号中自动挂TJPB=1的科室")
	/** 体检判别 | 0.非体检科室 1.体检科室 在体检挂号中自动挂TJPB=1的科室 */
	private Integer tjpb;
	@JsonIgnore
	@ApiModelProperty(value = "已挂人数")
	/** 已挂人数 */
	private Integer ygrs;
	@JsonIgnore
	@ApiModelProperty(value = "预约人数")
	/** 预约人数 */
	private Integer yyrs;
	@ApiModelProperty(value = "科室类别 0：西医  1：中医")
	private Integer kslb;
	@ApiModelProperty(value = "性别限制")
	private Integer xbxz;
	@ApiModelProperty(value = "最大年龄限制")
	private Integer nlxz;
	@ApiModelProperty(value = "急诊门诊 0.否    1.是")
	private Integer jzmz;
	@ApiModelProperty(value = "大病项目代码")
	private String dbtype;
	@ApiModelProperty(value = "是否互联科室 0-不是 1-是")
	private String internet;
	@ApiModelProperty(value = "是否儿科科室 0-不是 1-是")
	private String pediatrics;

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

	public Integer getMzks() {
		return mzks;
	}

	public void setMzks(Integer mzks) {
		this.mzks = mzks;
	}

	public Integer getPtmz() {
		return ptmz;
	}

	public void setPtmz(Integer ptmz) {
		this.ptmz = ptmz;
	}

	public Integer getZjmz() {
		return zjmz;
	}

	public void setZjmz(Integer zjmz) {
		this.zjmz = zjmz;
	}

	public Integer getZkmz() {
		return zkmz;
	}

	public void setZkmz(Integer zkmz) {
		this.zkmz = zkmz;
	}

	public Integer getTxmz() {
		return txmz;
	}

	public void setTxmz(Integer txmz) {
		this.txmz = txmz;
	}

	public String getPydm() {
		return pydm;
	}

	public void setPydm(String pydm) {
		this.pydm = pydm;
	}

	public String getWbdm() {
		return wbdm;
	}

	public void setWbdm(String wbdm) {
		this.wbdm = wbdm;
	}

	public String getSzdm() {
		return szdm;
	}

	public void setSzdm(String szdm) {
		this.szdm = szdm;
	}

	public String getJxdm() {
		return jxdm;
	}

	public void setJxdm(String jxdm) {
		this.jxdm = jxdm;
	}

	public String getQtdm() {
		return qtdm;
	}

	public void setQtdm(String qtdm) {
		this.qtdm = qtdm;
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

	public Integer getMzlb() {
		return mzlb;
	}

	public void setMzlb(Integer mzlb) {
		this.mzlb = mzlb;
	}

	public String getDdxx() {
		return ddxx;
	}

	public void setDdxx(String ddxx) {
		this.ddxx = ddxx;
	}

	public String getKsfjh() {
		return ksfjh;
	}

	public void setKsfjh(String ksfjh) {
		this.ksfjh = ksfjh;
	}

	public Integer getSfqy() {
		return sfqy;
	}

	public void setSfqy(Integer sfqy) {
		this.sfqy = sfqy;
	}

	public Integer getLrjkbk() {
		return lrjkbk;
	}

	public void setLrjkbk(Integer lrjkbk) {
		this.lrjkbk = lrjkbk;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getGhlb() {
		return ghlb;
	}

	public void setGhlb(Integer ghlb) {
		this.ghlb = ghlb;
	}

	public Integer getGhxe() {
		return ghxe;
	}

	public void setGhxe(Integer ghxe) {
		this.ghxe = ghxe;
	}

	public BigDecimal getJjrghf() {
		return jjrghf;
	}

	public void setJjrghf(BigDecimal jjrghf) {
		this.jjrghf = jjrghf;
	}

	public Integer getJzxh() {
		return jzxh;
	}

	public void setJzxh(Integer jzxh) {
		this.jzxh = jzxh;
	}

	public BigDecimal getTjf() {
		return tjf;
	}

	public void setTjf(BigDecimal tjf) {
		this.tjf = tjf;
	}

	public Integer getTjpb() {
		return tjpb;
	}

	public void setTjpb(Integer tjpb) {
		this.tjpb = tjpb;
	}

	public Integer getYgrs() {
		return ygrs;
	}

	public void setYgrs(Integer ygrs) {
		this.ygrs = ygrs;
	}

	public Integer getYyrs() {
		return yyrs;
	}

	public void setYyrs(Integer yyrs) {
		this.yyrs = yyrs;
	}

	public Integer getKslb() {
		return kslb;
	}

	public void setKslb(Integer kslb) {
		this.kslb = kslb;
	}

	public Integer getXbxz() {
		return xbxz;
	}

	public void setXbxz(Integer xbxz) {
		this.xbxz = xbxz;
	}

	public Integer getNlxz() {
		return nlxz;
	}

	public void setNlxz(Integer nlxz) {
		this.nlxz = nlxz;
	}

	public Integer getJzmz() {
		return jzmz;
	}

	public void setJzmz(Integer jzmz) {
		this.jzmz = jzmz;
	}

	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public String getPediatrics() {
		return pediatrics;
	}

	public void setPediatrics(String pediatrics) {
		this.pediatrics = pediatrics;
	}
}
