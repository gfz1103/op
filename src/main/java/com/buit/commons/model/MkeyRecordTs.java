package com.buit.commons.model;

import com.buit.commons.PageQuery;

import java.sql.Timestamp;

/**
 * 类名称：MkeyRecordTs<br>
 * 类描述：签名记录时间戳
 * @author 韦靖
 * @ApiModel(value="签名记录时间戳")
 */
public class MkeyRecordTs  extends  PageQuery{
	//@ApiModelProperty(value="id")
    /** id */
    private Integer id;
	//@ApiModelProperty(value="mkey记录ID")
    /** mkey记录ID */
    private Integer recordId;
	//@ApiModelProperty(value="BASE64时间戳")
    /** BASE64时间戳 */
    private String ts;
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

    /** 设置:mkey记录ID  */
    public void setRecordId(Integer value) {
        this.recordId = value;
    }
    /** 获取:mkey记录ID */
    public Integer getRecordId() {
        return recordId;
    }

    /** 设置:BASE64时间戳  */
    public void setTs(String value) {
        this.ts = value;
    }
    /** 获取:BASE64时间戳 */
    public String getTs() {
        return ts;
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
