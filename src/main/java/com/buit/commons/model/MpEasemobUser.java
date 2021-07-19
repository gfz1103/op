package com.buit.commons.model;

import com.buit.commons.PageQuery;

import java.sql.Timestamp;

/**
 * 类名称：MpEasemobUser<br>
 * 类描述：环信用户表（客服使用）
 * @author 韦靖
 * @ApiModel(value="环信用户表（客服使用）")
 */
public class MpEasemobUser extends PageQuery {
	//@ApiModelProperty(value="id")
    /** id */
    private Long id;
	//@ApiModelProperty(value="用户名")
    /** 用户名 */
    private String username;
	//@ApiModelProperty(value="password")
    /** password */
    private String password;
	//@ApiModelProperty(value="昵称")
    /** 昵称 */
    private String nickname;
	//@ApiModelProperty(value="UUID")
    /** UUID */
    private String uuid;
	//@ApiModelProperty(value="账户状态 ")
    /** 账户状态  */
    private String activated;
	//@ApiModelProperty(value="创建时间")
    /** 创建时间 */
    private Long created;
	//@ApiModelProperty(value="修改时间")
    /** 修改时间 */
    private Long modified;
	//@ApiModelProperty(value="环信用户类型")
    /** 环信用户类型 */
    private String type;
	//@ApiModelProperty(value="用户类型 1用户 2医生(包含客服)")
    /** 用户类型 1用户 2医生(包含客服) */
    private String usertype;
	//@ApiModelProperty(value="用户ID")
    /** 用户ID */
    private Long userid;
    /** 状态  -1删除 0禁用 1可用*/
    private Integer state;
	//@ApiModelProperty(value="创建人")
    /** 创建人 */
    private Long createUserId;
	//@ApiModelProperty(value="创建时间")
    /** 创建时间 */
    private Timestamp createTime;
	//@ApiModelProperty(value="修改人")
    /** 修改人 */
    private Long updateUserId;
	//@ApiModelProperty(value="修改时间")
    /** 修改时间 */
    private Timestamp updateTime;

    /** 用户姓名 */
    private String yhxm;

    /** 设置:id  */
    public void setId(Long value) {
        this.id = value;
    }
    /** 获取:id */
    public Long getId() {
        return id;
    }

    /** 设置:用户名  */
    public void setUsername(String value) {
        this.username = value;
    }
    /** 获取:用户名 */
    public String getUsername() {
        return username;
    }

    /** 设置:password  */
    public void setPassword(String value) {
        this.password = value;
    }
    /** 获取:password */
    public String getPassword() {
        return password;
    }

    /** 设置:昵称  */
    public void setNickname(String value) {
        this.nickname = value;
    }
    /** 获取:昵称 */
    public String getNickname() {
        return nickname;
    }

    /** 设置:UUID  */
    public void setUuid(String value) {
        this.uuid = value;
    }
    /** 获取:UUID */
    public String getUuid() {
        return uuid;
    }

    /** 设置:账户状态   */
    public void setActivated(String value) {
        this.activated = value;
    }
    /** 获取:账户状态  */
    public String getActivated() {
        return activated;
    }

    /** 设置:创建时间  */
    public void setCreated(Long value) {
        this.created = value;
    }
    /** 获取:创建时间 */
    public Long getCreated() {
        return created;
    }

    /** 设置:修改时间  */
    public void setModified(Long value) {
        this.modified = value;
    }
    /** 获取:修改时间 */
    public Long getModified() {
        return modified;
    }

    /** 设置:环信用户类型  */
    public void setType(String value) {
        this.type = value;
    }
    /** 获取:环信用户类型 */
    public String getType() {
        return type;
    }

    /** 设置:用户类型 1用户 2医生(包含客服)  */
    public void setUsertype(String value) {
        this.usertype = value;
    }
    /** 获取:用户类型 1用户 2医生(包含客服) */
    public String getUsertype() {
        return usertype;
    }

    /** 设置:用户ID  */
    public void setUserid(Long value) {
        this.userid = value;
    }
    /** 获取:用户ID */
    public Long getUserid() {
        return userid;
    }

    /** 设置:创建人  */
    public void setCreateUserId(Long value) {
        this.createUserId = value;
    }
    /** 获取:创建人 */
    public Long getCreateUserId() {
        return createUserId;
    }

    /** 设置:创建时间  */
    public void setCreateTime(Timestamp value) {
        this.createTime = value;
    }
    /** 获取:创建时间 */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /** 设置:修改人  */
    public void setUpdateUserId(Long value) {
        this.updateUserId = value;
    }
    /** 获取:修改人 */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /** 设置:修改时间  */
    public void setUpdateTime(Timestamp value) {
        this.updateTime = value;
    }
    /** 获取:修改时间 */
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getYhxm() {
        return yhxm;
    }

    public void setYhxm(String yhxm) {
        this.yhxm = yhxm;
    }
}
