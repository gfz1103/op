package com.buit.commons.model;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 类名称：OpGhks<br>
 * 类描述：门诊_挂号科室
 *
 * @author WY @ApiModel(value="门诊_挂号科室")
 */
public class OpGhks extends PageQuery {
	@ApiModelProperty(value = "科室代码")
	/** 科室代码 */
	private Integer ksdm;
	@ApiModelProperty(value = "机构代码")
	/** 机构代码 */
	private Integer jgid;
	@ApiModelProperty(value = "科室名称")
	/** 科室名称 */
	private String ksmc;
	@ApiModelProperty(value = "挂号类别 ")
	/** 挂号类别 */
	private Integer ghlb;
	@ApiModelProperty(value = "拼音代码")
	/** 拼音代码 */
	private String pydm;
	@ApiModelProperty(value = "五笔代码")
	/** 五笔代码 */
	private String wbdm;
	@ApiModelProperty(value = "角形代码")
	/** 角形代码 */
	private String jxdm;
	@ApiModelProperty(value = "其他代码")
	/** 其他代码 */
	private String qtdm;
	@ApiModelProperty(value = "挂号费")
	/** 挂号费 */
	private BigDecimal ghf;
	@ApiModelProperty(value = "诊疗费")
	/** 诊疗费 */
	private BigDecimal zlf;
	@ApiModelProperty(value = "专家门诊 | 0.普通门诊    1.专家门诊")
	/** 专家门诊 | 0.普通门诊 1.专家门诊 */
	private Integer zjmz;
	@ApiModelProperty(value = "挂号限额")
	/** 挂号限额 */
	private Integer ghxe;
	@ApiModelProperty(value = "已挂人数")
	/** 已挂人数 */
	private Integer ygrs;
	@ApiModelProperty(value = "预约人数")
	/** 预约人数 */
	private Integer yyrs;
	@ApiModelProperty(value = "挂号日期")
	/** 挂号日期 */
	private Timestamp ghrq;
	@ApiModelProperty(value = "门诊科室  SYS_DICT_CONFIG:10")
	/** 门诊科室 */
	private Integer mzks;
	@ApiModelProperty(value = "体检判别 | 0.非体检科室  1.体检科室 在体检挂号中自动挂TJPB=1的科室")
	/** 体检判别 | 0.非体检科室 1.体检科室 在体检挂号中自动挂TJPB=1的科室 */
	private Integer tjpb;
	@ApiModelProperty(value = "体验费")
	/** 体验费 */
	private BigDecimal tjf;
	@ApiModelProperty(value = "门诊类别 0.门诊挂号科室 1.急诊挂号科室 ")
	/** 门诊类别 | 0.门诊挂号科室 1.急诊挂号科室 */
	@NotNull(message = "门诊类别不能为空")
	private Integer mzlb;
	@ApiModelProperty(value = "就诊序号")
	/** 就诊序号 */
	private Integer jzxh;
	@ApiModelProperty(value = "节假日挂号费")
	/** 节假日挂号费 */
	private BigDecimal jjrghf;
	@ApiModelProperty(value = "地点信息")
	/** 门诊排列 */
	private String ddxx;
	@ApiModelProperty(value = "地点代码")
	/** 地点代码 */
	private String dddm;
	@ApiModelProperty(value = "启用叫号")
	/** 启用叫号 */
	private Integer sfqy;
	@ApiModelProperty(value = "录入疾控报卡")
	/** 录入疾控报卡 */
	private Integer lrjkbk;
	@ApiModelProperty(value = "老系统科室代码")
	/** 老系统科室代码 */
	private String bsrunksdm;
	@ApiModelProperty(value = "数字代码")
	/** 数字代码 */
	private String szdm;
	@ApiModelProperty(value = "普通门诊")
	/** 普通门诊 */
	private Integer ptmz;
	@ApiModelProperty(value = "专科门诊")
	/** 专科门诊 */
	private Integer zkmz;
	@ApiModelProperty(value = "特需门诊")
	/** 特需门诊 */
	private Integer txmz;
	@ApiModelProperty(value = "科室分机号")
	/** 科室分机号 */
	private String ksfjh;
	@JsonIgnore
	@ApiModelProperty(value = "查询开始时间")
	private Timestamp beginOfDay;
	@JsonIgnore
	@ApiModelProperty(value = "查询结束时间")
	private Timestamp endOfDay;
	@ApiModelProperty(value = "停挂标志")
	/** 停挂标志 */
	private Integer tgbz;
	@ApiModelProperty(value = "科室类别 0：西医  1：中医")
	private Integer kslb;
	@ApiModelProperty(value = "性别限制")
	private Integer xbxz;
	@ApiModelProperty(value = "最大年龄限制")
	private Integer nlxz;
	@ApiModelProperty(value = "服务台ID")
	private Integer fwtid;
	@ApiModelProperty(value = "急诊门诊 0.否    1.是")
	private Integer jzmz;
	@ApiModelProperty(value = "大病项目代码")
	private String dbtype;
	@ApiModelProperty(value = "是否互联科室 0-不是 1-是")
	private String internet;
	@ApiModelProperty(value = "是否儿科科室 0-不是 1-是")
	private String pediatrics;
	/** 设置:科室代码 */
	public void setKsdm(Integer value) {
		this.ksdm = value;
	}

	/** 获取:科室代码 */
	public Integer getKsdm() {
		return ksdm;
	}

	/** 设置:机构代码 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/** 获取:机构代码 */
	public Integer getJgid() {
		return jgid;
	}

	/** 设置:科室名称 */
	public void setKsmc(String value) {
		this.ksmc = value;
	}

	/** 获取:科室名称 */
	public String getKsmc() {
		return ksmc;
	}

	/** 设置:挂号类别 | 与GY_DMZD (DMLB = 25)关联 */
	public void setGhlb(Integer value) {
		this.ghlb = value;
	}

	/** 获取:挂号类别 | 与GY_DMZD (DMLB = 25)关联 */
	public Integer getGhlb() {
		return ghlb;
	}

	/** 设置:拼音代码 */
	public void setPydm(String value) {
		this.pydm = value;
	}

	/** 获取:拼音代码 */
	public String getPydm() {
		return pydm;
	}

	/** 设置:五笔代码 */
	public void setWbdm(String value) {
		this.wbdm = value;
	}

	/** 获取:五笔代码 */
	public String getWbdm() {
		return wbdm;
	}

	/** 设置:角形代码 */
	public void setJxdm(String value) {
		this.jxdm = value;
	}

	/** 获取:角形代码 */
	public String getJxdm() {
		return jxdm;
	}

	/** 设置:其他代码 */
	public void setQtdm(String value) {
		this.qtdm = value;
	}

	/** 获取:其他代码 */
	public String getQtdm() {
		return qtdm;
	}

	/** 设置:挂号费 */
	public void setGhf(BigDecimal value) {
		this.ghf = value;
	}

	/** 获取:挂号费 */
	public BigDecimal getGhf() {
		return ghf;
	}

	/** 设置:诊疗费 */
	public void setZlf(BigDecimal value) {
		this.zlf = value;
	}

	/** 获取:诊疗费 */
	public BigDecimal getZlf() {
		return zlf;
	}

	/** 设置:专家门诊 | 0.普通门诊 1.专家门诊 */
	public void setZjmz(Integer value) {
		this.zjmz = value;
	}

	/** 获取:专家门诊 | 0.普通门诊 1.专家门诊 */
	public Integer getZjmz() {
		return zjmz;
	}

	/** 设置:挂号限额 */
	public void setGhxe(Integer value) {
		this.ghxe = value;
	}

	/** 获取:挂号限额 */
	public Integer getGhxe() {
		return ghxe;
	}

	/** 设置:已挂人数 */
	public void setYgrs(Integer value) {
		this.ygrs = value;
	}

	/** 获取:已挂人数 */
	public Integer getYgrs() {
		return ygrs;
	}

	/** 设置:预约人数 */
	public void setYyrs(Integer value) {
		this.yyrs = value;
	}

	/** 获取:预约人数 */
	public Integer getYyrs() {
		return yyrs;
	}

	/** 设置:挂号日期 */
	public void setGhrq(Timestamp value) {
		this.ghrq = value;
	}

	/** 获取:挂号日期 */
	public Timestamp getGhrq() {
		return ghrq;
	}

	/** 设置:门诊科室 | 该挂号科室对应的门诊科室代码 */
	public void setMzks(Integer value) {
		this.mzks = value;
	}

	/** 获取:门诊科室 | 该挂号科室对应的门诊科室代码 */
	public Integer getMzks() {
		return mzks;
	}

	/** 设置:体检判别 | 0.非体检科室 1.体检科室 在体检挂号中自动挂TJPB=1的科室 */
	public void setTjpb(Integer value) {
		this.tjpb = value;
	}

	/** 获取:体检判别 | 0.非体检科室 1.体检科室 在体检挂号中自动挂TJPB=1的科室 */
	public Integer getTjpb() {
		return tjpb;
	}

	/** 设置:体验费 */
	public void setTjf(BigDecimal value) {
		this.tjf = value;
	}

	/** 获取:体验费 */
	public BigDecimal getTjf() {
		return tjf;
	}

	public Integer getMzlb() {
		return mzlb;
	}

	public void setMzlb(Integer mzlb) {
		this.mzlb = mzlb;
	}

	public void setSfqy(Integer sfqy) {
		this.sfqy = sfqy;
	}

	/** 设置:就诊序号 */
	public void setJzxh(Integer value) {
		this.jzxh = value;
	}

	/** 获取:就诊序号 */
	public Integer getJzxh() {
		return jzxh;
	}

	/** 设置:节假日挂号费 */
	public void setJjrghf(BigDecimal value) {
		this.jjrghf = value;
	}

	/** 获取:节假日挂号费 */
	public BigDecimal getJjrghf() {
		return jjrghf;
	}

	/** 设置:门诊排列 */
	public void setDdxx(String value) {
		this.ddxx = value;
	}

	/** 获取:门诊排列 */
	public String getDdxx() {
		return ddxx;
	}

	/** 设置:住院排列 */
	public void setDddm(String value) {
		this.dddm = value;
	}

	/** 获取:住院排列 */
	public String getDddm() {
		return dddm;
	}

	public Integer getSfqy() {
		return sfqy;
	}

	/** 设置:录入疾控报卡 */
	public void setLrjkbk(Integer value) {
		this.lrjkbk = value;
	}

	/** 获取:录入疾控报卡 */
	public Integer getLrjkbk() {
		return lrjkbk;
	}

	/** 设置:老系统科室代码 */
	public void setBsrunksdm(String value) {
		this.bsrunksdm = value;
	}

	/** 获取:老系统科室代码 */
	public String getBsrunksdm() {
		return bsrunksdm;
	}

	/** 设置:数字代码 */
	public void setSzdm(String value) {
		this.szdm = value;
	}

	/** 获取:数字代码 */
	public String getSzdm() {
		return szdm;
	}

	/** 设置:普通门诊 */
	public void setPtmz(Integer value) {
		this.ptmz = value;
	}

	/** 获取:普通门诊 */
	public Integer getPtmz() {
		return ptmz;
	}

	/** 设置:专科门诊 */
	public void setZkmz(Integer value) {
		this.zkmz = value;
	}

	/** 获取:专科门诊 */
	public Integer getZkmz() {
		return zkmz;
	}

	/** 设置:特需门诊 */
	public void setTxmz(Integer value) {
		this.txmz = value;
	}

	/** 获取:特需门诊 */
	public Integer getTxmz() {
		return txmz;
	}

	/** 设置:科室分机号 */
	public void setKsfjh(String value) {
		this.ksfjh = value;
	}

	/** 获取:科室分机号 */
	public String getKsfjh() {
		return ksfjh;
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

	public Integer getTgbz() {
		return tgbz;
	}

	public void setTgbz(Integer tgbz) {
		this.tgbz = tgbz;
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

	public Integer getFwtid() {
		return fwtid;
	}

	public void setFwtid(Integer fwtid) {
		this.fwtid = fwtid;
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
