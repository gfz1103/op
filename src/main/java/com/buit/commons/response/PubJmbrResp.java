
package com.buit.commons.response;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：PubJmbrResp<br>
 * 类描述：妇幼病人返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "妇幼病人返回")
public class PubJmbrResp extends PageQuery {
	private static final long serialVersionUID = 7133802781076702839L;
	@ApiModelProperty(value = "性质")
	private Integer brxz;
	@ApiModelProperty(value = "证号")
	private String fyzh;
	@ApiModelProperty(value = "妇幼单位主键")
	private Integer fydw;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "拼音代码")
	private String pydm;
	@ApiModelProperty(value = "性别")
	private Integer brxb;
	@ApiModelProperty(value = "出生年月")
	private Timestamp csny;
	@ApiModelProperty(value = "领证日期")
	private Timestamp lzrq;
	@ApiModelProperty(value = "家长姓名")
	private String jzxm;
	@ApiModelProperty(value = "作废判别")
	private Integer zfpb;
	@ApiModelProperty(value = "证号有效期")
	private Timestamp zhxq;
	@ApiModelProperty(value = "标识")
	private Integer scbz;

	/**
	 * 设置:性质
	 */
	public void setBrxz(Integer value) {
		this.brxz = value;
	}

	/**
	 * 获取:性质
	 */
	public Integer getBrxz() {
		return brxz;
	}

	/**
	 * 设置:证号
	 */
	public void setFyzh(String value) {
		this.fyzh = value;
	}

	/**
	 * 获取:证号
	 */
	public String getFyzh() {
		return fyzh;
	}

	/**
	 * 设置:妇幼单位主键
	 */
	public void setFydw(Integer value) {
		this.fydw = value;
	}

	/**
	 * 获取:妇幼单位主键
	 */
	public Integer getFydw() {
		return fydw;
	}

	/**
	 * 设置:病人姓名
	 */
	public void setBrxm(String value) {
		this.brxm = value;
	}

	/**
	 * 获取:病人姓名
	 */
	public String getBrxm() {
		return brxm;
	}

	/**
	 * 设置:拼音代码
	 */
	public void setPydm(String value) {
		this.pydm = value;
	}

	/**
	 * 获取:拼音代码
	 */
	public String getPydm() {
		return pydm;
	}

	/**
	 * 设置:性别
	 */
	public void setBrxb(Integer value) {
		this.brxb = value;
	}

	/**
	 * 获取:性别
	 */
	public Integer getBrxb() {
		return brxb;
	}

	/**
	 * 设置:出生年月
	 */
	public void setCsny(Timestamp value) {
		this.csny = value;
	}

	/**
	 * 获取:出生年月
	 */
	public Timestamp getCsny() {
		return csny;
	}

	/**
	 * 设置:领证日期
	 */
	public void setLzrq(Timestamp value) {
		this.lzrq = value;
	}

	/**
	 * 获取:领证日期
	 */
	public Timestamp getLzrq() {
		return lzrq;
	}

	/**
	 * 设置:家长姓名
	 */
	public void setJzxm(String value) {
		this.jzxm = value;
	}

	/**
	 * 获取:家长姓名
	 */
	public String getJzxm() {
		return jzxm;
	}

	/**
	 * 设置:作废判别
	 */
	public void setZfpb(Integer value) {
		this.zfpb = value;
	}

	/**
	 * 获取:作废判别
	 */
	public Integer getZfpb() {
		return zfpb;
	}

	/**
	 * 设置:证号有效期
	 */
	public void setZhxq(Timestamp value) {
		this.zhxq = value;
	}

	/**
	 * 获取:证号有效期
	 */
	public Timestamp getZhxq() {
		return zhxq;
	}

	/**
	 * 设置:标识
	 */
	public void setScbz(Integer value) {
		this.scbz = value;
	}

	/**
	 * 获取:标识
	 */
	public Integer getScbz() {
		return scbz;
	}
}
