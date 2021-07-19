
package com.buit.cis.op.dctwork.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;


/**
 * 类名称：MsBcjl<br>
 * 类描述：门诊_门诊病历 | 病程记录<br>
 * @author 老花生
 */
@ApiModel(value="门诊_门诊病历 | 病程记录-保存请求")
public class MsBcjlSaveReq extends  PageQuery{

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
    @ApiModelProperty(value="病情告知")
    private String bqgz;
    @ApiModelProperty(value="妊娠标志 0:无、1：妊娠期、2：哺乳期")
    private Integer rsbz;
    @ApiModelProperty(value="代配药")
    private String dpy;
    @ApiModelProperty(value="慢性病")
    private String mxb;
    @ApiModelProperty(value="体温 | 单位℃")
    private BigDecimal t;
    @ApiModelProperty(value="呼吸 | R")
    private Integer r;
    @ApiModelProperty(value="脉搏 | P  50---200")
    private Integer p;
    @ApiModelProperty(value="h")
    private BigDecimal h;
    @ApiModelProperty(value="w")
    private BigDecimal w;
    @ApiModelProperty(value="bmi")
    private BigDecimal bmi;
    @ApiModelProperty(value="收缩压 | BP1　> BP2  收缩压 舒张压")
    private Integer ssy;
    @ApiModelProperty(value="舒张压")
    private Integer szy;
    @ApiModelProperty(value="leftvision")
    private BigDecimal leftvision;
    @ApiModelProperty(value="rightvision")
    private BigDecimal rightvision;
    @ApiModelProperty(value="leftcorrectedvision")
    private BigDecimal leftcorrectedvision;
    @ApiModelProperty(value="rightcorrectedvision")
    private BigDecimal rightcorrectedvision;
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
    @ApiModelProperty(value="其他临床表现")
    private String qtlcbx;
    @ApiModelProperty(value="就诊序号 | 就诊序号 类似于住院的住院号 每次就诊不一样")
    private Integer jzxh;
    @ApiModelProperty(value="病人ID号")
    private Integer brid;
    @ApiModelProperty(value="就诊科室-挂号科室")
    private Integer ghks;
    @ApiModelProperty(value="门诊科室")
    private Integer mzks;
    @ApiModelProperty(value="健康处方")
    private List<MsBcjljKcfReq> jkcfs;
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;

    public String getZsxx() {
        return zsxx;
    }

    public void setZsxx(String zsxx) {
        this.zsxx = zsxx;
    }

    public String getXbs() {
        return xbs;
    }

    public void setXbs(String xbs) {
        this.xbs = xbs;
    }

    public String getJws() {
        return jws;
    }

    public void setJws(String jws) {
        this.jws = jws;
    }

    public String getTgjc() {
        return tgjc;
    }

    public void setTgjc(String tgjc) {
        this.tgjc = tgjc;
    }

    public String getFzjc() {
        return fzjc;
    }

    public void setFzjc(String fzjc) {
        this.fzjc = fzjc;
    }

    public String getBqgz() {
        return bqgz;
    }

    public void setBqgz(String bqgz) {
        this.bqgz = bqgz;
    }

    public Integer getRsbz() {
        return rsbz;
    }

    public void setRsbz(Integer rsbz) {
        this.rsbz = rsbz;
    }

    public String getDpy() {
        return dpy;
    }

    public void setDpy(String dpy) {
        this.dpy = dpy;
    }

    public String getMxb() {
        return mxb;
    }

    public void setMxb(String mxb) {
        this.mxb = mxb;
    }

    public BigDecimal getT() {
        return t;
    }

    public void setT(BigDecimal t) {
        this.t = t;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public BigDecimal getH() {
        return h;
    }

    public void setH(BigDecimal h) {
        this.h = h;
    }

    public BigDecimal getW() {
        return w;
    }

    public void setW(BigDecimal w) {
        this.w = w;
    }

    public BigDecimal getBmi() {
        return bmi;
    }

    public void setBmi(BigDecimal bmi) {
        this.bmi = bmi;
    }

    public Integer getSsy() {
        return ssy;
    }

    public void setSsy(Integer ssy) {
        this.ssy = ssy;
    }

    public Integer getSzy() {
        return szy;
    }

    public void setSzy(Integer szy) {
        this.szy = szy;
    }

    public BigDecimal getLeftvision() {
        return leftvision;
    }

    public void setLeftvision(BigDecimal leftvision) {
        this.leftvision = leftvision;
    }

    public BigDecimal getRightvision() {
        return rightvision;
    }

    public void setRightvision(BigDecimal rightvision) {
        this.rightvision = rightvision;
    }

    public BigDecimal getLeftcorrectedvision() {
        return leftcorrectedvision;
    }

    public void setLeftcorrectedvision(BigDecimal leftcorrectedvision) {
        this.leftcorrectedvision = leftcorrectedvision;
    }

    public BigDecimal getRightcorrectedvision() {
        return rightcorrectedvision;
    }

    public void setRightcorrectedvision(BigDecimal rightcorrectedvision) {
        this.rightcorrectedvision = rightcorrectedvision;
    }

    public Boolean getKs() {
        return ks;
    }

    public void setKs(Boolean ks) {
        this.ks = ks;
    }

    public Boolean getYt() {
        return yt;
    }

    public void setYt(Boolean yt) {
        this.yt = yt;
    }

    public Boolean getHxkn() {
        return hxkn;
    }

    public void setHxkn(Boolean hxkn) {
        this.hxkn = hxkn;
    }

    public Boolean getOt() {
        return ot;
    }

    public void setOt(Boolean ot) {
        this.ot = ot;
    }

    public Boolean getFt() {
        return ft;
    }

    public void setFt(Boolean ft) {
        this.ft = ft;
    }

    public Boolean getFx() {
        return fx;
    }

    public void setFx(Boolean fx) {
        this.fx = fx;
    }

    public Boolean getPz() {
        return pz;
    }

    public void setPz(Boolean pz) {
        this.pz = pz;
    }

    public String getQtlcbx() {
        return qtlcbx;
    }

    public void setQtlcbx(String qtlcbx) {
        this.qtlcbx = qtlcbx;
    }

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getGhks() {
        return ghks;
    }

    public void setGhks(Integer ghks) {
        this.ghks = ghks;
    }

    public Integer getMzks() {
        return mzks;
    }

    public void setMzks(Integer mzks) {
        this.mzks = mzks;
    }

    public List<MsBcjljKcfReq> getJkcfs() {
        return jkcfs;
    }

    public void setJkcfs(List<MsBcjljKcfReq> jkcfs) {
        this.jkcfs = jkcfs;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }
}