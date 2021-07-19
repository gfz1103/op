package com.buit.commons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：WlWzkc<br> 
 * 类描述：物资库存(WL_WZKC)
 * @author 老花生 
 * @ApiModel(value="物资库存(WL_WZKC)")
 */
public class WlWzkc  extends  PageQuery{
	//@ApiModelProperty(value="记录序号")
    /** 记录序号 */
    private Integer jlxh;
	//@ApiModelProperty(value="机构ID")
    /** 机构ID */
    private Integer jgid;
	//@ApiModelProperty(value="库存序号")
    /** 库存序号 */
    private Integer kcxh;
	//@ApiModelProperty(value="库房序号")
    /** 库房序号 */
    private Integer kfxh;
	//@ApiModelProperty(value="帐薄类别")
    /** 帐薄类别 */
    private Integer zblb;
	//@ApiModelProperty(value="物资序号")
    /** 物资序号 */
    private Integer wzxh;
	//@ApiModelProperty(value="厂家序号")
    /** 厂家序号 */
    private Integer cjxh;
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
	//@ApiModelProperty(value="物资数量")
    /** 物资数量 */
    private BigDecimal wzsl;
	//@ApiModelProperty(value="物资价格")
    /** 物资价格 */
    private BigDecimal wzjg;
	//@ApiModelProperty(value="物资金额")
    /** 物资金额 */
    private BigDecimal wzje;
	//@ApiModelProperty(value="预扣数量")
    /** 预扣数量 */
    private BigDecimal yksl;
	//@ApiModelProperty(value="入库日期")
    /** 入库日期 */
    private Timestamp fsrq;
	//@ApiModelProperty(value="零售价格")
    /** 零售价格 */
    private BigDecimal lsjg;
	//@ApiModelProperty(value="零售金额")
    /** 零售金额 */
    private BigDecimal lsje;
	//@ApiModelProperty(value="zcbh")
    /** zcbh */
    private String zcbh;
	//@ApiModelProperty(value="kczt")
    /** kczt */
    private Integer kczt;
	//@ApiModelProperty(value="sbbh")
    /** sbbh */
    private String sbbh;
	//@ApiModelProperty(value="rkxh")
    /** rkxh */
    private String rkxh;

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

    /** 设置:库存序号  */
    public void setKcxh(Integer value) {
        this.kcxh = value;
    }
    /** 获取:库存序号 */
    public Integer getKcxh() {
        return kcxh;
    }

    /** 设置:库房序号  */
    public void setKfxh(Integer value) {
        this.kfxh = value;
    }
    /** 获取:库房序号 */
    public Integer getKfxh() {
        return kfxh;
    }

    /** 设置:帐薄类别  */
    public void setZblb(Integer value) {
        this.zblb = value;
    }
    /** 获取:帐薄类别 */
    public Integer getZblb() {
        return zblb;
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

    /** 设置:预扣数量  */
    public void setYksl(BigDecimal value) {
        this.yksl = value;
    }
    /** 获取:预扣数量 */
    public BigDecimal getYksl() {
        return yksl;
    }

    /** 设置:入库日期  */
    public void setFsrq(Timestamp value) {
        this.fsrq = value;
    }
    /** 获取:入库日期 */
    public Timestamp getFsrq() {
        return fsrq;
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

    /** 设置:zcbh  */
    public void setZcbh(String value) {
        this.zcbh = value;
    }
    /** 获取:zcbh */
    public String getZcbh() {
        return zcbh;
    }

    /** 设置:kczt  */
    public void setKczt(Integer value) {
        this.kczt = value;
    }
    /** 获取:kczt */
    public Integer getKczt() {
        return kczt;
    }

    /** 设置:sbbh  */
    public void setSbbh(String value) {
        this.sbbh = value;
    }
    /** 获取:sbbh */
    public String getSbbh() {
        return sbbh;
    }

    /** 设置:rkxh  */
    public void setRkxh(String value) {
        this.rkxh = value;
    }
    /** 获取:rkxh */
    public String getRkxh() {
        return rkxh;
    }


}