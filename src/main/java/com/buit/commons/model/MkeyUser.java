package com.buit.commons.model;

import com.buit.commons.PageQuery;

import java.sql.Timestamp;

/**
 * 类名称：MkeyUser<br>
 * 类描述：CA用户表
 * @author 韦靖
 * @ApiModel(value="CA用户表")
 */
public class MkeyUser  extends  PageQuery{
	//@ApiModelProperty(value="id")
    /** id */
    private Integer id;
	//@ApiModelProperty(value="用户ID")
    /** 用户ID */
    private Integer sysUserId;
	//@ApiModelProperty(value="mkey用户标识")
    /** mkey用户标识 */
    private String mkeyUserId;
    //@ApiModelProperty(value="CA证书序列号")
    /** CA证书序列号 */
    private String caZsxlh;
	//@ApiModelProperty(value="createTime")
    /** createTime */
    private Timestamp createTime;
	//@ApiModelProperty(value="updateTime")
    /** updateTime */
    private Timestamp updateTime;
	//@ApiModelProperty(value="status")
    /** status */
    private Integer status;

    /** 设置:id  */
    public void setId(Integer value) {
        this.id = value;
    }
    /** 获取:id */
    public Integer getId() {
        return id;
    }

    /** 设置:用户ID  */
    public void setSysUserId(Integer value) {
        this.sysUserId = value;
    }
    /** 获取:用户ID */
    public Integer getSysUserId() {
        return sysUserId;
    }

    /** 设置:mkey用户标识  */
    public void setMkeyUserId(String value) {
        this.mkeyUserId = value;
    }
    /** 获取:mkey用户标识 */
    public String getMkeyUserId() {
        return mkeyUserId;
    }

    public String getCaZsxlh() {
        return caZsxlh;
    }

    public void setCaZsxlh(String caZsxlh) {
        this.caZsxlh = caZsxlh;
    }

    /** 设置:createTime  */
    public void setCreateTime(Timestamp value) {
        this.createTime = value;
    }
    /** 获取:createTime */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /** 设置:updateTime  */
    public void setUpdateTime(Timestamp value) {
        this.updateTime = value;
    }
    /** 获取:updateTime */
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /** 设置:status  */
    public void setStatus(Integer value) {
        this.status = value;
    }
    /** 获取:status */
    public Integer getStatus() {
        return status;
    }


}
