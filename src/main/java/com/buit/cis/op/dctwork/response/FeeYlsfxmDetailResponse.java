package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Author weijing
 * @Date 2021-04-22 09:21
 * @Description
 **/
@ApiModel(value = "查询医疗收费项目详情返回")
public class FeeYlsfxmDetailResponse {
    @ApiModelProperty(value="费用序号")
    private Integer fyxh;

    @ApiModelProperty(value="费用名称")
    private String fymc;

    @ApiModelProperty(value="项目类型")
    private Integer xmlx;

    @ApiModelProperty(value="费用单价 机构规定的价格")
    private BigDecimal fydj;

    @ApiModelProperty(value="标准价格")
    private BigDecimal bzjg;

    @ApiModelProperty(value="费用归并")
    private Integer fygb;

    @ApiModelProperty(value="费用单位")
    private String fydw;

    @ApiModelProperty(value="执行科室")
    private Integer zxks;

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public Integer getXmlx() {
        return xmlx;
    }

    public void setXmlx(Integer xmlx) {
        this.xmlx = xmlx;
    }

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }

    public BigDecimal getBzjg() {
        return bzjg;
    }

    public void setBzjg(BigDecimal bzjg) {
        this.bzjg = bzjg;
    }

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

    public String getFydw() {
        return fydw;
    }

    public void setFydw(String fydw) {
        this.fydw = fydw;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }
}
