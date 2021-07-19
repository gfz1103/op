package com.buit.his.op.reg.enums;

public enum PbCzEnum {
    CANCEL(1, "取消"),
    COPY(2, "复制"),
    ;

    private Integer key;
    private String value;

    PbCzEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getPbCzValue(Integer key) {
        for (PbCzEnum c : PbCzEnum.values()) {
            if (c.getKey().equals(key)) {
                return c.getValue();
            }
        }
        return null;
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
