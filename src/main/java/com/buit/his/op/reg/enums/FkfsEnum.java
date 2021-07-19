package com.buit.his.op.reg.enums;

public enum FkfsEnum {
    XJ(1, "现金支付"),
    ZP(2, "支票支付"),
    WX(3, "微信支付"),
    ZFB(4, "支付宝支付"),
    CZK(9, "充值卡支付"),
    ;

    private Integer key;
    private String value;

    FkfsEnum(Integer key, String value) {
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
