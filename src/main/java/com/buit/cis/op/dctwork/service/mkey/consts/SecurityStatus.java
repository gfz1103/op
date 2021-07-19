package com.buit.cis.op.dctwork.service.mkey.consts;

public enum SecurityStatus{

    LOGIN_NAME_EMPTY(10_00_01, "用户名不能为空"),
    LOGIN_PWD_EMPTY(10_00_02, "密码不能为空"),
    PERMISSION_NAME_EXIST(10_00_03, "该权限名称已存在"),
    PERMISSION_CODE_EXIST(10_00_04, "该权限编码已存在"),

    EXIST_LOGIN_NAME(10_01_01, "该账号已存在"),
    EXIST_PHONE(10_01_02, "该手机号已存在"),
    EXIST_EMAIL(10_01_03, "该email已存在"),
    OLD_PWD_BLANK(10_01_04, "旧密码不能为空"),
    NEW_PWD_BLANK(10_01_05, "新密码不能为空"),
    AGAIN_PWD_BLANK(10_01_06, "确认密码不能为空" ),
    NEW_AGAIN_NOT_EQUAL(10_01_07, "新密码与确认密码不一致" ),
    OLD_PWD_ERROR(10_01_08, "旧密码不正确"),
    PHONE_EMPTY(10_0109, "手机号码不能为空"),
    LOGIN_STATUS(10_0110, "该账号不存在或已被禁用，请联系管理员"),
    NOT_EXIST_BIZSN(10_0111, "二维码已过期,请重新生成后扫码登录"),
    USER_NOT_EXIST(10_0112, "用户不存在,请联系管理员");

    public Integer code;
    public String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    SecurityStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static SecurityStatus fromCode(Integer code) {
        for (SecurityStatus status : SecurityStatus.values()) {
            if (status.getCode()
                    .equals(code)) {
                return status;
            }
        }
        return null;
    }

}
