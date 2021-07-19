
package com.buit.commons.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：PubCyzd<br>
 * 类描述：公用_个人常用诊断表<br>
 * @author 老花生
 */
@ApiModel(value="公用_个人常用诊断表")

public class PubCyzdResp {
    @ApiModelProperty(value="序号")
    private Integer jlbh;
    @NotNull(message = "所属类别 不能为空")
    @ApiModelProperty(value="所属类别 | 1.个人组套 2.科室组套 3.公用组套 4.个人常用药（诊断、项目）")
    private Integer sslb;
    @NotBlank(message = "诊断名称 不能为空")
    @ApiModelProperty(value="诊断名称")
    private String zdmc;
    @NotNull(message = "诊断序号 不能为空")
    @ApiModelProperty(value="诊断序号")
    private Integer zdxh;
    @NotBlank(message = "ICD10 不能为空")
    @ApiModelProperty(value="ICD10")
    private String icd10;
    @NotNull(message = "处方类型 不能为空")
    @ApiModelProperty(value="处方类型| 1:西药处方 2：中药处方 3：草药处方")
    private Integer cflx;
    @ApiModelProperty(value="肠道门诊诊断")
    private Integer cdmzzd;
    @ApiModelProperty(value="疾病报告卡")
    private String jbbgk;

    public Integer getSslb() {
        return sslb;
    }

    public void setSslb(Integer sslb) {
        this.sslb = sslb;
    }

    public String getZdmc() {
        return zdmc;
    }

    public void setZdmc(String zdmc) {
        this.zdmc = zdmc;
    }

    public Integer getZdxh() {
        return zdxh;
    }

    public void setZdxh(Integer zdxh) {
        this.zdxh = zdxh;
    }

    public String getIcd10() {
        return icd10;
    }

    public void setIcd10(String icd10) {
        this.icd10 = icd10;
    }

    public Integer getCflx() {
        return cflx;
    }

    public void setCflx(Integer cflx) {
        this.cflx = cflx;
    }

    public Integer getCdmzzd() {
        return cdmzzd;
    }

    public void setCdmzzd(Integer cdmzzd) {
        this.cdmzzd = cdmzzd;
    }

    public String getJbbgk() {
        return jbbgk;
    }

    public void setJbbgk(String jbbgk) {
        this.jbbgk = jbbgk;
    }

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
    }
}
