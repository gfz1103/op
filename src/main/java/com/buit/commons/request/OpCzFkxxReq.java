package com.buit.commons.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;


public class OpCzFkxxReq extends PageQuery {
    @ApiModelProperty(value = "机构代码", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value = "票据起始号码")
    private String beginPjhm;
    @ApiModelProperty(value = "票据结束号码")
    private String endPjhm;
    @ApiModelProperty(value = "开始充值日期")
    private Date beginCzrq;
    @ApiModelProperty(value = "结束充值日期")
    private Date endCzrq;
    @ApiModelProperty(value = "病人性质")
    private Integer brxz;
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
    @ApiModelProperty(value = "就诊卡号")
    private String jzkh;
    @ApiModelProperty(value = "操作工号")
    private Integer czgh;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getBeginPjhm() {
        return beginPjhm;
    }

    public void setBeginPjhm(String beginPjhm) {
        this.beginPjhm = beginPjhm;
    }

    public String getEndPjhm() {
        return endPjhm;
    }

    public void setEndPjhm(String endPjhm) {
        this.endPjhm = endPjhm;
    }

    public Date getBeginCzrq() {
        return beginCzrq;
    }

    public void setBeginCzrq(Date beginCzrq) {
        this.beginCzrq = beginCzrq;
    }

    public Date getEndCzrq() {
        return endCzrq;
    }

    public void setEndCzrq(Date endCzrq) {
        this.endCzrq = endCzrq;
    }

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public Integer getCzgh() {
        return czgh;
    }

    public void setCzgh(Integer czgh) {
        this.czgh = czgh;
    }
}
