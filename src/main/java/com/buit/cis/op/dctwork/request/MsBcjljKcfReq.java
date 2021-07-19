package com.buit.cis.op.dctwork.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

@ApiModel(value="门诊_门诊病历 | 病程记录-保存请求-健康处方")
public class MsBcjljKcfReq {
    @ApiModelProperty(value="业务主键")
    private String recordid;
    @ApiModelProperty(value="empiid")
    private String empiid;
    @ApiModelProperty(value="录入日期")
    private Timestamp inputdate;
    @ApiModelProperty(value="recipename")
    private String recipename;
    @ApiModelProperty(value="最后修改机构")
    private String lastmodifyunit;
    @ApiModelProperty(value="最后修改机构")
    private String lastModifyUnitText;
    @ApiModelProperty(value="wayid")
    private String wayid;
    @ApiModelProperty(value="录入单位")
    private String inputunit;
    @ApiModelProperty(value="录入单位")
    private String inputUnitText;
    @ApiModelProperty(value="指导途径")
    private String guideway;
    @ApiModelProperty(value="指导途径")
    private String guideWayText;
    @ApiModelProperty(value="录入员工")
    private String inputuser;
    @ApiModelProperty(value="录入员工")
    private String inputUserText;
    @ApiModelProperty(value="指导建议")
    private String healthteach;
    @ApiModelProperty(value="指导日期")
    private Timestamp guidedate;
    @ApiModelProperty(value="就诊机构")
    /** 就诊机构 */
    private String examineunit;
    @ApiModelProperty(value="主键")
    private String id;
    @ApiModelProperty(value="ICD10")
    private String icd10;
    @ApiModelProperty(value="指导医生")
    private String guideuser;
    @ApiModelProperty(value="指导医生")
    private String guideUserText;
    @ApiModelProperty(value="最后修改人")
    private String lastmodifyuser;
    @ApiModelProperty(value="最后修改人")
    private String lastModifyUserText;
    @ApiModelProperty(value="健康档案编号")
    private String phrid;
    @ApiModelProperty(value="诊断名称")
    private String diagnosename;
    @ApiModelProperty(value="最后修改日期")
    private Timestamp lastmodifydate;
    @ApiModelProperty(value="diagnoseid")
    private String diagnoseid;

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public String getEmpiid() {
        return empiid;
    }

    public void setEmpiid(String empiid) {
        this.empiid = empiid;
    }

    public Timestamp getInputdate() {
        return inputdate;
    }

    public void setInputdate(Timestamp inputdate) {
        this.inputdate = inputdate;
    }

    public String getRecipename() {
        return recipename;
    }

    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    public String getLastmodifyunit() {
        return lastmodifyunit;
    }

    public void setLastmodifyunit(String lastmodifyunit) {
        this.lastmodifyunit = lastmodifyunit;
    }

    public String getWayid() {
        return wayid;
    }

    public void setWayid(String wayid) {
        this.wayid = wayid;
    }

    public String getInputunit() {
        return inputunit;
    }

    public void setInputunit(String inputunit) {
        this.inputunit = inputunit;
    }

    public String getGuideway() {
        return guideway;
    }

    public void setGuideway(String guideway) {
        this.guideway = guideway;
    }

    public String getInputuser() {
        return inputuser;
    }

    public void setInputuser(String inputuser) {
        this.inputuser = inputuser;
    }

    public String getInputUserText() {
        return inputUserText;
    }

    public void setInputUserText(String inputUserText) {
        this.inputUserText = inputUserText;
    }

    public String getHealthteach() {
        return healthteach;
    }

    public void setHealthteach(String healthteach) {
        this.healthteach = healthteach;
    }

    public Timestamp getGuidedate() {
        return guidedate;
    }

    public void setGuidedate(Timestamp guidedate) {
        this.guidedate = guidedate;
    }

    public String getExamineunit() {
        return examineunit;
    }

    public void setExamineunit(String examineunit) {
        this.examineunit = examineunit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcd10() {
        return icd10;
    }

    public void setIcd10(String icd10) {
        this.icd10 = icd10;
    }

    public String getGuideuser() {
        return guideuser;
    }

    public void setGuideuser(String guideuser) {
        this.guideuser = guideuser;
    }

    public String getGuideUserText() {
        return guideUserText;
    }

    public void setGuideUserText(String guideUserText) {
        this.guideUserText = guideUserText;
    }

    public String getLastmodifyuser() {
        return lastmodifyuser;
    }

    public void setLastmodifyuser(String lastmodifyuser) {
        this.lastmodifyuser = lastmodifyuser;
    }

    public String getLastModifyUserText() {
        return lastModifyUserText;
    }

    public void setLastModifyUserText(String lastModifyUserText) {
        this.lastModifyUserText = lastModifyUserText;
    }

    public String getPhrid() {
        return phrid;
    }

    public void setPhrid(String phrid) {
        this.phrid = phrid;
    }

    public String getDiagnosename() {
        return diagnosename;
    }

    public void setDiagnosename(String diagnosename) {
        this.diagnosename = diagnosename;
    }

    public Timestamp getLastmodifydate() {
        return lastmodifydate;
    }

    public void setLastmodifydate(Timestamp lastmodifydate) {
        this.lastmodifydate = lastmodifydate;
    }

    public String getDiagnoseid() {
        return diagnoseid;
    }

    public void setDiagnoseid(String diagnoseid) {
        this.diagnoseid = diagnoseid;
    }

    public String getLastModifyUnitText() {
        return lastModifyUnitText;
    }

    public void setLastModifyUnitText(String lastModifyUnitText) {
        this.lastModifyUnitText = lastModifyUnitText;
    }

    public String getInputUnitText() {
        return inputUnitText;
    }

    public void setInputUnitText(String inputUnitText) {
        this.inputUnitText = inputUnitText;
    }

    public String getGuideWayText() {
        return guideWayText;
    }

    public void setGuideWayText(String guideWayText) {
        this.guideWayText = guideWayText;
    }
}
