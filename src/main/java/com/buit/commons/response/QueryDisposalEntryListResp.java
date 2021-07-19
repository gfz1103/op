package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @ClassName QueryDisposalEntryListResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/7 16:36
 */
@ApiModel(value="查询处置列表-返回")
public class QueryDisposalEntryListResp {

    @ApiModelProperty(value="执行科室")
    private Integer zxks;
    @ApiModelProperty(value="医技序号")
    private Integer yjxh;
    @ApiModelProperty(value="发票号码")
    private String fphm;
    @ApiModelProperty(value="费用归并")
    private Integer fygb;
    @ApiModelProperty(value="组套编号")
    private String ztbh;
    @ApiModelProperty(value="审批编号")
    private String spbh;
    @ApiModelProperty(value="费用单位")
    private String fydw;
    @ApiModelProperty(value="就诊机构")
    private String jgid;
    @ApiModelProperty(value="病人医技接口id")
    private Integer yjjk;
    @ApiModelProperty(value="申请文号")
    private String sqwh;
    @ApiModelProperty(value="费用名称")
    private String fymc;
    @ApiModelProperty(value="门诊序号")
    private String mzxh;
    @ApiModelProperty(value="组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志")
    private Integer ztbz;
    @ApiModelProperty(value="执行日期")
    private String zxrq;
    @ApiModelProperty(value="识别序号 op_yjcf02表主键")
    private Integer sbxh;
    @ApiModelProperty(value="医疗序号")
    private Integer ylxh;
    @ApiModelProperty(value="备注信息")
    private String bzxx;
    @ApiModelProperty(value="项目类型")
    private Integer xmlx;
    @ApiModelProperty(value="组套医嘱识别序号(OP_YJ02_ZT表SBXH)")
    private String ztyzsbxh;
    @ApiModelProperty(value="医疗数量")
    private BigDecimal ylsl;
    @ApiModelProperty(value="医生")
    private String ysdm;
    @ApiModelProperty(value="合计金额")
    private BigDecimal hjje;
    @ApiModelProperty(value="自负比例")
    private Integer zfbl;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="打折比例")
    private Integer dzbl;
    @ApiModelProperty(value="医技主项")
    private Integer yjzx;
    @ApiModelProperty(value="单价")
    private BigDecimal yldj;
    @ApiModelProperty(value="作废判别")
    private Integer zfpb;
    @ApiModelProperty(value="医技组号")
    private Integer yjzh;
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;
    @ApiModelProperty(value="排序号 用于前端区分颜色展示")
    private Integer pxh;
    @ApiModelProperty(value="单据来源  11处置")
    private Integer djly;

    public Integer getDjly() {
        return djly;
    }

    public void setDjly(Integer djly) {
        this.djly = djly;
    }

    public Integer getPxh() {
        return pxh;
    }

    public void setPxh(Integer pxh) {
        this.pxh = pxh;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }

    public Integer getYjxh() {
        return yjxh;
    }

    public void setYjxh(Integer yjxh) {
        this.yjxh = yjxh;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

    public String getZtbh() {
        return ztbh;
    }

    public void setZtbh(String ztbh) {
        this.ztbh = ztbh;
    }

    public String getSpbh() {
        return spbh;
    }

    public void setSpbh(String spbh) {
        this.spbh = spbh;
    }

    public String getFydw() {
        return fydw;
    }

    public void setFydw(String fydw) {
        this.fydw = fydw;
    }

    public String getJgid() {
        return jgid;
    }

    public void setJgid(String jgid) {
        this.jgid = jgid;
    }

    public Integer getYjjk() {
        return yjjk;
    }

    public void setYjjk(Integer yjjk) {
        this.yjjk = yjjk;
    }

    public String getSqwh() {
        return sqwh;
    }

    public void setSqwh(String sqwh) {
        this.sqwh = sqwh;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public String getMzxh() {
        return mzxh;
    }

    public void setMzxh(String mzxh) {
        this.mzxh = mzxh;
    }

    public Integer getZtbz() {
        return ztbz;
    }

    public void setZtbz(Integer ztbz) {
        this.ztbz = ztbz;
    }

    public String getZxrq() {
        return zxrq;
    }

    public void setZxrq(String zxrq) {
        this.zxrq = zxrq;
    }

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public Integer getYlxh() {
        return ylxh;
    }

    public void setYlxh(Integer ylxh) {
        this.ylxh = ylxh;
    }

    public String getBzxx() {
        return bzxx;
    }

    public void setBzxx(String bzxx) {
        this.bzxx = bzxx;
    }

    public Integer getXmlx() {
        return xmlx;
    }

    public void setXmlx(Integer xmlx) {
        this.xmlx = xmlx;
    }

    public String getZtyzsbxh() {
        return ztyzsbxh;
    }

    public void setZtyzsbxh(String ztyzsbxh) {
        this.ztyzsbxh = ztyzsbxh;
    }

    public BigDecimal getYlsl() {
        return ylsl;
    }

    public void setYlsl(BigDecimal ylsl) {
        this.ylsl = ylsl;
    }

    public String getYsdm() {
        return ysdm;
    }

    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }

    public BigDecimal getHjje() {
        return hjje;
    }

    public void setHjje(BigDecimal hjje) {
        this.hjje = hjje;
    }

    public Integer getZfbl() {
        return zfbl;
    }

    public void setZfbl(Integer zfbl) {
        this.zfbl = zfbl;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Integer getDzbl() {
        return dzbl;
    }

    public void setDzbl(Integer dzbl) {
        this.dzbl = dzbl;
    }

    public Integer getYjzx() {
        return yjzx;
    }

    public void setYjzx(Integer yjzx) {
        this.yjzx = yjzx;
    }

    public BigDecimal getYldj() {
        return yldj;
    }

    public void setYldj(BigDecimal yldj) {
        this.yldj = yldj;
    }

    public Integer getZfpb() {
        return zfpb;
    }

    public void setZfpb(Integer zfpb) {
        this.zfpb = zfpb;
    }

    public Integer getYjzh() {
        return yjzh;
    }

    public void setYjzh(Integer yjzh) {
        this.yjzh = yjzh;
    }
}
