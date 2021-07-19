package com.buit.commons.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum TradingChannelEnum {
    ONLINE("20"),

    OFFLINE("10");

    private String value;

    TradingChannelEnum(String value) {
        this.value = value;
    }

    private static final Map<String, TradingChannelEnum> ALL_ENTRIES = new HashMap<>(TradingChannelEnum.values().length);
    static {
        for(TradingChannelEnum each : TradingChannelEnum.values()){
            ALL_ENTRIES.put(each.getValue(), each);
        }
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public TradingChannelEnum fromValue(String value){

        return ALL_ENTRIES.get(value);
    }


}
