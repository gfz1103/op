
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpBrzd<br>
 * 类描述：门诊_病人诊断<br>
 * @author 老花生
 */
@ApiModel(value="门诊_病人诊断")
public class OpBrzdPatientResp extends PageQuery {
    @ApiModelProperty(value="记录编号")
    private Integer jlbh;
    @ApiModelProperty(value="诊断序号")
    private Integer zdxh;
    @ApiModelProperty(value="ICD10")
    private String icd10;
    @ApiModelProperty(value="诊断名称")
    private String zdmc;
    @ApiModelProperty(value="子诊断级数 | 0为第一层诊断，1为第二层诊断，以此类推")
    private Integer deep;
    @ApiModelProperty(value="主诊断标志 | 1 主诊断 0 非主诊断")
    private Integer zzbz;
    @ApiModelProperty(value="复诊标志 | 0：初诊、1：复诊")
    private Integer fzbz;
    @ApiModelProperty(value="处方类型| 1:西药处方 2：中药处方 3：草药处方")
    private Integer cflx;
    @ApiModelProperty(value="证侯名称")
    private String zhmc;
    @ApiModelProperty(value="ICD9")
    private String icd9;

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
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

    public String getZdmc() {
        return zdmc;
    }

    public void setZdmc(String zdmc) {
        this.zdmc = zdmc;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    public Integer getZzbz() {
        return zzbz;
    }

    public void setZzbz(Integer zzbz) {
        this.zzbz = zzbz;
    }

    public Integer getFzbz() {
        return fzbz;
    }

    public void setFzbz(Integer fzbz) {
        this.fzbz = fzbz;
    }

    public Integer getCflx() {
        return cflx;
    }

    public void setCflx(Integer cflx) {
        this.cflx = cflx;
    }

    public String getZhmc() {
        return zhmc;
    }

    public void setZhmc(String zhmc) {
        this.zhmc = zhmc;
    }

    public String getIcd9() {
        return icd9;
    }

    public void setIcd9(String icd9) {
        this.icd9 = icd9;
    }
}
