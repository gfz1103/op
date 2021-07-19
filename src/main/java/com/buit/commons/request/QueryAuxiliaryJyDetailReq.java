package com.buit.commons.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckInventoryReq
 * @Description 查询辅助报告检验明细信息-请求
 * @Author 老花生
 * @Date 2020/9/3 10:15
 */
@ApiModel(value="查询辅助报告检验明细信息-请求")
public class QueryAuxiliaryJyDetailReq {
    @NotNull(message = "医技序号 不能为空")
    @ApiModelProperty(value="医技主键")
    private Integer yjxh;

    public Integer getYjxh() {
        return yjxh;
    }

    public void setYjxh(Integer yjxh) {
        this.yjxh = yjxh;
    }
}
