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
// * 类名称：OpGhrb<br> 
// * 类描述：门诊_挂号日报<br>
// * @author WY
// */
//@ApiModel(value="门诊_挂号日报")
//public class OpGhrbResp  extends  PageQuery{
//    @ApiModelProperty(value="操作工号")
//    private String czgh;
//    @ApiModelProperty(value="结帐日期")
//    private Timestamp jzrq;
//    @ApiModelProperty(value="机构ID")
//    private Integer jgid;
//    @ApiModelProperty(value="起止票据")
//    private String qzpj;
//    @ApiModelProperty(value="总计金额")
//    private BigDecimal zjje;
//    @ApiModelProperty(value="现金金额")
//    private BigDecimal xjje;
//    @ApiModelProperty(value="支票金额")
//    private BigDecimal zpje;
//    @ApiModelProperty(value="帐户金额")
//    private BigDecimal zhje;
//    @ApiModelProperty(value="其他应收")
//    private BigDecimal qtys;
//    @ApiModelProperty(value="货币误差")
//    private BigDecimal hbwc;
//    @ApiModelProperty(value="汇总日期")
//    private Timestamp hzrq;
//    @ApiModelProperty(value="发票张数")
//    private Integer fpzs;
//    @ApiModelProperty(value="门诊类别")
//    private Integer mzlb;
//    @ApiModelProperty(value="退号发票")
//    private String thfp;
//    @ApiModelProperty(value="退号数量")
//    private Integer thsl;
//    @ApiModelProperty(value="退号金额")
//    private BigDecimal thje;
//    @ApiModelProperty(value="转科发票张数")
//    private Integer zksl;
//    @ApiModelProperty(value="转科发票")
//    private String zkfp;
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
//     * 设置:结帐日期
//     */
//    public void setJzrq(Timestamp value) {
//        this.jzrq = value;
//    }
//    /**
//     * 获取:结帐日期
//     */
//    public Timestamp getJzrq() {
//        return jzrq;
//    }
//    /**
//     * 设置:机构ID
//     */
//    public void setJgid(Integer value) {
//        this.jgid = value;
//    }
//    /**
//     * 获取:机构ID
//     */
//    public Integer getJgid() {
//        return jgid;
//    }
//    /**
//     * 设置:起止票据
//     */
//    public void setQzpj(String value) {
//        this.qzpj = value;
//    }
//    /**
//     * 获取:起止票据
//     */
//    public String getQzpj() {
//        return qzpj;
//    }
//    /**
//     * 设置:总计金额
//     */
//    public void setZjje(BigDecimal value) {
//        this.zjje = value;
//    }
//    /**
//     * 获取:总计金额
//     */
//    public BigDecimal getZjje() {
//        return zjje;
//    }
//    /**
//     * 设置:现金金额
//     */
//    public void setXjje(BigDecimal value) {
//        this.xjje = value;
//    }
//    /**
//     * 获取:现金金额
//     */
//    public BigDecimal getXjje() {
//        return xjje;
//    }
//    /**
//     * 设置:支票金额
//     */
//    public void setZpje(BigDecimal value) {
//        this.zpje = value;
//    }
//    /**
//     * 获取:支票金额
//     */
//    public BigDecimal getZpje() {
//        return zpje;
//    }
//    /**
//     * 设置:帐户金额
//     */
//    public void setZhje(BigDecimal value) {
//        this.zhje = value;
//    }
//    /**
//     * 获取:帐户金额
//     */
//    public BigDecimal getZhje() {
//        return zhje;
//    }
//    /**
//     * 设置:其他应收
//     */
//    public void setQtys(BigDecimal value) {
//        this.qtys = value;
//    }
//    /**
//     * 获取:其他应收
//     */
//    public BigDecimal getQtys() {
//        return qtys;
//    }
//    /**
//     * 设置:货币误差
//     */
//    public void setHbwc(BigDecimal value) {
//        this.hbwc = value;
//    }
//    /**
//     * 获取:货币误差
//     */
//    public BigDecimal getHbwc() {
//        return hbwc;
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
//     * 设置:发票张数
//     */
//    public void setFpzs(Integer value) {
//        this.fpzs = value;
//    }
//    /**
//     * 获取:发票张数
//     */
//    public Integer getFpzs() {
//        return fpzs;
//    }
//    /**
//     * 设置:门诊类别
//     */
//    public void setMzlb(Integer value) {
//        this.mzlb = value;
//    }
//    /**
//     * 获取:门诊类别
//     */
//    public Integer getMzlb() {
//        return mzlb;
//    }
//    /**
//     * 设置:退号发票
//     */
//    public void setThfp(String value) {
//        this.thfp = value;
//    }
//    /**
//     * 获取:退号发票
//     */
//    public String getThfp() {
//        return thfp;
//    }
//    /**
//     * 设置:退号数量
//     */
//    public void setThsl(Integer value) {
//        this.thsl = value;
//    }
//    /**
//     * 获取:退号数量
//     */
//    public Integer getThsl() {
//        return thsl;
//    }
//    /**
//     * 设置:退号金额
//     */
//    public void setThje(BigDecimal value) {
//        this.thje = value;
//    }
//    /**
//     * 获取:退号金额
//     */
//    public BigDecimal getThje() {
//        return thje;
//    }
//    /**
//     * 设置:转科发票张数
//     */
//    public void setZksl(Integer value) {
//        this.zksl = value;
//    }
//    /**
//     * 获取:转科发票张数
//     */
//    public Integer getZksl() {
//        return zksl;
//    }
//    /**
//     * 设置:转科发票
//     */
//    public void setZkfp(String value) {
//        this.zkfp = value;
//    }
//    /**
//     * 获取:转科发票
//     */
//    public String getZkfp() {
//        return zkfp;
//    }
//}
