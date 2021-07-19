package com.buit.commons.model;


import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpZt01<br> 
 * 类描述：门诊_门诊医生组套 | 个人:YGDM值
科室:KSDM值
公用:NULL值
 * @author 老花生
 * @ApiModel(value="门诊_门诊医生组套 | 个人:YGDM值
科室:KSDM值
公用:NULL值")
 */
public class OpZt01  extends PageQuery {
	@ApiModelProperty(value="组套编号")
    /** 组套编号 */
    private Integer ztbh;
	@ApiModelProperty(value="组套名称")
    /** 组套名称 */
    private String ztmc;
	@ApiModelProperty(value="组套类别 | 1.西药 2.中药 3.草药 4.项目")
    /** 组套类别 | 1.西药 2.中药 3.草药 4.项目 */
    private Integer ztlb;
	@ApiModelProperty(value="所属类别 | 1.个人组套 2.科室组套 3.公用组套 4.个人常用药 5.科室常用 6.全院常用")
    /** 所属类别 | 1.个人组套 2.科室组套 3.公用组套 4.个人常用药 5.科室常用 6.全院常用 */
    private Integer sslb;
	@ApiModelProperty(value="员工代码")
    /** 员工代码 */
    private Integer ygdm;
	@ApiModelProperty(value="关联疾病")
    /** 关联疾病 */
    private Integer gljb;
	@ApiModelProperty(value="拼音码")
    /** 拼音码 */
    private String pydm;
	@ApiModelProperty(value="项目选取")
    /** 项目选取 */
    private Integer xmxq;
	@ApiModelProperty(value="是否启用")
    /** 是否启用 */
    private Integer sfqy;
	@ApiModelProperty(value="机构代码")
    /** 机构代码 */
    private Integer jgid;
	@ApiModelProperty(value="科室代码")
    /** 科室代码 */
    private String ksdm;
	@ApiModelProperty(value="排列顺序")
    /** 排列顺序 */
    private Integer plsx;
	@ApiModelProperty(value="组套类型(关联LIS_JYZTLX表主键ID)")
    /** 组套类型(关联LIS_JYZTLX表主键ID) */
    private Integer ztlx;
    @ApiModelProperty(value="就诊流水号")
    /** 就诊流水号 */
    private String jzlsh;

    /** 设置:组套编号  */
    public void setZtbh(Integer value) {
        this.ztbh = value;
    }
    /** 获取:组套编号 */
    public Integer getZtbh() {
        return ztbh;
    }

    /** 设置:组套名称  */
    public void setZtmc(String value) {
        this.ztmc = value;
    }
    /** 获取:组套名称 */
    public String getZtmc() {
        return ztmc;
    }

    /** 设置:组套类别 | 1.西药 2.中药 3.草药 4.项目  */
    public void setZtlb(Integer value) {
        this.ztlb = value;
    }
    /** 获取:组套类别 | 1.西药 2.中药 3.草药 4.项目 */
    public Integer getZtlb() {
        return ztlb;
    }

    /** 设置:所属类别 | 1.个人组套 2.科室组套 3.公用组套 4.个人常用药 5.科室常用 6.全院常用  */
    public void setSslb(Integer value) {
        this.sslb = value;
    }
    /** 获取:所属类别 | 1.个人组套 2.科室组套 3.公用组套 4.个人常用药 5.科室常用 6.全院常用 */
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

    /** 设置:关联疾病  */
    public void setGljb(Integer value) {
        this.gljb = value;
    }
    /** 获取:关联疾病 */
    public Integer getGljb() {
        return gljb;
    }

    /** 设置:拼音码  */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /** 获取:拼音码 */
    public String getPydm() {
        return pydm;
    }

    /** 设置:项目选取  */
    public void setXmxq(Integer value) {
        this.xmxq = value;
    }
    /** 获取:项目选取 */
    public Integer getXmxq() {
        return xmxq;
    }

    /** 设置:是否启用  */
    public void setSfqy(Integer value) {
        this.sfqy = value;
    }
    /** 获取:是否启用 */
    public Integer getSfqy() {
        return sfqy;
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
    public void setKsdm(String value) {
        this.ksdm = value;
    }
    /** 获取:科室代码 */
    public String getKsdm() {
        return ksdm;
    }

    /** 设置:排列顺序  */
    public void setPlsx(Integer value) {
        this.plsx = value;
    }
    /** 获取:排列顺序 */
    public Integer getPlsx() {
        return plsx;
    }

    /** 设置:组套类型(关联LIS_JYZTLX表主键ID)  */
    public void setZtlx(Integer value) {
        this.ztlx = value;
    }
    /** 获取:组套类型(关联LIS_JYZTLX表主键ID) */
    public Integer getZtlx() {
        return ztlx;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }
}
