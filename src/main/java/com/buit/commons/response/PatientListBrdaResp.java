
package com.buit.commons.response;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpGhmx<br>
 * 类描述：门诊_挂号明细表<br>
 * 
 * @author 老花生
 */
@ApiModel(value = "挂号明细表")
public class PatientListBrdaResp extends PageQuery {
	@ApiModelProperty(value = "病人ID号 | 是一个内码，其它数据表与该表相联系的字段")
	/** 病人ID号 | 是一个内码，其它数据表与该表相联系的字段 */
	private Integer brid;
	@ApiModelProperty(value = "门诊号码 | 唯一一处记载病人门诊号码的地方，在程序中用于刷卡登记或查询相关记录使用")
	/** 门诊号码 | 唯一一处记载病人门诊号码的地方，在程序中用于刷卡登记或查询相关记录使用 */
	private String mzhm;
	@ApiModelProperty(value = "病人姓名")
	/** 病人姓名 */
	private String brxm;
	@ApiModelProperty(value = "医疗证号")
	/** 医疗证号 */
	private String fyzh;
	@ApiModelProperty(value = "身份证号")
	/** 身份证号 */
	private String sfzh;
	@ApiModelProperty(value = "病人性质 | 与patientProperties.xml字典关联")
	/** 病人性质 | 与patientProperties.xml字典关联 */
	private Integer brxz;
	@ApiModelProperty(value = "病人性别 | GB/T 2261.1-2003 与gender.xml字典关联")
	/** 病人性别 | GB/T 2261.1-2003 与gender.xml字典关联 */
	private Integer brxb;
	@ApiModelProperty(value = "出生年月")
	/** 出生年月 */
	private Timestamp csny;
	@ApiModelProperty(value = "婚姻状况 | GB/T 2261.2-2003 与maritals.xml字典关联")
	/** 婚姻状况 | GB/T 2261.2-2003 与maritals.xml字典关联 */
	private Integer hyzk;
	@ApiModelProperty(value = "职业代码 | GB/T 6565-2009 与jobtitle.xml字典关联")
	/** 职业代码 | GB/T 6565-2009 与jobtitle.xml字典关联 */
	private String zydm;
	@ApiModelProperty(value = "民族代码 | GB3304-91 与ethnic.xml字典关联")
	/** 民族代码 | GB3304-91 与ethnic.xml字典关联 */
	private String mzdm;
	@ApiModelProperty(value = "血型代码 | GA 324.6-2001 与blood.xml字典关联")
	/** 血型代码 | GA 324.6-2001 与blood.xml字典关联 */
	private Integer xxdm;
	@ApiModelProperty(value = "过敏药物")
	/** 过敏药物 */
	private Integer gmyw;
	@ApiModelProperty(value = "单位序号")
	/** 单位序号 */
	private Integer dwxh;
	@ApiModelProperty(value = "单位名称")
	/** 单位名称 */
	private String dwmc;
	@ApiModelProperty(value = "单位电话")
	/** 单位电话 */
	private String dwdh;
	@ApiModelProperty(value = "单位邮编")
	/** 单位邮编 */
	private String dwyb;
	@ApiModelProperty(value = "户口地址")
	/** 户口地址 */
	private String hkdz;
	@ApiModelProperty(value = "家庭电话")
	/** 家庭电话 */
	private String jtdh;
	@ApiModelProperty(value = "户口邮编")
	/** 户口邮编 */
	private String hkyb;
	@ApiModelProperty(value = "就诊次数")
	/** 就诊次数 */
	private Integer jzcs;
	@ApiModelProperty(value = "就诊日期")
	/** 就诊日期 */
	private Timestamp jzrq;
	@ApiModelProperty(value = "初诊日期")
	/** 初诊日期 */
	private Timestamp czrq;
	@ApiModelProperty(value = "就诊卡号")
	/** 就诊卡号 */
	private String jzkh;
	@ApiModelProperty(value = "省份代码")
	/** 省份代码 */
	private Integer sfdm;
	@ApiModelProperty(value = "籍贯代码")
	/** 籍贯代码 */
	private Integer jgdm;
	@ApiModelProperty(value = "国籍代码")
	/** 国籍代码 */
	private String gjdm;
	@ApiModelProperty(value = "联系人名")
	/** 联系人名 */
	private String lxrm;
	@ApiModelProperty(value = "联系关系")
	/** 联系关系 */
	private Integer lxgx;
	@ApiModelProperty(value = "联系地址")
	/** 联系地址 */
	private String lxdz;
	@ApiModelProperty(value = "联系电话")
	/** 联系电话 */
	private String lxdh;
	@ApiModelProperty(value = "担保人名")
	/** 担保人名 */
	private String dbrm;
	@ApiModelProperty(value = "担保关系")
	/** 担保关系 */
	private Integer dbgx;
	@ApiModelProperty(value = "社保号码")
	/** 社保号码 */
	private String sbhm;
	@ApiModelProperty(value = "医保卡号")
	/** 医保卡号 */
	private String ybkh;
	@ApiModelProperty(value = "在职退休")
	/** 在职退休 */
	private Integer zztx;
	@ApiModelProperty(value = "建档机构")
	/** 建档机构 */
	private String jdjg;
	@ApiModelProperty(value = "建档时间")
	/** 建档时间 */
	private Timestamp jdsj;
	@ApiModelProperty(value = "建档人")
	/** 建档人 */
	private String jdr;
	@ApiModelProperty(value = "注销标志 | 0：正常 1：注销")
	/** 注销标志 | 0：正常 1：注销 */
	private Integer zxbz;
	@ApiModelProperty(value = "注销人")
	/** 注销人 */
	private String zxr;
	@ApiModelProperty(value = "注销时间")
	/** 注销时间 */
	private Timestamp zxsj;
	@ApiModelProperty(value = "修改时间")
	/** 修改时间 */
	private Timestamp xgsj;
	@ApiModelProperty(value = "出生地_省区市")
	/** 出生地_省区市 */
	private Integer csdSqs;
	@ApiModelProperty(value = "出生地_市")
	/** 出生地_市 */
	private Integer csdS;
	@ApiModelProperty(value = "出生地_县")
	/** 出生地_县 */
	private Integer csdX;
	@ApiModelProperty(value = "籍贯代码_省区市")
	/** 籍贯代码_省区市 */
	private Integer jgdmSqs;
	@ApiModelProperty(value = "籍贯代码_市")
	/** 籍贯代码_市 */
	private Integer jgdmS;
	@ApiModelProperty(value = "现住址_省区市")
	/** 现住址_省区市 */
	private Integer xzzSqs;
	@ApiModelProperty(value = "现住址_市")
	/** 现住址_市 */
	private Integer xzzS;
	@ApiModelProperty(value = "现住址_县")
	/** 现住址_县 */
	private Integer xzzX;
	@ApiModelProperty(value = "现住址_邮编")
	/** 现住址_邮编 */
	private String xzzYb;
	@ApiModelProperty(value = "现住址_电话")
	/** 现住址_电话 */
	private String xzzDh;
	@ApiModelProperty(value = "户口地址_省区市")
	/** 户口地址_省区市 */
	private Integer hkdzSqs;
	@ApiModelProperty(value = "户口地址_市")
	/** 户口地址_市 */
	private Integer hkdzS;
	@ApiModelProperty(value = "户口地址_县")
	/** 户口地址_县 */
	private Integer hkdzX;
	@ApiModelProperty(value = "现住址_其他地址")
	/** 现住址_其他地址 */
	private String xzzQtdz;
	@ApiModelProperty(value = "户口地址_其他地址")
	/** 户口地址_其他地址 */
	private String hkdzQtdz;
	@ApiModelProperty(value = "EMPI | 对应mpi_demographicinfo表中的empiId字段 个人唯一索引")
	/** EMPI | 对应mpi_demographicinfo表中的empiId字段 个人唯一索引 */
	private String empiid;
	@ApiModelProperty(value = "数据来源(标识导入数据)")
	/** 数据来源(标识导入数据) */
	private String src;
	@ApiModelProperty(value = "cardtype")
	/** cardtype */
	private Integer cardtype;
	@ApiModelProperty(value = "grbm")
	/** grbm */
	private String grbm;
	@ApiModelProperty(value = "gsbj")
	/** gsbj */
	private Integer gsbj;
	@ApiModelProperty(value = "减免标志")
	/** 减免标志 */
	private String jmbz;
	@ApiModelProperty(value = "减免凭证类型")
	/** 减免凭证类型 */
	private String pzlx;
	@ApiModelProperty(value = "减免凭证号码")
	/** 减免凭证号码 */
	private String pzhm;
	@ApiModelProperty(value = "工伤认定号")
	/** 工伤认定号 */
	private String gsrdh;
	@ApiModelProperty(value = "大病病种")
	/** 大病病种 */
	private String dbbz;
	@ApiModelProperty(value = "上传标志")
	/** 上传标志 */
	private String scbz;
	// @ApiModelProperty(value="照片")
	/** 照片 */
	private String photo;
	// @ApiModelProperty(value="证件类型")
	/** 证件类型 */
	private String zjlx;
	// @ApiModelProperty(value="本人电话")
	/** 本人电话 */
	private Integer brdh;
	// @ApiModelProperty(value="联系人电话")
	/** 联系人电话 */
	private Integer lxrdh;
	// @ApiModelProperty(value="是否农合")
	/** 是否农合 */
	private Integer isnh;
	// @ApiModelProperty(value="户籍标志")
	/** 户籍标志 */
	private String hjbz;
	// @ApiModelProperty(value="国籍 | GB/T 2659-2000")
	/** 国籍 | GB/T 2659-2000 */
	private String nationalitycode;
	// @ApiModelProperty(value="保险卡号")
	/** 保险卡号 */
	private String bxcabxbxcardno;
	// @ApiModelProperty(value="保险有效期起")
	/** 保险有效期起 */
	private Timestamp bxstart;
	// @ApiModelProperty(value="保险有效期止")
	/** 保险有效期止 */
	private Timestamp bxend;
	// @ApiModelProperty(value="保险公司")
	/** 保险公司 */
	private String bxcompany;
	// @ApiModelProperty(value="修改人")
	/** 修改人 */
	private String xgr;

	/** 设置:病人ID号 | 是一个内码，其它数据表与该表相联系的字段 */
	public void setBrid(Integer value) {
		this.brid = value;
	}

	/** 获取:病人ID号 | 是一个内码，其它数据表与该表相联系的字段 */
	public Integer getBrid() {
		return brid;
	}

	/** 设置:门诊号码 | 唯一一处记载病人门诊号码的地方，在程序中用于刷卡登记或查询相关记录使用 */
	public void setMzhm(String value) {
		this.mzhm = value;
	}

	/** 获取:门诊号码 | 唯一一处记载病人门诊号码的地方，在程序中用于刷卡登记或查询相关记录使用 */
	public String getMzhm() {
		return mzhm;
	}

	/** 设置:病人姓名 */
	public void setBrxm(String value) {
		this.brxm = value;
	}

	/** 获取:病人姓名 */
	public String getBrxm() {
		return brxm;
	}

	/** 设置:医疗证号 */
	public void setFyzh(String value) {
		this.fyzh = value;
	}

	/** 获取:医疗证号 */
	public String getFyzh() {
		return fyzh;
	}

	/** 设置:身份证号 */
	public void setSfzh(String value) {
		this.sfzh = value;
	}

	/** 获取:身份证号 */
	public String getSfzh() {
		return sfzh;
	}

	/** 设置:病人性质 | 与patientProperties.xml字典关联 */
	public void setBrxz(Integer value) {
		this.brxz = value;
	}

	/** 获取:病人性质 | 与patientProperties.xml字典关联 */
	public Integer getBrxz() {
		return brxz;
	}

	/** 设置:病人性别 | GB/T 2261.1-2003 与gender.xml字典关联 */
	public void setBrxb(Integer value) {
		this.brxb = value;
	}

	/** 获取:病人性别 | GB/T 2261.1-2003 与gender.xml字典关联 */
	public Integer getBrxb() {
		return brxb;
	}

	/** 设置:出生年月 */
	public void setCsny(Timestamp value) {
		this.csny = value;
	}

	/** 获取:出生年月 */
	public Timestamp getCsny() {
		return csny;
	}

	/** 设置:婚姻状况 | GB/T 2261.2-2003 与maritals.xml字典关联 */
	public void setHyzk(Integer value) {
		this.hyzk = value;
	}

	/** 获取:婚姻状况 | GB/T 2261.2-2003 与maritals.xml字典关联 */
	public Integer getHyzk() {
		return hyzk;
	}

	/** 设置:职业代码 | GB/T 6565-2009 与jobtitle.xml字典关联 */
	public void setZydm(String value) {
		this.zydm = value;
	}

	/** 获取:职业代码 | GB/T 6565-2009 与jobtitle.xml字典关联 */
	public String getZydm() {
		return zydm;
	}

	/** 设置:民族代码 | GB3304-91 与ethnic.xml字典关联 */
	public void setMzdm(String value) {
		this.mzdm = value;
	}

	/** 获取:民族代码 | GB3304-91 与ethnic.xml字典关联 */
	public String getMzdm() {
		return mzdm;
	}

	/** 设置:血型代码 | GA 324.6-2001 与blood.xml字典关联 */
	public void setXxdm(Integer value) {
		this.xxdm = value;
	}

	/** 获取:血型代码 | GA 324.6-2001 与blood.xml字典关联 */
	public Integer getXxdm() {
		return xxdm;
	}

	/** 设置:过敏药物 */
	public void setGmyw(Integer value) {
		this.gmyw = value;
	}

	/** 获取:过敏药物 */
	public Integer getGmyw() {
		return gmyw;
	}

	/** 设置:单位序号 */
	public void setDwxh(Integer value) {
		this.dwxh = value;
	}

	/** 获取:单位序号 */
	public Integer getDwxh() {
		return dwxh;
	}

	/** 设置:单位名称 */
	public void setDwmc(String value) {
		this.dwmc = value;
	}

	/** 获取:单位名称 */
	public String getDwmc() {
		return dwmc;
	}

	/** 设置:单位电话 */
	public void setDwdh(String value) {
		this.dwdh = value;
	}

	/** 获取:单位电话 */
	public String getDwdh() {
		return dwdh;
	}

	/** 设置:单位邮编 */
	public void setDwyb(String value) {
		this.dwyb = value;
	}

	/** 获取:单位邮编 */
	public String getDwyb() {
		return dwyb;
	}

	/** 设置:户口地址 */
	public void setHkdz(String value) {
		this.hkdz = value;
	}

	/** 获取:户口地址 */
	public String getHkdz() {
		return hkdz;
	}

	/** 设置:家庭电话 */
	public void setJtdh(String value) {
		this.jtdh = value;
	}

	/** 获取:家庭电话 */
	public String getJtdh() {
		return jtdh;
	}

	/** 设置:户口邮编 */
	public void setHkyb(String value) {
		this.hkyb = value;
	}

	/** 获取:户口邮编 */
	public String getHkyb() {
		return hkyb;
	}

	/** 设置:就诊次数 */
	public void setJzcs(Integer value) {
		this.jzcs = value;
	}

	/** 获取:就诊次数 */
	public Integer getJzcs() {
		return jzcs;
	}

	/** 设置:就诊日期 */
	public void setJzrq(Timestamp value) {
		this.jzrq = value;
	}

	/** 获取:就诊日期 */
	public Timestamp getJzrq() {
		return jzrq;
	}

	/** 设置:初诊日期 */
	public void setCzrq(Timestamp value) {
		this.czrq = value;
	}

	/** 获取:初诊日期 */
	public Timestamp getCzrq() {
		return czrq;
	}

	/** 设置:就诊卡号 */
	public void setJzkh(String value) {
		this.jzkh = value;
	}

	/** 获取:就诊卡号 */
	public String getJzkh() {
		return jzkh;
	}

	/** 设置:省份代码 */
	public void setSfdm(Integer value) {
		this.sfdm = value;
	}

	/** 获取:省份代码 */
	public Integer getSfdm() {
		return sfdm;
	}

	/** 设置:籍贯代码 */
	public void setJgdm(Integer value) {
		this.jgdm = value;
	}

	/** 获取:籍贯代码 */
	public Integer getJgdm() {
		return jgdm;
	}

	/** 设置:国籍代码 */
	public void setGjdm(String value) {
		this.gjdm = value;
	}

	/** 获取:国籍代码 */
	public String getGjdm() {
		return gjdm;
	}

	/** 设置:联系人名 */
	public void setLxrm(String value) {
		this.lxrm = value;
	}

	/** 获取:联系人名 */
	public String getLxrm() {
		return lxrm;
	}

	/** 设置:联系关系 */
	public void setLxgx(Integer value) {
		this.lxgx = value;
	}

	/** 获取:联系关系 */
	public Integer getLxgx() {
		return lxgx;
	}

	/** 设置:联系地址 */
	public void setLxdz(String value) {
		this.lxdz = value;
	}

	/** 获取:联系地址 */
	public String getLxdz() {
		return lxdz;
	}

	/** 设置:联系电话 */
	public void setLxdh(String value) {
		this.lxdh = value;
	}

	/** 获取:联系电话 */
	public String getLxdh() {
		return lxdh;
	}

	/** 设置:担保人名 */
	public void setDbrm(String value) {
		this.dbrm = value;
	}

	/** 获取:担保人名 */
	public String getDbrm() {
		return dbrm;
	}

	/** 设置:担保关系 */
	public void setDbgx(Integer value) {
		this.dbgx = value;
	}

	/** 获取:担保关系 */
	public Integer getDbgx() {
		return dbgx;
	}

	/** 设置:社保号码 */
	public void setSbhm(String value) {
		this.sbhm = value;
	}

	/** 获取:社保号码 */
	public String getSbhm() {
		return sbhm;
	}

	/** 设置:医保卡号 */
	public void setYbkh(String value) {
		this.ybkh = value;
	}

	/** 获取:医保卡号 */
	public String getYbkh() {
		return ybkh;
	}

	/** 设置:在职退休 */
	public void setZztx(Integer value) {
		this.zztx = value;
	}

	/** 获取:在职退休 */
	public Integer getZztx() {
		return zztx;
	}

	/** 设置:建档机构 */
	public void setJdjg(String value) {
		this.jdjg = value;
	}

	/** 获取:建档机构 */
	public String getJdjg() {
		return jdjg;
	}

	/** 设置:建档时间 */
	public void setJdsj(Timestamp value) {
		this.jdsj = value;
	}

	/** 获取:建档时间 */
	public Timestamp getJdsj() {
		return jdsj;
	}

	/** 设置:建档人 */
	public void setJdr(String value) {
		this.jdr = value;
	}

	/** 获取:建档人 */
	public String getJdr() {
		return jdr;
	}

	/** 设置:注销标志 | 0：正常 1：注销 */
	public void setZxbz(Integer value) {
		this.zxbz = value;
	}

	/** 获取:注销标志 | 0：正常 1：注销 */
	public Integer getZxbz() {
		return zxbz;
	}

	/** 设置:注销人 */
	public void setZxr(String value) {
		this.zxr = value;
	}

	/** 获取:注销人 */
	public String getZxr() {
		return zxr;
	}

	/** 设置:注销时间 */
	public void setZxsj(Timestamp value) {
		this.zxsj = value;
	}

	/** 获取:注销时间 */
	public Timestamp getZxsj() {
		return zxsj;
	}

	/** 设置:修改时间 */
	public void setXgsj(Timestamp value) {
		this.xgsj = value;
	}

	/** 获取:修改时间 */
	public Timestamp getXgsj() {
		return xgsj;
	}

	/** 设置:出生地_省区市 */
	public void setCsdSqs(Integer value) {
		this.csdSqs = value;
	}

	/** 获取:出生地_省区市 */
	public Integer getCsdSqs() {
		return csdSqs;
	}

	/** 设置:出生地_市 */
	public void setCsdS(Integer value) {
		this.csdS = value;
	}

	/** 获取:出生地_市 */
	public Integer getCsdS() {
		return csdS;
	}

	/** 设置:出生地_县 */
	public void setCsdX(Integer value) {
		this.csdX = value;
	}

	/** 获取:出生地_县 */
	public Integer getCsdX() {
		return csdX;
	}

	/** 设置:籍贯代码_省区市 */
	public void setJgdmSqs(Integer value) {
		this.jgdmSqs = value;
	}

	/** 获取:籍贯代码_省区市 */
	public Integer getJgdmSqs() {
		return jgdmSqs;
	}

	/** 设置:籍贯代码_市 */
	public void setJgdmS(Integer value) {
		this.jgdmS = value;
	}

	/** 获取:籍贯代码_市 */
	public Integer getJgdmS() {
		return jgdmS;
	}

	/** 设置:现住址_省区市 */
	public void setXzzSqs(Integer value) {
		this.xzzSqs = value;
	}

	/** 获取:现住址_省区市 */
	public Integer getXzzSqs() {
		return xzzSqs;
	}

	/** 设置:现住址_市 */
	public void setXzzS(Integer value) {
		this.xzzS = value;
	}

	/** 获取:现住址_市 */
	public Integer getXzzS() {
		return xzzS;
	}

	/** 设置:现住址_县 */
	public void setXzzX(Integer value) {
		this.xzzX = value;
	}

	/** 获取:现住址_县 */
	public Integer getXzzX() {
		return xzzX;
	}

	/** 设置:现住址_邮编 */
	public void setXzzYb(String value) {
		this.xzzYb = value;
	}

	/** 获取:现住址_邮编 */
	public String getXzzYb() {
		return xzzYb;
	}

	/** 设置:现住址_电话 */
	public void setXzzDh(String value) {
		this.xzzDh = value;
	}

	/** 获取:现住址_电话 */
	public String getXzzDh() {
		return xzzDh;
	}

	/** 设置:户口地址_省区市 */
	public void setHkdzSqs(Integer value) {
		this.hkdzSqs = value;
	}

	/** 获取:户口地址_省区市 */
	public Integer getHkdzSqs() {
		return hkdzSqs;
	}

	/** 设置:户口地址_市 */
	public void setHkdzS(Integer value) {
		this.hkdzS = value;
	}

	/** 获取:户口地址_市 */
	public Integer getHkdzS() {
		return hkdzS;
	}

	/** 设置:户口地址_县 */
	public void setHkdzX(Integer value) {
		this.hkdzX = value;
	}

	/** 获取:户口地址_县 */
	public Integer getHkdzX() {
		return hkdzX;
	}

	/** 设置:现住址_其他地址 */
	public void setXzzQtdz(String value) {
		this.xzzQtdz = value;
	}

	/** 获取:现住址_其他地址 */
	public String getXzzQtdz() {
		return xzzQtdz;
	}

	/** 设置:户口地址_其他地址 */
	public void setHkdzQtdz(String value) {
		this.hkdzQtdz = value;
	}

	/** 获取:户口地址_其他地址 */
	public String getHkdzQtdz() {
		return hkdzQtdz;
	}

	/** 设置:EMPI | 对应mpi_demographicinfo表中的empiId字段 个人唯一索引 */
	public void setEmpiid(String value) {
		this.empiid = value;
	}

	/** 获取:EMPI | 对应mpi_demographicinfo表中的empiId字段 个人唯一索引 */
	public String getEmpiid() {
		return empiid;
	}

	/** 设置:数据来源(标识导入数据) */
	public void setSrc(String value) {
		this.src = value;
	}

	/** 获取:数据来源(标识导入数据) */
	public String getSrc() {
		return src;
	}

	/** 设置:cardtype */
	public void setCardtype(Integer value) {
		this.cardtype = value;
	}

	/** 获取:cardtype */
	public Integer getCardtype() {
		return cardtype;
	}

	/** 设置:grbm */
	public void setGrbm(String value) {
		this.grbm = value;
	}

	/** 获取:grbm */
	public String getGrbm() {
		return grbm;
	}

	/** 设置:gsbj */
	public void setGsbj(Integer value) {
		this.gsbj = value;
	}

	/** 获取:gsbj */
	public Integer getGsbj() {
		return gsbj;
	}

	/** 设置:减免标志 */
	public void setJmbz(String value) {
		this.jmbz = value;
	}

	/** 获取:减免标志 */
	public String getJmbz() {
		return jmbz;
	}

	/** 设置:减免凭证类型 */
	public void setPzlx(String value) {
		this.pzlx = value;
	}

	/** 获取:减免凭证类型 */
	public String getPzlx() {
		return pzlx;
	}

	/** 设置:减免凭证号码 */
	public void setPzhm(String value) {
		this.pzhm = value;
	}

	/** 获取:减免凭证号码 */
	public String getPzhm() {
		return pzhm;
	}

	/** 设置:工伤认定号 */
	public void setGsrdh(String value) {
		this.gsrdh = value;
	}

	/** 获取:工伤认定号 */
	public String getGsrdh() {
		return gsrdh;
	}

	/** 设置:大病病种 */
	public void setDbbz(String value) {
		this.dbbz = value;
	}

	/** 获取:大病病种 */
	public String getDbbz() {
		return dbbz;
	}

	/** 设置:上传标志 */
	public void setScbz(String value) {
		this.scbz = value;
	}

	/** 获取:上传标志 */
	public String getScbz() {
		return scbz;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getZjlx() {
		return zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	public Integer getBrdh() {
		return brdh;
	}

	public void setBrdh(Integer brdh) {
		this.brdh = brdh;
	}

	public Integer getLxrdh() {
		return lxrdh;
	}

	public void setLxrdh(Integer lxrdh) {
		this.lxrdh = lxrdh;
	}

	public Integer getIsnh() {
		return isnh;
	}

	public void setIsnh(Integer isnh) {
		this.isnh = isnh;
	}

	public String getHjbz() {
		return hjbz;
	}

	public void setHjbz(String hjbz) {
		this.hjbz = hjbz;
	}

	public String getNationalitycode() {
		return nationalitycode;
	}

	public void setNationalitycode(String nationalitycode) {
		this.nationalitycode = nationalitycode;
	}

	public String getBxcabxbxcardno() {
		return bxcabxbxcardno;
	}

	public void setBxcabxbxcardno(String bxcabxbxcardno) {
		this.bxcabxbxcardno = bxcabxbxcardno;
	}

	public Timestamp getBxstart() {
		return bxstart;
	}

	public void setBxstart(Timestamp bxstart) {
		this.bxstart = bxstart;
	}

	public Timestamp getBxend() {
		return bxend;
	}

	public void setBxend(Timestamp bxend) {
		this.bxend = bxend;
	}

	public String getBxcompany() {
		return bxcompany;
	}

	public void setBxcompany(String bxcompany) {
		this.bxcompany = bxcompany;
	}

	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

}
