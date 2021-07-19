package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName SystemArgumentCfmxslResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/5 17:10
 */
@ApiModel(value="根据系统参数限制每张处方明细条数-返回")
public class SystemArgumentCfmxslResp {
    @ApiModelProperty(value="录入处方明细数量限制是否启用(西药中药)，0表示不启用,大于0则表示允许录入的最大处方明细数量")
    private Integer cfxyzymxsl;
    @ApiModelProperty(value="录入处方明细数量限制是否启用(草药)，0表示不启用,大于0则表示允许录入的最大处方明细数量")
    private Integer cfcymxsl;

    public Integer getCfxyzymxsl() {
        return cfxyzymxsl;
    }

    public void setCfxyzymxsl(Integer cfxyzymxsl) {
        this.cfxyzymxsl = cfxyzymxsl;
    }

    public Integer getCfcymxsl() {
        return cfcymxsl;
    }

    public void setCfcymxsl(Integer cfcymxsl) {
        this.cfcymxsl = cfcymxsl;
    }
}
