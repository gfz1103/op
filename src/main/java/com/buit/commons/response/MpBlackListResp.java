package com.buit.commons.response;//

import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：MpBlackList<br>
 * 类描述：黑名单表<br>
 * @author DESKTOP-1OEG1QM
 */
@ApiModel(value="黑名单表")
public class MpBlackListResp  extends  PageQuery{
    @ApiModelProperty(value="主键ID")
    private Long id;
    @ApiModelProperty(value="身份证号码")
    private String sfzh;
    @ApiModelProperty(value="姓名")
    /** 姓名 */
    private String name;
    @ApiModelProperty(value="数据有效性， 0-无效， 1-有效")
    private Integer state;
    @ApiModelProperty(value="创建时间")
    private Timestamp cjsj;
    @ApiModelProperty(value="修改时间")
    private Timestamp xgsj;
    /**
     * 设置:主键ID
     */
    public void setId(Long value) {
        this.id = value;
    }
    /**
     * 获取:主键ID
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置:身份证号码
     */
    public void setSfzh(String value) {
        this.sfzh = value;
    }
    /**
     * 获取:身份证号码
     */
    public String getSfzh() {
        return sfzh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置:数据有效性， 0-无效， 1-有效
     */
    public void setState(Integer value) {
        this.state = value;
    }
    /**
     * 获取:数据有效性， 0-无效， 1-有效
     */
    public Integer getState() {
        return state;
    }
    /**
     * 设置:创建时间
     */
    public void setCjsj(Timestamp value) {
        this.cjsj = value;
    }
    /**
     * 获取:创建时间
     */
    public Timestamp getCjsj() {
        return cjsj;
    }
    /**
     * 设置:修改时间
     */
    public void setXgsj(Timestamp value) {
        this.xgsj = value;
    }
    /**
     * 获取:修改时间
     */
    public Timestamp getXgsj() {
        return xgsj;
    }
}