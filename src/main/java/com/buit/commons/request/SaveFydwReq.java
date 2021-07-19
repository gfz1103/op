
package com.buit.commons.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SaveFydwReq<br>
 * 类描述：新增妇幼单位请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "新增妇幼单位请求")
public class SaveFydwReq {
	@JsonIgnore
	@ApiModelProperty(value = "医疗机构")
	private Integer jgid;
	@ApiModelProperty(value = "妇幼单位")
	private Integer fydw;
	@ApiModelProperty(value = "性质")
	private Integer gsxz;
	@ApiModelProperty(value = "单位名称")
	private String dwmc;
	@ApiModelProperty(value = "单位编号")
	private String dwbh;
	@ApiModelProperty(value = "单位地址")
	private String dwdz;
	@ApiModelProperty(value = "单位电话")
	private String dwdh;
	@ApiModelProperty(value = "单位邮编")
	private String dwyb;
	@ApiModelProperty(value = "开户银行")
	private String khyh;
	@ApiModelProperty(value = "银行账号")
	private String yhzh;
	@ApiModelProperty(value = "负责人")
	private String fzr;
	@ApiModelProperty(value = "拼音代码")
	private String pydm;
	@ApiModelProperty(value = "五笔代码")
	private String wbdm;
	@ApiModelProperty(value = "角形代码")
	private String jxdm;
	@ApiModelProperty(value = "其他代码")
	private String qtbm;
	@ApiModelProperty(value = "备注信息")
	private String bzxx;
	@ApiModelProperty(value = "作废判别 0：未作废  1：已作废")
	private Integer zfpb;
	@ApiModelProperty(value = "挂号减免： 0：否 1：是")
	private String ghjm;
	@ApiModelProperty(value = "挂号减免百分比")
	private BigDecimal ghjmrate;
	@ApiModelProperty(value = "收费减免项目 SFXM")
	private String sfjm;
	@ApiModelProperty(value = "结算减免百分比")
	private BigDecimal jsjmrate;

	public Integer getGsxz() {
		return gsxz;
	}

	public void setGsxz(Integer gsxz) {
		this.gsxz = gsxz;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getDwbh() {
		return dwbh;
	}

	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}

	public String getDwdz() {
		return dwdz;
	}

	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}

	public String getDwdh() {
		return dwdh;
	}

	public void setDwdh(String dwdh) {
		this.dwdh = dwdh;
	}

	public String getDwyb() {
		return dwyb;
	}

	public void setDwyb(String dwyb) {
		this.dwyb = dwyb;
	}

	public String getKhyh() {
		return khyh;
	}

	public void setKhyh(String khyh) {
		this.khyh = khyh;
	}

	public String getYhzh() {
		return yhzh;
	}

	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}

	public String getFzr() {
		return fzr;
	}

	public void setFzr(String fzr) {
		this.fzr = fzr;
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

	public String getJxdm() {
		return jxdm;
	}

	public void setJxdm(String jxdm) {
		this.jxdm = jxdm;
	}

	public String getQtbm() {
		return qtbm;
	}

	public void setQtbm(String qtbm) {
		this.qtbm = qtbm;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}

	public Integer getZfpb() {
		return zfpb;
	}

	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getFydw() {
		return fydw;
	}

	public void setFydw(Integer fydw) {
		this.fydw = fydw;
	}

	public String getGhjm() {
		return ghjm;
	}

	public void setGhjm(String ghjm) {
		this.ghjm = ghjm;
	}

	public BigDecimal getGhjmrate() {
		return ghjmrate;
	}

	public void setGhjmrate(BigDecimal ghjmrate) {
		this.ghjmrate = ghjmrate;
	}

	public String getSfjm() {
		return sfjm;
	}

	public void setSfjm(String sfjm) {
		this.sfjm = sfjm;
	}

	public BigDecimal getJsjmrate() {
		return jsjmrate;
	}

	public void setJsjmrate(BigDecimal jsjmrate) {
		this.jsjmrate = jsjmrate;
	}

}