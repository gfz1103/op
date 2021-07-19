package com.buit.commons.model;

import com.buit.commons.PageQuery;

/**
 * 类名称：ApiEcgReport<br> 
 * 类描述：接口心电图
 * @author 老花生 
 * @ApiModel(value="接口心电图")
 */
public class ApiEcgReport  extends  PageQuery{
	//@ApiModelProperty(value="id")
    /** id */
    private Integer id;
	//@ApiModelProperty(value="病人ID")
    /** 病人ID */
    private String brId;
	//@ApiModelProperty(value="HIS 给出的编号（比如申请单号码等）与信息获取相对应 体检患者对应体检流水号")
    /** HIS 给出的编号（比如申请单号码等）与信息获取相对应 体检患者对应体检流水号 */
    private String reqId;
	//@ApiModelProperty(value="项目编号，格式为：2302/2308/2375（每个组合C4:C18项目之间用“/”隔开）")
    /** 项目编号，格式为：2302/2308/2375（每个组合C4:C18项目之间用“/”隔开） */
    private String chkitId;
	//@ApiModelProperty(value="病人类型：0-门诊、1-住院、2-体检")
    /** 病人类型：0-门诊、1-住院、2-体检 */
    private String patType;
	//@ApiModelProperty(value="报告的唯一ID")
    /** 报告的唯一ID */
    private String reportId;
	//@ApiModelProperty(value="病人的检查编号(RIS 产生) ")
    /** 病人的检查编号(RIS 产生)  */
    private String patientNo;
	//@ApiModelProperty(value="报告医生姓名")
    /** 报告医生姓名 */
    private String reporter;
	//@ApiModelProperty(value="审核医生姓名")
    /** 审核医生姓名 */
    private String auditor;
	//@ApiModelProperty(value="报告日期YYYY-MM-DD")
    /** 报告日期YYYY-MM-DD */
    private String writedate;
	//@ApiModelProperty(value="报告时间HH24:MI:SS")
    /** 报告时间HH24:MI:SS */
    private String writetime;
	//@ApiModelProperty(value="审核日期YYYY-MM-DD")
    /** 审核日期YYYY-MM-DD */
    private String auditdate;
	//@ApiModelProperty(value="审核时间HH24:MI:SS")
    /** 审核时间HH24:MI:SS */
    private String audittime;
	//@ApiModelProperty(value="检查部位")
    /** 检查部位 */
    private String bodypart;
	//@ApiModelProperty(value="检查名称")
    /** 检查名称 */
    private String examname;
	//@ApiModelProperty(value="检查方法")
    /** 检查方法 */
    private String exammethod;
	//@ApiModelProperty(value="影像所见")
    /** 影像所见 */
    private String diagdesc;
	//@ApiModelProperty(value="诊断结论")
    /** 诊断结论 */
    private String diagname;
	//@ApiModelProperty(value="就诊流水号")
    /** 就诊流水号 */
    private String jzlsh;

    /** 设置:id  */
    public void setId(Integer value) {
        this.id = value;
    }
    /** 获取:id */
    public Integer getId() {
        return id;
    }

    /** 设置:病人ID  */
    public void setBrId(String value) {
        this.brId = value;
    }
    /** 获取:病人ID */
    public String getBrId() {
        return brId;
    }

    /** 设置:HIS 给出的编号（比如申请单号码等）与信息获取相对应 体检患者对应体检流水号  */
    public void setReqId(String value) {
        this.reqId = value;
    }
    /** 获取:HIS 给出的编号（比如申请单号码等）与信息获取相对应 体检患者对应体检流水号 */
    public String getReqId() {
        return reqId;
    }

    /** 设置:项目编号，格式为：2302/2308/2375（每个组合C4:C18项目之间用“/”隔开）  */
    public void setChkitId(String value) {
        this.chkitId = value;
    }
    /** 获取:项目编号，格式为：2302/2308/2375（每个组合C4:C18项目之间用“/”隔开） */
    public String getChkitId() {
        return chkitId;
    }

    /** 设置:病人类型：0-门诊、1-住院、2-体检  */
    public void setPatType(String value) {
        this.patType = value;
    }
    /** 获取:病人类型：0-门诊、1-住院、2-体检 */
    public String getPatType() {
        return patType;
    }

    /** 设置:报告的唯一ID  */
    public void setReportId(String value) {
        this.reportId = value;
    }
    /** 获取:报告的唯一ID */
    public String getReportId() {
        return reportId;
    }

    /** 设置:病人的检查编号(RIS 产生)   */
    public void setPatientNo(String value) {
        this.patientNo = value;
    }
    /** 获取:病人的检查编号(RIS 产生)  */
    public String getPatientNo() {
        return patientNo;
    }

    /** 设置:报告医生姓名  */
    public void setReporter(String value) {
        this.reporter = value;
    }
    /** 获取:报告医生姓名 */
    public String getReporter() {
        return reporter;
    }

    /** 设置:审核医生姓名  */
    public void setAuditor(String value) {
        this.auditor = value;
    }
    /** 获取:审核医生姓名 */
    public String getAuditor() {
        return auditor;
    }

    /** 设置:报告日期YYYY-MM-DD  */
    public void setWritedate(String value) {
        this.writedate = value;
    }
    /** 获取:报告日期YYYY-MM-DD */
    public String getWritedate() {
        return writedate;
    }

    /** 设置:报告时间HH24:MI:SS  */
    public void setWritetime(String value) {
        this.writetime = value;
    }
    /** 获取:报告时间HH24:MI:SS */
    public String getWritetime() {
        return writetime;
    }

    /** 设置:审核日期YYYY-MM-DD  */
    public void setAuditdate(String value) {
        this.auditdate = value;
    }
    /** 获取:审核日期YYYY-MM-DD */
    public String getAuditdate() {
        return auditdate;
    }

    /** 设置:审核时间HH24:MI:SS  */
    public void setAudittime(String value) {
        this.audittime = value;
    }
    /** 获取:审核时间HH24:MI:SS */
    public String getAudittime() {
        return audittime;
    }

    /** 设置:检查部位  */
    public void setBodypart(String value) {
        this.bodypart = value;
    }
    /** 获取:检查部位 */
    public String getBodypart() {
        return bodypart;
    }

    /** 设置:检查名称  */
    public void setExamname(String value) {
        this.examname = value;
    }
    /** 获取:检查名称 */
    public String getExamname() {
        return examname;
    }

    /** 设置:检查方法  */
    public void setExammethod(String value) {
        this.exammethod = value;
    }
    /** 获取:检查方法 */
    public String getExammethod() {
        return exammethod;
    }

    /** 设置:影像所见  */
    public void setDiagdesc(String value) {
        this.diagdesc = value;
    }
    /** 获取:影像所见 */
    public String getDiagdesc() {
        return diagdesc;
    }

    /** 设置:诊断结论  */
    public void setDiagname(String value) {
        this.diagname = value;
    }
    /** 获取:诊断结论 */
    public String getDiagname() {
        return diagname;
    }

    /** 设置:就诊流水号  */
    public void setJzlsh(String value) {
        this.jzlsh = value;
    }
    /** 获取:就诊流水号 */
    public String getJzlsh() {
        return jzlsh;
    }


}
