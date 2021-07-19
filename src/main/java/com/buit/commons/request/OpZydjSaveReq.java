package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


/**
 * 门诊住院登记分页查询请求
 * 类名称：OpZydjPageReq<br>
 * 类描述：<br>
 * @author 老花生
 */
@ApiModel(value="门诊住院登记分页保存请求")
public class OpZydjSaveReq {

    @ApiModelProperty(value="开单科室")
    private String mzks;
    @ApiModelProperty(value="开单医生")
    private String mzys;
    @ApiModelProperty(value="诊断")
    private String brzd;
    @ApiModelProperty(value="联系人姓名")
    private String lxrm;
    @ApiModelProperty(value="联系人地址")
    private String lxdz;
    @ApiModelProperty(value="联系电话")
    private String lxdh;
    @NotBlank(message = "入院目的 不能为空")
    @ApiModelProperty(value="入院目的")
    private String rymd;
    @NotBlank(message = "登记类型 不能为空")
    @ApiModelProperty(value="登记类型")
    private String djlx;
    @NotBlank(message = "拟收治病区 不能为空")
    @ApiModelProperty(value="拟收治病区")
    private String nszbq;
    @ApiModelProperty(value="特需标志")
    private Integer txbz;
    @ApiModelProperty(value="大病减负标志 1:尿毒症透析医疗费用,2:肾移植减负,3：精神病减负  其他：不减负")
    private String dbjfbz;
    @ApiModelProperty(value="开单日期")
    private Timestamp kdrq;
    @ApiModelProperty(value="病人ID")
    @NotNull(message = "病人ID不能为空")
    private Integer brid;
    @ApiModelProperty(value="卡号")
    @NotBlank(message = "卡号不能为空")
    private String cardno;
    @ApiModelProperty(value="申请状态 1新申请2已提交3已入院")
    private String sqzt;
    @ApiModelProperty(value="主诊断")
    private String zzd;
    @ApiModelProperty(value="主诊断ICD10")
    private String zzdicd10;
    @NotNull(message = "就诊流水号 不能为空")
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;
    @NotNull(message = "申请类型 不能为空")
    @ApiModelProperty(value="申请类型：1住院申请、2留观申请")
    private String sqlx = "1";
    @ApiModelProperty(value="拟收治科室")
    @NotNull(message = "拟收治科室 不能为空")
    private Integer nszks;
    @ApiModelProperty(value="联系人关系")
    private String lxrgx;
    @ApiModelProperty(value="机构ID",hidden = true)
    private String jgid;

    public String getJgid() {
        return jgid;
    }

    public void setJgid(String jgid) {
        this.jgid = jgid;
    }

    public Integer getNszks() {
        return nszks;
    }

    public void setNszks(Integer nszks) {
        this.nszks = nszks;
    }

    public String getLxrgx() {
        return lxrgx;
    }

    public void setLxrgx(String lxrgx) {
        this.lxrgx = lxrgx;
    }

    public String getMzks() {
        return mzks;
    }

    public void setMzks(String mzks) {
        this.mzks = mzks;
    }

    public String getMzys() {
        return mzys;
    }

    public void setMzys(String mzys) {
        this.mzys = mzys;
    }

    public String getBrzd() {
        return brzd;
    }

    public void setBrzd(String brzd) {
        this.brzd = brzd;
    }

    public String getLxrm() {
        return lxrm;
    }

    public void setLxrm(String lxrm) {
        this.lxrm = lxrm;
    }

    public String getLxdz() {
        return lxdz;
    }

    public void setLxdz(String lxdz) {
        this.lxdz = lxdz;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getRymd() {
        return rymd;
    }

    public void setRymd(String rymd) {
        this.rymd = rymd;
    }

    public String getDjlx() {
        return djlx;
    }

    public void setDjlx(String djlx) {
        this.djlx = djlx;
    }

    public String getNszbq() {
        return nszbq;
    }

    public void setNszbq(String nszbq) {
        this.nszbq = nszbq;
    }

    public Integer getTxbz() {
        return txbz;
    }

    public void setTxbz(Integer txbz) {
        this.txbz = txbz;
    }

    public String getDbjfbz() {
        return dbjfbz;
    }

    public void setDbjfbz(String dbjfbz) {
        this.dbjfbz = dbjfbz;
    }

    public Timestamp getKdrq() {
        return kdrq;
    }

    public void setKdrq(Timestamp kdrq) {
        this.kdrq = kdrq;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getSqzt() {
        return sqzt;
    }

    public void setSqzt(String sqzt) {
        this.sqzt = sqzt;
    }

    public String getZzd() {
        return zzd;
    }

    public void setZzd(String zzd) {
        this.zzd = zzd;
    }

    public String getZzdicd10() {
        return zzdicd10;
    }

    public void setZzdicd10(String zzdicd10) {
        this.zzdicd10 = zzdicd10;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public String getSqlx() {
        return sqlx;
    }

    public void setSqlx(String sqlx) {
        this.sqlx = sqlx;
    }
}
