
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：MsBcjl<br>
 * 类描述：门诊_门诊病历 | 病程记录<br>
 * @author 老花生
 */
@ApiModel(value="门诊_门诊病历 | 病程记录")
public class MsBcjlResp  extends  PageQuery{
    @ApiModelProperty(value="就诊序号 | 就诊序号 类似于住院的住院号 每次就诊不一样")
    private Integer jzxh;
    @ApiModelProperty(value="病人ID号")
    private Integer brid;
    @ApiModelProperty(value="病历类型")
    private Integer bllx;
    @ApiModelProperty(value="病历类别")
    private Integer bllb;
    @ApiModelProperty(value="病历名称")
    private String blmc;
    @ApiModelProperty(value="就诊科室")
    private Integer jzks;
    @ApiModelProperty(value="就诊医生")
    private String jzys;
    @ApiModelProperty(value="主诉信息")
    private String zsxx;
    @ApiModelProperty(value="先病史")
    private String xbs;
    @ApiModelProperty(value="既往史")
    private String jws;
    @ApiModelProperty(value="tgjc")
    private String tgjc;
    @ApiModelProperty(value="fzjc")
    private String fzjc;
    @ApiModelProperty(value="处理措施")
    private String clcs;
    @ApiModelProperty(value="体温 | 单位℃")
    private BigDecimal t;
    @ApiModelProperty(value="脉搏 | P  50---200")
    private Integer p;
    @ApiModelProperty(value="呼吸 | R")
    private Integer r;
    @ApiModelProperty(value="收缩压 | BP1　> BP2  收缩压 舒张压")
    private Integer ssy;
    @ApiModelProperty(value="舒张压")
    private Integer szy;
    @ApiModelProperty(value="处理意见")
    private String czys;
    @ApiModelProperty(value="机构代码")
    private Integer jgid;
    @ApiModelProperty(value="咳嗽")
    private Boolean ks;
    @ApiModelProperty(value="咽痛")
    private Boolean yt;
    @ApiModelProperty(value="呼吸困难")
    private Boolean hxkn;
    @ApiModelProperty(value="呕吐")
    private Boolean ot;
    @ApiModelProperty(value="腹痛")
    private Boolean ft;
    @ApiModelProperty(value="腹泻")
    private Boolean fx;
    @ApiModelProperty(value="皮疹")
    private Boolean pz;
    @ApiModelProperty(value="其他")
    private Boolean qt;
    @ApiModelProperty(value="病人去向")
    private Boolean brqx;
    @ApiModelProperty(value="健康教育")
    private String jkjy;
    @ApiModelProperty(value="修正诊断")
    private String xzzd;
    @ApiModelProperty(value="打印标志")
    private String dybz;
    @ApiModelProperty(value="w")
    private BigDecimal w;
    @ApiModelProperty(value="h")
    private BigDecimal h;
    @ApiModelProperty(value="bmi")
    private BigDecimal bmi;
    @ApiModelProperty(value="代配药")
    private String dpy;
    @ApiModelProperty(value="妊娠标志 0:无、1：妊娠期、2：哺乳期")
    private Boolean rsbz;
    @ApiModelProperty(value="病情告知")
    private String bqgz;
    @ApiModelProperty(value="治则（中医科专用）")
    private String zz;
    @ApiModelProperty(value="leftvision")
    private BigDecimal leftvision;
    @ApiModelProperty(value="rightvision")
    private BigDecimal rightvision;
    @ApiModelProperty(value="leftcorrectedvision")
    private BigDecimal leftcorrectedvision;
    @ApiModelProperty(value="rightcorrectedvision")
    private BigDecimal rightcorrectedvision;
    @ApiModelProperty(value="其他临床表现")
    private String qtlcbx;
    @ApiModelProperty(value="慢性病")
    private String mxb;
    /**
     * 设置:就诊序号 | 就诊序号 类似于住院的住院号 每次就诊不一样
     */
    public void setJzxh(Integer value) {
        this.jzxh = value;
    }
    /**
     * 获取:就诊序号 | 就诊序号 类似于住院的住院号 每次就诊不一样
     */
    public Integer getJzxh() {
        return jzxh;
    }
    /**
     * 设置:病人ID号
     */
    public void setBrid(Integer value) {
        this.brid = value;
    }
    /**
     * 获取:病人ID号
     */
    public Integer getBrid() {
        return brid;
    }

    public Integer getBllx() {
        return bllx;
    }

    public void setBllx(Integer bllx) {
        this.bllx = bllx;
    }

    /**
     * 设置:病历类别
     */
    public void setBllb(Integer value) {
        this.bllb = value;
    }
    /**
     * 获取:病历类别
     */
    public Integer getBllb() {
        return bllb;
    }
    /**
     * 设置:病历名称
     */
    public void setBlmc(String value) {
        this.blmc = value;
    }
    /**
     * 获取:病历名称
     */
    public String getBlmc() {
        return blmc;
    }
    /**
     * 设置:就诊科室
     */
    public void setJzks(Integer value) {
        this.jzks = value;
    }
    /**
     * 获取:就诊科室
     */
    public Integer getJzks() {
        return jzks;
    }
    /**
     * 设置:就诊医生
     */
    public void setJzys(String value) {
        this.jzys = value;
    }
    /**
     * 获取:就诊医生
     */
    public String getJzys() {
        return jzys;
    }
    /**
     * 设置:主诉信息
     */
    public void setZsxx(String value) {
        this.zsxx = value;
    }
    /**
     * 获取:主诉信息
     */
    public String getZsxx() {
        return zsxx;
    }
    /**
     * 设置:先病史
     */
    public void setXbs(String value) {
        this.xbs = value;
    }
    /**
     * 获取:先病史
     */
    public String getXbs() {
        return xbs;
    }
    /**
     * 设置:既往史
     */
    public void setJws(String value) {
        this.jws = value;
    }
    /**
     * 获取:既往史
     */
    public String getJws() {
        return jws;
    }
    /**
     * 设置:tgjc
     */
    public void setTgjc(String value) {
        this.tgjc = value;
    }
    /**
     * 获取:tgjc
     */
    public String getTgjc() {
        return tgjc;
    }
    /**
     * 设置:fzjc
     */
    public void setFzjc(String value) {
        this.fzjc = value;
    }
    /**
     * 获取:fzjc
     */
    public String getFzjc() {
        return fzjc;
    }
    /**
     * 设置:处理措施
     */
    public void setClcs(String value) {
        this.clcs = value;
    }
    /**
     * 获取:处理措施
     */
    public String getClcs() {
        return clcs;
    }
    /**
     * 设置:体温 | 单位℃
     */
    public void setT(BigDecimal value) {
        this.t = value;
    }
    /**
     * 获取:体温 | 单位℃
     */
    public BigDecimal getT() {
        return t;
    }
    /**
     * 设置:脉搏 | P  50---200
     */
    public void setP(Integer value) {
        this.p = value;
    }
    /**
     * 获取:脉搏 | P  50---200
     */
    public Integer getP() {
        return p;
    }
    /**
     * 设置:呼吸 | R
     */
    public void setR(Integer value) {
        this.r = value;
    }
    /**
     * 获取:呼吸 | R
     */
    public Integer getR() {
        return r;
    }
    /**
     * 设置:收缩压 | BP1　> BP2  收缩压 舒张压
     */
    public void setSsy(Integer value) {
        this.ssy = value;
    }
    /**
     * 获取:收缩压 | BP1　> BP2  收缩压 舒张压
     */
    public Integer getSsy() {
        return ssy;
    }
    /**
     * 设置:舒张压
     */
    public void setSzy(Integer value) {
        this.szy = value;
    }
    /**
     * 获取:舒张压
     */
    public Integer getSzy() {
        return szy;
    }
    /**
     * 设置:处理意见
     */
    public void setCzys(String value) {
        this.czys = value;
    }
    /**
     * 获取:处理意见
     */
    public String getCzys() {
        return czys;
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
     * 设置:咳嗽
     */
    public void setKs(Boolean value) {
        this.ks = value;
    }
    /**
     * 获取:咳嗽
     */
    public Boolean getKs() {
        return ks;
    }
    /**
     * 设置:咽痛
     */
    public void setYt(Boolean value) {
        this.yt = value;
    }
    /**
     * 获取:咽痛
     */
    public Boolean getYt() {
        return yt;
    }
    /**
     * 设置:呼吸困难
     */
    public void setHxkn(Boolean value) {
        this.hxkn = value;
    }
    /**
     * 获取:呼吸困难
     */
    public Boolean getHxkn() {
        return hxkn;
    }
    /**
     * 设置:呕吐
     */
    public void setOt(Boolean value) {
        this.ot = value;
    }
    /**
     * 获取:呕吐
     */
    public Boolean getOt() {
        return ot;
    }
    /**
     * 设置:腹痛
     */
    public void setFt(Boolean value) {
        this.ft = value;
    }
    /**
     * 获取:腹痛
     */
    public Boolean getFt() {
        return ft;
    }
    /**
     * 设置:腹泻
     */
    public void setFx(Boolean value) {
        this.fx = value;
    }
    /**
     * 获取:腹泻
     */
    public Boolean getFx() {
        return fx;
    }
    /**
     * 设置:皮疹
     */
    public void setPz(Boolean value) {
        this.pz = value;
    }
    /**
     * 获取:皮疹
     */
    public Boolean getPz() {
        return pz;
    }
    /**
     * 设置:其他
     */
    public void setQt(Boolean value) {
        this.qt = value;
    }
    /**
     * 获取:其他
     */
    public Boolean getQt() {
        return qt;
    }
    /**
     * 设置:病人去向
     */
    public void setBrqx(Boolean value) {
        this.brqx = value;
    }
    /**
     * 获取:病人去向
     */
    public Boolean getBrqx() {
        return brqx;
    }
    /**
     * 设置:健康教育
     */
    public void setJkjy(String value) {
        this.jkjy = value;
    }
    /**
     * 获取:健康教育
     */
    public String getJkjy() {
        return jkjy;
    }
    /**
     * 设置:修正诊断
     */
    public void setXzzd(String value) {
        this.xzzd = value;
    }
    /**
     * 获取:修正诊断
     */
    public String getXzzd() {
        return xzzd;
    }
    /**
     * 设置:打印标志
     */
    public void setDybz(String value) {
        this.dybz = value;
    }
    /**
     * 获取:打印标志
     */
    public String getDybz() {
        return dybz;
    }
    /**
     * 设置:w
     */
    public void setW(BigDecimal value) {
        this.w = value;
    }
    /**
     * 获取:w
     */
    public BigDecimal getW() {
        return w;
    }
    /**
     * 设置:h
     */
    public void setH(BigDecimal value) {
        this.h = value;
    }
    /**
     * 获取:h
     */
    public BigDecimal getH() {
        return h;
    }
    /**
     * 设置:bmi
     */
    public void setBmi(BigDecimal value) {
        this.bmi = value;
    }
    /**
     * 获取:bmi
     */
    public BigDecimal getBmi() {
        return bmi;
    }
    /**
     * 设置:代配药
     */
    public void setDpy(String value) {
        this.dpy = value;
    }
    /**
     * 获取:代配药
     */
    public String getDpy() {
        return dpy;
    }
    /**
     * 设置:妊娠标志 0:无、1：妊娠期、2：哺乳期
     */
    public void setRsbz(Boolean value) {
        this.rsbz = value;
    }
    /**
     * 获取:妊娠标志 0:无、1：妊娠期、2：哺乳期
     */
    public Boolean getRsbz() {
        return rsbz;
    }
    /**
     * 设置:病情告知
     */
    public void setBqgz(String value) {
        this.bqgz = value;
    }
    /**
     * 获取:病情告知
     */
    public String getBqgz() {
        return bqgz;
    }
    /**
     * 设置:治则（中医科专用）
     */
    public void setZz(String value) {
        this.zz = value;
    }
    /**
     * 获取:治则（中医科专用）
     */
    public String getZz() {
        return zz;
    }
    /**
     * 设置:leftvision
     */
    public void setLeftvision(BigDecimal value) {
        this.leftvision = value;
    }
    /**
     * 获取:leftvision
     */
    public BigDecimal getLeftvision() {
        return leftvision;
    }
    /**
     * 设置:rightvision
     */
    public void setRightvision(BigDecimal value) {
        this.rightvision = value;
    }
    /**
     * 获取:rightvision
     */
    public BigDecimal getRightvision() {
        return rightvision;
    }
    /**
     * 设置:leftcorrectedvision
     */
    public void setLeftcorrectedvision(BigDecimal value) {
        this.leftcorrectedvision = value;
    }
    /**
     * 获取:leftcorrectedvision
     */
    public BigDecimal getLeftcorrectedvision() {
        return leftcorrectedvision;
    }
    /**
     * 设置:rightcorrectedvision
     */
    public void setRightcorrectedvision(BigDecimal value) {
        this.rightcorrectedvision = value;
    }
    /**
     * 获取:rightcorrectedvision
     */
    public BigDecimal getRightcorrectedvision() {
        return rightcorrectedvision;
    }
    /**
     * 设置:其他临床表现
     */
    public void setQtlcbx(String value) {
        this.qtlcbx = value;
    }
    /**
     * 获取:其他临床表现
     */
    public String getQtlcbx() {
        return qtlcbx;
    }
    /**
     * 设置:慢性病
     */
    public void setMxb(String value) {
        this.mxb = value;
    }
    /**
     * 获取:慢性病
     */
    public String getMxb() {
        return mxb;
    }
}