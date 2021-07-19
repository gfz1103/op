
package com.buit.commons.request;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsGhxxReq<br>
 * 类描述：挂号信息请求<br>
 * 
 * @author wangyang
 */
@ApiModel(value = "挂号信息请求")
public class MsGhxxReq extends PageQuery {
	private static final long serialVersionUID = 4238783897272984668L;
	@ApiModelProperty(value = "挂号时间")
	private Date ghsj;
	@ApiModelProperty(value = "减免金额")
	private BigDecimal jmje;
	@ApiModelProperty(value = "总计金额")
	private BigDecimal zjje;
	@ApiModelProperty(value = "现金金额 ")
	private BigDecimal xjje;
	@ApiModelProperty(value = "自负金额")
	private BigDecimal zfje;
	@ApiModelProperty(value = "诊室ID")
	private String zsid;
	@ApiModelProperty(value = "病人ID号")
	private Integer brid;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "病人性质")
	private Integer brxz;
	@ApiModelProperty(value = "挂号类别")
	private Integer ghlb;
	@ApiModelProperty(value = "挂号金额 ")
	private BigDecimal ghje;
	@ApiModelProperty(value = "诊疗金额")
	private BigDecimal zlje;
	@ApiModelProperty(value = "病历金额")
	private BigDecimal blje;
	@ApiModelProperty(value = "专家费用")
	private BigDecimal zjfy;
	@ApiModelProperty(value = "医生代码 ")
	private String ysdm;
	@ApiModelProperty(value = "预约标志")
	private Integer yybz;
	@ApiModelProperty(value = "预约序号（预约网同步过来），默认1")
	private Integer yyxh;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "挂账单位名称")
	private String gzdwmc;
	@ApiModelProperty(value = "付款信息")
	private List<OpFkxxReq> fkxxList;
	@ApiModelProperty(value = "值班类别")
	private String zblb;
	@ApiModelProperty(value = "特需门诊")
	private Integer txmz;
	@ApiModelProperty(value = "挂号日期")
	private Date ghrq;
	@ApiModelProperty(value = "磁卡金额")
	private BigDecimal ckje;
	@ApiModelProperty(value = "挂号类型（0：普通门诊 1:急诊）")
	private Integer ghlx;
	@ApiModelProperty(value = "是否免费 0-不免费 1-义诊 2-免费")
	private Integer sfmf;
	@ApiModelProperty(value = "预检分诊流水号")
	private String lsh;
	@ApiModelProperty(value = "其他应收")
	private BigDecimal qtys;
	@ApiModelProperty(value = "互联网问诊金额")
	private BigDecimal wzje;
	@ApiModelProperty(value = "是否大病")
	private String isDb;
	@ApiModelProperty(value = "是否工伤")
	private String isGs;
	@ApiModelProperty(value = "大病类型")
	private String dbtype;
	@ApiModelProperty(value = "工伤认定号")
	private String gsrdh;
	@ApiModelProperty(value = "应收款")
	private BigDecimal ysk;
	@ApiModelProperty(value = "cardtype")
	private String cardtype;
	@ApiModelProperty(value = "cardid")
	private String cardid;

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public Date getGhsj() {
		return ghsj;
	}

	public void setGhsj(Date ghsj) {
		this.ghsj = ghsj;
	}

	public BigDecimal getJmje() {
		return jmje;
	}

	public void setJmje(BigDecimal jmje) {
		this.jmje = jmje;
	}

	public BigDecimal getZjje() {
		return zjje;
	}

	public void setZjje(BigDecimal zjje) {
		this.zjje = zjje;
	}

	public BigDecimal getXjje() {
		return xjje;
	}

	public void setXjje(BigDecimal xjje) {
		this.xjje = xjje;
	}

	public BigDecimal getZfje() {
		return zfje;
	}

	public void setZfje(BigDecimal zfje) {
		this.zfje = zfje;
	}

	public String getZsid() {
		return zsid;
	}

	public void setZsid(String zsid) {
		this.zsid = zsid;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public Integer getGhlb() {
		return ghlb;
	}

	public void setGhlb(Integer ghlb) {
		this.ghlb = ghlb;
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

	public BigDecimal getBlje() {
		return blje;
	}

	public void setBlje(BigDecimal blje) {
		this.blje = blje;
	}

	public BigDecimal getZjfy() {
		return zjfy;
	}

	public void setZjfy(BigDecimal zjfy) {
		this.zjfy = zjfy;
	}

	public String getYsdm() {
		return ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
	}

	public Integer getYybz() {
		return yybz;
	}

	public void setYybz(Integer yybz) {
		this.yybz = yybz;
	}

	public Integer getYyxh() {
		return yyxh;
	}

	public void setYyxh(Integer yyxh) {
		this.yyxh = yyxh;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public String getGzdwmc() {
		return gzdwmc;
	}

	public void setGzdwmc(String gzdwmc) {
		this.gzdwmc = gzdwmc;
	}

	public List<OpFkxxReq> getFkxxList() {
		return fkxxList;
	}

	public void setFkxxList(List<OpFkxxReq> fkxxList) {
		this.fkxxList = fkxxList;
	}

	public String getZblb() {
		return zblb;
	}

	public void setZblb(String zblb) {
		this.zblb = zblb;
	}

	public Integer getTxmz() {
		return txmz;
	}

	public void setTxmz(Integer txmz) {
		this.txmz = txmz;
	}

	public Date getGhrq() {
		return ghrq;
	}

	public void setGhrq(Date ghrq) {
		this.ghrq = ghrq;
	}

	public BigDecimal getCkje() {
		return ckje;
	}

	public void setCkje(BigDecimal ckje) {
		this.ckje = ckje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getGhlx() {
		return ghlx;
	}

	public void setGhlx(Integer ghlx) {
		this.ghlx = ghlx;
	}

	public Integer getSfmf() {
		return sfmf;
	}

	public void setSfmf(Integer sfmf) {
		this.sfmf = sfmf;
	}

	public String getLsh() {
		return lsh;
	}

	public void setLsh(String lsh) {
		this.lsh = lsh;
	}

	public BigDecimal getQtys() {
		return qtys;
	}

	public void setQtys(BigDecimal qtys) {
		this.qtys = qtys;
	}
	public String getIsDb() {
		return isDb;
	}

	public void setIsDb(String isDb) {
		this.isDb = isDb;
	}

	public String getIsGs() {
		return isGs;
	}

	public void setIsGs(String isGs) {
		this.isGs = isGs;
	}

	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}

	public String getGsrdh() {
		return gsrdh;
	}

	public void setGsrdh(String gsrdh) {
		this.gsrdh = gsrdh;
	}

	public BigDecimal getWzje() {
		return wzje;
	}

	public void setWzje(BigDecimal wzje) {
		this.wzje = wzje;
	}

	public BigDecimal getYsk() {
		return ysk;
	}

	public void setYsk(BigDecimal ysk) {
		this.ysk = ysk;
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
}