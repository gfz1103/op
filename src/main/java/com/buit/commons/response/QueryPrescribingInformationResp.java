package com.buit.commons.response;

import com.buit.commons.model.CfDetailDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/5/13 19:41
 */
@ApiModel("QueryPrescribingInformationResp")
public class QueryPrescribingInformationResp extends CfDetailDto {


    @ApiModelProperty("皮试结果,字典:SYS_FLAG_DATA:FD000003")
    private String psjg;
    @ApiModelProperty("诊断名称")
    private String zdmc;

    public String getPsjg() {
        return psjg;
    }

    public void setPsjg(String psjg) {
        this.psjg = psjg;
    }

    public String getZdmc() {
        return zdmc;
    }

    public void setZdmc(String zdmc) {
        this.zdmc = zdmc;
    }
}
