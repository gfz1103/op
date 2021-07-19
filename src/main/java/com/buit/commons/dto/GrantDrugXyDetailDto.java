package com.buit.commons.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.sql.Timestamp;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/9/15 15:49
 */
public class GrantDrugXyDetailDto {

    private String ypsl;
    private String ypmc;
    private String yfgg;
    private String ypyf;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Timestamp jzrq;
    private String brxm;

    public String getYpsl() {
        return ypsl;
    }

    public void setYpsl(String ypsl) {
        this.ypsl = ypsl;
    }

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

    public String getYpyf() {
        return ypyf;
    }

    public void setYpyf(String ypyf) {
        this.ypyf = ypyf;
    }

    public Timestamp getJzrq() {
        return jzrq;
    }

    public void setJzrq(Timestamp jzrq) {
        this.jzrq = jzrq;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }
}
