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
// * 类名称：SyJydjzb<br> 
// * 类描述：输液/注射接药登记主表<br>
// * @author WY
// */
//@ApiModel(value="输液/注射接药登记主表")
//public class SyJydjzbReq  extends  PageQuery{
//    @ApiModelProperty(value="医疗机构代码")
//    private Integer jgid;
//    @ApiModelProperty(value="科室代码 主键 HIS科室代码")
//    private Integer ksdm;
//    @ApiModelProperty(value="登记单号")
//    private String djdh;
//    @ApiModelProperty(value="科室类别 1输液室/2注射室")
//    private String kslb;
//    @ApiModelProperty(value="登记时间")
//    private Timestamp djsj;
//    @ApiModelProperty(value="门诊号")
//    private String mzhm;
//    @ApiModelProperty(value="发票号")
//    private String fphm;
//    @ApiModelProperty(value="卡号")
//    private String jzkh;
//    @ApiModelProperty(value="输液/注射日期")
//    private Date syrq;
//    @ApiModelProperty(value="登记人代码")
//    private String djrdm;
//    @ApiModelProperty(value="状态 1 输液/注射中/2 输液/注射完成")
//    private String zt;
//    @ApiModelProperty(value="完成时间")
//    private Timestamp wcsj;
//    @ApiModelProperty(value="完成操作人代码")
//    private String wcczrdm;
//    /**
//     * 设置:医疗机构代码
//     */
//    public void setJgid(Integer value) {
//        this.jgid = value;
//    }
//    /**
//     * 获取:医疗机构代码
//     */
//    public Integer getJgid() {
//        return jgid;
//    }
//    /**
//     * 设置:科室代码 主键 HIS科室代码
//     */
//    public void setKsdm(Integer value) {
//        this.ksdm = value;
//    }
//    /**
//     * 获取:科室代码 主键 HIS科室代码
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
//     * 设置:科室类别 1输液室/2注射室
//     */
//    public void setKslb(String value) {
//        this.kslb = value;
//    }
//    /**
//     * 获取:科室类别 1输液室/2注射室
//     */
//    public String getKslb() {
//        return kslb;
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
//     * 设置:门诊号
//     */
//    public void setMzhm(String value) {
//        this.mzhm = value;
//    }
//    /**
//     * 获取:门诊号
//     */
//    public String getMzhm() {
//        return mzhm;
//    }
//    /**
//     * 设置:发票号
//     */
//    public void setFphm(String value) {
//        this.fphm = value;
//    }
//    /**
//     * 获取:发票号
//     */
//    public String getFphm() {
//        return fphm;
//    }
//    /**
//     * 设置:卡号
//     */
//    public void setJzkh(String value) {
//        this.jzkh = value;
//    }
//    /**
//     * 获取:卡号
//     */
//    public String getJzkh() {
//        return jzkh;
//    }
//    /**
//     * 设置:输液/注射日期
//     */
//    public void setSyrq(Date value) {
//        this.syrq = value;
//    }
//    /**
//     * 获取:输液/注射日期
//     */
//    public Date getSyrq() {
//        return syrq;
//    }
//    /**
//     * 设置:登记人代码
//     */
//    public void setDjrdm(String value) {
//        this.djrdm = value;
//    }
//    /**
//     * 获取:登记人代码
//     */
//    public String getDjrdm() {
//        return djrdm;
//    }
//    /**
//     * 设置:状态 1 输液/注射中/2 输液/注射完成
//     */
//    public void setZt(String value) {
//        this.zt = value;
//    }
//    /**
//     * 获取:状态 1 输液/注射中/2 输液/注射完成
//     */
//    public String getZt() {
//        return zt;
//    }
//    /**
//     * 设置:完成时间
//     */
//    public void setWcsj(Timestamp value) {
//        this.wcsj = value;
//    }
//    /**
//     * 获取:完成时间
//     */
//    public Timestamp getWcsj() {
//        return wcsj;
//    }
//    /**
//     * 设置:完成操作人代码
//     */
//    public void setWcczrdm(String value) {
//        this.wcczrdm = value;
//    }
//    /**
//     * 获取:完成操作人代码
//     */
//    public String getWcczrdm() {
//        return wcczrdm;
//    }
//}