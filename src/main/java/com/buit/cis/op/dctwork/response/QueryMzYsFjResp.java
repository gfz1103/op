package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @ClassName QueryMzYsFjResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/12 10:47
 */
@ApiModel(value="门诊医生工作站-辅检查询返回")
public class QueryMzYsFjResp {

    @ApiModelProperty(value="费用归并")
    private Integer fygb;
    @ApiModelProperty(value="限制使用")
    private String xzsy;
    @ApiModelProperty(value="费用单位")
    private String fydw;
    @ApiModelProperty(value="费用科室")
    private Object fyks;
    @ApiModelProperty(value="费用序号")
    private Integer fyxh;
    @ApiModelProperty(value="限制天数")
    private Integer xzts;
    @ApiModelProperty(value="标准价格")
    private BigDecimal bzjg;
    @ApiModelProperty(value="限制次数")
    private Integer xzcs;
    @ApiModelProperty(value="费用单价")
    private BigDecimal fydj;
    @ApiModelProperty(value="费用名称")
    private String fymc;
    @ApiModelProperty(value="医保编码")
    private String ybbm;
    @ApiModelProperty(value="排序号")
    private Integer numKey;
    @ApiModelProperty(value="项目类型")
    private Integer xmlx;
    @ApiModelProperty(value="执行科室")
    private Integer zxks;
    @ApiModelProperty(value="是否有默认执行科室 0：有默认执行科室、1：无默认执行科室")
    private Integer isZxks;
    @ApiModelProperty(value="拼音代码")
    private String pydm;


    public void setIsZxks(Integer isZxks) {
        this.isZxks = isZxks;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

    public String getXzsy() {
        return xzsy;
    }

    public void setXzsy(String xzsy) {
        this.xzsy = xzsy;
    }

    public String getFydw() {
        return fydw;
    }

    public void setFydw(String fydw) {
        this.fydw = fydw;
    }

    public Object getFyks() {
        return fyks;
    }

    public void setFyks(Object fyks) {
        this.fyks = fyks;
    }

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }

    public Integer getXzts() {
        return xzts;
    }

    public void setXzts(Integer xzts) {
        this.xzts = xzts;
    }

    public BigDecimal getBzjg() {
        return bzjg;
    }

    public void setBzjg(BigDecimal bzjg) {
        this.bzjg = bzjg;
    }

    public Integer getXzcs() {
        return xzcs;
    }

    public void setXzcs(Integer xzcs) {
        this.xzcs = xzcs;
    }

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public String getYbbm() {
        return ybbm;
    }

    public void setYbbm(String ybbm) {
        this.ybbm = ybbm;
    }

    public Integer getNumKey() {
        return numKey;
    }

    public void setNumKey(Integer numKey) {
        this.numKey = numKey;
    }

    public Integer getXmlx() {
        return xmlx;
    }

    public void setXmlx(Integer xmlx) {
        this.xmlx = xmlx;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }

    public Integer getIsZxks() {
        if(this.zxks == null || this.zxks.intValue() == 0){
            return 1;
        }
        return 0;
    }
}
