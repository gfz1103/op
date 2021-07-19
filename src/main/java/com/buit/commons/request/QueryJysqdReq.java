package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * @Author weijing
 * @Date 2021-01-15 14:32
 * @Description
 **/
@ApiModel("检验申请单查询入参")
public class QueryJysqdReq {
    @ApiModelProperty("申请医生代码")
    private Integer ysdm;

    @ApiModelProperty("就诊序号")
    private Integer jzxh;

    @ApiModelProperty("申请日期-开始(YYYY-MM-dd)")
    private Date kdrq_begin;

    @ApiModelProperty("申请日期-结束(YYYY-MM-dd)")
    private Date kdrq_end;

    @ApiModelProperty(value = "机构id",hidden = true)
    private Integer jgid;

    public Integer getYsdm() {
        return ysdm;
    }

    public void setYsdm(Integer ysdm) {
        this.ysdm = ysdm;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

    public Date getKdrq_begin() {
        return kdrq_begin;
    }

    public void setKdrq_begin(Date kdrq_begin) {
        this.kdrq_begin = kdrq_begin;
    }

    public Date getKdrq_end() {
        return kdrq_end;
    }

    public void setKdrq_end(Date kdrq_end) {
        this.kdrq_end = kdrq_end;
    }
}
