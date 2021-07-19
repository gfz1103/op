package com.buit.commons.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckInventoryReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/8/26 10:19
 */
@ApiModel(value="处方--打印--请求")
public class CfPrintReq {
    @NotNull(message = "silentPrint 不能空")
    @ApiModelProperty(value="默认1")
    private Integer silentPrint;
    @NotNull(message = "处方识别 不能空")
    @ApiModelProperty(value="处方识别")
    private Integer cfsb;
    @NotNull(message = "就诊卡号 不能空")
    @ApiModelProperty(value="就诊卡号")
    private String jzkh;
    @NotNull(message = "病人性质 不能空")
    @ApiModelProperty(value="病人性质")
    private Integer brxz;

    public Integer getSilentPrint() {
        return silentPrint;
    }

    public void setSilentPrint(Integer silentPrint) {
        this.silentPrint = silentPrint;
    }

    public Integer getCfsb() {
        return cfsb;
    }

    public void setCfsb(Integer cfsb) {
        this.cfsb = cfsb;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }
}
