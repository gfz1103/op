
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpZt02<br>
 * 类描述：门诊医生组套明细<br>
 * @author 老花生
 */
@ApiModel(value="门诊_门诊医生组套明细")
public class OpZt02XmResp extends PageQuery {
    @ApiModelProperty(value="记录编号")
    private Integer jlbh;
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @ApiModelProperty(value="药品组号")
    private Integer ypzh;
    @ApiModelProperty(value="项目编号")
    private Integer xmbh;
    @ApiModelProperty(value="项目名称")
    private String xmmc;
    @ApiModelProperty(value="项目数量")
    private Integer xmsl;
    @ApiModelProperty(value="一次剂量")
    private Integer ycjl;
    @ApiModelProperty(value="使用频次 | 项目组套维护 使用频次 可以为空")
    private String sypc;
    @ApiModelProperty(value="费用单价")
    private BigDecimal fydj;
    @ApiModelProperty(value="商保价格")
    private Integer sbjg;
    @ApiModelProperty(value="ypsl")
    private Integer ypsl;
    @ApiModelProperty(value="每日次数")
    private Integer mrcs;
    @ApiModelProperty(value="用药天数")
    private Integer yyts;
    @ApiModelProperty(value="给药途径")
    private Integer gytj;
    @ApiModelProperty(value="医保编码")
    private String ybbm;

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
    }

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
    }

    public Integer getYpzh() {
        return ypzh;
    }

    public void setYpzh(Integer ypzh) {
        this.ypzh = ypzh;
    }

    public Integer getXmbh() {
        return xmbh;
    }

    public void setXmbh(Integer xmbh) {
        this.xmbh = xmbh;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public Integer getXmsl() {
        return xmsl;
    }

    public void setXmsl(Integer xmsl) {
        this.xmsl = xmsl;
    }

    public Integer getYcjl() {
        return ycjl;
    }

    public void setYcjl(Integer ycjl) {
        this.ycjl = ycjl;
    }

    public String getSypc() {
        return sypc;
    }

    public void setSypc(String sypc) {
        this.sypc = sypc;
    }

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }

    public Integer getSbjg() {
        return sbjg;
    }

    public void setSbjg(Integer sbjg) {
        this.sbjg = sbjg;
    }

    public Integer getYpsl() {
        return ypsl;
    }

    public void setYpsl(Integer ypsl) {
        this.ypsl = ypsl;
    }

    public Integer getMrcs() {
        return mrcs;
    }

    public void setMrcs(Integer mrcs) {
        this.mrcs = mrcs;
    }

    public Integer getYyts() {
        return yyts;
    }

    public void setYyts(Integer yyts) {
        this.yyts = yyts;
    }

    public Integer getGytj() {
        return gytj;
    }

    public void setGytj(Integer gytj) {
        this.gytj = gytj;
    }

    public String getYbbm() {
        return ybbm;
    }

    public void setYbbm(String ybbm) {
        this.ybbm = ybbm;
    }
}
