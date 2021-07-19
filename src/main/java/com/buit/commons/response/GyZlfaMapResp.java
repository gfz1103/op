
package com.buit.commons.response;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：GyZlfa<br>
 * 类描述：公用_诊疗方案<br>
 * @author 老花生
 */
@ApiModel(value="公用_诊疗方案")
public class GyZlfaMapResp {
    @ApiModelProperty(value="常用诊断")
    private List<PubCyzdResp> cyzt;
    @ApiModelProperty(value="处方组套")
    private List<OpZt01Resp> cfzt;
    @ApiModelProperty(value="项目组套")
    private List<OpZt01Resp> xmzt;
    @ApiModelProperty(value="病历模板")
    private List<GyBlmbResp> blmb;

    public List<PubCyzdResp> getCyzt() {
        return cyzt;
    }

    public void setCyzt(List<PubCyzdResp> cyzt) {
        this.cyzt = cyzt;
    }

    public List<OpZt01Resp> getCfzt() {
        return cfzt;
    }

    public void setCfzt(List<OpZt01Resp> cfzt) {
        this.cfzt = cfzt;
    }

    public List<OpZt01Resp> getXmzt() {
        return xmzt;
    }

    public void setXmzt(List<OpZt01Resp> xmzt) {
        this.xmzt = xmzt;
    }

    public List<GyBlmbResp> getBlmb() {
        return blmb;
    }

    public void setBlmb(List<GyBlmbResp> blmb) {
        this.blmb = blmb;
    }
}
