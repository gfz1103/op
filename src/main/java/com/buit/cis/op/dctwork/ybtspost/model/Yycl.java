package com.buit.cis.op.dctwork.ybtspost.model;

/**
 * @Author weijing
 * @Date 2021-04-12 13:36
 * @Description
 **/
public class Yycl {
    /** 编码类型 10：医保发布的统编明细项目代码 11：非医保发布的医院内自编明细项目代码 **/
    private String BMLX;

    /** 费用类别 **/
    private String FYLB;

    /** 医用材料名称 **/
    private String CLMC;

    /** 医用材料医保统编代码 **/
    private String YYCLBM;

    /** 医用材料规格 **/
    private String CLGG;

    /** 医用材料数量 **/
    private String CLSL;

    /** 材料数量单位 **/
    private String CLSLDW;

    /** 材料单价 **/
    private String CLDJ;

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

    public String getCLMC() {
        return CLMC;
    }

    public void setCLMC(String CLMC) {
        this.CLMC = CLMC;
    }

    public String getYYCLBM() {
        return YYCLBM;
    }

    public void setYYCLBM(String YYCLBM) {
        this.YYCLBM = YYCLBM;
    }

    public String getCLGG() {
        return CLGG;
    }

    public void setCLGG(String CLGG) {
        this.CLGG = CLGG;
    }

    public String getCLSL() {
        return CLSL;
    }

    public void setCLSL(String CLSL) {
        this.CLSL = CLSL;
    }

    public String getCLSLDW() {
        return CLSLDW;
    }

    public void setCLSLDW(String CLSLDW) {
        this.CLSLDW = CLSLDW;
    }

    public String getCLDJ() {
        return CLDJ;
    }

    public void setCLDJ(String CLDJ) {
        this.CLDJ = CLDJ;
    }
}
