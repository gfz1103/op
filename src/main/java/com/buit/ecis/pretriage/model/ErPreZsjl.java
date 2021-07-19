package com.buit.ecis.pretriage.model;

import java.sql.Timestamp;
import com.buit.commons.PageQuery;

/**
 * 类名称：ErPreZsjl<br> 
 * 类描述：主诉记录
 * @author 朱智 
 * @ApiModel(value="主诉记录")
 */
public class ErPreZsjl  extends  PageQuery{
	//@ApiModelProperty(value="主诉描述ID")
    /** 主诉描述ID */
    private Integer zsmsid;
	//@ApiModelProperty(value="医疗机构代码")
    /** 医疗机构代码 */
    private Integer jgid;
	//@ApiModelProperty(value="主诉描述")
    /** 主诉描述 */
    private String zsms;
	//@ApiModelProperty(value="病情分级")
    /** 病情分级 */
    private String bqfj;
	//@ApiModelProperty(value="拼音码")
    /** 拼音码 */
    private String pym;
	//@ApiModelProperty(value="五笔码")
    /** 五笔码 */
    private String wbm;
	//@ApiModelProperty(value="主诉类别ID")
    /** 主诉类别ID */
    private Integer zslbid;

    /** 设置:主诉描述ID  */
    public void setZsmsid(Integer value) {
        this.zsmsid = value;
    }
    /** 获取:主诉描述ID */
    public Integer getZsmsid() {
        return zsmsid;
    }

    /** 设置:医疗机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:医疗机构代码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:主诉描述  */
    public void setZsms(String value) {
        this.zsms = value;
    }
    /** 获取:主诉描述 */
    public String getZsms() {
        return zsms;
    }

    /** 设置:病情分级  */
    public void setBqfj(String value) {
        this.bqfj = value;
    }
    /** 获取:病情分级 */
    public String getBqfj() {
        return bqfj;
    }

    /** 设置:拼音码  */
    public void setPym(String value) {
        this.pym = value;
    }
    /** 获取:拼音码 */
    public String getPym() {
        return pym;
    }

    /** 设置:五笔码  */
    public void setWbm(String value) {
        this.wbm = value;
    }
    /** 获取:五笔码 */
    public String getWbm() {
        return wbm;
    }

    /** 设置:主诉类别ID  */
    public void setZslbid(Integer value) {
        this.zslbid = value;
    }
    /** 获取:主诉类别ID */
    public Integer getZslbid() {
        return zslbid;
    }


}