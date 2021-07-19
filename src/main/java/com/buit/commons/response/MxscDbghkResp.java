
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：明细上传-门急诊大病挂号库<br>
 * 
 * @author beijunhua
 */
@ApiModel(value = "明细上传-门急诊大病挂号库")
public class MxscDbghkResp extends PageQuery {
	@ApiModelProperty(value = "流水号")
	private String ZXLSH;
	@ApiModelProperty(value = "卡号")
	private String BRKH;
	@ApiModelProperty(value = "账户标志")
	private String ZHBZ;
	@ApiModelProperty(value = "科室编码")
	private String KSBM;
	@ApiModelProperty(value = "科室名称")
	private String KSMC;
	@ApiModelProperty(value = "挂号费")
	private String GHF;
	@ApiModelProperty(value = "诊疗费")
	private String ZLF;
	@ApiModelProperty(value = "交易总费用")
	private String JYTOTFY;
	@ApiModelProperty(value = "医保范围总额")
	private String TOTFY;
	@ApiModelProperty(value = "非医保范围总额")
	private String ZF;
	@ApiModelProperty(value = "交易时间")
	private String JYSJ;
	@ApiModelProperty(value = "医保类型")
	private String YBLX;
	@ApiModelProperty(value = "结算类型")
	private String JSLX;
	@ApiModelProperty(value = "退费标志")
	private String TFBZ;
	@ApiModelProperty(value = "减免结算标志")
	private String JMJSBZ;
	@ApiModelProperty(value = "就诊流水号")
	private String JZLSH;

	public String getZXLSH() {
		return ZXLSH;
	}

	public void setZXLSH(String ZXLSH) {
		this.ZXLSH = ZXLSH;
	}

	public String getBRKH() {
		return BRKH;
	}

	public void setBRKH(String BRKH) {
		this.BRKH = BRKH;
	}

	public String getKSBM() {
		return KSBM;
	}

	public void setKSBM(String KSBM) {
		this.KSBM = KSBM;
	}

	public String getKSMC() {
		return KSMC;
	}

	public void setKSMC(String KSMC) {
		this.KSMC = KSMC;
	}

	public String getGHF() {
		return GHF;
	}

	public void setGHF(String GHF) {
		this.GHF = GHF;
	}

	public String getZLF() {
		return ZLF;
	}

	public void setZLF(String ZLF) {
		this.ZLF = ZLF;
	}

	public String getJYTOTFY() {
		return JYTOTFY;
	}

	public void setJYTOTFY(String JYTOTFY) {
		this.JYTOTFY = JYTOTFY;
	}

	public String getTOTFY() {
		return TOTFY;
	}

	public void setTOTFY(String TOTFY) {
		this.TOTFY = TOTFY;
	}

	public String getZF() {
		return ZF;
	}

	public void setZF(String ZF) {
		this.ZF = ZF;
	}

	public String getJYSJ() {
		return JYSJ;
	}

	public void setJYSJ(String JYSJ) {
		this.JYSJ = JYSJ;
	}

	public String getYBLX() {
		return YBLX;
	}

	public void setYBLX(String YBLX) {
		this.YBLX = YBLX;
	}

	public String getJSLX() {
		return JSLX;
	}

	public void setJSLX(String JSLX) {
		this.JSLX = JSLX;
	}

	public String getTFBZ() {
		return TFBZ;
	}

	public void setTFBZ(String TFBZ) {
		this.TFBZ = TFBZ;
	}

	public String getJZLSH() {
		return JZLSH;
	}

	public void setJZLSH(String JZLSH) {
		this.JZLSH = JZLSH;
	}

	public String getJMJSBZ() {
		return JMJSBZ;
	}

	public void setJMJSBZ(String JMJSBZ) {
		this.JMJSBZ = JMJSBZ;
	}

	public String getZHBZ() {
		return ZHBZ;
	}

	public void setZHBZ(String ZHBZ) {
		this.ZHBZ = ZHBZ;
	}
}