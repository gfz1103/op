
package com.buit.commons.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：工伤保险门诊报表<br>
 * 
 * @author beijunhua
 */
@ApiModel(value = "工伤保险门诊报表")
public class YbOpGsbxbResp extends PageQuery {
	@ApiModelProperty(value = "姓名")
	private String NAME;
	@ApiModelProperty(value = "保险编码(身份证)")
	private String BXID;
	@ApiModelProperty(value = "凭证号码")
	private String YBID;
	@ApiModelProperty(value = "工伤认定号")
	private String GSID;
	@ApiModelProperty(value = "就诊科别编码")
	private String KSID;
	@ApiModelProperty(value = "就诊科别名称")
	private String KSNA;
	@ApiModelProperty(value = "就诊日期")
	private String JZDATE;
	@ApiModelProperty(value = "就诊次数")
	private String JZNUM;
	@ApiModelProperty(value = "在退标志")
	private String GRXZ;
	@ApiModelProperty(value = "工伤资金支付")
	private String TCZF;
	@ApiModelProperty(value = "医保内总费用")
	private String TOTFY;
	@ApiModelProperty(value = "诊疗费")
	private String FY00;
	@ApiModelProperty(value = "治疗费")
	private String FY01;
	@ApiModelProperty(value = "手材费")
	private String FY02;
	@ApiModelProperty(value = "检查费")
	private String FY03;
	@ApiModelProperty(value = "化验费")
	private String FY04;
	@ApiModelProperty(value = "摄片费")
	private String FY05;
	@ApiModelProperty(value = "透视费")
	private String FY06;
	@ApiModelProperty(value = "西药费")
	private String FY07;
	@ApiModelProperty(value = "中成药费")
	private String FY08;
	@ApiModelProperty(value = "中草药费")
	private String FY09;
	@ApiModelProperty(value = "其它")
	private String FY10;
	@ApiModelProperty(value = "非医保个人自费")
	private String ZF;
	@ApiModelProperty(value = "诊断编码")
	private String ZDICD;
	@ApiModelProperty(value = "诊断说明")
	private String ZDNAME;
	@ApiModelProperty(value = "保健情况")
	private String BJQK;
	@ApiModelProperty(value = "上报年月")
	private String DAA;
	@ApiModelProperty(value = "医院法人码")
	private String YYID;
	@ApiModelProperty(value = "流水号")
	private String LSH;

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	public String getBXID() {
		return BXID;
	}

	public void setBXID(String BXID) {
		this.BXID = BXID;
	}

	public String getYBID() {
		return YBID;
	}

	public void setYBID(String YBID) {
		this.YBID = YBID;
	}

	public String getGSID() {
		return GSID;
	}

	public void setGSID(String GSID) {
		this.GSID = GSID;
	}

	public String getKSID() {
		return KSID;
	}

	public void setKSID(String KSID) {
		this.KSID = KSID;
	}

	public String getKSNA() {
		return KSNA;
	}

	public void setKSNA(String KSNA) {
		this.KSNA = KSNA;
	}

	public String getJZDATE() {
		return JZDATE;
	}

	public void setJZDATE(String JZDATE) {
		this.JZDATE = JZDATE;
	}

	public String getJZNUM() {
		return JZNUM;
	}

	public void setJZNUM(String JZNUM) {
		this.JZNUM = JZNUM;
	}

	public String getGRXZ() {
		return GRXZ;
	}

	public void setGRXZ(String GRXZ) {
		this.GRXZ = GRXZ;
	}

	public String getTCZF() {
		return TCZF;
	}

	public void setTCZF(String TCZF) {
		this.TCZF = TCZF;
	}

	public String getTOTFY() {
		return TOTFY;
	}

	public void setTOTFY(String TOTFY) {
		this.TOTFY = TOTFY;
	}

	public String getFY00() {
		return FY00;
	}

	public void setFY00(String FY00) {
		this.FY00 = FY00;
	}

	public String getFY01() {
		return FY01;
	}

	public void setFY01(String FY01) {
		this.FY01 = FY01;
	}

	public String getFY02() {
		return FY02;
	}

	public void setFY02(String FY02) {
		this.FY02 = FY02;
	}

	public String getFY03() {
		return FY03;
	}

	public void setFY03(String FY03) {
		this.FY03 = FY03;
	}

	public String getFY04() {
		return FY04;
	}

	public void setFY04(String FY04) {
		this.FY04 = FY04;
	}

	public String getFY05() {
		return FY05;
	}

	public void setFY05(String FY05) {
		this.FY05 = FY05;
	}

	public String getFY06() {
		return FY06;
	}

	public void setFY06(String FY06) {
		this.FY06 = FY06;
	}

	public String getFY07() {
		return FY07;
	}

	public void setFY07(String FY07) {
		this.FY07 = FY07;
	}

	public String getFY08() {
		return FY08;
	}

	public void setFY08(String FY08) {
		this.FY08 = FY08;
	}

	public String getFY09() {
		return FY09;
	}

	public void setFY09(String FY09) {
		this.FY09 = FY09;
	}

	public String getFY10() {
		return FY10;
	}

	public void setFY10(String FY10) {
		this.FY10 = FY10;
	}

	public String getZF() {
		return ZF;
	}

	public void setZF(String ZF) {
		this.ZF = ZF;
	}

	public String getZDICD() {
		return ZDICD;
	}

	public void setZDICD(String ZDICD) {
		this.ZDICD = ZDICD;
	}

	public String getZDNAME() {
		return ZDNAME;
	}

	public void setZDNAME(String ZDNAME) {
		this.ZDNAME = ZDNAME;
	}

	public String getBJQK() {
		return BJQK;
	}

	public void setBJQK(String BJQK) {
		this.BJQK = BJQK;
	}

	public String getDAA() {
		return DAA;
	}

	public void setDAA(String DAA) {
		this.DAA = DAA;
	}

	public String getYYID() {
		return YYID;
	}

	public void setYYID(String YYID) {
		this.YYID = YYID;
	}

	public String getLSH() {
		return LSH;
	}

	public void setLSH(String LSH) {
		this.LSH = LSH;
	}
}