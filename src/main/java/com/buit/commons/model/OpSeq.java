package com.buit.commons.model;

import com.buit.commons.PageQuery;

/**
 * 类名称：OpSeq<br> 
 * 类描述：暂时用来解决发票虚拟自增序号
 * @author WY 
 * @ApiModel(value="暂时用来解决发票虚拟自增序号")
 */
public class OpSeq  extends  PageQuery{
	//@ApiModelProperty(value="当前日期")
    /** 当前日期 */
    private String dqrq;
	//@ApiModelProperty(value="当前序号")
    /** 当前序号 */
    private Integer dqxh;

    /** 设置:当前日期  */
    public void setDqrq(String value) {
        this.dqrq = value;
    }
    /** 获取:当前日期 */
    public String getDqrq() {
        return dqrq;
    }

    /** 设置:当前序号  */
    public void setDqxh(Integer value) {
        this.dqxh = value;
    }
    /** 获取:当前序号 */
    public Integer getDqxh() {
        return dqxh;
    }


}
