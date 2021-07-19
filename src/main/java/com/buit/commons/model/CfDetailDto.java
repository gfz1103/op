package com.buit.commons.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/5/25 11:11
 */
@ApiModel("CfDetailDto")
public class CfDetailDto {

    @ApiModelProperty("病人姓名")
    private String brxm;
    @ApiModelProperty("发票号码")
    private String fphm;
    @ApiModelProperty("处方识别")
    private Integer cfsb;
    @ApiModelProperty("发药标志")
    private Integer fybz;
    @ApiModelProperty("处方贴数")
    private Integer cfts;
    @ApiModelProperty("病人id")
    private Integer brid;
    @ApiModelProperty("医生姓名")
    private String ysxm;
    @ApiModelProperty("医生代码")
    private String ysdm;
    @ApiModelProperty("处方号码")
    private String cfhm;

    @ApiModelProperty("开方日期")
    private Timestamp kfrq;
    @ApiModelProperty("配药工号")
    private String pygh;
    @ApiModelProperty("发药日期")
    private Timestamp fyrq;
    @ApiModelProperty("发药工号,字典:sys_dict_config:17")
    private String fygh;

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public Integer getCfsb() {
        return cfsb;
    }

    public void setCfsb(Integer cfsb) {
        this.cfsb = cfsb;
    }

    public Integer getFybz() {
        return fybz;
    }

    public void setFybz(Integer fybz) {
        this.fybz = fybz;
    }

    public Integer getCfts() {
        return cfts;
    }

    public void setCfts(Integer cfts) {
        this.cfts = cfts;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public String getYsxm() {
        return ysxm;
    }

    public void setYsxm(String ysxm) {
        this.ysxm = ysxm;
    }

    public String getYsdm() {
        return ysdm;
    }

    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }

    public String getCfhm() {
        return cfhm;
    }

    public void setCfhm(String cfhm) {
        this.cfhm = cfhm;
    }

    public Timestamp getKfrq() {
        return kfrq;
    }

    public void setKfrq(Timestamp kfrq) {
        this.kfrq = kfrq;
    }

    public String getPygh() {
        return pygh;
    }

    public void setPygh(String pygh) {
        this.pygh = pygh;
    }

    public Timestamp getFyrq() {
        return fyrq;
    }

    public void setFyrq(Timestamp fyrq) {
        this.fyrq = fyrq;
    }

    public String getFygh() {
        return fygh;
    }

    public void setFygh(String fygh) {
        this.fygh = fygh;
    }
}
