
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：明细上传-住院结算记录库<br>
 * 
 * @author beijunhua
 */
@ApiModel(value = "明细上传-住院结算记录库")
public class MxscZyjsjlkResp extends PageQuery {
	@ApiModelProperty(value = "流水号")
	private String LSH;
	@ApiModelProperty(value = "卡号")
	private String BRKH;
	@ApiModelProperty(value = "住院号")
	private String ZYHM;
	@ApiModelProperty(value = "住院天数")
	private String ZYDNUM;
	@ApiModelProperty(value = "开始日期")
	private String KSRQ;
	@ApiModelProperty(value = "入院诊断编码")
	private String RYZDBM;
	@ApiModelProperty(value = "入院诊断说明")
	private String RYZDMC;
	@ApiModelProperty(value = "结束日期")
	private String JSRQ;
	@ApiModelProperty(value = "住院标志")
	private String ZYJGBZ;
	@ApiModelProperty(value = "出院标志")
	private String CYBZ;
	@ApiModelProperty(value = "交易时间")
	private String JYSJ;
	@ApiModelProperty(value = "结算类型")
	private String JSLX;

	public String getLSH() {
		return LSH;
	}

	public void setLSH(String LSH) {
		this.LSH = LSH;
	}

	public String getBRKH() {
		return BRKH;
	}

	public void setBRKH(String BRKH) {
		this.BRKH = BRKH;
	}

	public String getZYHM() {
		return ZYHM;
	}

	public void setZYHM(String ZYHM) {
		this.ZYHM = ZYHM;
	}

	public String getZYDNUM() {
		return ZYDNUM;
	}

	public void setZYDNUM(String ZYDNUM) {
		this.ZYDNUM = ZYDNUM;
	}

	public String getKSRQ() {
		return KSRQ;
	}

	public void setKSRQ(String KSRQ) {
		this.KSRQ = KSRQ;
	}

	public String getRYZDBM() {
		return RYZDBM;
	}

	public void setRYZDBM(String RYZDBM) {
		this.RYZDBM = RYZDBM;
	}

	public String getRYZDMC() {
		return RYZDMC;
	}

	public void setRYZDMC(String RYZDMC) {
		this.RYZDMC = RYZDMC;
	}

	public String getJSRQ() {
		return JSRQ;
	}

	public void setJSRQ(String JSRQ) {
		this.JSRQ = JSRQ;
	}

	public String getZYJGBZ() {
		return ZYJGBZ;
	}

	public void setZYJGBZ(String ZYJGBZ) {
		this.ZYJGBZ = ZYJGBZ;
	}

	public String getCYBZ() {
		return CYBZ;
	}

	public void setCYBZ(String CYBZ) {
		this.CYBZ = CYBZ;
	}

	public String getJYSJ() {
		return JYSJ;
	}

	public void setJYSJ(String JYSJ) {
		this.JYSJ = JYSJ;
	}

	public String getJSLX() {
		return JSLX;
	}

	public void setJSLX(String JSLX) {
		this.JSLX = JSLX;
	}
}