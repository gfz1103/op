package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel("用户登录返回")
public class LoginResponse {

    @ApiModelProperty
    private Integer id;

    @ApiModelProperty("用户名")
    private String loginName;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("手机号码")
    private Long phone;

    @ApiModelProperty("证件号")
    private String idCard;

    @ApiModelProperty("证件类型")
    private String idCardType;

    @ApiModelProperty("身份证认证状态 -1认证失败 0待认证 1认证通过")
    private Integer idCardState;

    @ApiModelProperty("用户唯一标识")
    private String uuid;

    @ApiModelProperty("用户类型 0超级管理员 1运维 2医生")
    private Integer type;

    @ApiModelProperty("头像地址")
    private String avatar;

    @ApiModelProperty("CA证书序列号")
    private String caSn;

    @ApiModelProperty("CA证书时间戳")
    private String caTimestamp;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("注册时间")
    private LocalDateTime createTime;

    @ApiModelProperty("最后登录时间")
    private LocalDateTime loginTime;

    @ApiModelProperty("数据状态 0禁用 1有效 -1逻辑删除")
    private Integer status;

    @ApiModelProperty
    private String token;

    @ApiModelProperty("token类型")
    private String tokenType = "Bearer";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    public Integer getIdCardState() {
        return idCardState;
    }

    public void setIdCardState(Integer idCardState) {
        this.idCardState = idCardState;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCaSn() {
        return caSn;
    }

    public void setCaSn(String caSn) {
        this.caSn = caSn;
    }

    public String getCaTimestamp() {
        return caTimestamp;
    }

    public void setCaTimestamp(String caTimestamp) {
        this.caTimestamp = caTimestamp;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
