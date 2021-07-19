
package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DrugsTypk<br>
 * 类描述：药库_药品基本库分页信息<br>
 * @author "MLeo"
 */
@ApiModel(value="药库_药品基本库分页信息")
public class DrugsTypkPackagePageResp {
    @ApiModelProperty(value="药品序号 | 本代码为内部代码，用户不可见")
    private Integer ypxh;
    @ApiModelProperty(value="药品名称")
    private String ypmc;

    @ApiModelProperty(value="药品规格")
    private String ypgg;
    @ApiModelProperty(value="药品单位")
    private String ypdw;

    @ApiModelProperty(value="最小单位")
    private String zxdw;
    @ApiModelProperty(value="最小包装数量")
    private Integer zxbz;
    @ApiModelProperty(value="药房单位")
    private String yfdw;
    @ApiModelProperty(value="药房包装数量")
    private Integer yfbz;
    @ApiModelProperty(value="病区单位")
    private String bfdw;
    @ApiModelProperty(value="病区包装数量")
    private Integer bfbz;

    @ApiModelProperty(value="作废判别:0、为作废 1、作废")
    private Integer zfpb;

    public Integer getYpxh() {
        return ypxh;
    }

    public void setYpxh(Integer ypxh) {
        this.ypxh = ypxh;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getYpgg() {
        return ypgg;
    }

    public void setYpgg(String ypgg) {
        this.ypgg = ypgg;
    }

    public String getYpdw() {
        return ypdw;
    }

    public void setYpdw(String ypdw) {
        this.ypdw = ypdw;
    }

    public String getZxdw() {
        return zxdw;
    }

    public void setZxdw(String zxdw) {
        this.zxdw = zxdw;
    }

    public Integer getZxbz() {
        return zxbz;
    }

    public void setZxbz(Integer zxbz) {
        this.zxbz = zxbz;
    }

    public String getYfdw() {
        return yfdw;
    }

    public void setYfdw(String yfdw) {
        this.yfdw = yfdw;
    }

    public Integer getYfbz() {
        return yfbz;
    }

    public void setYfbz(Integer yfbz) {
        this.yfbz = yfbz;
    }

    public String getBfdw() {
        return bfdw;
    }

    public void setBfdw(String bfdw) {
        this.bfdw = bfdw;
    }

    public Integer getBfbz() {
        return bfbz;
    }

    public void setBfbz(Integer bfbz) {
        this.bfbz = bfbz;
    }

    public Integer getZfpb() {
        return zfpb;
    }

    public void setZfpb(Integer zfpb) {
        this.zfpb = zfpb;
    }
}
