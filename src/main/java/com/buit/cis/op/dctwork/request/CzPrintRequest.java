package com.buit.cis.op.dctwork.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author weijing
 * @Date 2021-04-23 13:25
 * @Description
 **/
@ApiModel(value = "处置打印入参")
public class CzPrintRequest {
    @ApiModelProperty(value = "就诊流水号")
    @NotBlank(message = "就诊流水号不能为空")
    private String jzlsh;

    @ApiModelProperty(value = "类型 1打印全部 2打印同组 3打印选中")
    @NotBlank(message = "打印类型不能为空")
    private String type;

    @ApiModelProperty(value = "处置打印的数据集合")
    private List<CzPrintData> czPrintData;

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CzPrintData> getCzPrintData() {
        return czPrintData;
    }

    public void setCzPrintData(List<CzPrintData> czPrintData) {
        this.czPrintData = czPrintData;
    }
}
