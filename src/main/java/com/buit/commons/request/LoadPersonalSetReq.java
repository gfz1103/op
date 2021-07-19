package com.buit.commons.request;

import java.util.List;

import com.buit.apply.response.OpZt02CdResp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName LoadPersonalSetReq
 * @Description 根据组套载入组套明细信息请求
 * @Author 老花生
 * @Date 2020/7/15 19:58
 */
@ApiModel(value="根据组套载入组套明细信息请求")
public class LoadPersonalSetReq {
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;

    @ApiModelProperty(value="处方类型")
    private Integer clinicType;

    @ApiModelProperty(value="药房识别")
    private Integer pharmacyId;

    @ApiModelProperty(value="病人性质")
    private Integer brxz;

    @ApiModelProperty(value="产地信息集合")
    List<OpZt02CdResp> cdList;

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
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

    public List<OpZt02CdResp> getCdList() {
        return cdList;
    }

    public void setCdList(List<OpZt02CdResp> cdList) {
        this.cdList = cdList;
    }
}
