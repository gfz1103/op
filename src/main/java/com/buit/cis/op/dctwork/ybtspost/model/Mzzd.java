package com.buit.cis.op.dctwork.ybtspost.model;

/**
 * @Author weijing
 * @Date 2021-04-09 18:27
 * @Description
 **/
public class Mzzd {
    /** 诊断编码 **/
    private String ZDBM;

    /** 诊断名称 西医：按统一规定的ICD10字典表执行；中医：按国标-95或国标-97执行。仅填写主要诊断 **/
    private String ZDMC;

    /** 诊断编码类型 01：ICD-10；02：国标-95；03：国标-97 **/
    private String BMLX;

    /** 医嘱 **/
    private String YZ;

    public String getZDBM() {
        return ZDBM;
    }

    public void setZDBM(String ZDBM) {
        this.ZDBM = ZDBM;
    }

    public String getZDMC() {
        return ZDMC;
    }

    public void setZDMC(String ZDMC) {
        this.ZDMC = ZDMC;
    }

    public String getBMLX() {
        return BMLX;
    }

    public void setBMLX(String BMLX) {
        this.BMLX = BMLX;
    }

    public String getYZ() {
        return YZ;
    }

    public void setYZ(String YZ) {
        this.YZ = YZ;
    }
}
