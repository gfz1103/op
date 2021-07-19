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
// * 类名称：OpSbhy<br> 
// * 类描述：设备号源表<br>
// * @author 老花生
// */
//@ApiModel(value="设备号源表")
//public class OpSbhyResp  extends  PageQuery{
//    @ApiModelProperty(value="号源ID")
//    private Integer hyid;
//    @ApiModelProperty(value="编号ID")
//    private Integer bhid;
//    @ApiModelProperty(value="号源日期")
//    private Timestamp hyrq;
//    @ApiModelProperty(value="号源时间(10:00)")
//    private String hysj;
//    @ApiModelProperty(value="所属时段")
//    private Integer sdid;
//    @ApiModelProperty(value="是否预约  0=否,1=是")
//    private Integer sfyy;
//    @ApiModelProperty(value="是否冻结  0=否,1=是")
//    private Integer sfdj;
//    @ApiModelProperty(value="冻结医生")
//    private String djys;
//    /**
//     * 设置:号源ID
//     */
//    public void setHyid(Integer value) {
//        this.hyid = value;
//    }
//    /**
//     * 获取:号源ID
//     */
//    public Integer getHyid() {
//        return hyid;
//    }
//    /**
//     * 设置:编号ID
//     */
//    public void setBhid(Integer value) {
//        this.bhid = value;
//    }
//    /**
//     * 获取:编号ID
//     */
//    public Integer getBhid() {
//        return bhid;
//    }
//    /**
//     * 设置:号源日期
//     */
//    public void setHyrq(Timestamp value) {
//        this.hyrq = value;
//    }
//    /**
//     * 获取:号源日期
//     */
//    public Timestamp getHyrq() {
//        return hyrq;
//    }
//    /**
//     * 设置:号源时间(10:00)
//     */
//    public void setHysj(String value) {
//        this.hysj = value;
//    }
//    /**
//     * 获取:号源时间(10:00)
//     */
//    public String getHysj() {
//        return hysj;
//    }
//    /**
//     * 设置:所属时段
//     */
//    public void setSdid(Integer value) {
//        this.sdid = value;
//    }
//    /**
//     * 获取:所属时段
//     */
//    public Integer getSdid() {
//        return sdid;
//    }
//    /**
//     * 设置:是否预约  0=否,1=是
//     */
//    public void setSfyy(Integer value) {
//        this.sfyy = value;
//    }
//    /**
//     * 获取:是否预约  0=否,1=是
//     */
//    public Integer getSfyy() {
//        return sfyy;
//    }
//    /**
//     * 设置:是否冻结  0=否,1=是
//     */
//    public void setSfdj(Integer value) {
//        this.sfdj = value;
//    }
//    /**
//     * 获取:是否冻结  0=否,1=是
//     */
//    public Integer getSfdj() {
//        return sfdj;
//    }
//    /**
//     * 设置:冻结医生
//     */
//    public void setDjys(String value) {
//        this.djys = value;
//    }
//    /**
//     * 获取:冻结医生
//     */
//    public String getDjys() {
//        return djys;
//    }
//}
