package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckInventoryReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/9/1 17:52
 */
@ApiModel(value="查询复制报告检验、检查申请列表-返回")
public class QueryAuxiliaryReportListResp {
    @ApiModelProperty(value="申请日期")
    private Timestamp kdrq;
    @ApiModelProperty(value="检验名称")
    private String fymc;
    @ApiModelProperty(value="检验状态")
    private Integer djzt;
    @ApiModelProperty(value="开单医生")
    private Integer ysdm;
    @ApiModelProperty(value="金额")
    private BigDecimal hjje;
    @ApiModelProperty(value="医技主键")
    private Integer yjxh;

    public Timestamp getKdrq() {
        return kdrq;
    }

    public void setKdrq(Timestamp kdrq) {
        this.kdrq = kdrq;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public Integer getDjzt() {
        return djzt;
    }

    public void setDjzt(Integer djzt) {
        this.djzt = djzt;
    }

    public Integer getYsdm() {
        return ysdm;
    }

    public void setYsdm(Integer ysdm) {
        this.ysdm = ysdm;
    }

    public BigDecimal getHjje() {
        return hjje;
    }

    public void setHjje(BigDecimal hjje) {
        this.hjje = hjje;
    }

    public Integer getYjxh() {
        return yjxh;
    }

    public void setYjxh(Integer yjxh) {
        this.yjxh = yjxh;
    }
}
