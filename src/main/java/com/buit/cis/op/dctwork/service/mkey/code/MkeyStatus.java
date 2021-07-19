package com.buit.cis.op.dctwork.service.mkey.code;

public enum MkeyStatus{
    VERIFY_FAIL(1900_01, "签名验证错误"),
    CONFIRM(1900_02, "扫码确认中"),
    ERROR(1900_03, "接口调用出现异常"),
    TIMESTAMPERROR(1900_04,"获取时间戳接口异常"),
    CERT_NULL(1900_05, "证书为空"),
    SIGN_USER_NOT_MATCH(1900_06, "签名人不匹配,请重新签名"),
    ;

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    MkeyStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
