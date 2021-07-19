package com.buit.commons.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.buit.commons.PageQuery;

import com.buit.his.shyb.source.entity.SJ31Res;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MpiBrda<br>
 * 类描述：门诊_病人档案
 * 
 * @author WY
 * 
 */
@ApiModel(value = "病人档案和病人性质")
public class MpiBrdaInfo extends PageQuery {
	@ApiModelProperty(value = "EMPI")
	private String empiid;
	@ApiModelProperty(value = "病人ID号")
	private Integer brid;
	@ApiModelProperty(value = "门诊号码 | 唯一一处记载病人门诊号码的地方，在程序中用于刷卡登记或查询相关记录使用")
	private String mzhm;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "身份证号")
	private String sfzh;
	@ApiModelProperty(value = "病人性质 SYS_DICT_CONFIG:14 ")
	private Integer brxz;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "性质控制大类")
	private String xzdl;
	@ApiModelProperty(value = "出生年月")
	private Timestamp csny;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "年龄")
	private Integer age;
	@ApiModelProperty(value = "年龄描述")
	private String ages;
	@ApiModelProperty(value = "挂号科室")
	private Integer ghks;
	@ApiModelProperty(value = "科室名称")
	private String ksmc;
	@ApiModelProperty(value = "附加处方")
	private Integer fjgl;
	@ApiModelProperty(value = "挂号关联 | 该收费单与哪次挂号相联系,GHGL字段与OP_GHMX中SBXH关联")
	private Integer ghgl;
	@ApiModelProperty(value = "临时挂号关联")
	private Integer tempGhgl;
	@ApiModelProperty(value = "就诊序号")
	private Integer jzxh;
	@ApiModelProperty(value = "今天已挂号")
	private Integer jtygh;
	@ApiModelProperty(value = "门诊类别")
	private Integer mzlb;
	@ApiModelProperty(value = "状态 | 0=正常1=挂失2=注销3=失效")
	private String status;
	@ApiModelProperty(value = "gsrdh")
	private String gsrdh;
	@ApiModelProperty(value = "病人挂号科室、医生和唯一标识")
	private List<MsGhInfo> msGhInfo = new ArrayList<MsGhInfo>();
	@ApiModelProperty(value = "大病明细")
	private List<com.buit.his.shyb.source.entity.SJ31Res> SJ31Res = new ArrayList<SJ31Res>();
	@ApiModelProperty(value = "是否大病")
	private Integer isDb;
	@ApiModelProperty(value = "单位序号")
	private String dwxh;
	@ApiModelProperty(value = "单位名称")
	private String dwmc;
	@ApiModelProperty(value = "凭证类型")
	private String pzlx;
	@ApiModelProperty(value = "凭证号码")
	private String pzhm;
	@ApiModelProperty(value = "联系地址")
	private String lxdz;
	@ApiModelProperty(value = "电话号码")
	private String lxdh;
	@ApiModelProperty(value = "联系人电话")
	private String lxrdh;
	@ApiModelProperty(value = "0-初诊， 1-复诊")
	private Integer czfz;

	public String getEmpiid() {
		return empiid;
	}

	public void setEmpiid(String empiid) {
		this.empiid = empiid;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
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

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
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

	public String getXzdl() {
		return xzdl;
	}

	public void setXzdl(String xzdl) {
		this.xzdl = xzdl;
	}

	public Timestamp getCsny() {
		return csny;
	}

	public void setCsny(Timestamp csny) {
		this.csny = csny;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer i) {
		this.age = i;
	}

	public Integer getGhks() {
		return ghks;
	}

	public void setGhks(Integer ghks) {
		this.ghks = ghks;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public Integer getFjgl() {
		return fjgl;
	}

	public void setFjgl(Integer fjgl) {
		this.fjgl = fjgl;
	}

	public Integer getGhgl() {
		return ghgl;
	}

	public void setGhgl(Integer ghgl) {
		this.ghgl = ghgl;
	}

	public Integer getTempGhgl() {
		return tempGhgl;
	}

	public void setTempGhgl(Integer tempGhgl) {
		this.tempGhgl = tempGhgl;
	}

	public Integer getJzxh() {
		return jzxh;
	}

	public void setJzxh(Integer jzxh) {
		this.jzxh = jzxh;
	}

	public Integer getJtygh() {
		return jtygh;
	}

	public void setJtygh(Integer jtygh) {
		this.jtygh = jtygh;
	}

	public Integer getMzlb() {
		return mzlb;
	}

	public void setMzlb(Integer mzlb) {
		this.mzlb = mzlb;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<MsGhInfo> getMsGhInfo() {
		return msGhInfo;
	}

	public void setMsGhInfo(List<MsGhInfo> msGhInfo) {
		this.msGhInfo = msGhInfo;
	}

	public String getAges() {
		return ages;
	}

	public void setAges(String ages) {
		this.ages = ages;
	}

	public List<com.buit.his.shyb.source.entity.SJ31Res> getSJ31Res() {
		return SJ31Res;
	}

	public void setSJ31Res(List<com.buit.his.shyb.source.entity.SJ31Res> SJ31Res) {
		this.SJ31Res = SJ31Res;
	}

	public Integer getIsDb() {
		return isDb;
	}

	public void setIsDb(Integer isDb) {
		this.isDb = isDb;
	}

	public String getGsrdh() {
		return gsrdh;
	}

	public void setGsrdh(String gsrdh) {
		this.gsrdh = gsrdh;
	}

	public String getDwxh() {
		return dwxh;
	}

	public void setDwxh(String dwxh) {
		this.dwxh = dwxh;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getPzlx() {
		return pzlx;
	}

	public void setPzlx(String pzlx) {
		this.pzlx = pzlx;
	}

	public String getPzhm() {
		return pzhm;
	}

	public void setPzhm(String pzhm) {
		this.pzhm = pzhm;
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

	public Integer getCzfz() {
		return czfz;
	}

	public void setCzfz(Integer czfz) {
		this.czfz = czfz;
	}

	public String getLxrdh() {
		return lxrdh;
	}

	public void setLxrdh(String lxrdh) {
		this.lxrdh = lxrdh;
	}
}
