
package com.buit.commons.request;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsQryRegisterReq<br>
 * 类描述：挂号查询请求<br>
 * 
 * @author wangyang
 */
@ApiModel(value = "挂号查询请求")
public class MsQryRegisterReq extends PageQuery {
	private static final long serialVersionUID = -8575255223354930348L;
	@ApiModelProperty(value = "病人性质")
	private Integer brxz;
	@ApiModelProperty(value = "挂号金额")
	private BigDecimal ghje;
	@ApiModelProperty(value = "诊疗金额")
	private BigDecimal zlje;
	@ApiModelProperty(value = "病例费金额")
	private BigDecimal blje;
	@ApiModelProperty(value = "专家费金额")
	private BigDecimal zjje;
	@ApiModelProperty(value = "个人需支付金额")
	private BigDecimal grxjzf;
	@ApiModelProperty(value = "磁卡金额")
	private BigDecimal ckje;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "付款方式  sys_dict_config:21")
	private Integer fkfs;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;

	@ApiModelProperty(value = "是否医保 || 1是 0否")
	private Integer isYb;
	@ApiModelProperty(value = "是否工伤 || 1是 0否")
	private Integer isGs;
	@ApiModelProperty(value = "工伤认定号")
	private String gsrdh;
	@ApiModelProperty(value = "是否大病 || 1是 0否")
	private Integer isDb;
	@ApiModelProperty(value = "大病项目代码")
	private String dbtype;
	@ApiModelProperty(value = "病人id")
	private Integer brid;
	@ApiModelProperty(value = "卡类别标志|| 0磁卡 1保障卡 3电子凭证")
	private String cardtype;
	@ApiModelProperty(value = "卡号")
	private String cardid;
	@ApiModelProperty(value = "令牌")
	private String ecToken;
	@ApiModelProperty(value = "账户标志")
	private String accountattr;
	@ApiModelProperty(value = "医保社区减免标志")
	private String ybsqjmbz;
	@ApiModelProperty(value = "减免策略")
	private Integer jmcl;
	@ApiModelProperty(value = "挂号科室")
	private Integer ksdm;
	@ApiModelProperty(value = "医疗类别")
	private Integer ghlx;
	@ApiModelProperty(value = "是否免费 0-不免费 1-义诊 2-免费")
	private Integer sfmf;
	@ApiModelProperty(value = "ip")
	private String ip;
	@JsonIgnore
	@ApiModelProperty(value = "员工代码")
	private Integer ygdm;
	@JsonIgnore
	@ApiModelProperty(value = "员工姓名")
	private String ygxm;

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
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

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public BigDecimal getGrxjzf() {
		return grxjzf;
	}

	public void setGrxjzf(BigDecimal grxjzf) {
		this.grxjzf = grxjzf;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public BigDecimal getZjje() {
		return zjje;
	}

	public void setZjje(BigDecimal zjje) {
		this.zjje = zjje;
	}

	public Integer getIsYb() {
		return isYb;
	}

	public void setIsYb(Integer isYb) {
		this.isYb = isYb;
	}

	public Integer getIsGs() {
		return isGs;
	}

	public void setIsGs(Integer isGs) {
		this.isGs = isGs;
	}

	public String getGsrdh() {
		return gsrdh;
	}

	public void setGsrdh(String gsrdh) {
		this.gsrdh = gsrdh;
	}

	public Integer getIsDb() {
		return isDb;
	}

	public void setIsDb(Integer isDb) {
		this.isDb = isDb;
	}

	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
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

	public String getAccountattr() {
		return accountattr;
	}

	public void setAccountattr(String accountattr) {
		this.accountattr = accountattr;
	}

	public String getYbsqjmbz() {
		return ybsqjmbz;
	}

	public void setYbsqjmbz(String ybsqjmbz) {
		this.ybsqjmbz = ybsqjmbz;
	}

	public Integer getJmcl() {
		return jmcl;
	}

	public void setJmcl(Integer jmcl) {
		this.jmcl = jmcl;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}


	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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

	public String getEcToken() {
		return ecToken;
	}

	public void setEcToken(String ecToken) {
		this.ecToken = ecToken;
	}

	public Integer getYgdm() {
		return ygdm;
	}

	public void setYgdm(Integer ygdm) {
		this.ygdm = ygdm;
	}

	public String getYgxm() {
		return ygxm;
	}

	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}
}