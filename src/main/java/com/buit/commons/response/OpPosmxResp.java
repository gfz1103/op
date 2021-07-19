//   
//package com.buit.commons.response;
//
//import java.sql.Timestamp;
//
//import com.his.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：OpPosmx<br> 
// * 类描述：<br>
// * @author WY
// */
//@ApiModel(value="")
//public class OpPosmxResp  extends  PageQuery{
//    @ApiModelProperty(value="id")
//    private Integer id;
//    @ApiModelProperty(value="jysj")
//    private Timestamp jysj;
//    @ApiModelProperty(value="jylb")
//    private Integer jylb;
//    @ApiModelProperty(value="fphm")
//    private String fphm;
//    @ApiModelProperty(value="posnumber")
//    private String posnumber;
//    @ApiModelProperty(value="storenumber")
//    private String storenumber;
//    @ApiModelProperty(value="operator")
//    private String operator;
//    @ApiModelProperty(value="cardtype")
//    private String cardtype;
//    @ApiModelProperty(value="cardname")
//    private String cardname;
//    @ApiModelProperty(value="transtype")
//    private Integer transtype;
//    @ApiModelProperty(value="transamount")
//    private BigDecimal transamount;
//    @ApiModelProperty(value="tips")
//    private BigDecimal tips;
//    @ApiModelProperty(value="total")
//    private BigDecimal total;
//    @ApiModelProperty(value="balanceamount")
//    private BigDecimal balanceamount;
//    @ApiModelProperty(value="postracenumber")
//    private String postracenumber;
//    @ApiModelProperty(value="oldtracenumber")
//    private String oldtracenumber;
//    @ApiModelProperty(value="expiredate")
//    private String expiredate;
//    @ApiModelProperty(value="batchnumber")
//    private String batchnumber;
//    @ApiModelProperty(value="merchantnumber")
//    private String merchantnumber;
//    @ApiModelProperty(value="merchantname")
//    private String merchantname;
//    @ApiModelProperty(value="terminalnumber")
//    private String terminalnumber;
//    @ApiModelProperty(value="hostserialnumber")
//    private String hostserialnumber;
//    @ApiModelProperty(value="authnumber")
//    private String authnumber;
//    @ApiModelProperty(value="rejcode")
//    private String rejcode;
//    @ApiModelProperty(value="issnumber")
//    private String issnumber;
//    @ApiModelProperty(value="issname")
//    private String issname;
//    @ApiModelProperty(value="cardnumber")
//    private String cardnumber;
//    @ApiModelProperty(value="transdate")
//    private String transdate;
//    @ApiModelProperty(value="transtime")
//    private String transtime;
//    @ApiModelProperty(value="rejcodeexplain")
//    private String rejcodeexplain;
//    @ApiModelProperty(value="cardback")
//    private String cardback;
//    @ApiModelProperty(value="transcheck")
//    private String transcheck;
//    /**
//     * 设置:id
//     */
//    public void setId(Integer value) {
//        this.id = value;
//    }
//    /**
//     * 获取:id
//     */
//    public Integer getId() {
//        return id;
//    }
//    /**
//     * 设置:jysj
//     */
//    public void setJysj(Timestamp value) {
//        this.jysj = value;
//    }
//    /**
//     * 获取:jysj
//     */
//    public Timestamp getJysj() {
//        return jysj;
//    }
//    /**
//     * 设置:jylb
//     */
//    public void setJylb(Integer value) {
//        this.jylb = value;
//    }
//    /**
//     * 获取:jylb
//     */
//    public Integer getJylb() {
//        return jylb;
//    }
//    /**
//     * 设置:fphm
//     */
//    public void setFphm(String value) {
//        this.fphm = value;
//    }
//    /**
//     * 获取:fphm
//     */
//    public String getFphm() {
//        return fphm;
//    }
//    /**
//     * 设置:posnumber
//     */
//    public void setPosnumber(String value) {
//        this.posnumber = value;
//    }
//    /**
//     * 获取:posnumber
//     */
//    public String getPosnumber() {
//        return posnumber;
//    }
//    /**
//     * 设置:storenumber
//     */
//    public void setStorenumber(String value) {
//        this.storenumber = value;
//    }
//    /**
//     * 获取:storenumber
//     */
//    public String getStorenumber() {
//        return storenumber;
//    }
//    /**
//     * 设置:operator
//     */
//    public void setOperator(String value) {
//        this.operator = value;
//    }
//    /**
//     * 获取:operator
//     */
//    public String getOperator() {
//        return operator;
//    }
//    /**
//     * 设置:cardtype
//     */
//    public void setCardtype(String value) {
//        this.cardtype = value;
//    }
//    /**
//     * 获取:cardtype
//     */
//    public String getCardtype() {
//        return cardtype;
//    }
//    /**
//     * 设置:cardname
//     */
//    public void setCardname(String value) {
//        this.cardname = value;
//    }
//    /**
//     * 获取:cardname
//     */
//    public String getCardname() {
//        return cardname;
//    }
//    /**
//     * 设置:transtype
//     */
//    public void setTranstype(Integer value) {
//        this.transtype = value;
//    }
//    /**
//     * 获取:transtype
//     */
//    public Integer getTranstype() {
//        return transtype;
//    }
//    /**
//     * 设置:transamount
//     */
//    public void setTransamount(BigDecimal value) {
//        this.transamount = value;
//    }
//    /**
//     * 获取:transamount
//     */
//    public BigDecimal getTransamount() {
//        return transamount;
//    }
//    /**
//     * 设置:tips
//     */
//    public void setTips(BigDecimal value) {
//        this.tips = value;
//    }
//    /**
//     * 获取:tips
//     */
//    public BigDecimal getTips() {
//        return tips;
//    }
//    /**
//     * 设置:total
//     */
//    public void setTotal(BigDecimal value) {
//        this.total = value;
//    }
//    /**
//     * 获取:total
//     */
//    public BigDecimal getTotal() {
//        return total;
//    }
//    /**
//     * 设置:balanceamount
//     */
//    public void setBalanceamount(BigDecimal value) {
//        this.balanceamount = value;
//    }
//    /**
//     * 获取:balanceamount
//     */
//    public BigDecimal getBalanceamount() {
//        return balanceamount;
//    }
//    /**
//     * 设置:postracenumber
//     */
//    public void setPostracenumber(String value) {
//        this.postracenumber = value;
//    }
//    /**
//     * 获取:postracenumber
//     */
//    public String getPostracenumber() {
//        return postracenumber;
//    }
//    /**
//     * 设置:oldtracenumber
//     */
//    public void setOldtracenumber(String value) {
//        this.oldtracenumber = value;
//    }
//    /**
//     * 获取:oldtracenumber
//     */
//    public String getOldtracenumber() {
//        return oldtracenumber;
//    }
//    /**
//     * 设置:expiredate
//     */
//    public void setExpiredate(String value) {
//        this.expiredate = value;
//    }
//    /**
//     * 获取:expiredate
//     */
//    public String getExpiredate() {
//        return expiredate;
//    }
//    /**
//     * 设置:batchnumber
//     */
//    public void setBatchnumber(String value) {
//        this.batchnumber = value;
//    }
//    /**
//     * 获取:batchnumber
//     */
//    public String getBatchnumber() {
//        return batchnumber;
//    }
//    /**
//     * 设置:merchantnumber
//     */
//    public void setMerchantnumber(String value) {
//        this.merchantnumber = value;
//    }
//    /**
//     * 获取:merchantnumber
//     */
//    public String getMerchantnumber() {
//        return merchantnumber;
//    }
//    /**
//     * 设置:merchantname
//     */
//    public void setMerchantname(String value) {
//        this.merchantname = value;
//    }
//    /**
//     * 获取:merchantname
//     */
//    public String getMerchantname() {
//        return merchantname;
//    }
//    /**
//     * 设置:terminalnumber
//     */
//    public void setTerminalnumber(String value) {
//        this.terminalnumber = value;
//    }
//    /**
//     * 获取:terminalnumber
//     */
//    public String getTerminalnumber() {
//        return terminalnumber;
//    }
//    /**
//     * 设置:hostserialnumber
//     */
//    public void setHostserialnumber(String value) {
//        this.hostserialnumber = value;
//    }
//    /**
//     * 获取:hostserialnumber
//     */
//    public String getHostserialnumber() {
//        return hostserialnumber;
//    }
//    /**
//     * 设置:authnumber
//     */
//    public void setAuthnumber(String value) {
//        this.authnumber = value;
//    }
//    /**
//     * 获取:authnumber
//     */
//    public String getAuthnumber() {
//        return authnumber;
//    }
//    /**
//     * 设置:rejcode
//     */
//    public void setRejcode(String value) {
//        this.rejcode = value;
//    }
//    /**
//     * 获取:rejcode
//     */
//    public String getRejcode() {
//        return rejcode;
//    }
//    /**
//     * 设置:issnumber
//     */
//    public void setIssnumber(String value) {
//        this.issnumber = value;
//    }
//    /**
//     * 获取:issnumber
//     */
//    public String getIssnumber() {
//        return issnumber;
//    }
//    /**
//     * 设置:issname
//     */
//    public void setIssname(String value) {
//        this.issname = value;
//    }
//    /**
//     * 获取:issname
//     */
//    public String getIssname() {
//        return issname;
//    }
//    /**
//     * 设置:cardnumber
//     */
//    public void setCardnumber(String value) {
//        this.cardnumber = value;
//    }
//    /**
//     * 获取:cardnumber
//     */
//    public String getCardnumber() {
//        return cardnumber;
//    }
//    /**
//     * 设置:transdate
//     */
//    public void setTransdate(String value) {
//        this.transdate = value;
//    }
//    /**
//     * 获取:transdate
//     */
//    public String getTransdate() {
//        return transdate;
//    }
//    /**
//     * 设置:transtime
//     */
//    public void setTranstime(String value) {
//        this.transtime = value;
//    }
//    /**
//     * 获取:transtime
//     */
//    public String getTranstime() {
//        return transtime;
//    }
//    /**
//     * 设置:rejcodeexplain
//     */
//    public void setRejcodeexplain(String value) {
//        this.rejcodeexplain = value;
//    }
//    /**
//     * 获取:rejcodeexplain
//     */
//    public String getRejcodeexplain() {
//        return rejcodeexplain;
//    }
//    /**
//     * 设置:cardback
//     */
//    public void setCardback(String value) {
//        this.cardback = value;
//    }
//    /**
//     * 获取:cardback
//     */
//    public String getCardback() {
//        return cardback;
//    }
//    /**
//     * 设置:transcheck
//     */
//    public void setTranscheck(String value) {
//        this.transcheck = value;
//    }
//    /**
//     * 获取:transcheck
//     */
//    public String getTranscheck() {
//        return transcheck;
//    }
//}
