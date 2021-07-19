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
// * 类名称：SyCfzxqk<br> 
// * 类描述：<br>
// * @author WY
// */
//@ApiModel(value="")
//public class SyCfzxqkResp  extends  PageQuery{
//    @ApiModelProperty(value="机构ID")
//    private Integer jgid;
//    @ApiModelProperty(value="处方号码")
//    private Integer cfhm;
//    @ApiModelProperty(value="处方组号")
//    private Integer cfzh;
//    @ApiModelProperty(value="需要执行总次数")
//    private Integer xyzxzcs;
//    @ApiModelProperty(value="已执行次数")
//    private Integer yzxcs;
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
//     * 设置:处方号码
//     */
//    public void setCfhm(Integer value) {
//        this.cfhm = value;
//    }
//    /**
//     * 获取:处方号码
//     */
//    public Integer getCfhm() {
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
//     * 设置:需要执行总次数
//     */
//    public void setXyzxzcs(Integer value) {
//        this.xyzxzcs = value;
//    }
//    /**
//     * 获取:需要执行总次数
//     */
//    public Integer getXyzxzcs() {
//        return xyzxzcs;
//    }
//    /**
//     * 设置:已执行次数
//     */
//    public void setYzxcs(Integer value) {
//        this.yzxcs = value;
//    }
//    /**
//     * 获取:已执行次数
//     */
//    public Integer getYzxcs() {
//        return yzxcs;
//    }
//}