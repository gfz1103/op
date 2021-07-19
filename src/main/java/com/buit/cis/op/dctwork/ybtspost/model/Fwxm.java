package com.buit.cis.op.dctwork.ybtspost.model;

/**
 * @Author weijing
 * @Date 2021-04-12 09:56
 * @Description
 **/
public class Fwxm {
    /** 服务类别 2：实验室检验  3：医学影像检查 9: 其他各类治疗 **/
    private String FWLB;

    /** 编码类型 10：医保发布的统编明细项目代码 11：非医保发布的医院内自编明细项目代码 **/
    private String BMLX;

    /** 费用类别 **/
    private String FYLB;

    /** 项目名称**/
    private String XMMC;

    /** 项目医院自编代码 **/
    private String YYXMDM;

    /** 项目医保统编代码 **/
    private String YBXMDM;

    /** 项目数量 **/
    private String XMSL;

    /** 项目数量单位 **/
    private String XMSLDW;

    /** 检查部位编码 **/
    private String JCBWBM;

    /** 检查部位名称 **/
    private String JCBW;

    /** 诊疗部位编码 **/
    private String ZLBWBM;

    /** 项目单价 **/
    private String XMDJ;

    /** 组套标志 **/
    private Integer ZTBZ;

    /** 组套编号 **/
    private Integer ZTBH;


    public Integer getZTBZ() {
        return ZTBZ;
    }

    public void setZTBZ(Integer ZTBZ) {
        this.ZTBZ = ZTBZ;
    }

    public Integer getZTBH() {
        return ZTBH;
    }

    public void setZTBH(Integer ZTBH) {
        this.ZTBH = ZTBH;
    }

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

    public String getXMMC() {
        return XMMC;
    }

    public void setXMMC(String XMMC) {
        this.XMMC = XMMC;
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
}
