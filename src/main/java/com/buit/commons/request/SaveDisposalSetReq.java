package com.buit.commons.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName SaveDisposalSetReq
 * @Description 根据组套载入组套明细信息（全院-科室）-请求
 * @Author 老花生
 * @Date 2020/7/29 9:41
 */
@ApiModel(value="根据组套载入组套明细信息（全院-科室）-请求")
public class SaveDisposalSetReq {
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @ApiModelProperty(value="组套名称")
    private String ztmc;
    @ApiModelProperty(value="组套类别")
    private Integer ztlb;
    @ApiModelProperty(value="组套类别-名称")
    private String ztlb_text;
    @ApiModelProperty(value="所属类别")
    private Integer sslb;
    @ApiModelProperty(value="所属类别-名称")
    private String sslb_text;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="员工代码")
    private Integer ygdm;
    @ApiModelProperty(value="项目选取")
    private Integer xmxq;
    @ApiModelProperty(value="排列顺序")
    private String plsx;
    @ApiModelProperty(value="启用")
    private Integer sfqy;
    @ApiModelProperty(value="启用-名称")
    private String sfqy_text;
    @ApiModelProperty(value="机构ID")
    private Integer jgid;
    @ApiModelProperty(value="病人性质")
    private Integer brxz;
    @ApiModelProperty(value="就诊序号")
    private Integer jzxh;
    @ApiModelProperty(value="病人ID")
    private Integer brid;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="挂号关联")
    private Integer ghgl;
    @ApiModelProperty(value="医技组号")
    private Integer yjzh;
    @NotNull(message = "就诊流水号 不能为空")
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;
    @NotNull(message = "就诊卡号 不能为空")
    @ApiModelProperty(value="jzkh")
    private String jzkh;

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
    }

    public String getZtmc() {
        return ztmc;
    }

    public void setZtmc(String ztmc) {
        this.ztmc = ztmc;
    }

    public Integer getZtlb() {
        return ztlb;
    }

    public void setZtlb(Integer ztlb) {
        this.ztlb = ztlb;
    }

    public String getZtlb_text() {
        return ztlb_text;
    }

    public void setZtlb_text(String ztlb_text) {
        this.ztlb_text = ztlb_text;
    }

    public Integer getSslb() {
        return sslb;
    }

    public void setSslb(Integer sslb) {
        this.sslb = sslb;
    }

    public String getSslb_text() {
        return sslb_text;
    }

    public void setSslb_text(String sslb_text) {
        this.sslb_text = sslb_text;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Integer getXmxq() {
        return xmxq;
    }

    public void setXmxq(Integer xmxq) {
        this.xmxq = xmxq;
    }

    public String getPlsx() {
        return plsx;
    }

    public void setPlsx(String plsx) {
        this.plsx = plsx;
    }

    public Integer getSfqy() {
        return sfqy;
    }

    public void setSfqy(Integer sfqy) {
        this.sfqy = sfqy;
    }

    public String getSfqy_text() {
        return sfqy_text;
    }

    public void setSfqy_text(String sfqy_text) {
        this.sfqy_text = sfqy_text;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }

    public Integer getYgdm() {
        return ygdm;
    }

    public void setYgdm(Integer ygdm) {
        this.ygdm = ygdm;
    }

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Integer getGhgl() {
        return ghgl;
    }

    public void setGhgl(Integer ghgl) {
        this.ghgl = ghgl;
    }

    public Integer getYjzh() {
        return yjzh;
    }

    public void setYjzh(Integer yjzh) {
        this.yjzh = yjzh;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }
}
