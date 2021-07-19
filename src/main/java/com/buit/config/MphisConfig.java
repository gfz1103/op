package com.buit.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConditionalOnProperty(prefix = "mphis.hospital", name = "yljgdm")
@ConfigurationProperties(prefix = "mphis.hospital")
public class MphisConfig {

    static final Logger logger = LoggerFactory.getLogger(MphisConfig.class);

    private String yljgdm;
    private String wsjgdm;
    private Long ygdm;
    private String ygxm;
    private String ybip;

    public String getYljgdm() {
        return yljgdm;
    }

    public void setYljgdm(String yljgdm) {
        this.yljgdm = yljgdm;
    }

    public String getWsjgdm() {
        return wsjgdm;
    }

    public void setWsjgdm(String wsjgdm) {
        this.wsjgdm = wsjgdm;
    }

    public Long getYgdm() {
        return ygdm;
    }

    public void setYgdm(Long ygdm) {
        this.ygdm = ygdm;
    }

    public String getYgxm() {
        return ygxm;
    }

    public void setYgxm(String ygxm) {
        this.ygxm = ygxm;
    }

    public String getYbip() {
        return ybip;
    }

    public void setYbip(String ybip) {
        this.ybip = ybip;
    }

    @PostConstruct
    public void init(){
        logger.info("加载互联网模块参数:{}", toString());
    }

    @Override
    public String toString() {
        return "MphisConfig{" +
                "yljgdm='" + yljgdm + '\'' +
                ", wsjgdm='" + wsjgdm + '\'' +
                ", ygdm='" + ygdm + '\'' +
                ", ygxm='" + ygxm + '\'' +
                ", ybip='" + ybip + '\'' +
                '}';
    }
}
