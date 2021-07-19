package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("医生工作量统计响应")
public class WorkloadAccountForYSResp {
    @ApiModelProperty("医生代码")
    private Integer ysdm;

    @ApiModelProperty("医生工号")
    private String ysgh;

    @ApiModelProperty("医生姓名")
    private String ysxm;

    @ApiModelProperty("科室代码")
    private Integer ksdm;

    @ApiModelProperty("科室名称")
    private String ksmc;

    @ApiModelProperty("诊疗人数")
    private String zlrs;

    public Integer getYsdm() {
        return ysdm;
    }

    public void setYsdm(Integer ysdm) {
        this.ysdm = ysdm;
    }

    public String getYsgh() {
        return ysgh;
    }

    public void setYsgh(String ysgh) {
        this.ysgh = ysgh;
    }

    public String getYsxm() {
        return ysxm;
    }

    public void setYsxm(String ysxm) {
        this.ysxm = ysxm;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public String getZlrs() {
        return zlrs;
    }

    public void setZlrs(String zlrs) {
        this.zlrs = zlrs;
    }
}
