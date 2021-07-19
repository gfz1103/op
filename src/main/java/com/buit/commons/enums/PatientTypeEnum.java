package com.buit.commons.enums;


/**
 * @author 老花生
 */
public enum PatientTypeEnum {
    //病人就诊状态 |   1 待诊 2 暂挂 3 已诊
    code_1(1),
    code_2(2),
    code_3(3);

    private Integer code;

    PatientTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
