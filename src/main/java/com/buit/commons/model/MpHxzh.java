package com.buit.commons.model;

import com.buit.commons.PageQuery;

/**
 * 类名称：MpHxzh<br> 
 * 类描述：环信账号信息
 * @author DESKTOP-1OEG1QM 
 * @ApiModel(value="环信账号信息")
 */
public class MpHxzh  extends  PageQuery{
	//@ApiModelProperty(value="就诊流水号")
    /** 就诊流水号 */
    private String jzlsh;
	//@ApiModelProperty(value="问诊方式")
    /** 问诊方式 */
    private String wzfs;
	//@ApiModelProperty(value="环信用户ID")
    /** 环信用户ID */
    private Long userid;
	//@ApiModelProperty(value="环信用户账号")
    /** 环信用户账号 */
    private String easemob;

    /** 设置:就诊流水号  */
    public void setJzlsh(String value) {
        this.jzlsh = value;
    }
    /** 获取:就诊流水号 */
    public String getJzlsh() {
        return jzlsh;
    }

    /** 设置:问诊方式  */
    public void setWzfs(String value) {
        this.wzfs = value;
    }
    /** 获取:问诊方式 */
    public String getWzfs() {
        return wzfs;
    }

    /** 设置:环信用户ID  */
    public void setUserid(Long value) {
        this.userid = value;
    }
    /** 获取:环信用户ID */
    public Long getUserid() {
        return userid;
    }

    /** 设置:环信用户账号  */
    public void setEasemob(String value) {
        this.easemob = value;
    }
    /** 获取:环信用户账号 */
    public String getEasemob() {
        return easemob;
    }


}