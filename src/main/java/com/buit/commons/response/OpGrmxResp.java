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
// * 类名称：OpGrmx<br> 
// * 类描述：门诊_挂号日报明细<br>
// * @author WY
// */
//@ApiModel(value="门诊_挂号日报明细")
//public class OpGrmxResp  extends  PageQuery{
//    @ApiModelProperty(value="操作工号")
//    private String czgh;
//    @ApiModelProperty(value="就诊日期")
//    private Timestamp jzrq;
//    @ApiModelProperty(value="病人性质")
//    private Integer brxz;
//    @ApiModelProperty(value="机构ID")
//    private Integer jgid;
//    @ApiModelProperty(value="收费金额")
//    private BigDecimal sfje;
//    @ApiModelProperty(value="发票张数")
//    private Integer fpzs;
//    @ApiModelProperty(value="挂号金额")
//    private BigDecimal ghje;
//    @ApiModelProperty(value="诊疗金额")
//    private BigDecimal zlje;
//    @ApiModelProperty(value="专家金额")
//    private BigDecimal zjfy;
//    @ApiModelProperty(value="病历金额")
//    private BigDecimal blje;
//    @ApiModelProperty(value="mzlb")
//    private Integer mzlb;
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
//     * 设置:就诊日期
//     */
//    public void setJzrq(Timestamp value) {
//        this.jzrq = value;
//    }
//    /**
//     * 获取:就诊日期
//     */
//    public Timestamp getJzrq() {
//        return jzrq;
//    }
//    /**
//     * 设置:病人性质
//     */
//    public void setBrxz(Integer value) {
//        this.brxz = value;
//    }
//    /**
//     * 获取:病人性质
//     */
//    public Integer getBrxz() {
//        return brxz;
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
//     * 设置:收费金额
//     */
//    public void setSfje(BigDecimal value) {
//        this.sfje = value;
//    }
//    /**
//     * 获取:收费金额
//     */
//    public BigDecimal getSfje() {
//        return sfje;
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
//     * 设置:挂号金额
//     */
//    public void setGhje(BigDecimal value) {
//        this.ghje = value;
//    }
//    /**
//     * 获取:挂号金额
//     */
//    public BigDecimal getGhje() {
//        return ghje;
//    }
//    /**
//     * 设置:诊疗金额
//     */
//    public void setZlje(BigDecimal value) {
//        this.zlje = value;
//    }
//    /**
//     * 获取:诊疗金额
//     */
//    public BigDecimal getZlje() {
//        return zlje;
//    }
//    /**
//     * 设置:专家金额
//     */
//    public void setZjfy(BigDecimal value) {
//        this.zjfy = value;
//    }
//    /**
//     * 获取:专家金额
//     */
//    public BigDecimal getZjfy() {
//        return zjfy;
//    }
//    /**
//     * 设置:病历金额
//     */
//    public void setBlje(BigDecimal value) {
//        this.blje = value;
//    }
//    /**
//     * 获取:病历金额
//     */
//    public BigDecimal getBlje() {
//        return blje;
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
