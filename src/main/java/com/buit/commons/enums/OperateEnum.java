package com.buit.commons.enums;


/**
 * @author 老花生
 */
public enum OperateEnum {
    //type 1:病历 2：诊断 3：处方 4:处置 5：所有
    code_1("1"),
    code_2("2"),
    code_3("3"),
    code_4("4"),
    code_5("5");

    private String code;

    OperateEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
