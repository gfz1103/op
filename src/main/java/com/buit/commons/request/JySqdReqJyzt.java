package com.buit.commons.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckInventoryReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/9/21 10:16
 */
public class JySqdReqJyzt {
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @ApiModelProperty(value="组套名称")
    private String ztmc;

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
    }

    public String getZtmc() {
        return ztmc;
    }

    public void setZtmc(String ztmc) {
        this.ztmc = ztmc;
    }
}
