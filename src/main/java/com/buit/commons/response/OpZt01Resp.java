
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpZt01<br>
 * 类描述：门诊_门诊医生组套 | 个人:YGDM值 科室:KSDM值 公用:NULL值<br>
 * @author 老花生
 */
@ApiModel(value="门诊_门诊医生组套 | 个人:YGDM值 科室:KSDM值 公用:NULL值")
public class OpZt01Resp  extends PageQuery {
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @ApiModelProperty(value="组套名称")
    private String ztmc;
    @ApiModelProperty(value="组套类别 | 1.西药 2.中药 3.草药 4.项目")
    private Integer ztlb;
    @ApiModelProperty(value="是否启用")
    private Integer sfqy;
    @ApiModelProperty(value="组套类型名称")
    private String ztlxMc;
    @ApiModelProperty(value="科室代码")
    private String ksdm;

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
    }

    public String getZtmc() {
        return ztmc;
    }

    public void setZtmc(String ztmc) {
        this.ztmc = ztmc;
    }

    public Integer getSfqy() {
        return sfqy;
    }

    public void setSfqy(Integer sfqy) {
        this.sfqy = sfqy;
    }

    public Integer getZtlb() {
        return ztlb;
    }

    public void setZtlb(Integer ztlb) {
        this.ztlb = ztlb;
    }

    public String getZtlxMc() {
        return ztlxMc;
    }

    public void setZtlxMc(String ztlxMc) {
        this.ztlxMc = ztlxMc;
    }

    public String getKsdm() {
        return ksdm;
    }

    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }
}
