
package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpBrzd<br>
 * 类描述：门诊_病人诊断<br>
 * @author 老花生
 */
@ApiModel(value="门诊_病人诊断")
public class OpBrzdReq {

    @ApiModelProperty(value="病人ID")
    private Integer brid;
    @ApiModelProperty(value="就诊序号 | 每次就诊的唯一号")
    private Integer jzxh;

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
}
