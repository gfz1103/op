package com.buit.cis.op.dctwork.ybtspost.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author weijing
 * @Date 2021-04-08 10:17
 * @Description
 **/
@ApiModel(value = "4.1门诊就诊")
public class MzjzMain {
    @ApiModelProperty(value = "触发点代码")
    private String CFDDM;

    @ApiModelProperty(value = "证件号码")
    private String ZJHM;

    @ApiModelProperty(value = "姓名")
    private String XM;

    @ApiModelProperty(value = "性别")
    private String XB;

    @ApiModelProperty(value = "名族")
    private String MZ;

    @ApiModelProperty(value = "出生日期 格式：YYYYMMDD 必须8位")
    private String CSRQ;

    @ApiModelProperty(value = "婚姻状况")
    private String HYZK;

    @ApiModelProperty(value = "固定联系电话")
    private String GDLXDH;

    @ApiModelProperty(value = "移动联系电话")
    private String YDLXDH;

    @ApiModelProperty(value = "户籍地址")
    private String HJDZ;

    @ApiModelProperty(value = "居住地址")
    private String JZDZ;

    @ApiModelProperty(value = "卡号")
    private String KH;

    @ApiModelProperty(value = "卡类型")
    private String KLX;

    @ApiModelProperty(value = "医疗机构代码")
    private String YLJGDM;

    @ApiModelProperty(value = "就诊类型")
    private String JZLX;

    @ApiModelProperty(value = "门诊号")
    private String MZH;

    @ApiModelProperty(value = "住院号")
    private String ZHH;

    @ApiModelProperty(value = "医院科室编码")
    private String YYKSBM;

    @ApiModelProperty(value = "医院科室名称")
    private String YYKSMC;

    @ApiModelProperty(value = "医院医生工号")
    private String YYYSGH;

    @ApiModelProperty(value = "医保医生工号")
    private String YBYSGH;

    @ApiModelProperty(value = "医生姓名")
    private String YSXM;

    @ApiModelProperty(value = "操作设备IP地址")
    private String AGENTIP;

    @ApiModelProperty(value = "操作设备 MAC地址")
    private String AGENTMAC;

    @ApiModelProperty(value = "主诉")
    private String ZS;

    @ApiModelProperty(value = "临床表现")
    private String LCBX;

    @ApiModelProperty(value = "收缩压")
    private String SSY;

    @ApiModelProperty(value = "舒张压")
    private String SZY;

    @ApiModelProperty(value = "是否首次发现血压异常 1=是 2=否")
    private String SFSCXYYC;

    public String getCFDDM() {
        return CFDDM;
    }

    public void setCFDDM(String CFDDM) {
        this.CFDDM = CFDDM;
    }

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

    public String getAGENTIP() {
        return AGENTIP;
    }

    public void setAGENTIP(String AGENTIP) {
        this.AGENTIP = AGENTIP;
    }

    public String getAGENTMAC() {
        return AGENTMAC;
    }

    public void setAGENTMAC(String AGENTMAC) {
        this.AGENTMAC = AGENTMAC;
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
