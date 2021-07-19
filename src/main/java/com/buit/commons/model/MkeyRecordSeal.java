package com.buit.commons.model;

import com.buit.commons.PageQuery;

import java.sql.Timestamp;

/**
 * 类名称：MkeyRecordSeal<br>
 * 类描述：数据签名
 * @author 韦靖
 * @ApiModel(value="数据签名")
 */
public class MkeyRecordSeal  extends  PageQuery{
	//@ApiModelProperty(value="id")
    /** id */
    private Integer id;
	//@ApiModelProperty(value="签名记录ID")
    /** 签名记录ID */
    private Integer recordId;
	//@ApiModelProperty(value="用户id")
    /** 用户id */
    private Integer userId;
	//@ApiModelProperty(value="BASE64签章")
    /** BASE64签章 */
    private String seal;
	//@ApiModelProperty(value="创建时间")
    /** 创建时间 */
    private Timestamp createTime;
	//@ApiModelProperty(value="修改时间")
    /** 修改时间 */
    private Timestamp updateTime;

    /** 设置:id  */
    public void setId(Integer value) {
        this.id = value;
    }
    /** 获取:id */
    public Integer getId() {
        return id;
    }

    /** 设置:签名记录ID  */
    public void setRecordId(Integer value) {
        this.recordId = value;
    }
    /** 获取:签名记录ID */
    public Integer getRecordId() {
        return recordId;
    }

    /** 设置:用户id  */
    public void setUserId(Integer value) {
        this.userId = value;
    }
    /** 获取:用户id */
    public Integer getUserId() {
        return userId;
    }

    /** 设置:BASE64签章  */
    public void setSeal(String value) {
        this.seal = value;
    }
    /** 获取:BASE64签章 */
    public String getSeal() {
        return seal;
    }

    /** 设置:创建时间  */
    public void setCreateTime(Timestamp value) {
        this.createTime = value;
    }
    /** 获取:创建时间 */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /** 设置:修改时间  */
    public void setUpdateTime(Timestamp value) {
        this.updateTime = value;
    }
    /** 获取:修改时间 */
    public Timestamp getUpdateTime() {
        return updateTime;
    }


}
