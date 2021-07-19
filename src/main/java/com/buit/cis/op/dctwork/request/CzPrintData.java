package com.buit.cis.op.dctwork.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author weijing
 * @Date 2021-04-23 13:27
 * @Description
 **/
@ApiModel(value = "需要打印的数据集合")
public class CzPrintData {
    @ApiModelProperty("识别序号")
    private Integer sbxh;

    @ApiModelProperty("组套识别序号")
    private Integer ztsbxh;

    @ApiModelProperty("组套标志 1是 0 否")
    private Integer ztbz;

    @ApiModelProperty("组号")
    private Integer yjzh;

    @ApiModelProperty(value = "项目名称")
    private String xmmc;

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public Integer getZtsbxh() {
        return ztsbxh;
    }

    public void setZtsbxh(Integer ztsbxh) {
        this.ztsbxh = ztsbxh;
    }

    public Integer getZtbz() {
        return ztbz;
    }

    public void setZtbz(Integer ztbz) {
        this.ztbz = ztbz;
    }

    public Integer getYjzh() {
        return yjzh;
    }

    public void setYjzh(Integer yjzh) {
        this.yjzh = yjzh;
    }
}
