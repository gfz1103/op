package com.buit.commons.enums;


public enum MpPsxxZtEnum {

    WFH("0", "未发货"),
    PSZ("1", "配送中"),
    YQS("2", "已签收"),
    YQX("3", "已取消"),
    ;

    private String key;
    private String value;

    MpPsxxZtEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
