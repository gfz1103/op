
package com.buit.commons.request;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：ApiLisReport<br>
 * 类描述：接口检验<br>
 * @author 老花生
 */
@ApiModel(value="接口检验")
public class ApiLisReportReq  extends  PageQuery{
    @ApiModelProperty(value="主键", hidden = true)
    private Integer id;
    @ApiModelProperty(value="申请单号")
    private String reqNo;
    @ApiModelProperty(value="病人ID", hidden = true)
    private String brId;
    @ApiModelProperty(value="申请日期", hidden = true)
    private String reqData;
    @ApiModelProperty(value="项目金额", hidden = true)
    private String itemPrice;
    @ApiModelProperty(value="病人类型：0-门诊、1-住院、2-体检 ")
    private String patType;
    @ApiModelProperty(value="审核医生姓名", hidden = true)
    private String auditor;
    @ApiModelProperty(value="审核时间YYYY-MM-DD HH24:MI:SS", hidden = true)
    private String audittime;
    @ApiModelProperty(value="结果提示（偏低L、偏高H等提示）", hidden = true)
    private String itemReompt;
    @ApiModelProperty(value="操作员", hidden = true)
    private String labDoctor;
    @ApiModelProperty(value="项目序号", hidden = true)
    private String itemNo;
    @ApiModelProperty(value="报告项目序号", hidden = true)
    private String reportItemId;
    @ApiModelProperty(value="报告项目名称", hidden = true)
    private String reportItemName;
    @ApiModelProperty(value="报告项目代码", hidden = true)
    private String reportItemCode;
    @ApiModelProperty(value="结果", hidden = true)
    private String result;
    @ApiModelProperty(value="结果单位", hidden = true)
    private String units;
    @ApiModelProperty(value="异常标识 1-异常", hidden = true)
    private String abnormalIndicator;
    @ApiModelProperty(value="报告日期时间 yyyy-mm-dd hh24:mi:ss", hidden = true)
    private String resultDateTime;
    @ApiModelProperty(value="正常参考值范围", hidden = true)
    private String textRange;
    @ApiModelProperty(value="病原菌代码", hidden = true)
    private String itemCode;
    @ApiModelProperty(value="病原菌名称", hidden = true)
    private String itemName;
    @ApiModelProperty(value="标本号", hidden = true)
    private String sampleNo;
    @ApiModelProperty(value="备注", hidden = true)
    private String remark;
    @ApiModelProperty(value="检验报告号", hidden = true)
    private String reportNo;
    @ApiModelProperty(value="危急值标识 1-危急值", hidden = true)
    private String danger;
    @ApiModelProperty(value="标本类型", hidden = true)
    private String specimenType;
    @ApiModelProperty(value="检查状态 1：未收费、2：已收费、3：已提交、4：已预约、5：已抽血（检验）、6：已检查、7：完成", hidden = true)
    private String examineType;
    @ApiModelProperty(value="就诊流水号", hidden = true)
    private String jzlsh;
    /**
     * 设置:主键
     */
    public void setId(Integer value) {
        this.id = value;
    }
    /**
     * 获取:主键
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置:申请单号，体检患者对应体检流水号
     */
    public void setReqNo(String value) {
        this.reqNo = value;
    }
    /**
     * 获取:申请单号，体检患者对应体检流水号
     */
    public String getReqNo() {
        return reqNo;
    }
    /**
     * 设置:病人ID
     */
    public void setBrId(String value) {
        this.brId = value;
    }
    /**
     * 获取:病人ID
     */
    public String getBrId() {
        return brId;
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
     * 设置:项目金额
     */
    public void setItemPrice(String value) {
        this.itemPrice = value;
    }
    /**
     * 获取:项目金额
     */
    public String getItemPrice() {
        return itemPrice;
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
     * 设置:审核时间YYYY-MM-DD HH24:MI:SS
     */
    public void setAudittime(String value) {
        this.audittime = value;
    }
    /**
     * 获取:审核时间YYYY-MM-DD HH24:MI:SS
     */
    public String getAudittime() {
        return audittime;
    }
    /**
     * 设置:结果提示（偏低L、偏高H等提示）
     */
    public void setItemReompt(String value) {
        this.itemReompt = value;
    }
    /**
     * 获取:结果提示（偏低L、偏高H等提示）
     */
    public String getItemReompt() {
        return itemReompt;
    }
    /**
     * 设置:操作员
     */
    public void setLabDoctor(String value) {
        this.labDoctor = value;
    }
    /**
     * 获取:操作员
     */
    public String getLabDoctor() {
        return labDoctor;
    }
    /**
     * 设置:项目序号
     */
    public void setItemNo(String value) {
        this.itemNo = value;
    }
    /**
     * 获取:项目序号
     */
    public String getItemNo() {
        return itemNo;
    }
    /**
     * 设置:报告项目序号
     */
    public void setReportItemId(String value) {
        this.reportItemId = value;
    }
    /**
     * 获取:报告项目序号
     */
    public String getReportItemId() {
        return reportItemId;
    }
    /**
     * 设置:报告项目名称
     */
    public void setReportItemName(String value) {
        this.reportItemName = value;
    }
    /**
     * 获取:报告项目名称
     */
    public String getReportItemName() {
        return reportItemName;
    }
    /**
     * 设置:报告项目代码
     */
    public void setReportItemCode(String value) {
        this.reportItemCode = value;
    }
    /**
     * 获取:报告项目代码
     */
    public String getReportItemCode() {
        return reportItemCode;
    }
    /**
     * 设置:结果
     */
    public void setResult(String value) {
        this.result = value;
    }
    /**
     * 获取:结果
     */
    public String getResult() {
        return result;
    }
    /**
     * 设置:结果单位
     */
    public void setUnits(String value) {
        this.units = value;
    }
    /**
     * 获取:结果单位
     */
    public String getUnits() {
        return units;
    }
    /**
     * 设置:异常标识 1-异常
     */
    public void setAbnormalIndicator(String value) {
        this.abnormalIndicator = value;
    }
    /**
     * 获取:异常标识 1-异常
     */
    public String getAbnormalIndicator() {
        return abnormalIndicator;
    }
    /**
     * 设置:报告日期时间 yyyy-mm-dd hh24:mi:ss
     */
    public void setResultDateTime(String value) {
        this.resultDateTime = value;
    }
    /**
     * 获取:报告日期时间 yyyy-mm-dd hh24:mi:ss
     */
    public String getResultDateTime() {
        return resultDateTime;
    }
    /**
     * 设置:正常参考值范围
     */
    public void setTextRange(String value) {
        this.textRange = value;
    }
    /**
     * 获取:正常参考值范围
     */
    public String getTextRange() {
        return textRange;
    }
    /**
     * 设置:病原菌代码
     */
    public void setItemCode(String value) {
        this.itemCode = value;
    }
    /**
     * 获取:病原菌代码
     */
    public String getItemCode() {
        return itemCode;
    }
    /**
     * 设置:病原菌名称
     */
    public void setItemName(String value) {
        this.itemName = value;
    }
    /**
     * 获取:病原菌名称
     */
    public String getItemName() {
        return itemName;
    }
    /**
     * 设置:标本号
     */
    public void setSampleNo(String value) {
        this.sampleNo = value;
    }
    /**
     * 获取:标本号
     */
    public String getSampleNo() {
        return sampleNo;
    }
    /**
     * 设置:备注
     */
    public void setRemark(String value) {
        this.remark = value;
    }
    /**
     * 获取:备注
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 设置:检验报告号
     */
    public void setReportNo(String value) {
        this.reportNo = value;
    }
    /**
     * 获取:检验报告号
     */
    public String getReportNo() {
        return reportNo;
    }
    /**
     * 设置:危急值标识 1-危急值
     */
    public void setDanger(String value) {
        this.danger = value;
    }
    /**
     * 获取:危急值标识 1-危急值
     */
    public String getDanger() {
        return danger;
    }
    /**
     * 设置:标本类型
     */
    public void setSpecimenType(String value) {
        this.specimenType = value;
    }
    /**
     * 获取:标本类型
     */
    public String getSpecimenType() {
        return specimenType;
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
