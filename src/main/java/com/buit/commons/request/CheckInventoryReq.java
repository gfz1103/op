package com.buit.commons.request;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckInventoryReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/1 16:29
 */
@ApiModel(value="校验库存信息-请求")
public class CheckInventoryReq {
    @ApiModelProperty(value="零售价格")
    private BigDecimal lsjg;
    @ApiModelProperty(value="药品编号")
    private Integer medId;
    @ApiModelProperty(value="药品产地")
    private Integer medsource;
    @ApiModelProperty(value="药房编号")
    private Integer pharmId;
    @ApiModelProperty(value="药品总量")
    private BigDecimal quantity;
    @ApiModelProperty(value="药品名称")
    private String ypmc;
    @ApiModelProperty(value="件次")
    private String jc;
    @ApiModelProperty(value="记录序号")
    private Integer jlxh;

    public BigDecimal getLsjg() {
        return lsjg;
    }

    public void setLsjg(BigDecimal lsjg) {
        this.lsjg = lsjg;
    }

    public Integer getMedId() {
        return medId;
    }

    public void setMedId(Integer medId) {
        this.medId = medId;
    }

    public Integer getMedsource() {
        return medsource;
    }

    public void setMedsource(Integer medsource) {
        this.medsource = medsource;
    }

    public Integer getPharmId() {
        return pharmId;
    }

    public void setPharmId(Integer pharmId) {
        this.pharmId = pharmId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }
}
