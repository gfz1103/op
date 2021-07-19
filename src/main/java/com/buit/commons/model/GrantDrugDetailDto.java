package com.buit.commons.model;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/9/10 19:22
 */
public class GrantDrugDetailDto {

    private String ypmc;
    private BigDecimal ypsl;
    private String gytj;
    private String ypyl;
    private String ypyf;
    private String ypgg;
    private String ypcj;
    private String yppc;
    private String ypwz;

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public BigDecimal getYpsl() {
        return ypsl;
    }

    public void setYpsl(BigDecimal ypsl) {
        this.ypsl = ypsl;
    }

    public String getGytj() {
        return gytj;
    }

    public void setGytj(String gytj) {
        this.gytj = gytj;
    }

    public String getYpyl() {
        return ypyl;
    }

    public void setYpyl(String ypyl) {
        this.ypyl = ypyl;
    }

    public String getYpyf() {
        return ypyf;
    }

    public void setYpyf(String ypyf) {
        this.ypyf = ypyf;
    }

    public String getYpgg() {
        return ypgg;
    }

    public void setYpgg(String ypgg) {
        this.ypgg = ypgg;
    }

    public String getYpcj() {
        return ypcj;
    }

    public void setYpcj(String ypcj) {
        this.ypcj = ypcj;
    }

    public String getYppc() {
        return yppc;
    }

    public void setYppc(String yppc) {
        this.yppc = yppc;
    }

    public String getYpwz() {
        return ypwz;
    }

    public void setYpwz(String ypwz) {
        this.ypwz = ypwz;
    }
}
