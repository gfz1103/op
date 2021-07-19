
package com.buit.commons.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：QueryShiftDeptReq<br>
 * 类描述：查询科室排班请求<br>
 * @author 老花生
 */
@ApiModel(value="查询科室排班请求")
public class QueryShiftDeptResp {
    @ApiModelProperty(value="挂号日期")
    private String ghrq;
    @ApiModelProperty(value="诊疗费")
    private BigDecimal zlf;
    @ApiModelProperty(value="五笔代码")
    private String wbdm;
    @ApiModelProperty(value="拼音代码")
    private String pydm;
    @ApiModelProperty(value="")
    private int selected;
    @ApiModelProperty(value="挂号费")
    private BigDecimal ghf;
    @ApiModelProperty(value="专家门诊 | 0.普通门诊    1.专家门诊")
    private int zjmz;
    @ApiModelProperty(value="科室名称")
    private String ksmc;
    @ApiModelProperty(value="专家门诊 | 0.普通门诊    1.专家门诊")
    private String zjmzText;
    @ApiModelProperty(value="科室代码")
    private int ksdm;
    @ApiModelProperty(value="角形代码")
    private String jxdm;
    @ApiModelProperty(value="挂号类别 | 与GY_DMZD (DMLB = 25)关联")
    private int ghlb;
    @ApiModelProperty(value="其他代码")
    private Object qtdm;
    @ApiModelProperty(value="数字代码")
    private String szdm;
    @ApiModelProperty(value="停挂标志")
    private int tgbz;
    @ApiModelProperty(value="节假日挂号费")
    private int jjrghf;
    @ApiModelProperty(value="预约人数")
    private int yyrs;

    public String getGhrq() {
        return ghrq;
    }

    public void setGhrq(String ghrq) {
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

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public BigDecimal getGhf() {
        return ghf;
    }

    public void setGhf(BigDecimal ghf) {
        this.ghf = ghf;
    }

    public int getZjmz() {
        return zjmz;
    }

    public void setZjmz(int zjmz) {
        this.zjmz = zjmz;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public String getZjmzText() {
        return zjmzText;
    }

    public void setZjmzText(String zjmzText) {
        this.zjmzText = zjmzText;
    }

    public int getKsdm() {
        return ksdm;
    }

    public void setKsdm(int ksdm) {
        this.ksdm = ksdm;
    }

    public String getJxdm() {
        return jxdm;
    }

    public void setJxdm(String jxdm) {
        this.jxdm = jxdm;
    }

    public int getGhlb() {
        return ghlb;
    }

    public void setGhlb(int ghlb) {
        this.ghlb = ghlb;
    }

    public Object getQtdm() {
        return qtdm;
    }

    public void setQtdm(Object qtdm) {
        this.qtdm = qtdm;
    }

    public String getSzdm() {
        return szdm;
    }

    public void setSzdm(String szdm) {
        this.szdm = szdm;
    }

    public int getTgbz() {
        return tgbz;
    }

    public void setTgbz(int tgbz) {
        this.tgbz = tgbz;
    }

    public int getJjrghf() {
        return jjrghf;
    }

    public void setJjrghf(int jjrghf) {
        this.jjrghf = jjrghf;
    }

    public int getYyrs() {
        return yyrs;
    }

    public void setYyrs(int yyrs) {
        this.yyrs = yyrs;
    }
}