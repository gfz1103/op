package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * 类名称：PubBrxz
 * 类描述：病人性质维护-编辑
 *
 * @author liushijie
 */
@ApiModel(value = "病人性质维护-编辑")
public class PubBrxzTreeResp {
    @NotNull(message = "性质代码不能为空")
    @ApiModelProperty(value = "性质代码", required = true)
    private Integer brxz;
    @ApiModelProperty(value = "性质名称", required = true)
    private String xzmc;
    @ApiModelProperty(value = "上级性质", required = true)
    private Integer sjxz;

    private List<PubBrxzTreeResp> childrenList;

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }

    public String getXzmc() {
        return xzmc;
    }

    public void setXzmc(String xzmc) {
        this.xzmc = xzmc;
    }

    public Integer getSjxz() {
        return sjxz;
    }

    public void setSjxz(Integer sjxz) {
        this.sjxz = sjxz;
    }

    public List<PubBrxzTreeResp> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<PubBrxzTreeResp> childrenList) {
        this.childrenList = childrenList;
    }
}
