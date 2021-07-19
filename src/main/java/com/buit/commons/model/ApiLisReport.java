package com.buit.commons.model;

import com.buit.commons.PageQuery;

/**
 * 类名称：ApiLisReport<br> 
 * 类描述：接口检验
 * @author 老花生 
 * @ApiModel(value="接口检验")
 */
public class ApiLisReport  extends  PageQuery{
	//@ApiModelProperty(value="主键")
    /** 主键 */
    private Integer id;
	//@ApiModelProperty(value="申请单号，体检患者对应体检流水号")
    /** 申请单号，体检患者对应体检流水号 */
    private String reqNo;

    /** 申请医生 */
    private String reqDoctor;
	//@ApiModelProperty(value="病人ID")
    /** 病人ID */
    private String brId;
	//@ApiModelProperty(value="申请日期")
    /** 申请日期 */
    private String reqData;
	//@ApiModelProperty(value="项目金额")
    /** 项目金额 */
    private String itemPrice;
	//@ApiModelProperty(value="病人类型：0-门诊、1-住院、2-体检 ")
    /** 病人类型：0-门诊、1-住院、2-体检  */
    private String patType;
	//@ApiModelProperty(value="审核医生姓名")
    /** 审核医生姓名 */
    private String auditor;
	//@ApiModelProperty(value="审核时间YYYY-MM-DD HH24:MI:SS")
    /** 审核时间YYYY-MM-DD HH24:MI:SS */
    private String audittime;
	//@ApiModelProperty(value="结果提示（偏低L、偏高H等提示）")
    /** 结果提示（偏低L、偏高H等提示） */
    private String itemReompt;
	//@ApiModelProperty(value="操作员")
    /** 操作员 */
    private String labDoctor;
	//@ApiModelProperty(value="项目序号")
    /** 项目序号 */
    private String itemNo;
	//@ApiModelProperty(value="报告项目序号")
    /** 报告项目序号 */
    private String reportItemId;
	//@ApiModelProperty(value="报告项目名称")
    /** 报告项目名称 */
    private String reportItemName;
	//@ApiModelProperty(value="报告项目代码")
    /** 报告项目代码 */
    private String reportItemCode;
	//@ApiModelProperty(value="结果")
    /** 结果 */
    private String result;
	//@ApiModelProperty(value="结果单位")
    /** 结果单位 */
    private String units;
	//@ApiModelProperty(value="异常标识 1-异常")
    /** 异常标识 1-异常 */
    private String abnormalIndicator;
	//@ApiModelProperty(value="报告日期时间 yyyy-mm-dd hh24:mi:ss")
    /** 报告日期时间 yyyy-mm-dd hh24:mi:ss */
    private String resultDateTime;
	//@ApiModelProperty(value="正常参考值范围")
    /** 正常参考值范围 */
    private String textRange;
	//@ApiModelProperty(value="病原菌代码")
    /** 病原菌代码 */
    private String itemCode;
	//@ApiModelProperty(value="病原菌名称")
    /** 病原菌名称 */
    private String itemName;
	//@ApiModelProperty(value="标本号")
    /** 标本号 */
    private String sampleNo;
	//@ApiModelProperty(value="备注")
    /** 备注 */
    private String remark;
	//@ApiModelProperty(value="检验报告号")
    /** 检验报告号 */
    private String reportNo;
	//@ApiModelProperty(value="危急值标识 1-危急值")
    /** 危急值标识 1-危急值 */
    private String danger;
	//@ApiModelProperty(value="标本类型")
    /** 标本类型 */
    private String specimenType;
	//@ApiModelProperty(value="检查状态 1：未收费、2：已收费、3：已提交、4：已预约、5：已抽血（检验）、6：已检查、7：完成")
    /** 检查状态 1：未收费、2：已收费、3：已提交、4：已预约、5：已抽血（检验）、6：已检查、7：完成 */
    private String examineType;
	//@ApiModelProperty(value="就诊流水号")
    /** 就诊流水号 */
    private String jzlsh;

    /** 条码号 */
    private String barcode;

    /** 就诊卡号或者住院号 */
    private String jzkh;


    /** 采集日期 */
    private String samplingDate;

    /** 采集医院接收日期 */
    private String receiptDate;

    /** 执行医院接收日期 */
    private String receiptDate1;

    /** 检验时间 */
    private String testDate;

    /** 检验人姓名 */
    private String testDoctor;

    /** 报告类型(0，普通结果，1，微生物结果) */
    private String reportType;

    /** 细菌结果 */
    private String germResult;

    /** 细菌结果类型 */
    private String germResultType;

    /** 细菌项目id */
    private String antiGermCode;

    /** 细菌项目名称 */
    private String antiGermName;

    /** 药敏项目id */
    private String antiCode;

    /** 药敏项目名称 */
    private String antiName;

    /** 药敏结果 */
    private String antiResult;

    /** R耐药/S敏感/I中敏 */
    private String antiResult1;

    /** 撤销标记 1-撤销 0-正常 */
    private Boolean cancel;

    /**
     * 机构
     */
    private String jgid;

    /**
     * 报告单类别编码
     */
    private String bgdlbbm;

    /**
     * 报告单类别名称
     */
    private String bgdlb;

    /** 设置:主键  */
    public void setId(Integer value) {
        this.id = value;
    }
    /** 获取:主键 */
    public Integer getId() {
        return id;
    }

    /** 设置:申请单号，体检患者对应体检流水号  */
    public void setReqNo(String value) {
        this.reqNo = value;
    }
    /** 获取:申请单号，体检患者对应体检流水号 */
    public String getReqNo() {
        return reqNo;
    }

    public String getReqDoctor() {
        return reqDoctor;
    }

    public void setReqDoctor(String reqDoctor) {
        this.reqDoctor = reqDoctor;
    }

    /** 设置:病人ID  */
    public void setBrId(String value) {
        this.brId = value;
    }
    /** 获取:病人ID */
    public String getBrId() {
        return brId;
    }

    /** 设置:申请日期  */
    public void setReqData(String value) {
        this.reqData = value;
    }
    /** 获取:申请日期 */
    public String getReqData() {
        return reqData;
    }

    /** 设置:项目金额  */
    public void setItemPrice(String value) {
        this.itemPrice = value;
    }
    /** 获取:项目金额 */
    public String getItemPrice() {
        return itemPrice;
    }

    /** 设置:病人类型：0-门诊、1-住院、2-体检   */
    public void setPatType(String value) {
        this.patType = value;
    }
    /** 获取:病人类型：0-门诊、1-住院、2-体检  */
    public String getPatType() {
        return patType;
    }

    /** 设置:审核医生姓名  */
    public void setAuditor(String value) {
        this.auditor = value;
    }
    /** 获取:审核医生姓名 */
    public String getAuditor() {
        return auditor;
    }

    /** 设置:审核时间YYYY-MM-DD HH24:MI:SS  */
    public void setAudittime(String value) {
        this.audittime = value;
    }
    /** 获取:审核时间YYYY-MM-DD HH24:MI:SS */
    public String getAudittime() {
        return audittime;
    }

    /** 设置:结果提示（偏低L、偏高H等提示）  */
    public void setItemReompt(String value) {
        this.itemReompt = value;
    }
    /** 获取:结果提示（偏低L、偏高H等提示） */
    public String getItemReompt() {
        return itemReompt;
    }

    /** 设置:操作员  */
    public void setLabDoctor(String value) {
        this.labDoctor = value;
    }
    /** 获取:操作员 */
    public String getLabDoctor() {
        return labDoctor;
    }

    /** 设置:项目序号  */
    public void setItemNo(String value) {
        this.itemNo = value;
    }
    /** 获取:项目序号 */
    public String getItemNo() {
        return itemNo;
    }

    /** 设置:报告项目序号  */
    public void setReportItemId(String value) {
        this.reportItemId = value;
    }
    /** 获取:报告项目序号 */
    public String getReportItemId() {
        return reportItemId;
    }

    /** 设置:报告项目名称  */
    public void setReportItemName(String value) {
        this.reportItemName = value;
    }
    /** 获取:报告项目名称 */
    public String getReportItemName() {
        return reportItemName;
    }

    /** 设置:报告项目代码  */
    public void setReportItemCode(String value) {
        this.reportItemCode = value;
    }
    /** 获取:报告项目代码 */
    public String getReportItemCode() {
        return reportItemCode;
    }

    /** 设置:结果  */
    public void setResult(String value) {
        this.result = value;
    }
    /** 获取:结果 */
    public String getResult() {
        return result;
    }

    /** 设置:结果单位  */
    public void setUnits(String value) {
        this.units = value;
    }
    /** 获取:结果单位 */
    public String getUnits() {
        return units;
    }

    /** 设置:异常标识 1-异常  */
    public void setAbnormalIndicator(String value) {
        this.abnormalIndicator = value;
    }
    /** 获取:异常标识 1-异常 */
    public String getAbnormalIndicator() {
        return abnormalIndicator;
    }

    /** 设置:报告日期时间 yyyy-mm-dd hh24:mi:ss  */
    public void setResultDateTime(String value) {
        this.resultDateTime = value;
    }
    /** 获取:报告日期时间 yyyy-mm-dd hh24:mi:ss */
    public String getResultDateTime() {
        return resultDateTime;
    }

    /** 设置:正常参考值范围  */
    public void setTextRange(String value) {
        this.textRange = value;
    }
    /** 获取:正常参考值范围 */
    public String getTextRange() {
        return textRange;
    }

    /** 设置:病原菌代码  */
    public void setItemCode(String value) {
        this.itemCode = value;
    }
    /** 获取:病原菌代码 */
    public String getItemCode() {
        return itemCode;
    }

    /** 设置:病原菌名称  */
    public void setItemName(String value) {
        this.itemName = value;
    }
    /** 获取:病原菌名称 */
    public String getItemName() {
        return itemName;
    }

    /** 设置:标本号  */
    public void setSampleNo(String value) {
        this.sampleNo = value;
    }
    /** 获取:标本号 */
    public String getSampleNo() {
        return sampleNo;
    }

    /** 设置:备注  */
    public void setRemark(String value) {
        this.remark = value;
    }
    /** 获取:备注 */
    public String getRemark() {
        return remark;
    }

    /** 设置:检验报告号  */
    public void setReportNo(String value) {
        this.reportNo = value;
    }
    /** 获取:检验报告号 */
    public String getReportNo() {
        return reportNo;
    }

    /** 设置:危急值标识 1-危急值  */
    public void setDanger(String value) {
        this.danger = value;
    }
    /** 获取:危急值标识 1-危急值 */
    public String getDanger() {
        return danger;
    }

    /** 设置:标本类型  */
    public void setSpecimenType(String value) {
        this.specimenType = value;
    }
    /** 获取:标本类型 */
    public String getSpecimenType() {
        return specimenType;
    }

    /** 设置:检查状态 1：未收费、2：已收费、3：已提交、4：已预约、5：已抽血（检验）、6：已检查、7：完成  */
    public void setExamineType(String value) {
        this.examineType = value;
    }
    /** 获取:检查状态 1：未收费、2：已收费、3：已提交、4：已预约、5：已抽血（检验）、6：已检查、7：完成 */
    public String getExamineType() {
        return examineType;
    }

    /** 设置:就诊流水号  */
    public void setJzlsh(String value) {
        this.jzlsh = value;
    }
    /** 获取:就诊流水号 */
    public String getJzlsh() {
        return jzlsh;
    }


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public String getSamplingDate() {
        return samplingDate;
    }

    public void setSamplingDate(String samplingDate) {
        this.samplingDate = samplingDate;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getReceiptDate1() {
        return receiptDate1;
    }

    public void setReceiptDate1(String receiptDate1) {
        this.receiptDate1 = receiptDate1;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getTestDoctor() {
        return testDoctor;
    }

    public void setTestDoctor(String testDoctor) {
        this.testDoctor = testDoctor;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getGermResult() {
        return germResult;
    }

    public void setGermResult(String germResult) {
        this.germResult = germResult;
    }

    public String getGermResultType() {
        return germResultType;
    }

    public void setGermResultType(String germResultType) {
        this.germResultType = germResultType;
    }

    public String getAntiGermCode() {
        return antiGermCode;
    }

    public void setAntiGermCode(String antiGermCode) {
        this.antiGermCode = antiGermCode;
    }

    public String getAntiGermName() {
        return antiGermName;
    }

    public void setAntiGermName(String antiGermName) {
        this.antiGermName = antiGermName;
    }

    public String getAntiCode() {
        return antiCode;
    }

    public void setAntiCode(String antiCode) {
        this.antiCode = antiCode;
    }

    public String getAntiName() {
        return antiName;
    }

    public void setAntiName(String antiName) {
        this.antiName = antiName;
    }

    public String getAntiResult() {
        return antiResult;
    }

    public void setAntiResult(String antiResult) {
        this.antiResult = antiResult;
    }

    public String getAntiResult1() {
        return antiResult1;
    }

    public void setAntiResult1(String antiResult1) {
        this.antiResult1 = antiResult1;
    }

    public Boolean getCancel() {
        return cancel;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    public String getJgid() {
        return jgid;
    }

    public void setJgid(String jgid) {
        this.jgid = jgid;
    }

    public String getBgdlbbm() {
        return bgdlbbm;
    }

    public void setBgdlbbm(String bgdlbbm) {
        this.bgdlbbm = bgdlbbm;
    }

    public String getBgdlb() {
        return bgdlb;
    }

    public void setBgdlb(String bgdlb) {
        this.bgdlb = bgdlb;
    }
}
