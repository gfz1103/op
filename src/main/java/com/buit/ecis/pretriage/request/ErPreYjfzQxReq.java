
package com.buit.ecis.pretriage.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


/**
 * 类名称：ErPreYjfz<br> 
 * 类描述：急诊预检分诊<br>
 * @author 朱智
 */
@ApiModel(value="急诊预检分诊-去向-请求")
public class ErPreYjfzQxReq {
    @NotNull(message = "急诊流水号 不能为空")
    @ApiModelProperty(value="急诊流水号")
    private Integer lsh;
    @NotNull(message = "离开时间 不能为空")
    @ApiModelProperty(value="离开时间")
    private Timestamp lksj;
    @NotBlank(message = "去向 不能为空")
    @ApiModelProperty(value="去向")
    private String qx;
    @NotNull(message = "停留时间 不能为空")
    @ApiModelProperty(value="停留时间（分钟）")
    private Double tlsj;

    public Integer getLsh() {
        return lsh;
    }

    public void setLsh(Integer lsh) {
        this.lsh = lsh;
    }

    public Timestamp getLksj() {
        return lksj;
    }

    public void setLksj(Timestamp lksj) {
        this.lksj = lksj;
    }

    public String getQx() {
        return qx;
    }

    public void setQx(String qx) {
        this.qx = qx;
    }

    public Double getTlsj() {
        return tlsj;
    }

    public void setTlsj(Double tlsj) {
        this.tlsj = tlsj;
    }
}