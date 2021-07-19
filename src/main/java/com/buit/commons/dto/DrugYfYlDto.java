package com.buit.commons.dto;

import java.math.BigDecimal;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/9/15 11:32
 */
public class DrugYfYlDto {
    private Integer jf;
    private Integer zfyp;
    private String ypmc;
    private BigDecimal ypjl;
    private String jldw;
    private String yfmc;

    public Integer getJf() {
        return jf;
    }

    public void setJf(Integer jf) {
        this.jf = jf;
    }

    public Integer getZfyp() {
        return zfyp;
    }

    public void setZfyp(Integer zfyp) {
        this.zfyp = zfyp;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public BigDecimal getYpjl() {
        return ypjl;
    }

    public void setYpjl(BigDecimal ypjl) {
        this.ypjl = ypjl;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public String getYfmc() {
        return yfmc;
    }

    public void setYfmc(String yfmc) {
        this.yfmc = yfmc;
    }
}
