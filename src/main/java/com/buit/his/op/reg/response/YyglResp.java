package com.buit.his.op.reg.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @ClassName YyglResp
 * @Description 预约管理-返回
 * @Author 老花生
 * @Date 2020/6/29 13:47
 */
@ApiModel(value="预约管理-返回")
public class YyglResp extends PageQuery {
    @ApiModelProperty(value="挂号日期")
    private Date ghrq;
    @ApiModelProperty(value="诊疗费")
    private BigDecimal zlf;
    @ApiModelProperty(value="五笔码")
    private String wbdm;
    @ApiModelProperty(value="拼音码")
    private String pydm;
    @ApiModelProperty(value="Selected")
    private Integer selected;
    @ApiModelProperty(value="挂号费")
    private BigDecimal ghf;
    @ApiModelProperty(value="专家门诊")
    private Integer zjmz;
    @ApiModelProperty(value="挂号科室")
    private String ksmc;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="角形代码")
    private String jxdm;
    @ApiModelProperty(value="挂号类别")
    private Integer ghlb;
    @ApiModelProperty(value="其他代码")
    private String qtdm;
    @ApiModelProperty(value="数字代码")
    private String szdm;
    @ApiModelProperty(value="停挂标志")
    private Integer tgbz;
    @ApiModelProperty(value="节假日挂号费")
    private BigDecimal JJRGHF;
    @ApiModelProperty(value="预约人数")
    private Integer yyrs;
    @ApiModelProperty(value="特需")
    private Integer txmz;
    @ApiModelProperty(value="挂号限额")
    private Integer ghxe;
    @ApiModelProperty(value="年龄限制")
    private Integer nlxz;
    @ApiModelProperty(value="性别限制")
    private Integer xbxz;

    public Date getGhrq() {
        return ghrq;
    }

    public void setGhrq(Date ghrq) {
        this.ghrq = ghrq;
    }

    public BigDecimal getZlf() {
        return zlf;
    }

    public void setZlf(BigDecimal zlf) {
        this.zlf = zlf;
    }

    public String getWbdm() {
        return wbdm;
    }

    public void setWbdm(String wbdm) {
        this.wbdm = wbdm;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    public BigDecimal getGhf() {
        return ghf;
    }

    public void setGhf(BigDecimal ghf) {
        this.ghf = ghf;
    }

    public Integer getZjmz() {
        return zjmz;
    }

    public void setZjmz(Integer zjmz) {
        this.zjmz = zjmz;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public String getJxdm() {
        return jxdm;
    }

    public void setJxdm(String jxdm) {
        this.jxdm = jxdm;
    }

    public Integer getGhlb() {
        return ghlb;
    }

    public void setGhlb(Integer ghlb) {
        this.ghlb = ghlb;
    }

    public String getQtdm() {
        return qtdm;
    }

    public void setQtdm(String qtdm) {
        this.qtdm = qtdm;
    }

    public String getSzdm() {
        return szdm;
    }

    public void setSzdm(String szdm) {
        this.szdm = szdm;
    }

    public Integer getTgbz() {
        return tgbz;
    }

    public void setTgbz(Integer tgbz) {
        this.tgbz = tgbz;
    }

    public BigDecimal getJJRGHF() {
        return JJRGHF;
    }

    public void setJJRGHF(BigDecimal JJRGHF) {
        this.JJRGHF = JJRGHF;
    }

    public Integer getYyrs() {
        return yyrs;
    }

    public void setYyrs(Integer yyrs) {
        this.yyrs = yyrs;
    }

    public Integer getTxmz() {
        return txmz;
    }

    public void setTxmz(Integer txmz) {
        this.txmz = txmz;
    }

    public Integer getGhxe() {
        return ghxe;
    }

    public void setGhxe(Integer ghxe) {
        this.ghxe = ghxe;
    }

    public Integer getNlxz() {
        return nlxz;
    }

    public void setNlxz(Integer nlxz) {
        this.nlxz = nlxz;
    }

    public Integer getXbxz() {
        return xbxz;
    }

    public void setXbxz(Integer xbxz) {
        this.xbxz = xbxz;
    }
}
