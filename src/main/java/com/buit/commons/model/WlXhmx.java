package com.buit.commons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：WlXhmx<br> 
 * 类描述：消耗明细(WL_XHMX)
 * @author 老花生 
 * @ApiModel(value="消耗明细(WL_XHMX)")
 */
public class WlXhmx  extends  PageQuery{
	//@ApiModelProperty(value="记录序号")
    /** 记录序号 */
    private Integer jlxh;
	//@ApiModelProperty(value="机构ID")
    /** 机构ID */
    private Integer jgid;
	//@ApiModelProperty(value="库房序号")
    /** 库房序号 */
    private Integer kfxh;
	//@ApiModelProperty(value="科室")
    /** 科室 */
    private Integer ksdm;
	//@ApiModelProperty(value="科室名称")
    /** 科室名称 */
    private String ksmc;
	//@ApiModelProperty(value="患者ID")
    /** 患者ID */
    private Integer brid;
	//@ApiModelProperty(value="病人号码")
    /** 病人号码 */
    private String brhm;
	//@ApiModelProperty(value="病人来源")
    /** 病人来源 */
    private String brly;
	//@ApiModelProperty(value="病人姓名")
    /** 病人姓名 */
    private String brxm;
	//@ApiModelProperty(value="消耗日期")
    /** 消耗日期 */
    private Timestamp xhrq;
	//@ApiModelProperty(value="物资序号")
    /** 物资序号 */
    private Integer wzxh;
	//@ApiModelProperty(value="物资数量")
    /** 物资数量 */
    private BigDecimal wzsl;
	//@ApiModelProperty(value="状态标志|0 :  未出库　1: 已出库")
    /** 状态标志|0 :  未出库　1: 已出库 */
    private Integer ztbz;
	//@ApiModelProperty(value="单据序号")
    /** 单据序号 */
    private Integer djxh;
	//@ApiModelProperty(value="xmje")
    /** xmje */
    private BigDecimal xmje;
	//@ApiModelProperty(value="mzxh")
    /** mzxh */
    private Integer mzxh;
	//@ApiModelProperty(value="kcxh")
    /** kcxh */
    private Integer kcxh;

    /** 设置:记录序号  */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /** 获取:记录序号 */
    public Integer getJlxh() {
        return jlxh;
    }

    /** 设置:机构ID  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构ID */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:库房序号  */
    public void setKfxh(Integer value) {
        this.kfxh = value;
    }
    /** 获取:库房序号 */
    public Integer getKfxh() {
        return kfxh;
    }

    /** 设置:科室  */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /** 获取:科室 */
    public Integer getKsdm() {
        return ksdm;
    }

    /** 设置:科室名称  */
    public void setKsmc(String value) {
        this.ksmc = value;
    }
    /** 获取:科室名称 */
    public String getKsmc() {
        return ksmc;
    }

    /** 设置:患者ID  */
    public void setBrid(Integer value) {
        this.brid = value;
    }
    /** 获取:患者ID */
    public Integer getBrid() {
        return brid;
    }

    /** 设置:病人号码  */
    public void setBrhm(String value) {
        this.brhm = value;
    }
    /** 获取:病人号码 */
    public String getBrhm() {
        return brhm;
    }

    /** 设置:病人来源  */
    public void setBrly(String value) {
        this.brly = value;
    }
    /** 获取:病人来源 */
    public String getBrly() {
        return brly;
    }

    /** 设置:病人姓名  */
    public void setBrxm(String value) {
        this.brxm = value;
    }
    /** 获取:病人姓名 */
    public String getBrxm() {
        return brxm;
    }

    /** 设置:消耗日期  */
    public void setXhrq(Timestamp value) {
        this.xhrq = value;
    }
    /** 获取:消耗日期 */
    public Timestamp getXhrq() {
        return xhrq;
    }

    /** 设置:物资序号  */
    public void setWzxh(Integer value) {
        this.wzxh = value;
    }
    /** 获取:物资序号 */
    public Integer getWzxh() {
        return wzxh;
    }

    /** 设置:物资数量  */
    public void setWzsl(BigDecimal value) {
        this.wzsl = value;
    }
    /** 获取:物资数量 */
    public BigDecimal getWzsl() {
        return wzsl;
    }

    /** 设置:状态标志|0 :  未出库　1: 已出库  */
    public void setZtbz(Integer value) {
        this.ztbz = value;
    }
    /** 获取:状态标志|0 :  未出库　1: 已出库 */
    public Integer getZtbz() {
        return ztbz;
    }

    /** 设置:单据序号  */
    public void setDjxh(Integer value) {
        this.djxh = value;
    }
    /** 获取:单据序号 */
    public Integer getDjxh() {
        return djxh;
    }

    /** 设置:xmje  */
    public void setXmje(BigDecimal value) {
        this.xmje = value;
    }
    /** 获取:xmje */
    public BigDecimal getXmje() {
        return xmje;
    }

    /** 设置:mzxh  */
    public void setMzxh(Integer value) {
        this.mzxh = value;
    }
    /** 获取:mzxh */
    public Integer getMzxh() {
        return mzxh;
    }

    /** 设置:kcxh  */
    public void setKcxh(Integer value) {
        this.kcxh = value;
    }
    /** 获取:kcxh */
    public Integer getKcxh() {
        return kcxh;
    }


}