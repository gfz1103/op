
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


/**
 * 类名称：OpZt02<br>
 * 类描述：门诊_门诊医生组套明细<br>
 * @author 老花生
 */
@ApiModel(value="门诊_门诊医生组套明细")
public class OpZt02AddReq extends PageQuery {
    @ApiModelProperty(value="记录编号", hidden = true)
    private Integer jlbh;

    @NotNull(message = "组套编号 不能为空")
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;

    @NotNull(message = "药品（项目）组号 不能为空")
    @ApiModelProperty(value="药品（项目）组号")
    private Integer ypzh;

    @ApiModelProperty(value="项目编号")
    private Integer xmbh;

    @ApiModelProperty(value="药品（项目）名称")
    private String xmmc;

    @ApiModelProperty(value="项目数量")
    private BigDecimal xmsl;

    @ApiModelProperty(value = "几倍")
    private String jb;

    @ApiModelProperty(value="一次剂量")
    private BigDecimal ycjl;

    @ApiModelProperty(value="每日次数")
    private Integer mrcs;

    @ApiModelProperty(value="用药天数")
    private Integer yyts;

    @ApiModelProperty(value="给药途径")
    private Integer gytj;

    @ApiModelProperty(value="使用频次")
    private String sypc;

    @ApiModelProperty(value="药品数量")
    private BigDecimal ypsl;

    @ApiModelProperty(value="脚注")
    private Integer jz;

    @ApiModelProperty(value="费用单价")
    private BigDecimal fydj;

    @ApiModelProperty(value="商保价格")
    private BigDecimal sbjg;

    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;
    /**
     * 设置:记录编号
     */
    public void setJlbh(Integer value) {
        this.jlbh = value;
    }
    /**
     * 获取:记录编号
     */
    public Integer getJlbh() {
        return jlbh;
    }
    /**
     * 设置:组套编号
     */
    public void setZtbh(Integer value) {
        this.ztbh = value;
    }
    /**
     * 获取:组套编号
     */
    public Integer getZtbh() {
        return ztbh;
    }
    /**
     * 设置:药品组号
     */
    public void setYpzh(Integer value) {
        this.ypzh = value;
    }
    /**
     * 获取:药品组号
     */
    public Integer getYpzh() {
        return ypzh;
    }
    /**
     * 设置:项目编号
     */
    public void setXmbh(Integer value) {
        this.xmbh = value;
    }
    /**
     * 获取:项目编号
     */
    public Integer getXmbh() {
        return xmbh;
    }
    /**
     * 设置:项目名称
     */
    public void setXmmc(String value) {
        this.xmmc = value;
    }
    /**
     * 获取:项目名称
     */
    public String getXmmc() {
        return xmmc;
    }
    /**
     * 设置:项目数量
     */
    public void setXmsl(BigDecimal value) {
        this.xmsl = value;
    }
    /**
     * 获取:项目数量
     */
    public BigDecimal getXmsl() {
        return xmsl;
    }

    public String getJb() {
        return jb;
    }

    public void setJb(String jb) {
        this.jb = jb;
    }

    /**
     * 设置:一次剂量
     */
    public void setYcjl(BigDecimal value) {
        this.ycjl = value;
    }
    /**
     * 获取:一次剂量
     */
    public BigDecimal getYcjl() {
        return ycjl;
    }
    /**
     * 设置:使用频次 | 项目组套维护 使用频次 可以为空
     */
    public void setSypc(String value) {
        this.sypc = value;
    }
    /**
     * 获取:使用频次 | 项目组套维护 使用频次 可以为空
     */
    public String getSypc() {
        return sypc;
    }
    /**
     * 设置:每日次数
     */
    public void setMrcs(Integer value) {
        this.mrcs = value;
    }
    /**
     * 获取:每日次数
     */
    public Integer getMrcs() {
        return mrcs;
    }
    /**
     * 设置:用药天数
     */
    public void setYyts(Integer value) {
        this.yyts = value;
    }
    /**
     * 获取:用药天数
     */
    public Integer getYyts() {
        return yyts;
    }
    /**
     * 设置:给药途径
     */
    public void setGytj(Integer value) {
        this.gytj = value;
    }
    /**
     * 获取:给药途径
     */
    public Integer getGytj() {
        return gytj;
    }
    /**
     * 设置:ypsl
     */
    public void setYpsl(BigDecimal value) {
        this.ypsl = value;
    }
    /**
     * 获取:ypsl
     */
    public BigDecimal getYpsl() {
        return ypsl;
    }
    /**
     * 设置:脚注
     */
    public void setJz(Integer value) {
        this.jz = value;
    }
    /**
     * 获取:脚注
     */
    public Integer getJz() {
        return jz;
    }

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }

    public BigDecimal getSbjg() {
        return sbjg;
    }

    public void setSbjg(BigDecimal sbjg) {
        this.sbjg = sbjg;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }
}
