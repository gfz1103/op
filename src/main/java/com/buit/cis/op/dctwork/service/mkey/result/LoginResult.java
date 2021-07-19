package com.buit.cis.op.dctwork.service.mkey.result;

import java.time.LocalDateTime;

/**
 * @Author sunjx
 * @Date 2020-06-15 11:47
 * @Description
 **/
public class LoginResult {
    private Integer id;

    /**
     * 用户名
     */
    private String loginName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号码
     */
    private Long phone;

    /**
     * 证件号
     */
    private String idCard;

    /**
     * 证件类型
     */
    private String idCardType;

    /**
     * 身份证认证状态 -1认证失败 0待认证 1认证通过
     */
    private Integer idCardState;

    /**
     * 用户唯一标识
     */
    private String uuid;

    /**
     * 用户类型 0超级管理员 1运维 2医生
     */
    private Integer type;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * CA证书序列号
     */
    private String caSn;

    /**
     * CA证书时间戳
     */
    private String caTimestamp;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;

    private Integer createUserId;

    private LocalDateTime createTime;

    private Integer updateUserId;

    private LocalDateTime updateTime;

    private LocalDateTime loginTime;

    /**
     * 数据状态 0禁用 1有效 -1逻辑删除
     */
    private Integer status;

    private String token;

    /**
     * mkey业务流水
     */
    private String bizSn;

    /**
     * mkey错误码
     */
    private String mkeyCode;

    /**
     * mkey消息
     */
    private String mkeyMsg;

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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
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

    public String getBizSn() {
        return bizSn;
    }

    public void setBizSn(String bizSn) {
        this.bizSn = bizSn;
    }

    public String getMkeyCode() {
        return mkeyCode;
    }

    public void setMkeyCode(String mkeyCode) {
        this.mkeyCode = mkeyCode;
    }

    public String getMkeyMsg() {
        return mkeyMsg;
    }

    public void setMkeyMsg(String mkeyMsg) {
        this.mkeyMsg = mkeyMsg;
    }
}
