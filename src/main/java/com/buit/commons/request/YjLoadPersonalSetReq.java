package com.buit.commons.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName YjLoadPersonalSetReq
 * @Description 医技根据组套载入组套明细信息-请求
 * @Author 老花生
 * @Date 2020/7/24 13:47
 */
@ApiModel(value="医技根据组套载入组套明细信息-请求")
public class YjLoadPersonalSetReq {
    @NotNull(message = "组套编号不能为空")
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @NotNull(message = "组套编号不能为空")
    @ApiModelProperty(value="病人ID")
    private Integer brid;
    @NotNull(message = "组套编号不能为空")
    @ApiModelProperty(value="病人性质")
    private Integer brxz;
    @ApiModelProperty(value="组套明细ID集合")
    private List<Integer> zt02Jlbh;

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }

    public List<Integer> getZt02Jlbh() {
        return zt02Jlbh;
    }

    public void setZt02Jlbh(List<Integer> zt02Jlbh) {
        this.zt02Jlbh = zt02Jlbh;
    }
}
