package com.buit.commons.model;

import java.sql.Date;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;

/**
 * 类名称：PubJmbr<br>
 * 类描述：减免患者
 * 
 * @author WY
 * 
 */
@ApiModel(value = "减免患者")
public class PubJmbr extends PageQuery {
	// @ApiModelProperty(value="性质")
	/** 性质 */
	private Integer brxz;
	// @ApiModelProperty(value="证号")
	/** 证号 */
	private String fyzh;
	// @ApiModelProperty(value="妇幼单位主键")
	/** 妇幼单位主键 */
	private Integer fydw;
	// @ApiModelProperty(value="病人姓名")
	/** 病人姓名 */
	private String brxm;
	// @ApiModelProperty(value="拼音代码")
	/** 拼音代码 */
	private String pydm;
	// @ApiModelProperty(value="性别")
	/** 性别 */
	private Integer brxb;
	// @ApiModelProperty(value="出生年月")
	/** 出生年月 */
	private Date csny;
	// @ApiModelProperty(value="领证日期")
	/** 领证日期 */
	private Date lzrq;
	// @ApiModelProperty(value="家长姓名")
	/** 家长姓名 */
	private String jzxm;
	// @ApiModelProperty(value="作废判别")
	/** 作废判别 */
	private Integer zfpb;
	// @ApiModelProperty(value="证号有效期")
	/** 证号有效期 */
	private Date zhxq;
	// @ApiModelProperty(value="标识")
	/** 标识 */
	private Integer scbz;

	/** 设置:性质 */
	public void setBrxz(Integer value) {
		this.brxz = value;
	}

	/** 获取:性质 */
	public Integer getBrxz() {
		return brxz;
	}

	/** 设置:证号 */
	public void setFyzh(String value) {
		this.fyzh = value;
	}

	/** 获取:证号 */
	public String getFyzh() {
		return fyzh;
	}

	/** 设置:妇幼单位主键 */
	public void setFydw(Integer value) {
		this.fydw = value;
	}

	/** 获取:妇幼单位主键 */
	public Integer getFydw() {
		return fydw;
	}

	/** 设置:病人姓名 */
	public void setBrxm(String value) {
		this.brxm = value;
	}

	/** 获取:病人姓名 */
	public String getBrxm() {
		return brxm;
	}

	/** 设置:拼音代码 */
	public void setPydm(String value) {
		this.pydm = value;
	}

	/** 获取:拼音代码 */
	public String getPydm() {
		return pydm;
	}

	/** 设置:性别 */
	public void setBrxb(Integer value) {
		this.brxb = value;
	}

	/** 获取:性别 */
	public Integer getBrxb() {
		return brxb;
	}

	/** 设置:出生年月 */
	public void setCsny(Date value) {
		this.csny = value;
	}

	/** 获取:出生年月 */
	public Date getCsny() {
		return csny;
	}

	/** 设置:领证日期 */
	public void setLzrq(Date value) {
		this.lzrq = value;
	}

	/** 获取:领证日期 */
	public Date getLzrq() {
		return lzrq;
	}

	/** 设置:家长姓名 */
	public void setJzxm(String value) {
		this.jzxm = value;
	}

	/** 获取:家长姓名 */
	public String getJzxm() {
		return jzxm;
	}

	/** 设置:作废判别 */
	public void setZfpb(Integer value) {
		this.zfpb = value;
	}

	/** 获取:作废判别 */
	public Integer getZfpb() {
		return zfpb;
	}

	/** 设置:证号有效期 */
	public void setZhxq(Date value) {
		this.zhxq = value;
	}

	/** 获取:证号有效期 */
	public Date getZhxq() {
		return zhxq;
	}

	/** 设置:标识 */
	public void setScbz(Integer value) {
		this.scbz = value;
	}

	/** 获取:标识 */
	public Integer getScbz() {
		return scbz;
	}

}
