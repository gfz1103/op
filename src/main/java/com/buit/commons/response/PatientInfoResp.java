
package com.buit.commons.response;

import java.util.List;

import com.buit.commons.model.MsBcjl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：GyBlmb<br>
 * 类描述：病人信息<br>
 * @author 老花生
 */
@ApiModel(value="病人信息")
public class PatientInfoResp {
    @ApiModelProperty(value="病人档案对象")
    private PatientListBrdaResp brda;
    @ApiModelProperty(value="id集合")
    private IdsResp ids;
    @ApiModelProperty(value="病程记录")
    private MsBcjl bcjl;
    @ApiModelProperty(value="健康处方")
    List<HerHealthreciperecordMzResp> jkcfList;
    @ApiModelProperty(value="诊断")
    List<OpBrzdPatientResp> brzdList;
    @ApiModelProperty(value="诊断明细")
    List<PatientPrescriptionDetailsResp> zdDetailsList;
    @ApiModelProperty(value="组套信息")
    List<OpZt01Resp> ztList;
    @ApiModelProperty(value="医技")
    List<InitPatientDisposeResp> yjList;

    public IdsResp getIds() {
        return ids;
    }

    public void setIds(IdsResp ids) {
        this.ids = ids;
    }

    public PatientListBrdaResp getBrda() {
        return brda;
    }

    public void setBrda(PatientListBrdaResp brda) {
        this.brda = brda;
    }

    public MsBcjl getBcjl() {
        return bcjl;
    }

    public void setBcjl(MsBcjl bcjl) {
        this.bcjl = bcjl;
    }

    public List<HerHealthreciperecordMzResp> getJkcfList() {
        return jkcfList;
    }

    public void setJkcfList(List<HerHealthreciperecordMzResp> jkcfList) {
        this.jkcfList = jkcfList;
    }

    public List<OpBrzdPatientResp> getBrzdList() {
        return brzdList;
    }

    public void setBrzdList(List<OpBrzdPatientResp> brzdList) {
        this.brzdList = brzdList;
    }

    public List<PatientPrescriptionDetailsResp> getZdDetailsList() {
        return zdDetailsList;
    }

    public void setZdDetailsList(List<PatientPrescriptionDetailsResp> zdDetailsList) {
        this.zdDetailsList = zdDetailsList;
    }

    public List<OpZt01Resp> getZtList() {
        return ztList;
    }

    public void setZtList(List<OpZt01Resp> ztList) {
        this.ztList = ztList;
    }

    public List<InitPatientDisposeResp> getYjList() {
        return yjList;
    }

    public void setYjList(List<InitPatientDisposeResp> yjList) {
        this.yjList = yjList;
    }
}
