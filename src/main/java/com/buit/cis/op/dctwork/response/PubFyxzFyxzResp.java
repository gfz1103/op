package com.buit.cis.op.dctwork.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：PubFyxz<br>
 * 类描述：病人性质维护-费用限制<br>
 * @author liushijie
 */
@ApiModel(value="病人性质维护-费用限制")
public class PubFyxzFyxzResp extends PageQuery {
    @ApiModelProperty(value="病人性质")
    private Integer brxz;
    @ApiModelProperty(value="费用序号")
    private Integer fyxh;
    @ApiModelProperty(value="自负比例")
    private BigDecimal zfbl;
    @ApiModelProperty(value="费用限额 | =0：没有限额 >0：有限额")
    private BigDecimal fyxe;
    @ApiModelProperty(value="超限比例 | 超限部分的计算比例")
    private BigDecimal cxbl;
    @ApiModelProperty(value="特殊标志，是否走纯自费")
    private String tsbz;
    @ApiModelProperty(value="费用名称")
    private String fymc;
    @ApiModelProperty(value="费用单位")
    private String fydw;


    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public String getFydw() {
        return fydw;
    }

    public void setFydw(String fydw) {
        this.fydw = fydw;
    }

    /**
     * 设置:病人性质
     */
    public void setBrxz(Integer value) {
        this.brxz = value;
    }
    /**
     * 获取:病人性质
     */
    public Integer getBrxz() {
        return brxz;
    }
    /**
     * 设置:费用序号
     */
    public void setFyxh(Integer value) {
        this.fyxh = value;
    }
    /**
     * 获取:费用序号
     */
    public Integer getFyxh() {
        return fyxh;
    }
    /**
     * 设置:自负比例
     */
    public void setZfbl(BigDecimal value) {
        this.zfbl = value;
    }
    /**
     * 获取:自负比例
     */
    public BigDecimal getZfbl() {
        return zfbl;
    }
    /**
     * 设置:费用限额 | =0：没有限额 >0：有限额
     */
    public void setFyxe(BigDecimal value) {
        this.fyxe = value;
    }
    /**
     * 获取:费用限额 | =0：没有限额 >0：有限额
     */
    public BigDecimal getFyxe() {
        return fyxe;
    }
    /**
     * 设置:超限比例 | 超限部分的计算比例
     */
    public void setCxbl(BigDecimal value) {
        this.cxbl = value;
    }
    /**
     * 获取:超限比例 | 超限部分的计算比例
     */
    public BigDecimal getCxbl() {
        return cxbl;
    }
    /**
     * 设置:特殊标志，是否走纯自费
     */
    public void setTsbz(String value) {
        this.tsbz = value;
    }
    /**
     * 获取:特殊标志，是否走纯自费
     */
    public String getTsbz() {
        return tsbz;
    }
}
