
package com.buit.commons.request;

import com.buit.cis.op.dctwork.request.OpCfpsReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

/**
 * 类名称：MsCfSaveReq<br>
 * 类描述：门诊_门诊处方表保存请求<br>
 *
 * @author 老花生
 */
@ApiModel(value = "门诊_门诊处方表保存请求")
public class MsCfSaveReq {
	@ApiModelProperty(value = "原处方识别")
	private Integer oldCfsb;
	@ApiModelProperty(value = "机构ID", hidden = true)
	private Integer jgid;
	@ApiModelProperty(value = "处方号码 | 外部标示一张处方，不唯一", hidden = true)
	private String cfhm;
	@ApiModelProperty(value = "开方日期", hidden = true)
	private Timestamp kfrq;
	@ApiModelProperty(value = "处方类型 | 1：西药处方 2：中药处方 3：草药处方")
	private Integer cflx;
	@ApiModelProperty(value = "药房识别 | 该处方到哪个药房发药的标识，由门诊的配置文件决定")
	private Integer yfsb;
	@ApiModelProperty(value = "科室代码 | 开单科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "医生代码 | 开单医生代码", hidden = true)
	private String ysdm;
	@ApiModelProperty(value = "处方贴数")
	private Integer cfts;
	@ApiModelProperty(value = "代煎药标志")
	private Integer djybz;
	@ApiModelProperty(value = "方名")
	private String fm;
	@ApiModelProperty(value = "煎服法")
	private String jff;
	@NotNull(message = "门诊就诊号 不能为空")
	@ApiModelProperty(value = "门诊就诊")
	private Integer jzxh;
	@ApiModelProperty(value = "病人ID号")
	private Integer brid;
	@ApiModelProperty(value = "单据来源 | 1医生开单 2药房划价 3药房退药 4医技划价 5体检开单 6收费划价 7门诊退费")
	private Integer djly;
	@ApiModelProperty(value = "特殊处方")
	private Integer tscf;
	@ApiModelProperty(value = "特殊要求")
	private String tsyq;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "处方明细集合")
	private List<OpCf02SaveReq> cf02List;
	@ApiModelProperty(value = "组套编号")
	private Integer ztbh;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "病人序号")
	private String brxz;
	@ApiModelProperty(value = "不明确便利")
	private String saveBy;
	@NotNull(message = "就诊流水号 不能为空")
	@ApiModelProperty(value = "就诊流水号")
	private String jzlsh;
	@ApiModelProperty(value = "不明确便利")
	private List<OpCfpsReq> cfpsList;

	//代办人信息（当处方中存在麻、精药品）
	@ApiModelProperty(value = "代办人姓名")
	private String dbrxm;
	@ApiModelProperty(value = "代办人联系电话")
	private String dbrlxdh;
	@ApiModelProperty(value = "身份证明 证件类型")
	private String sfzm;
	@ApiModelProperty(value = "编号 证件编号")
	private String bh;

	@ApiModelProperty(value = "客户机ip",hidden = true)
	private String ip;
	@ApiModelProperty(value = "mac地址",hidden = true)
	private String mac;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getDbrxm() {
		return dbrxm;
	}

	public void setDbrxm(String dbrxm) {
		this.dbrxm = dbrxm;
	}

	public String getDbrlxdh() {
		return dbrlxdh;
	}

	public void setDbrlxdh(String dbrlxdh) {
		this.dbrlxdh = dbrlxdh;
	}

	public String getSfzm() {
		return sfzm;
	}

	public void setSfzm(String sfzm) {
		this.sfzm = sfzm;
	}

	public String getBh() {
		return bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getCfhm() {
		return cfhm;
	}

	public void setCfhm(String cfhm) {
		this.cfhm = cfhm;
	}

	public Timestamp getKfrq() {
		return kfrq;
	}

	public void setKfrq(Timestamp kfrq) {
		this.kfrq = kfrq;
	}

	public Integer getCflx() {
		return cflx;
	}

	public void setCflx(Integer cflx) {
		this.cflx = cflx;
	}

	public Integer getYfsb() {
		return yfsb;
	}

	public void setYfsb(Integer yfsb) {
		this.yfsb = yfsb;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getYsdm() {
		return ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
	}

	public Integer getCfts() {
		return cfts;
	}

	public void setCfts(Integer cfts) {
		this.cfts = cfts;
	}

	public Integer getDjybz() {
		return djybz;
	}

	public void setDjybz(Integer djybz) {
		this.djybz = djybz;
	}

	public String getFm() {
		return fm;
	}

	public void setFm(String fm) {
		this.fm = fm;
	}

	public String getJff() {
		return jff;
	}

	public void setJff(String jff) {
		this.jff = jff;
	}

	public Integer getJzxh() {
		return jzxh;
	}

	public void setJzxh(Integer jzxh) {
		this.jzxh = jzxh;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public Integer getDjly() {
		return djly;
	}

	public void setDjly(Integer djly) {
		this.djly = djly;
	}

	public Integer getTscf() {
		return tscf;
	}

	public void setTscf(Integer tscf) {
		this.tscf = tscf;
	}

	public String getTsyq() {
		return tsyq;
	}

	public void setTsyq(String tsyq) {
		this.tsyq = tsyq;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public List<OpCf02SaveReq> getCf02List() {
		return cf02List;
	}

	public void setCf02List(List<OpCf02SaveReq> cf02List) {
		this.cf02List = cf02List;
	}

	public Integer getZtbh() {
		return ztbh;
	}

	public void setZtbh(Integer ztbh) {
		this.ztbh = ztbh;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public String getBrxz() {
		return brxz;
	}

	public void setBrxz(String brxz) {
		this.brxz = brxz;
	}

	public String getSaveBy() {
		return saveBy;
	}

	public void setSaveBy(String saveBy) {
		this.saveBy = saveBy;
	}

	public Integer getOldCfsb() {
		return oldCfsb;
	}

	public void setOldCfsb(Integer oldCfsb) {
		this.oldCfsb = oldCfsb;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public List<OpCfpsReq> getCfpsList() {
		return cfpsList;
	}

	public void setCfpsList(List<OpCfpsReq> cfpsList) {
		this.cfpsList = cfpsList;
	}
}
