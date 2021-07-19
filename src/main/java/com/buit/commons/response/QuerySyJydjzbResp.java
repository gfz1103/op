
package com.buit.commons.response;

import java.sql.Date;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QuerySyJydjzbResp<br>
 * 类描述：分页查询输液/注射接药登记主表<br>
 * 
 * @author WY
 */
@ApiModel(value = "分页查询输液/注射接药登记主表返回")
public class QuerySyJydjzbResp extends PageQuery {
	@ApiModelProperty(value = "登记时间")
	private Timestamp djsj;
	@ApiModelProperty(value = "登记人代码")
	private Integer djrdm;
	@ApiModelProperty(value = "开始时间")
	private Timestamp kssj;
	@ApiModelProperty(value = "开始人代码")
	private Integer ksrdm;
	@ApiModelProperty(value = "完成时间")
	private Timestamp wcsj;
	@ApiModelProperty(value = "完成人代码")
	private Integer wcczrdm;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "病人年龄")
	private String age;
	@ApiModelProperty(value = "发票号")
	private String fphm;
	@ApiModelProperty(value = "输液/注射日期")
	private Date syrq;
	@ApiModelProperty(value = "状态 0未开始 1 输液/注射中/2 输液/注射完成")
	private String zt;
	@ApiModelProperty(value = "科室类别 1输液室/2注射室")
	private String kslb;
	@JsonIgnore
	@ApiModelProperty(value = "出生年月")
	private Timestamp csny;
	@ApiModelProperty(value = "登记单号")
	private String djdh;

	public String getKslb() {
		return kslb;
	}

	public void setKslb(String kslb) {
		this.kslb = kslb;
	}

	public Integer getDjrdm() {
		return djrdm;
	}

	public void setDjrdm(Integer djrdm) {
		this.djrdm = djrdm;
	}

	public Timestamp getKssj() {
		return kssj;
	}

	public void setKssj(Timestamp kssj) {
		this.kssj = kssj;
	}

	public Integer getKsrdm() {
		return ksrdm;
	}

	public void setKsrdm(Integer ksrdm) {
		this.ksrdm = ksrdm;
	}

	public Timestamp getWcsj() {
		return wcsj;
	}

	public void setWcsj(Timestamp wcsj) {
		this.wcsj = wcsj;
	}

	public Integer getWcczrdm() {
		return wcczrdm;
	}

	public void setWcczrdm(Integer wcczrdm) {
		this.wcczrdm = wcczrdm;
	}

	public Timestamp getDjsj() {
		return djsj;
	}

	public void setDjsj(Timestamp djsj) {
		this.djsj = djsj;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public Date getSyrq() {
		return syrq;
	}

	public void setSyrq(Date syrq) {
		this.syrq = syrq;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public Timestamp getCsny() {
		return csny;
	}

	public void setCsny(Timestamp csny) {
		this.csny = csny;
	}

	public String getDjdh() {
		return djdh;
	}

	public void setDjdh(String djdh) {
		this.djdh = djdh;
	}

}