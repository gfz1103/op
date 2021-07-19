
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：PubJmlx<br>
 * 类描述：<br>
 * 
 * @author WY
 */
@ApiModel(value = "减免政策返回")
public class PubJmlxResp extends PageQuery {
	@ApiModelProperty(value = "主键")
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
	@ApiModelProperty(value = "拼音码")
	private String pydm;
	@ApiModelProperty(value = "五笔码")
	private String wbdm;
	@ApiModelProperty(value = "角形码")
	private String jxdm;
	@ApiModelProperty(value = "其他编码")
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

	/**
	 * 设置:主键
	 */
	public void setFydw(Integer value) {
		this.fydw = value;
	}

	/**
	 * 获取:主键
	 */
	public Integer getFydw() {
		return fydw;
	}

	/**
	 * 设置:性质
	 */
	public void setGsxz(Integer value) {
		this.gsxz = value;
	}

	/**
	 * 获取:性质
	 */
	public Integer getGsxz() {
		return gsxz;
	}

	/**
	 * 设置:单位名称
	 */
	public void setDwmc(String value) {
		this.dwmc = value;
	}

	/**
	 * 获取:单位名称
	 */
	public String getDwmc() {
		return dwmc;
	}

	/**
	 * 设置:单位编号
	 */
	public void setDwbh(String value) {
		this.dwbh = value;
	}

	/**
	 * 获取:单位编号
	 */
	public String getDwbh() {
		return dwbh;
	}

	/**
	 * 设置:单位地址
	 */
	public void setDwdz(String value) {
		this.dwdz = value;
	}

	/**
	 * 获取:单位地址
	 */
	public String getDwdz() {
		return dwdz;
	}

	/**
	 * 设置:单位电话
	 */
	public void setDwdh(String value) {
		this.dwdh = value;
	}

	/**
	 * 获取:单位电话
	 */
	public String getDwdh() {
		return dwdh;
	}

	/**
	 * 设置:单位邮编
	 */
	public void setDwyb(String value) {
		this.dwyb = value;
	}

	/**
	 * 获取:单位邮编
	 */
	public String getDwyb() {
		return dwyb;
	}

	/**
	 * 设置:开户银行
	 */
	public void setKhyh(String value) {
		this.khyh = value;
	}

	/**
	 * 获取:开户银行
	 */
	public String getKhyh() {
		return khyh;
	}

	/**
	 * 设置:银行账号
	 */
	public void setYhzh(String value) {
		this.yhzh = value;
	}

	/**
	 * 获取:银行账号
	 */
	public String getYhzh() {
		return yhzh;
	}

	/**
	 * 设置:负责人
	 */
	public void setFzr(String value) {
		this.fzr = value;
	}

	/**
	 * 获取:负责人
	 */
	public String getFzr() {
		return fzr;
	}

	/**
	 * 设置:拼音码
	 */
	public void setPydm(String value) {
		this.pydm = value;
	}

	/**
	 * 获取:拼音码
	 */
	public String getPydm() {
		return pydm;
	}

	/**
	 * 设置:五笔码
	 */
	public void setWbdm(String value) {
		this.wbdm = value;
	}

	/**
	 * 获取:五笔码
	 */
	public String getWbdm() {
		return wbdm;
	}

	/**
	 * 设置:角形码
	 */
	public void setJxdm(String value) {
		this.jxdm = value;
	}

	/**
	 * 获取:角形码
	 */
	public String getJxdm() {
		return jxdm;
	}

	/**
	 * 设置:其他编码
	 */
	public void setQtbm(String value) {
		this.qtbm = value;
	}

	/**
	 * 获取:其他编码
	 */
	public String getQtbm() {
		return qtbm;
	}

	/**
	 * 设置:备注信息
	 */
	public void setBzxx(String value) {
		this.bzxx = value;
	}

	/**
	 * 获取:备注信息
	 */
	public String getBzxx() {
		return bzxx;
	}

	/**
	 * 设置:作废判别 0：未作废 1：已作废
	 */
	public void setZfpb(Integer value) {
		this.zfpb = value;
	}

	/**
	 * 获取:作废判别 0：未作废 1：已作废
	 */
	public Integer getZfpb() {
		return zfpb;
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
