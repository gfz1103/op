package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName SaveInitClinicInfoReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/6/22 11:05
 */
@ApiModel(value="选择病人后，初始化病人就诊信息-查询")
public class SaveInitClinicInfoReq {
    @ApiModelProperty(value="挂号科室")
    private Integer ghks;
    @ApiModelProperty(value="门诊科室")
    private Integer mzks;
    @ApiModelProperty(value="病人id")
    private Integer brid;
    @ApiModelProperty(value="挂号明细表的识别序号")
    private Integer sbxh;
    @ApiModelProperty(value="病人性质")
    private Integer brxz;
    @ApiModelProperty(value="挂号类别")
    private Integer ghlb;
    @ApiModelProperty(value="")
    private String updatingDoctor;
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;
    @ApiModelProperty(value="CA登录ID")
    private String bizsn;

    public String getBizsn() {
        return bizsn;
    }

    public void setBizsn(String bizsn) {
        this.bizsn = bizsn;
    }

    public Integer getGhks() {
        return ghks;
    }

    public void setGhks(Integer ghks) {
        this.ghks = ghks;
    }

    public Integer getMzks() {
        return mzks;
    }

    public void setMzks(Integer mzks) {
        this.mzks = mzks;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }

    public Integer getGhlb() {
        return ghlb;
    }

    public void setGhlb(Integer ghlb) {
        this.ghlb = ghlb;
    }

    public String getUpdatingDoctor() {
        return updatingDoctor;
    }

    public void setUpdatingDoctor(String updatingDoctor) {
        this.updatingDoctor = updatingDoctor;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }
}
