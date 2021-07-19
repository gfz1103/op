package com.buit.cis.op.dctwork.ybtspost.model;

/**
 * @Author weijing
 * @Date 2021-04-12 16:56
 * @Description
 **/
public class Ztfwxm {
    /** 服务类别 2：实验室检验  3：医学影像检查 9: 其他各类治疗 **/
    private String FWLB;

    /** 项目医院自编代码 **/
    private String YYXMDM;

    /** 项目医保统编代码 **/
    //private String YBXMDM;

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

    public String getFWLB() {
        return FWLB;
    }

    public void setFWLB(String FWLB) {
        this.FWLB = FWLB;
    }

    public String getYYXMDM() {
        return YYXMDM;
    }

    public void setYYXMDM(String YYXMDM) {
        this.YYXMDM = YYXMDM;
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
