
package com.buit.cis.op.dctwork.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：ApiPacsReport<br>
 * 类描述：接口检查<br>
 * @author 老花生
 */
@ApiModel(value="接口检查")
public class ApiPacsReportReq extends  PageQuery{
    @ApiModelProperty(value="主键唯一标识", hidden = true)
    private Integer id;
    @ApiModelProperty(value="病人ID", hidden = true)
    private String brid;
    @ApiModelProperty(value="HIS 给出的编号（比如申请单号码等）与信息获取相对应 体检患者对应体检流水号")
    private String reqId;
    @ApiModelProperty(value="项目编号，格式为：2302/2308/2375（每个组合项目之间用“/”隔开）", hidden = true)
    private String chkitId;
    @ApiModelProperty(value="病人类型：0-门诊、1-住院、2-体检", hidden = true)
    private String patType;
    @ApiModelProperty(value="报告的唯一ID", hidden = true)
    private String reportId;
    @ApiModelProperty(value="病人的检查编号(RIS 产生)", hidden = true)
    private String patientNo;
    @ApiModelProperty(value="报告医生姓名", hidden = true)
    private String reporter;
    @ApiModelProperty(value="审核医生姓名", hidden = true)
    private String auditor;
    @ApiModelProperty(value="报告日期YYYY-MM-DD", hidden = true)
    private String writedate;
    @ApiModelProperty(value="报告时间HH24:MI:SS", hidden = true)
    private String writetime;
    @ApiModelProperty(value="审核日期YYYY-MM-DD", hidden = true)
    private String auditdate;
    @ApiModelProperty(value="审核时间HH24:MI:SS", hidden = true)
    private String audittime;
    @ApiModelProperty(value="检查部位", hidden = true)
    private String bodypart;
    @ApiModelProperty(value="检查名称", hidden = true)
    private String examname;
    @ApiModelProperty(value="检查方法", hidden = true)
    private String exammethod;
    @ApiModelProperty(value="影像所见", hidden = true)
    private String diagdesc;
    @ApiModelProperty(value="诊断结论", hidden = true)
    private String diagname;
    @ApiModelProperty(value="医技类型1：放射、2：超声、3：内镜、4：心功能、5：特殊治疗、6：病理、7：特殊", hidden = true)
    private String medicalTechnologyType;
    @ApiModelProperty(value="影像URL地址", hidden = true)
    private String imgUrl;
    @ApiModelProperty(value="检查状态 1：未收费、2：已收费、3：已提交、4：已预约、5：已抽血（检验）、6：已检查、7：完成", hidden = true)
    private String examineType;
    @ApiModelProperty(value="预约日期", hidden = true)
    private String reservationDate;
    @ApiModelProperty(value="申请日期", hidden = true)
    private String reqData;
    @ApiModelProperty(value="就诊流水号", hidden = true)
    private String jzlsh;
    /**
     * 设置:主键唯一标识
     */
    public void setId(Integer value) {
        this.id = value;
    }
    /**
     * 获取:主键唯一标识
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置:病人ID
     */
    public void setBrid(String value) {
        this.brid = value;
    }
    /**
     * 获取:病人ID
     */
    public String getBrid() {
        return brid;
    }
    /**
     * 设置:HIS 给出的编号（比如申请单号码等）与信息获取相对应 体检患者对应体检流水号
     */
    public void setReqId(String value) {
        this.reqId = value;
    }
    /**
     * 获取:HIS 给出的编号（比如申请单号码等）与信息获取相对应 体检患者对应体检流水号
     */
    public String getReqId() {
        return reqId;
    }
    /**
     * 设置:项目编号，格式为：2302/2308/2375（每个组合项目之间用“/”隔开）
     */
    public void setChkitId(String value) {
        this.chkitId = value;
    }
    /**
     * 获取:项目编号，格式为：2302/2308/2375（每个组合项目之间用“/”隔开）
     */
    public String getChkitId() {
        return chkitId;
    }
    /**
     * 设置:病人类型：0-门诊、1-住院、2-体检
     */
    public void setPatType(String value) {
        this.patType = value;
    }
    /**
     * 获取:病人类型：0-门诊、1-住院、2-体检
     */
    public String getPatType() {
        return patType;
    }
    /**
     * 设置:报告的唯一ID
     */
    public void setReportId(String value) {
        this.reportId = value;
    }
    /**
     * 获取:报告的唯一ID
     */
    public String getReportId() {
        return reportId;
    }
    /**
     * 设置:病人的检查编号(RIS 产生)
     */
    public void setPatientNo(String value) {
        this.patientNo = value;
    }
    /**
     * 获取:病人的检查编号(RIS 产生)
     */
    public String getPatientNo() {
        return patientNo;
    }
    /**
     * 设置:报告医生姓名
     */
    public void setReporter(String value) {
        this.reporter = value;
    }
    /**
     * 获取:报告医生姓名
     */
    public String getReporter() {
        return reporter;
    }
    /**
     * 设置:审核医生姓名
     */
    public void setAuditor(String value) {
        this.auditor = value;
    }
    /**
     * 获取:审核医生姓名
     */
    public String getAuditor() {
        return auditor;
    }
    /**
     * 设置:报告日期YYYY-MM-DD
     */
    public void setWritedate(String value) {
        this.writedate = value;
    }
    /**
     * 获取:报告日期YYYY-MM-DD
     */
    public String getWritedate() {
        return writedate;
    }
    /**
     * 设置:报告时间HH24:MI:SS
     */
    public void setWritetime(String value) {
        this.writetime = value;
    }
    /**
     * 获取:报告时间HH24:MI:SS
     */
    public String getWritetime() {
        return writetime;
    }
    /**
     * 设置:审核日期YYYY-MM-DD
     */
    public void setAuditdate(String value) {
        this.auditdate = value;
    }
    /**
     * 获取:审核日期YYYY-MM-DD
     */
    public String getAuditdate() {
        return auditdate;
    }
    /**
     * 设置:审核时间HH24:MI:SS
     */
    public void setAudittime(String value) {
        this.audittime = value;
    }
    /**
     * 获取:审核时间HH24:MI:SS
     */
    public String getAudittime() {
        return audittime;
    }
    /**
     * 设置:检查部位
     */
    public void setBodypart(String value) {
        this.bodypart = value;
    }
    /**
     * 获取:检查部位
     */
    public String getBodypart() {
        return bodypart;
    }
    /**
     * 设置:检查名称
     */
    public void setExamname(String value) {
        this.examname = value;
    }
    /**
     * 获取:检查名称
     */
    public String getExamname() {
        return examname;
    }
    /**
     * 设置:检查方法
     */
    public void setExammethod(String value) {
        this.exammethod = value;
    }
    /**
     * 获取:检查方法
     */
    public String getExammethod() {
        return exammethod;
    }
    /**
     * 设置:影像所见
     */
    public void setDiagdesc(String value) {
        this.diagdesc = value;
    }
    /**
     * 获取:影像所见
     */
    public String getDiagdesc() {
        return diagdesc;
    }
    /**
     * 设置:诊断结论
     */
    public void setDiagname(String value) {
        this.diagname = value;
    }
    /**
     * 获取:诊断结论
     */
    public String getDiagname() {
        return diagname;
    }
    /**
     * 设置:医技类型1：放射、2：超声、3：内镜、4：心功能、5：特殊治疗、6：病理、7：特殊
     */
    public void setMedicalTechnologyType(String value) {
        this.medicalTechnologyType = value;
    }
    /**
     * 获取:医技类型1：放射、2：超声、3：内镜、4：心功能、5：特殊治疗、6：病理、7：特殊
     */
    public String getMedicalTechnologyType() {
        return medicalTechnologyType;
    }
    /**
     * 设置:影像URL地址
     */
    public void setImgUrl(String value) {
        this.imgUrl = value;
    }
    /**
     * 获取:影像URL地址
     */
    public String getImgUrl() {
        return imgUrl;
    }
    /**
     * 设置:检查状态 1：未收费、2：已收费、3：已提交、4：已预约、5：已抽血（检验）、6：已检查、7：完成
     */
    public void setExamineType(String value) {
        this.examineType = value;
    }
    /**
     * 获取:检查状态 1：未收费、2：已收费、3：已提交、4：已预约、5：已抽血（检验）、6：已检查、7：完成
     */
    public String getExamineType() {
        return examineType;
    }
    /**
     * 设置:预约日期
     */
    public void setReservationDate(String value) {
        this.reservationDate = value;
    }
    /**
     * 获取:预约日期
     */
    public String getReservationDate() {
        return reservationDate;
    }
    /**
     * 设置:申请日期
     */
    public void setReqData(String value) {
        this.reqData = value;
    }
    /**
     * 获取:申请日期
     */
    public String getReqData() {
        return reqData;
    }
    /**
     * 设置:就诊流水号
     */
    public void setJzlsh(String value) {
        this.jzlsh = value;
    }
    /**
     * 获取:就诊流水号
     */
    public String getJzlsh() {
        return jzlsh;
    }
}
