package com.buit.commons.model;

import java.math.BigDecimal;
import java.sql.Date;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：PubJmlxJm<br>
 * 类描述：
 * 
 * @author WY
 * 
 */
@ApiModel(value = "减免政策减免类别")
public class PubJmlxJm extends PageQuery {
	private static final long serialVersionUID = -3155160436608775202L;
	@ApiModelProperty(value = "挂号减免： 0：否 1：是")
	private String ghjm;
	@ApiModelProperty(value = "挂号减免百分比")
	private BigDecimal ghjmrate;
	@ApiModelProperty(value = "收费减免项目 SFXM")
	private String sfjm;
	@ApiModelProperty(value = "结算减免百分比")
	private BigDecimal jsjmrate;
	@ApiModelProperty(value = "有效期")
	private Date zhxq;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getZhxq() {
		return zhxq;
	}

	public void setZhxq(Date zhxq) {
		this.zhxq = zhxq;
	}

}
