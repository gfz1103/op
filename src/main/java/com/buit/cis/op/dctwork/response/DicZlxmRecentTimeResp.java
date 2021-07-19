
package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;


/**
 * 类名称：DicZlxmRecentTimeResp<br>
 * 类描述：查询设备指定日期最近的号源-返回<br>
 * @author 老花生
 */
@ApiModel(value="查询设备指定日期最近的号源-返回")
public class DicZlxmRecentTimeResp {

    @ApiModelProperty(value="号源ID")
    private Integer hyid;
    @ApiModelProperty(value="号源日期")
    private Timestamp hyrq;
    @ApiModelProperty(value="号源时间")
    private String hysj;
    @ApiModelProperty(value="号源ID")
    private String bhid;
    @ApiModelProperty(value="设备编号")
    private String sbbh;
    @ApiModelProperty(value="设备名称")
    private String sbmc;
    @ApiModelProperty(value="设备地址")
    private String sbdz;

    public Integer getHyid() {
        return hyid;
    }

    public void setHyid(Integer hyid) {
        this.hyid = hyid;
    }

    public Timestamp getHyrq() {
        return hyrq;
    }

    public void setHyrq(Timestamp hyrq) {
        this.hyrq = hyrq;
    }

    public String getHysj() {
        return hysj;
    }

    public void setHysj(String hysj) {
        this.hysj = hysj;
    }

    public String getBhid() {
        return bhid;
    }

    public void setBhid(String bhid) {
        this.bhid = bhid;
    }

    public String getSbbh() {
        return sbbh;
    }

    public void setSbbh(String sbbh) {
        this.sbbh = sbbh;
    }

    public String getSbmc() {
        return sbmc;
    }

    public void setSbmc(String sbmc) {
        this.sbmc = sbmc;
    }

    public String getSbdz() {
        return sbdz;
    }

    public void setSbdz(String sbdz) {
        this.sbdz = sbdz;
    }
}
