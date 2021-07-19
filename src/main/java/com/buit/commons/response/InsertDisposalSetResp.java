package com.buit.commons.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName InsertDisposalSetResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/29 13:50
 */
@ApiModel(value="根据组装组套插入数据-返回")
public class InsertDisposalSetResp {

    @ApiModelProperty(value="识别序号")
    private Integer sbxh;
    @ApiModelProperty(value="医技组号")
    private Integer yjzh;
    @ApiModelProperty(value="机构ID")
    private Integer jgid;
    @ApiModelProperty(value="医技序号")
    private Integer yjxh;
    @ApiModelProperty(value="医疗序号")
    private Integer ylxh;
    @ApiModelProperty(value="项目类型")
    private Integer xmlx;
    @ApiModelProperty(value="医技主项")
    private Integer yjzx;
    @ApiModelProperty(value="费用名称")
    private String fymc;
    @ApiModelProperty(value="单位")
    private String fydw;
    @ApiModelProperty(value="医疗单价")
    private BigDecimal yldj;
    @ApiModelProperty(value="医疗数量")
    private BigDecimal ylsl;
    @ApiModelProperty(value="划价金额")
    private BigDecimal hjje;
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
    @ApiModelProperty(value="组套标志")
    private Integer ztbz;

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

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
    }

    public Integer getZtbz() {
        return ztbz;
    }

    public void setZtbz(Integer ztbz) {
        this.ztbz = ztbz;
    }
}
