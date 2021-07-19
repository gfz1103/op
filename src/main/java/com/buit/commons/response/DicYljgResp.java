
package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.List;


/**
 * 类名称：DicYljg<br>
 * 类描述：医疗卫生机构索引表<br>
 *
 * @author liushijie
 */
@ApiModel(value = "医疗卫生机构索引表")
public class DicYljgResp {
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
    @ApiModelProperty(value = "启用时间")
    private Timestamp beginDate;
    @ApiModelProperty(value = "停用标志")
    private String stopFlag;
    @ApiModelProperty(value = "停用时间")
    private Timestamp endDate;
    @ApiModelProperty(value = "拼音码")
    private String pyCode;
    @ApiModelProperty(value = "五笔码")
    private String wbCode;
    @ApiModelProperty(value = "子集集合")
    private List<DicYljgResp> childrenList;

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(Integer dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Timestamp gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public Integer getParentHospitalId() {
        return parentHospitalId;
    }

    public void setParentHospitalId(Integer parentHospitalId) {
        this.parentHospitalId = parentHospitalId;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getSecondHospitalName() {
        return secondHospitalName;
    }

    public void setSecondHospitalName(String secondHospitalName) {
        this.secondHospitalName = secondHospitalName;
    }

    public String getAffiliatedName() {
        return affiliatedName;
    }

    public void setAffiliatedName(String affiliatedName) {
        this.affiliatedName = affiliatedName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getTownshipAddr() {
        return townshipAddr;
    }

    public void setTownshipAddr(String townshipAddr) {
        this.townshipAddr = townshipAddr;
    }

    public String getVillageAddr() {
        return villageAddr;
    }

    public void setVillageAddr(String villageAddr) {
        this.villageAddr = villageAddr;
    }

    public String getAddrNumber() {
        return addrNumber;
    }

    public void setAddrNumber(String addrNumber) {
        this.addrNumber = addrNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getChargeTelephone() {
        return chargeTelephone;
    }

    public void setChargeTelephone(String chargeTelephone) {
        this.chargeTelephone = chargeTelephone;
    }

    public String getChargeRecordNumber() {
        return chargeRecordNumber;
    }

    public void setChargeRecordNumber(String chargeRecordNumber) {
        this.chargeRecordNumber = chargeRecordNumber;
    }

    public String getChargeMobileNumber() {
        return chargeMobileNumber;
    }

    public void setChargeMobileNumber(String chargeMobileNumber) {
        this.chargeMobileNumber = chargeMobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getHospitalClassId() {
        return hospitalClassId;
    }

    public void setHospitalClassId(Integer hospitalClassId) {
        this.hospitalClassId = hospitalClassId;
    }

    public String getHospitalGradeId() {
        return hospitalGradeId;
    }

    public void setHospitalGradeId(String hospitalGradeId) {
        this.hospitalGradeId = hospitalGradeId;
    }

    public Timestamp getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(Timestamp setupDate) {
        this.setupDate = setupDate;
    }

    public Timestamp getRevokeDate() {
        return revokeDate;
    }

    public void setRevokeDate(Timestamp revokeDate) {
        this.revokeDate = revokeDate;
    }

    public Integer getRegistId() {
        return registId;
    }

    public void setRegistId(Integer registId) {
        this.registId = registId;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getApprovedBed() {
        return approvedBed;
    }

    public void setApprovedBed(Integer approvedBed) {
        this.approvedBed = approvedBed;
    }

    public Integer getApprovedPreparation() {
        return approvedPreparation;
    }

    public void setApprovedPreparation(Integer approvedPreparation) {
        this.approvedPreparation = approvedPreparation;
    }

    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getPyCode() {
        return pyCode;
    }

    public void setPyCode(String pyCode) {
        this.pyCode = pyCode;
    }

    public String getWbCode() {
        return wbCode;
    }

    public void setWbCode(String wbCode) {
        this.wbCode = wbCode;
    }

    public List<DicYljgResp> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<DicYljgResp> childrenList) {
        this.childrenList = childrenList;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }
}
