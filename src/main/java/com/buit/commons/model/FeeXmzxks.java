package com.buit.commons.model;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

/**
 * 类名称：FeeXmzxks<br> 
 * 类描述：
 * @author 老花生 
 * @ApiModel(value="")
 */
public class FeeXmzxks  extends  PageQuery{
	//@ApiModelProperty(value="记录序号")
    /** 记录序号 */
    private Integer jlxh;
	//@ApiModelProperty(value="机构ID")
    /** 机构ID */
    private Integer jgid;
	//@ApiModelProperty(value="费用序号")
    /** 费用序号 */
    private Integer fyxh;
	//@ApiModelProperty(value="费用类别")
    /** 费用类别 */
    private Integer fylb;
	//@ApiModelProperty(value="物资序号")
    /** 物资序号 */
    private Integer wzxh;
	//@ApiModelProperty(value="物资数量")
    /** 物资数量 */
    private BigDecimal wzsl;

    /** 设置:记录序号  */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /** 获取:记录序号 */
    public Integer getJlxh() {
        return jlxh;
    }

    /** 设置:机构ID  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构ID */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:费用序号  */
    public void setFyxh(Integer value) {
        this.fyxh = value;
    }
    /** 获取:费用序号 */
    public Integer getFyxh() {
        return fyxh;
    }

    /** 设置:费用类别  */
    public void setFylb(Integer value) {
        this.fylb = value;
    }
    /** 获取:费用类别 */
    public Integer getFylb() {
        return fylb;
    }

    /** 设置:物资序号  */
    public void setWzxh(Integer value) {
        this.wzxh = value;
    }
    /** 获取:物资序号 */
    public Integer getWzxh() {
        return wzxh;
    }

    /** 设置:物资数量  */
    public void setWzsl(BigDecimal value) {
        this.wzsl = value;
    }
    /** 获取:物资数量 */
    public BigDecimal getWzsl() {
        return wzsl;
    }


}
