
package com.buit.commons.request;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：PubPelplehealthteach<br>
 * 类描述：老年人健康教育<br>
 * @author 老花生
 */
@ApiModel(value="老年人健康教育")
public class PubPelplehealthteachPageReq extends PageQuery {

    @ApiModelProperty(value="疾病拼音码")
    private String diagnosenamepy;
    @ApiModelProperty(value="健康处方拼音码")
    private String recipenamepy;
    @ApiModelProperty(value="疾病编码")
    private String icd10;


    @ApiModelProperty(value="记录序号", hidden = true)
    private String recordid;
    @ApiModelProperty(value="诊断名称", hidden = true)
    private String diagnosename;
    @ApiModelProperty(value="健康处方内容", hidden = true)
    private String healthteach;
    @ApiModelProperty(value="录入单位", hidden = true)
    private String inputunit;
    @ApiModelProperty(value="录入日期", hidden = true)
    private Timestamp inputdate;
    @ApiModelProperty(value="录入员工", hidden = true)
    private String inputuser;
    @ApiModelProperty(value="最后修改人", hidden = true)
    private String lastmodifyuser;
    @ApiModelProperty(value="最后修改机构", hidden = true)
    private String lastmodifyunit;
    @ApiModelProperty(value="最后修改日期", hidden = true)
    private Timestamp lastmodifydate;
    @ApiModelProperty(value="recipename", hidden = true)
    private String recipename;
    @ApiModelProperty(value="ordernum", hidden = true)
    private Integer ordernum;
    @ApiModelProperty(value="处方类型", hidden = true)
    private String recipetype;
    /**
     * 设置:记录序号
     */
    public void setRecordid(String value) {
        this.recordid = value;
    }
    /**
     * 获取:记录序号
     */
    public String getRecordid() {
        return recordid;
    }
    /**
     * 设置:诊断名称
     */
    public void setDiagnosename(String value) {
        this.diagnosename = value;
    }
    /**
     * 获取:诊断名称
     */
    public String getDiagnosename() {
        return diagnosename;
    }
    /**
     * 设置:ICD10
     */
    public void setIcd10(String value) {
        this.icd10 = value;
    }
    /**
     * 获取:ICD10
     */
    public String getIcd10() {
        return icd10;
    }
    /**
     * 设置:健康处方内容
     */
    public void setHealthteach(String value) {
        this.healthteach = value;
    }
    /**
     * 获取:健康处方内容
     */
    public String getHealthteach() {
        return healthteach;
    }
    /**
     * 设置:录入单位
     */
    public void setInputunit(String value) {
        this.inputunit = value;
    }
    /**
     * 获取:录入单位
     */
    public String getInputunit() {
        return inputunit;
    }
    /**
     * 设置:录入日期
     */
    public void setInputdate(Timestamp value) {
        this.inputdate = value;
    }
    /**
     * 获取:录入日期
     */
    public Timestamp getInputdate() {
        return inputdate;
    }
    /**
     * 设置:录入员工
     */
    public void setInputuser(String value) {
        this.inputuser = value;
    }
    /**
     * 获取:录入员工
     */
    public String getInputuser() {
        return inputuser;
    }
    /**
     * 设置:最后修改人
     */
    public void setLastmodifyuser(String value) {
        this.lastmodifyuser = value;
    }
    /**
     * 获取:最后修改人
     */
    public String getLastmodifyuser() {
        return lastmodifyuser;
    }
    /**
     * 设置:最后修改机构
     */
    public void setLastmodifyunit(String value) {
        this.lastmodifyunit = value;
    }
    /**
     * 获取:最后修改机构
     */
    public String getLastmodifyunit() {
        return lastmodifyunit;
    }
    /**
     * 设置:最后修改日期
     */
    public void setLastmodifydate(Timestamp value) {
        this.lastmodifydate = value;
    }
    /**
     * 获取:最后修改日期
     */
    public Timestamp getLastmodifydate() {
        return lastmodifydate;
    }
    /**
     * 设置:recipename
     */
    public void setRecipename(String value) {
        this.recipename = value;
    }
    /**
     * 获取:recipename
     */
    public String getRecipename() {
        return recipename;
    }
    /**
     * 设置:diagnosenamepy
     */
    public void setDiagnosenamepy(String value) {
        this.diagnosenamepy = value;
    }
    /**
     * 获取:diagnosenamepy
     */
    public String getDiagnosenamepy() {
        return diagnosenamepy;
    }
    /**
     * 设置:recipenamepy
     */
    public void setRecipenamepy(String value) {
        this.recipenamepy = value;
    }
    /**
     * 获取:recipenamepy
     */
    public String getRecipenamepy() {
        return recipenamepy;
    }
    /**
     * 设置:ordernum
     */
    public void setOrdernum(Integer value) {
        this.ordernum = value;
    }
    /**
     * 获取:ordernum
     */
    public Integer getOrdernum() {
        return ordernum;
    }
    /**
     * 设置:处方类型
     */
    public void setRecipetype(String value) {
        this.recipetype = value;
    }
    /**
     * 获取:处方类型
     */
    public String getRecipetype() {
        return recipetype;
    }
}