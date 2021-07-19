
package com.buit.commons.response;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：FpzfBrdaResp<br>
 * 类描述：发票作废病人信息<br>
 * 
 * @author WY
 */
@ApiModel(value = "发票作废病人信息")
public class FpzfBrdaResp extends PageQuery {
	@ApiModelProperty(value = "门诊序号")
	private Integer mzxh;
	@ApiModelProperty(value = "门诊号码")
	private String mzhm;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "病人性质 ")
	private Integer brxz;
	@ApiModelProperty(value = "性别")
	private Integer brxb;
	@ApiModelProperty(value = "出生年月")
	private Timestamp csny;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "自费判别")
	private Integer zfpb;
	@ApiModelProperty(value = "结账日期")
	private Timestamp jzrq;
	@ApiModelProperty(value = "年龄")
	private String age;
	@ApiModelProperty(value = "年龄")
	private String jzlsh;

	public Integer getMzxh() {
		return mzxh;
	}

	public void setMzxh(Integer mzxh) {
		this.mzxh = mzxh;
	}

	public String getMzhm() {
		return mzhm;
	}

	public void setMzhm(String mzhm) {
		this.mzhm = mzhm;
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

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

	public Timestamp getCsny() {
		return csny;
	}

	public void setCsny(Timestamp csny) {
		this.csny = csny;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public Integer getZfpb() {
		return zfpb;
	}

	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}

	public Timestamp getJzrq() {
		return jzrq;
	}

	public void setJzrq(Timestamp jzrq) {
		this.jzrq = jzrq;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

}