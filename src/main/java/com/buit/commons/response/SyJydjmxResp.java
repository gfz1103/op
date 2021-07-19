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
// * 类名称：SyJydjmx<br> 
// * 类描述：输液/注射接药登记明细表<br>
// * @author WY
// */
//@ApiModel(value="输液/注射接药登记明细表")
//public class SyJydjmxResp  extends  PageQuery{
//    @ApiModelProperty(value="医疗机构代码")
//    private Integer jgid;
//    @ApiModelProperty(value="输液科室代码")
//    private Integer ksdm;
//    @ApiModelProperty(value="登记单号")
//    private String djdh;
//    @ApiModelProperty(value="输液/注射序号")
//    private Integer xh;
//    @ApiModelProperty(value="处方号")
//    private String cfhm;
//    @ApiModelProperty(value="处方组号")
//    private Integer cfzh;
//    @ApiModelProperty(value="药品序号")
//    private Integer ypxh;
//    @ApiModelProperty(value="门诊号码")
//    private String mzhm;
//    @ApiModelProperty(value="发票号码")
//    private String fphm;
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
//     * 设置:输液/注射序号
//     */
//    public void setXh(Integer value) {
//        this.xh = value;
//    }
//    /**
//     * 获取:输液/注射序号
//     */
//    public Integer getXh() {
//        return xh;
//    }
//    /**
//     * 设置:处方号
//     */
//    public void setCfhm(String value) {
//        this.cfhm = value;
//    }
//    /**
//     * 获取:处方号
//     */
//    public String getCfhm() {
//        return cfhm;
//    }
//    /**
//     * 设置:处方组号
//     */
//    public void setCfzh(Integer value) {
//        this.cfzh = value;
//    }
//    /**
//     * 获取:处方组号
//     */
//    public Integer getCfzh() {
//        return cfzh;
//    }
//    /**
//     * 设置:药品序号
//     */
//    public void setYpxh(Integer value) {
//        this.ypxh = value;
//    }
//    /**
//     * 获取:药品序号
//     */
//    public Integer getYpxh() {
//        return ypxh;
//    }
//    /**
//     * 设置:门诊号码
//     */
//    public void setMzhm(String value) {
//        this.mzhm = value;
//    }
//    /**
//     * 获取:门诊号码
//     */
//    public String getMzhm() {
//        return mzhm;
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
//}