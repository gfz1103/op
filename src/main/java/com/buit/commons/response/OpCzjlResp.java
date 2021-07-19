   
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpCzjl<br> 
 * 类描述：充值卡操作记录<br>
 * @author WY
 */
@ApiModel(value="充值卡操作记录")
public class OpCzjlResp  extends  PageQuery{
    @ApiModelProperty(value="充值序号")
    private Integer czxh;
    @ApiModelProperty(value="卡号")
    private String cardno;
    @ApiModelProperty(value="操作类型 01发卡 02充值 03退费 04挂失 05解挂  06注销 07挂号付费 08门诊付费 09住院付费 10挂号退费 11挂号退费 12住院退费")
    private String cztype;
    @ApiModelProperty(value="操作金额")
    private BigDecimal amount;
    @ApiModelProperty(value="操作工号")
    private String czgh;
    @ApiModelProperty(value="操作IP")
    private String czip;
    @ApiModelProperty(value="操作时间")
    private Timestamp czsj;
    @ApiModelProperty(value="病人ID")
    private Integer brid;
    @ApiModelProperty(value="发票号码")
    private String mpiKpxx;
    @ApiModelProperty(value="上次卡内余额")
    private BigDecimal lastknye;
    @ApiModelProperty(value="czfs")
    private Integer czfs;
    @ApiModelProperty(value="发票号码")
    private String fphm;
    /**
     * 设置:充值序号
     */
    public void setCzxh(Integer value) {
        this.czxh = value;
    }
    /**
     * 获取:充值序号
     */
    public Integer getCzxh() {
        return czxh;
    }
    /**
     * 设置:卡号
     */
    public void setCardno(String value) {
        this.cardno = value;
    }
    /**
     * 获取:卡号
     */
    public String getCardno() {
        return cardno;
    }
    /**
     * 设置:操作类型 01发卡 02充值 03退费 04挂失 05解挂  06注销 07挂号付费 08门诊付费 09住院付费 10挂号退费 11挂号退费 12住院退费
     */
    public void setCztype(String value) {
        this.cztype = value;
    }
    /**
     * 获取:操作类型 01发卡 02充值 03退费 04挂失 05解挂  06注销 07挂号付费 08门诊付费 09住院付费 10挂号退费 11挂号退费 12住院退费
     */
    public String getCztype() {
        return cztype;
    }
    /**
     * 设置:操作金额
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }
    /**
     * 获取:操作金额
     */
    public BigDecimal getAmount() {
        return amount;
    }
    /**
     * 设置:操作工号
     */
    public void setCzgh(String value) {
        this.czgh = value;
    }
    /**
     * 获取:操作工号
     */
    public String getCzgh() {
        return czgh;
    }
    /**
     * 设置:操作IP
     */
    public void setCzip(String value) {
        this.czip = value;
    }
    /**
     * 获取:操作IP
     */
    public String getCzip() {
        return czip;
    }
    /**
     * 设置:操作时间
     */
    public void setCzsj(Timestamp value) {
        this.czsj = value;
    }
    /**
     * 获取:操作时间
     */
    public Timestamp getCzsj() {
        return czsj;
    }
    /**
     * 设置:病人ID
     */
    public void setBrid(Integer value) {
        this.brid = value;
    }
    /**
     * 获取:病人ID
     */
    public Integer getBrid() {
        return brid;
    }
    /**
     * 设置:发票号码
     */
    public void setMpiKpxx(String value) {
        this.mpiKpxx = value;
    }
    /**
     * 获取:发票号码
     */
    public String getMpiKpxx() {
        return mpiKpxx;
    }
    /**
     * 设置:上次卡内余额
     */
    public void setLastknye(BigDecimal value) {
        this.lastknye = value;
    }
    /**
     * 获取:上次卡内余额
     */
    public BigDecimal getLastknye() {
        return lastknye;
    }
    /**
     * 设置:czfs
     */
    public void setCzfs(Integer value) {
        this.czfs = value;
    }
    /**
     * 获取:czfs
     */
    public Integer getCzfs() {
        return czfs;
    }
    /**
     * 设置:发票号码
     */
    public void setFphm(String value) {
        this.fphm = value;
    }
    /**
     * 获取:发票号码
     */
    public String getFphm() {
        return fphm;
    }
}
