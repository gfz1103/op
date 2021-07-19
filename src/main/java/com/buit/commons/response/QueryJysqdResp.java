package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @Author weijing
 * @Date 2021-01-15 14:32
 * @Description
 **/
@ApiModel("检验申请单查询返回")
public class QueryJysqdResp {
    @ApiModelProperty("机构id")
    private Integer jgid;

    @ApiModelProperty("病人姓名")
    private String brxm;

    @ApiModelProperty("开单日期（申请时间）")
    private Timestamp kdrq;

    @ApiModelProperty("申请科室代码")
    private Integer ksdm;

    @ApiModelProperty("申请医生代码")
    private Integer ysdm;

    @ApiModelProperty("执行科室")
    private Integer zxks;

    @ApiModelProperty("单据状态")
    private Integer djzt;

    @ApiModelProperty("项目对应的序号（打印时用）")
    private String sbxhs;

    @ApiModelProperty("合计金额")
    private String hjje;

    @ApiModelProperty("项目列表（当前申请包含的项目）")
    private String xmlbs;

    @ApiModelProperty("组套名称（当项目为组套时才会有）")
    private String ztmc;

    public String getXmlbs() {
        return xmlbs;
    }

    public void setXmlbs(String xmlbs) {
        this.xmlbs = xmlbs;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Timestamp getKdrq() {
        return kdrq;
    }

    public void setKdrq(Timestamp kdrq) {
        this.kdrq = kdrq;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Integer getYsdm() {
        return ysdm;
    }

    public void setYsdm(Integer ysdm) {
        this.ysdm = ysdm;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }

    public Integer getDjzt() {
        return djzt;
    }

    public void setDjzt(Integer djzt) {
        this.djzt = djzt;
    }

    public String getSbxhs() {
        return sbxhs;
    }

    public void setSbxhs(String sbxhs) {
        this.sbxhs = sbxhs;
    }

    public String getHjje() {
        return hjje;
    }

    public void setHjje(String hjje) {
        this.hjje = hjje;
    }

    public String getZtmc() {
        return ztmc;
    }

    public void setZtmc(String ztmc) {
        this.ztmc = ztmc;
    }
}
