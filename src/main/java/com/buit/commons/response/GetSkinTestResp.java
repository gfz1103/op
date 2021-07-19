package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName GetSkinTestResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/31 13:48
 */
@ApiModel(value="获取药品皮试历史信息-返回")
public class GetSkinTestResp {
    @ApiModelProperty(value="记录编号")
    private Integer jlbh;
    @ApiModelProperty(value="申请时间")
    private String sqsj;
    @ApiModelProperty(value="处方识别")
    private Integer cfsb;
    @ApiModelProperty(value="申请医生")
    private String sqys;
    @ApiModelProperty(value="病人编号")
    private Integer brbh;
    @ApiModelProperty(value="机构ID")
    private String jgid;
    @ApiModelProperty(value="处方号码")
    private String cfhm;
    @ApiModelProperty(value="医生代码")
    private String ysdm_text;
    @ApiModelProperty(value="皮试医生")
    private String psys_text;
    @ApiModelProperty(value="药品单位")
    private String ypdw;
    @ApiModelProperty(value="门诊号码")
    private String mzhm;
    @ApiModelProperty(value="过敏批号")
    private String gmph;
    @ApiModelProperty(value="完成标志")
    private Integer wcbz;
    @ApiModelProperty(value="皮试医生")
    private String psys;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="药品名称")
    private String ypmc;
    @ApiModelProperty(value="药品编号")
    private Integer ypbh;
    @ApiModelProperty(value="皮试时间")
    private String pssj;
    @ApiModelProperty(value="饮食代码")
    private String ysdm;
    @ApiModelProperty(value="皮试结果")
    private String psjg;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="药品规格")
    private String ypgg;

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
    }

    public String getSqsj() {
        return sqsj;
    }

    public void setSqsj(String sqsj) {
        this.sqsj = sqsj;
    }

    public Integer getCfsb() {
        return cfsb;
    }

    public void setCfsb(Integer cfsb) {
        this.cfsb = cfsb;
    }

    public String getSqys() {
        return sqys;
    }

    public void setSqys(String sqys) {
        this.sqys = sqys;
    }

    public Integer getBrbh() {
        return brbh;
    }

    public void setBrbh(Integer brbh) {
        this.brbh = brbh;
    }

    public String getJgid() {
        return jgid;
    }

    public void setJgid(String jgid) {
        this.jgid = jgid;
    }

    public String getCfhm() {
        return cfhm;
    }

    public void setCfhm(String cfhm) {
        this.cfhm = cfhm;
    }

    public String getYsdm_text() {
        return ysdm_text;
    }

    public void setYsdm_text(String ysdm_text) {
        this.ysdm_text = ysdm_text;
    }

    public String getPsys_text() {
        return psys_text;
    }

    public void setPsys_text(String psys_text) {
        this.psys_text = psys_text;
    }

    public String getYpdw() {
        return ypdw;
    }

    public void setYpdw(String ypdw) {
        this.ypdw = ypdw;
    }

    public String getMzhm() {
        return mzhm;
    }

    public void setMzhm(String mzhm) {
        this.mzhm = mzhm;
    }

    public String getGmph() {
        return gmph;
    }

    public void setGmph(String gmph) {
        this.gmph = gmph;
    }

    public Integer getWcbz() {
        return wcbz;
    }

    public void setWcbz(Integer wcbz) {
        this.wcbz = wcbz;
    }

    public String getPsys() {
        return psys;
    }

    public void setPsys(String psys) {
        this.psys = psys;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public Integer getYpbh() {
        return ypbh;
    }

    public void setYpbh(Integer ypbh) {
        this.ypbh = ypbh;
    }

    public String getPssj() {
        return pssj;
    }

    public void setPssj(String pssj) {
        this.pssj = pssj;
    }

    public String getYsdm() {
        return ysdm;
    }

    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }

    public String getPsjg() {
        return psjg;
    }

    public void setPsjg(String psjg) {
        this.psjg = psjg;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public String getYpgg() {
        return ypgg;
    }

    public void setYpgg(String ypgg) {
        this.ypgg = ypgg;
    }
}
