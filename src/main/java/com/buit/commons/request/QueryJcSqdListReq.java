package com.buit.commons.request;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName QueryJcSqdListReq
 * @Description 查询医技检查申请单列表请求
 * @Author 老花生
 * @Date 2020/7/29 27:23
 */
@ApiModel(value="查询医技检查申请单列表请求")
public class QueryJcSqdListReq {
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="开始时间")
    private Date date;
    @ApiModelProperty(value="结束时间")
    private Date date2;
    @ApiModelProperty(value="编号ID")
    private Integer sbId;
    @ApiModelProperty(value="所属时段")
    private String timeId;

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId) {
        this.timeId = timeId;
    }
}
