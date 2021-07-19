package com.buit.commons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：OpSfrbFkmx<br> 
 * 类描述：门诊_门诊收费日报付款明细
 * @author WY 
 * @ApiModel(value="门诊_门诊收费日报付款明细")
 */
public class OpSfrbFkmx  extends  PageQuery{
	//@ApiModelProperty(value="操作工号")
    /** 操作工号 */
    private String czgh;
	//@ApiModelProperty(value="结帐日期")
    /** 结帐日期 */
    private Timestamp jzrq;
	//@ApiModelProperty(value="付款方式")
    /** 付款方式 */
    private Integer fkfs;
	//@ApiModelProperty(value="机构ID")
    /** 机构ID */
    private Integer jgid;
	//@ApiModelProperty(value="付款金额")
    /** 付款金额 */
    private BigDecimal fkje;
	//@ApiModelProperty(value="mzlb")
    /** mzlb */
    private Integer mzlb;

    /** 设置:操作工号  */
    public void setCzgh(String value) {
        this.czgh = value;
    }
    /** 获取:操作工号 */
    public String getCzgh() {
        return czgh;
    }

    /** 设置:结帐日期  */
    public void setJzrq(Timestamp value) {
        this.jzrq = value;
    }
    /** 获取:结帐日期 */
    public Timestamp getJzrq() {
        return jzrq;
    }

    /** 设置:付款方式  */
    public void setFkfs(Integer value) {
        this.fkfs = value;
    }
    /** 获取:付款方式 */
    public Integer getFkfs() {
        return fkfs;
    }

    /** 设置:机构ID  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构ID */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:付款金额  */
    public void setFkje(BigDecimal value) {
        this.fkje = value;
    }
    /** 获取:付款金额 */
    public BigDecimal getFkje() {
        return fkje;
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
