package com.buit.commons.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * 类名称：DicYljg<br>
 * 类描述：医疗卫生机构索引表
 *
 * @author yueyu
 * @ApiModel(value="医疗卫生机构索引表")
 */
public class DicYljg extends PageQuery {
    @ApiModelProperty(value = "唯一ID")
    private Integer hospitalId;
    @ApiModelProperty(value = "数据版本")
    private Integer dataVersion;
    @ApiModelProperty(value = "数据创建时间")
    private Timestamp gmtCreate;
    @ApiModelProperty(value = "数据修改时间")
    private Timestamp gmtModify;
    @ApiModelProperty(value = "医疗机构代码(医保)")
    private String hospitalCode;
    @ApiModelProperty(value = "上级医疗机构ID")
    private Integer parentHospitalId;
    @ApiModelProperty(value = "医疗机构组织机构代码DE08.10.052.00")
    private String organizationCode;
    @ApiModelProperty(value = "医疗机构名称 DE08.10.013.00")
    private String hospitalName;
    @ApiModelProperty(value = "第二医疗机构名称")
    private String secondHospitalName;
    @ApiModelProperty(value = "医院医保全称")
    private String affiliatedName;
    @ApiModelProperty(value = "医院简称")
    private String secondName;
    @ApiModelProperty(value = "医疗机构联系电话 DE02.01.010.00")
    private String telephone;
    @ApiModelProperty(value = "国籍代码 DE02.01.015.00")
    private String countryId;
    @ApiModelProperty(value = "地址-省 DE02.01.009.01")
    private String provinceId;
    @ApiModelProperty(value = "地址-市 DE02.01.009.02")
    private String cityId;
    @ApiModelProperty(value = "地址-县 DE02.01.009.03")
    private String countyId;
    @ApiModelProperty(value = "地址-乡 DE02.01.009.04")
    private String townshipAddr;
    @ApiModelProperty(value = "地址-村 DE02.01.009.05")
    private String villageAddr;
    @ApiModelProperty(value = "地址-门牌号码 DE02.01.009.06")
    private String addrNumber;
    @ApiModelProperty(value = "邮政编码 DE02.01.047.00")
    private String phoneNumber;
    @ApiModelProperty(value = "医疗机构负责人(法人)姓名 DE02.01.039.00")
    private String chargeName;
    @ApiModelProperty(value = "法人代表电话")
    private String chargeTelephone;
    @ApiModelProperty(value = "法人代表身份证")
    private String chargeRecordNumber;
    @ApiModelProperty(value = "法人代表手机")
    private String chargeMobileNumber;
    @ApiModelProperty(value = "单位电子邮箱")
    private String email;
    @ApiModelProperty(value = "卫生机构类别代码")
    private Integer hospitalClassId;
    @ApiModelProperty(value = "医院等级代码PD000059")
    private String hospitalGradeId;
    @ApiModelProperty(value = "单位成立日期")
    private Timestamp setupDate;
    @ApiModelProperty(value = "单位撤销日期")
    private Timestamp revokeDate;
    @ApiModelProperty(value = "注册ID 关联官网医疗结构注册ID")
    private Integer registId;
    @ApiModelProperty(value = "组织结构类型 0 管理组织 1 医疗机构")
    private String organizationType;
    @ApiModelProperty(value = "机构网站")
    private String website;
    @ApiModelProperty(value = "核定床位")
    private Integer approvedBed;
    @ApiModelProperty(value = "核定编制")
    private Integer approvedPreparation;
    @ApiModelProperty(value = "停用标志")
    private String stopFlag;
    @ApiModelProperty(value = "启用时间")
    private Timestamp beginDate;
    @ApiModelProperty(value = "停用时间")
    private Timestamp endDate;
    @ApiModelProperty(value = "拼音码")
    private String pyCode;
    @ApiModelProperty(value = "五笔码")
    private String wbCode;

    /**
     * 设置:唯一ID
     */
    public void setHospitalId(Integer value) {
        this.hospitalId = value;
    }

    /**
     * 获取:唯一ID
     */
    public Integer getHospitalId() {
        return hospitalId;
    }

    /**
     * 设置:数据版本
     */
    public void setDataVersion(Integer value) {
        this.dataVersion = value;
    }

    /**
     * 获取:数据版本
     */
    public Integer getDataVersion() {
        return dataVersion;
    }

    /**
     * 设置:数据创建时间
     */
    public void setGmtCreate(Timestamp value) {
        this.gmtCreate = value;
    }

    /**
     * 获取:数据创建时间
     */
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置:数据修改时间
     */
    public void setGmtModify(Timestamp value) {
        this.gmtModify = value;
    }

    /**
     * 获取:数据修改时间
     */
    public Timestamp getGmtModify() {
        return gmtModify;
    }

    /**
     * 设置:医疗机构代码(医保)
     */
    public void setHospitalCode(String value) {
        this.hospitalCode = value;
    }

    /**
     * 获取:医疗机构代码(医保)
     */
    public String getHospitalCode() {
        return hospitalCode;
    }

    /**
     * 设置:上级医疗机构ID
     */
    public void setParentHospitalId(Integer value) {
        this.parentHospitalId = value;
    }

    /**
     * 获取:上级医疗机构ID
     */
    public Integer getParentHospitalId() {
        return parentHospitalId;
    }

    /**
     * 设置:医疗机构组织机构代码DE08.10.052.00
     */
    public void setOrganizationCode(String value) {
        this.organizationCode = value;
    }

    /**
     * 获取:医疗机构组织机构代码DE08.10.052.00
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * 设置:医疗机构名称 DE08.10.013.00
     */
    public void setHospitalName(String value) {
        this.hospitalName = value;
    }

    /**
     * 获取:医疗机构名称 DE08.10.013.00
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * 设置:第二医疗机构名称
     */
    public void setSecondHospitalName(String value) {
        this.secondHospitalName = value;
    }

    /**
     * 获取:第二医疗机构名称
     */
    public String getSecondHospitalName() {
        return secondHospitalName;
    }

    /**
     * 设置:医院医保全称
     */
    public void setAffiliatedName(String value) {
        this.affiliatedName = value;
    }

    /**
     * 获取:医院医保全称
     */
    public String getAffiliatedName() {
        return affiliatedName;
    }

    /**
     * 设置:医院简称
     */
    public void setSecondName(String value) {
        this.secondName = value;
    }

    /**
     * 获取:医院简称
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * 设置:医疗机构联系电话 DE02.01.010.00
     */
    public void setTelephone(String value) {
        this.telephone = value;
    }

    /**
     * 获取:医疗机构联系电话 DE02.01.010.00
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置:国籍代码 DE02.01.015.00
     */
    public void setCountryId(String value) {
        this.countryId = value;
    }

    /**
     * 获取:国籍代码 DE02.01.015.00
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * 设置:地址-省 DE02.01.009.01
     */
    public void setProvinceId(String value) {
        this.provinceId = value;
    }

    /**
     * 获取:地址-省 DE02.01.009.01
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * 设置:地址-市 DE02.01.009.02
     */
    public void setCityId(String value) {
        this.cityId = value;
    }

    /**
     * 获取:地址-市 DE02.01.009.02
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 设置:地址-县 DE02.01.009.03
     */
    public void setCountyId(String value) {
        this.countyId = value;
    }

    /**
     * 获取:地址-县 DE02.01.009.03
     */
    public String getCountyId() {
        return countyId;
    }

    /**
     * 设置:地址-乡 DE02.01.009.04
     */
    public void setTownshipAddr(String value) {
        this.townshipAddr = value;
    }

    /**
     * 获取:地址-乡 DE02.01.009.04
     */
    public String getTownshipAddr() {
        return townshipAddr;
    }

    /**
     * 设置:地址-村 DE02.01.009.05
     */
    public void setVillageAddr(String value) {
        this.villageAddr = value;
    }

    /**
     * 获取:地址-村 DE02.01.009.05
     */
    public String getVillageAddr() {
        return villageAddr;
    }

    /**
     * 设置:地址-门牌号码 DE02.01.009.06
     */
    public void setAddrNumber(String value) {
        this.addrNumber = value;
    }

    /**
     * 获取:地址-门牌号码 DE02.01.009.06
     */
    public String getAddrNumber() {
        return addrNumber;
    }

    /**
     * 设置:邮政编码 DE02.01.047.00
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * 获取:邮政编码 DE02.01.047.00
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置:医疗机构负责人(法人)姓名 DE02.01.039.00
     */
    public void setChargeName(String value) {
        this.chargeName = value;
    }

    /**
     * 获取:医疗机构负责人(法人)姓名 DE02.01.039.00
     */
    public String getChargeName() {
        return chargeName;
    }

    /**
     * 设置:法人代表电话
     */
    public void setChargeTelephone(String value) {
        this.chargeTelephone = value;
    }

    /**
     * 获取:法人代表电话
     */
    public String getChargeTelephone() {
        return chargeTelephone;
    }

    /**
     * 设置:法人代表身份证
     */
    public void setChargeRecordNumber(String value) {
        this.chargeRecordNumber = value;
    }

    /**
     * 获取:法人代表身份证
     */
    public String getChargeRecordNumber() {
        return chargeRecordNumber;
    }

    /**
     * 设置:法人代表手机
     */
    public void setChargeMobileNumber(String value) {
        this.chargeMobileNumber = value;
    }

    /**
     * 获取:法人代表手机
     */
    public String getChargeMobileNumber() {
        return chargeMobileNumber;
    }

    /**
     * 设置:单位电子邮箱
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * 获取:单位电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置:卫生机构类别代码
     */
    public void setHospitalClassId(Integer value) {
        this.hospitalClassId = value;
    }

    /**
     * 获取:卫生机构类别代码
     */
    public Integer getHospitalClassId() {
        return hospitalClassId;
    }

    /**
     * 设置:医院等级代码PD000059
     */
    public void setHospitalGradeId(String value) {
        this.hospitalGradeId = value;
    }

    /**
     * 获取:医院等级代码PD000059
     */
    public String getHospitalGradeId() {
        return hospitalGradeId;
    }

    /**
     * 设置:单位成立日期
     */
    public void setSetupDate(Timestamp value) {
        this.setupDate = value;
    }

    /**
     * 获取:单位成立日期
     */
    public Timestamp getSetupDate() {
        return setupDate;
    }

    /**
     * 设置:单位撤销日期
     */
    public void setRevokeDate(Timestamp value) {
        this.revokeDate = value;
    }

    /**
     * 获取:单位撤销日期
     */
    public Timestamp getRevokeDate() {
        return revokeDate;
    }

    /**
     * 设置:注册ID 关联官网医疗结构注册ID
     */
    public void setRegistId(Integer value) {
        this.registId = value;
    }

    /**
     * 获取:注册ID 关联官网医疗结构注册ID
     */
    public Integer getRegistId() {
        return registId;
    }

    /**
     * 设置:组织结构类型 0 管理组织 1 医疗机构
     */
    public void setOrganizationType(String value) {
        this.organizationType = value;
    }

    /**
     * 获取:组织结构类型 0 管理组织 1 医疗机构
     */
    public String getOrganizationType() {
        return organizationType;
    }

    /**
     * 设置:机构网站
     */
    public void setWebsite(String value) {
        this.website = value;
    }

    /**
     * 获取:机构网站
     */
    public String getWebsite() {
        return website;
    }

    /**
     * 设置:核定床位
     */
    public void setApprovedBed(Integer value) {
        this.approvedBed = value;
    }

    /**
     * 获取:核定床位
     */
    public Integer getApprovedBed() {
        return approvedBed;
    }

    /**
     * 设置:核定编制
     */
    public void setApprovedPreparation(Integer value) {
        this.approvedPreparation = value;
    }

    /**
     * 获取:核定编制
     */
    public Integer getApprovedPreparation() {
        return approvedPreparation;
    }

    /**
     * 设置:启用时间
     */
    public void setBeginDate(Timestamp value) {
        this.beginDate = value;
    }

    /**
     * 获取:启用时间
     */
    public Timestamp getBeginDate() {
        return beginDate;
    }

    /**
     * 设置:停用时间
     */
    public void setEndDate(Timestamp value) {
        this.endDate = value;
    }

    /**
     * 获取:停用时间
     */
    public Timestamp getEndDate() {
        return endDate;
    }

    /**
     * 设置:拼音码
     */
    public void setPyCode(String value) {
        this.pyCode = value;
    }

    /**
     * 获取:拼音码
     */
    public String getPyCode() {
        return pyCode;
    }

    /**
     * 设置:五笔码
     */
    public void setWbCode(String value) {
        this.wbCode = value;
    }

    /**
     * 获取:五笔码
     */
    public String getWbCode() {
        return wbCode;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }
}
