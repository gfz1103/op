package com.buit.commons.model;

import com.buit.commons.PageQuery;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 类名称：op_rbmx_sfmx<br>
 * 类描述：门诊_门诊收费日报付款明细
 * @author bjh
 * @ApiModel(value="门诊_门诊收费日报付款明细")
 */
public class OpRbmxSfmx extends  PageQuery{
	//@ApiModelProperty(value="操作工号")
    /** 操作工号 */
    private String czgh;
    private String rbid;
	//@ApiModelProperty(value="结帐日期")
    /** 结帐日期 */
    private Timestamp jzrq;
    private BigDecimal xj;
    private BigDecimal zp;
    private BigDecimal pos;
    private BigDecimal zfb;
    private BigDecimal wx;
    private BigDecimal czk;
    private BigDecimal hbwc;
    private BigDecimal kyck;
    private BigDecimal yhje;
    private BigDecimal jzje;
    private BigDecimal qtys;
    private BigDecimal sbjz;
    private BigDecimal qtjz;
    private BigDecimal zje;
    private BigDecimal yjj_xj;
    private BigDecimal yjj_zp;
    private BigDecimal yjj_pos;
    private BigDecimal yjj_hj;
    private BigDecimal tjj_xj;
    private BigDecimal tjj_zp;
    private BigDecimal tjj_pos;
    private BigDecimal tjj_hj;
    private BigDecimal ss_hj;
    private String sjh;
    private String sjzs;
    private String sjje;
    private String fph;
    private String fpzs;
    private String fpje;
    private Integer jgid;
	//@ApiModelProperty(value="mzlb")
    /** mzlb */
    private String mzlb;


    public String getCzgh() {
        return czgh;
    }

    public void setCzgh(String czgh) {
        this.czgh = czgh;
    }

    public String getRbid() {
        return rbid;
    }

    public void setRbid(String rbid) {
        this.rbid = rbid;
    }

    public Timestamp getJzrq() {
        return jzrq;
    }

    public void setJzrq(Timestamp jzrq) {
        this.jzrq = jzrq;
    }

    public BigDecimal getXj() {
        return xj;
    }

    public void setXj(BigDecimal xj) {
        this.xj = xj;
    }

    public BigDecimal getZp() {
        return zp;
    }

    public void setZp(BigDecimal zp) {
        this.zp = zp;
    }

    public BigDecimal getPos() {
        return pos;
    }

    public void setPos(BigDecimal pos) {
        this.pos = pos;
    }

    public BigDecimal getHbwc() {
        return hbwc;
    }

    public void setHbwc(BigDecimal hbwc) {
        this.hbwc = hbwc;
    }

    public BigDecimal getKyck() {
        return kyck;
    }

    public void setKyck(BigDecimal kyck) {
        this.kyck = kyck;
    }

    public BigDecimal getYhje() {
        return yhje;
    }

    public void setYhje(BigDecimal yhje) {
        this.yhje = yhje;
    }

    public BigDecimal getJzje() {
        return jzje;
    }

    public void setJzje(BigDecimal jzje) {
        this.jzje = jzje;
    }

    public BigDecimal getQtys() {
        return qtys;
    }

    public void setQtys(BigDecimal qtys) {
        this.qtys = qtys;
    }

    public BigDecimal getSbjz() {
        return sbjz;
    }

    public void setSbjz(BigDecimal sbjz) {
        this.sbjz = sbjz;
    }

    public BigDecimal getQtjz() {
        return qtjz;
    }

    public void setQtjz(BigDecimal qtjz) {
        this.qtjz = qtjz;
    }

    public BigDecimal getZje() {
        return zje;
    }

    public void setZje(BigDecimal zje) {
        this.zje = zje;
    }

    public BigDecimal getYjj_xj() {
        return yjj_xj;
    }

    public void setYjj_xj(BigDecimal yjj_xj) {
        this.yjj_xj = yjj_xj;
    }

    public BigDecimal getYjj_zp() {
        return yjj_zp;
    }

    public void setYjj_zp(BigDecimal yjj_zp) {
        this.yjj_zp = yjj_zp;
    }

    public BigDecimal getYjj_pos() {
        return yjj_pos;
    }

    public void setYjj_pos(BigDecimal yjj_pos) {
        this.yjj_pos = yjj_pos;
    }

    public BigDecimal getYjj_hj() {
        return yjj_hj;
    }

    public void setYjj_hj(BigDecimal yjj_hj) {
        this.yjj_hj = yjj_hj;
    }

    public BigDecimal getTjj_xj() {
        return tjj_xj;
    }

    public void setTjj_xj(BigDecimal tjj_xj) {
        this.tjj_xj = tjj_xj;
    }

    public BigDecimal getTjj_zp() {
        return tjj_zp;
    }

    public void setTjj_zp(BigDecimal tjj_zp) {
        this.tjj_zp = tjj_zp;
    }

    public BigDecimal getTjj_pos() {
        return tjj_pos;
    }

    public void setTjj_pos(BigDecimal tjj_pos) {
        this.tjj_pos = tjj_pos;
    }

    public BigDecimal getTjj_hj() {
        return tjj_hj;
    }

    public void setTjj_hj(BigDecimal tjj_hj) {
        this.tjj_hj = tjj_hj;
    }

    public BigDecimal getSs_hj() {
        return ss_hj;
    }

    public void setSs_hj(BigDecimal ss_hj) {
        this.ss_hj = ss_hj;
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh;
    }

    public String getSjzs() {
        return sjzs;
    }

    public void setSjzs(String sjzs) {
        this.sjzs = sjzs;
    }

    public String getSjje() {
        return sjje;
    }

    public void setSjje(String sjje) {
        this.sjje = sjje;
    }

    public String getFph() {
        return fph;
    }

    public void setFph(String fph) {
        this.fph = fph;
    }

    public String getFpzs() {
        return fpzs;
    }

    public void setFpzs(String fpzs) {
        this.fpzs = fpzs;
    }

    public String getFpje() {
        return fpje;
    }

    public void setFpje(String fpje) {
        this.fpje = fpje;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getMzlb() {
        return mzlb;
    }

    public void setMzlb(String mzlb) {
        this.mzlb = mzlb;
    }

    public BigDecimal getZfb() {
        return zfb;
    }

    public void setZfb(BigDecimal zfb) {
        this.zfb = zfb;
    }

    public BigDecimal getWx() {
        return wx;
    }

    public void setWx(BigDecimal wx) {
        this.wx = wx;
    }

    public BigDecimal getCzk() {
        return czk;
    }

    public void setCzk(BigDecimal czk) {
        this.czk = czk;
    }
}
