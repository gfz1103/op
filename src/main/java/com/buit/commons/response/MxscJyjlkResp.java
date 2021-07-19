
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：明细上传-交易记录库<br>
 * 
 * @author beijunhua
 */
@ApiModel(value = "明细上传-交易记录库")
public class MxscJyjlkResp extends PageQuery {
	@ApiModelProperty(value = "流水号")
	private String ZXLSH;
	@ApiModelProperty(value = "机构代码")
	private String JGID;
	@ApiModelProperty(value = "卡号")
	private String BRKH;
	@ApiModelProperty(value = "账户标志")
	private String ZHBZ;
	@ApiModelProperty(value = "病人类型")
	private String BRLX;
	@ApiModelProperty(value = "就诊次数")
	private String JZDNUM;
	@ApiModelProperty(value = "交易时间")
	private String JYSJ;
	@ApiModelProperty(value = "结算类型")
	private String JSLX;

	@ApiModelProperty(value = "交易总费用")
	private String JYTOTFY;
	@ApiModelProperty(value = "当年账户支付")
	private String DNZH;
	@ApiModelProperty(value = "历年账户支付")
	private String LNZH;
	@ApiModelProperty(value = "自负段现金")
	private String ZFDXJ;
	@ApiModelProperty(value = "起付段现金")
	private String QFDXJ;
	@ApiModelProperty(value = "起付段账户")
	private String QFDZH;
	@ApiModelProperty(value = "统筹段现金")
	private String TCDXJ;
	@ApiModelProperty(value = "统筹段账户支付")
	private String TCDZH;

	@ApiModelProperty(value = "统筹支付")
	private String TCZF;
	@ApiModelProperty(value = "附加段现金")
	private String FJDXJ;
	@ApiModelProperty(value = "附加段账户")
	private String FJZH;
	@ApiModelProperty(value = "附加支付")
	private String FJZF;
	@ApiModelProperty(value = "医保范围内总额")
	private String TOTFY;
	@ApiModelProperty(value = "非医保范围自费")
	private String ZF;
	@ApiModelProperty(value = "医保类型")
	private String YBLX;
	@ApiModelProperty(value = "发票号码")
	private String FPHM;
	@ApiModelProperty(value = "退费标志")
	private String TFBZ;
	@ApiModelProperty(value = "开始日期")
	private String KSRQ;
	@ApiModelProperty(value = "减负标志")
	private String JFBZ;
	@ApiModelProperty(value = "减负金额")
	private String JFXMJE;


	public String getZXLSH() {
		return ZXLSH;
	}

	public void setZXLSH(String ZXLSH) {
		this.ZXLSH = ZXLSH;
	}

	public String getJGID() {
		return JGID;
	}

	public void setJGID(String JGID) {
		this.JGID = JGID;
	}

	public String getBRKH() {
		return BRKH;
	}

	public void setBRKH(String BRKH) {
		this.BRKH = BRKH;
	}

	public String getZHBZ() {
		return ZHBZ;
	}

	public void setZHBZ(String ZHBZ) {
		this.ZHBZ = ZHBZ;
	}

	public String getBRLX() {
		return BRLX;
	}

	public void setBRLX(String BRLX) {
		this.BRLX = BRLX;
	}

	public String getJZDNUM() {
		return JZDNUM;
	}

	public void setJZDNUM(String JZDNUM) {
		this.JZDNUM = JZDNUM;
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

	public String getJYTOTFY() {
		return JYTOTFY;
	}

	public void setJYTOTFY(String JYTOTFY) {
		this.JYTOTFY = JYTOTFY;
	}

	public String getDNZH() {
		return DNZH;
	}

	public void setDNZH(String DNZH) {
		this.DNZH = DNZH;
	}

	public String getLNZH() {
		return LNZH;
	}

	public void setLNZH(String LNZH) {
		this.LNZH = LNZH;
	}

	public String getZFDXJ() {
		return ZFDXJ;
	}

	public void setZFDXJ(String ZFDXJ) {
		this.ZFDXJ = ZFDXJ;
	}

	public String getQFDXJ() {
		return QFDXJ;
	}

	public void setQFDXJ(String QFDXJ) {
		this.QFDXJ = QFDXJ;
	}

	public String getQFDZH() {
		return QFDZH;
	}

	public void setQFDZH(String QFDZH) {
		this.QFDZH = QFDZH;
	}

	public String getTCDXJ() {
		return TCDXJ;
	}

	public void setTCDXJ(String TCDXJ) {
		this.TCDXJ = TCDXJ;
	}

	public String getTCDZH() {
		return TCDZH;
	}

	public void setTCDZH(String TCDZH) {
		this.TCDZH = TCDZH;
	}

	public String getTCZF() {
		return TCZF;
	}

	public void setTCZF(String TCZF) {
		this.TCZF = TCZF;
	}

	public String getFJDXJ() {
		return FJDXJ;
	}

	public void setFJDXJ(String FJDXJ) {
		this.FJDXJ = FJDXJ;
	}

	public String getFJZH() {
		return FJZH;
	}

	public void setFJZH(String FJZH) {
		this.FJZH = FJZH;
	}

	public String getFJZF() {
		return FJZF;
	}

	public void setFJZF(String FJZF) {
		this.FJZF = FJZF;
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

	public String getYBLX() {
		return YBLX;
	}

	public void setYBLX(String YBLX) {
		this.YBLX = YBLX;
	}

	public String getFPHM() {
		return FPHM;
	}

	public void setFPHM(String FPHM) {
		this.FPHM = FPHM;
	}

	public String getTFBZ() {
		return TFBZ;
	}

	public void setTFBZ(String TFBZ) {
		this.TFBZ = TFBZ;
	}

	public String getKSRQ() {
		return KSRQ;
	}

	public void setKSRQ(String KSRQ) {
		this.KSRQ = KSRQ;
	}

	public String getJFBZ() {
		return JFBZ;
	}

	public void setJFBZ(String JFBZ) {
		this.JFBZ = JFBZ;
	}

	public String getJFXMJE() {
		return JFXMJE;
	}

	public void setJFXMJE(String JFXMJE) {
		this.JFXMJE = JFXMJE;
	}
}