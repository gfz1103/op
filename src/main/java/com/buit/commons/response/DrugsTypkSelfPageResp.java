
package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DrugsTypk<br>
 * 类描述：药库_药品基本库分页信息<br>
 * @author "MLeo"
 */
@ApiModel(value="药库_药品基本库分页信息")
public class DrugsTypkSelfPageResp {
    @ApiModelProperty(value="药品序号 | 本代码为内部代码，用户不可见")
    private Integer ypxh;
    @ApiModelProperty(value="本地药品编码")
    private String ypbm;

    @ApiModelProperty(value="药品名称")
    private String ypmc;

    @ApiModelProperty(value="药品规格")
    private String ypgg;
    @ApiModelProperty(value="药品单位")
    private String ypdw;

    @ApiModelProperty(value="药品类别 | 1：西药 2：中成药 3：中草药")
    private Integer type;
    @ApiModelProperty(value="药品属性 | 剂型代码 对应DRUGS_YPSX.YPSX的代码")
    private Integer ypsx;

    @ApiModelProperty(value="拼音码")
    private String pydm;
    @ApiModelProperty(value="五笔码")
    private String wbdm;
    @ApiModelProperty(value="角形码")
    private String jxdm;
    @ApiModelProperty(value="笔画码")
    private String bhdm;

    @ApiModelProperty(value="特殊药品-指定药品 | 对应GY_DMZD（DMSB=16）对应 1——麻醉、2——精神、3——贵重")
    private Integer tsyp;
    @ApiModelProperty(value="药品费别")
    private Integer ypfb;

    @ApiModelProperty(value="橱柜号")
    private String cgh;
    @ApiModelProperty(value="作废判别:0、为作废 1、作废")
    private Integer zfpb;
    @ApiModelProperty(value="处方类型=type药品类别 | 1：西药 2：中成药 3：中草药")
    private Integer cflx;

    @ApiModelProperty(value="药品代码")
    private String ypdm;

    public Integer getYpxh() {
        return ypxh;
    }

    public void setYpxh(Integer ypxh) {
        this.ypxh = ypxh;
    }

    public String getYpbm() {
        return ypbm;
    }

    public void setYpbm(String ypbm) {
        this.ypbm = ypbm;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getYpsx() {
        return ypsx;
    }

    public void setYpsx(Integer ypsx) {
        this.ypsx = ypsx;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }

    public String getWbdm() {
        return wbdm;
    }

    public void setWbdm(String wbdm) {
        this.wbdm = wbdm;
    }

    public String getJxdm() {
        return jxdm;
    }

    public void setJxdm(String jxdm) {
        this.jxdm = jxdm;
    }

    public String getBhdm() {
        return bhdm;
    }

    public void setBhdm(String bhdm) {
        this.bhdm = bhdm;
    }

    public Integer getTsyp() {
        return tsyp;
    }

    public void setTsyp(Integer tsyp) {
        this.tsyp = tsyp;
    }

    public Integer getYpfb() {
        return ypfb;
    }

    public void setYpfb(Integer ypfb) {
        this.ypfb = ypfb;
    }

    public String getCgh() {
        return cgh;
    }

    public void setCgh(String cgh) {
        this.cgh = cgh;
    }

    public Integer getZfpb() {
        return zfpb;
    }

    public void setZfpb(Integer zfpb) {
        this.zfpb = zfpb;
    }

    public Integer getCflx() {
        return cflx;
    }

    public void setCflx(Integer cflx) {
        this.cflx = cflx;
    }

    public String getYpdm() {
        return ypdm;
    }

    public void setYpdm(String ypdm) {
        this.ypdm = ypdm;
    }
}
