package com.buit.commons.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/9/18 13:20
 */
public class GeneralWhiteCombatDetailDto {

    private String ypmc;
    private String yfgg;
    private BigDecimal ypsl;
    private String yfdw;
    private String ycjl;
    private String jldw;
    private String gytj;
    private String ypyf;
    private String ypzh;

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getYfgg() {
        return yfgg;
    }

    public void setYfgg(String yfgg) {
        this.yfgg = yfgg;
    }

    public BigDecimal getYpsl() {
        return ypsl;
    }

    public void setYpsl(BigDecimal ypsl) {
        this.ypsl = ypsl;
    }

    public String getYfdw() {
        return yfdw;
    }

    public void setYfdw(String yfdw) {
        this.yfdw = yfdw;
    }

    public String getYcjl() {
        return ycjl;
    }

    public void setYcjl(String ycjl) {
        this.ycjl = ycjl;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public String getGytj() {
        return gytj;
    }

    public void setGytj(String gytj) {
        this.gytj = gytj;
    }

    public String getYpyf() {
        return ypyf;
    }

    public void setYpyf(String ypyf) {
        this.ypyf = ypyf;
    }

    public String getYpzh() {
        return ypzh;
    }

    public void setYpzh(String ypzh) {
        this.ypzh = ypzh;
    }
}
