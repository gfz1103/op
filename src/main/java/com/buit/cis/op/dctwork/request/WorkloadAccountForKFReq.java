package com.buit.cis.op.dctwork.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * @Author weijing
 * @Date 2021-01-27 09:57
 * @Description
 **/
@ApiModel("客服工作量统计入参")
public class WorkloadAccountForKFReq {
    @ApiModelProperty("客服id")
    private Integer userid;

    @ApiModelProperty("咨询时间开始")
    private Date zxsjks;

    @ApiModelProperty("咨询时间结束")
    private Date zxsjjs;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getZxsjks() {
        return zxsjks;
    }

    public void setZxsjks(Date zxsjks) {
        this.zxsjks = zxsjks;
    }

    public Date getZxsjjs() {
        return zxsjjs;
    }

    public void setZxsjjs(Date zxsjjs) {
        this.zxsjjs = zxsjjs;
    }
}
