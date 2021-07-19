package com.buit.commons.model;

import com.buit.commons.PageQuery;

/**
 * 类名称：GmAxektc<br> 
 * 类描述：
 * @author WY 
 * @ApiModel(value="")
 */
public class GhrbReport  extends  PageQuery{
	//@ApiModelProperty(value="套餐编码")
    /** 套餐编码 */
    private String tcbm;
	//@ApiModelProperty(value="套餐名称")
    /** 套餐名称 */
    private String tcmc;
	//@ApiModelProperty(value="类型（调爱心卡接口用）")
    /** 类型（调爱心卡接口用） */
    private String lx;
	//@ApiModelProperty(value="状态")
    /** 状态 */
    private String zt;

    /** 设置:套餐编码  */
    public void setTcbm(String value) {
        this.tcbm = value;
    }
    /** 获取:套餐编码 */
    public String getTcbm() {
        return tcbm;
    }

    /** 设置:套餐名称  */
    public void setTcmc(String value) {
        this.tcmc = value;
    }
    /** 获取:套餐名称 */
    public String getTcmc() {
        return tcmc;
    }

    /** 设置:类型（调爱心卡接口用）  */
    public void setLx(String value) {
        this.lx = value;
    }
    /** 获取:类型（调爱心卡接口用） */
    public String getLx() {
        return lx;
    }

    /** 设置:状态  */
    public void setZt(String value) {
        this.zt = value;
    }
    /** 获取:状态 */
    public String getZt() {
        return zt;
    }


}