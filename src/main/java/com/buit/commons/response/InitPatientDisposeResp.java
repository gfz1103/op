
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpYjcf01<br>
 * 类描述：门诊_门诊医技单<br>
 * @author 老花生
 */
@ApiModel(value="门诊医技单")
public class InitPatientDisposeResp extends  PageQuery{
    @ApiModelProperty(value="识别序号")
    private Integer sbxh;
    @ApiModelProperty(value="医技组号")
    private Integer yjzh;
    @ApiModelProperty(value="机构代码")
    private Integer jgid;
    @ApiModelProperty(value="医技序号")
    private Integer yjxh;
    @ApiModelProperty(value="医疗序号(关联FEE_YLSFXM费用序号FYXH字段)")
    private Integer ylxh;
    @ApiModelProperty(value="项目类型")
    private Integer xmlx;
    @ApiModelProperty(value="医技主项")
    private Integer yjzx;
    @ApiModelProperty(value="费用名称")
    private String fymc;
    @ApiModelProperty(value="费用单位")
    private String fydw;
    @ApiModelProperty(value="医疗单价")
    private BigDecimal yldj;
    @ApiModelProperty(value="医疗数量")
    private BigDecimal ylsl;
    @ApiModelProperty(value="划价金额")
    private BigDecimal hjje;
    @ApiModelProperty(value="执行日期")
    private Timestamp zxrq;
    @ApiModelProperty(value="医生代码")
    private String ysdm;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="执行科室")
    private Integer zxks;
    @ApiModelProperty(value="门诊序号")
    private Integer mzxh;
    @ApiModelProperty(value="发票号码")
    private String fphm;
    @ApiModelProperty(value="申请文号")
    private Integer sqwh;
    @ApiModelProperty(value="作废判别")
    private Integer zfpb;
    @ApiModelProperty(value="费用归并")
    private Integer fygb;
    @ApiModelProperty(value="自负比例")
    private BigDecimal zfbl;
    @ApiModelProperty(value="备注信息")
    private String bzxx;
    @ApiModelProperty(value="打折比例")
    private BigDecimal dzbl;
    @ApiModelProperty(value="审批编号")
    private Integer spbh;
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @ApiModelProperty(value="组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志")
    private Integer ztbz;
    @ApiModelProperty(value="组套医嘱识别序号(OP_YJ02_ZT表SBXH)")
    private Integer ztyzsbxh;
    @ApiModelProperty(value="折扣比例")
    private BigDecimal zkbl;
    @ApiModelProperty(value="折后金额")
    private BigDecimal zhje;
    @ApiModelProperty(value="折扣金额")
    private BigDecimal zkje;
    @ApiModelProperty(value="yxms")
    private Integer yxms;
    @ApiModelProperty(value="djzt")
    private Integer djzt;
    @ApiModelProperty(value="执行判别")
    private Integer zxpb;
    @ApiModelProperty(value="申请单号")
    private Integer sqdh;
    @ApiModelProperty(value="xflsh")
    private String xflsh;
    @ApiModelProperty(value="作废判别")
    private Integer zfpb2;
    @ApiModelProperty(value="数量单位")
    private String sldw;

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public Integer getYjzh() {
        return yjzh;
    }

    public void setYjzh(Integer yjzh) {
        this.yjzh = yjzh;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getYjxh() {
        return yjxh;
    }

    public void setYjxh(Integer yjxh) {
        this.yjxh = yjxh;
    }

    public Integer getYlxh() {
        return ylxh;
    }

    public void setYlxh(Integer ylxh) {
        this.ylxh = ylxh;
    }

    public Integer getXmlx() {
        return xmlx;
    }

    public void setXmlx(Integer xmlx) {
        this.xmlx = xmlx;
    }

    public Integer getYjzx() {
        return yjzx;
    }

    public void setYjzx(Integer yjzx) {
        this.yjzx = yjzx;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public String getFydw() {
        return fydw;
    }

    public void setFydw(String fydw) {
        this.fydw = fydw;
    }

    public BigDecimal getYldj() {
        return yldj;
    }

    public void setYldj(BigDecimal yldj) {
        this.yldj = yldj;
    }

    public BigDecimal getYlsl() {
        return ylsl;
    }

    public void setYlsl(BigDecimal ylsl) {
        this.ylsl = ylsl;
    }

    public BigDecimal getHjje() {
        return hjje;
    }

    public void setHjje(BigDecimal hjje) {
        this.hjje = hjje;
    }

    public Timestamp getZxrq() {
        return zxrq;
    }

    public void setZxrq(Timestamp zxrq) {
        this.zxrq = zxrq;
    }

    public String getYsdm() {
        return ysdm;
    }

    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }

    public Integer getMzxh() {
        return mzxh;
    }

    public void setMzxh(Integer mzxh) {
        this.mzxh = mzxh;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public Integer getSqwh() {
        return sqwh;
    }

    public void setSqwh(Integer sqwh) {
        this.sqwh = sqwh;
    }

    public Integer getZfpb() {
        return zfpb;
    }

    public void setZfpb(Integer zfpb) {
        this.zfpb = zfpb;
    }

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

    public BigDecimal getZfbl() {
        return zfbl;
    }

    public void setZfbl(BigDecimal zfbl) {
        this.zfbl = zfbl;
    }

    public String getBzxx() {
        return bzxx;
    }

    public void setBzxx(String bzxx) {
        this.bzxx = bzxx;
    }

    public BigDecimal getDzbl() {
        return dzbl;
    }

    public void setDzbl(BigDecimal dzbl) {
        this.dzbl = dzbl;
    }

    public Integer getSpbh() {
        return spbh;
    }

    public void setSpbh(Integer spbh) {
        this.spbh = spbh;
    }

    public Integer getZtbz() {
        return ztbz;
    }

    public void setZtbz(Integer ztbz) {
        this.ztbz = ztbz;
    }

    public Integer getZtyzsbxh() {
        return ztyzsbxh;
    }

    public void setZtyzsbxh(Integer ztyzsbxh) {
        this.ztyzsbxh = ztyzsbxh;
    }

    public BigDecimal getZkbl() {
        return zkbl;
    }

    public void setZkbl(BigDecimal zkbl) {
        this.zkbl = zkbl;
    }

    public BigDecimal getZhje() {
        return zhje;
    }

    public void setZhje(BigDecimal zhje) {
        this.zhje = zhje;
    }

    public BigDecimal getZkje() {
        return zkje;
    }

    public void setZkje(BigDecimal zkje) {
        this.zkje = zkje;
    }

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
    }

    public Integer getYxms() {
        return yxms;
    }

    public void setYxms(Integer yxms) {
        this.yxms = yxms;
    }

    public Integer getDjzt() {
        return djzt;
    }

    public void setDjzt(Integer djzt) {
        this.djzt = djzt;
    }

    public Integer getZxpb() {
        return zxpb;
    }

    public void setZxpb(Integer zxpb) {
        this.zxpb = zxpb;
    }

    public Integer getSqdh() {
        return sqdh;
    }

    public void setSqdh(Integer sqdh) {
        this.sqdh = sqdh;
    }

    public String getXflsh() {
        return xflsh;
    }

    public void setXflsh(String xflsh) {
        this.xflsh = xflsh;
    }

    public Integer getZfpb2() {
        return zfpb2;
    }

    public void setZfpb2(Integer zfpb2) {
        this.zfpb2 = zfpb2;
    }

    public String getSldw() {
        return sldw;
    }

    public void setSldw(String sldw) {
        this.sldw = sldw;
    }
}
