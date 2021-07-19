package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @ClassName QueryDisposalEntryListReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/7 16:18
 */
@ApiModel(value="查询处置列表-请求")
public class QueryDisposalEntryListReq {
    @NotNull(message = "病人id 不能为空")
    @ApiModelProperty(value="病人id")
    private Integer brid;
    @NotNull(message = "就诊序号 不能为空")
    @ApiModelProperty(value="就诊序号")
    private Integer jzxh;
    @NotNull(message = "附加类别 不能为空")
    @ApiModelProperty(value="附加类别")
    private Integer fjlb;
    @ApiModelProperty(value="项目类型 4检验,5检查", hidden = true)
    private Integer xmlx;

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

    public Integer getFjlb() {
        return fjlb;
    }

    public void setFjlb(Integer fjlb) {
        this.fjlb = fjlb;
    }

    public Integer getXmlx() {
        return xmlx;
    }

    public void setXmlx(Integer xmlx) {
        this.xmlx = xmlx;
    }
}
