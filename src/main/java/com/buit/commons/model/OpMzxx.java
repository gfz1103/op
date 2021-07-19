package com.buit.commons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpMzxx<br>
 * 类描述：门诊_门诊收费信息
 * 
 * @author WY @ApiModel(value="门诊_门诊收费信息")
 */
public class OpMzxx extends PageQuery {
	// @ApiModelProperty(value="门诊序号")
	/** 门诊序号 */
	private Integer mzxh;
	// @ApiModelProperty(value="机构代码")
	/** 机构代码 */
	private String jgid;
	// @ApiModelProperty(value="发票号码 | 连接OP_SFMX,OP_CF01,OP_YJCF01")
	/** 发票号码 | 连接OP_SFMX,OP_CF01,OP_YJCF01 */
	private String fphm;

	// @ApiModelProperty(value="发票号码 | 连接OP_SFMX,OP_CF01,OP_YJCF01")
	/** 重打发票号码 */
	private String cdfphm;

	// @ApiModelProperty(value="收费日期")
	/** 收费日期 */
	private Date sfrq;
	// @ApiModelProperty(value="病人ID号 |
	// 内部标示一个病人的编号在MPI_BRDA库中每一个MZHM与一个ID号相关联，用于唯一标示一个病人")
	/** 病人ID号 | 内部标示一个病人的编号在MPI_BRDA库中每一个MZHM与一个ID号相关联，用于唯一标示一个病人 */
	private Integer brid;
	// @ApiModelProperty(value="病人姓名")
	/** 病人姓名 */
	private String brxm;
	// @ApiModelProperty(value="病人性别 | 与GY_DMZD（DMSB=15）对应")
	/** 病人性别 | 与GY_DMZD（DMSB=15）对应 */
	private Integer brxb;
	// @ApiModelProperty(value="病人性质 | 与PUB_BRXZ中BRXZ关联")
	/** 病人性质 | 与PUB_BRXZ中BRXZ关联 */
	private Integer brxz;
	// @ApiModelProperty(value="医疗证号")
	/** 医疗证号 */
	private String fyzh;
	// @ApiModelProperty(value="单位序号")
	/** 单位序号 */
	private Integer dwxh;
	// @ApiModelProperty(value="现金金额 | XJJE+ZPJE+QTJE+QTYS+HBWC=
	// OP_SFMX中该发票的ZJJE之和但XJJE+ZPJE+QTJE不一定等于OP_SFMX中该发票的ZFJE之和")
	/**
	 * 现金金额 | XJJE+ZPJE+QTJE+QTYS+HBWC=
	 * OP_SFMX中该发票的ZJJE之和但XJJE+ZPJE+QTJE不一定等于OP_SFMX中该发票的ZFJE之和
	 */
	private BigDecimal xjje;
	// @ApiModelProperty(value="支票金额")
	/** 支票金额 */
	private BigDecimal zpje;
	// @ApiModelProperty(value="帐户金额")
	/** 帐户金额 */
	private BigDecimal zhje;
	// @ApiModelProperty(value="货币误差")
	/** 货币误差 */
	private BigDecimal hbwc;
	// @ApiModelProperty(value="其他应收")
	/** 其他应收 */
	private BigDecimal qtys;
	// @ApiModelProperty(value="总计金额")
	/** 总计金额 */
	private BigDecimal zjje;
	// @ApiModelProperty(value="自负金额")
	/** 自负金额 */
	private BigDecimal zfje;
	// @ApiModelProperty(value="帐户类别 | 与MS_ZHLB中CODE关联")
	/** 帐户类别 | 与MS_ZHLB中CODE关联 */
	private Integer zhlb;
	// @ApiModelProperty(value="作废判别 | 1.作废 0.未作废")
	/** 作废判别 | 1.作废 0.未作废 */
	private Integer zfpb;
	// @ApiModelProperty(value="退号判别 | 1.退费发票(包括原发票和现发票)0.非退费发票")
	/** 退号判别 | 1.退费发票(包括原发票和现发票)0.非退费发票 */
	private Integer thpb;
	// @ApiModelProperty(value="发票关联 | 用于退费，特指该退费发票的原发票")
	/** 发票关联 | 用于退费，特指该退费发票的原发票 */
	private String fpgl;
	// @ApiModelProperty(value="门诊关联")
	/** 门诊关联 */
	private Integer mzgl;
	// @ApiModelProperty(value="门诊类别 | 根据门诊的配置文件决定。可区分医院多种门诊点的情况")
	/** 门诊类别 | 根据门诊的配置文件决定。可区分医院多种门诊点的情况 */
	private Integer mzlb;
	// @ApiModelProperty(value="挂号关联 | 该收费单与哪次挂号相联系,GHGL字段与OP_GHMX中SBXH关联")
	/** 挂号关联 | 该收费单与哪次挂号相联系,GHGL字段与OP_GHMX中SBXH关联 */
	private Integer ghgl;
	// @ApiModelProperty(value="操作工号")
	/** 操作工号 */
	private String czgh;
	// @ApiModelProperty(value="结帐日期 | 收费员个人结帐时间表示该发票是否结帐")
	/** 结帐日期 | 收费员个人结帐时间表示该发票是否结帐 */
	private Timestamp jzrq;
	// @ApiModelProperty(value="汇总日期 | 收费处每日汇总时间，每日只能汇总一次")
	/** 汇总日期 | 收费处每日汇总时间，每日只能汇总一次 */
	private Timestamp hzrq;
	// @ApiModelProperty(value="收费方式 | 0.真实发票 1.门诊虚拟发票 2.药房虚拟发票 3.医技虚拟发票")
	/** 收费方式 | 0.真实发票 1.门诊虚拟发票 2.药房虚拟发票 3.医技虚拟发票 */
	private Integer sffs;
	// @ApiModelProperty(value="合并标志 | 虚拟发票是否合并打印 0.未合并，1.合并")
	/** 合并标志 | 虚拟发票是否合并打印 0.未合并，1.合并 */
	private Integer hbbz;
	// @ApiModelProperty(value="虚拟发票")
	/** 虚拟发票 */
	private String xnfp;
	// @ApiModelProperty(value="交款金额")
	/** 交款金额 */
	private BigDecimal jkje;
	// @ApiModelProperty(value="退找金额")
	/** 退找金额 */
	private BigDecimal tzje;
	// @ApiModelProperty(value="年度")
	/** 年度 */
	private String nd;
	// @ApiModelProperty(value="结算流水号")
	/** 结算流水号 */
	private String jslsh;
	// @ApiModelProperty(value="结算单号 | 医保返回")
	/** 结算单号 | 医保返回 */
	private String jsdh;
	// @ApiModelProperty(value="参保险种")
	/** 参保险种 */
	private String cbxz;
	// @ApiModelProperty(value="核准金额")
	/** 核准金额 */
	private BigDecimal hzje;
	// @ApiModelProperty(value="基金支付")
	/** 基金支付 */
	private BigDecimal jjzfje;
	// @ApiModelProperty(value="费用总额")
	/** 费用总额 */
	private BigDecimal fyze;
	// @ApiModelProperty(value="mzjzje")
	/** mzjzje */
	private BigDecimal mzjzje;
	// @ApiModelProperty(value="fffs")
	/** fffs */
	private Integer fffs;
	// @ApiModelProperty(value="移动出诊收费 | 0.表示移动出诊收费，用以区分BS版收费")
	/** 移动出诊收费 | 0.表示移动出诊收费，用以区分BS版收费 */
	private String ydczsf;
	// @ApiModelProperty(value="移动出诊发票补打 | 0.发票没有补打;1.发票已经补打.发票只能打印一次.")
	/** 移动出诊发票补打 | 0.发票没有补打;1.发票已经补打.发票只能打印一次. */
	private String ydczfpbd;
	// @ApiModelProperty(value="发票张数")
	/** 发票张数 */
	private Integer fpzs;
	// @ApiModelProperty(value="fwbxx")
	/** fwbxx */
	private String fwbxx;
	// @ApiModelProperty(value="卡类别标志")
	/** 卡类别标志 */
	private Integer klbbz;
	// @ApiModelProperty(value="卡内数据")
	/** 卡内数据 */
	private String knsj;
	// @ApiModelProperty(value="医保支付金额")
	/** 医保支付金额 */
	private BigDecimal ybzfje;
	// @ApiModelProperty(value="医保交易流水号")
	/** 医保交易流水号 */
	private String ybjylsh;
	// @ApiModelProperty(value="zhbz")
	/** zhbz */
	private String zhbz;
	// @ApiModelProperty(value="dbxm")
	/** dbxm */
	private String dbxm;
	// @ApiModelProperty(value="fjddffj")
	/** fjddffj */
	private BigDecimal fjddffj;
	// @ApiModelProperty(value="fjdlnzh")
	/** fjdlnzh */
	private BigDecimal fjdlnzh;
	// @ApiModelProperty(value="tcdtc")
	/** tcdtc */
	private BigDecimal tcdtc;
	// @ApiModelProperty(value="tcdlnzh")
	/** tcdlnzh */
	private BigDecimal tcdlnzh;
	// @ApiModelProperty(value="zfddnzh")
	/** zfddnzh */
	private BigDecimal zfddnzh;
	// @ApiModelProperty(value="zfdlnzh")
	/** zfdlnzh */
	private BigDecimal zfdlnzh;
	// @ApiModelProperty(value="flzf")
	/** flzf */
	private BigDecimal flzf;
	// @ApiModelProperty(value="czfje")
	/** czfje */
	private BigDecimal czfje;
	// @ApiModelProperty(value="ybks")
	/** ybks */
	private String ybks;
	// @ApiModelProperty(value="fyetdjid")
	/** fyetdjid */
	private Integer fyetdjid;
	// @ApiModelProperty(value="grbh")
	/** grbh */
	private String grbh;
	// @ApiModelProperty(value="fyetbrxz")
	/** fyetbrxz */
	private String fyetbrxz;
	// @ApiModelProperty(value="fyetjmje")
	/** fyetjmje */
	private BigDecimal fyetjmje;
	// @ApiModelProperty(value="就诊卡号")
	/** 就诊卡号 */
	private String jzkh;
	// @ApiModelProperty(value="登记ID")
	/** 登记ID */
	private String djid;
	// @ApiModelProperty(value="报销金额")
	/** 报销金额 */
	private String bxje;
	// @ApiModelProperty(value="农合编号")
	/** 农合编号 */
	private String nhbh;
	// @ApiModelProperty(value="农合报销ID")
	/** 农合报销ID */
	private String nhbxid;
	// @ApiModelProperty(value="农合报销日期")
	/** 农合报销日期 */
	private String nhbxrq;
	// @ApiModelProperty(value="爱心卡套餐编号")
	/** 爱心卡套餐编号 */
	private String axktcbh;
	// @ApiModelProperty(value="爱心卡减免金额")
	/** 爱心卡减免金额 */
	private BigDecimal axkjmje;
	// @ApiModelProperty(value="社保交易流水号")
	/** 社保交易流水号 */
	private String sblsh;
	// @ApiModelProperty(value="个人自费")
	/** 个人自费 */
	private BigDecimal fygrzf;
	// @ApiModelProperty(value="个人自理")
	/** 个人自理 */
	private BigDecimal fyflzf;
	// @ApiModelProperty(value="医保统筹")
	/** 医保统筹 */
	private BigDecimal fyybtz;
	// @ApiModelProperty(value="自费补助")
	/** 自费补助 */
	private BigDecimal grzfzfs;
	// @ApiModelProperty(value="自费现金")
	/** 自费现金 */
	private BigDecimal grzfxj;
	// @ApiModelProperty(value="自负救助")
	/** 自负救助 */
	private BigDecimal flzfzfs;
	// @ApiModelProperty(value="自负现金")
	/** 自负现金 */
	private BigDecimal flzfxj;
	// @ApiModelProperty(value="自费补助累计")
	/** 自费补助累计 */
	private BigDecimal grzfzfslj;
	// @ApiModelProperty(value="自负补助累计")
	/** 自负补助累计 */
	private BigDecimal flzfzfslj;
	// @ApiModelProperty(value="交易流水号")
	/** 交易流水号 */
	private String mzjzlsh;
	// @ApiModelProperty(value="结算申请号")
	/** 结算申请号 */
	private String jssqh;
	// @ApiModelProperty(value="真实发票号码")
	/** 真实发票号码 */
	private String zsfphm;
	// @ApiModelProperty(value="真实发票标志 1、补打真实发票(不显示)")
	/** 真实发票标志 1、补打真实发票(不显示) */
	private String zsfpbz;
	// @ApiModelProperty(value="减免金额")
	/** 减免金额 */
	private BigDecimal jmje;
	// @ApiModelProperty(value="免赔金额")
	/** 免赔金额 */
	private BigDecimal mpje;
	// @ApiModelProperty(value="理赔金额")
	/** 理赔金额 */
	private BigDecimal lpje;
	// @ApiModelProperty(value="汇率损益金额")
	/** 汇率损益金额 */
	private BigDecimal hlsyje;
	// @ApiModelProperty(value="超付金额")
	/** 超付金额 */
	private BigDecimal cfje;
	// @ApiModelProperty(value="已冲账金额")
	/** 已冲账金额 */
	private BigDecimal yczje;
	// @ApiModelProperty(value="已发生坏账金额")
	/** 已发生坏账金额 */
	private BigDecimal yhzje;
	// @ApiModelProperty(value="binvcode")
	/** binvcode */
	private String binvcode;
	// @ApiModelProperty(value="binvnr")
	/** binvnr */
	private String binvnr;
	// @ApiModelProperty(value="挂账单位名称:限支付方式为挂账时，录入的备注信息")
	/** 挂账单位名称:限支付方式为挂账时，录入的备注信息 */
	private String gzdwmc;
	@JsonIgnore
	@ApiModelProperty(value = "查询开始时间")
	private Timestamp beginOfDay;
	@JsonIgnore
	@ApiModelProperty(value = "查询结束时间")
	private Timestamp endOfDay;
	@ApiModelProperty(value = "门诊就诊流水号")
	private String jzlsh;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "医生代码")
	private Integer ysdm;
	@ApiModelProperty(value = "配送金额")
	private BigDecimal psje;


	/** 设置:门诊序号 */
	public void setMzxh(Integer value) {
		this.mzxh = value;
	}

	/** 获取:门诊序号 */
	public Integer getMzxh() {
		return mzxh;
	}

	/** 设置:机构代码 */
	public void setJgid(String value) {
		this.jgid = value;
	}

	/** 获取:机构代码 */
	public String getJgid() {
		return jgid;
	}

	/** 设置:发票号码 | 连接OP_SFMX,OP_CF01,OP_YJCF01 */
	public void setFphm(String value) {
		this.fphm = value;
	}

	/** 获取:发票号码 | 连接OP_SFMX,OP_CF01,OP_YJCF01 */
	public String getFphm() {
		return fphm;
	}

	/** 设置:收费日期 */
	public void setSfrq(Date value) {
		this.sfrq = value;
	}

	/** 获取:收费日期 */
	public Date getSfrq() {
		return sfrq;
	}

	/** 设置:病人ID号 | 内部标示一个病人的编号在MPI_BRDA库中每一个MZHM与一个ID号相关联，用于唯一标示一个病人 */
	public void setBrid(Integer value) {
		this.brid = value;
	}

	/** 获取:病人ID号 | 内部标示一个病人的编号在MPI_BRDA库中每一个MZHM与一个ID号相关联，用于唯一标示一个病人 */
	public Integer getBrid() {
		return brid;
	}

	/** 设置:病人姓名 */
	public void setBrxm(String value) {
		this.brxm = value;
	}

	/** 获取:病人姓名 */
	public String getBrxm() {
		return brxm;
	}

	/** 设置:病人性别 | 与GY_DMZD（DMSB=15）对应 */
	public void setBrxb(Integer value) {
		this.brxb = value;
	}

	/** 获取:病人性别 | 与GY_DMZD（DMSB=15）对应 */
	public Integer getBrxb() {
		return brxb;
	}

	/** 设置:病人性质 | 与PUB_BRXZ中BRXZ关联 */
	public void setBrxz(Integer value) {
		this.brxz = value;
	}

	/** 获取:病人性质 | 与PUB_BRXZ中BRXZ关联 */
	public Integer getBrxz() {
		return brxz;
	}

	/** 设置:医疗证号 */
	public void setFyzh(String value) {
		this.fyzh = value;
	}

	/** 获取:医疗证号 */
	public String getFyzh() {
		return fyzh;
	}

	/** 设置:单位序号 */
	public void setDwxh(Integer value) {
		this.dwxh = value;
	}

	/** 获取:单位序号 */
	public Integer getDwxh() {
		return dwxh;
	}

	/**
	 * 设置:现金金额 | XJJE+ZPJE+QTJE+QTYS+HBWC=
	 * OP_SFMX中该发票的ZJJE之和但XJJE+ZPJE+QTJE不一定等于OP_SFMX中该发票的ZFJE之和
	 */
	public void setXjje(BigDecimal value) {
		this.xjje = value;
	}

	/**
	 * 获取:现金金额 | XJJE+ZPJE+QTJE+QTYS+HBWC=
	 * OP_SFMX中该发票的ZJJE之和但XJJE+ZPJE+QTJE不一定等于OP_SFMX中该发票的ZFJE之和
	 */
	public BigDecimal getXjje() {
		return xjje;
	}

	/** 设置:支票金额 */
	public void setZpje(BigDecimal value) {
		this.zpje = value;
	}

	/** 获取:支票金额 */
	public BigDecimal getZpje() {
		return zpje;
	}

	/** 设置:帐户金额 */
	public void setZhje(BigDecimal value) {
		this.zhje = value;
	}

	/** 获取:帐户金额 */
	public BigDecimal getZhje() {
		return zhje;
	}

	/** 设置:货币误差 */
	public void setHbwc(BigDecimal value) {
		this.hbwc = value;
	}

	/** 获取:货币误差 */
	public BigDecimal getHbwc() {
		return hbwc;
	}

	/** 设置:其他应收 */
	public void setQtys(BigDecimal value) {
		this.qtys = value;
	}

	/** 获取:其他应收 */
	public BigDecimal getQtys() {
		return qtys;
	}

	/** 设置:总计金额 */
	public void setZjje(BigDecimal value) {
		this.zjje = value;
	}

	/** 获取:总计金额 */
	public BigDecimal getZjje() {
		return zjje;
	}

	/** 设置:自负金额 */
	public void setZfje(BigDecimal value) {
		this.zfje = value;
	}

	/** 获取:自负金额 */
	public BigDecimal getZfje() {
		return zfje;
	}

	/** 设置:帐户类别 | 与MS_ZHLB中CODE关联 */
	public void setZhlb(Integer value) {
		this.zhlb = value;
	}

	/** 获取:帐户类别 | 与MS_ZHLB中CODE关联 */
	public Integer getZhlb() {
		return zhlb;
	}

	/** 设置:作废判别 | 1.作废 0.未作废 */
	public void setZfpb(Integer value) {
		this.zfpb = value;
	}

	/** 获取:作废判别 | 1.作废 0.未作废 */
	public Integer getZfpb() {
		return zfpb;
	}

	/** 设置:退号判别 | 1.退费发票(包括原发票和现发票)0.非退费发票 */
	public void setThpb(Integer value) {
		this.thpb = value;
	}

	/** 获取:退号判别 | 1.退费发票(包括原发票和现发票)0.非退费发票 */
	public Integer getThpb() {
		return thpb;
	}

	/** 设置:发票关联 | 用于退费，特指该退费发票的原发票 */
	public void setFpgl(String value) {
		this.fpgl = value;
	}

	/** 获取:发票关联 | 用于退费，特指该退费发票的原发票 */
	public String getFpgl() {
		return fpgl;
	}

	/** 设置:门诊关联 */
	public void setMzgl(Integer value) {
		this.mzgl = value;
	}

	/** 获取:门诊关联 */
	public Integer getMzgl() {
		return mzgl;
	}

	/** 设置:门诊类别 | 根据门诊的配置文件决定。可区分医院多种门诊点的情况 */
	public void setMzlb(Integer value) {
		this.mzlb = value;
	}

	/** 获取:门诊类别 | 根据门诊的配置文件决定。可区分医院多种门诊点的情况 */
	public Integer getMzlb() {
		return mzlb;
	}

	/** 设置:挂号关联 | 该收费单与哪次挂号相联系,GHGL字段与OP_GHMX中SBXH关联 */
	public void setGhgl(Integer value) {
		this.ghgl = value;
	}

	/** 获取:挂号关联 | 该收费单与哪次挂号相联系,GHGL字段与OP_GHMX中SBXH关联 */
	public Integer getGhgl() {
		return ghgl;
	}

	/** 设置:操作工号 */
	public void setCzgh(String value) {
		this.czgh = value;
	}

	/** 获取:操作工号 */
	public String getCzgh() {
		return czgh;
	}

	/** 设置:结帐日期 | 收费员个人结帐时间表示该发票是否结帐 */
	public void setJzrq(Timestamp value) {
		this.jzrq = value;
	}

	/** 获取:结帐日期 | 收费员个人结帐时间表示该发票是否结帐 */
	public Timestamp getJzrq() {
		return jzrq;
	}

	/** 设置:汇总日期 | 收费处每日汇总时间，每日只能汇总一次 */
	public void setHzrq(Timestamp value) {
		this.hzrq = value;
	}

	/** 获取:汇总日期 | 收费处每日汇总时间，每日只能汇总一次 */
	public Timestamp getHzrq() {
		return hzrq;
	}

	/** 设置:收费方式 | 0.真实发票 1.门诊虚拟发票 2.药房虚拟发票 3.医技虚拟发票 */
	public void setSffs(Integer value) {
		this.sffs = value;
	}

	/** 获取:收费方式 | 0.真实发票 1.门诊虚拟发票 2.药房虚拟发票 3.医技虚拟发票 */
	public Integer getSffs() {
		return sffs;
	}

	/** 设置:合并标志 | 虚拟发票是否合并打印 0.未合并，1.合并 */
	public void setHbbz(Integer value) {
		this.hbbz = value;
	}

	/** 获取:合并标志 | 虚拟发票是否合并打印 0.未合并，1.合并 */
	public Integer getHbbz() {
		return hbbz;
	}

	/** 设置:虚拟发票 */
	public void setXnfp(String value) {
		this.xnfp = value;
	}

	/** 获取:虚拟发票 */
	public String getXnfp() {
		return xnfp;
	}

	/** 设置:交款金额 */
	public void setJkje(BigDecimal value) {
		this.jkje = value;
	}

	/** 获取:交款金额 */
	public BigDecimal getJkje() {
		return jkje;
	}

	/** 设置:退找金额 */
	public void setTzje(BigDecimal value) {
		this.tzje = value;
	}

	/** 获取:退找金额 */
	public BigDecimal getTzje() {
		return tzje;
	}

	/** 设置:年度 */
	public void setNd(String value) {
		this.nd = value;
	}

	/** 获取:年度 */
	public String getNd() {
		return nd;
	}

	/** 设置:结算流水号 */
	public void setJslsh(String value) {
		this.jslsh = value;
	}

	/** 获取:结算流水号 */
	public String getJslsh() {
		return jslsh;
	}

	/** 设置:结算单号 | 医保返回 */
	public void setJsdh(String value) {
		this.jsdh = value;
	}

	/** 获取:结算单号 | 医保返回 */
	public String getJsdh() {
		return jsdh;
	}

	/** 设置:参保险种 */
	public void setCbxz(String value) {
		this.cbxz = value;
	}

	/** 获取:参保险种 */
	public String getCbxz() {
		return cbxz;
	}

	/** 设置:核准金额 */
	public void setHzje(BigDecimal value) {
		this.hzje = value;
	}

	/** 获取:核准金额 */
	public BigDecimal getHzje() {
		return hzje;
	}

	/** 设置:基金支付 */
	public void setJjzfje(BigDecimal value) {
		this.jjzfje = value;
	}

	/** 获取:基金支付 */
	public BigDecimal getJjzfje() {
		return jjzfje;
	}

	/** 设置:费用总额 */
	public void setFyze(BigDecimal value) {
		this.fyze = value;
	}

	/** 获取:费用总额 */
	public BigDecimal getFyze() {
		return fyze;
	}

	/** 设置:mzjzje */
	public void setMzjzje(BigDecimal value) {
		this.mzjzje = value;
	}

	/** 获取:mzjzje */
	public BigDecimal getMzjzje() {
		return mzjzje;
	}

	/** 设置:fffs */
	public void setFffs(Integer value) {
		this.fffs = value;
	}

	/** 获取:fffs */
	public Integer getFffs() {
		return fffs;
	}

	/** 设置:移动出诊收费 | 0.表示移动出诊收费，用以区分BS版收费 */
	public void setYdczsf(String value) {
		this.ydczsf = value;
	}

	/** 获取:移动出诊收费 | 0.表示移动出诊收费，用以区分BS版收费 */
	public String getYdczsf() {
		return ydczsf;
	}

	/** 设置:移动出诊发票补打 | 0.发票没有补打;1.发票已经补打.发票只能打印一次. */
	public void setYdczfpbd(String value) {
		this.ydczfpbd = value;
	}

	/** 获取:移动出诊发票补打 | 0.发票没有补打;1.发票已经补打.发票只能打印一次. */
	public String getYdczfpbd() {
		return ydczfpbd;
	}

	/** 设置:发票张数 */
	public void setFpzs(Integer value) {
		this.fpzs = value;
	}

	/** 获取:发票张数 */
	public Integer getFpzs() {
		return fpzs;
	}

	/** 设置:fwbxx */
	public void setFwbxx(String value) {
		this.fwbxx = value;
	}

	/** 获取:fwbxx */
	public String getFwbxx() {
		return fwbxx;
	}

	/** 设置:卡类别标志 */
	public void setKlbbz(Integer value) {
		this.klbbz = value;
	}

	/** 获取:卡类别标志 */
	public Integer getKlbbz() {
		return klbbz;
	}

	/** 设置:卡内数据 */
	public void setKnsj(String value) {
		this.knsj = value;
	}

	/** 获取:卡内数据 */
	public String getKnsj() {
		return knsj;
	}

	/** 设置:医保支付金额 */
	public void setYbzfje(BigDecimal value) {
		this.ybzfje = value;
	}

	/** 获取:医保支付金额 */
	public BigDecimal getYbzfje() {
		return ybzfje;
	}

	/** 设置:医保交易流水号 */
	public void setYbjylsh(String value) {
		this.ybjylsh = value;
	}

	/** 获取:医保交易流水号 */
	public String getYbjylsh() {
		return ybjylsh;
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

	/** 设置:fjdlnzh */
	public void setFjdlnzh(BigDecimal value) {
		this.fjdlnzh = value;
	}

	/** 获取:fjdlnzh */
	public BigDecimal getFjdlnzh() {
		return fjdlnzh;
	}

	/** 设置:tcdtc */
	public void setTcdtc(BigDecimal value) {
		this.tcdtc = value;
	}

	/** 获取:tcdtc */
	public BigDecimal getTcdtc() {
		return tcdtc;
	}

	/** 设置:tcdlnzh */
	public void setTcdlnzh(BigDecimal value) {
		this.tcdlnzh = value;
	}

	/** 获取:tcdlnzh */
	public BigDecimal getTcdlnzh() {
		return tcdlnzh;
	}

	/** 设置:zfddnzh */
	public void setZfddnzh(BigDecimal value) {
		this.zfddnzh = value;
	}

	/** 获取:zfddnzh */
	public BigDecimal getZfddnzh() {
		return zfddnzh;
	}

	/** 设置:zfdlnzh */
	public void setZfdlnzh(BigDecimal value) {
		this.zfdlnzh = value;
	}

	/** 获取:zfdlnzh */
	public BigDecimal getZfdlnzh() {
		return zfdlnzh;
	}

	/** 设置:flzf */
	public void setFlzf(BigDecimal value) {
		this.flzf = value;
	}

	/** 获取:flzf */
	public BigDecimal getFlzf() {
		return flzf;
	}

	/** 设置:czfje */
	public void setCzfje(BigDecimal value) {
		this.czfje = value;
	}

	/** 获取:czfje */
	public BigDecimal getCzfje() {
		return czfje;
	}

	/** 设置:ybks */
	public void setYbks(String value) {
		this.ybks = value;
	}

	/** 获取:ybks */
	public String getYbks() {
		return ybks;
	}

	/** 设置:fyetdjid */
	public void setFyetdjid(Integer value) {
		this.fyetdjid = value;
	}

	/** 获取:fyetdjid */
	public Integer getFyetdjid() {
		return fyetdjid;
	}

	/** 设置:grbh */
	public void setGrbh(String value) {
		this.grbh = value;
	}

	/** 获取:grbh */
	public String getGrbh() {
		return grbh;
	}

	/** 设置:fyetbrxz */
	public void setFyetbrxz(String value) {
		this.fyetbrxz = value;
	}

	/** 获取:fyetbrxz */
	public String getFyetbrxz() {
		return fyetbrxz;
	}

	/** 设置:fyetjmje */
	public void setFyetjmje(BigDecimal value) {
		this.fyetjmje = value;
	}

	/** 获取:fyetjmje */
	public BigDecimal getFyetjmje() {
		return fyetjmje;
	}

	/** 设置:就诊卡号 */
	public void setJzkh(String value) {
		this.jzkh = value;
	}

	/** 获取:就诊卡号 */
	public String getJzkh() {
		return jzkh;
	}

	/** 设置:登记ID */
	public void setDjid(String value) {
		this.djid = value;
	}

	/** 获取:登记ID */
	public String getDjid() {
		return djid;
	}

	/** 设置:报销金额 */
	public void setBxje(String value) {
		this.bxje = value;
	}

	/** 获取:报销金额 */
	public String getBxje() {
		return bxje;
	}

	/** 设置:农合编号 */
	public void setNhbh(String value) {
		this.nhbh = value;
	}

	/** 获取:农合编号 */
	public String getNhbh() {
		return nhbh;
	}

	/** 设置:农合报销ID */
	public void setNhbxid(String value) {
		this.nhbxid = value;
	}

	/** 获取:农合报销ID */
	public String getNhbxid() {
		return nhbxid;
	}

	/** 设置:农合报销日期 */
	public void setNhbxrq(String value) {
		this.nhbxrq = value;
	}

	/** 获取:农合报销日期 */
	public String getNhbxrq() {
		return nhbxrq;
	}

	/** 设置:爱心卡套餐编号 */
	public void setAxktcbh(String value) {
		this.axktcbh = value;
	}

	/** 获取:爱心卡套餐编号 */
	public String getAxktcbh() {
		return axktcbh;
	}

	/** 设置:爱心卡减免金额 */
	public void setAxkjmje(BigDecimal value) {
		this.axkjmje = value;
	}

	/** 获取:爱心卡减免金额 */
	public BigDecimal getAxkjmje() {
		return axkjmje;
	}

	/** 设置:社保交易流水号 */
	public void setSblsh(String value) {
		this.sblsh = value;
	}

	/** 获取:社保交易流水号 */
	public String getSblsh() {
		return sblsh;
	}

	/** 设置:个人自费 */
	public void setFygrzf(BigDecimal value) {
		this.fygrzf = value;
	}

	/** 获取:个人自费 */
	public BigDecimal getFygrzf() {
		return fygrzf;
	}

	/** 设置:个人自理 */
	public void setFyflzf(BigDecimal value) {
		this.fyflzf = value;
	}

	/** 获取:个人自理 */
	public BigDecimal getFyflzf() {
		return fyflzf;
	}

	/** 设置:医保统筹 */
	public void setFyybtz(BigDecimal value) {
		this.fyybtz = value;
	}

	/** 获取:医保统筹 */
	public BigDecimal getFyybtz() {
		return fyybtz;
	}

	/** 设置:自费补助 */
	public void setGrzfzfs(BigDecimal value) {
		this.grzfzfs = value;
	}

	/** 获取:自费补助 */
	public BigDecimal getGrzfzfs() {
		return grzfzfs;
	}

	/** 设置:自费现金 */
	public void setGrzfxj(BigDecimal value) {
		this.grzfxj = value;
	}

	/** 获取:自费现金 */
	public BigDecimal getGrzfxj() {
		return grzfxj;
	}

	/** 设置:自负救助 */
	public void setFlzfzfs(BigDecimal value) {
		this.flzfzfs = value;
	}

	/** 获取:自负救助 */
	public BigDecimal getFlzfzfs() {
		return flzfzfs;
	}

	/** 设置:自负现金 */
	public void setFlzfxj(BigDecimal value) {
		this.flzfxj = value;
	}

	/** 获取:自负现金 */
	public BigDecimal getFlzfxj() {
		return flzfxj;
	}

	/** 设置:自费补助累计 */
	public void setGrzfzfslj(BigDecimal value) {
		this.grzfzfslj = value;
	}

	/** 获取:自费补助累计 */
	public BigDecimal getGrzfzfslj() {
		return grzfzfslj;
	}

	/** 设置:自负补助累计 */
	public void setFlzfzfslj(BigDecimal value) {
		this.flzfzfslj = value;
	}

	/** 获取:自负补助累计 */
	public BigDecimal getFlzfzfslj() {
		return flzfzfslj;
	}

	/** 设置:交易流水号 */
	public void setMzjzlsh(String value) {
		this.mzjzlsh = value;
	}

	/** 获取:交易流水号 */
	public String getMzjzlsh() {
		return mzjzlsh;
	}

	/** 设置:结算申请号 */
	public void setJssqh(String value) {
		this.jssqh = value;
	}

	/** 获取:结算申请号 */
	public String getJssqh() {
		return jssqh;
	}

	/** 设置:真实发票号码 */
	public void setZsfphm(String value) {
		this.zsfphm = value;
	}

	/** 获取:真实发票号码 */
	public String getZsfphm() {
		return zsfphm;
	}

	/** 设置:真实发票标志 1、补打真实发票(不显示) */
	public void setZsfpbz(String value) {
		this.zsfpbz = value;
	}

	/** 获取:真实发票标志 1、补打真实发票(不显示) */
	public String getZsfpbz() {
		return zsfpbz;
	}

	/** 设置:减免金额 */
	public void setJmje(BigDecimal value) {
		this.jmje = value;
	}

	/** 获取:减免金额 */
	public BigDecimal getJmje() {
		return jmje;
	}

	/** 设置:免赔金额 */
	public void setMpje(BigDecimal value) {
		this.mpje = value;
	}

	/** 获取:免赔金额 */
	public BigDecimal getMpje() {
		return mpje;
	}

	/** 设置:理赔金额 */
	public void setLpje(BigDecimal value) {
		this.lpje = value;
	}

	/** 获取:理赔金额 */
	public BigDecimal getLpje() {
		return lpje;
	}

	/** 设置:汇率损益金额 */
	public void setHlsyje(BigDecimal value) {
		this.hlsyje = value;
	}

	/** 获取:汇率损益金额 */
	public BigDecimal getHlsyje() {
		return hlsyje;
	}

	/** 设置:超付金额 */
	public void setCfje(BigDecimal value) {
		this.cfje = value;
	}

	/** 获取:超付金额 */
	public BigDecimal getCfje() {
		return cfje;
	}

	/** 设置:已冲账金额 */
	public void setYczje(BigDecimal value) {
		this.yczje = value;
	}

	/** 获取:已冲账金额 */
	public BigDecimal getYczje() {
		return yczje;
	}

	/** 设置:已发生坏账金额 */
	public void setYhzje(BigDecimal value) {
		this.yhzje = value;
	}

	/** 获取:已发生坏账金额 */
	public BigDecimal getYhzje() {
		return yhzje;
	}

	/** 设置:binvcode */
	public void setBinvcode(String value) {
		this.binvcode = value;
	}

	/** 获取:binvcode */
	public String getBinvcode() {
		return binvcode;
	}

	/** 设置:binvnr */
	public void setBinvnr(String value) {
		this.binvnr = value;
	}

	/** 获取:binvnr */
	public String getBinvnr() {
		return binvnr;
	}

	/** 设置:挂账单位名称:限支付方式为挂账时，录入的备注信息 */
	public void setGzdwmc(String value) {
		this.gzdwmc = value;
	}

	/** 获取:挂账单位名称:限支付方式为挂账时，录入的备注信息 */
	public String getGzdwmc() {
		return gzdwmc;
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

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Integer getYsdm() {
		return ysdm;
	}

	public void setYsdm(Integer ysdm) {
		this.ysdm = ysdm;
	}

	public BigDecimal getPsje() {
		return psje;
	}

	public void setPsje(BigDecimal psje) {
		this.psje = psje;
	}

	public String getCdfphm() {
		return cdfphm;
	}

	public void setCdfphm(String cdfphm) {
		this.cdfphm = cdfphm;
	}
}
