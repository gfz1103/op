
package com.buit.commons.response;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpBrzd<br>
 * 类描述：门诊_病人诊断<br>
 * @author 老花生
 */
@ApiModel(value="门诊_病人诊断-查询列表返回")
public class OpBrzdResp extends PageQuery {
    @ApiModelProperty(value="疾病报告卡")
    private String jbbgk;
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
    @ApiModelProperty(value="转归情况 | 1 治愈、2 好转、3 未愈、 4 未治、5 死亡")
    private Integer zgqk;
    @ApiModelProperty(value="转归时间")
    private Timestamp zgsj;
    @ApiModelProperty(value="复诊标志 | 0：初诊、1：复诊")
    private Integer fzbz;
    @ApiModelProperty(value="发病日期")
    private Timestamp fbrq;
    @ApiModelProperty(value="证侯名称")
    private String zhmc;
    @ApiModelProperty(value="处方类型| 1:西药处方 2：中药处方 3：草药处方")
    private Integer cflx;
    @ApiModelProperty(value="疾病判别")
    private String jbpb;
    @ApiModelProperty(value="附属诊断标志 | 是否包含附属诊断 1 包含 0 不包含 ；包含的话 至少需要维护一个附属诊断")
    private Integer ffbz;
    @ApiModelProperty(value="病理诊断标志 | 1 是 0 否 默认 0 ")
    private Integer blzd;

    /**
     * 设置:记录编号
     */
    public void setJlbh(Integer value) {
        this.jlbh = value;
    }
    /**
     * 获取:记录编号
     */
    public Integer getJlbh() {
        return jlbh;
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
     * 设置:就诊序号 | 每次就诊的唯一号
     */
    public void setJzxh(Integer value) {
        this.jzxh = value;
    }
    /**
     * 获取:就诊序号 | 每次就诊的唯一号
     */
    public Integer getJzxh() {
        return jzxh;
    }
    /**
     * 设置:病人ID
     */
    public void setBrid(Integer value) {
        this.brid = value;
    }
    /**
     * 获取:病人ID
     */
    public Integer getBrid() {
        return brid;
    }
    /**
     * 设置:诊断类别 | 1 门诊诊断 2....    诊断类别 默认门急诊诊断，不可修改
     */
    public void setZdlb(Integer value) {
        this.zdlb = value;
    }
    /**
     * 获取:诊断类别 | 1 门诊诊断 2....    诊断类别 默认门急诊诊断，不可修改
     */
    public Integer getZdlb() {
        return zdlb;
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
     * 设置:排列序号
     */
    public void setPlxh(Integer value) {
        this.plxh = value;
    }
    /**
     * 获取:排列序号
     */
    public Integer getPlxh() {
        return plxh;
    }
    /**
     * 设置:诊断部位 | 部位”在字典参数中维护，如”左侧、右侧、双侧”等
     */
    public void setZdbw(Integer value) {
        this.zdbw = value;
    }
    /**
     * 获取:诊断部位 | 部位”在字典参数中维护，如”左侧、右侧、双侧”等
     */
    public Integer getZdbw() {
        return zdbw;
    }
    /**
     * 设置:诊断医生 | 默认当前操作者，不可修改
     */
    public void setZdys(String value) {
        this.zdys = value;
    }
    /**
     * 获取:诊断医生 | 默认当前操作者，不可修改
     */
    public String getZdys() {
        return zdys;
    }
    /**
     * 设置:诊断时间
     */
    public void setZdsj(Timestamp value) {
        this.zdsj = value;
    }
    /**
     * 获取:诊断时间
     */
    public Timestamp getZdsj() {
        return zdsj;
    }
    /**
     * 设置:转归情况 | 1 治愈、2 好转、3 未愈、 4 未治、5 死亡
     */
    public void setZgqk(Integer value) {
        this.zgqk = value;
    }
    /**
     * 获取:转归情况 | 1 治愈、2 好转、3 未愈、 4 未治、5 死亡
     */
    public Integer getZgqk() {
        return zgqk;
    }
    /**
     * 设置:转归时间
     */
    public void setZgsj(Timestamp value) {
        this.zgsj = value;
    }
    /**
     * 获取:转归时间
     */
    public Timestamp getZgsj() {
        return zgsj;
    }
    /**
     * 设置:主诊断标志 | 1 主诊断 0 非主诊断
     */
    public void setZzbz(Integer value) {
        this.zzbz = value;
    }
    /**
     * 获取:主诊断标志 | 1 主诊断 0 非主诊断
     */
    public Integer getZzbz() {
        return zzbz;
    }
    /**
     * 设置:上级诊断标志 | 没有填0
     */
    public void setSjzd(Integer value) {
        this.sjzd = value;
    }
    /**
     * 获取:上级诊断标志 | 没有填0
     */
    public Integer getSjzd() {
        return sjzd;
    }
    /**
     * 设置:子诊断级数 | 0为第一层诊断，1为第二层诊断，以此类推
     */
    public void setDeep(Integer value) {
        this.deep = value;
    }
    /**
     * 获取:子诊断级数 | 0为第一层诊断，1为第二层诊断，以此类推
     */
    public Integer getDeep() {
        return deep;
    }
    /**
     * 设置:复诊标志 | 0：初诊、1：复诊
     */
    public void setFzbz(Integer value) {
        this.fzbz = value;
    }
    /**
     * 获取:复诊标志 | 0：初诊、1：复诊
     */
    public Integer getFzbz() {
        return fzbz;
    }
    /**
     * 设置:发病日期
     */
    public void setFbrq(Timestamp value) {
        this.fbrq = value;
    }
    /**
     * 获取:发病日期
     */
    public Timestamp getFbrq() {
        return fbrq;
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
     * 设置:疾病判别
     */
    public void setJbpb(String value) {
        this.jbpb = value;
    }
    /**
     * 获取:疾病判别
     */
    public String getJbpb() {
        return jbpb;
    }

    public String getJbbgk() {
        return jbbgk;
    }

    public void setJbbgk(String jbbgk) {
        this.jbbgk = jbbgk;
    }

    public String getZhmc() {
        return zhmc;
    }

    public void setZhmc(String zhmc) {
        this.zhmc = zhmc;
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
