package com.buit.commons.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName MzCfGetPayProportionReq
 * @Description 门诊处方-获取费用自负比例
 * @Author 老花生
 * @Date 2020/6/18 16:35
 */
public class MzCfGetPayProportionReq {
    @ApiModelProperty(value="药品传药品类型1,2,3,费用传0")
    private String type;
    @ApiModelProperty(value="费用序号")
    private String fyxh;
    @ApiModelProperty(value="费用归并")
    private String fygb;
    @ApiModelProperty(value="病人性质")
    private String brxz;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFyxh() {
        return fyxh;
    }

    public void setFyxh(String fyxh) {
        this.fyxh = fyxh;
    }

    public String getFygb() {
        return fygb;
    }

    public void setFygb(String fygb) {
        this.fygb = fygb;
    }

    public String getBrxz() {
        return brxz;
    }

    public void setBrxz(String brxz) {
        this.brxz = brxz;
    }
}
