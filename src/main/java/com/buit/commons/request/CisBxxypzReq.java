   
package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：CisBxxypzReq<br> 
 * 类描述：备血申请单血液品种表<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="备血申请单血液品种表_Req")
public class CisBxxypzReq  {
    @ApiModelProperty(value="医疗机构代码")
    private String yljgd;
    @ApiModelProperty(value="申请单号")
    private String sqdh;
    @ApiModelProperty(value="序号")
    private Integer xh;
    @ApiModelProperty(value="输血品种代码")
    private String sxpzdm;
    @ApiModelProperty(value="输血品种名称")
    private String sxpzmc;
    @ApiModelProperty(value="数量")
    private BigDecimal sl;
    @ApiModelProperty(value="单位")
    private String dw;
    @ApiModelProperty(value="单价")
    private BigDecimal dj;
    @ApiModelProperty(value="金额")
    private BigDecimal je;
    @ApiModelProperty(value="组套标志")
    private Integer ztbz;
    /**
     * 设置:医疗机构代码
     */
    public void setYljgd(String value) {
        this.yljgd = value;
    }
    /**
     * 获取:医疗机构代码
     */
    public String getYljgd() {
        return yljgd;
    }
    /**
     * 设置:申请单号
     */
    public void setSqdh(String value) {
        this.sqdh = value;
    }
    /**
     * 获取:申请单号
     */
    public String getSqdh() {
        return sqdh;
    }
    /**
     * 设置:序号
     */
    public void setXh(Integer value) {
        this.xh = value;
    }
    /**
     * 获取:序号
     */
    public Integer getXh() {
        return xh;
    }
    /**
     * 设置:输血品种代码
     */
    public void setSxpzdm(String value) {
        this.sxpzdm = value;
    }
    /**
     * 获取:输血品种代码
     */
    public String getSxpzdm() {
        return sxpzdm;
    }
    /**
     * 设置:输血品种名称
     */
    public void setSxpzmc(String value) {
        this.sxpzmc = value;
    }
    /**
     * 获取:输血品种名称
     */
    public String getSxpzmc() {
        return sxpzmc;
    }
    /**
     * 设置:数量
     */
    public void setSl(BigDecimal value) {
        this.sl = value;
    }
    /**
     * 获取:数量
     */
    public BigDecimal getSl() {
        return sl;
    }
    /**
     * 设置:单位
     */
    public void setDw(String value) {
        this.dw = value;
    }
    /**
     * 获取:单位
     */
    public String getDw() {
        return dw;
    }
    /**
     * 设置:单价
     */
    public void setDj(BigDecimal value) {
        this.dj = value;
    }
    /**
     * 获取:单价
     */
    public BigDecimal getDj() {
        return dj;
    }
    /**
     * 设置:金额
     */
    public void setJe(BigDecimal value) {
        this.je = value;
    }
    /**
     * 获取:金额
     */
    public BigDecimal getJe() {
        return je;
    }
    
	public Integer getZtbz() {
		return ztbz;
	}
	
	public void setZtbz(Integer ztbz) {
		this.ztbz = ztbz;
	}
    
    
}
