package com.buit.commons.model;

import java.sql.Timestamp;
import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MpiPsxx<br> 
 * 类描述：互联网医院配送信息表
 * @author DESKTOP-1OEG1QM 
 * @ApiModel(value="互联网医院配送信息表")
 */
public class MpPsxx extends  PageQuery{
	//@ApiModelProperty(value="主键ID")
    /** 主键ID */
    private Integer id;

    private String jgid;
    /** 就诊卡号 */
    private String jzkh;
	//@ApiModelProperty(value="患者id")
    /** 患者id */
    private Integer brid;
	//@ApiModelProperty(value="诊治科室|挂号科室")
    /** 诊治科室|挂号科室 */
    private Integer ghks;
	//@ApiModelProperty(value="处方号")
    /** 处方号 */
    private String cfhm;
    /** op_cf02主键 */
    private Integer sbxh;
    /** 就诊流水号 */
    private String jzlsh;
	//@ApiModelProperty(value="创建时间")
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp cjsj;
	//@ApiModelProperty(value="修改时间")
    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp xgsj;
	//@ApiModelProperty(value="订单号")
    /** 订单号 */
    private String ddh;
	//@ApiModelProperty(value="配送状态")
    /** 配送状态 */
    private String pszt;
	//@ApiModelProperty(value="收货人")
    /** 收货人 */
    private String shr;
	//@ApiModelProperty(value="收货人电话")
    /** 收货人电话 */
    private String shrdh;
	//@ApiModelProperty(value="配送地址")
    /** 配送地址 */
    private String psdz;
	//@ApiModelProperty(value="配送方式")
    /** 配送方式 */
    private String psfs;
	//@ApiModelProperty(value="派件员")
    /** 派件员 */
    private String pjy;

    private String pjydh;
	//@ApiModelProperty(value="快递公司")
    /** 快递公司 */
    private String kdgs;
	//@ApiModelProperty(value="快递单号")
    /** 快递单号 */
    private String kddh;
	//@ApiModelProperty(value="预计到达时间")
    /** 预计到达时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String yjddsj;

    /** 配送开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String kssj;

    /** 配送结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String jssj;
	//@ApiModelProperty(value="备注信息")
    /** 备注信息 */
    private String bz;

    /** 设置:主键ID  */
    public void setId(Integer value) {
        this.id = value;
    }
    /** 获取:主键ID */
    public Integer getId() {
        return id;
    }

    public String getJgid() {
        return jgid;
    }

    public void setJgid(String jgid) {
        this.jgid = jgid;
    }

    /** 设置:就诊卡号  */
    public void setJzkh(String value) {
        this.jzkh = value;
    }
    /** 获取:就诊卡号 */
    public String getJzkh() {
        return jzkh;
    }

    /** 设置:患者id  */
    public void setBrid(Integer value) {
        this.brid = value;
    }
    /** 获取:患者id */
    public Integer getBrid() {
        return brid;
    }

    /** 设置:诊治科室|挂号科室  */
    public void setGhks(Integer value) {
        this.ghks = value;
    }
    /** 获取:诊治科室|挂号科室 */
    public Integer getGhks() {
        return ghks;
    }

    /** 设置:处方号  */
    public void setCfhm(String value) {
        this.cfhm = value;
    }
    /** 获取:处方号 */
    public String getCfhm() {
        return cfhm;
    }

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    /** 设置:创建时间  */
    public void setCjsj(Timestamp value) {
        this.cjsj = value;
    }
    /** 获取:创建时间 */
    public Timestamp getCjsj() {
        return cjsj;
    }

    /** 设置:修改时间  */
    public void setXgsj(Timestamp value) {
        this.xgsj = value;
    }
    /** 获取:修改时间 */
    public Timestamp getXgsj() {
        return xgsj;
    }

    /** 设置:订单号  */
    public void setDdh(String value) {
        this.ddh = value;
    }
    /** 获取:订单号 */
    public String getDdh() {
        return ddh;
    }

    /** 设置:配送状态  */
    public void setPszt(String value) {
        this.pszt = value;
    }
    /** 获取:配送状态 */
    public String getPszt() {
        return pszt;
    }

    /** 设置:收货人  */
    public void setShr(String value) {
        this.shr = value;
    }
    /** 获取:收货人 */
    public String getShr() {
        return shr;
    }

    /** 设置:收货人电话  */
    public void setShrdh(String value) {
        this.shrdh = value;
    }
    /** 获取:收货人电话 */
    public String getShrdh() {
        return shrdh;
    }

    /** 设置:配送地址  */
    public void setPsdz(String value) {
        this.psdz = value;
    }
    /** 获取:配送地址 */
    public String getPsdz() {
        return psdz;
    }

    /** 设置:配送方式  */
    public void setPsfs(String value) {
        this.psfs = value;
    }
    /** 获取:配送方式 */
    public String getPsfs() {
        return psfs;
    }

    /** 设置:派件员  */
    public void setPjy(String value) {
        this.pjy = value;
    }
    /** 获取:派件员 */
    public String getPjy() {
        return pjy;
    }

    /** 设置:快递公司  */
    public void setKdgs(String value) {
        this.kdgs = value;
    }
    /** 获取:快递公司 */
    public String getKdgs() {
        return kdgs;
    }

    /** 设置:快递单号  */
    public void setKddh(String value) {
        this.kddh = value;
    }
    /** 获取:快递单号 */
    public String getKddh() {
        return kddh;
    }

    /** 设置:预计到达时间  */
    public void setYjddsj(String value) {
        this.yjddsj = value;
    }
    /** 获取:预计到达时间 */
    public String getYjddsj() {
        return yjddsj;
    }

    public String getKssj() {
        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    public String getJssj() {
        return jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj;
    }

    /** 设置:备注信息  */
    public void setBz(String value) {
        this.bz = value;
    }
    /** 获取:备注信息 */
    public String getBz() {
        return bz;
    }

    public String getPjydh() {
        return pjydh;
    }

    public void setPjydh(String pjydh) {
        this.pjydh = pjydh;
    }
}