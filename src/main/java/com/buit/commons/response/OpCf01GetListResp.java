
package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpCf01<br>
 * 类描述：门诊_门诊处方表<br>
 * @author 老花生
 */
@ApiModel(value="门诊_门诊处方表-查询集合返回")
public class OpCf01GetListResp {
    @ApiModelProperty(value="处方识别 | 通过该字段和OP_CF02关联")
    private Integer cfsb;
    @ApiModelProperty(value="处方号码 | 外部标示一张处方，不唯一")
    private String cfhm;
    @ApiModelProperty(value="处方类型 | 1：西药处方 2：中药处方 3：草药处方")
    private Integer cflx;
    @ApiModelProperty(value="发票号码 | 该处方所属的发票")
    private String fphm;
    @ApiModelProperty(value="作废判别 | 0：有效处方  1：作废处方 该字段具有最高优先级，当ZFPB=1时， 其它各标志均无效")
    private Integer zfpb;
    @ApiModelProperty(value="药房识别 | 该处方到哪个药房发药的标识，由门诊的配置文件决定")
    private Integer yfsb;

    public Integer getCfsb() {
        return cfsb;
    }

    public void setCfsb(Integer cfsb) {
        this.cfsb = cfsb;
    }

    public String getCfhm() {
        return cfhm;
    }

    public void setCfhm(String cfhm) {
        this.cfhm = cfhm;
    }

    public Integer getCflx() {
        return cflx;
    }

    public void setCflx(Integer cflx) {
        this.cflx = cflx;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public Integer getZfpb() {
        return zfpb;
    }

    public void setZfpb(Integer zfpb) {
        this.zfpb = zfpb;
    }

    public Integer getYfsb() {
        return yfsb;
    }

    public void setYfsb(Integer yfsb) {
        this.yfsb = yfsb;
    }
}
