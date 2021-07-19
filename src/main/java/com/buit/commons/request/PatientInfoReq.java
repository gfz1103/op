package com.buit.commons.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：PatientInfoReq<br>
 * 类描述：初始化病人就诊信息请求<br>
 * @author 老花生
 */
public class PatientInfoReq {

    @ApiModelProperty(value="EMPI")
    private String empiId;

    @NotNull(message = "病人档案ID 不能为空")
    @ApiModelProperty(value="病人档案ID")
    private Integer brid;

    @NotNull(message = "就诊号码 不能为空")
    @ApiModelProperty(value="就诊号码")
    private String jzhm;

    @ApiModelProperty(value="识别序号 | 唯一标示一次挂号的序号")
    private Integer clinicId;

    @ApiModelProperty(value="启用公卫系统")
    private String qygwxt;

    @ApiModelProperty(value="挂号序号")
    private Integer ghxh;

    @NotNull(message = "类型不能为空")
    @ApiModelProperty(value="1:病历 2：诊断 3：处方 4:处置 5：所有")
    private String types;

    public Integer getGhxh() {
        return ghxh;
    }

    public void setGhxh(Integer ghxh) {
        this.ghxh = ghxh;
    }

    public String getEmpiId() {
        return empiId;
    }

    public void setEmpiId(String empiId) {
        this.empiId = empiId;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public String getJzhm() {
        return jzhm;
    }

    public void setJzhm(String jzhm) {
        this.jzhm = jzhm;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public String getQygwxt() {
        return qygwxt;
    }

    public void setQygwxt(String qygwxt) {
        this.qygwxt = qygwxt;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
