
package com.buit.commons.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：城镇居民住院上报表<br>
 * 
 * @author beijunhua
 */
@ApiModel(value = "城镇居民住院上报表")
public class CzjmzySbbResp extends PageQuery {
	@ApiModelProperty(value = "住院号")
	private String ZYID;
	@ApiModelProperty(value = "姓名")
	private String NAME;
	@ApiModelProperty(value = "身份证")
	private String BXID;
	@ApiModelProperty(value = "凭证号码")
	private String YBID;
	@ApiModelProperty(value = "出院日期")
	private String CYDATE;
	@ApiModelProperty(value = "住院天数")
	private String ZYDNUM;
	@ApiModelProperty(value = "项目")
	private String ZYJGBZ;
	@ApiModelProperty(value = "科别编码")
	private String KSID;
	@ApiModelProperty(value = "科别名称")
	private String KSNA;
	@ApiModelProperty(value = "在退标识")
	private String GRXZ;
	@ApiModelProperty(value = "总费额")
	private String JYTOTFY;
	@ApiModelProperty(value = "现金支付起付线")
	private String GRXJD;
	@ApiModelProperty(value = "现金支付起其余")
	private String GRXJQ;
	@ApiModelProperty(value = "医保支付")
	private String YBZF;
	@ApiModelProperty(value = "医保结算范围费用总额")
	private String TOTFY;
	@ApiModelProperty(value = "住院费")
	private String FY01;
	@ApiModelProperty(value = "诊疗费")
	private String FY02;
	@ApiModelProperty(value = "治疗费")
	private String FY03;
	@ApiModelProperty(value = "护理费")
	private String FY04;
	@ApiModelProperty(value = "手术材料费")
	private String FY05;
	@ApiModelProperty(value = "检查费")
	private String FY06;
	@ApiModelProperty(value = "化验费")
	private String FY07;
	@ApiModelProperty(value = "摄片费")
	private String FY08;
	@ApiModelProperty(value = "透视费")
	private String FY09;
	@ApiModelProperty(value = "输血费")
	private String FY10;
	@ApiModelProperty(value = "输氧费")
	private String FY11;
	@ApiModelProperty(value = "西药费")
	private String FY12;
	@ApiModelProperty(value = "中成药费")
	private String FY13;
	@ApiModelProperty(value = "中草药费")
	private String FY14;
	@ApiModelProperty(value = "其他")
	private String FY15;
	@ApiModelProperty(value = "自负合计")
	private String FLGRZF;
	@ApiModelProperty(value = "自负住院费")
	private String FY20;
	@ApiModelProperty(value = "自负诊疗费")
	private String FY21;
	@ApiModelProperty(value = "自负治疗费")
	private String FY22;
	@ApiModelProperty(value = "自负护理费")
	private String FY23;
	@ApiModelProperty(value = "自负手术材料费")
	private String FY24;
	@ApiModelProperty(value = "自负检查")
	private String FY25;
	@ApiModelProperty(value = "自负化验费")
	private String FY26;
	@ApiModelProperty(value = "自负摄片费")
	private String FY27;
	@ApiModelProperty(value = "自负透视费")
	private String FY28;
	@ApiModelProperty(value = "自负输血费")
	private String FY29;
	@ApiModelProperty(value = "自负输氧费")
	private String FY30;
	@ApiModelProperty(value = "自负西药费")
	private String FY31;
	@ApiModelProperty(value = "自负中成药费")
	private String FY32;
	@ApiModelProperty(value = "自负中草药费")
	private String FY33;
	@ApiModelProperty(value = "自负其他")
	private String FY34;
	@ApiModelProperty(value = "非医保个人自费")
	private String ZF;
	@ApiModelProperty(value = "诊断编码")
	private String ZDICD;
	@ApiModelProperty(value = "诊断说明")
	private String ZDNAME;
	@ApiModelProperty(value = "上报年月")
	private String DAA;
	@ApiModelProperty(value = "医院法人码")
	private String YYID;
	@ApiModelProperty(value = "流水号")
	private String LSH;

	public String getZYID() {
		return ZYID;
	}

	public void setZYID(String ZYID) {
		this.ZYID = ZYID;
	}

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

	public String getCYDATE() {
		return CYDATE;
	}

	public void setCYDATE(String CYDATE) {
		this.CYDATE = CYDATE;
	}

	public String getZYDNUM() {
		return ZYDNUM;
	}

	public void setZYDNUM(String ZYDNUM) {
		this.ZYDNUM = ZYDNUM;
	}

	public String getZYJGBZ() {
		return ZYJGBZ;
	}

	public void setZYJGBZ(String ZYJGBZ) {
		this.ZYJGBZ = ZYJGBZ;
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

	public String getGRXZ() {
		return GRXZ;
	}

	public void setGRXZ(String GRXZ) {
		this.GRXZ = GRXZ;
	}

	public String getJYTOTFY() {
		return JYTOTFY;
	}

	public void setJYTOTFY(String JYTOTFY) {
		this.JYTOTFY = JYTOTFY;
	}

	public String getGRXJD() {
		return GRXJD;
	}

	public void setGRXJD(String GRXJD) {
		this.GRXJD = GRXJD;
	}

	public String getGRXJQ() {
		return GRXJQ;
	}

	public void setGRXJQ(String GRXJQ) {
		this.GRXJQ = GRXJQ;
	}

	public String getYBZF() {
		return YBZF;
	}

	public void setYBZF(String YBZF) {
		this.YBZF = YBZF;
	}

	public String getTOTFY() {
		return TOTFY;
	}

	public void setTOTFY(String TOTFY) {
		this.TOTFY = TOTFY;
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

	public String getFY11() {
		return FY11;
	}

	public void setFY11(String FY11) {
		this.FY11 = FY11;
	}

	public String getFY12() {
		return FY12;
	}

	public void setFY12(String FY12) {
		this.FY12 = FY12;
	}

	public String getFY13() {
		return FY13;
	}

	public void setFY13(String FY13) {
		this.FY13 = FY13;
	}

	public String getFY14() {
		return FY14;
	}

	public void setFY14(String FY14) {
		this.FY14 = FY14;
	}

	public String getFY15() {
		return FY15;
	}

	public void setFY15(String FY15) {
		this.FY15 = FY15;
	}

	public String getFLGRZF() {
		return FLGRZF;
	}

	public void setFLGRZF(String FLGRZF) {
		this.FLGRZF = FLGRZF;
	}

	public String getFY20() {
		return FY20;
	}

	public void setFY20(String FY20) {
		this.FY20 = FY20;
	}

	public String getFY21() {
		return FY21;
	}

	public void setFY21(String FY21) {
		this.FY21 = FY21;
	}

	public String getFY22() {
		return FY22;
	}

	public void setFY22(String FY22) {
		this.FY22 = FY22;
	}

	public String getFY23() {
		return FY23;
	}

	public void setFY23(String FY23) {
		this.FY23 = FY23;
	}

	public String getFY24() {
		return FY24;
	}

	public void setFY24(String FY24) {
		this.FY24 = FY24;
	}

	public String getFY25() {
		return FY25;
	}

	public void setFY25(String FY25) {
		this.FY25 = FY25;
	}

	public String getFY26() {
		return FY26;
	}

	public void setFY26(String FY26) {
		this.FY26 = FY26;
	}

	public String getFY27() {
		return FY27;
	}

	public void setFY27(String FY27) {
		this.FY27 = FY27;
	}

	public String getFY28() {
		return FY28;
	}

	public void setFY28(String FY28) {
		this.FY28 = FY28;
	}

	public String getFY29() {
		return FY29;
	}

	public void setFY29(String FY29) {
		this.FY29 = FY29;
	}

	public String getFY30() {
		return FY30;
	}

	public void setFY30(String FY30) {
		this.FY30 = FY30;
	}

	public String getFY31() {
		return FY31;
	}

	public void setFY31(String FY31) {
		this.FY31 = FY31;
	}

	public String getFY32() {
		return FY32;
	}

	public void setFY32(String FY32) {
		this.FY32 = FY32;
	}

	public String getFY33() {
		return FY33;
	}

	public void setFY33(String FY33) {
		this.FY33 = FY33;
	}

	public String getFY34() {
		return FY34;
	}

	public void setFY34(String FY34) {
		this.FY34 = FY34;
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