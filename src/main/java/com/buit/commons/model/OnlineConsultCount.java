package com.buit.commons.model;

/**
 * @Author weijing
 * @Date 2021-01-26 19:18
 * @Description
 **/
public class OnlineConsultCount {
    /**咨询客服的ID**/
    private Integer userid;

    /**环信用户名**/
    private String username;

    /**正在咨询数量**/
    private Integer zxsl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getZxsl() {
        return zxsl;
    }

    public void setZxsl(Integer zxsl) {
        this.zxsl = zxsl;
    }
}
