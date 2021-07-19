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
// * 类名称：WlCk01<br> 
// * 类描述：<br>
// * @author WY
// */
//@ApiModel(value="")
//public class WlCk01Resp  extends  PageQuery{
//    @ApiModelProperty(value="单据序号")
//    private Integer djxh;
//    @ApiModelProperty(value="机构标志")
//    private Integer jgid;
//    @ApiModelProperty(value="库房序号")
//    private Integer kfxh;
//    @ApiModelProperty(value="账簿类别")
//    private Integer zblb;
//    @ApiModelProperty(value="流转单号")
//    private String lzdh;
//    @ApiModelProperty(value="流转方式")
//    private Integer lzfs;
//    @ApiModelProperty(value="出库科室")
//    private Integer ksdm;
//    @ApiModelProperty(value="出库库房")
//    private Integer ckkf;
//    @ApiModelProperty(value="出库日期")
//    private Timestamp ckrq;
//    @ApiModelProperty(value="经办人员")
//    private String jbgh;
//    @ApiModelProperty(value="单据类型 | 0:正常出库单　1:备库产生出库单　2:病人消耗出库单 3:盘点产生出库单 4.包裹产生出库单  5:被服加工材料出库单")
//    private Integer djlx;
//    @ApiModelProperty(value="加工方式 | 0:正常 1:外加工出库")
//    private Integer jgfs;
//    @ApiModelProperty(value="制单日期")
//    private Timestamp zdrq;
//    @ApiModelProperty(value="制单人员")
//    private String zdgh;
//    @ApiModelProperty(value="审核日期")
//    private Timestamp shrq;
//    @ApiModelProperty(value="审核人员")
//    private String shgh;
//    @ApiModelProperty(value="记账日期")
//    private Timestamp jzrq;
//    @ApiModelProperty(value="记账工号")
//    private String jzgh;
//    @ApiModelProperty(value="单据状态 | 0：新增 1：审核 2：记帐  ")
//    private Integer djzt;
//    @ApiModelProperty(value="退回单据")
//    private Integer thdj;
//    @ApiModelProperty(value="单据备注")
//    private String djbz;
//    @ApiModelProperty(value="盘点单据")
//    private Integer pddj;
//    @ApiModelProperty(value="出库方式 | 2级别库房出库方式:0 消耗出口;1领用消耗;2科室消耗")
//    private Integer ckfs;
//    @ApiModelProperty(value="申领人员")
//    private String slgh;
//    @ApiModelProperty(value="单据金额")
//    private BigDecimal djje;
//    @ApiModelProperty(value="确认标志 | 0：未确认  1：确认")
//    private Integer qrbz;
//    @ApiModelProperty(value="确认流转方式")
//    private Integer qrrk;
//    @ApiModelProperty(value="确认日期")
//    private Timestamp qrrq;
//    @ApiModelProperty(value="确认人员")
//    private String qrgh;
//    @ApiModelProperty(value="入库单据")
//    private Integer rkdj;
//    /**
//     * 设置:单据序号
//     */
//    public void setDjxh(Integer value) {
//        this.djxh = value;
//    }
//    /**
//     * 获取:单据序号
//     */
//    public Integer getDjxh() {
//        return djxh;
//    }
//    /**
//     * 设置:机构标志
//     */
//    public void setJgid(Integer value) {
//        this.jgid = value;
//    }
//    /**
//     * 获取:机构标志
//     */
//    public Integer getJgid() {
//        return jgid;
//    }
//    /**
//     * 设置:库房序号
//     */
//    public void setKfxh(Integer value) {
//        this.kfxh = value;
//    }
//    /**
//     * 获取:库房序号
//     */
//    public Integer getKfxh() {
//        return kfxh;
//    }
//    /**
//     * 设置:账簿类别
//     */
//    public void setZblb(Integer value) {
//        this.zblb = value;
//    }
//    /**
//     * 获取:账簿类别
//     */
//    public Integer getZblb() {
//        return zblb;
//    }
//    /**
//     * 设置:流转单号
//     */
//    public void setLzdh(String value) {
//        this.lzdh = value;
//    }
//    /**
//     * 获取:流转单号
//     */
//    public String getLzdh() {
//        return lzdh;
//    }
//    /**
//     * 设置:流转方式
//     */
//    public void setLzfs(Integer value) {
//        this.lzfs = value;
//    }
//    /**
//     * 获取:流转方式
//     */
//    public Integer getLzfs() {
//        return lzfs;
//    }
//    /**
//     * 设置:出库科室
//     */
//    public void setKsdm(Integer value) {
//        this.ksdm = value;
//    }
//    /**
//     * 获取:出库科室
//     */
//    public Integer getKsdm() {
//        return ksdm;
//    }
//    /**
//     * 设置:出库库房
//     */
//    public void setCkkf(Integer value) {
//        this.ckkf = value;
//    }
//    /**
//     * 获取:出库库房
//     */
//    public Integer getCkkf() {
//        return ckkf;
//    }
//    /**
//     * 设置:出库日期
//     */
//    public void setCkrq(Timestamp value) {
//        this.ckrq = value;
//    }
//    /**
//     * 获取:出库日期
//     */
//    public Timestamp getCkrq() {
//        return ckrq;
//    }
//    /**
//     * 设置:经办人员
//     */
//    public void setJbgh(String value) {
//        this.jbgh = value;
//    }
//    /**
//     * 获取:经办人员
//     */
//    public String getJbgh() {
//        return jbgh;
//    }
//    /**
//     * 设置:单据类型 | 0:正常出库单　1:备库产生出库单　2:病人消耗出库单 3:盘点产生出库单 4.包裹产生出库单  5:被服加工材料出库单
//     */
//    public void setDjlx(Integer value) {
//        this.djlx = value;
//    }
//    /**
//     * 获取:单据类型 | 0:正常出库单　1:备库产生出库单　2:病人消耗出库单 3:盘点产生出库单 4.包裹产生出库单  5:被服加工材料出库单
//     */
//    public Integer getDjlx() {
//        return djlx;
//    }
//    /**
//     * 设置:加工方式 | 0:正常 1:外加工出库
//     */
//    public void setJgfs(Integer value) {
//        this.jgfs = value;
//    }
//    /**
//     * 获取:加工方式 | 0:正常 1:外加工出库
//     */
//    public Integer getJgfs() {
//        return jgfs;
//    }
//    /**
//     * 设置:制单日期
//     */
//    public void setZdrq(Timestamp value) {
//        this.zdrq = value;
//    }
//    /**
//     * 获取:制单日期
//     */
//    public Timestamp getZdrq() {
//        return zdrq;
//    }
//    /**
//     * 设置:制单人员
//     */
//    public void setZdgh(String value) {
//        this.zdgh = value;
//    }
//    /**
//     * 获取:制单人员
//     */
//    public String getZdgh() {
//        return zdgh;
//    }
//    /**
//     * 设置:审核日期
//     */
//    public void setShrq(Timestamp value) {
//        this.shrq = value;
//    }
//    /**
//     * 获取:审核日期
//     */
//    public Timestamp getShrq() {
//        return shrq;
//    }
//    /**
//     * 设置:审核人员
//     */
//    public void setShgh(String value) {
//        this.shgh = value;
//    }
//    /**
//     * 获取:审核人员
//     */
//    public String getShgh() {
//        return shgh;
//    }
//    /**
//     * 设置:记账日期
//     */
//    public void setJzrq(Timestamp value) {
//        this.jzrq = value;
//    }
//    /**
//     * 获取:记账日期
//     */
//    public Timestamp getJzrq() {
//        return jzrq;
//    }
//    /**
//     * 设置:记账工号
//     */
//    public void setJzgh(String value) {
//        this.jzgh = value;
//    }
//    /**
//     * 获取:记账工号
//     */
//    public String getJzgh() {
//        return jzgh;
//    }
//    /**
//     * 设置:单据状态 | 0：新增 1：审核 2：记帐  
//     */
//    public void setDjzt(Integer value) {
//        this.djzt = value;
//    }
//    /**
//     * 获取:单据状态 | 0：新增 1：审核 2：记帐  
//     */
//    public Integer getDjzt() {
//        return djzt;
//    }
//    /**
//     * 设置:退回单据
//     */
//    public void setThdj(Integer value) {
//        this.thdj = value;
//    }
//    /**
//     * 获取:退回单据
//     */
//    public Integer getThdj() {
//        return thdj;
//    }
//    /**
//     * 设置:单据备注
//     */
//    public void setDjbz(String value) {
//        this.djbz = value;
//    }
//    /**
//     * 获取:单据备注
//     */
//    public String getDjbz() {
//        return djbz;
//    }
//    /**
//     * 设置:盘点单据
//     */
//    public void setPddj(Integer value) {
//        this.pddj = value;
//    }
//    /**
//     * 获取:盘点单据
//     */
//    public Integer getPddj() {
//        return pddj;
//    }
//    /**
//     * 设置:出库方式 | 2级别库房出库方式:0 消耗出口;1领用消耗;2科室消耗
//     */
//    public void setCkfs(Integer value) {
//        this.ckfs = value;
//    }
//    /**
//     * 获取:出库方式 | 2级别库房出库方式:0 消耗出口;1领用消耗;2科室消耗
//     */
//    public Integer getCkfs() {
//        return ckfs;
//    }
//    /**
//     * 设置:申领人员
//     */
//    public void setSlgh(String value) {
//        this.slgh = value;
//    }
//    /**
//     * 获取:申领人员
//     */
//    public String getSlgh() {
//        return slgh;
//    }
//    /**
//     * 设置:单据金额
//     */
//    public void setDjje(BigDecimal value) {
//        this.djje = value;
//    }
//    /**
//     * 获取:单据金额
//     */
//    public BigDecimal getDjje() {
//        return djje;
//    }
//    /**
//     * 设置:确认标志 | 0：未确认  1：确认
//     */
//    public void setQrbz(Integer value) {
//        this.qrbz = value;
//    }
//    /**
//     * 获取:确认标志 | 0：未确认  1：确认
//     */
//    public Integer getQrbz() {
//        return qrbz;
//    }
//    /**
//     * 设置:确认流转方式
//     */
//    public void setQrrk(Integer value) {
//        this.qrrk = value;
//    }
//    /**
//     * 获取:确认流转方式
//     */
//    public Integer getQrrk() {
//        return qrrk;
//    }
//    /**
//     * 设置:确认日期
//     */
//    public void setQrrq(Timestamp value) {
//        this.qrrq = value;
//    }
//    /**
//     * 获取:确认日期
//     */
//    public Timestamp getQrrq() {
//        return qrrq;
//    }
//    /**
//     * 设置:确认人员
//     */
//    public void setQrgh(String value) {
//        this.qrgh = value;
//    }
//    /**
//     * 获取:确认人员
//     */
//    public String getQrgh() {
//        return qrgh;
//    }
//    /**
//     * 设置:入库单据
//     */
//    public void setRkdj(Integer value) {
//        this.rkdj = value;
//    }
//    /**
//     * 获取:入库单据
//     */
//    public Integer getRkdj() {
//        return rkdj;
//    }
//}