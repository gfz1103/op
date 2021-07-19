package com.buit.commons.model;

import com.buit.commons.PageQuery;

/**
 * 类名称：SyGytj<br> 
 * 类描述：输液/注射给药途径设置
 * @author WY 
 * @ApiModel(value="输液/注射给药途径设置")
 */
public class SyGytj  extends  PageQuery{
	//@ApiModelProperty(value="医疗机构代码")
    /** 医疗机构代码 */
    private Integer jgid;
	//@ApiModelProperty(value="输液科室代码")
    /** 输液科室代码 */
    private Integer ksdm;
	//@ApiModelProperty(value="给药途径代码")
    /** 给药途径代码 */
    private String gytjdm;
	//@ApiModelProperty(value="科室类别  1输液室/2注射室")
    /** 科室类别  1输液室/2注射室 */
    private String kslb;

    /** 设置:医疗机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:医疗机构代码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:输液科室代码  */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /** 获取:输液科室代码 */
    public Integer getKsdm() {
        return ksdm;
    }

    /** 设置:给药途径代码  */
    public void setGytjdm(String value) {
        this.gytjdm = value;
    }
    /** 获取:给药途径代码 */
    public String getGytjdm() {
        return gytjdm;
    }

    /** 设置:科室类别  1输液室/2注射室  */
    public void setKslb(String value) {
        this.kslb = value;
    }
    /** 获取:科室类别  1输液室/2注射室 */
    public String getKslb() {
        return kslb;
    }


}