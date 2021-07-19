package com.buit.commons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：WlCk02<br> 
 * 类描述：
 * @author WY 
 * @ApiModel(value="")
 */
public class WlCk02  extends  PageQuery{
	//@ApiModelProperty(value="记录序号")
    /** 记录序号 */
    private Integer jlxh;
	//@ApiModelProperty(value="单据序号")
    /** 单据序号 */
    private Integer djxh;
	//@ApiModelProperty(value="物资序号")
    /** 物资序号 */
    private Integer wzxh;
	//@ApiModelProperty(value="厂家序号")
    /** 厂家序号 */
    private Integer cjxh;
	//@ApiModelProperty(value="物资数量")
    /** 物资数量 */
    private BigDecimal wzsl;
	//@ApiModelProperty(value="物资价格")
    /** 物资价格 */
    private BigDecimal wzjg;
	//@ApiModelProperty(value="物资金额")
    /** 物资金额 */
    private BigDecimal wzje;
	//@ApiModelProperty(value="物资批号")
    /** 物资批号 */
    private String wzph;
	//@ApiModelProperty(value="灭菌批号")
    /** 灭菌批号 */
    private String mjph;
	//@ApiModelProperty(value="生产日期")
    /** 生产日期 */
    private Timestamp scrq;
	//@ApiModelProperty(value="失效日期")
    /** 失效日期 */
    private Timestamp sxrq;
	//@ApiModelProperty(value="关联序号")
    /** 关联序号 */
    private Integer glxh;
	//@ApiModelProperty(value="退回明细")
    /** 退回明细 */
    private Integer thmx;
	//@ApiModelProperty(value="库存序号")
    /** 库存序号 */
    private Integer kcxh;
	//@ApiModelProperty(value="账簿序号")
    /** 账簿序号 */
    private Integer zbxh;
	//@ApiModelProperty(value="申领序号")
    /** 申领序号 */
    private Integer slxh;
	//@ApiModelProperty(value="申领数量")
    /** 申领数量 */
    private BigDecimal slsl;
	//@ApiModelProperty(value="未发数量")
    /** 未发数量 */
    private BigDecimal wfsl;
	//@ApiModelProperty(value="计划标志 | 0:不是 1 :是")
    /** 计划标志 | 0:不是 1 :是 */
    private Integer jhbz;
	//@ApiModelProperty(value="零售价格")
    /** 零售价格 */
    private BigDecimal lsjg;
	//@ApiModelProperty(value="零售金额")
    /** 零售金额 */
    private BigDecimal lsje;
	//@ApiModelProperty(value="预扣标识")
    /** 预扣标识 */
    private Integer ykbz;
	//@ApiModelProperty(value="领导批示")
    /** 领导批示 */
    private Integer ldps;
	//@ApiModelProperty(value="zcbh")
    /** zcbh */
    private String zcbh;
	//@ApiModelProperty(value="sbbh")
    /** sbbh */
    private String sbbh;
	//@ApiModelProperty(value="lzdh")
    /** lzdh */
    private String lzdh;

    /** 设置:记录序号  */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /** 获取:记录序号 */
    public Integer getJlxh() {
        return jlxh;
    }

    /** 设置:单据序号  */
    public void setDjxh(Integer value) {
        this.djxh = value;
    }
    /** 获取:单据序号 */
    public Integer getDjxh() {
        return djxh;
    }

    /** 设置:物资序号  */
    public void setWzxh(Integer value) {
        this.wzxh = value;
    }
    /** 获取:物资序号 */
    public Integer getWzxh() {
        return wzxh;
    }

    /** 设置:厂家序号  */
    public void setCjxh(Integer value) {
        this.cjxh = value;
    }
    /** 获取:厂家序号 */
    public Integer getCjxh() {
        return cjxh;
    }

    /** 设置:物资数量  */
    public void setWzsl(BigDecimal value) {
        this.wzsl = value;
    }
    /** 获取:物资数量 */
    public BigDecimal getWzsl() {
        return wzsl;
    }

    /** 设置:物资价格  */
    public void setWzjg(BigDecimal value) {
        this.wzjg = value;
    }
    /** 获取:物资价格 */
    public BigDecimal getWzjg() {
        return wzjg;
    }

    /** 设置:物资金额  */
    public void setWzje(BigDecimal value) {
        this.wzje = value;
    }
    /** 获取:物资金额 */
    public BigDecimal getWzje() {
        return wzje;
    }

    /** 设置:物资批号  */
    public void setWzph(String value) {
        this.wzph = value;
    }
    /** 获取:物资批号 */
    public String getWzph() {
        return wzph;
    }

    /** 设置:灭菌批号  */
    public void setMjph(String value) {
        this.mjph = value;
    }
    /** 获取:灭菌批号 */
    public String getMjph() {
        return mjph;
    }

    /** 设置:生产日期  */
    public void setScrq(Timestamp value) {
        this.scrq = value;
    }
    /** 获取:生产日期 */
    public Timestamp getScrq() {
        return scrq;
    }

    /** 设置:失效日期  */
    public void setSxrq(Timestamp value) {
        this.sxrq = value;
    }
    /** 获取:失效日期 */
    public Timestamp getSxrq() {
        return sxrq;
    }

    /** 设置:关联序号  */
    public void setGlxh(Integer value) {
        this.glxh = value;
    }
    /** 获取:关联序号 */
    public Integer getGlxh() {
        return glxh;
    }

    /** 设置:退回明细  */
    public void setThmx(Integer value) {
        this.thmx = value;
    }
    /** 获取:退回明细 */
    public Integer getThmx() {
        return thmx;
    }

    /** 设置:库存序号  */
    public void setKcxh(Integer value) {
        this.kcxh = value;
    }
    /** 获取:库存序号 */
    public Integer getKcxh() {
        return kcxh;
    }

    /** 设置:账簿序号  */
    public void setZbxh(Integer value) {
        this.zbxh = value;
    }
    /** 获取:账簿序号 */
    public Integer getZbxh() {
        return zbxh;
    }

    /** 设置:申领序号  */
    public void setSlxh(Integer value) {
        this.slxh = value;
    }
    /** 获取:申领序号 */
    public Integer getSlxh() {
        return slxh;
    }

    /** 设置:申领数量  */
    public void setSlsl(BigDecimal value) {
        this.slsl = value;
    }
    /** 获取:申领数量 */
    public BigDecimal getSlsl() {
        return slsl;
    }

    /** 设置:未发数量  */
    public void setWfsl(BigDecimal value) {
        this.wfsl = value;
    }
    /** 获取:未发数量 */
    public BigDecimal getWfsl() {
        return wfsl;
    }

    /** 设置:计划标志 | 0:不是 1 :是  */
    public void setJhbz(Integer value) {
        this.jhbz = value;
    }
    /** 获取:计划标志 | 0:不是 1 :是 */
    public Integer getJhbz() {
        return jhbz;
    }

    /** 设置:零售价格  */
    public void setLsjg(BigDecimal value) {
        this.lsjg = value;
    }
    /** 获取:零售价格 */
    public BigDecimal getLsjg() {
        return lsjg;
    }

    /** 设置:零售金额  */
    public void setLsje(BigDecimal value) {
        this.lsje = value;
    }
    /** 获取:零售金额 */
    public BigDecimal getLsje() {
        return lsje;
    }

    /** 设置:预扣标识  */
    public void setYkbz(Integer value) {
        this.ykbz = value;
    }
    /** 获取:预扣标识 */
    public Integer getYkbz() {
        return ykbz;
    }

    /** 设置:领导批示  */
    public void setLdps(Integer value) {
        this.ldps = value;
    }
    /** 获取:领导批示 */
    public Integer getLdps() {
        return ldps;
    }

    /** 设置:zcbh  */
    public void setZcbh(String value) {
        this.zcbh = value;
    }
    /** 获取:zcbh */
    public String getZcbh() {
        return zcbh;
    }

    /** 设置:sbbh  */
    public void setSbbh(String value) {
        this.sbbh = value;
    }
    /** 获取:sbbh */
    public String getSbbh() {
        return sbbh;
    }

    /** 设置:lzdh  */
    public void setLzdh(String value) {
        this.lzdh = value;
    }
    /** 获取:lzdh */
    public String getLzdh() {
        return lzdh;
    }


}