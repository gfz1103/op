package com.buit.commons.request;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MzxxReq<br>
 * 类描述：保存折扣信息中门诊信息请求
 * 
 * @author WY
 * 
 */
@ApiModel(value = "保存折扣信息中门诊信息请求")
public class MzxxReq extends PageQuery {
	private static final long serialVersionUID = -8360061739135397026L;
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
	@ApiModelProperty(value = "付款方式")
	private Integer fkfs;
	@ApiModelProperty(value = "发票号码 ")
	private String fphm;
	@ApiModelProperty(value = "发票张数")
	private Integer fpzs;
	@ApiModelProperty(value = "挂号关联")
	private Integer ghgl;
	@ApiModelProperty(value = "挂号科室")
	private Integer ghks;
	@ApiModelProperty(value = "")
	private Integer jhsyjmbz;
	@ApiModelProperty(value = "统筹支出")
	private Integer jjzf;
	@ApiModelProperty(value = "交款金额")
	private BigDecimal jkje;
	@ApiModelProperty(value = "减免金额")
	private BigDecimal jmje;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "科室名称")
	private String ksmc;
	@ApiModelProperty(value = "理赔金额")
	private BigDecimal lpje;
	@ApiModelProperty(value = "免赔金额")
	private BigDecimal mpje;
	@ApiModelProperty(value = "门诊号码")
	private Integer mzhm;
	@ApiModelProperty(value = "门诊类别 ")
	private Integer mzlb;
	@ApiModelProperty(value = "身份证号")
	private String sfzh;
	@ApiModelProperty(value = "退找金额")
	private BigDecimal tzje;
	@ApiModelProperty(value = "性质控制大类")
	private String xzdl;
	@ApiModelProperty(value = "应收款")
	private BigDecimal ysk;
	@ApiModelProperty(value = "诊断序号")
	private Integer zdxh;
	@ApiModelProperty(value = "自负金额")
	private BigDecimal zfje;
	@ApiModelProperty(value = "总计金额")
	private BigDecimal zjje;
	@ApiModelProperty(value = "就诊流水号")
	private String jzlsh;
	@ApiModelProperty(value = "挂号详细信息")
	private GhDetailsReq ghDetails;
	@ApiModelProperty(value = "保存标识")
	private boolean mxsave;
	@ApiModelProperty(value = "医生代码")
	private Integer ysdm;
	@ApiModelProperty(value = "删除数据")
	private List<QueryPayReq> removeData;
	@ApiModelProperty(value = "删除处方识别")
	private List<RemoveSettleReq> removeCfsb;
	@ApiModelProperty(value = "账户标志")
	private String accountattr;
	@ApiModelProperty(value = "卡类型")
	private String cardtype;
	@ApiModelProperty(value = "卡号")
	private String cardid;
	@ApiModelProperty(value = "计算申请序号")
	private String jssqxh;
	@ApiModelProperty(value = "就诊单元号")
	private String jzdyh;
	@ApiModelProperty(value = "医保金额")
	private BigDecimal qtys;

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

	public Integer getFkfs() {
		return fkfs;
	}

	public void setFkfs(Integer fkfs) {
		this.fkfs = fkfs;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public Integer getFpzs() {
		return fpzs;
	}

	public void setFpzs(Integer fpzs) {
		this.fpzs = fpzs;
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

	public Integer getJhsyjmbz() {
		return jhsyjmbz;
	}

	public void setJhsyjmbz(Integer jhsyjmbz) {
		this.jhsyjmbz = jhsyjmbz;
	}

	public Integer getJjzf() {
		return jjzf;
	}

	public void setJjzf(Integer jjzf) {
		this.jjzf = jjzf;
	}

	public BigDecimal getJkje() {
		return jkje;
	}

	public void setJkje(BigDecimal jkje) {
		this.jkje = jkje;
	}

	public BigDecimal getJmje() {
		return jmje;
	}

	public void setJmje(BigDecimal jmje) {
		this.jmje = jmje;
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

	public BigDecimal getLpje() {
		return lpje;
	}

	public void setLpje(BigDecimal lpje) {
		this.lpje = lpje;
	}

	public BigDecimal getMpje() {
		return mpje;
	}

	public void setMpje(BigDecimal mpje) {
		this.mpje = mpje;
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

	public BigDecimal getTzje() {
		return tzje;
	}

	public void setTzje(BigDecimal tzje) {
		this.tzje = tzje;
	}

	public String getXzdl() {
		return xzdl;
	}

	public void setXzdl(String xzdl) {
		this.xzdl = xzdl;
	}

	public BigDecimal getYsk() {
		return ysk;
	}

	public void setYsk(BigDecimal ysk) {
		this.ysk = ysk;
	}

	public Integer getZdxh() {
		return zdxh;
	}

	public void setZdxh(Integer zdxh) {
		this.zdxh = zdxh;
	}

	public BigDecimal getZfje() {
		return zfje;
	}

	public void setZfje(BigDecimal zfje) {
		this.zfje = zfje;
	}

	public BigDecimal getZjje() {
		return zjje;
	}

	public void setZjje(BigDecimal zjje) {
		this.zjje = zjje;
	}

	public GhDetailsReq getGhDetails() {
		return ghDetails;
	}

	public void setGhDetails(GhDetailsReq ghDetails) {
		this.ghDetails = ghDetails;
	}

	public boolean isMxsave() {
		return mxsave;
	}

	public void setMxsave(boolean mxsave) {
		this.mxsave = mxsave;
	}

	public List<QueryPayReq> getRemoveData() {
		return removeData;
	}

	public void setRemoveData(List<QueryPayReq> removeData) {
		this.removeData = removeData;
	}

	public List<RemoveSettleReq> getRemoveCfsb() {
		return removeCfsb;
	}

	public void setRemoveCfsb(List<RemoveSettleReq> removeCfsb) {
		this.removeCfsb = removeCfsb;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

	public Integer getYsdm() {
		return ysdm;
	}

	public void setYsdm(Integer ysdm) {
		this.ysdm = ysdm;
	}

	public String getAccountattr() {
		return accountattr;
	}

	public void setAccountattr(String accountattr) {
		this.accountattr = accountattr;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getJssqxh() {
		return jssqxh;
	}

	public void setJssqxh(String jssqxh) {
		this.jssqxh = jssqxh;
	}

	public String getJzdyh() {
		return jzdyh;
	}

	public void setJzdyh(String jzdyh) {
		this.jzdyh = jzdyh;
	}

	public BigDecimal getQtys() {
		return qtys;
	}

	public void setQtys(BigDecimal qtys) {
		this.qtys = qtys;
	}
}