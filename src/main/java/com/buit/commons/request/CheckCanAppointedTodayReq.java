package com.buit.commons.request;

import java.sql.Date;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckCanAppointedTodayReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/6/30 10:09
 */
public class CheckCanAppointedTodayReq {
    @ApiModelProperty(value="预约实际")
    private Date yyrq;
    @ApiModelProperty(value="病人id")
    private Integer brid;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="挂号时间")
    private Timestamp ghsj;

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Date getYyrq() {
        return yyrq;
    }

    public void setYyrq(Date yyrq) {
        this.yyrq = yyrq;
    }

    public Timestamp getGhsj() {
        return ghsj;
    }

    public void setGhsj(Timestamp ghsj) {
        this.ghsj = ghsj;
    }
}
