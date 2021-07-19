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
// * 类名称：OpYnzzsq<br> 
// * 类描述：院内转诊申请<br>
// * @author 老花生
// */
//@ApiModel(value="院内转诊申请")
//public class OpYnzzsqResp  extends  PageQuery{
//    @ApiModelProperty(value="编号(主键ID)")
//    private Integer sqdh;
//    @ApiModelProperty(value="机构id")
//    private Integer jgid;
//    @ApiModelProperty(value="病人id")
//    private String brid;
//    @ApiModelProperty(value="目前就诊科室")
//    private Integer jzks;
//    @ApiModelProperty(value="病人姓名")
//    private String brxm;
//    @ApiModelProperty(value="病人年龄")
//    private String brnl;
//    @ApiModelProperty(value="转诊科室")
//    private Integer zzks;
//    @ApiModelProperty(value="目前诊断")
//    private String sqzd;
//    @ApiModelProperty(value="转诊目的")
//    private String zzmd;
//    @ApiModelProperty(value="转诊医生")
//    private String jzys;
//    @ApiModelProperty(value="转诊日期")
//    private Timestamp sqrq;
//    @ApiModelProperty(value="作废")
//    private Integer zfbz;
//    @ApiModelProperty(value="jzkh")
//    private String jzkh;
//    @ApiModelProperty(value="brxb")
//    private Integer brxb;
//    /**
//     * 设置:编号(主键ID)
//     */
//    public void setSqdh(Integer value) {
//        this.sqdh = value;
//    }
//    /**
//     * 获取:编号(主键ID)
//     */
//    public Integer getSqdh() {
//        return sqdh;
//    }
//    /**
//     * 设置:机构id
//     */
//    public void setJgid(Integer value) {
//        this.jgid = value;
//    }
//    /**
//     * 获取:机构id
//     */
//    public Integer getJgid() {
//        return jgid;
//    }
//    /**
//     * 设置:病人id
//     */
//    public void setBrid(String value) {
//        this.brid = value;
//    }
//    /**
//     * 获取:病人id
//     */
//    public String getBrid() {
//        return brid;
//    }
//    /**
//     * 设置:目前就诊科室
//     */
//    public void setJzks(Integer value) {
//        this.jzks = value;
//    }
//    /**
//     * 获取:目前就诊科室
//     */
//    public Integer getJzks() {
//        return jzks;
//    }
//    /**
//     * 设置:病人姓名
//     */
//    public void setBrxm(String value) {
//        this.brxm = value;
//    }
//    /**
//     * 获取:病人姓名
//     */
//    public String getBrxm() {
//        return brxm;
//    }
//    /**
//     * 设置:病人年龄
//     */
//    public void setBrnl(String value) {
//        this.brnl = value;
//    }
//    /**
//     * 获取:病人年龄
//     */
//    public String getBrnl() {
//        return brnl;
//    }
//    /**
//     * 设置:转诊科室
//     */
//    public void setZzks(Integer value) {
//        this.zzks = value;
//    }
//    /**
//     * 获取:转诊科室
//     */
//    public Integer getZzks() {
//        return zzks;
//    }
//    /**
//     * 设置:目前诊断
//     */
//    public void setSqzd(String value) {
//        this.sqzd = value;
//    }
//    /**
//     * 获取:目前诊断
//     */
//    public String getSqzd() {
//        return sqzd;
//    }
//    /**
//     * 设置:转诊目的
//     */
//    public void setZzmd(String value) {
//        this.zzmd = value;
//    }
//    /**
//     * 获取:转诊目的
//     */
//    public String getZzmd() {
//        return zzmd;
//    }
//    /**
//     * 设置:转诊医生
//     */
//    public void setJzys(String value) {
//        this.jzys = value;
//    }
//    /**
//     * 获取:转诊医生
//     */
//    public String getJzys() {
//        return jzys;
//    }
//    /**
//     * 设置:转诊日期
//     */
//    public void setSqrq(Timestamp value) {
//        this.sqrq = value;
//    }
//    /**
//     * 获取:转诊日期
//     */
//    public Timestamp getSqrq() {
//        return sqrq;
//    }
//    /**
//     * 设置:作废
//     */
//    public void setZfbz(Integer value) {
//        this.zfbz = value;
//    }
//    /**
//     * 获取:作废
//     */
//    public Integer getZfbz() {
//        return zfbz;
//    }
//    /**
//     * 设置:jzkh
//     */
//    public void setJzkh(String value) {
//        this.jzkh = value;
//    }
//    /**
//     * 获取:jzkh
//     */
//    public String getJzkh() {
//        return jzkh;
//    }
//    /**
//     * 设置:brxb
//     */
//    public void setBrxb(Integer value) {
//        this.brxb = value;
//    }
//    /**
//     * 获取:brxb
//     */
//    public Integer getBrxb() {
//        return brxb;
//    }
//}
