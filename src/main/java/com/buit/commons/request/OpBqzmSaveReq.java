
package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


/**
 * 类名称：OpBqzmSaveReq<br>
 * 类描述：病区证明-保存请求<br>
 * @author 老花生
 */
@ApiModel(value="病区证明-保存请求")
public class OpBqzmSaveReq {
    @ApiModelProperty(value="主键ID")
    private Integer bqid;
    @ApiModelProperty(value="类型:1 门诊 2 住院")
    @NotNull(message = "类型必填 1 门诊 2 住院")
    private Integer lx;
    @ApiModelProperty(value="卡号")
    private String cardno;
    @ApiModelProperty(value="身份证号码")
    private String sfzh;
    @ApiModelProperty(value="姓名")
    private String brxm;
    @ApiModelProperty(value="性别")
    private Integer brxb;
    @ApiModelProperty(value="就诊日期")
    private Timestamp jzrq;
    @ApiModelProperty(value="诊断")
    private String brzd;
    @NotNull(message = "休息天数 不能为空")
    @ApiModelProperty(value="休息天数")
    private String xxts;
    @NotNull(message = "开始时间 不能为空")
    @ApiModelProperty(value="开始时间")
    private Timestamp kssj;
    @NotNull(message = "结束时间 不能为空")
    @ApiModelProperty(value="结束时间")
    private Timestamp jssj;
    @ApiModelProperty(value="科室")
    private Integer jzks;
    @ApiModelProperty(value="接诊医生")
    private Integer jzys;
    @ApiModelProperty(value="备注")
    private String bz;
    @ApiModelProperty(value="门诊号码")
    private String mzhm;
    @ApiModelProperty(value="开始上下午")
    private Integer kssxw;
    @ApiModelProperty(value="结束上下午")
    private Integer jssxw;
    @ApiModelProperty(value="入院日期")
    private Timestamp ryrq;
    @ApiModelProperty(value="住院号码")
    private String zyhm;

    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;

    @ApiModelProperty(value="单据类型 1病情证明单 2疾病证明单",hidden = true)
    private String djlx;
    /**
     * 设置:主键ID
     */
    public void setBqid(Integer value) {
        this.bqid = value;
    }
    /**
     * 获取:主键ID
     */
    public Integer getBqid() {
        return bqid;
    }
    /**
     * 设置:类型:1 门诊 2 住院
     */
    public void setLx(Integer value) {
        this.lx = value;
    }
    /**
     * 获取:类型:1 门诊 2 住院
     */
    public Integer getLx() {
        return lx;
    }
    /**
     * 设置:门诊号码
     */
    public void setMzhm(String value) {
        this.mzhm = value;
    }
    /**
     * 获取:门诊号码
     */
    public String getMzhm() {
        return mzhm;
    }
    /**
     * 设置:卡号
     */
    public void setCardno(String value) {
        this.cardno = value;
    }
    /**
     * 获取:卡号
     */
    public String getCardno() {
        return cardno;
    }
    /**
     * 设置:身份证号码
     */
    public void setSfzh(String value) {
        this.sfzh = value;
    }
    /**
     * 获取:身份证号码
     */
    public String getSfzh() {
        return sfzh;
    }
    /**
     * 设置:姓名
     */
    public void setBrxm(String value) {
        this.brxm = value;
    }
    /**
     * 获取:姓名
     */
    public String getBrxm() {
        return brxm;
    }
    /**
     * 设置:性别
     */
    public void setBrxb(Integer value) {
        this.brxb = value;
    }
    /**
     * 获取:性别
     */
    public Integer getBrxb() {
        return brxb;
    }
    /**
     * 设置:就诊日期
     */
    public void setJzrq(Timestamp value) {
        this.jzrq = value;
    }
    /**
     * 获取:就诊日期
     */
    public Timestamp getJzrq() {
        return jzrq;
    }
    /**
     * 设置:接诊医生
     */
    public void setJzys(Integer value) {
        this.jzys = value;
    }
    /**
     * 获取:接诊医生
     */
    public Integer getJzys() {
        return jzys;
    }
    /**
     * 设置:科室
     */
    public void setJzks(Integer value) {
        this.jzks = value;
    }
    /**
     * 获取:科室
     */
    public Integer getJzks() {
        return jzks;
    }
    /**
     * 设置:诊断
     */
    public void setBrzd(String value) {
        this.brzd = value;
    }
    /**
     * 获取:诊断
     */
    public String getBrzd() {
        return brzd;
    }
    /**
     * 设置:休息天数
     */
    public void setXxts(String value) {
        this.xxts = value;
    }
    /**
     * 获取:休息天数
     */
    public String getXxts() {
        return xxts;
    }
    /**
     * 设置:开始时间
     */
    public void setKssj(Timestamp value) {
        this.kssj = value;
    }
    /**
     * 获取:开始时间
     */
    public Timestamp getKssj() {
        return kssj;
    }
    /**
     * 设置:结束时间
     */
    public void setJssj(Timestamp value) {
        this.jssj = value;
    }
    /**
     * 获取:结束时间
     */
    public Timestamp getJssj() {
        return jssj;
    }
    /**
     * 设置:备注
     */
    public void setBz(String value) {
        this.bz = value;
    }
    /**
     * 获取:备注
     */
    public String getBz() {
        return bz;
    }
    /**
     * 设置:开始上下午
     */
    public void setKssxw(Integer value) {
        this.kssxw = value;
    }
    /**
     * 获取:开始上下午
     */
    public Integer getKssxw() {
        return kssxw;
    }
    /**
     * 设置:结束上下午
     */
    public void setJssxw(Integer value) {
        this.jssxw = value;
    }
    /**
     * 获取:结束上下午
     */
    public Integer getJssxw() {
        return jssxw;
    }
	public Timestamp getRyrq() {
		return ryrq;
	}
	public void setRyrq(Timestamp ryrq) {
		this.ryrq = ryrq;
	}
	public String getZyhm() {
		return zyhm;
	}
	public void setZyhm(String zyhm) {
		this.zyhm = zyhm;
	}

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public String getDjlx() {
        return djlx;
    }

    public void setDjlx(String djlx) {
        this.djlx = djlx;
    }
}
