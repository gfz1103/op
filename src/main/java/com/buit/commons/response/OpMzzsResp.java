//   
//package com.buit.his.op.reg..response;
//
//import java.sql.Timestamp;
//
//import com.his.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：OpMzzs<br> 
// * 类描述：门诊诊室信息<br>
// * @author WY
// */
//@ApiModel(value="门诊诊室信息")
//public class OpMzzsResp  extends  PageQuery{
//    @ApiModelProperty(value="识别序号")
//    private BigDecimal sbxh;
//    @ApiModelProperty(value="挂号科室")
//    private BigDecimal ghks;
//    @ApiModelProperty(value="诊室ID")
//    private Integer zsid;
//    @ApiModelProperty(value="诊室名称")
//    private String zsmc;
//    @ApiModelProperty(value="语音信息")
//    private String yyxx;
//    @ApiModelProperty(value="屏幕ID")
//    private String pmid;
//    @ApiModelProperty(value="是否叫号(1是,2否)")
//    private String sfjh;
//    @ApiModelProperty(value="是否启用(1启用,2禁用)")
//    private String sfqy;
//    /**
//     * 设置:识别序号
//     */
//    public void setSbxh(BigDecimal value) {
//        this.sbxh = value;
//    }
//    /**
//     * 获取:识别序号
//     */
//    public BigDecimal getSbxh() {
//        return sbxh;
//    }
//    /**
//     * 设置:挂号科室
//     */
//    public void setGhks(BigDecimal value) {
//        this.ghks = value;
//    }
//    /**
//     * 获取:挂号科室
//     */
//    public BigDecimal getGhks() {
//        return ghks;
//    }
//    /**
//     * 设置:诊室ID
//     */
//    public void setZsid(Integer value) {
//        this.zsid = value;
//    }
//    /**
//     * 获取:诊室ID
//     */
//    public Integer getZsid() {
//        return zsid;
//    }
//    /**
//     * 设置:诊室名称
//     */
//    public void setZsmc(String value) {
//        this.zsmc = value;
//    }
//    /**
//     * 获取:诊室名称
//     */
//    public String getZsmc() {
//        return zsmc;
//    }
//    /**
//     * 设置:语音信息
//     */
//    public void setYyxx(String value) {
//        this.yyxx = value;
//    }
//    /**
//     * 获取:语音信息
//     */
//    public String getYyxx() {
//        return yyxx;
//    }
//    /**
//     * 设置:屏幕ID
//     */
//    public void setPmid(String value) {
//        this.pmid = value;
//    }
//    /**
//     * 获取:屏幕ID
//     */
//    public String getPmid() {
//        return pmid;
//    }
//    /**
//     * 设置:是否叫号(1是,2否)
//     */
//    public void setSfjh(String value) {
//        this.sfjh = value;
//    }
//    /**
//     * 获取:是否叫号(1是,2否)
//     */
//    public String getSfjh() {
//        return sfjh;
//    }
//    /**
//     * 设置:是否启用(1启用,2禁用)
//     */
//    public void setSfqy(String value) {
//        this.sfqy = value;
//    }
//    /**
//     * 获取:是否启用(1启用,2禁用)
//     */
//    public String getSfqy() {
//        return sfqy;
//    }
//}
