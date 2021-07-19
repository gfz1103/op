package com.buit.commons.enums;


/**
 * @author All
 */
public enum SslbEnum {
    //所属类别 |  SSLB 1 个人 2 科室 3 全院 4 B类模板
    code_1(1),
    code_2(2),
    code_3(3),
    code_4(4);

    private Integer code;

    SslbEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
