package com.buit.commons.response;//
//package com.buit.cis.op.dctwork.response;
//
//import java.sql.Timestamp;
//
//import com.his.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：PubPelplehealthdiagnose<br> 
// * 类描述：健康教育诊断信息<br>
// * @author 老花生
// */
//@ApiModel(value="健康教育诊断信息")
//public class PubPelplehealthdiagnoseResp  extends  PageQuery{
//    @ApiModelProperty(value="疾病序号")
//    private String diagnoseid;
//    @ApiModelProperty(value="处方序号")
//    private String recordid;
//    @ApiModelProperty(value="ICD10")
//    private String icd10;
//    @ApiModelProperty(value="疾病名称")
//    private String diagnosename;
//    @ApiModelProperty(value="疾病名称拼音码")
//    private String diagnosenamepy;
//    @ApiModelProperty(value="疾病类别")
//    private String diagnosetype;
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
//    /**
//     * 设置:疾病序号
//     */
//    public void setDiagnoseid(String value) {
//        this.diagnoseid = value;
//    }
//    /**
//     * 获取:疾病序号
//     */
//    public String getDiagnoseid() {
//        return diagnoseid;
//    }
//    /**
//     * 设置:处方序号
//     */
//    public void setRecordid(String value) {
//        this.recordid = value;
//    }
//    /**
//     * 获取:处方序号
//     */
//    public String getRecordid() {
//        return recordid;
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
//     * 设置:疾病名称
//     */
//    public void setDiagnosename(String value) {
//        this.diagnosename = value;
//    }
//    /**
//     * 获取:疾病名称
//     */
//    public String getDiagnosename() {
//        return diagnosename;
//    }
//    /**
//     * 设置:疾病名称拼音码
//     */
//    public void setDiagnosenamepy(String value) {
//        this.diagnosenamepy = value;
//    }
//    /**
//     * 获取:疾病名称拼音码
//     */
//    public String getDiagnosenamepy() {
//        return diagnosenamepy;
//    }
//    /**
//     * 设置:疾病类别
//     */
//    public void setDiagnosetype(String value) {
//        this.diagnosetype = value;
//    }
//    /**
//     * 获取:疾病类别
//     */
//    public String getDiagnosetype() {
//        return diagnosetype;
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
//}