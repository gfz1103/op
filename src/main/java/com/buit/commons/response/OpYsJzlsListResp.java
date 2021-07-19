
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpYsJzls<br>
 * 类描述：门诊_就诊历史<br>
 * @author 老花生
 */
@ApiModel(value="门诊_就诊历史-就诊记录查询")
public class OpYsJzlsListResp extends  PageQuery{
    @ApiModelProperty(value="就诊序号")
    private Integer jzxh;
    @ApiModelProperty(value="挂号序号")
    private Integer ghxh;
    @ApiModelProperty(value="病人编号")
    private Integer brbh;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="医生代码")
    private String ysdm;
    @ApiModelProperty(value="主要诊断")
    private String zyzd;
    @ApiModelProperty(value="开始时间")
    private Timestamp kssj;
    @ApiModelProperty(value="结束时间")
    private Timestamp jssj;
    @ApiModelProperty(value="就诊状态 | 1.就诊中 2.挂起 9.结束就诊")
    private Integer jzzt;
    @ApiModelProperty(value="复诊预约序号")
    private Integer yyxh;
    @ApiModelProperty(value="复诊日期")
    private Timestamp fzrq;
    @ApiModelProperty(value="挂号复诊")
    private Integer ghfz;
    @ApiModelProperty(value="机构代码")
    private String jgid;
    @ApiModelProperty(value="sfdy")
    private BigDecimal sfdy;
    @ApiModelProperty(value="sfjk")
    private BigDecimal sfjk;
    @ApiModelProperty(value="scbz")
    private String scbz;
    @ApiModelProperty(value="诊断名称")
    private String zdmc;
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;
    @ApiModelProperty(value="病人性质")
    private String brxz;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="就诊号码")
    private String jzhm;
    @ApiModelProperty(value="就诊卡号")
    private String jzkh;

    @ApiModelProperty(value="病人性别")
    private String brxb;
    @ApiModelProperty(value="出生日期")
    private String csny;
    @ApiModelProperty(value="门诊号码")
    private String mzhm;
    @ApiModelProperty(value="记录册号")
    private String jlch;
    @ApiModelProperty(value="身份证号")
    private String sfzh;
    /**
     * 设置:就诊序号
     */
    public void setJzxh(Integer value) {
        this.jzxh = value;
    }
    /**
     * 获取:就诊序号
     */
    public Integer getJzxh() {
        return jzxh;
    }
    /**
     * 设置:挂号序号
     */
    public void setGhxh(Integer value) {
        this.ghxh = value;
    }
    /**
     * 获取:挂号序号
     */
    public Integer getGhxh() {
        return ghxh;
    }
    /**
     * 设置:病人编号
     */
    public void setBrbh(Integer value) {
        this.brbh = value;
    }
    /**
     * 获取:病人编号
     */
    public Integer getBrbh() {
        return brbh;
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
     * 设置:医生代码
     */
    public void setYsdm(String value) {
        this.ysdm = value;
    }
    /**
     * 获取:医生代码
     */
    public String getYsdm() {
        return ysdm;
    }
    /**
     * 设置:主要诊断
     */
    public void setZyzd(String value) {
        this.zyzd = value;
    }
    /**
     * 获取:主要诊断
     */
    public String getZyzd() {
        return zyzd;
    }
    /**
     * 设置:开始时间
     */
    public void setKssj(Timestamp value) {
        this.kssj = value;
    }
    /**
     * 获取:开始时间
     */
    public Timestamp getKssj() {
        return kssj;
    }
    /**
     * 设置:结束时间
     */
    public void setJssj(Timestamp value) {
        this.jssj = value;
    }
    /**
     * 获取:结束时间
     */
    public Timestamp getJssj() {
        return jssj;
    }
    /**
     * 设置:就诊状态 | 1.就诊中 2.挂起 9.结束就诊
     */
    public void setJzzt(Integer value) {
        this.jzzt = value;
    }
    /**
     * 获取:就诊状态 | 1.就诊中 2.挂起 9.结束就诊
     */
    public Integer getJzzt() {
        return jzzt;
    }
    /**
     * 设置:复诊预约序号
     */
    public void setYyxh(Integer value) {
        this.yyxh = value;
    }
    /**
     * 获取:复诊预约序号
     */
    public Integer getYyxh() {
        return yyxh;
    }
    /**
     * 设置:复诊日期
     */
    public void setFzrq(Timestamp value) {
        this.fzrq = value;
    }
    /**
     * 获取:复诊日期
     */
    public Timestamp getFzrq() {
        return fzrq;
    }
    /**
     * 设置:挂号复诊
     */
    public void setGhfz(Integer value) {
        this.ghfz = value;
    }
    /**
     * 获取:挂号复诊
     */
    public Integer getGhfz() {
        return ghfz;
    }
    /**
     * 设置:机构代码
     */
    public void setJgid(String value) {
        this.jgid = value;
    }
    /**
     * 获取:机构代码
     */
    public String getJgid() {
        return jgid;
    }
    /**
     * 设置:sfdy
     */
    public void setSfdy(BigDecimal value) {
        this.sfdy = value;
    }
    /**
     * 获取:sfdy
     */
    public BigDecimal getSfdy() {
        return sfdy;
    }
    /**
     * 设置:sfjk
     */
    public void setSfjk(BigDecimal value) {
        this.sfjk = value;
    }
    /**
     * 获取:sfjk
     */
    public BigDecimal getSfjk() {
        return sfjk;
    }
    /**
     * 设置:scbz
     */
    public void setScbz(String value) {
        this.scbz = value;
    }
    /**
     * 获取:scbz
     */
    public String getScbz() {
        return scbz;
    }

    public String getZdmc() {
        return zdmc;
    }

    public void setZdmc(String zdmc) {
        this.zdmc = zdmc;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public String getBrxz() {
        return brxz;
    }

    public void setBrxz(String brxz) {
        this.brxz = brxz;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getJzhm() {
        return jzhm;
    }

    public void setJzhm(String jzhm) {
        this.jzhm = jzhm;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public String getBrxb() {
        return brxb;
    }

    public void setBrxb(String brxb) {
        this.brxb = brxb;
    }

    public String getCsny() {
        return csny;
    }

    public void setCsny(String csny) {
        this.csny = csny;
    }

    public String getMzhm() {
        return mzhm;
    }

    public void setMzhm(String mzhm) {
        this.mzhm = mzhm;
    }

    public String getJlch() {
        return jlch;
    }

    public void setJlch(String jlch) {
        this.jlch = jlch;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }
}
