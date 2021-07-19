package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName LoadAdditionResp
 * @Description 载入附加项目参数返回
 * @Author 老花生
 * @Date 2020/7/1 14:45
 */
@ApiModel(value="载入附加项目参数返回")
public class LoadAdditionResp {
    @ApiModelProperty(value="识别序号")
    private String sbxh;
    @ApiModelProperty(value="医技组号")
    private String yjzh;
    @ApiModelProperty(value="医技序号")
    private String yjxh;
    @ApiModelProperty(value="附加类别")
    private String ylxh;
    @ApiModelProperty(value="项目名称")
    private String fymc;
    @ApiModelProperty(value="单位")
    private String fydw;
    @ApiModelProperty(value="数量")
    private String ylsl;
    @ApiModelProperty(value="医疗单价")
    private String yldj;
    @ApiModelProperty(value="划价金额")
    private String hjje;
    @ApiModelProperty(value="自负比例")
    private String zfbl;
    @ApiModelProperty(value="药品组号")
    private String ypzh;

    public String getSbxh() {
        return sbxh;
    }

    public void setSbxh(String sbxh) {
        this.sbxh = sbxh;
    }

    public String getYjzh() {
        return yjzh;
    }

    public void setYjzh(String yjzh) {
        this.yjzh = yjzh;
    }

    public String getYjxh() {
        return yjxh;
    }

    public void setYjxh(String yjxh) {
        this.yjxh = yjxh;
    }

    public String getYlxh() {
        return ylxh;
    }

    public void setYlxh(String ylxh) {
        this.ylxh = ylxh;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public String getFydw() {
        return fydw;
    }

    public void setFydw(String fydw) {
        this.fydw = fydw;
    }

    public String getYlsl() {
        return ylsl;
    }

    public void setYlsl(String ylsl) {
        this.ylsl = ylsl;
    }

    public String getYldj() {
        return yldj;
    }

    public void setYldj(String yldj) {
        this.yldj = yldj;
    }

    public String getHjje() {
        return hjje;
    }

    public void setHjje(String hjje) {
        this.hjje = hjje;
    }

    public String getZfbl() {
        return zfbl;
    }

    public void setZfbl(String zfbl) {
        this.zfbl = zfbl;
    }

    public String getYpzh() {
        return ypzh;
    }

    public void setYpzh(String ypzh) {
        this.ypzh = ypzh;
    }
}
