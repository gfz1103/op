package com.buit.commons.model;

/**
 * @Author weijing
 * @Date 2021-01-27 09:55
 * @Description
 **/
public class WorkloadAccountForKF {
    /**客服工号**/
    private Integer kfgh;

    /**客服姓名**/
    private String  kfxm;

    /**咨询数量**/
    private String  zxsl;

    /**科室代码**/
    private Integer ksdm;

    /**科室名称**/
    private String  ksmc;

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public Integer getKfgh() {
        return kfgh;
    }

    public void setKfgh(Integer kfgh) {
        this.kfgh = kfgh;
    }

    public String getKfxm() {
        return kfxm;
    }

    public void setKfxm(String kfxm) {
        this.kfxm = kfxm;
    }

    public String getZxsl() {
        return zxsl;
    }

    public void setZxsl(String zxsl) {
        this.zxsl = zxsl;
    }
}
