
package com.buit.cis.op.dctwork.request;

import com.buit.commons.request.JySqdReqJyzt;
import com.buit.commons.request.JySqdReqXmDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * 类名称：JySqdReq<br>
 * 类描述：保存检验申请单-请求<br>
 * @author 老花生
 */
@ApiModel(value="保存检验申请单-请求")
public class JySqdReq {
    @ApiModelProperty(value="就诊序号")
    @NotNull(message = "就诊序号不能为空")
    private Integer clinicId;

    @ApiModelProperty(value="病人ID")
    @NotNull(message = "病人ID不能为空")
    private Integer brid;

    @ApiModelProperty(value="病人姓名")
    @NotBlank(message = "病人姓名不能为空")
    private String brxm;

    @ApiModelProperty(value="单据来源")
    private Integer djly;

    @ApiModelProperty(value="门诊号码(挂号关联)")
    private Integer ghgl;

    @ApiModelProperty(value="病人性质")
    private Integer brxz;

    @ApiModelProperty(value="病人科室")
    @NotNull(message = "病人科室不能为空")
    private Integer brks;

    @ApiModelProperty(value="病人科室名称")
    private String brksText;

    @ApiModelProperty(value="就诊卡号")
    @NotBlank(message = "就诊卡号不能为空")
    private String jzkh;

    @ApiModelProperty(value="申请类型")
    private Integer sqlx;

    @ApiModelProperty(value="组套集合")
    private List<JySqdReqJyzt> jyzts;

    @ApiModelProperty(value="项目费用集合")
    private List<JySqdReqXmDetail> xmDetails;

    @ApiModelProperty(value="就诊流水号")
    @NotBlank(message = "就诊流水号不能为空")
    private String jzlsh;

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Integer getDjly() {
        return djly;
    }

    public void setDjly(Integer djly) {
        this.djly = djly;
    }

    public Integer getGhgl() {
        return ghgl;
    }

    public void setGhgl(Integer ghgl) {
        this.ghgl = ghgl;
    }

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }

    public Integer getBrks() {
        return brks;
    }

    public void setBrks(Integer brks) {
        this.brks = brks;
    }

    public String getBrksText() {
        return brksText;
    }

    public void setBrksText(String brksText) {
        this.brksText = brksText;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public Integer getSqlx() {
        return sqlx;
    }

    public void setSqlx(Integer sqlx) {
        this.sqlx = sqlx;
    }

    public List<JySqdReqJyzt> getJyzts() {
        return jyzts;
    }

    public void setJyzts(List<JySqdReqJyzt> jyzts) {
        this.jyzts = jyzts;
    }

    public List<JySqdReqXmDetail> getXmDetails() {
        return xmDetails;
    }

    public void setXmDetails(List<JySqdReqXmDetail> xmDetails) {
        this.xmDetails = xmDetails;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }
}
