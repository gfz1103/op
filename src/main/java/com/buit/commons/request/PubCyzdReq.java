
package com.buit.commons.request;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：PubCyzd<br>
 * 类描述：公用_个人常用诊断表<br>
 * @author 老花生
 */
@ApiModel(value="公用_个人常用诊断表")
public class PubCyzdReq extends PageQuery {
    @ApiModelProperty(value="处方类型| 1:西药处方 2：中药处方 3：草药处方")
    private Integer cflx;
    @ApiModelProperty(value="所属类别 | 1.个人组套 2.科室组套 3.公用组套 4.个人常用药（诊断、项目）")
    private Integer sslb;
    @ApiModelProperty(value="拼音码")
    private String pydm;


    @ApiModelProperty(value="机构代码", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="员工代码 | 填科室、医生等相应代码 该字段和SSLB对照着维护", hidden = true)
    private Integer ygdm;
    @ApiModelProperty(value="序号", hidden = true)
    private Integer jlbh;
    @ApiModelProperty(value="诊断序号", hidden = true)
    private Integer zdxh;
    @ApiModelProperty(value="诊断名称", hidden = true)
    private String zdmc;
    @ApiModelProperty(value="ICD10", hidden = true)
    private String icd10;
    @ApiModelProperty(value="科室代码", hidden = true)
    private Integer ksdm;
    @ApiModelProperty(value="五笔码", hidden = true)
    private String wbdm;
    @ApiModelProperty(value="肠道门诊诊断", hidden = true)
    private Integer cdmzzd;
    /**
     * 设置:序号
     */
    public void setJlbh(Integer value) {
        this.jlbh = value;
    }
    /**
     * 获取:序号
     */
    public Integer getJlbh() {
        return jlbh;
    }
    /**
     * 设置:所属类别 | 1.个人组套 2.科室组套 3.公用组套 4.个人常用药（诊断、项目）
     */
    public void setSslb(Integer value) {
        this.sslb = value;
    }
    /**
     * 获取:所属类别 | 1.个人组套 2.科室组套 3.公用组套 4.个人常用药（诊断、项目）
     */
    public Integer getSslb() {
        return sslb;
    }
    /**
     * 设置:员工代码 | 填科室、医生等相应代码 该字段和SSLB对照着维护
     */
    public void setYgdm(Integer value) {
        this.ygdm = value;
    }
    /**
     * 获取:员工代码 | 填科室、医生等相应代码 该字段和SSLB对照着维护
     */
    public Integer getYgdm() {
        return ygdm;
    }
    /**
     * 设置:诊断序号
     */
    public void setZdxh(Integer value) {
        this.zdxh = value;
    }
    /**
     * 获取:诊断序号
     */
    public Integer getZdxh() {
        return zdxh;
    }
    /**
     * 设置:诊断名称
     */
    public void setZdmc(String value) {
        this.zdmc = value;
    }
    /**
     * 获取:诊断名称
     */
    public String getZdmc() {
        return zdmc;
    }
    /**
     * 设置:ICD10
     */
    public void setIcd10(String value) {
        this.icd10 = value;
    }
    /**
     * 获取:ICD10
     */
    public String getIcd10() {
        return icd10;
    }
    /**
     * 设置:拼音码
     */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /**
     * 获取:拼音码
     */
    public String getPydm() {
        return pydm;
    }
    /**
     * 设置:机构代码
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:机构代码
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:科室代码
     */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /**
     * 获取:科室代码
     */
    public Integer getKsdm() {
        return ksdm;
    }
    /**
     * 设置:处方类型| 1:西药处方 2：中药处方 3：草药处方
     */
    public void setCflx(Integer value) {
        this.cflx = value;
    }
    /**
     * 获取:处方类型| 1:西药处方 2：中药处方 3：草药处方
     */
    public Integer getCflx() {
        return cflx;
    }
    /**
     * 设置:五笔码
     */
    public void setWbdm(String value) {
        this.wbdm = value;
    }
    /**
     * 获取:五笔码
     */
    public String getWbdm() {
        return wbdm;
    }
    /**
     * 设置:肠道门诊诊断
     */
    public void setCdmzzd(Integer value) {
        this.cdmzzd = value;
    }
    /**
     * 获取:肠道门诊诊断
     */
    public Integer getCdmzzd() {
        return cdmzzd;
    }
}
