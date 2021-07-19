package com.buit.commons.request;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName ModifyAppointedInfoReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/28 16:56
 */

@ApiModel(value="改预约信息")
public class ModifyAppointedInfoReq {

    @ApiModelProperty(value="预约序号")
    private Integer yyxh;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="病人性别")
    private Integer brxb;
    @ApiModelProperty(value="挂号科室")
    private Integer ksdm;
    @ApiModelProperty(value="医生代码")
    private Integer ysdm;
    @ApiModelProperty(value="预约日期")
    private Date yyrq;
    @ApiModelProperty(value="类别")
    private String zblb;
    @ApiModelProperty(value="用户ID", hidden = true)
    private Integer userId;

    public Integer getYyxh() {
        return yyxh;
    }

    public void setYyxh(Integer yyxh) {
        this.yyxh = yyxh;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Integer getBrxb() {
        return brxb;
    }

    public void setBrxb(Integer brxb) {
        this.brxb = brxb;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Integer getYsdm() {
        return ysdm;
    }

    public void setYsdm(Integer ysdm) {
        this.ysdm = ysdm;
    }

    public Date getYyrq() {
        return yyrq;
    }

    public void setYyrq(Date yyrq) {
        this.yyrq = yyrq;
    }

    public String getZblb() {
        return zblb;
    }

    public void setZblb(String zblb) {
        this.zblb = zblb;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
