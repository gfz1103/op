package com.buit.cis.op.dctwork.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Author weijing
 * @Date 2021-03-29 10:00
 * @Description
 **/
@ApiModel(value = "疾病证明查询入参")
public class OpJbzmQueryReq extends PageQuery {
    @ApiModelProperty(value="类型:1 门诊 2 住院")
    @NotNull(message = "类型必传 1门诊 2住院")
    private Integer lx;

    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;
    @ApiModelProperty(value="住院号码")
    private String zyhm;

    @ApiModelProperty(value="单据类型 1病情证明单 2疾病证明单",hidden = true)
    private String djlx;
    @ApiModelProperty(value="门诊号码",hidden = true)
    private String mzhm;

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public Integer getLx() {
        return lx;
    }

    public void setLx(Integer lx) {
        this.lx = lx;
    }

    public String getMzhm() {
        return mzhm;
    }

    public void setMzhm(String mzhm) {
        this.mzhm = mzhm;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public String getDjlx() {
        return djlx;
    }

    public void setDjlx(String djlx) {
        this.djlx = djlx;
    }
}
