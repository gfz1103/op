package com.buit.commons.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：OpPdjh<br> 
 * 类描述：
 * @author 老花生 
 * @ApiModel(value="")
 */
public class OpPdjh extends  PageQuery{
	//@ApiModelProperty(value="记录序号")
    /** 记录序号 */
    private Integer jlxh;
	//@ApiModelProperty(value="病人姓名")
    /** 病人姓名 */
    private String brxm;
	//@ApiModelProperty(value="科室代码")
    /** 科室代码 */
    private Integer ksdm;
	//@ApiModelProperty(value="医生代码")
    /** 医生代码 */
    private String ysdm;
	//@ApiModelProperty(value="诊室ID")
    /** 诊室ID */
    private String zsid;
	//@ApiModelProperty(value="屏幕ID")
    /** 屏幕ID */
    private String pmid;
	//@ApiModelProperty(value="叫号号码（OP_GHMX.pdxh）")
    /** 叫号号码（OP_GHMX.pdxh） */
    private String jhhm;
	//@ApiModelProperty(value="叫号类型(1：正常叫号、2：准备叫号)")
    /** 叫号类型(1：正常叫号、2：准备叫号) */
    private String jhtx;
	//@ApiModelProperty(value="叫号状态(0：未叫号，1：已叫号)")
    /** 叫号状态(0：未叫号，1：已叫号) */
    private String jhzt;
	//@ApiModelProperty(value="叫号时间")
    /** 叫号时间 */
    private Timestamp jhsj;
	//@ApiModelProperty(value="病人ID")
    /** 病人ID */
    private String brid;
	//@ApiModelProperty(value="挂号识别（OP_GHMX.sbxh）")
    /** 挂号识别（OP_GHMX.sbxh） */
    private Integer ghsb;
	//@ApiModelProperty(value="挂号类别(MZGH：门诊挂号，ZZGH：自助挂号，YYGH：预约挂号)")
    /** 挂号类别(MZGH：门诊挂号，ZZGH：自助挂号，YYGH：预约挂号) */
    private String ghlb;
	//@ApiModelProperty(value="排队序号")
    /** 排队序号 */
    private Integer pdxh;
	//@ApiModelProperty(value="特铢人员标识(1是,0否)")
    /** 特铢人员标识(1是,0否) */
    private String tsry;
	//@ApiModelProperty(value="叫号来源(1：OP_GHMX；2：DIY_GHMX_ZZGH)")
    /** 叫号来源(1：OP_GHMX；2：DIY_GHMX_ZZGH) */
    private Integer jhly;
	//@ApiModelProperty(value="分诊台发声（1：已发声 0：未发声）")
    /** 分诊台发声（1：已发声 0：未发声） */
    private String fzfs;

    /** 设置:记录序号  */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /** 获取:记录序号 */
    public Integer getJlxh() {
        return jlxh;
    }

    /** 设置:病人姓名  */
    public void setBrxm(String value) {
        this.brxm = value;
    }
    /** 获取:病人姓名 */
    public String getBrxm() {
        return brxm;
    }

    /** 设置:科室代码  */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /** 获取:科室代码 */
    public Integer getKsdm() {
        return ksdm;
    }

    /** 设置:医生代码  */
    public void setYsdm(String value) {
        this.ysdm = value;
    }
    /** 获取:医生代码 */
    public String getYsdm() {
        return ysdm;
    }

    /** 设置:诊室ID  */
    public void setZsid(String value) {
        this.zsid = value;
    }
    /** 获取:诊室ID */
    public String getZsid() {
        return zsid;
    }

    /** 设置:屏幕ID  */
    public void setPmid(String value) {
        this.pmid = value;
    }
    /** 获取:屏幕ID */
    public String getPmid() {
        return pmid;
    }

    /** 设置:叫号号码（OP_GHMX.pdxh）  */
    public void setJhhm(String value) {
        this.jhhm = value;
    }
    /** 获取:叫号号码（OP_GHMX.pdxh） */
    public String getJhhm() {
        return jhhm;
    }

    /** 设置:叫号类型(1：正常叫号、2：准备叫号)  */
    public void setJhtx(String value) {
        this.jhtx = value;
    }
    /** 获取:叫号类型(1：正常叫号、2：准备叫号) */
    public String getJhtx() {
        return jhtx;
    }

    /** 设置:叫号状态(0：未叫号，1：已叫号)  */
    public void setJhzt(String value) {
        this.jhzt = value;
    }
    /** 获取:叫号状态(0：未叫号，1：已叫号) */
    public String getJhzt() {
        return jhzt;
    }

    /** 设置:叫号时间  */
    public void setJhsj(Timestamp value) {
        this.jhsj = value;
    }
    /** 获取:叫号时间 */
    public Timestamp getJhsj() {
        return jhsj;
    }

    /** 设置:病人ID  */
    public void setBrid(String value) {
        this.brid = value;
    }
    /** 获取:病人ID */
    public String getBrid() {
        return brid;
    }

    /** 设置:挂号识别（OP_GHMX.sbxh）  */
    public void setGhsb(Integer value) {
        this.ghsb = value;
    }
    /** 获取:挂号识别（OP_GHMX.sbxh） */
    public Integer getGhsb() {
        return ghsb;
    }

    /** 设置:挂号类别(MZGH：门诊挂号，ZZGH：自助挂号，YYGH：预约挂号)  */
    public void setGhlb(String value) {
        this.ghlb = value;
    }
    /** 获取:挂号类别(MZGH：门诊挂号，ZZGH：自助挂号，YYGH：预约挂号) */
    public String getGhlb() {
        return ghlb;
    }

    /** 设置:排队序号  */
    public void setPdxh(Integer value) {
        this.pdxh = value;
    }
    /** 获取:排队序号 */
    public Integer getPdxh() {
        return pdxh;
    }

    /** 设置:特铢人员标识(1是,0否)  */
    public void setTsry(String value) {
        this.tsry = value;
    }
    /** 获取:特铢人员标识(1是,0否) */
    public String getTsry() {
        return tsry;
    }

    /** 设置:叫号来源(1：OP_GHMX；2：DIY_GHMX_ZZGH)  */
    public void setJhly(Integer value) {
        this.jhly = value;
    }
    /** 获取:叫号来源(1：OP_GHMX；2：DIY_GHMX_ZZGH) */
    public Integer getJhly() {
        return jhly;
    }

    /** 设置:分诊台发声（1：已发声 0：未发声）  */
    public void setFzfs(String value) {
        this.fzfs = value;
    }
    /** 获取:分诊台发声（1：已发声 0：未发声） */
    public String getFzfs() {
        return fzfs;
    }


}
