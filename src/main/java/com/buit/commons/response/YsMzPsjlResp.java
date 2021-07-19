package com.buit.commons.response;//
//package com.buit.cis.op.dctwork.response;
//
//import java.sql.Timestamp;
//
//import com.buit.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：YsMzPsjl<br> 
// * 类描述：门诊_门诊皮试记录<br>
// * @author 老花生
// */
//@ApiModel(value="门诊_门诊皮试记录")
//public class YsMzPsjlResp  extends  PageQuery{
//    @ApiModelProperty(value="记录编号")
//    private Integer jlbh;
//    @ApiModelProperty(value="病人编号")
//    private Integer brbh;
//    @ApiModelProperty(value="药品编号")
//    private Integer ypbh;
//    @ApiModelProperty(value="皮试结果")
//    private Integer psjg;
//    @ApiModelProperty(value="完成标志")
//    private Integer wcbz;
//    @ApiModelProperty(value="申请医生")
//    private String sqys;
//    @ApiModelProperty(value="申请时间")
//    private Timestamp sqsj;
//    @ApiModelProperty(value="皮试医生")
//    private String psys;
//    @ApiModelProperty(value="皮试时间")
//    private Timestamp pssj;
//    @ApiModelProperty(value="机构代码")
//    private Integer jgid;
//    @ApiModelProperty(value="处方识别")
//    private Integer cfsb;
//    @ApiModelProperty(value="过敏批号")
//    private String gmph;
//    /**
//     * 设置:记录编号
//     */
//    public void setJlbh(Integer value) {
//        this.jlbh = value;
//    }
//    /**
//     * 获取:记录编号
//     */
//    public Integer getJlbh() {
//        return jlbh;
//    }
//    /**
//     * 设置:病人编号
//     */
//    public void setBrbh(Integer value) {
//        this.brbh = value;
//    }
//    /**
//     * 获取:病人编号
//     */
//    public Integer getBrbh() {
//        return brbh;
//    }
//    /**
//     * 设置:药品编号
//     */
//    public void setYpbh(Integer value) {
//        this.ypbh = value;
//    }
//    /**
//     * 获取:药品编号
//     */
//    public Integer getYpbh() {
//        return ypbh;
//    }
//    /**
//     * 设置:皮试结果
//     */
//    public void setPsjg(Integer value) {
//        this.psjg = value;
//    }
//    /**
//     * 获取:皮试结果
//     */
//    public Integer getPsjg() {
//        return psjg;
//    }
//    /**
//     * 设置:完成标志
//     */
//    public void setWcbz(Integer value) {
//        this.wcbz = value;
//    }
//    /**
//     * 获取:完成标志
//     */
//    public Integer getWcbz() {
//        return wcbz;
//    }
//    /**
//     * 设置:申请医生
//     */
//    public void setSqys(String value) {
//        this.sqys = value;
//    }
//    /**
//     * 获取:申请医生
//     */
//    public String getSqys() {
//        return sqys;
//    }
//    /**
//     * 设置:申请时间
//     */
//    public void setSqsj(Timestamp value) {
//        this.sqsj = value;
//    }
//    /**
//     * 获取:申请时间
//     */
//    public Timestamp getSqsj() {
//        return sqsj;
//    }
//    /**
//     * 设置:皮试医生
//     */
//    public void setPsys(String value) {
//        this.psys = value;
//    }
//    /**
//     * 获取:皮试医生
//     */
//    public String getPsys() {
//        return psys;
//    }
//    /**
//     * 设置:皮试时间
//     */
//    public void setPssj(Timestamp value) {
//        this.pssj = value;
//    }
//    /**
//     * 获取:皮试时间
//     */
//    public Timestamp getPssj() {
//        return pssj;
//    }
//    /**
//     * 设置:机构代码
//     */
//    public void setJgid(String value) {
//        this.jgid = value;
//    }
//    /**
//     * 获取:机构代码
//     */
//    public String getJgid() {
//        return jgid;
//    }
//    /**
//     * 设置:处方识别
//     */
//    public void setCfsb(Integer value) {
//        this.cfsb = value;
//    }
//    /**
//     * 获取:处方识别
//     */
//    public Integer getCfsb() {
//        return cfsb;
//    }
//    /**
//     * 设置:过敏批号
//     */
//    public void setGmph(String value) {
//        this.gmph = value;
//    }
//    /**
//     * 获取:过敏批号
//     */
//    public String getGmph() {
//        return gmph;
//    }
//}