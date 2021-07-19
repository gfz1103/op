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
// * 类名称：OpCzTfxx<br> 
// * 类描述：充值_充值退费信息<br>
// * @author WY
// */
//@ApiModel(value="充值_充值退费信息")
//public class OpCzTfxxResp  extends  PageQuery{
//    @ApiModelProperty(value="记录序号")
//    private Integer jlxh;
//    @ApiModelProperty(value="cardid")
//    private Integer cardid;
//    @ApiModelProperty(value="机构代码")
//    private Integer jgid;
//    @ApiModelProperty(value="退费日期")
//    private Timestamp tfrq;
//    @ApiModelProperty(value="退费方式")
//    private Integer tffs;
//    @ApiModelProperty(value="退费金额")
//    private BigDecimal tfje;
//    @ApiModelProperty(value="操作工号")
//    private String czgh;
//    @ApiModelProperty(value="结账日期")
//    private Timestamp jzrq;
//    @ApiModelProperty(value="汇总日期")
//    private Timestamp hzrq;
//    @ApiModelProperty(value="mzlb")
//    private Integer mzlb;
//    /**
//     * 设置:记录序号
//     */
//    public void setJlxh(Integer value) {
//        this.jlxh = value;
//    }
//    /**
//     * 获取:记录序号
//     */
//    public Integer getJlxh() {
//        return jlxh;
//    }
//    /**
//     * 设置:cardid
//     */
//    public void setCardid(Integer value) {
//        this.cardid = value;
//    }
//    /**
//     * 获取:cardid
//     */
//    public Integer getCardid() {
//        return cardid;
//    }
//    /**
//     * 设置:机构代码
//     */
//    public void setJgid(Integer value) {
//        this.jgid = value;
//    }
//    /**
//     * 获取:机构代码
//     */
//    public Integer getJgid() {
//        return jgid;
//    }
//    /**
//     * 设置:退费日期
//     */
//    public void setTfrq(Timestamp value) {
//        this.tfrq = value;
//    }
//    /**
//     * 获取:退费日期
//     */
//    public Timestamp getTfrq() {
//        return tfrq;
//    }
//    /**
//     * 设置:退费方式
//     */
//    public void setTffs(Integer value) {
//        this.tffs = value;
//    }
//    /**
//     * 获取:退费方式
//     */
//    public Integer getTffs() {
//        return tffs;
//    }
//    /**
//     * 设置:退费金额
//     */
//    public void setTfje(BigDecimal value) {
//        this.tfje = value;
//    }
//    /**
//     * 获取:退费金额
//     */
//    public BigDecimal getTfje() {
//        return tfje;
//    }
//    /**
//     * 设置:操作工号
//     */
//    public void setCzgh(String value) {
//        this.czgh = value;
//    }
//    /**
//     * 获取:操作工号
//     */
//    public String getCzgh() {
//        return czgh;
//    }
//    /**
//     * 设置:结账日期
//     */
//    public void setJzrq(Timestamp value) {
//        this.jzrq = value;
//    }
//    /**
//     * 获取:结账日期
//     */
//    public Timestamp getJzrq() {
//        return jzrq;
//    }
//    /**
//     * 设置:汇总日期
//     */
//    public void setHzrq(Timestamp value) {
//        this.hzrq = value;
//    }
//    /**
//     * 获取:汇总日期
//     */
//    public Timestamp getHzrq() {
//        return hzrq;
//    }
//    /**
//     * 设置:mzlb
//     */
//    public void setMzlb(Integer value) {
//        this.mzlb = value;
//    }
//    /**
//     * 获取:mzlb
//     */
//    public Integer getMzlb() {
//        return mzlb;
//    }
//}
