package com.buit.cis.op.dctwork.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @Author weijing
 * @Date 2021-01-26 14:15
 * @Description
 **/
@ApiModel(value="环信用户表新增（客服使用）")
public class MpEasemobUserAddReq {
    @ApiModelProperty(value="用户名 不传系统会自动生成")
    private String username;
    @ApiModelProperty(value="password 不传系统会自动生成")
    private String password;
    @ApiModelProperty(value="昵称")
    private String nickname;
    @ApiModelProperty(value="用户ID")
    @NotNull(message = "用户ID不能为空")
    private Long userid;

    @ApiModelProperty(value="用户类型 1客服 2医生")
    @NotBlank(message = "用户类型不能为空")
    private String usertype;


    @ApiModelProperty(value="id",hidden = true)
    private Long id;
    @ApiModelProperty(value="UUID",hidden = true)
    private String uuid;
    @ApiModelProperty(value="账户状态 ",hidden = true)
    private String activated;
    @ApiModelProperty(value="创建时间",hidden = true)
    private Long created;
    @ApiModelProperty(value="修改时间",hidden = true)
    private Long modified;
    @ApiModelProperty(value="环信用户类型",hidden = true)
    private String type;
    @ApiModelProperty(value="创建人",hidden = true)
    private Long createUserId;
    @ApiModelProperty(value="创建时间",hidden = true)
    private Timestamp createTime;
    @ApiModelProperty(value="修改人",hidden = true)
    private Long updateUserId;
    @ApiModelProperty(value="修改时间",hidden = true)
    private Timestamp updateTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getModified() {
        return modified;
    }

    public void setModified(Long modified) {
        this.modified = modified;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
