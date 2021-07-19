
package com.buit.commons.request;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SaveFybrReq<br>
 * 类描述：新增减免患者请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "新增减免患者请求")
public class SaveFybrReq {
	@ApiModelProperty(value = "病人性质")
	private Integer brxz;
	@ApiModelProperty(value = "证号")
	private String fyzh;
	@ApiModelProperty(value = "减免政策主键")
	private Integer fydw;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "拼音代码")
	private String pydm;
	@ApiModelProperty(value = "性别")
	private Integer brxb;
	@ApiModelProperty(value = "出生年月")
	private Date csny;
	@ApiModelProperty(value = "领证日期")
	private Date lzrq;
	@ApiModelProperty(value = "家长姓名")
	private String jzxm;
	@ApiModelProperty(value = "作废判别")
	private Integer zfpb;
	@ApiModelProperty(value = "证号有效期")
	private Date zhxq;
	@ApiModelProperty(value = "标识")
	private Integer scbz;

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public String getFyzh() {
		return fyzh;
	}

	public void setFyzh(String fyzh) {
		this.fyzh = fyzh;
	}

	public Integer getFydw() {
		return fydw;
	}

	public void setFydw(Integer fydw) {
		this.fydw = fydw;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getPydm() {
		return pydm;
	}

	public void setPydm(String pydm) {
		this.pydm = pydm;
	}

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

	public Date getCsny() {
		return csny;
	}

	public void setCsny(Date csny) {
		this.csny = csny;
	}

	public Date getLzrq() {
		return lzrq;
	}

	public void setLzrq(Date lzrq) {
		this.lzrq = lzrq;
	}

	public String getJzxm() {
		return jzxm;
	}

	public void setJzxm(String jzxm) {
		this.jzxm = jzxm;
	}

	public Integer getZfpb() {
		return zfpb;
	}

	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}

	public Date getZhxq() {
		return zhxq;
	}

	public void setZhxq(Date zhxq) {
		this.zhxq = zhxq;
	}

	public Integer getScbz() {
		return scbz;
	}

	public void setScbz(Integer scbz) {
		this.scbz = scbz;
	}

}