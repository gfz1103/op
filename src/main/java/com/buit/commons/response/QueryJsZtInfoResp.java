
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：QueryJsZtInfoResp<br>
 * 类描述：门诊_门诊医生组套 | 个人:YGDM值 科室:KSDM值 公用:NULL值<br>
 * @author wy
 */
@ApiModel(value="收费结算组套查询")
public class QueryJsZtInfoResp  extends PageQuery {
    @ApiModelProperty(value="组套编号")
    private Integer ypxh;
    @ApiModelProperty(value="组套名称")
    private String ypmc;
    @ApiModelProperty(value="组套类别 | 1.西药 2.中药 3.草药 4.项目")
    private Integer ztlb;
    @ApiModelProperty(value="是否启用")
    private Integer sfqy;
    @ApiModelProperty(value="组套类型名称")
    private String ztlxMc;
	public Integer getYpxh() {
		return ypxh;
	}
	public void setYpxh(Integer ypxh) {
		this.ypxh = ypxh;
	}
	public String getYpmc() {
		return ypmc;
	}
	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}
	public Integer getZtlb() {
		return ztlb;
	}
	public void setZtlb(Integer ztlb) {
		this.ztlb = ztlb;
	}
	public Integer getSfqy() {
		return sfqy;
	}
	public void setSfqy(Integer sfqy) {
		this.sfqy = sfqy;
	}

	public String getZtlxMc() {
		return ztlxMc;
	}
	public void setZtlxMc(String ztlxMc) {
		this.ztlxMc = ztlxMc;
	}

    
}