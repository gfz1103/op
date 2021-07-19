package com.buit.commons.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：DrugsCdybxx<br> 
 * 类描述：药品产地医保信息
 * @author 老花生 
 * @ApiModel(value="药品产地医保信息")
 */
public class DrugsCdybxx  extends  PageQuery{
	//@ApiModelProperty(value="识别序号")
    /** 识别序号 */
    private Integer sbxh;
	//@ApiModelProperty(value="药品序号")
    /** 药品序号 */
    private Integer ypxh;
	//@ApiModelProperty(value="药品产地")
    /** 药品产地 */
    private Integer ypcd;
	//@ApiModelProperty(value="医保编码")
    /** 医保编码 */
    private String ybbm;
	//@ApiModelProperty(value="医保药品名称")
    /** 医保药品名称 */
    private String ybmc;
	//@ApiModelProperty(value="医品规格")
    /** 医品规格 */
    private String ybgg;
	//@ApiModelProperty(value="医品单位")
    /** 医品单位 */
    private String ybdw;
	//@ApiModelProperty(value="医品商品名称")
    /** 医品商品名称 */
    private String ybspmc;
	//@ApiModelProperty(value="启用标志")
    /** 启用标志 */
    private String qybz;
	//@ApiModelProperty(value="启用日期")
    /** 启用日期 */
    private Timestamp qyrq;
	//@ApiModelProperty(value="结束日期")
    /** 结束日期 */
    private Timestamp jsrq;

    /** 设置:识别序号  */
    public void setSbxh(Integer value) {
        this.sbxh = value;
    }
    /** 获取:识别序号 */
    public Integer getSbxh() {
        return sbxh;
    }

    /** 设置:药品序号  */
    public void setYpxh(Integer value) {
        this.ypxh = value;
    }
    /** 获取:药品序号 */
    public Integer getYpxh() {
        return ypxh;
    }

    /** 设置:药品产地  */
    public void setYpcd(Integer value) {
        this.ypcd = value;
    }
    /** 获取:药品产地 */
    public Integer getYpcd() {
        return ypcd;
    }

    /** 设置:医保编码  */
    public void setYbbm(String value) {
        this.ybbm = value;
    }
    /** 获取:医保编码 */
    public String getYbbm() {
        return ybbm;
    }

    /** 设置:医保药品名称  */
    public void setYbmc(String value) {
        this.ybmc = value;
    }
    /** 获取:医保药品名称 */
    public String getYbmc() {
        return ybmc;
    }

    /** 设置:医品规格  */
    public void setYbgg(String value) {
        this.ybgg = value;
    }
    /** 获取:医品规格 */
    public String getYbgg() {
        return ybgg;
    }

    /** 设置:医品单位  */
    public void setYbdw(String value) {
        this.ybdw = value;
    }
    /** 获取:医品单位 */
    public String getYbdw() {
        return ybdw;
    }

    /** 设置:医品商品名称  */
    public void setYbspmc(String value) {
        this.ybspmc = value;
    }
    /** 获取:医品商品名称 */
    public String getYbspmc() {
        return ybspmc;
    }

    /** 设置:启用标志  */
    public void setQybz(String value) {
        this.qybz = value;
    }
    /** 获取:启用标志 */
    public String getQybz() {
        return qybz;
    }

    /** 设置:启用日期  */
    public void setQyrq(Timestamp value) {
        this.qyrq = value;
    }
    /** 获取:启用日期 */
    public Timestamp getQyrq() {
        return qyrq;
    }

    /** 设置:结束日期  */
    public void setJsrq(Timestamp value) {
        this.jsrq = value;
    }
    /** 获取:结束日期 */
    public Timestamp getJsrq() {
        return jsrq;
    }


}
