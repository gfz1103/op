package com.buit.commons.model;


import com.buit.commons.PageQuery;

/**
 * 类名称：GyZlfa<br> 
 * 类描述：公用_诊疗方案
 * @author 老花生 
 * @ApiModel(value="公用_诊疗方案")
 */
public class GyZlfa  extends PageQuery {
	//@ApiModelProperty(value="序号")
    /** 序号 */
    private Integer zlxh;
	//@ApiModelProperty(value="项目名称")
    /** 项目名称 */
    private String zlmc;
	//@ApiModelProperty(value="拼音码")
    /** 拼音码 */
    private String pydm;
	//@ApiModelProperty(value="启用标志")
    /** 启用标志 */
    private Integer qybz;
	//@ApiModelProperty(value="所属类别")
    /** 所属类别 */
    private Integer sslb;
	//@ApiModelProperty(value="员工代码")
    /** 员工代码 */
    private Integer ygdm;
	//@ApiModelProperty(value="病例模版序号")
    /** 病例模版序号 */
    private Integer blmbbh;
	//@ApiModelProperty(value="处方组套序号")
    /** 处方组套序号 */
    private Integer cfztbh;
	//@ApiModelProperty(value="项目组套序号")
    /** 项目组套序号 */
    private Integer xmztbh;
	//@ApiModelProperty(value="疾病序号 | 由于增加中医诊断，此处需要存常用诊断表主键")
    /** 疾病序号 | 由于增加中医诊断，此处需要存常用诊断表主键 */
    private Integer jbxh;
	//@ApiModelProperty(value="科室代码")
    /** 科室代码 */
    private Integer ksdm;
	//@ApiModelProperty(value="机构代码")
    /** 机构代码 */
    private Integer jgid;

    /** 设置:序号  */
    public void setZlxh(Integer value) {
        this.zlxh = value;
    }
    /** 获取:序号 */
    public Integer getZlxh() {
        return zlxh;
    }

    /** 设置:项目名称  */
    public void setZlmc(String value) {
        this.zlmc = value;
    }
    /** 获取:项目名称 */
    public String getZlmc() {
        return zlmc;
    }

    /** 设置:拼音码  */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /** 获取:拼音码 */
    public String getPydm() {
        return pydm;
    }

    /** 设置:启用标志  */
    public void setQybz(Integer value) {
        this.qybz = value;
    }
    /** 获取:启用标志 */
    public Integer getQybz() {
        return qybz;
    }

    /** 设置:所属类别  */
    public void setSslb(Integer value) {
        this.sslb = value;
    }
    /** 获取:所属类别 */
    public Integer getSslb() {
        return sslb;
    }

    /** 设置:员工代码  */
    public void setYgdm(Integer value) {
        this.ygdm = value;
    }
    /** 获取:员工代码 */
    public Integer getYgdm() {
        return ygdm;
    }

    /** 设置:病例模版序号  */
    public void setBlmbbh(Integer value) {
        this.blmbbh = value;
    }
    /** 获取:病例模版序号 */
    public Integer getBlmbbh() {
        return blmbbh;
    }

    /** 设置:处方组套序号  */
    public void setCfztbh(Integer value) {
        this.cfztbh = value;
    }
    /** 获取:处方组套序号 */
    public Integer getCfztbh() {
        return cfztbh;
    }

    /** 设置:项目组套序号  */
    public void setXmztbh(Integer value) {
        this.xmztbh = value;
    }
    /** 获取:项目组套序号 */
    public Integer getXmztbh() {
        return xmztbh;
    }

    /** 设置:疾病序号 | 由于增加中医诊断，此处需要存常用诊断表主键  */
    public void setJbxh(Integer value) {
        this.jbxh = value;
    }
    /** 获取:疾病序号 | 由于增加中医诊断，此处需要存常用诊断表主键 */
    public Integer getJbxh() {
        return jbxh;
    }

    /** 设置:科室代码  */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /** 获取:科室代码 */
    public Integer getKsdm() {
        return ksdm;
    }

    /** 设置:机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构代码 */
    public Integer getJgid() {
        return jgid;
    }


}