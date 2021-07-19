package com.buit.cis.op.dctwork.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;


/**
 * 类名称：MpUserConsult<br>
 * 类描述：用户咨询表（客服使用）<br>
 * @author 韦靖
 */
@ApiModel(value="用户咨询表（客服使用）")
public class MpUserConsultResp extends  PageQuery{
    @ApiModelProperty(value="主键")
    private Integer id;
    @ApiModelProperty(value="咨询的客服ID")
    private Integer userid;
    @ApiModelProperty(value="咨询用户ID")
    private Integer zxrid;
    @ApiModelProperty(value="咨询开始时间")
    private Timestamp zxkssj;
    @ApiModelProperty(value="咨询结束时间")
    private Timestamp zxjssj;
    @ApiModelProperty(value="咨询状态（1开始咨询 2结束咨询）")
    private Integer zxzt;
    @ApiModelProperty(value="创建时间")
    private Timestamp createTime;
    /**
     * 设置:主键
     */
    public void setId(Integer value) {
        this.id = value;
    }
    /**
     * 获取:主键
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置:咨询的客服ID
     */
    public void setUserid(Integer value) {
        this.userid = value;
    }
    /**
     * 获取:咨询的客服ID
     */
    public Integer getUserid() {
        return userid;
    }
    /**
     * 设置:咨询用户ID
     */
    public void setZxrid(Integer value) {
        this.zxrid = value;
    }
    /**
     * 获取:咨询用户ID
     */
    public Integer getZxrid() {
        return zxrid;
    }
    /**
     * 设置:咨询开始时间
     */
    public void setZxkssj(Timestamp value) {
        this.zxkssj = value;
    }
    /**
     * 获取:咨询开始时间
     */
    public Timestamp getZxkssj() {
        return zxkssj;
    }
    /**
     * 设置:咨询结束时间
     */
    public void setZxjssj(Timestamp value) {
        this.zxjssj = value;
    }
    /**
     * 获取:咨询结束时间
     */
    public Timestamp getZxjssj() {
        return zxjssj;
    }
    /**
     * 设置:咨询状态（1开始咨询 2结束咨询）
     */
    public void setZxzt(Integer value) {
        this.zxzt = value;
    }
    /**
     * 获取:咨询状态（1开始咨询 2结束咨询）
     */
    public Integer getZxzt() {
        return zxzt;
    }
    /**
     * 设置:创建时间
     */
    public void setCreateTime(Timestamp value) {
        this.createTime = value;
    }
    /**
     * 获取:创建时间
     */
    public Timestamp getCreateTime() {
        return createTime;
    }
}
