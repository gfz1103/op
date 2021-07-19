package com.buit.ecis.pretriage.model;

import java.sql.Timestamp;
import com.buit.commons.PageQuery;

/**
 * 类名称：ErPreLyfs<br> 
 * 类描述：来院方式
 * @author 朱智 
 * @ApiModel(value="来院方式")
 */
public class ErPreLyfs  extends  PageQuery{
	//@ApiModelProperty(value="来院方式ID")
    /** 来院方式ID */
    private Integer lyfsid;
	//@ApiModelProperty(value="机构ID")
    /** 机构ID */
    private Integer jgid;
	//@ApiModelProperty(value="来院方式")
    /** 来院方式 */
    private String lyfs;
	//@ApiModelProperty(value="排序号")
    /** 排序号 */
    private Integer pxh;
	//@ApiModelProperty(value="状态 :0 停用/1 启用")
    /** 状态 :0 停用/1 启用 */
    private String zt;

    /** 设置:来院方式ID  */
    public void setLyfsid(Integer value) {
        this.lyfsid = value;
    }
    /** 获取:来院方式ID */
    public Integer getLyfsid() {
        return lyfsid;
    }

    /** 设置:机构ID  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构ID */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:来院方式  */
    public void setLyfs(String value) {
        this.lyfs = value;
    }
    /** 获取:来院方式 */
    public String getLyfs() {
        return lyfs;
    }

    /** 设置:排序号  */
    public void setPxh(Integer value) {
        this.pxh = value;
    }
    /** 获取:排序号 */
    public Integer getPxh() {
        return pxh;
    }

    /** 设置:状态 :0 停用/1 启用  */
    public void setZt(String value) {
        this.zt = value;
    }
    /** 获取:状态 :0 停用/1 启用 */
    public String getZt() {
        return zt;
    }


}