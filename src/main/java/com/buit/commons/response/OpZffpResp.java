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
// * 类名称：OpZffp<br> 
// * 类描述：门诊_作废发票<br>
// * @author WY
// */
//@ApiModel(value="门诊_作废发票")
//public class OpZffpResp  extends  PageQuery{
//    @ApiModelProperty(value="门诊序号")
//    private Integer mzxh;
//    @ApiModelProperty(value="机构代码")
//    private Integer jgid;
//    @ApiModelProperty(value="发票号码")
//    private String fphm;
//    @ApiModelProperty(value="操作工号")
//    private String czgh;
//    @ApiModelProperty(value="结帐日期")
//    private Timestamp jzrq;
//    @ApiModelProperty(value="门诊类别")
//    private Integer mzlb;
//    @ApiModelProperty(value="汇总日期")
//    private Timestamp hzrq;
//    @ApiModelProperty(value="作废日期")
//    private Timestamp zfrq;
//    /**
//     * 设置:门诊序号
//     */
//    public void setMzxh(Integer value) {
//        this.mzxh = value;
//    }
//    /**
//     * 获取:门诊序号
//     */
//    public Integer getMzxh() {
//        return mzxh;
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
//     * 设置:发票号码
//     */
//    public void setFphm(String value) {
//        this.fphm = value;
//    }
//    /**
//     * 获取:发票号码
//     */
//    public String getFphm() {
//        return fphm;
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
//     * 设置:作废日期
//     */
//    public void setZfrq(Timestamp value) {
//        this.zfrq = value;
//    }
//    /**
//     * 获取:作废日期
//     */
//    public Timestamp getZfrq() {
//        return zfrq;
//    }
//}
