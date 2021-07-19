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
// * 类名称：OpThmx<br> 
// * 类描述：门诊_退号明细<br>
// * @author WY
// */
//@ApiModel(value="门诊_退号明细")
//public class OpThmxResp  extends  PageQuery{
//    @ApiModelProperty(value="识别序号")
//    private Integer sbxh;
//    @ApiModelProperty(value="机构ID")
//    private Integer jgid;
//    @ApiModelProperty(value="操作工号")
//    private String czgh;
//    @ApiModelProperty(value="结帐日期")
//    private Timestamp jzrq;
//    @ApiModelProperty(value="门诊类别")
//    private Integer mzlb;
//    @ApiModelProperty(value="汇总日期")
//    private Timestamp hzrq;
//    @ApiModelProperty(value="退号日期")
//    private Timestamp thrq;
//    /**
//     * 设置:识别序号
//     */
//    public void setSbxh(Integer value) {
//        this.sbxh = value;
//    }
//    /**
//     * 获取:识别序号
//     */
//    public Integer getSbxh() {
//        return sbxh;
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
//     * 设置:退号日期
//     */
//    public void setThrq(Timestamp value) {
//        this.thrq = value;
//    }
//    /**
//     * 获取:退号日期
//     */
//    public Timestamp getThrq() {
//        return thrq;
//    }
//}
