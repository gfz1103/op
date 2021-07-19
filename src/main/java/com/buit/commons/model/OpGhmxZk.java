package com.buit.commons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpGhmxZk<br>
 * 类描述：挂号明细_转科信息
 * 
 * @author WY @ApiModel(value="挂号明细_转科信息")
 */
public class OpGhmxZk extends PageQuery {
	// @ApiModelProperty(value="挂号识别")
	/** 挂号识别 */
	private Integer ghsb;
	// @ApiModelProperty(value="jgid")
	/** jgid */
	private Integer jgid;
	// @ApiModelProperty(value="brid")
	/** brid */
	private Integer brid;
	// @ApiModelProperty(value="brxz")
	/** brxz */
	private Integer brxz;
	// @ApiModelProperty(value="ghsj")
	/** ghsj */
	private Timestamp ghsj;
	// @ApiModelProperty(value="ghlb")
	/** ghlb */
	private Integer ghlb;
	// @ApiModelProperty(value="ksdm")
	/** ksdm */
	private Integer ksdm;
	// @ApiModelProperty(value="ysdm")
	/** ysdm */
	private String ysdm;
	// @ApiModelProperty(value="jzys")
	/** jzys */
	private String jzys;
	// @ApiModelProperty(value="jzxh")
	/** jzxh */
	private Integer jzxh;
	// @ApiModelProperty(value="ghcs")
	/** ghcs */
	private Integer ghcs;
	// @ApiModelProperty(value="ghje")
	/** ghje */
	private BigDecimal ghje;
	// @ApiModelProperty(value="zlje")
	/** zlje */
	private BigDecimal zlje;
	// @ApiModelProperty(value="zjfy")
	/** zjfy */
	private BigDecimal zjfy;
	// @ApiModelProperty(value="blje")
	/** blje */
	private BigDecimal blje;
	// @ApiModelProperty(value="xjje")
	/** xjje */
	private BigDecimal xjje;
	// @ApiModelProperty(value="zpje")
	/** zpje */
	private BigDecimal zpje;
	// @ApiModelProperty(value="zhje")
	/** zhje */
	private BigDecimal zhje;
	// @ApiModelProperty(value="hbwc")
	/** hbwc */
	private BigDecimal hbwc;
	// @ApiModelProperty(value="qtys")
	/** qtys */
	private BigDecimal qtys;
	// @ApiModelProperty(value="账户类别")
	/** zhlb */
	private Integer zhlb;
	// @ApiModelProperty(value="就诊结束")
	/** jzjs */
	private Integer jzjs;
	// @ApiModelProperty(value="就诊结果")
	/** zdjg */
	private Integer zdjg;
	// @ApiModelProperty(value="退号标志")
	/** thbz */
	private Integer thbz;
	// @ApiModelProperty(value="操作工号")
	/** czgh */
	private String czgh;
	// @ApiModelProperty(value="结账日期")
	/** jzrq */
	private Timestamp jzrq;
	// @ApiModelProperty(value="hzrq")
	/** hzrq */
	private Timestamp hzrq;
	// @ApiModelProperty(value="诊断判别")
	/** czpb */
	private Integer czpb;
	// @ApiModelProperty(value="就诊号码")
	/** jzhm */
	private String jzhm;
	// @ApiModelProperty(value="门诊类别")
	/** mzlb */
	private Integer mzlb;
	// @ApiModelProperty(value="预约标志")
	/** yybz */
	private Integer yybz;
	// @ApiModelProperty(value="医生判别")
	/** yspb */
	private Integer yspb;
	// @ApiModelProperty(value="导诊识别")
	/** dzsb */
	private Integer dzsb;
	// @ApiModelProperty(value="收费方式")
	/** sffs */
	private Integer sffs;
	// @ApiModelProperty(value="就诊状态")
	/** jzzt */
	private Integer jzzt;
	// @ApiModelProperty(value="移动挂号判别")
	/** ydgh */
	private String ydgh;
	// @ApiModelProperty(value="诊断序号")
	/** zdxh */
	private Integer zdxh;
	// @ApiModelProperty(value="诊断标志")
	/** zhbz */
	private String zhbz;
	// @ApiModelProperty(value="dbxm")
	/** dbxm */
	private String dbxm;
	// @ApiModelProperty(value="fjddffj")
	/** fjddffj */
	private BigDecimal fjddffj;
	// @ApiModelProperty(value="tcdtc")
	/** tcdtc */
	private BigDecimal tcdtc;
	// @ApiModelProperty(value="zfdlnzh")
	/** zfdlnzh */
	private BigDecimal zfdlnzh;
	// @ApiModelProperty(value="zfddnzh")
	/** zfddnzh */
	private BigDecimal zfddnzh;
	// @ApiModelProperty(value="排队序号")
	/** pdxh */
	private Integer pdxh;
	// @ApiModelProperty(value="当前序号")
	/** dqxh */
	private Integer dqxh;
	// @ApiModelProperty(value="等待次数")
	/** ddcs */
	private Integer ddcs;
	// @ApiModelProperty(value="预约序号")
	/** yyxh */
	private Integer yyxh;
	// @ApiModelProperty(value="czsj")
	/** czsj */
	private Timestamp czsj;
	// @ApiModelProperty(value="jkzsb")
	/** jkzsb */
	private Integer jkzsb;
	// @ApiModelProperty(value="就诊卡号")
	/** jzkh */
	private String jzkh;
	// @ApiModelProperty(value="登记ID")
	/** ghid */
	private String ghid;
	// @ApiModelProperty(value="报销金额")
	/** bxje */
	private String bxje;
	// @ApiModelProperty(value="农合编号")
	/** nhbh */
	private String nhbh;
	// @ApiModelProperty(value="农合报销ID")
	/** nhbxid */
	private String nhbxid;
	// @ApiModelProperty(value="农合报销日期")
	/** nhbxrq */
	private String nhbxrq;
	// @ApiModelProperty(value="诊室ID")
	/** zsid */
	private String zsid;
	// @ApiModelProperty(value="叫号号码")
	/** jhhm */
	private String jhhm;
	// @ApiModelProperty(value="ywlx")
	/** ywlx */
	private Integer ywlx;
	// @ApiModelProperty(value="转入时间")
	/** 转入时间 */
	private Timestamp zrsj;
	// @ApiModelProperty(value="新就诊号码")
	/** 新就诊号码 */
	private String xjzhm;
	// @ApiModelProperty(value="是否是新转科(1是,0否)")
	/** 是否是新转科(1是,0否) */
	private Integer sfxzk;
	// @ApiModelProperty(value="转科标志(1是,0否)")
	/** 转科标志(1是,0否) */
	private Integer zkbz;
	@ApiModelProperty(value = "就诊流水号")
	private String jzlsh;

	/** 设置:挂号识别 */
	public void setGhsb(Integer value) {
		this.ghsb = value;
	}

	/** 获取:挂号识别 */
	public Integer getGhsb() {
		return ghsb;
	}

	/** 设置:jgid */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/** 获取:jgid */
	public Integer getJgid() {
		return jgid;
	}

	/** 设置:brid */
	public void setBrid(Integer value) {
		this.brid = value;
	}

	/** 获取:brid */
	public Integer getBrid() {
		return brid;
	}

	/** 设置:brxz */
	public void setBrxz(Integer value) {
		this.brxz = value;
	}

	/** 获取:brxz */
	public Integer getBrxz() {
		return brxz;
	}

	/** 设置:ghsj */
	public void setGhsj(Timestamp value) {
		this.ghsj = value;
	}

	/** 获取:ghsj */
	public Timestamp getGhsj() {
		return ghsj;
	}

	/** 设置:ghlb */
	public void setGhlb(Integer value) {
		this.ghlb = value;
	}

	/** 获取:ghlb */
	public Integer getGhlb() {
		return ghlb;
	}

	/** 设置:ksdm */
	public void setKsdm(Integer value) {
		this.ksdm = value;
	}

	/** 获取:ksdm */
	public Integer getKsdm() {
		return ksdm;
	}

	/** 设置:ysdm */
	public void setYsdm(String value) {
		this.ysdm = value;
	}

	/** 获取:ysdm */
	public String getYsdm() {
		return ysdm;
	}

	/** 设置:jzys */
	public void setJzys(String value) {
		this.jzys = value;
	}

	/** 获取:jzys */
	public String getJzys() {
		return jzys;
	}

	/** 设置:jzxh */
	public void setJzxh(Integer value) {
		this.jzxh = value;
	}

	/** 获取:jzxh */
	public Integer getJzxh() {
		return jzxh;
	}

	/** 设置:ghcs */
	public void setGhcs(Integer value) {
		this.ghcs = value;
	}

	/** 获取:ghcs */
	public Integer getGhcs() {
		return ghcs;
	}

	/** 设置:ghje */
	public void setGhje(BigDecimal value) {
		this.ghje = value;
	}

	/** 获取:ghje */
	public BigDecimal getGhje() {
		return ghje;
	}

	/** 设置:zlje */
	public void setZlje(BigDecimal value) {
		this.zlje = value;
	}

	/** 获取:zlje */
	public BigDecimal getZlje() {
		return zlje;
	}

	/** 设置:zjfy */
	public void setZjfy(BigDecimal value) {
		this.zjfy = value;
	}

	/** 获取:zjfy */
	public BigDecimal getZjfy() {
		return zjfy;
	}

	/** 设置:blje */
	public void setBlje(BigDecimal value) {
		this.blje = value;
	}

	/** 获取:blje */
	public BigDecimal getBlje() {
		return blje;
	}

	/** 设置:xjje */
	public void setXjje(BigDecimal value) {
		this.xjje = value;
	}

	/** 获取:xjje */
	public BigDecimal getXjje() {
		return xjje;
	}

	/** 设置:zpje */
	public void setZpje(BigDecimal value) {
		this.zpje = value;
	}

	/** 获取:zpje */
	public BigDecimal getZpje() {
		return zpje;
	}

	/** 设置:zhje */
	public void setZhje(BigDecimal value) {
		this.zhje = value;
	}

	/** 获取:zhje */
	public BigDecimal getZhje() {
		return zhje;
	}

	/** 设置:hbwc */
	public void setHbwc(BigDecimal value) {
		this.hbwc = value;
	}

	/** 获取:hbwc */
	public BigDecimal getHbwc() {
		return hbwc;
	}

	/** 设置:qtys */
	public void setQtys(BigDecimal value) {
		this.qtys = value;
	}

	/** 获取:qtys */
	public BigDecimal getQtys() {
		return qtys;
	}

	/** 设置:zhlb */
	public void setZhlb(Integer value) {
		this.zhlb = value;
	}

	/** 获取:zhlb */
	public Integer getZhlb() {
		return zhlb;
	}

	/** 设置:jzjs */
	public void setJzjs(Integer value) {
		this.jzjs = value;
	}

	/** 获取:jzjs */
	public Integer getJzjs() {
		return jzjs;
	}

	/** 设置:zdjg */
	public void setZdjg(Integer value) {
		this.zdjg = value;
	}

	/** 获取:zdjg */
	public Integer getZdjg() {
		return zdjg;
	}

	/** 设置:thbz */
	public void setThbz(Integer value) {
		this.thbz = value;
	}

	/** 获取:thbz */
	public Integer getThbz() {
		return thbz;
	}

	/** 设置:czgh */
	public void setCzgh(String value) {
		this.czgh = value;
	}

	/** 获取:czgh */
	public String getCzgh() {
		return czgh;
	}

	/** 设置:jzrq */
	public void setJzrq(Timestamp value) {
		this.jzrq = value;
	}

	/** 获取:jzrq */
	public Timestamp getJzrq() {
		return jzrq;
	}

	/** 设置:hzrq */
	public void setHzrq(Timestamp value) {
		this.hzrq = value;
	}

	/** 获取:hzrq */
	public Timestamp getHzrq() {
		return hzrq;
	}

	/** 设置:czpb */
	public void setCzpb(Integer value) {
		this.czpb = value;
	}

	/** 获取:czpb */
	public Integer getCzpb() {
		return czpb;
	}

	/** 设置:jzhm */
	public void setJzhm(String value) {
		this.jzhm = value;
	}

	/** 获取:jzhm */
	public String getJzhm() {
		return jzhm;
	}

	/** 设置:mzlb */
	public void setMzlb(Integer value) {
		this.mzlb = value;
	}

	/** 获取:mzlb */
	public Integer getMzlb() {
		return mzlb;
	}

	/** 设置:yybz */
	public void setYybz(Integer value) {
		this.yybz = value;
	}

	/** 获取:yybz */
	public Integer getYybz() {
		return yybz;
	}

	/** 设置:yspb */
	public void setYspb(Integer value) {
		this.yspb = value;
	}

	/** 获取:yspb */
	public Integer getYspb() {
		return yspb;
	}

	/** 设置:dzsb */
	public void setDzsb(Integer value) {
		this.dzsb = value;
	}

	/** 获取:dzsb */
	public Integer getDzsb() {
		return dzsb;
	}

	/** 设置:sffs */
	public void setSffs(Integer value) {
		this.sffs = value;
	}

	/** 获取:sffs */
	public Integer getSffs() {
		return sffs;
	}

	/** 设置:jzzt */
	public void setJzzt(Integer value) {
		this.jzzt = value;
	}

	/** 获取:jzzt */
	public Integer getJzzt() {
		return jzzt;
	}

	/** 设置:ydgh */
	public void setYdgh(String value) {
		this.ydgh = value;
	}

	/** 获取:ydgh */
	public String getYdgh() {
		return ydgh;
	}

	/** 设置:zdxh */
	public void setZdxh(Integer value) {
		this.zdxh = value;
	}

	/** 获取:zdxh */
	public Integer getZdxh() {
		return zdxh;
	}

	/** 设置:zhbz */
	public void setZhbz(String value) {
		this.zhbz = value;
	}

	/** 获取:zhbz */
	public String getZhbz() {
		return zhbz;
	}

	/** 设置:dbxm */
	public void setDbxm(String value) {
		this.dbxm = value;
	}

	/** 获取:dbxm */
	public String getDbxm() {
		return dbxm;
	}

	/** 设置:fjddffj */
	public void setFjddffj(BigDecimal value) {
		this.fjddffj = value;
	}

	/** 获取:fjddffj */
	public BigDecimal getFjddffj() {
		return fjddffj;
	}

	/** 设置:tcdtc */
	public void setTcdtc(BigDecimal value) {
		this.tcdtc = value;
	}

	/** 获取:tcdtc */
	public BigDecimal getTcdtc() {
		return tcdtc;
	}

	/** 设置:zfdlnzh */
	public void setZfdlnzh(BigDecimal value) {
		this.zfdlnzh = value;
	}

	/** 获取:zfdlnzh */
	public BigDecimal getZfdlnzh() {
		return zfdlnzh;
	}

	/** 设置:zfddnzh */
	public void setZfddnzh(BigDecimal value) {
		this.zfddnzh = value;
	}

	/** 获取:zfddnzh */
	public BigDecimal getZfddnzh() {
		return zfddnzh;
	}

	/** 设置:pdxh */
	public void setPdxh(Integer value) {
		this.pdxh = value;
	}

	/** 获取:pdxh */
	public Integer getPdxh() {
		return pdxh;
	}

	/** 设置:dqxh */
	public void setDqxh(Integer value) {
		this.dqxh = value;
	}

	/** 获取:dqxh */
	public Integer getDqxh() {
		return dqxh;
	}

	/** 设置:ddcs */
	public void setDdcs(Integer value) {
		this.ddcs = value;
	}

	/** 获取:ddcs */
	public Integer getDdcs() {
		return ddcs;
	}

	/** 设置:yyxh */
	public void setYyxh(Integer value) {
		this.yyxh = value;
	}

	/** 获取:yyxh */
	public Integer getYyxh() {
		return yyxh;
	}

	/** 设置:czsj */
	public void setCzsj(Timestamp value) {
		this.czsj = value;
	}

	/** 获取:czsj */
	public Timestamp getCzsj() {
		return czsj;
	}

	/** 设置:jkzsb */
	public void setJkzsb(Integer value) {
		this.jkzsb = value;
	}

	/** 获取:jkzsb */
	public Integer getJkzsb() {
		return jkzsb;
	}

	/** 设置:jzkh */
	public void setJzkh(String value) {
		this.jzkh = value;
	}

	/** 获取:jzkh */
	public String getJzkh() {
		return jzkh;
	}

	/** 设置:ghid */
	public void setGhid(String value) {
		this.ghid = value;
	}

	/** 获取:ghid */
	public String getGhid() {
		return ghid;
	}

	/** 设置:bxje */
	public void setBxje(String value) {
		this.bxje = value;
	}

	/** 获取:bxje */
	public String getBxje() {
		return bxje;
	}

	/** 设置:nhbh */
	public void setNhbh(String value) {
		this.nhbh = value;
	}

	/** 获取:nhbh */
	public String getNhbh() {
		return nhbh;
	}

	/** 设置:nhbxid */
	public void setNhbxid(String value) {
		this.nhbxid = value;
	}

	/** 获取:nhbxid */
	public String getNhbxid() {
		return nhbxid;
	}

	/** 设置:nhbxrq */
	public void setNhbxrq(String value) {
		this.nhbxrq = value;
	}

	/** 获取:nhbxrq */
	public String getNhbxrq() {
		return nhbxrq;
	}

	/** 设置:zsid */
	public void setZsid(String value) {
		this.zsid = value;
	}

	/** 获取:zsid */
	public String getZsid() {
		return zsid;
	}

	/** 设置:jhhm */
	public void setJhhm(String value) {
		this.jhhm = value;
	}

	/** 获取:jhhm */
	public String getJhhm() {
		return jhhm;
	}

	/** 设置:ywlx */
	public void setYwlx(Integer value) {
		this.ywlx = value;
	}

	/** 获取:ywlx */
	public Integer getYwlx() {
		return ywlx;
	}

	/** 设置:转入时间 */
	public void setZrsj(Timestamp value) {
		this.zrsj = value;
	}

	/** 获取:转入时间 */
	public Timestamp getZrsj() {
		return zrsj;
	}

	/** 设置:新就诊号码 */
	public void setXjzhm(String value) {
		this.xjzhm = value;
	}

	/** 获取:新就诊号码 */
	public String getXjzhm() {
		return xjzhm;
	}

	/** 设置:是否是新转科(1是,0否) */
	public void setSfxzk(Integer value) {
		this.sfxzk = value;
	}

	/** 获取:是否是新转科(1是,0否) */
	public Integer getSfxzk() {
		return sfxzk;
	}

	/** 设置:转科标志(1是,0否) */
	public void setZkbz(Integer value) {
		this.zkbz = value;
	}

	/** 获取:转科标志(1是,0否) */
	public Integer getZkbz() {
		return zkbz;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

}
