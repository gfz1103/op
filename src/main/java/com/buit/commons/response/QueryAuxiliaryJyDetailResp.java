package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckInventoryReq
 * @Description 查询辅助报告检验明细信息-返回
 * @Author 老花生
 * @Date 2020/9/3 10:17
 */
@ApiModel(value="查询辅助报告检验明细信息-返回")
public class QueryAuxiliaryJyDetailResp {
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @ApiModelProperty(value="组套名称")
    private String ztmc;
    @ApiModelProperty(value="名称")
    private String fymc;
    @ApiModelProperty(value="申请单号")
    private Integer sqdh;

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public Integer getSqdh() {
        return sqdh;
    }

    public void setSqdh(Integer sqdh) {
        this.sqdh = sqdh;
    }

    public String getZtmc() {
        return ztmc;
    }

    public void setZtmc(String ztmc) {
        this.ztmc = ztmc;
    }
}
