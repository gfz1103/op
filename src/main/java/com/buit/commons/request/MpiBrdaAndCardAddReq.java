
package com.buit.commons.request;

import java.sql.Date;
import java.util.List;

import com.buit.commons.PageQuery;
import com.buit.commons.model.MpiCard;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MpiBrdaAndCardAddReq<br>
 * 类描述：建档新增病人信息和卡列表信息<br>
 * 
 * @author WY
 */
@ApiModel(value = "建档新增病人信息和卡列表信息")
public class MpiBrdaAndCardAddReq extends PageQuery {
	private static final long serialVersionUID = -2852499460965192791L;
	@ApiModelProperty(value = "病人ID号 ")
	private Integer brid;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "证件类型")
	private String zjlx;
	@ApiModelProperty(value = "身份证号")
	private String sfzh;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "出生年月")
	private Date csny;
	@ApiModelProperty(value = "年龄")
	private Integer age;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "门诊号码")
	private String mzhm;
	@ApiModelProperty(value = "医疗证号")
	private String fyzh;
	@ApiModelProperty(value = "病人性质 ")
	private Integer brxz;
	@ApiModelProperty(value = "是否农合")
	private Integer isnh;
	@ApiModelProperty(value = "本人电话")
	private String brdh;
	@ApiModelProperty(value = "联系人名")
	private String lxrm;
	@ApiModelProperty(value = "联系人电话")
	private String lxrdh;
	@ApiModelProperty(value = "户籍标志 DIC_GBSJ01:PD0000000125")
	private String hjbz;
	@ApiModelProperty(value = "民族代码 ")
	private String mzdm;
	@ApiModelProperty(value = "血型代码  DIC_GBSJ01:8")
	private Integer xxdm;
	@ApiModelProperty(value = "婚姻状况 ")
	private Integer hyzk;
	@ApiModelProperty(value = "国籍代码")
	private String gjdm;
	@ApiModelProperty(value = "联系地址省区市")
	private Integer xzzSqs;
	@ApiModelProperty(value = "联系地址市")
	private Integer xzzS;
	@ApiModelProperty(value = "联系地址县")
	private Integer xzzX;
	@ApiModelProperty(value = "详细地址")
	private String xzzQtdz;
	@ApiModelProperty(value = "保险卡号")
	private String bxcabxbxcardno;
	@ApiModelProperty(value = "保险有效期起")
	private Date bxstart;
	@ApiModelProperty(value = "保险有效期止")
	private Date bxend;
	@ApiModelProperty(value = "保险公司")
	private String bxcompany;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "用户ID")
	private Integer ygdm;
	@ApiModelProperty(value = "照片")
	private String photo;
	@ApiModelProperty(value = "EMPI | 对应mpi_demographicinfo表中的empiId字段 个人唯一索引")
	private String empiid;
	@ApiModelProperty(value = "联系关系")
	private Integer lxgx;
	@ApiModelProperty(value = "联系地址")
	private String lxdz;
	@ApiModelProperty(value = "职业代码")
	private String zydm;
	@ApiModelProperty(value = "急诊分诊主键 和病人档案关联")
	private Integer lsh;
	@ApiModelProperty(value = "卡片列表信息")
	private List<MpiCard> mpiCardList;
	@ApiModelProperty(value = "工伤认定号")
	private String gsrdh;
	@ApiModelProperty(value = "单位序号")
	private String dwxh;
	@ApiModelProperty(value = "单位名称")
	private String dwmc;
	@ApiModelProperty(value = "凭证类型")
	private String pzlx;
	@ApiModelProperty(value = "凭证号码")
	private String pzhm;

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getZjlx() {
		return zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

	public Date getCsny() {
		return csny;
	}

	public void setCsny(Date csny) {
		this.csny = csny;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public String getMzhm() {
		return mzhm;
	}

	public void setMzhm(String mzhm) {
		this.mzhm = mzhm;
	}

	public String getFyzh() {
		return fyzh;
	}

	public void setFyzh(String fyzh) {
		this.fyzh = fyzh;
	}

	public Integer getIsnh() {
		return isnh;
	}

	public void setIsnh(Integer isnh) {
		this.isnh = isnh;
	}

	public String getBrdh() {
		return brdh;
	}

	public void setBrdh(String brdh) {
		this.brdh = brdh;
	}

	public String getLxrm() {
		return lxrm;
	}

	public void setLxrm(String lxrm) {
		this.lxrm = lxrm;
	}

	public String getLxrdh() {
		return lxrdh;
	}

	public void setLxrdh(String lxrdh) {
		this.lxrdh = lxrdh;
	}

	public String getHjbz() {
		return hjbz;
	}

	public void setHjbz(String hjbz) {
		this.hjbz = hjbz;
	}

	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	public Integer getXxdm() {
		return xxdm;
	}

	public void setXxdm(Integer xxdm) {
		this.xxdm = xxdm;
	}

	public Integer getHyzk() {
		return hyzk;
	}

	public void setHyzk(Integer hyzk) {
		this.hyzk = hyzk;
	}

	public String getGjdm() {
		return gjdm;
	}

	public void setGjdm(String gjdm) {
		this.gjdm = gjdm;
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

	public String getXzzQtdz() {
		return xzzQtdz;
	}

	public void setXzzQtdz(String xzzQtdz) {
		this.xzzQtdz = xzzQtdz;
	}

	public String getBxcabxbxcardno() {
		return bxcabxbxcardno;
	}

	public void setBxcabxbxcardno(String bxcabxbxcardno) {
		this.bxcabxbxcardno = bxcabxbxcardno;
	}

	public String getBxcompany() {
		return bxcompany;
	}

	public void setBxcompany(String bxcompany) {
		this.bxcompany = bxcompany;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getYgdm() {
		return ygdm;
	}

	public void setYgdm(Integer ygdm) {
		this.ygdm = ygdm;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getBxstart() {
		return bxstart;
	}

	public void setBxstart(Date bxstart) {
		this.bxstart = bxstart;
	}

	public Date getBxend() {
		return bxend;
	}

	public void setBxend(Date bxend) {
		this.bxend = bxend;
	}

	public List<MpiCard> getMpiCardList() {
		return mpiCardList;
	}

	public void setMpiCardList(List<MpiCard> mpiCardList) {
		this.mpiCardList = mpiCardList;
	}

	public String getEmpiid() {
		return empiid;
	}

	public void setEmpiid(String empiid) {
		this.empiid = empiid;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getZydm() {
		return zydm;
	}

	public void setZydm(String zydm) {
		this.zydm = zydm;
	}

	public Integer getLsh() {
		return lsh;
	}

	public void setLsh(Integer lsh) {
		this.lsh = lsh;
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
}
