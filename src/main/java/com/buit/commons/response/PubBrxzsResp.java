
package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * 类名称：PubBrxz<br>
 * 类描述：公用_个病人性质<br>
 * @author 卑军华
 */
@ApiModel(value="公用_病人性质详细信息")

public class PubBrxzsResp {
    @ApiModelProperty(value="病人性质")
    private int brxz;
    @ApiModelProperty(value="性质名称")
    private String xzmc;
    @ApiModelProperty(value="上级性质")
    private int sjxz;
    @ApiModelProperty(value="是否更改")
    private String sfgg;
    @ApiModelProperty(value="特殊代码")
    private String tsdm;

    public int getBrxz() {
        return brxz;
    }

    public void setBrxz(int brxz) {
        this.brxz = brxz;
    }

    public String getXzmc() {
        return xzmc;
    }

    public void setXzmc(String xzmc) {
        this.xzmc = xzmc;
    }

    public int getSjxz() {
        return sjxz;
    }

    public void setSjxz(int sjxz) {
        this.sjxz = sjxz;
    }

    public String getSfgg() {
        return sfgg;
    }

    public void setSfgg(String sfgg) {
        this.sfgg = sfgg;
    }

    public String getTsdm() {
        return tsdm;
    }

    public void setTsdm(String tsdm) {
        this.tsdm = tsdm;
    }
}
