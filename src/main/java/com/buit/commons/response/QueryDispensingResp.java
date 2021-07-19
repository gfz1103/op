package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/5/13 9:57
 */
@ApiModel("QueryDispensingResp")
public class QueryDispensingResp {
    @ApiModelProperty("病人姓名")
    private String brxm;
    @ApiModelProperty("发票号码")
    private String fphm;
    @ApiModelProperty("处方识别")
    private Integer cfsb;
    @ApiModelProperty("虚拟发票")
    private String xnfp;
    @ApiModelProperty("上级发药药房")
    private Integer sjyf;
    @ApiModelProperty("药房识别")
    private Integer yfsb;
    @ApiModelProperty("叫号标志")
    private Integer jhbz;
    @ApiModelProperty("处方号码")
    private String cfhm;
    @ApiModelProperty("处方类型")
    private Integer cflx;
    @ApiModelProperty("收费日期")
    private Timestamp sfrq;
    @ApiModelProperty("叫号号码")
    private Integer jhhm;
    @ApiModelProperty("上级发药机构")
    private String sjjg;
    @ApiModelProperty("上级发药标志")
    private Integer sjfybz;

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

    public String getXnfp() {
        return xnfp;
    }

    public void setXnfp(String xnfp) {
        this.xnfp = xnfp;
    }

    public Integer getSjyf() {
        return sjyf;
    }

    public void setSjyf(Integer sjyf) {
        this.sjyf = sjyf;
    }

    public Integer getYfsb() {
        return yfsb;
    }

    public void setYfsb(Integer yfsb) {
        this.yfsb = yfsb;
    }

    public Integer getJhbz() {
        return jhbz;
    }

    public void setJhbz(Integer jhbz) {
        this.jhbz = jhbz;
    }

    public String getCfhm() {
        return cfhm;
    }

    public void setCfhm(String cfhm) {
        this.cfhm = cfhm;
    }

    public Integer getCflx() {
        return cflx;
    }

    public void setCflx(Integer cflx) {
        this.cflx = cflx;
    }

    public Timestamp getSfrq() {
        return sfrq;
    }

    public void setSfrq(Timestamp sfrq) {
        this.sfrq = sfrq;
    }

    public Integer getJhhm() {
        return jhhm;
    }

    public void setJhhm(Integer jhhm) {
        this.jhhm = jhhm;
    }

    public String getSjjg() {
        return sjjg;
    }

    public void setSjjg(String sjjg) {
        this.sjjg = sjjg;
    }

    public Integer getSjfybz() {
        return sjfybz;
    }

    public void setSjfybz(Integer sjfybz) {
        this.sjfybz = sjfybz;
    }
}
