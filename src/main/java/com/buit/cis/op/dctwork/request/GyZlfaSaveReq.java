
package com.buit.cis.op.dctwork.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：GyZlfa<br>
 * 类描述：公用_诊疗方案<br>
 * @author 老花生
 */
@ApiModel(value="诊疗方案-保存")
public class GyZlfaSaveReq extends PageQuery {
    @ApiModelProperty(value="序号")
    private Integer zlxh;
    @ApiModelProperty(value="常用诊断序号")
    private Integer jbxh;
    @ApiModelProperty(value="处方组套序号")
    private Integer cfztbh;
    @ApiModelProperty(value="项目组套序号")
    private Integer xmztbh;
    @ApiModelProperty(value="病例模版序号")
    private Integer blmbbh;


    @ApiModelProperty(value="项目名称", hidden = true)
    private String zlmc;
    @ApiModelProperty(value="拼音码", hidden = true)
    private String pydm;
    @ApiModelProperty(value="启用标志", hidden = true)
    private Integer qybz;
    @ApiModelProperty(value="所属类别", hidden = true)
    private Integer sslb;
    @ApiModelProperty(value="员工代码", hidden = true)
    private Integer ygdm;
    @ApiModelProperty(value="科室代码", hidden = true)
    private Integer ksdm;
    @ApiModelProperty(value="机构代码", hidden = true)
    private Integer jgid;
    /**
     * 设置:序号
     */
    public void setZlxh(Integer value) {
        this.zlxh = value;
    }
    /**
     * 获取:序号
     */
    public Integer getZlxh() {
        return zlxh;
    }
    /**
     * 设置:项目名称
     */
    public void setZlmc(String value) {
        this.zlmc = value;
    }
    /**
     * 获取:项目名称
     */
    public String getZlmc() {
        return zlmc;
    }
    /**
     * 设置:拼音码
     */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /**
     * 获取:拼音码
     */
    public String getPydm() {
        return pydm;
    }
    /**
     * 设置:启用标志
     */
    public void setQybz(Integer value) {
        this.qybz = value;
    }
    /**
     * 获取:启用标志
     */
    public Integer getQybz() {
        return qybz;
    }
    /**
     * 设置:所属类别
     */
    public void setSslb(Integer value) {
        this.sslb = value;
    }
    /**
     * 获取:所属类别
     */
    public Integer getSslb() {
        return sslb;
    }
    /**
     * 设置:员工代码
     */
    public void setYgdm(Integer value) {
        this.ygdm = value;
    }
    /**
     * 获取:员工代码
     */
    public Integer getYgdm() {
        return ygdm;
    }
    /**
     * 设置:病例模版序号
     */
    public void setBlmbbh(Integer value) {
        this.blmbbh = value;
    }
    /**
     * 获取:病例模版序号
     */
    public Integer getBlmbbh() {
        return blmbbh;
    }
    /**
     * 设置:处方组套序号
     */
    public void setCfztbh(Integer value) {
        this.cfztbh = value;
    }
    /**
     * 获取:处方组套序号
     */
    public Integer getCfztbh() {
        return cfztbh;
    }
    /**
     * 设置:项目组套序号
     */
    public void setXmztbh(Integer value) {
        this.xmztbh = value;
    }
    /**
     * 获取:项目组套序号
     */
    public Integer getXmztbh() {
        return xmztbh;
    }
    /**
     * 设置:疾病序号 | 由于增加中医诊断，此处需要存常用诊断表主键
     */
    public void setJbxh(Integer value) {
        this.jbxh = value;
    }
    /**
     * 获取:疾病序号 | 由于增加中医诊断，此处需要存常用诊断表主键
     */
    public Integer getJbxh() {
        return jbxh;
    }
    /**
     * 设置:科室代码
     */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /**
     * 获取:科室代码
     */
    public Integer getKsdm() {
        return ksdm;
    }
    /**
     * 设置:机构代码
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:机构代码
     */
    public Integer getJgid() {
        return jgid;
    }
}