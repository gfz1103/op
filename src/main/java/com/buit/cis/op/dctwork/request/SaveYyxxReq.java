package com.buit.cis.op.dctwork.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * @ClassName SaveYyxxReq
 * @Description 保存诊间预约信息-请求
 * @Author 老花生
 * @Date 2020/7/14 20:46
 */
@ApiModel(value="保存诊间预约信息-请求")
public class SaveYyxxReq {
    @ApiModelProperty(value="挂号科室")
    private Integer ksdm;
    @ApiModelProperty(value="预约日期")
    private Date yyrq;
    @ApiModelProperty(value="病人id")
    private Integer brid;
    @ApiModelProperty(value="值班类别")
    private Integer zblb;
    @NotNull
    @ApiModelProperty(value="识别序号")
    private Integer sbxh;
    @ApiModelProperty(value="预约时间")
    private String yysj;
    @ApiModelProperty(value="卡号")
    private String jzkh;
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Date getYyrq() {
        return yyrq;
    }

    public void setYyrq(Date yyrq) {
        this.yyrq = yyrq;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getZblb() {
        return zblb;
    }

    public void setZblb(Integer zblb) {
        this.zblb = zblb;
    }

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public String getYysj() {
        return yysj;
    }

    public void setYysj(String yysj) {
        this.yysj = yysj;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }
}
