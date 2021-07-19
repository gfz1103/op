package com.buit.commons.model;

/**
 * @Author weijing
 * @Date 2021-04-20 10:59
 * @Description
 **/
public class CzData {
    /** 发票号码 **/
    private String fphm;

    /** 作废标志 **/
    private Integer zfbz;

    /** 识别序号 **/
    private Integer sbxh;

    /** 组套标志 1组套 0非组套 **/
    private Integer ztbz;

    /** 医技序号 **/
    private Integer yjxh;

    /** 就诊流水号 **/
    private String jzlsh;

    /** 项目类型 **/
    private Integer xmlx;

    /** 申请单id（项目为检查时 对应cisjcsq01表主键） **/
    private Integer sqid;

    /** 手术申请单id **/
    private Integer sssqid;

    /** 治疗申请单id **/
    private Integer zlsqdid;

    /** opyj02zt表主键 **/
    private Integer ztyzsbxh;

    /** 机构id **/
    private Integer jgid;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public Integer getZfbz() {
        return zfbz;
    }

    public void setZfbz(Integer zfbz) {
        this.zfbz = zfbz;
    }

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public Integer getZtbz() {
        return ztbz;
    }

    public void setZtbz(Integer ztbz) {
        this.ztbz = ztbz;
    }

    public Integer getYjxh() {
        return yjxh;
    }

    public void setYjxh(Integer yjxh) {
        this.yjxh = yjxh;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public Integer getXmlx() {
        return xmlx;
    }

    public void setXmlx(Integer xmlx) {
        this.xmlx = xmlx;
    }

    public Integer getSqid() {
        return sqid;
    }

    public void setSqid(Integer sqid) {
        this.sqid = sqid;
    }

    public Integer getSssqid() {
        return sssqid;
    }

    public void setSssqid(Integer sssqid) {
        this.sssqid = sssqid;
    }

    public Integer getZlsqdid() {
        return zlsqdid;
    }

    public void setZlsqdid(Integer zlsqdid) {
        this.zlsqdid = zlsqdid;
    }

    public Integer getZtyzsbxh() {
        return ztyzsbxh;
    }

    public void setZtyzsbxh(Integer ztyzsbxh) {
        this.ztyzsbxh = ztyzsbxh;
    }
}
