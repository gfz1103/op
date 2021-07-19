package com.buit.ecis.pretriage.model;

import java.sql.Timestamp;
import com.buit.commons.PageQuery;

/**
 * 类名称：ErPreZslb<br> 
 * 类描述：主诉类别
 * @author 朱智 
 * @ApiModel(value="主诉类别")
 */
public class ErPreZslb  extends  PageQuery{
	//@ApiModelProperty(value="主诉类别ID")
    /** 主诉类别ID */
    private Integer zslbid;
	//@ApiModelProperty(value="医疗机构代码")
    /** 医疗机构代码 */
    private Integer jgid;
	//@ApiModelProperty(value="主诉类别")
    /** 主诉类别 */
    private String zslb;
	//@ApiModelProperty(value="父ID")
    /** 父ID */
    private Integer fid;

    /** 设置:主诉类别ID  */
    public void setZslbid(Integer value) {
        this.zslbid = value;
    }
    /** 获取:主诉类别ID */
    public Integer getZslbid() {
        return zslbid;
    }

    /** 设置:医疗机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:医疗机构代码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:主诉类别  */
    public void setZslb(String value) {
        this.zslb = value;
    }
    /** 获取:主诉类别 */
    public String getZslb() {
        return zslb;
    }

    /** 设置:父ID  */
    public void setFid(Integer value) {
        this.fid = value;
    }
    /** 获取:父ID */
    public Integer getFid() {
        return fid;
    }


}