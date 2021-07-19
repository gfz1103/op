package com.buit.commons.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：PubPelplehealthteachMb<br> 
 * 类描述：老年人健康教育
 * @author 老花生 
 * @ApiModel(value="老年人健康教育")
 */
public class PubPelplehealthteachMb  extends PageQuery {
	//@ApiModelProperty(value="处方主键")
    /** 处方主键 */
    private String recordid;
	//@ApiModelProperty(value="诊断名称")
    /** 诊断名称 */
    private String diagnosename;
	//@ApiModelProperty(value="ICD10")
    /** ICD10 */
    private String icd10;
	//@ApiModelProperty(value="健康处方内容")
    /** 健康处方内容 */
    private String healthteach;
	//@ApiModelProperty(value="录入单位")
    /** 录入单位 */
    private String inputunit;
	//@ApiModelProperty(value="录入日期")
    /** 录入日期 */
    private Timestamp inputdate;
	//@ApiModelProperty(value="录入员工")
    /** 录入员工 */
    private String inputuser;
	//@ApiModelProperty(value="最后修改人")
    /** 最后修改人 */
    private String lastmodifyuser;
	//@ApiModelProperty(value="最后修改机构")
    /** 最后修改机构 */
    private String lastmodifyunit;
	//@ApiModelProperty(value="最后修改日期")
    /** 最后修改日期 */
    private Timestamp lastmodifydate;
	//@ApiModelProperty(value="健康处方名称")
    /** 健康处方名称 */
    private String recipename;
	//@ApiModelProperty(value="模版主键")
    /** 模版主键 */
    private String jlxh;
	//@ApiModelProperty(value="记录序号")
    /** 记录序号 */
    private String id;
	//@ApiModelProperty(value="recipenamepy")
    /** recipenamepy */
    private String recipenamepy;
	//@ApiModelProperty(value="diagnosenamepy")
    /** diagnosenamepy */
    private String diagnosenamepy;
	//@ApiModelProperty(value="diagnoseid")
    /** diagnoseid */
    private String diagnoseid;

    /** 设置:处方主键  */
    public void setRecordid(String value) {
        this.recordid = value;
    }
    /** 获取:处方主键 */
    public String getRecordid() {
        return recordid;
    }

    /** 设置:诊断名称  */
    public void setDiagnosename(String value) {
        this.diagnosename = value;
    }
    /** 获取:诊断名称 */
    public String getDiagnosename() {
        return diagnosename;
    }

    /** 设置:ICD10  */
    public void setIcd10(String value) {
        this.icd10 = value;
    }
    /** 获取:ICD10 */
    public String getIcd10() {
        return icd10;
    }

    /** 设置:健康处方内容  */
    public void setHealthteach(String value) {
        this.healthteach = value;
    }
    /** 获取:健康处方内容 */
    public String getHealthteach() {
        return healthteach;
    }

    /** 设置:录入单位  */
    public void setInputunit(String value) {
        this.inputunit = value;
    }
    /** 获取:录入单位 */
    public String getInputunit() {
        return inputunit;
    }

    /** 设置:录入日期  */
    public void setInputdate(Timestamp value) {
        this.inputdate = value;
    }
    /** 获取:录入日期 */
    public Timestamp getInputdate() {
        return inputdate;
    }

    /** 设置:录入员工  */
    public void setInputuser(String value) {
        this.inputuser = value;
    }
    /** 获取:录入员工 */
    public String getInputuser() {
        return inputuser;
    }

    /** 设置:最后修改人  */
    public void setLastmodifyuser(String value) {
        this.lastmodifyuser = value;
    }
    /** 获取:最后修改人 */
    public String getLastmodifyuser() {
        return lastmodifyuser;
    }

    /** 设置:最后修改机构  */
    public void setLastmodifyunit(String value) {
        this.lastmodifyunit = value;
    }
    /** 获取:最后修改机构 */
    public String getLastmodifyunit() {
        return lastmodifyunit;
    }

    /** 设置:最后修改日期  */
    public void setLastmodifydate(Timestamp value) {
        this.lastmodifydate = value;
    }
    /** 获取:最后修改日期 */
    public Timestamp getLastmodifydate() {
        return lastmodifydate;
    }

    /** 设置:健康处方名称  */
    public void setRecipename(String value) {
        this.recipename = value;
    }
    /** 获取:健康处方名称 */
    public String getRecipename() {
        return recipename;
    }

    /** 设置:模版主键  */
    public void setJlxh(String value) {
        this.jlxh = value;
    }
    /** 获取:模版主键 */
    public String getJlxh() {
        return jlxh;
    }

    /** 设置:记录序号  */
    public void setId(String value) {
        this.id = value;
    }
    /** 获取:记录序号 */
    public String getId() {
        return id;
    }

    /** 设置:recipenamepy  */
    public void setRecipenamepy(String value) {
        this.recipenamepy = value;
    }
    /** 获取:recipenamepy */
    public String getRecipenamepy() {
        return recipenamepy;
    }

    /** 设置:diagnosenamepy  */
    public void setDiagnosenamepy(String value) {
        this.diagnosenamepy = value;
    }
    /** 获取:diagnosenamepy */
    public String getDiagnosenamepy() {
        return diagnosenamepy;
    }

    /** 设置:diagnoseid  */
    public void setDiagnoseid(String value) {
        this.diagnoseid = value;
    }
    /** 获取:diagnoseid */
    public String getDiagnoseid() {
        return diagnoseid;
    }


}