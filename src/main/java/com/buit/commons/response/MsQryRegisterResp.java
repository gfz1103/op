
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import com.buit.commons.model.YbGhjs;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsQryRegisterResp<br>
 * 类描述：挂号结算查询<br>
 * 
 * @author WY
 */
@ApiModel(value = "挂号结算查询")
public class MsQryRegisterResp extends PageQuery {
	private static final long serialVersionUID = -3053465581784921363L;
	@ApiModelProperty(value = "付款方式")
	private Integer fkfs;
	@ApiModelProperty(value = "总计金额")
	private BigDecimal zjje;
	@ApiModelProperty(value = "自负金额")
	private BigDecimal zfje;
	@ApiModelProperty(value = "应收款")
	private BigDecimal qtys;
	@ApiModelProperty(value = "应收款(新)")
	private BigDecimal ysk;
	@ApiModelProperty(value = "减免金额")
	private BigDecimal jmje;
	@ApiModelProperty(value = "医保信息对象")
	private YbGhjs ybxx;
	@ApiModelProperty(value="卡类型")
	private String cardtype;
	@ApiModelProperty(value="卡号")
	private String cardid;
	@ApiModelProperty(value="账户标志")
	private String accountattr;
	@ApiModelProperty(value="总金额")
	private String totalexpense;
	@ApiModelProperty(value="医保结算金额")
	private String ybjsfwfyze;
	@ApiModelProperty(value="非医保结算金额")
	private String fybjsfwfyze;
	@ApiModelProperty(value="诊疗费")
	private String zlf;
	@ApiModelProperty(value="挂号费")
	private String ghf;
	@ApiModelProperty(value="专家费")
	private String zjfy;
	@ApiModelProperty(value="减免结算标志")
	private String jmjsbz;
	@ApiModelProperty(value="结算申请序号")
	private String jssqxh;
	@ApiModelProperty(value="工伤认定号")
	private String gsrdh;
	@ApiModelProperty(value="大病代码")
	private String dbtype;
	@ApiModelProperty(value="医疗类别")
	private String yllb;
	@ApiModelProperty(value="是否大病")
	private String isdb;

	public Integer getFkfs() {
		return fkfs;
	}

	public void setFkfs(Integer fkfs) {
		this.fkfs = fkfs;
	}

	public BigDecimal getZjje() {
		return zjje;
	}

	public void setZjje(BigDecimal zjje) {
		this.zjje = zjje;
	}

	public BigDecimal getZfje() {
		return zfje;
	}

	public void setZfje(BigDecimal zfje) {
		this.zfje = zfje;
	}

	public BigDecimal getQtys() {
		return qtys;
	}

	public void setQtys(BigDecimal qtys) {
		this.qtys = qtys;
	}

	public BigDecimal getYsk() {
		return ysk;
	}

	public void setYsk(BigDecimal ysk) {
		this.ysk = ysk;
	}

	public BigDecimal getJmje() {
		return jmje;
	}

	public void setJmje(BigDecimal jmje) {
		this.jmje = jmje;
	}

	public YbGhjs getYbxx() {
		return ybxx;
	}

	public void setYbxx(YbGhjs ybxx) {
		this.ybxx = ybxx;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
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

	public String getTotalexpense() {
		return totalexpense;
	}

	public void setTotalexpense(String totalexpense) {
		this.totalexpense = totalexpense;
	}

	public String getYbjsfwfyze() {
		return ybjsfwfyze;
	}

	public void setYbjsfwfyze(String ybjsfwfyze) {
		this.ybjsfwfyze = ybjsfwfyze;
	}

	public String getFybjsfwfyze() {
		return fybjsfwfyze;
	}

	public void setFybjsfwfyze(String fybjsfwfyze) {
		this.fybjsfwfyze = fybjsfwfyze;
	}

	public String getZlf() {
		return zlf;
	}

	public void setZlf(String zlf) {
		this.zlf = zlf;
	}

	public String getGhf() {
		return ghf;
	}

	public void setGhf(String ghf) {
		this.ghf = ghf;
	}

	public String getJmjsbz() {
		return jmjsbz;
	}

	public void setJmjsbz(String jmjsbz) {
		this.jmjsbz = jmjsbz;
	}

	public String getJssqxh() {
		return jssqxh;
	}

	public void setJssqxh(String jssqxh) {
		this.jssqxh = jssqxh;
	}

	public String getGsrdh() {
		return gsrdh;
	}

	public void setGsrdh(String gsrdh) {
		this.gsrdh = gsrdh;
	}

	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}

	public String getYllb() {
		return yllb;
	}

	public void setYllb(String yllb) {
		this.yllb = yllb;
	}

	public String getIsdb() {
		return isdb;
	}

	public void setIsdb(String isdb) {
		this.isdb = isdb;
	}

	public String getZjfy() {
		return zjfy;
	}

	public void setZjfy(String zjfy) {
		this.zjfy = zjfy;
	}
}