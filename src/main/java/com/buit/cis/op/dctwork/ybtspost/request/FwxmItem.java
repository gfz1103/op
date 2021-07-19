package com.buit.cis.op.dctwork.ybtspost.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author weijing
 * @Date 2021-04-09 14:00
 * @Description
 **/
@ApiModel(value = "服务项目节点")
public class FwxmItem<T> {
    @ApiModelProperty(value = "服务类别 2：实验室检验  3：医学影像检查 9: 其他各类治疗")
    private String FWLB;

    @ApiModelProperty(value = "编码类型 10：医保发布的统编明细项目代码 11：非医保发布的医院内自编明细项目代码")
    private String BMLX;

    @ApiModelProperty(value = "费用类别")
    private String FYLB;

    @ApiModelProperty(value = "项目名称 Item<T>或者String")
    private T XMMC;

    @ApiModelProperty(value = "项目医院自编代码")
    private String YYXMDM;

    @ApiModelProperty(value = "项目医保统编代码")
    private String YBXMDM;

    @ApiModelProperty(value = "项目数量")
    private String XMSL;

    @ApiModelProperty(value = "项目数量单位")
    private String XMSLDW;

    @ApiModelProperty(value = "检查部位编码")
    private String JCBWBM;

    @ApiModelProperty(value = "检查部位名称")
    private String JCBW;

    @ApiModelProperty(value = "诊疗部位编码")
    private String ZLBWBM;

    @ApiModelProperty(value = "项目单价")
    private String XMDJ;

    public String getFWLB() {
        return FWLB;
    }

    public void setFWLB(String FWLB) {
        this.FWLB = FWLB;
    }

    public String getBMLX() {
        return BMLX;
    }

    public void setBMLX(String BMLX) {
        this.BMLX = BMLX;
    }

    public String getFYLB() {
        return FYLB;
    }

    public void setFYLB(String FYLB) {
        this.FYLB = FYLB;
    }

    public String getYYXMDM() {
        return YYXMDM;
    }

    public void setYYXMDM(String YYXMDM) {
        this.YYXMDM = YYXMDM;
    }

    public String getYBXMDM() {
        return YBXMDM;
    }

    public void setYBXMDM(String YBXMDM) {
        this.YBXMDM = YBXMDM;
    }

    public String getXMSL() {
        return XMSL;
    }

    public void setXMSL(String XMSL) {
        this.XMSL = XMSL;
    }

    public String getXMSLDW() {
        return XMSLDW;
    }

    public void setXMSLDW(String XMSLDW) {
        this.XMSLDW = XMSLDW;
    }

    public String getJCBWBM() {
        return JCBWBM;
    }

    public void setJCBWBM(String JCBWBM) {
        this.JCBWBM = JCBWBM;
    }

    public String getJCBW() {
        return JCBW;
    }

    public void setJCBW(String JCBW) {
        this.JCBW = JCBW;
    }

    public String getZLBWBM() {
        return ZLBWBM;
    }

    public void setZLBWBM(String ZLBWBM) {
        this.ZLBWBM = ZLBWBM;
    }

    public String getXMDJ() {
        return XMDJ;
    }

    public void setXMDJ(String XMDJ) {
        this.XMDJ = XMDJ;
    }

    public T getXMMC() {
        return XMMC;
    }

    public void setXMMC(T XMMC) {
        this.XMMC = XMMC;
    }
}
