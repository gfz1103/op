package com.buit.commons.request;//


import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;


/**
 * 类名称：MpiPsxx<br>
 * 类描述：互联网医院配送信息表<br>
 * @author DESKTOP-1OEG1QM
 */
@ApiModel(value="互联网医院配送信息表")
public class MpPsxxReq extends  PageQuery{
    @ApiModelProperty(value="主键ID")
    private Integer id;
    @ApiModelProperty(value="关键字搜索")
    private String keyword;
    @ApiModelProperty(value="机构ID", hidden = true)
    private String jgid;
    @ApiModelProperty(value="配送状态")
    private String pszt;
    @ApiModelProperty(value="开始时间")
    private String beginDay;
    @ApiModelProperty(value="结束时间")
    private String endDay;
    @ApiModelProperty(value="派件员")
    private String pjy;
    @ApiModelProperty(value="派件员电话")
    private String pjydh;
    @ApiModelProperty(value="快递公司")
    private String kdgs;
    @ApiModelProperty(value="快递单号")
    private String kddh;
    @ApiModelProperty(value="预计到达时间")
    private String yjddsj;
    @ApiModelProperty(value="备注信息")
    private String bz;
    @ApiModelProperty(value="修改时间", hidden = true)
    private Timestamp xgsj;
    @ApiModelProperty(value="配送开始时间")
    private String kssj;
    @ApiModelProperty(value="配送结束时间")
    private String jssj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJgid() {
        return jgid;
    }

    public void setJgid(String jgid) {
        this.jgid = jgid;
    }

    public String getPszt() {
        return pszt;
    }

    public void setPszt(String pszt) {
        this.pszt = pszt;
    }

    public String getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(String beginDay) {
        this.beginDay = beginDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getPjy() {
        return pjy;
    }

    public void setPjy(String pjy) {
        this.pjy = pjy;
    }

    public String getPjydh() {
        return pjydh;
    }

    public void setPjydh(String pjydh) {
        this.pjydh = pjydh;
    }

    public String getKdgs() {
        return kdgs;
    }

    public void setKdgs(String kdgs) {
        this.kdgs = kdgs;
    }

    public String getKddh() {
        return kddh;
    }

    public void setKddh(String kddh) {
        this.kddh = kddh;
    }

    public String getYjddsj() {
        return yjddsj;
    }

    public void setYjddsj(String yjddsj) {
        this.yjddsj = yjddsj;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }


    public Timestamp getXgsj() {
        return xgsj;
    }

    public void setXgsj(Timestamp xgsj) {
        this.xgsj = xgsj;
    }

    public String getKssj() {
        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    public String getJssj() {
        return jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}