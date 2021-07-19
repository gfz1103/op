package com.buit.commons.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckInventoryReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/9/21 10:17
 */
public class JySqdReqXmDetail {
    @ApiModelProperty(value="费用单价")
    private Integer fydj;
    @ApiModelProperty(value="医嘱名称")
    private String yzmc;
    @ApiModelProperty(value="项目编号")
    private Integer xmbh;
    @ApiModelProperty(value="记录编号")
    private Integer jlbh;
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @ApiModelProperty(value="费用数量")
    private Integer fysl;

    public Integer getFydj() {
        return fydj;
    }

    public void setFydj(Integer fydj) {
        this.fydj = fydj;
    }

    public String getYzmc() {
        return yzmc;
    }

    public void setYzmc(String yzmc) {
        this.yzmc = yzmc;
    }

    public Integer getXmbh() {
        return xmbh;
    }

    public void setXmbh(Integer xmbh) {
        this.xmbh = xmbh;
    }

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
    }

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
    }

    public Integer getFysl() {
        return fysl;
    }

    public void setFysl(Integer fysl) {
        this.fysl = fysl;
    }
}
