package com.buit.commons.response;//
//package com.buit.cis.op.dctwork.response;
//
//import java.sql.Timestamp;
//
//import com.buit.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：HerHealthreciperecord<br> 
// * 类描述：<br>
// * @author 老花生
// */
//@ApiModel(value="")
//public class HerHealthreciperecordResp  extends  PageQuery{
//    @ApiModelProperty(value="主键")
//    private String id;
//    @ApiModelProperty(value="empiid")
//    private String empiid;
//    @ApiModelProperty(value="健康档案编号")
//    private String phrid;
//    @ApiModelProperty(value="业务主键")
//    private String recordid;
//    @ApiModelProperty(value="就诊机构")
//    private String examineunit;
//    @ApiModelProperty(value="诊断名称")
//    private String diagnosename;
//    @ApiModelProperty(value="ICD10")
//    private String icd10;
//    @ApiModelProperty(value="指导日期")
//    private Timestamp guidedate;
//    @ApiModelProperty(value="指导医生")
//    private String guideuser;
//    @ApiModelProperty(value="指导建议")
//    private String healthteach;
//    @ApiModelProperty(value="指导途径")
//    private String guideway;
//    @ApiModelProperty(value="录入单位")
//    private String inputunit;
//    @ApiModelProperty(value="录入日期")
//    private Timestamp inputdate;
//    @ApiModelProperty(value="录入员工")
//    private String inputuser;
//    @ApiModelProperty(value="最后修改人")
//    private String lastmodifyuser;
//    @ApiModelProperty(value="最后修改机构")
//    private String lastmodifyunit;
//    @ApiModelProperty(value="最后修改日期")
//    private Timestamp lastmodifydate;
//    @ApiModelProperty(value="recipename")
//    private String recipename;
//    @ApiModelProperty(value="wayid")
//    private String wayid;
//    @ApiModelProperty(value="childid")
//    private String childid;
//    @ApiModelProperty(value="diagnoseid")
//    private String diagnoseid;
//    /**
//     * 设置:主键
//     */
//    public void setId(String value) {
//        this.id = value;
//    }
//    /**
//     * 获取:主键
//     */
//    public String getId() {
//        return id;
//    }
//    /**
//     * 设置:empiid
//     */
//    public void setEmpiid(String value) {
//        this.empiid = value;
//    }
//    /**
//     * 获取:empiid
//     */
//    public String getEmpiid() {
//        return empiid;
//    }
//    /**
//     * 设置:健康档案编号
//     */
//    public void setPhrid(String value) {
//        this.phrid = value;
//    }
//    /**
//     * 获取:健康档案编号
//     */
//    public String getPhrid() {
//        return phrid;
//    }
//    /**
//     * 设置:业务主键
//     */
//    public void setRecordid(String value) {
//        this.recordid = value;
//    }
//    /**
//     * 获取:业务主键
//     */
//    public String getRecordid() {
//        return recordid;
//    }
//    /**
//     * 设置:就诊机构
//     */
//    public void setExamineunit(String value) {
//        this.examineunit = value;
//    }
//    /**
//     * 获取:就诊机构
//     */
//    public String getExamineunit() {
//        return examineunit;
//    }
//    /**
//     * 设置:诊断名称
//     */
//    public void setDiagnosename(String value) {
//        this.diagnosename = value;
//    }
//    /**
//     * 获取:诊断名称
//     */
//    public String getDiagnosename() {
//        return diagnosename;
//    }
//    /**
//     * 设置:ICD10
//     */
//    public void setIcd10(String value) {
//        this.icd10 = value;
//    }
//    /**
//     * 获取:ICD10
//     */
//    public String getIcd10() {
//        return icd10;
//    }
//    /**
//     * 设置:指导日期
//     */
//    public void setGuidedate(Timestamp value) {
//        this.guidedate = value;
//    }
//    /**
//     * 获取:指导日期
//     */
//    public Timestamp getGuidedate() {
//        return guidedate;
//    }
//    /**
//     * 设置:指导医生
//     */
//    public void setGuideuser(String value) {
//        this.guideuser = value;
//    }
//    /**
//     * 获取:指导医生
//     */
//    public String getGuideuser() {
//        return guideuser;
//    }
//    /**
//     * 设置:指导建议
//     */
//    public void setHealthteach(String value) {
//        this.healthteach = value;
//    }
//    /**
//     * 获取:指导建议
//     */
//    public String getHealthteach() {
//        return healthteach;
//    }
//    /**
//     * 设置:指导途径
//     */
//    public void setGuideway(String value) {
//        this.guideway = value;
//    }
//    /**
//     * 获取:指导途径
//     */
//    public String getGuideway() {
//        return guideway;
//    }
//    /**
//     * 设置:录入单位
//     */
//    public void setInputunit(String value) {
//        this.inputunit = value;
//    }
//    /**
//     * 获取:录入单位
//     */
//    public String getInputunit() {
//        return inputunit;
//    }
//    /**
//     * 设置:录入日期
//     */
//    public void setInputdate(Timestamp value) {
//        this.inputdate = value;
//    }
//    /**
//     * 获取:录入日期
//     */
//    public Timestamp getInputdate() {
//        return inputdate;
//    }
//    /**
//     * 设置:录入员工
//     */
//    public void setInputuser(String value) {
//        this.inputuser = value;
//    }
//    /**
//     * 获取:录入员工
//     */
//    public String getInputuser() {
//        return inputuser;
//    }
//    /**
//     * 设置:最后修改人
//     */
//    public void setLastmodifyuser(String value) {
//        this.lastmodifyuser = value;
//    }
//    /**
//     * 获取:最后修改人
//     */
//    public String getLastmodifyuser() {
//        return lastmodifyuser;
//    }
//    /**
//     * 设置:最后修改机构
//     */
//    public void setLastmodifyunit(String value) {
//        this.lastmodifyunit = value;
//    }
//    /**
//     * 获取:最后修改机构
//     */
//    public String getLastmodifyunit() {
//        return lastmodifyunit;
//    }
//    /**
//     * 设置:最后修改日期
//     */
//    public void setLastmodifydate(Timestamp value) {
//        this.lastmodifydate = value;
//    }
//    /**
//     * 获取:最后修改日期
//     */
//    public Timestamp getLastmodifydate() {
//        return lastmodifydate;
//    }
//    /**
//     * 设置:recipename
//     */
//    public void setRecipename(String value) {
//        this.recipename = value;
//    }
//    /**
//     * 获取:recipename
//     */
//    public String getRecipename() {
//        return recipename;
//    }
//    /**
//     * 设置:wayid
//     */
//    public void setWayid(String value) {
//        this.wayid = value;
//    }
//    /**
//     * 获取:wayid
//     */
//    public String getWayid() {
//        return wayid;
//    }
//    /**
//     * 设置:childid
//     */
//    public void setChildid(String value) {
//        this.childid = value;
//    }
//    /**
//     * 获取:childid
//     */
//    public String getChildid() {
//        return childid;
//    }
//    /**
//     * 设置:diagnoseid
//     */
//    public void setDiagnoseid(String value) {
//        this.diagnoseid = value;
//    }
//    /**
//     * 获取:diagnoseid
//     */
//    public String getDiagnoseid() {
//        return diagnoseid;
//    }
//}