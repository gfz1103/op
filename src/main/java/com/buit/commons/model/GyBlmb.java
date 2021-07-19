package com.buit.commons.model;


import com.buit.commons.PageQuery;

/**
 * 类名称：GyBlmb<br> 
 * 类描述：公用_门诊病历模板
 * @author 老花生 
 * @ApiModel(value="公用_门诊病历模板")
 */
public class GyBlmb  extends PageQuery {
	//@ApiModelProperty(value="记录序号 | 主键")
    /** 记录序号 | 主键 */
    private Integer jlxh;
	//@ApiModelProperty(value="所属类别 |  SSLB 1 个人组套 2 科室组套 3 公用组套 4 个人常用药（诊断、项目、病历）     主要为了和组套等一致")
    /** 所属类别 |  SSLB 1 个人组套 2 科室组套 3 公用组套 4 个人常用药（诊断、项目、病历）     主要为了和组套等一致 */
    private Integer sslb;
	//@ApiModelProperty(value="员工代码")
    /** 员工代码 */
    private Integer ygdm;
	//@ApiModelProperty(value="模板名称")
    /** 模板名称 */
    private String mbmc;
	//@ApiModelProperty(value="拼音码")
    /** 拼音码 */
    private String pydm;
	//@ApiModelProperty(value="主诉信息")
    /** 主诉信息 */
    private String zsxx;
	//@ApiModelProperty(value="现病史")
    /** 现病史 */
    private String xbs;
	//@ApiModelProperty(value="既往史")
    /** 既往史 */
    private String jws;
	//@ApiModelProperty(value="tgjc")
    /** tgjc */
    private String tgjc;
	//@ApiModelProperty(value="fzjc")
    /** fzjc */
    private String fzjc;
	//@ApiModelProperty(value="处理措施")
    /** 处理措施 */
    private String clcs;
	//@ApiModelProperty(value="启动标志 | 1.不启用 0.启用")
    /** 启动标志 | 1.不启用 0.启用 */
    private Integer qybz;
	//@ApiModelProperty(value="机构代码")
    /** 机构代码 */
    private Integer jgid;
	//@ApiModelProperty(value="科室代码")
    /** 科室代码 */
    private Integer ksdm;

    /** 设置:记录序号 | 主键  */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /** 获取:记录序号 | 主键 */
    public Integer getJlxh() {
        return jlxh;
    }

    /** 设置:所属类别 |  SSLB 1 个人组套 2 科室组套 3 公用组套 4 个人常用药（诊断、项目、病历）     主要为了和组套等一致  */
    public void setSslb(Integer value) {
        this.sslb = value;
    }
    /** 获取:所属类别 |  SSLB 1 个人组套 2 科室组套 3 公用组套 4 个人常用药（诊断、项目、病历）     主要为了和组套等一致 */
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

    /** 设置:模板名称  */
    public void setMbmc(String value) {
        this.mbmc = value;
    }
    /** 获取:模板名称 */
    public String getMbmc() {
        return mbmc;
    }

    /** 设置:拼音码  */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /** 获取:拼音码 */
    public String getPydm() {
        return pydm;
    }

    /** 设置:主诉信息  */
    public void setZsxx(String value) {
        this.zsxx = value;
    }
    /** 获取:主诉信息 */
    public String getZsxx() {
        return zsxx;
    }

    /** 设置:现病史  */
    public void setXbs(String value) {
        this.xbs = value;
    }
    /** 获取:现病史 */
    public String getXbs() {
        return xbs;
    }

    /** 设置:既往史  */
    public void setJws(String value) {
        this.jws = value;
    }
    /** 获取:既往史 */
    public String getJws() {
        return jws;
    }

    /** 设置:tgjc  */
    public void setTgjc(String value) {
        this.tgjc = value;
    }
    /** 获取:tgjc */
    public String getTgjc() {
        return tgjc;
    }

    /** 设置:fzjc  */
    public void setFzjc(String value) {
        this.fzjc = value;
    }
    /** 获取:fzjc */
    public String getFzjc() {
        return fzjc;
    }

    /** 设置:处理措施  */
    public void setClcs(String value) {
        this.clcs = value;
    }
    /** 获取:处理措施 */
    public String getClcs() {
        return clcs;
    }

    /** 设置:启动标志 | 1.不启用 0.启用  */
    public void setQybz(Integer value) {
        this.qybz = value;
    }
    /** 获取:启动标志 | 1.不启用 0.启用 */
    public Integer getQybz() {
        return qybz;
    }

    /** 设置:机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构代码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:科室代码  */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /** 获取:科室代码 */
    public Integer getKsdm() {
        return ksdm;
    }
}