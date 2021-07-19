
package com.buit.commons.request;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpBrzd<br>
 * 类描述：门诊_病人诊断<br>
 * @author 老花生
 */
@ApiModel(value="门诊_病人诊断保存请求")
public class OpBrzdAddReq {

    @ApiModelProperty(value="记录编号")
    private Integer jlbh;
    @ApiModelProperty(value="病人ID")
    private Integer brid;
    @ApiModelProperty(value="机构代码")
    private Integer jgid;
    @ApiModelProperty(value="就诊序号 | 每次就诊的唯一号")
    private Integer jzxh;
    @ApiModelProperty(value="子诊断级数 | 0为第一层诊断，1为第二层诊断，以此类推")
    private Integer deep;
    @ApiModelProperty(value="上级诊断标志 | 没有填0")
    private Integer sjzd;
    @ApiModelProperty(value="诊断名称")
    private String zdmc;
    @ApiModelProperty(value="主诊断标志 | 1 主诊断 0 非主诊断")
    private Integer zzbz;
    @ApiModelProperty(value="诊断序号")
    private Integer zdxh;
    @ApiModelProperty(value="排列序号")
    private Integer plxh;
    @ApiModelProperty(value="ICD10")
    private String icd10;
    @ApiModelProperty(value="诊断部位 | 部位”在字典参数中维护，如”左侧、右侧、双侧”等")
    private Integer zdbw;
    @ApiModelProperty(value="诊断医生 | 默认当前操作者，不可修改")
    private String zdys;
    @ApiModelProperty(value="诊断时间")
    private Timestamp zdsj;
    @ApiModelProperty(value="诊断类别 | 1 门诊诊断 2....    诊断类别 默认门急诊诊断，不可修改")
    private Integer zdlb;
    @ApiModelProperty(value="处方类型| 1:西药处方 2：中药处方 3：草药处方")
    private Integer cflx;
    @ApiModelProperty(value="转归情况 | 1 治愈、2 好转、3 未愈、 4 未治、5 死亡")
    private Integer zgqk;
    @ApiModelProperty(value="转归时间")
    private Timestamp zgsj;
    @ApiModelProperty(value="复诊标志 | 0：初诊、1：复诊")
    private Integer fzbz;
    @ApiModelProperty(value="发病日期")
    private Timestamp fbrq;
    @ApiModelProperty(value="疾病判别")
    private String jbpb;
    @ApiModelProperty(value="附属诊断标志 | 是否包含附属诊断 1 包含 0 不包含 ；包含的话 至少需要维护一个附属诊断")
    private Integer ffbz;
    @ApiModelProperty(value="病理诊断标志 | 1 是 0 否 默认 0 ")
    private Integer blzd;

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    public Integer getSjzd() {
        return sjzd;
    }

    public void setSjzd(Integer sjzd) {
        this.sjzd = sjzd;
    }

    public String getZdmc() {
        return zdmc;
    }

    public void setZdmc(String zdmc) {
        this.zdmc = zdmc;
    }

    public Integer getZzbz() {
        return zzbz;
    }

    public void setZzbz(Integer zzbz) {
        this.zzbz = zzbz;
    }

    public Integer getZdxh() {
        return zdxh;
    }

    public void setZdxh(Integer zdxh) {
        this.zdxh = zdxh;
    }

    public Integer getPlxh() {
        return plxh;
    }

    public void setPlxh(Integer plxh) {
        this.plxh = plxh;
    }

    public String getIcd10() {
        return icd10;
    }

    public void setIcd10(String icd10) {
        this.icd10 = icd10;
    }

    public Integer getZdbw() {
        return zdbw;
    }

    public void setZdbw(Integer zdbw) {
        this.zdbw = zdbw;
    }

    public String getZdys() {
        return zdys;
    }

    public void setZdys(String zdys) {
        this.zdys = zdys;
    }

    public Timestamp getZdsj() {
        return zdsj;
    }

    public void setZdsj(Timestamp zdsj) {
        this.zdsj = zdsj;
    }

    public Integer getZdlb() {
        return zdlb;
    }

    public void setZdlb(Integer zdlb) {
        this.zdlb = zdlb;
    }

    public Integer getCflx() {
        return cflx;
    }

    public void setCflx(Integer cflx) {
        this.cflx = cflx;
    }

    public Integer getZgqk() {
        return zgqk;
    }

    public void setZgqk(Integer zgqk) {
        this.zgqk = zgqk;
    }

    public Timestamp getZgsj() {
        return zgsj;
    }

    public void setZgsj(Timestamp zgsj) {
        this.zgsj = zgsj;
    }

    public Integer getFzbz() {
        return fzbz;
    }

    public void setFzbz(Integer fzbz) {
        this.fzbz = fzbz;
    }

    public Timestamp getFbrq() {
        return fbrq;
    }

    public void setFbrq(Timestamp fbrq) {
        this.fbrq = fbrq;
    }

    public String getJbpb() {
        return jbpb;
    }

    public void setJbpb(String jbpb) {
        this.jbpb = jbpb;
    }

    public Integer getFfbz() {
        return ffbz;
    }

    public void setFfbz(Integer ffbz) {
        this.ffbz = ffbz;
    }

    public Integer getBlzd() {
        return blzd;
    }

    public void setBlzd(Integer blzd) {
        this.blzd = blzd;
    }
}
