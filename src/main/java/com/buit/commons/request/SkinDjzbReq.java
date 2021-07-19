//   
//package com.buit.commons.request;
//
//import java.sql.Timestamp;
//
//import com.his.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：SkinDjzb<br> 
// * 类描述：<br>
// * @author WY
// */
//@ApiModel(value="")
//public class SkinDjzbReq  extends  PageQuery{
//    @ApiModelProperty(value="机构ID")
//    private Integer jgid;
//    @ApiModelProperty(value="输液科室代码")
//    private Integer ksdm;
//    @ApiModelProperty(value="登记单号")
//    private String djdh;
//    @ApiModelProperty(value="登记时间")
//    private Timestamp djsj;
//    @ApiModelProperty(value="就诊卡号")
//    private String jzkh;
//    @ApiModelProperty(value="登记人代码")
//    private Integer djrdm;
//    @ApiModelProperty(value="状态：0:未开始 1:皮试中 2:皮试完成")
//    private String zt;
//    @ApiModelProperty(value="皮试ID")
//    private Integer psid;
//    @ApiModelProperty(value="皮试项目名称")
//    private String psmc;
//    @ApiModelProperty(value="皮试序号")
//    private Integer psxh;
//    @ApiModelProperty(value="开始时间")
//    private Timestamp kssj;
//    @ApiModelProperty(value="结束时间")
//    private Timestamp jssj;
//    @ApiModelProperty(value="实际皮试时长(分钟)")
//    private Integer sjpssc;
//    @ApiModelProperty(value="皮试结果: 3阳 2阴")
//    private Integer psjg;
//    @ApiModelProperty(value="填写人代码")
//    private String txrdm;
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
//     * 设置:输液科室代码
//     */
//    public void setKsdm(Integer value) {
//        this.ksdm = value;
//    }
//    /**
//     * 获取:输液科室代码
//     */
//    public Integer getKsdm() {
//        return ksdm;
//    }
//    /**
//     * 设置:登记单号
//     */
//    public void setDjdh(String value) {
//        this.djdh = value;
//    }
//    /**
//     * 获取:登记单号
//     */
//    public String getDjdh() {
//        return djdh;
//    }
//    /**
//     * 设置:登记时间
//     */
//    public void setDjsj(Timestamp value) {
//        this.djsj = value;
//    }
//    /**
//     * 获取:登记时间
//     */
//    public Timestamp getDjsj() {
//        return djsj;
//    }
//    /**
//     * 设置:就诊卡号
//     */
//    public void setJzkh(String value) {
//        this.jzkh = value;
//    }
//    /**
//     * 获取:就诊卡号
//     */
//    public String getJzkh() {
//        return jzkh;
//    }
//    /**
//     * 设置:登记人代码
//     */
//    public void setDjrdm(Integer value) {
//        this.djrdm = value;
//    }
//    /**
//     * 获取:登记人代码
//     */
//    public Integer getDjrdm() {
//        return djrdm;
//    }
//    /**
//     * 设置:状态：0:未开始 1:皮试中 2:皮试完成
//     */
//    public void setZt(String value) {
//        this.zt = value;
//    }
//    /**
//     * 获取:状态：0:未开始 1:皮试中 2:皮试完成
//     */
//    public String getZt() {
//        return zt;
//    }
//    /**
//     * 设置:皮试ID
//     */
//    public void setPsid(Integer value) {
//        this.psid = value;
//    }
//    /**
//     * 获取:皮试ID
//     */
//    public Integer getPsid() {
//        return psid;
//    }
//    /**
//     * 设置:皮试项目名称
//     */
//    public void setPsmc(String value) {
//        this.psmc = value;
//    }
//    /**
//     * 获取:皮试项目名称
//     */
//    public String getPsmc() {
//        return psmc;
//    }
//    /**
//     * 设置:皮试序号
//     */
//    public void setPsxh(Integer value) {
//        this.psxh = value;
//    }
//    /**
//     * 获取:皮试序号
//     */
//    public Integer getPsxh() {
//        return psxh;
//    }
//    /**
//     * 设置:开始时间
//     */
//    public void setKssj(Timestamp value) {
//        this.kssj = value;
//    }
//    /**
//     * 获取:开始时间
//     */
//    public Timestamp getKssj() {
//        return kssj;
//    }
//    /**
//     * 设置:结束时间
//     */
//    public void setJssj(Timestamp value) {
//        this.jssj = value;
//    }
//    /**
//     * 获取:结束时间
//     */
//    public Timestamp getJssj() {
//        return jssj;
//    }
//    /**
//     * 设置:实际皮试时长(分钟)
//     */
//    public void setSjpssc(Integer value) {
//        this.sjpssc = value;
//    }
//    /**
//     * 获取:实际皮试时长(分钟)
//     */
//    public Integer getSjpssc() {
//        return sjpssc;
//    }
//    /**
//     * 设置:皮试结果: 3阳 2阴
//     */
//    public void setPsjg(Integer value) {
//        this.psjg = value;
//    }
//    /**
//     * 获取:皮试结果: 3阳 2阴
//     */
//    public Integer getPsjg() {
//        return psjg;
//    }
//    /**
//     * 设置:填写人代码
//     */
//    public void setTxrdm(String value) {
//        this.txrdm = value;
//    }
//    /**
//     * 获取:填写人代码
//     */
//    public String getTxrdm() {
//        return txrdm;
//    }
//}
