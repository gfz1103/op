package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName LoadMedcineInfoReq
 * @Description 根据药品序号获取药品信息请求
 * @Author 老花生
 * @Date 2020/7/16 10:28
 */
@ApiModel(value="根据药品序号获取药品信息请求")
public class LoadMedcineInfoReq {
    @ApiModelProperty(value="药品序号")
    private Integer ypxh;
    @ApiModelProperty(value="药品名称")
    private String ypmc;
    @ApiModelProperty(value="tabId(如：clinicCommon、clinicAll)")
    private String tabId;
    @ApiModelProperty(value="费用归并")
    private Integer fygb;
    @ApiModelProperty(value="处方类型")
    private Integer clinicType;
    @ApiModelProperty(value="药房识别")
    private Integer pharmacyId;
    @ApiModelProperty(value="病人性质")
    private Integer brxz;
    @ApiModelProperty(value="记录编号")
    private Integer jlbh;
    @ApiModelProperty(value="药品传药品类型1,2,3,费用传0")
    private Integer type;

    public Integer getYpxh() {
        return ypxh;
    }

    public void setYpxh(Integer ypxh) {
        this.ypxh = ypxh;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

    public Integer getClinicType() {
        return clinicType;
    }

    public void setClinicType(Integer clinicType) {
        this.clinicType = clinicType;
    }

    public Integer getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
