package com.buit.commons.model;

import java.sql.Timestamp;
import com.buit.commons.PageQuery;

/**
 * 类名称：MkeyRecordCert<br>
 * 类描述：签名记录证书
 * @author 韦靖
 * @ApiModel(value="签名记录证书")
 */
public class MkeyRecordCert  extends  PageQuery{
	//@ApiModelProperty(value="id")
    /** id */
    private Integer id;
	//@ApiModelProperty(value="mkey记录ID")
    /** mkey记录ID */
    private Integer recordId;
	//@ApiModelProperty(value="BASE64证书")
    /** BASE64证书 */
    private String cert;
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

    /** 设置:BASE64证书  */
    public void setCert(String value) {
        this.cert = value;
    }
    /** 获取:BASE64证书 */
    public String getCert() {
        return cert;
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
