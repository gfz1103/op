package com.buit.commons.model;

import java.sql.Date;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：HrPersonnel<br> 
 * 类描述：员工信息
 * @author 神算子 
 * @ApiModel(value="员工信息")
 */
public class HrPersonnel extends PageQuery {
	@ApiModelProperty(value="员工ID")
    /** 员工ID */
    private Integer personid;
	@ApiModelProperty(value="姓名-最长:100")
    /** 姓名 */
    private String personname;
	@ApiModelProperty(value="照片")
    /** 照片 */
    private String photo;
	@ApiModelProperty(value="身份证件类型 字典:DIC_GBSJ01:PD0000000260")
    /** 身份证件类型 */
    private String cardtype;
	@ApiModelProperty(value="身份证件号码 最长:50")
    /** 身份证件号码SFZH */
    private String cardnum;
	@ApiModelProperty(value="出生日期")
    /** 出生日期 */
    private Date birthday;
	@ApiModelProperty(value="性别 字典:DIC_GBSJ01:PD0000000269")
    /** 性别 */
    private String gender;
	@ApiModelProperty(value="民族 字典:DIC_GBSJ01:PD0000000215")
    /** 民族 */
    private String ethnic;
	@ApiModelProperty(value="籍贯 最长:150")
    private String hometown;
	@ApiModelProperty(value="邮件 最长:50")
    private String email;
	@ApiModelProperty(value="手机号码 最长:25")
    private String mobile;
	@ApiModelProperty(value="最高学历 字典:DIC_GBSJ01:PD0000000346")
    private String education;
	@ApiModelProperty(value="学位 字典:DIC_GBSJ01:PD0000000447")
    private String educationbackground;
	@ApiModelProperty(value="参加工作时间")
    private Date joininwork;
	@ApiModelProperty(value="行政职务 字典:DIC_GBSJ01:PD0000000001")
    private String jobpost;
	@ApiModelProperty(value="医师执业类别 字典:DIC_GBSJ01:PD0000000004")
    private String operationtype;
	@ApiModelProperty(value="专业类别 字典:DIC_GBSJ01:PD0000000005")
    private String majortype;
	@ApiModelProperty(value="专业技术职务 字典:DIC_GBSJ01:PD0000000472")
    private String majorjob;
	@ApiModelProperty(value="所在科室 字典:sys_dict_config:4-科室字典")
    private Integer officecode;
	@ApiModelProperty(value="所在机构JGID",hidden = true)
    private Integer organizcode;
	@ApiModelProperty(value="联系地址 最长:150")
    private String address;
	@ApiModelProperty(value="拼音代码PYDM")
    private String pycode;
	@ApiModelProperty(value="医生简介 最长:500")
    private String remark;
	@ApiModelProperty(value="执业证书编码 最长:20")
    private String certificatenum;
	@ApiModelProperty(value="专业技术资格 字典:DIC_GBSJ01:PD0000000471")
    private String majorqualify;
	@ApiModelProperty(value="医师执业范围 字典:DIC_GBSJ01:PD0000000372")
    private String operationscope;
	@ApiModelProperty(value="所学专业 字典:DIC_GBSJ01:PD0000000106")
    private String majorname;
	@ApiModelProperty(value="专家费用ZJFY")
    private Integer expertcost;
	@ApiModelProperty(value="开处方权 字典:SYS_FLAG_DATA:FD000005",required = true)  
    private String prescriberight;
	@ApiModelProperty(value="麻醉药权 字典:SYS_FLAG_DATA:FD000005",required = true)
    private String narcoticright;
	@ApiModelProperty(value="精神药权JSYQ 字典:SYS_FLAG_DATA:FD000005",required = true)
    private String psychotropicright;
	@ApiModelProperty(value="最后修改日期",hidden = true)
    private Timestamp lastmodifydate;
	@ApiModelProperty(value="停用标识 字典:SYS_FLAG_DATA:FD000011  0:启用(默认0) 1:停用")
    private String logoff;
	@ApiModelProperty(value="五笔码WBDM")
    private String wbcode;
	@ApiModelProperty(value="角形码JXDM")
    private String jxcode;
	@ApiModelProperty(value="其他码QTDM",hidden = true)
    private String qtcode;
	@ApiModelProperty(value="医疗角色  字典:SYS_DICT_CONFIG:8")
    private Integer medicalroles;
	@ApiModelProperty(value="抗生素等级:逗号分隔1,2,3 字典:SYS_FLAG_DATA:FD000013")
    private String antibioticlevel;
	@ApiModelProperty(value="职业编号 最长:30")
    private String zybh;
	@ApiModelProperty(value="家庭医生角色",hidden = true)
    private String gprole;
	@ApiModelProperty(value="人员编号 最长:20")
    private String rybh;
	@ApiModelProperty(value="机构编码",hidden = true)
    private String ygdm;
	@ApiModelProperty(value="GP医生编号",hidden = true)
    private String gpid;
	@ApiModelProperty(value="职业医生姓名 最长:50")
    private String zyysxm;
	@ApiModelProperty(value="对应40库绩效卡号",hidden = true)
    private String cardid;
	@ApiModelProperty(value="注销人员ID" )
    private Integer logoffoperater;
	@ApiModelProperty(value="注销人员姓名" )
    private String logoffoperaterName;
	@ApiModelProperty(value="注销时间" )
    private Timestamp logofftime;
	@ApiModelProperty(value="恢复操作人",hidden = true)
    private Integer recoveroperater;
	@ApiModelProperty(value="恢复时间",hidden = true)
    private Timestamp recovertime;
	@ApiModelProperty(value="特需费用")
    private Integer specialcost;
	@ApiModelProperty(value="阳光医药密码",hidden = true)
    private String ygPassword;
	@ApiModelProperty(value="现住址-市")
    private Integer cityId;
	@ApiModelProperty(value="国籍 字典:DIC_GBSJ01:PD0000000271")
    private String countryId;
	@ApiModelProperty(value="现住址-县")
    private Integer countyId;
	@ApiModelProperty(value="数据版本",hidden = true)
    private Integer dataVersion;
	@ApiModelProperty(value="数据创建时间",hidden = true)
    private Timestamp gmtCreate;
	@ApiModelProperty(value="婚姻状况 字典:DIC_GBSJ01:PD0000000137")
    private String marriageTypeId;
	@ApiModelProperty(value="办公室电话 最长:100")
    private String officeTelephone;
	@ApiModelProperty(value="职工分类标志 字典:sys_flag_data:FD000056")
    private String personClassId;
	@ApiModelProperty(value="现住址-省")
    private Integer provinceId;
	@ApiModelProperty(value="专家判别 字典:SYS_FLAG_DATA:FD000005")
    private String isexpert;
	@ApiModelProperty(value="抗生素权 字典:SYS_FLAG_DATA:FD000005")
    private String antibioticright;
	@ApiModelProperty(value="特需判别 字典:SYS_FLAG_DATA:FD000005")
    private String isspecial;
	@ApiModelProperty(value="家床管理员 字典:SYS_FLAG_DATA:FD000005")
    private String jcgly;
	@ApiModelProperty(value="排序使用",hidden = true)
	private String  sortColumns;
	@ApiModelProperty(value="岗位角色ID",hidden = true)
    private Integer groupId;
	@ApiModelProperty(value="分配置过登录账号的查询标识")
    private Integer haveGroup;
	@ApiModelProperty(value="最后登录IP")
	private String lastLoginIp;
	
    public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Integer getHaveGroup() {
		return haveGroup;
	}
	public void setHaveGroup(Integer haveGroup) {
		this.haveGroup = haveGroup;
	}
	public String getLogoffoperaterName() {
		return logoffoperaterName;
	}
	public void setLogoffoperaterName(String logoffoperaterName) {
		this.logoffoperaterName = logoffoperaterName;
	}
	public String getSortColumns() {
		return sortColumns;
	}
	public void setSortColumns(String sortColumns) {
		this.sortColumns = sortColumns;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	/** 设置:员工ID  */
    public void setPersonid(Integer value) {
        this.personid = value;
    }
    /** 获取:员工ID */
    public Integer getPersonid() {
        return personid;
    }

    /** 设置:姓名  */
    public void setPersonname(String value) {
        this.personname = value;
    }
    /** 获取:姓名 */
    public String getPersonname() {
        return personname;
    }

    /** 设置:照片  */
    public void setPhoto(String value) {
        this.photo = value;
    }
    /** 获取:照片 */
    public String getPhoto() {
        return photo;
    }

    /** 设置:身份证件类型  */
    public void setCardtype(String value) {
        this.cardtype = value;
    }
    /** 获取:身份证件类型 */
    public String getCardtype() {
        return cardtype;
    }

    /** 设置:身份证件号码SFZH  */
    public void setCardnum(String value) {
        this.cardnum = value;
    }
    /** 获取:身份证件号码SFZH */
    public String getCardnum() {
        return cardnum;
    }

    /** 设置:出生日期  */
    public void setBirthday(Date value) {
        this.birthday = value;
    }
    /** 获取:出生日期 */
    public Date getBirthday() {
        return birthday;
    }

    /** 设置:性别  */
    public void setGender(String value) {
        this.gender = value;
    }
    /** 获取:性别 */
    public String getGender() {
        return gender;
    }

    /** 设置:民族  */
    public void setEthnic(String value) {
        this.ethnic = value;
    }
    /** 获取:民族 */
    public String getEthnic() {
        return ethnic;
    }

    /** 设置:籍贯  */
    public void setHometown(String value) {
        this.hometown = value;
    }
    /** 获取:籍贯 */
    public String getHometown() {
        return hometown;
    }

    /** 设置:邮件  */
    public void setEmail(String value) {
        this.email = value;
    }
    /** 获取:邮件 */
    public String getEmail() {
        return email;
    }

    /** 设置:手机号码SJHM  */
    public void setMobile(String value) {
        this.mobile = value;
    }
    /** 获取:手机号码SJHM */
    public String getMobile() {
        return mobile;
    }

    /** 设置:最高学历  */
    public void setEducation(String value) {
        this.education = value;
    }
    /** 获取:最高学历 */
    public String getEducation() {
        return education;
    }

    /** 设置:学位  */
    public void setEducationbackground(String value) {
        this.educationbackground = value;
    }
    /** 获取:学位 */
    public String getEducationbackground() {
        return educationbackground;
    }

    /** 设置:参加工作时间  */
    public void setJoininwork(Date value) {
        this.joininwork = value;
    }
    /** 获取:参加工作时间 */
    public Date getJoininwork() {
        return joininwork;
    }

    /** 设置:行政职务  */
    public void setJobpost(String value) {
        this.jobpost = value;
    }
    /** 获取:行政职务 */
    public String getJobpost() {
        return jobpost;
    }

    /** 设置:医师执业类别  */
    public void setOperationtype(String value) {
        this.operationtype = value;
    }
    /** 获取:医师执业类别 */
    public String getOperationtype() {
        return operationtype;
    }

    /** 设置:专业类别  */
    public void setMajortype(String value) {
        this.majortype = value;
    }
    /** 获取:专业类别 */
    public String getMajortype() {
        return majortype;
    }

    /** 设置:专业技术职务  */
    public void setMajorjob(String value) {
        this.majorjob = value;
    }
    /** 获取:专业技术职务 */
    public String getMajorjob() {
        return majorjob;
    }

    /** 设置:所在科室KSDM  */
    public void setOfficecode(Integer value) {
        this.officecode = value;
    }
    /** 获取:所在科室KSDM */
    public Integer getOfficecode() {
        return officecode;
    }

    /** 设置:所在机构JGID  */
    public void setOrganizcode(Integer value) {
        this.organizcode = value;
    }
    /** 获取:所在机构JGID */
    public Integer getOrganizcode() {
        return organizcode;
    }

    /** 设置:联系地址  */
    public void setAddress(String value) {
        this.address = value;
    }
    /** 获取:联系地址 */
    public String getAddress() {
        return address;
    }

    /** 设置:拼音代码PYDM  */
    public void setPycode(String value) {
        this.pycode = value;
    }
    /** 获取:拼音代码PYDM */
    public String getPycode() {
        return pycode;
    }

    /** 设置:医生简介  */
    public void setRemark(String value) {
        this.remark = value;
    }
    /** 获取:医生简介 */
    public String getRemark() {
        return remark;
    }

    /** 设置:执业证书编码  */
    public void setCertificatenum(String value) {
        this.certificatenum = value;
    }
    /** 获取:执业证书编码 */
    public String getCertificatenum() {
        return certificatenum;
    }

    /** 设置:专业技术资格  */
    public void setMajorqualify(String value) {
        this.majorqualify = value;
    }
    /** 获取:专业技术资格 */
    public String getMajorqualify() {
        return majorqualify;
    }

    /** 设置:医师执业范围  */
    public void setOperationscope(String value) {
        this.operationscope = value;
    }
    /** 获取:医师执业范围 */
    public String getOperationscope() {
        return operationscope;
    }

    /** 设置:所学专业  */
    public void setMajorname(String value) {
        this.majorname = value;
    }
    /** 获取:所学专业 */
    public String getMajorname() {
        return majorname;
    }

    /** 设置:专家费用ZJFY  */
    public void setExpertcost(Integer value) {
        this.expertcost = value;
    }
    /** 获取:专家费用ZJFY */
    public Integer getExpertcost() {
        return expertcost;
    }

    /** 设置:开处方权KCFQ  */
    public void setPrescriberight(String value) {
        this.prescriberight = value;
    }
    /** 获取:开处方权KCFQ */
    public String getPrescriberight() {
        return prescriberight;
    }

    /** 设置:麻醉药权MZYQ  */
    public void setNarcoticright(String value) {
        this.narcoticright = value;
    }
    /** 获取:麻醉药权MZYQ */
    public String getNarcoticright() {
        return narcoticright;
    }

    /** 设置:精神药权JSYQ  */
    public void setPsychotropicright(String value) {
        this.psychotropicright = value;
    }
    /** 获取:精神药权JSYQ */
    public String getPsychotropicright() {
        return psychotropicright;
    }

    /** 设置:最后修改日期  */
    public void setLastmodifydate(Timestamp value) {
        this.lastmodifydate = value;
    }
    /** 获取:最后修改日期 */
    public Timestamp getLastmodifydate() {
        return lastmodifydate;
    }

    /** 设置:作废判别ZFPB  */
    public void setLogoff(String value) {
        this.logoff = value;
    }
    /** 获取:作废判别ZFPB */
    public String getLogoff() {
        return logoff;
    }

    /** 设置:五笔码WBDM  */
    public void setWbcode(String value) {
        this.wbcode = value;
    }
    /** 获取:五笔码WBDM */
    public String getWbcode() {
        return wbcode;
    }

    /** 设置:角形码JXDM  */
    public void setJxcode(String value) {
        this.jxcode = value;
    }
    /** 获取:角形码JXDM */
    public String getJxcode() {
        return jxcode;
    }

    /** 设置:其他码QTDM  */
    public void setQtcode(String value) {
        this.qtcode = value;
    }
    /** 获取:其他码QTDM */
    public String getQtcode() {
        return qtcode;
    }

    /** 设置:医疗角色  */
    public void setMedicalroles(Integer value) {
        this.medicalroles = value;
    }
    /** 获取:医疗角色 */
    public Integer getMedicalroles() {
        return medicalroles;
    }

    /** 设置:抗生素等级  */
    public void setAntibioticlevel(String value) {
        this.antibioticlevel = value;
    }
    /** 获取:抗生素等级 */
    public String getAntibioticlevel() {
        return antibioticlevel;
    }

    /** 设置:职业编号  */
    public void setZybh(String value) {
        this.zybh = value;
    }
    /** 获取:职业编号 */
    public String getZybh() {
        return zybh;
    }

    /** 设置:家庭医生角色  */
    public void setGprole(String value) {
        this.gprole = value;
    }
    /** 获取:家庭医生角色 */
    public String getGprole() {
        return gprole;
    }

    /** 设置:人员编号  */
    public void setRybh(String value) {
        this.rybh = value;
    }
    /** 获取:人员编号 */
    public String getRybh() {
        return rybh;
    }

    /** 设置:机构编码  */
    public void setYgdm(String value) {
        this.ygdm = value;
    }
    /** 获取:机构编码 */
    public String getYgdm() {
        return ygdm;
    }

    /** 设置:GP医生编号  */
    public void setGpid(String value) {
        this.gpid = value;
    }
    /** 获取:GP医生编号 */
    public String getGpid() {
        return gpid;
    }

    /** 设置:职业医生姓名  */
    public void setZyysxm(String value) {
        this.zyysxm = value;
    }
    /** 获取:职业医生姓名 */
    public String getZyysxm() {
        return zyysxm;
    }

    /** 设置:对应40库绩效卡号  */
    public void setCardid(String value) {
        this.cardid = value;
    }
    /** 获取:对应40库绩效卡号 */
    public String getCardid() {
        return cardid;
    }

    /** 设置:注销人员  */
    public void setLogoffoperater(Integer value) {
        this.logoffoperater = value;
    }
    /** 获取:注销人员 */
    public Integer getLogoffoperater() {
        return logoffoperater;
    }

    /** 设置:注销时间  */
    public void setLogofftime(Timestamp value) {
        this.logofftime = value;
    }
    /** 获取:注销时间 */
    public Timestamp getLogofftime() {
        return logofftime;
    }

    /** 设置:恢复操作人  */
    public void setRecoveroperater(Integer value) {
        this.recoveroperater = value;
    }
    /** 获取:恢复操作人 */
    public Integer getRecoveroperater() {
        return recoveroperater;
    }

    /** 设置:恢复时间  */
    public void setRecovertime(Timestamp value) {
        this.recovertime = value;
    }
    /** 获取:恢复时间 */
    public Timestamp getRecovertime() {
        return recovertime;
    }

    /** 设置:特需费用  */
    public void setSpecialcost(Integer value) {
        this.specialcost = value;
    }
    /** 获取:特需费用 */
    public Integer getSpecialcost() {
        return specialcost;
    }

    /** 设置:阳光医药密码  */
    public void setYgPassword(String value) {
        this.ygPassword = value;
    }
    /** 获取:阳光医药密码 */
    public String getYgPassword() {
        return ygPassword;
    }

    /** 设置:现住址-市 DE02.01.009.02  */
    public void setCityId(Integer value) {
        this.cityId = value;
    }
    /** 获取:现住址-市 DE02.01.009.02 */
    public Integer getCityId() {
        return cityId;
    }

    /** 设置:国籍代码 DE02.01.015.00  */
    public void setCountryId(String value) {
        this.countryId = value;
    }
    /** 获取:国籍代码 DE02.01.015.00 */
    public String getCountryId() {
        return countryId;
    }

    /** 设置:现住址-县 DE02.01.009.03  */
    public void setCountyId(Integer value) {
        this.countyId = value;
    }
    /** 获取:现住址-县 DE02.01.009.03 */
    public Integer getCountyId() {
        return countyId;
    }

    /** 设置:数据版本  */
    public void setDataVersion(Integer value) {
        this.dataVersion = value;
    }
    /** 获取:数据版本 */
    public Integer getDataVersion() {
        return dataVersion;
    }

    /** 设置:数据创建时间  */
    public void setGmtCreate(Timestamp value) {
        this.gmtCreate = value;
    }
    /** 获取:数据创建时间 */
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    /** 设置:婚姻状况类别代码 DE02.01.018.00  */
    public void setMarriageTypeId(String value) {
        this.marriageTypeId = value;
    }
    /** 获取:婚姻状况类别代码 DE02.01.018.00 */
    public String getMarriageTypeId() {
        return marriageTypeId;
    }

    /** 设置:办公室电话  */
    public void setOfficeTelephone(String value) {
        this.officeTelephone = value;
    }
    /** 获取:办公室电话 */
    public String getOfficeTelephone() {
        return officeTelephone;
    }

    /** 设置:职工分类标志  */
    public void setPersonClassId(String value) {
        this.personClassId = value;
    }
    /** 获取:职工分类标志 */
    public String getPersonClassId() {
        return personClassId;
    }

    /** 设置:现住址-省 DE02.01.009.01  */
    public void setProvinceId(Integer value) {
        this.provinceId = value;
    }
    /** 获取:现住址-省 DE02.01.009.01 */
    public Integer getProvinceId() {
        return provinceId;
    }

    /** 设置:专家判别ZJPB  */
    public void setIsexpert(String value) {
        this.isexpert = value;
    }
    /** 获取:专家判别ZJPB */
    public String getIsexpert() {
        return isexpert;
    }

    /** 设置:抗生素权KSYQ  */
    public void setAntibioticright(String value) {
        this.antibioticright = value;
    }
    /** 获取:抗生素权KSYQ */
    public String getAntibioticright() {
        return antibioticright;
    }

    /** 设置:特需判别  */
    public void setIsspecial(String value) {
        this.isspecial = value;
    }
    /** 获取:特需判别 */
    public String getIsspecial() {
        return isspecial;
    }

    /** 设置:家床管理员 1.是   0.否  */
    public void setJcgly(String value) {
        this.jcgly = value;
    }
    /** 获取:家床管理员 1.是   0.否 */
    public String getJcgly() {
        return jcgly;
    }  


}
