package com.buit.his.op.reg.enums;

public enum OpPjlxEnum {


    JZHM(1, "就诊号码"),
    FPHM(2, "发票号码"),
    DAHM(3, "档案号码"),
    CZHM(4, "充值号码"),
    ;

    private Integer key;
    private String value;

    OpPjlxEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }


    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
