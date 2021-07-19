
package com.buit.commons.response;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryBrdaListResp<br>
 * 类描述：患者档案登记请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "患者档案登记请求")
public class QueryBrdaListResp extends PageQuery {
	@ApiModelProperty(value = "病人ID")
	private Integer brid;
	@ApiModelProperty(value = "就诊卡号")
	private String cardno;
	@ApiModelProperty(value = "门诊号码")
	private String mzhm;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "医疗证号")
	private String fyzh;
	@ApiModelProperty(value = "病人性质")
	private Integer brxz;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "出生年月")
	private Timestamp csny;
	@ApiModelProperty(value = "身份证号")
	private String sfzh;
	@ApiModelProperty(value = "婚姻状况")
	private Integer hyzk;
	@ApiModelProperty(value = "职业代码 ")
	private String zydm;
	@ApiModelProperty(value = "麻醉代码")
	private Integer mzdm;
	@ApiModelProperty(value = "血型代码")
	private Integer xxdm;
	@ApiModelProperty(value = "过敏药物")
	private Integer gmyw;
	@ApiModelProperty(value = "单位序号")
	private Integer dwxh;
	@ApiModelProperty(value = "单位名称")
	private String dwmc;
	@ApiModelProperty(value = "单位电话")
	private String dwdh;
	@ApiModelProperty(value = "单位邮编")
	private String dwyb;
	@ApiModelProperty(value = "户口地址")
	private String hkdz;
	@ApiModelProperty(value = "家庭电话")
	private String jtdh;
	@ApiModelProperty(value = "户口邮编")
	private String hkyb;
	@ApiModelProperty(value = "就诊次数")
	private Integer jzcs;
	@ApiModelProperty(value = "结账日期")
	private Timestamp jzrq;
	@ApiModelProperty(value = "操作日期")
	private Timestamp czrq;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "省份代码")
	private Integer sfdm;
	@ApiModelProperty(value = "籍贯代码")
	private Integer jgdm;
	@ApiModelProperty(value = "国籍代码")
	private String gjdm;
	@ApiModelProperty(value = "联系人名")
	private String lxrm;
	@ApiModelProperty(value = "联系关系")
	private Integer lxgx;
	@ApiModelProperty(value = "联系地址")
	private String lxdz;
	@ApiModelProperty(value = "联系电话")
	private String lxdh;
	@ApiModelProperty(value = "担保人名")
	private String dbrm;
	@ApiModelProperty(value = "担保关系")
	private Integer dbgx;
	@ApiModelProperty(value = "社保号码")
	private String sbhm;
	@ApiModelProperty(value = "医保卡号")
	private String ybkh;
	@ApiModelProperty(value = "在职退休")
	private Integer zztx;
	@ApiModelProperty(value = "建档机构")
	private String jdjg;
	@ApiModelProperty(value = "建档时间")
	private Timestamp jdsj;
	@ApiModelProperty(value = "建档人")
	private String jdr;
	@ApiModelProperty(value = "注销标志:0使用 1注销 ")
	private Integer zxbz;
	@ApiModelProperty(value = "注销人")
	private String zxr;
	@ApiModelProperty(value = "注销时间")
	private Timestamp zxsj;
	@ApiModelProperty(value = "修改时间")
	private Timestamp xgsj;
	@ApiModelProperty(value = "出生地_省区市")
	private Integer csdSqs;
	@ApiModelProperty(value = "出生地_市")
	private Integer csdS;
	@ApiModelProperty(value = "出生地_县")
	private Integer csdX;
	@ApiModelProperty(value = "籍贯代码_省区市")
	private Integer jgdmSqs;
	@ApiModelProperty(value = "籍贯代码_市")
	private Integer jgdmS;
	@ApiModelProperty(value = "现住址_省区市")
	private Integer xzzSqs;
	@ApiModelProperty(value = "现住址_市")
	private Integer xzzS;
	@ApiModelProperty(value = "现住址_县")
	private Integer xzzX;
	@ApiModelProperty(value = "现住址_邮编")
	private String xzzYb;
	@ApiModelProperty(value = "现住址_电话")
	private String xzzDh;
	@ApiModelProperty(value = "户口地址_省区市")
	private Integer hkdzSqs;
	@ApiModelProperty(value = "户口地址_市")
	private Integer hkdzS;
	@ApiModelProperty(value = "户口地址_县")
	private Integer hkdzX;
	@ApiModelProperty(value = "现住址_其他地址")
	private String xzzQtdz;
	@ApiModelProperty(value = "户口地址_其他地址")
	private String hkdzQtdz;

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
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

	public String getFyzh() {
		return fyzh;
	}

	public void setFyzh(String fyzh) {
		this.fyzh = fyzh;
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

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public Integer getHyzk() {
		return hyzk;
	}

	public void setHyzk(Integer hyzk) {
		this.hyzk = hyzk;
	}

	public String getZydm() {
		return zydm;
	}

	public void setZydm(String zydm) {
		this.zydm = zydm;
	}

	public Integer getMzdm() {
		return mzdm;
	}

	public void setMzdm(Integer mzdm) {
		this.mzdm = mzdm;
	}

	public Integer getXxdm() {
		return xxdm;
	}

	public void setXxdm(Integer xxdm) {
		this.xxdm = xxdm;
	}

	public Integer getGmyw() {
		return gmyw;
	}

	public void setGmyw(Integer gmyw) {
		this.gmyw = gmyw;
	}

	public Integer getDwxh() {
		return dwxh;
	}

	public void setDwxh(Integer dwxh) {
		this.dwxh = dwxh;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getDwdh() {
		return dwdh;
	}

	public void setDwdh(String dwdh) {
		this.dwdh = dwdh;
	}

	public String getDwyb() {
		return dwyb;
	}

	public void setDwyb(String dwyb) {
		this.dwyb = dwyb;
	}

	public String getHkdz() {
		return hkdz;
	}

	public void setHkdz(String hkdz) {
		this.hkdz = hkdz;
	}

	public String getJtdh() {
		return jtdh;
	}

	public void setJtdh(String jtdh) {
		this.jtdh = jtdh;
	}

	public String getHkyb() {
		return hkyb;
	}

	public void setHkyb(String hkyb) {
		this.hkyb = hkyb;
	}

	public Integer getJzcs() {
		return jzcs;
	}

	public void setJzcs(Integer jzcs) {
		this.jzcs = jzcs;
	}

	public Timestamp getJzrq() {
		return jzrq;
	}

	public void setJzrq(Timestamp jzrq) {
		this.jzrq = jzrq;
	}

	public Timestamp getCzrq() {
		return czrq;
	}

	public void setCzrq(Timestamp czrq) {
		this.czrq = czrq;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public Integer getSfdm() {
		return sfdm;
	}

	public void setSfdm(Integer sfdm) {
		this.sfdm = sfdm;
	}

	public Integer getJgdm() {
		return jgdm;
	}

	public void setJgdm(Integer jgdm) {
		this.jgdm = jgdm;
	}

	public String getGjdm() {
		return gjdm;
	}

	public void setGjdm(String gjdm) {
		this.gjdm = gjdm;
	}

	public String getLxrm() {
		return lxrm;
	}

	public void setLxrm(String lxrm) {
		this.lxrm = lxrm;
	}

	public Integer getLxgx() {
		return lxgx;
	}

	public void setLxgx(Integer lxgx) {
		this.lxgx = lxgx;
	}

	public String getLxdz() {
		return lxdz;
	}

	public void setLxdz(String lxdz) {
		this.lxdz = lxdz;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getDbrm() {
		return dbrm;
	}

	public void setDbrm(String dbrm) {
		this.dbrm = dbrm;
	}

	public Integer getDbgx() {
		return dbgx;
	}

	public void setDbgx(Integer dbgx) {
		this.dbgx = dbgx;
	}

	public String getSbhm() {
		return sbhm;
	}

	public void setSbhm(String sbhm) {
		this.sbhm = sbhm;
	}

	public String getYbkh() {
		return ybkh;
	}

	public void setYbkh(String ybkh) {
		this.ybkh = ybkh;
	}

	public Integer getZztx() {
		return zztx;
	}

	public void setZztx(Integer zztx) {
		this.zztx = zztx;
	}

	public String getJdjg() {
		return jdjg;
	}

	public void setJdjg(String jdjg) {
		this.jdjg = jdjg;
	}

	public Timestamp getJdsj() {
		return jdsj;
	}

	public void setJdsj(Timestamp jdsj) {
		this.jdsj = jdsj;
	}

	public String getJdr() {
		return jdr;
	}

	public void setJdr(String jdr) {
		this.jdr = jdr;
	}

	public Integer getZxbz() {
		return zxbz;
	}

	public void setZxbz(Integer zxbz) {
		this.zxbz = zxbz;
	}

	public String getZxr() {
		return zxr;
	}

	public void setZxr(String zxr) {
		this.zxr = zxr;
	}

	public Timestamp getZxsj() {
		return zxsj;
	}

	public void setZxsj(Timestamp zxsj) {
		this.zxsj = zxsj;
	}

	public Timestamp getXgsj() {
		return xgsj;
	}

	public void setXgsj(Timestamp xgsj) {
		this.xgsj = xgsj;
	}

	public Integer getCsdSqs() {
		return csdSqs;
	}

	public void setCsdSqs(Integer csdSqs) {
		this.csdSqs = csdSqs;
	}

	public Integer getCsdS() {
		return csdS;
	}

	public void setCsdS(Integer csdS) {
		this.csdS = csdS;
	}

	public Integer getCsdX() {
		return csdX;
	}

	public void setCsdX(Integer csdX) {
		this.csdX = csdX;
	}

	public Integer getJgdmSqs() {
		return jgdmSqs;
	}

	public void setJgdmSqs(Integer jgdmSqs) {
		this.jgdmSqs = jgdmSqs;
	}

	public Integer getJgdmS() {
		return jgdmS;
	}

	public void setJgdmS(Integer jgdmS) {
		this.jgdmS = jgdmS;
	}

	public Integer getXzzSqs() {
		return xzzSqs;
	}

	public void setXzzSqs(Integer xzzSqs) {
		this.xzzSqs = xzzSqs;
	}

	public Integer getXzzS() {
		return xzzS;
	}

	public void setXzzS(Integer xzzS) {
		this.xzzS = xzzS;
	}

	public Integer getXzzX() {
		return xzzX;
	}

	public void setXzzX(Integer xzzX) {
		this.xzzX = xzzX;
	}

	public String getXzzYb() {
		return xzzYb;
	}

	public void setXzzYb(String xzzYb) {
		this.xzzYb = xzzYb;
	}

	public String getXzzDh() {
		return xzzDh;
	}

	public void setXzzDh(String xzzDh) {
		this.xzzDh = xzzDh;
	}

	public Integer getHkdzSqs() {
		return hkdzSqs;
	}

	public void setHkdzSqs(Integer hkdzSqs) {
		this.hkdzSqs = hkdzSqs;
	}

	public Integer getHkdzS() {
		return hkdzS;
	}

	public void setHkdzS(Integer hkdzS) {
		this.hkdzS = hkdzS;
	}

	public Integer getHkdzX() {
		return hkdzX;
	}

	public void setHkdzX(Integer hkdzX) {
		this.hkdzX = hkdzX;
	}

	public String getXzzQtdz() {
		return xzzQtdz;
	}

	public void setXzzQtdz(String xzzQtdz) {
		this.xzzQtdz = xzzQtdz;
	}

	public String getHkdzQtdz() {
		return hkdzQtdz;
	}

	public void setHkdzQtdz(String hkdzQtdz) {
		this.hkdzQtdz = hkdzQtdz;
	}

}