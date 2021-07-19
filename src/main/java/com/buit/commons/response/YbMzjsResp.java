package com.buit.commons.response;//
//package com.buit.his.op.reg.response;
//
//import java.sql.Timestamp;
//
//import com.his.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：YbMzjs<br> 
// * 类描述：医保门诊结算表,暂时只增加主键和OP_MZXX关联的键,其他的键按地方返回的医保卡字段增加<br>
// * @author WY
// */
//@ApiModel(value="医保门诊结算表,暂时只增加主键和OP_MZXX关联的键,其他的键按地方返回的医保卡字段增加")
//public class YbMzjsResp  extends  PageQuery{
//    @ApiModelProperty(value="主键")
//    private Integer sbxh;
//    @ApiModelProperty(value="和OP_MZXX主键关联")
//    private Integer mzxh;
//    @ApiModelProperty(value="发票号码")
//    private String fphm;
//    @ApiModelProperty(value="机构ID")
//    private Integer jgid;
//    @ApiModelProperty(value="作废判别,0未作废,1作废")
//    private Integer zfpb;
//    /**
//     * 设置:主键
//     */
//    public void setSbxh(Integer value) {
//        this.sbxh = value;
//    }
//    /**
//     * 获取:主键
//     */
//    public Integer getSbxh() {
//        return sbxh;
//    }
//    /**
//     * 设置:和OP_MZXX主键关联
//     */
//    public void setMzxh(Integer value) {
//        this.mzxh = value;
//    }
//    /**
//     * 获取:和OP_MZXX主键关联
//     */
//    public Integer getMzxh() {
//        return mzxh;
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
//     * 设置:作废判别,0未作废,1作废
//     */
//    public void setZfpb(Integer value) {
//        this.zfpb = value;
//    }
//    /**
//     * 获取:作废判别,0未作废,1作废
//     */
//    public Integer getZfpb() {
//        return zfpb;
//    }
//}
