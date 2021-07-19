package com.buit.commons.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckInventoryReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/8/31 16:14
 */

@ApiModel(value="医技打印-请求")
public class YjPrintReq {
    @NotNull(message = "类型默认 不能为空")
    @ApiModelProperty(value="类型默认1")
    private Integer type;
    @NotNull(message = "医技序号 不能为空")
    @ApiModelProperty(value="医技序号")
    private String yjxhList;
    @NotNull(message = "病人id 不能为空")
    @ApiModelProperty(value="病人id")
    private Integer brid;
    @NotNull(message = "就诊序号 不能为空")
    @ApiModelProperty(value="就诊序号")
    private Integer jzxh;
    @ApiModelProperty(value="费用序号")
    private Integer fyxh;
    @ApiModelProperty(value="组套医技序号")
    private Integer ztYjxh;
    @ApiModelProperty(value="机构ID", hidden = true)
    private Integer jgid;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getYjxhList() {
        return yjxhList;
    }

    public void setYjxhList(String yjxhList) {
        this.yjxhList = yjxhList;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }

    public Integer getZtYjxh() {
        return ztYjxh;
    }

    public void setZtYjxh(Integer ztYjxh) {
        this.ztYjxh = ztYjxh;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }
}
