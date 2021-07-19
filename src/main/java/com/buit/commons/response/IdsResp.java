package com.buit.commons.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：IdsResp<br>
 * 类描述：ids模板<br>
 * @author 老花生
 */
public class IdsResp {
    @ApiModelProperty(value="就诊序号")
    private String jzhm;
    @ApiModelProperty(value="挂号序号")
    private Integer ghxh;
    @ApiModelProperty(value="启用公卫系统")
    private String qygwxt;

    public String getJzhm() {
        return jzhm;
    }

    public void setJzhm(String jzhm) {
        this.jzhm = jzhm;
    }

    public Integer getGhxh() {
        return ghxh;
    }

    public void setGhxh(Integer ghxh) {
        this.ghxh = ghxh;
    }

    public String getQygwxt() {
        return qygwxt;
    }

    public void setQygwxt(String qygwxt) {
        this.qygwxt = qygwxt;
    }
}
