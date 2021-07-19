package com.buit.cis.op.dctwork.service.mkey.consts;

/**
 * <p>
 * 通用状态码
 * </p>
 */
public enum Status{

    SUCCESS(200, "操作成功！"),

    ERROR(500, "操作异常！"),

    LOGOUT(200, "退出成功！"),

    UNAUTHORIZED(401, "请先登录！"),

    ACCESS_DENIED(403, "权限不足！"),

    REQUEST_NOT_FOUND(404, "请求不存在！"),

    HTTP_BAD_METHOD(405, "请求方式不支持！"),

    CONTENT_TYPE_NOT_SUPPORTED(405, "Content-Type请求数据格式不支持"),

    BAD_REQUEST(400, "请求异常！"),

    PARAM_NOT_MATCH(400, "参数不匹配！"),

    PARAM_NOT_NULL(400, "参数不能为空！"),

    ARG_BIND_ERROR(400, "参数错误"),

    PARAM_INVALID(4001, "参数校验失败"),

    USER_DISABLED(403, "当前用户已被锁定，请联系管理员解锁！"),

    USERNAME_PASSWORD_ERROR(5001, "用户名或密码错误！"),

    TOKEN_EXPIRED(5002, "token 已过期，请重新登录！"),

    TOKEN_PARSE_ERROR(5002, "token 解析失败，请尝试重新登录！"),

    TOKEN_OUT_OF_CTRL(5003, "当前用户已在别处登录，请尝试更改密码或重新登录！"),

    KICKOUT_SELF(5004, "无法手动踢出自己，请尝试退出登录操作！"),

    REFRESH_TOKEN_EXPIRED(5005, "refresh token 已过期，请重新登录！"),

    IDEMPOTENT_KEY_EMPTY(5006, "系统异常[5006]"),

    IDEMPOTENT_KEY_CACHE_EMPTY(5007, "您的操作过于频繁,请稍后再试");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    Status(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Status fromCode(Integer code) {
        Status[] statuses = Status.values();
        for (Status status : statuses) {
            if (status.getCode()
                    .equals(code)) {
                return status;
            }
        }
        return SUCCESS;
    }

    @Override
    public String toString() {
        return String.format(" Status:{code=%s, message=%s} ", getCode(), getMsg());
    }

}
