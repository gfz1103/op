
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsInitGhksResp<br>
 * 类描述：门诊_挂号科室<br>
 * 
 * @author WY
 */
@ApiModel(value = "初始化挂号管理信息")
public class MsInitGhksResp extends PageQuery {
	private static final long serialVersionUID = 7707934382609524940L;
	@ApiModelProperty(value = "就诊代码")
	private String jzhm;
	@ApiModelProperty(value = "机构代码")
	private Timestamp ghrq;
	@ApiModelProperty(value = "值班类别")
	private String zblb;
	@ApiModelProperty(value = "病历金额")
	private BigDecimal blje;
	@ApiModelProperty(value = "磁卡金额")
	private BigDecimal ckje;

	public Timestamp getGhrq() {
		return ghrq;
	}

	public void setGhrq(Timestamp ghrq) {
		this.ghrq = ghrq;
	}

	public String getZblb() {
		return zblb;
	}

	public void setZblb(String zblb) {
		this.zblb = zblb;
	}

	public String getJzhm() {
		return jzhm;
	}

	public void setJzhm(String jzhm) {
		this.jzhm = jzhm;
	}

	public BigDecimal getBlje() {
		return blje;
	}

	public void setBlje(BigDecimal blje) {
		this.blje = blje;
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

}