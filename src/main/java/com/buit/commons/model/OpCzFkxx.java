package com.buit.commons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：OpCzFkxx<br> 
 * 类描述：充值_充值收费付款信息
 * @author WY 
 * @ApiModel(value="充值_充值收费付款信息")
 */
public class OpCzFkxx  extends  PageQuery{
	//@ApiModelProperty(value="记录序号")
    /** 记录序号 */
    private Integer jlxh;
	//@ApiModelProperty(value="cardid")
    /** cardid */
    private Integer cardid;
	//@ApiModelProperty(value="机构代码")
    /** 机构代码 */
    private Integer jgid;
	//@ApiModelProperty(value="充值日期")
    /** 充值日期 */
    private Timestamp czrq;
	//@ApiModelProperty(value="充值方式")
    /** 充值方式 */
    private Integer czfs;
	//@ApiModelProperty(value="充值金额")
    /** 充值金额 */
    private BigDecimal czje;
    //@ApiModelProperty(value="充值票据")
    /** 充值票据 */
    private String czpj;
	//@ApiModelProperty(value="操作工号")
    /** 操作工号 */
    private String czgh;
	//@ApiModelProperty(value="结账日期")
    /** 结账日期 */
    private Timestamp jzrq;
	//@ApiModelProperty(value="汇总日期")
    /** 汇总日期 */
    private Timestamp hzrq;
	//@ApiModelProperty(value="mzlb")
    /** mzlb */
    private Integer mzlb;

    /** 设置:记录序号  */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /** 获取:记录序号 */
    public Integer getJlxh() {
        return jlxh;
    }

    /** 设置:cardid  */
    public void setCardid(Integer value) {
        this.cardid = value;
    }
    /** 获取:cardid */
    public Integer getCardid() {
        return cardid;
    }

    /** 设置:机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构代码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:充值日期  */
    public void setCzrq(Timestamp value) {
        this.czrq = value;
    }
    /** 获取:充值日期 */
    public Timestamp getCzrq() {
        return czrq;
    }

    /** 设置:充值方式  */
    public void setCzfs(Integer value) {
        this.czfs = value;
    }
    /** 获取:充值方式 */
    public Integer getCzfs() {
        return czfs;
    }

    /** 设置:充值金额  */
    public void setCzje(BigDecimal value) {
        this.czje = value;
    }
    /** 获取:充值金额 */
    public BigDecimal getCzje() {
        return czje;
    }


    public String getCzpj() {
        return czpj;
    }

    public void setCzpj(String czpj) {
        this.czpj = czpj;
    }

    /** 设置:操作工号  */
    public void setCzgh(String value) {
        this.czgh = value;
    }
    /** 获取:操作工号 */
    public String getCzgh() {
        return czgh;
    }

    /** 设置:结账日期  */
    public void setJzrq(Timestamp value) {
        this.jzrq = value;
    }
    /** 获取:结账日期 */
    public Timestamp getJzrq() {
        return jzrq;
    }

    /** 设置:汇总日期  */
    public void setHzrq(Timestamp value) {
        this.hzrq = value;
    }
    /** 获取:汇总日期 */
    public Timestamp getHzrq() {
        return hzrq;
    }

    /** 设置:mzlb  */
    public void setMzlb(Integer value) {
        this.mzlb = value;
    }
    /** 获取:mzlb */
    public Integer getMzlb() {
        return mzlb;
    }


}
