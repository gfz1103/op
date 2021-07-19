package com.buit.commons.request;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName SaveAppointedInfomationReq
 * @Description 保存预约挂号-请求
 * @Author 老花生
 * @Date 2020/7/6 10:30
 */
@ApiModel(value="保存预约挂号-请求")
public class SaveAppointedInfomationReq {
    @NotNull(message = "挂号科室 不能为空")
    @ApiModelProperty(value="挂号科室")
    private Integer ksdm;
    @ApiModelProperty(value="医生代码")
    private String ysdm;
    @NotNull(message = "病人id 不能为空")
    @ApiModelProperty(value="病人id")
    private Integer brid;
    @NotNull(message = "预约日期 不能为空")
    @ApiModelProperty(value="预约日期")
    private Date yyrq;
    @ApiModelProperty(value="挂号标志")
    private Integer ghbz;
    @NotNull(message = "值班类别 不能为空")
    @ApiModelProperty(value="值班类别")
    private String zblb;
    @ApiModelProperty(value="挂号时间")
    private Timestamp ghsj;
    @ApiModelProperty(value="诊室ID")
    private String zsid;
    @NotNull(message = "卡号 不能为空")
    @ApiModelProperty(value="卡号")
    private String cardno;
    @ApiModelProperty(value="预约类型：1电话预约、2微信预约、3app预约、4诊间预约、9其他（字典：YY000001）")
    private String yylx;
    @ApiModelProperty(value="预约备注")
    private String yybz;

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public String getYsdm() {
        return ysdm;
    }

    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Date getYyrq() {
        return yyrq;
    }

    public void setYyrq(Date yyrq) {
        this.yyrq = yyrq;
    }

    public Integer getGhbz() {
        return ghbz;
    }

    public void setGhbz(Integer ghbz) {
        this.ghbz = ghbz;
    }

    public String getZblb() {
        return zblb;
    }

    public void setZblb(String zblb) {
        this.zblb = zblb;
    }

    public Timestamp getGhsj() {
        return ghsj;
    }

    public void setGhsj(Timestamp ghsj) {
        this.ghsj = ghsj;
    }

    public String getZsid() {
        return zsid;
    }

    public void setZsid(String zsid) {
        this.zsid = zsid;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getYylx() {
        return yylx;
    }

    public void setYylx(String yylx) {
        this.yylx = yylx;
    }

    public String getYybz() {
        return yybz;
    }

    public void setYybz(String yybz) {
        this.yybz = yybz;
    }
}
