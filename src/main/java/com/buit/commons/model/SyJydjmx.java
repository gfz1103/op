package com.buit.commons.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SyJydjmx<br>
 * 类描述：输液/注射接药登记明细表
 * @author sunjx
 */
public class SyJydjmx extends PageQuery {

	//医疗机构代码
    private Integer jgid;

	//输液科室代码
    private Integer ksdm;

	//登记单号
    private String djdh;

	//输液/注射序号
    private Integer xh;

	//处方号
    private Integer cfhm;

	//处方组号
    private Integer cfzh;

	//药品序号
    private Integer ypxh;

	//门诊号码
    private Integer mzhm;

	//发票号码
    private String fphm;

	//输液条码
    private String sytm;

    @ApiModelProperty(value = "开始时间")
    private Timestamp beginDay;
    @ApiModelProperty(value = "结束时间")
    private Timestamp endDay;
    @ApiModelProperty(value = "科室类别 1:输液室  2:注射室")
    private String kslb;


    public void setJgid(Integer value) {
        this.jgid = value;
    }
    public Integer getJgid() {
        return jgid;
    }

    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    public Integer getKsdm() {
        return ksdm;
    }

    public void setDjdh(String value) {
        this.djdh = value;
    }
    public String getDjdh() {
        return djdh;
    }

    public void setXh(Integer value) {
        this.xh = value;
    }
    public Integer getXh() {
        return xh;
    }

    public void setCfhm(Integer value) {
        this.cfhm = value;
    }
    public Integer getCfhm() {
        return cfhm;
    }

    public void setCfzh(Integer value) {
        this.cfzh = value;
    }
    public Integer getCfzh() {
        return cfzh;
    }

    public void setYpxh(Integer value) {
        this.ypxh = value;
    }
    public Integer getYpxh() {
        return ypxh;
    }

    public void setMzhm(Integer value) {
        this.mzhm = value;
    }
    public Integer getMzhm() {
        return mzhm;
    }

    public void setFphm(String value) {
        this.fphm = value;
    }
    public String getFphm() {
        return fphm;
    }

    public void setSytm(String value) {
        this.sytm = value;
    }
    public String getSytm() {
        return sytm;
    }
    public Timestamp getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(Timestamp beginDay) {
        this.beginDay = beginDay;
    }

    public Timestamp getEndDay() {
        return endDay;
    }

    public void setEndDay(Timestamp endDay) {
        this.endDay = endDay;
    }

    public String getKslb() {
        return kslb;
    }

    public void setKslb(String kslb) {
        this.kslb = kslb;
    }

}