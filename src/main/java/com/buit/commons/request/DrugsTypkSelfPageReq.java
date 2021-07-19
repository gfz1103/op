
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


/**
 * 类名称：DrugsTypk<br>
 * 类描述：药库_药品基本库分页<br>
 * @author "MLeo"
 */
@ApiModel(value="药库_药品基本库分页")
public class DrugsTypkSelfPageReq extends PageQuery{
    @NotNull(message = "药库识别不能为空")
    @ApiModelProperty(value="药库识别",required = true)
    private Integer yksb;
    @ApiModelProperty(value="机构代码",hidden = true)
    private Integer jgid;

    @ApiModelProperty(value="本地药品编码")
    private String ypbm;
    @ApiModelProperty(value="药品类别 | 1：西药 2：中成药 3：中草药")
    private Integer type;
    @ApiModelProperty(value="拼音代码")
    private String pydm;
    @ApiModelProperty(value="五笔代码")
    private String wbdm;
    @ApiModelProperty(value="角形代码")
    private String jxdm;
    @ApiModelProperty(value="笔画代码")
    private String bhdm;
    @ApiModelProperty(value="其他码")
    private String qtdm;
    @ApiModelProperty(value="药品贮藏")
    private Integer ypzc;
    @ApiModelProperty(value="医保分类")
    private Integer ybfl;
    @ApiModelProperty(value="特殊药品-指定药品 | 对应GY_DMZD（DMSB=16）对应 1——麻醉、2——精神、3——贵重")
    private Integer tsyp;
    @ApiModelProperty(value="处方药品")
    private Integer cfyp;
    @ApiModelProperty(value="新增开始时间")
    private String xzkssj;
    @ApiModelProperty(value="新增结束时间")
    private String xzjssj;
    @ApiModelProperty(value="药品代码")
    private String ypdm;


    public Integer getYksb() {
        return yksb;
    }

    public void setYksb(Integer yksb) {
        this.yksb = yksb;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getYpbm() {
        return ypbm;
    }

    public void setYpbm(String ypbm) {
        this.ypbm = ypbm;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }

    public String getWbdm() {
        return wbdm;
    }

    public void setWbdm(String wbdm) {
        this.wbdm = wbdm;
    }

    public String getJxdm() {
        return jxdm;
    }

    public void setJxdm(String jxdm) {
        this.jxdm = jxdm;
    }

    public String getBhdm() {
        return bhdm;
    }

    public void setBhdm(String bhdm) {
        this.bhdm = bhdm;
    }

    public String getQtdm() {
        return qtdm;
    }

    public void setQtdm(String qtdm) {
        this.qtdm = qtdm;
    }

    public Integer getYpzc() {
        return ypzc;
    }

    public void setYpzc(Integer ypzc) {
        this.ypzc = ypzc;
    }

    public Integer getYbfl() {
        return ybfl;
    }

    public void setYbfl(Integer ybfl) {
        this.ybfl = ybfl;
    }

    public Integer getTsyp() {
        return tsyp;
    }

    public void setTsyp(Integer tsyp) {
        this.tsyp = tsyp;
    }

    public Integer getCfyp() {
        return cfyp;
    }

    public void setCfyp(Integer cfyp) {
        this.cfyp = cfyp;
    }

    public String getXzkssj() {
        return xzkssj;
    }

    public void setXzkssj(String xzkssj) {
        this.xzkssj = xzkssj;
    }

    public String getXzjssj() {
        return xzjssj;
    }

    public void setXzjssj(String xzjssj) {
        this.xzjssj = xzjssj;
    }

    public String getYpdm() {
        return ypdm;
    }

    public void setYpdm(String ypdm) {
        this.ypdm = ypdm;
    }
}
