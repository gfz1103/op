
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：明细上传-出院诊断库<br>
 * 
 * @author beijunhua
 */
@ApiModel(value = "明细上传-出院诊断库")
public class MxscCyzdkResp extends PageQuery {
	@ApiModelProperty(value = "流水号")
	private String LSH;
	@ApiModelProperty(value = "卡号")
	private String YBID;
	@ApiModelProperty(value = "住院号")
	private String ZYHM;
	@ApiModelProperty(value = "结束日期")
	private String JSRQ;
	@ApiModelProperty(value = "出院诊断编码")
	private String CYZDBM;
	@ApiModelProperty(value = "出院诊断说明")
	private String CYZDMC;
	@ApiModelProperty(value = "住院标志")
	private String ZYJGBZ;
	@ApiModelProperty(value = "治疗结果")
	private String ZLJG;
	@ApiModelProperty(value = "主要手术操作代码")
	private String BZ1;
	@ApiModelProperty(value = "交易时间")
	private String JYSJ;

	public String getLSH() {
		return LSH;
	}

	public void setLSH(String LSH) {
		this.LSH = LSH;
	}

	public String getYBID() {
		return YBID;
	}

	public void setYBID(String YBID) {
		this.YBID = YBID;
	}

	public String getZYHM() {
		return ZYHM;
	}

	public void setZYHM(String ZYHM) {
		this.ZYHM = ZYHM;
	}

	public String getJSRQ() {
		return JSRQ;
	}

	public void setJSRQ(String JSRQ) {
		this.JSRQ = JSRQ;
	}

	public String getCYZDBM() {
		return CYZDBM;
	}

	public void setCYZDBM(String CYZDBM) {
		this.CYZDBM = CYZDBM;
	}

	public String getCYZDMC() {
		return CYZDMC;
	}

	public void setCYZDMC(String CYZDMC) {
		this.CYZDMC = CYZDMC;
	}

	public String getZYJGBZ() {
		return ZYJGBZ;
	}

	public void setZYJGBZ(String ZYJGBZ) {
		this.ZYJGBZ = ZYJGBZ;
	}

	public String getZLJG() {
		return ZLJG;
	}

	public void setZLJG(String ZLJG) {
		this.ZLJG = ZLJG;
	}

	public String getBZ1() {
		return BZ1;
	}

	public void setBZ1(String BZ1) {
		this.BZ1 = BZ1;
	}

	public String getJYSJ() {
		return JYSJ;
	}

	public void setJYSJ(String JYSJ) {
		this.JYSJ = JYSJ;
	}
}