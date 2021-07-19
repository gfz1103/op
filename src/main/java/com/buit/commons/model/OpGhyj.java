package com.buit.commons.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：OpGhyj<br> 
 * 类描述：门诊_挂号预检
 * @author WY 
 * @ApiModel(value="门诊_挂号预检")
 */
public class OpGhyj  extends  PageQuery{
	//@ApiModelProperty(value="预检序号")
    /** 预检序号 */
    private Integer yjxh;
	//@ApiModelProperty(value="机构代码")
    /** 机构代码 */
    private Integer jgid;
	//@ApiModelProperty(value="病人ID")
    /** 病人ID */
    private Integer brid;
	//@ApiModelProperty(value="预检日期")
    /** 预检日期 */
    private Timestamp yjrq;
	//@ApiModelProperty(value="值班类别")
    /** 值班类别 */
    private String zblb;
	//@ApiModelProperty(value="科室代码")
    /** 科室代码 */
    private String ksdm;
	//@ApiModelProperty(value="医生代码")
    /** 医生代码 */
    private String ysdm;
	//@ApiModelProperty(value="挂号标志 | 0.预检 1.挂号")
    /** 挂号标志 | 0.预检 1.挂号 */
    private Integer ghbz;
	//@ApiModelProperty(value="操作工号")
    /** 操作工号 */
    private String czgh;

    /** 设置:预检序号  */
    public void setYjxh(Integer value) {
        this.yjxh = value;
    }
    /** 获取:预检序号 */
    public Integer getYjxh() {
        return yjxh;
    }

    /** 设置:机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构代码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:病人ID  */
    public void setBrid(Integer value) {
        this.brid = value;
    }
    /** 获取:病人ID */
    public Integer getBrid() {
        return brid;
    }

    /** 设置:预检日期  */
    public void setYjrq(Timestamp value) {
        this.yjrq = value;
    }
    /** 获取:预检日期 */
    public Timestamp getYjrq() {
        return yjrq;
    }

    /** 设置:值班类别  */
    public void setZblb(String value) {
        this.zblb = value;
    }
    /** 获取:值班类别 */
    public String getZblb() {
        return zblb;
    }

    /** 设置:科室代码  */
    public void setKsdm(String value) {
        this.ksdm = value;
    }
    /** 获取:科室代码 */
    public String getKsdm() {
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

    /** 设置:挂号标志 | 0.预检 1.挂号  */
    public void setGhbz(Integer value) {
        this.ghbz = value;
    }
    /** 获取:挂号标志 | 0.预检 1.挂号 */
    public Integer getGhbz() {
        return ghbz;
    }

    /** 设置:操作工号  */
    public void setCzgh(String value) {
        this.czgh = value;
    }
    /** 获取:操作工号 */
    public String getCzgh() {
        return czgh;
    }


}
