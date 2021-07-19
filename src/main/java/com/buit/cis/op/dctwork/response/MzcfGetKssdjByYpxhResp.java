package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description 门诊处方获取抗生素等级
 * @Author 老花生
 * @Date 2020/10/26 11:05
 */
@ApiModel(value="门诊处方获取抗生素等级")
public class MzcfGetKssdjByYpxhResp {
    @ApiModelProperty(value="药品抗生素等级")
    private Integer kssdj;
    @ApiModelProperty(value="医生抗生素等级")
    private String yskssdj;

    public Integer getKssdj() {
        return kssdj;
    }

    public void setKssdj(Integer kssdj) {
        this.kssdj = kssdj;
    }

    public String getYskssdj() {
        return yskssdj;
    }

    public void setYskssdj(String yskssdj) {
        this.yskssdj = yskssdj;
    }
}
