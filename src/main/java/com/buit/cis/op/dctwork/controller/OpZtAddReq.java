package com.buit.cis.op.dctwork.controller;

import com.buit.commons.request.OpZt01AddReq;
import com.buit.commons.request.OpZt02AddReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author weijing
 * @Date 2021-03-22 15:41
 * @Description
 **/
@ApiModel(value="门诊医生工作站组套新增")
public class OpZtAddReq extends OpZt01AddReq {

    @Valid
    @ApiModelProperty(value = "组套详情")
    private List<OpZt02AddReq> opZt02AddReq;

    public List<OpZt02AddReq> getOpZt02AddReq() {
        return opZt02AddReq;
    }

    public void setOpZt02AddReq(List<OpZt02AddReq> opZt02AddReq) {
        this.opZt02AddReq = opZt02AddReq;
    }
}
