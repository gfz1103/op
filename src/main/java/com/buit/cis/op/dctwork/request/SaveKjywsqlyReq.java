package com.buit.cis.op.dctwork.request;

/**
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/10/30 9:45
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class SaveKjywsqlyReq {
    @ApiModelProperty("处方明细主键")
    private Integer sbxh;
    @ApiModelProperty("抗菌药物申请理由")
    private String kjywsqly;

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public String getKjywsqly() {
        return kjywsqly;
    }

    public void setKjywsqly(String kjywsqly) {
        this.kjywsqly = kjywsqly;
    }
}
