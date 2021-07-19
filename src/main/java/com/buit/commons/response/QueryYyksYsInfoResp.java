package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckInventoryReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/8/31 10:43
 */
@ApiModel(value="查询预约科室医生-返回")
public class QueryYyksYsInfoResp {
    @ApiModelProperty(value="工作日期")
    private Date gzrq;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="医生代码")
    private Integer ysdm;
    @ApiModelProperty(value="医生姓名")
    private String personname;
    @ApiModelProperty(value="专家")
    private String isexpert;
    @ApiModelProperty(value="专家费")
    private BigDecimal expertcost;
    @ApiModelProperty(value="拼音代码")
    private String pycode;
    @ApiModelProperty(value="值班类别")
    private String zblb;
    @ApiModelProperty(value="机构ID")
    private Integer jgid;
    @ApiModelProperty(value="挂号限额")
    private Integer ghxe;
    @ApiModelProperty(value="已挂人数")
    private Integer ygrs;
    @ApiModelProperty(value="预约人数")
    private Integer yyrs;
    @ApiModelProperty(value="就诊序号")
    private Integer jzxh;
    @ApiModelProperty(value="预约限额")
    private Integer yyxe;
    @ApiModelProperty(value="停挂标志")
    private Integer tgbz;
    @ApiModelProperty(value="注册id")
    private Integer zsid;

    public Date getGzrq() {
        return gzrq;
    }

    public void setGzrq(Date gzrq) {
        this.gzrq = gzrq;
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

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getIsexpert() {
        return isexpert;
    }

    public void setIsexpert(String isexpert) {
        this.isexpert = isexpert;
    }

    public BigDecimal getExpertcost() {
        return expertcost;
    }

    public void setExpertcost(BigDecimal expertcost) {
        this.expertcost = expertcost;
    }

    public String getPycode() {
        return pycode;
    }

    public void setPycode(String pycode) {
        this.pycode = pycode;
    }

    public String getZblb() {
        return zblb;
    }

    public void setZblb(String zblb) {
        this.zblb = zblb;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getGhxe() {
        return ghxe;
    }

    public void setGhxe(Integer ghxe) {
        this.ghxe = ghxe;
    }

    public Integer getYgrs() {
        return ygrs;
    }

    public void setYgrs(Integer ygrs) {
        this.ygrs = ygrs;
    }

    public Integer getYyrs() {
        return yyrs;
    }

    public void setYyrs(Integer yyrs) {
        this.yyrs = yyrs;
    }

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

    public Integer getYyxe() {
        return yyxe;
    }

    public void setYyxe(Integer yyxe) {
        this.yyxe = yyxe;
    }

    public Integer getTgbz() {
        return tgbz;
    }

    public void setTgbz(Integer tgbz) {
        this.tgbz = tgbz;
    }

    public Integer getZsid() {
        return zsid;
    }

    public void setZsid(Integer zsid) {
        this.zsid = zsid;
    }
}
