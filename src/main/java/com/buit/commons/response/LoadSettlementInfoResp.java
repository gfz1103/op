package com.buit.commons.response;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName LoadSettlementInfoResp
 * @Description 载入结算明细
 * @Author 老花生
 * @Date 2020/7/14 13:45
 */
@ApiModel(value="载入结算明细返回")
public class LoadSettlementInfoResp {
    @ApiModelProperty(value="处方金额")
    private BigDecimal cfje;
    @ApiModelProperty(value="处方数量")
    private Long cfsl;
    @ApiModelProperty(value="检查金额")
    private BigDecimal jcje;
    @ApiModelProperty(value="检查数量")
    private Long jcsl;
    @ApiModelProperty(value="处方金额集合")
    List<BigDecimal> measures;
    @ApiModelProperty(value="医技金额集合")
    List<BigDecimal> disposal;
    @ApiModelProperty(value="合计金额")
    BigDecimal hj ;
    @ApiModelProperty(value="未付款")
    BigDecimal wfk ;
    @ApiModelProperty(value="已付款")
    BigDecimal yfk ;

    public BigDecimal getCfje() {
        return cfje;
    }

    public void setCfje(BigDecimal cfje) {
        this.cfje = cfje;
    }

    public Long getCfsl() {
        return cfsl;
    }

    public void setCfsl(Long cfsl) {
        this.cfsl = cfsl;
    }

    public BigDecimal getJcje() {
        return jcje;
    }

    public void setJcje(BigDecimal jcje) {
        this.jcje = jcje;
    }

    public Long getJcsl() {
        return jcsl;
    }

    public void setJcsl(Long jcsl) {
        this.jcsl = jcsl;
    }

    public List<BigDecimal> getMeasures() {
        return measures;
    }

    public void setMeasures(List<BigDecimal> measures) {
        this.measures = measures;
    }

    public List<BigDecimal> getDisposal() {
        return disposal;
    }

    public void setDisposal(List<BigDecimal> disposal) {
        this.disposal = disposal;
    }

    public BigDecimal getHj() {
        return hj;
    }

    public void setHj(BigDecimal hj) {
        this.hj = hj;
    }

    public BigDecimal getWfk() {
        return wfk;
    }

    public void setWfk(BigDecimal wfk) {
        this.wfk = wfk;
    }

    public BigDecimal getYfk() {
        return yfk;
    }

    public void setYfk(BigDecimal yfk) {
        this.yfk = yfk;
    }
}
