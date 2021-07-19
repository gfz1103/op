package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName QueryCfAllYpxxResp
 * @Description 查询处方全部药品-返回
 * @Author 老花生
 * @Date 2020/7/15 15:47
 */
@ApiModel(value="查询处方全部药品-返回")
public class QueryCfAllYpxxResp {
    @ApiModelProperty(value="药品序号")
    private String ypxh;
    @ApiModelProperty(value="药品规格")
    private String yfgg;
    @ApiModelProperty(value="单位")
    private String yfdw;
    @ApiModelProperty(value="名称")
    private String ypmc;
    @ApiModelProperty(value="账簿类别,对应DIC_SFXMLB的 SFXM")
    private String zblb;

    public String getYpxh() {
        return ypxh;
    }

    public void setYpxh(String ypxh) {
        this.ypxh = ypxh;
    }

    public String getYfgg() {
        return yfgg;
    }

    public void setYfgg(String yfgg) {
        this.yfgg = yfgg;
    }

    public String getYfdw() {
        return yfdw;
    }

    public void setYfdw(String yfdw) {
        this.yfdw = yfdw;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getZblb() {
        return zblb;
    }

    public void setZblb(String zblb) {
        this.zblb = zblb;
    }
}
