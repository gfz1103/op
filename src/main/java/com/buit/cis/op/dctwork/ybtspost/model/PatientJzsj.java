package com.buit.cis.op.dctwork.ybtspost.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author weijing
 * @Date 2021-04-09 15:55
 * @Description 患者就诊数据
 **/
public class PatientJzsj {
    @ApiModelProperty(value = "证件号码")
    /**证件号码 **/
    private String ZJHM;
    /**姓名 **/
    private String XM;
    /**性别 **/
    private String XB;
    /**名族 **/
    private String MZ;
    /**出生日期 格式：YYYYMMDD 必须8位 **/
    private String CSRQ;
    /**婚姻状况 **/
    private String HYZK;
    /**固定联系电话 **/
    private String GDLXDH;
    /**移动联系电话 **/
    private String YDLXDH;
    /**户籍地址 **/
    private String HJDZ;
    /**居住地址 **/
    private String JZDZ;
    /**卡号 **/
    private String KH;
    /**卡类型 **/
    private String KLX;
    /**医疗机构代码 **/
    private String YLJGDM;
    /**就诊类型 **/
    private String JZLX;
    /**门诊号 **/
    private String MZH;
    /**住院号 **/
    private String ZHH;
    /**医院科室编码 **/
    private String YYKSBM;
    /**医院科室名称 **/
    private String YYKSMC;
    /**医院医生工号 **/
    private String YYYSGH;
    /**医保医生工号 **/
    private String YBYSGH;
    /**医生姓名 **/
    private String YSXM;
    /**主诉 **/
    private String ZS;
    /**临床表现 **/
    private String LCBX;
    /**收缩压 **/
    private String SSY;
    /**舒张压 **/
    private String SZY;
    /**是否首次发现血压异常 1=是 2=否 **/
    private String SFSCXYYC;

    public String getZJHM() {
        return ZJHM;
    }

    public void setZJHM(String ZJHM) {
        this.ZJHM = ZJHM;
    }

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
    }

    public String getXB() {
        return XB;
    }

    public void setXB(String XB) {
        this.XB = XB;
    }

    public String getMZ() {
        return MZ;
    }

    public void setMZ(String MZ) {
        this.MZ = MZ;
    }

    public String getCSRQ() {
        return CSRQ;
    }

    public void setCSRQ(String CSRQ) {
        this.CSRQ = CSRQ;
    }

    public String getHYZK() {
        return HYZK;
    }

    public void setHYZK(String HYZK) {
        this.HYZK = HYZK;
    }

    public String getGDLXDH() {
        return GDLXDH;
    }

    public void setGDLXDH(String GDLXDH) {
        this.GDLXDH = GDLXDH;
    }

    public String getYDLXDH() {
        return YDLXDH;
    }

    public void setYDLXDH(String YDLXDH) {
        this.YDLXDH = YDLXDH;
    }

    public String getHJDZ() {
        return HJDZ;
    }

    public void setHJDZ(String HJDZ) {
        this.HJDZ = HJDZ;
    }

    public String getJZDZ() {
        return JZDZ;
    }

    public void setJZDZ(String JZDZ) {
        this.JZDZ = JZDZ;
    }

    public String getKH() {
        return KH;
    }

    public void setKH(String KH) {
        this.KH = KH;
    }

    public String getKLX() {
        return KLX;
    }

    public void setKLX(String KLX) {
        this.KLX = KLX;
    }

    public String getYLJGDM() {
        return YLJGDM;
    }

    public void setYLJGDM(String YLJGDM) {
        this.YLJGDM = YLJGDM;
    }

    public String getJZLX() {
        return JZLX;
    }

    public void setJZLX(String JZLX) {
        this.JZLX = JZLX;
    }

    public String getMZH() {
        return MZH;
    }

    public void setMZH(String MZH) {
        this.MZH = MZH;
    }

    public String getZHH() {
        return ZHH;
    }

    public void setZHH(String ZHH) {
        this.ZHH = ZHH;
    }

    public String getYYKSBM() {
        return YYKSBM;
    }

    public void setYYKSBM(String YYKSBM) {
        this.YYKSBM = YYKSBM;
    }

    public String getYYKSMC() {
        return YYKSMC;
    }

    public void setYYKSMC(String YYKSMC) {
        this.YYKSMC = YYKSMC;
    }

    public String getYYYSGH() {
        return YYYSGH;
    }

    public void setYYYSGH(String YYYSGH) {
        this.YYYSGH = YYYSGH;
    }

    public String getYBYSGH() {
        return YBYSGH;
    }

    public void setYBYSGH(String YBYSGH) {
        this.YBYSGH = YBYSGH;
    }

    public String getYSXM() {
        return YSXM;
    }

    public void setYSXM(String YSXM) {
        this.YSXM = YSXM;
    }

    public String getZS() {
        return ZS;
    }

    public void setZS(String ZS) {
        this.ZS = ZS;
    }

    public String getLCBX() {
        return LCBX;
    }

    public void setLCBX(String LCBX) {
        this.LCBX = LCBX;
    }

    public String getSSY() {
        return SSY;
    }

    public void setSSY(String SSY) {
        this.SSY = SSY;
    }

    public String getSZY() {
        return SZY;
    }

    public void setSZY(String SZY) {
        this.SZY = SZY;
    }

    public String getSFSCXYYC() {
        return SFSCXYYC;
    }

    public void setSFSCXYYC(String SFSCXYYC) {
        this.SFSCXYYC = SFSCXYYC;
    }
}
