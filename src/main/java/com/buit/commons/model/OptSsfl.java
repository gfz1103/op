package com.buit.commons.model;


import com.buit.commons.PageQuery;

/**
 * 类名称：OptSsfl<br> 
 * 类描述：
 * @author 老花生 
 * @ApiModel(value="")
 */
public class OptSsfl  extends PageQuery {
	//@ApiModelProperty(value="主键")
    /** 主键 */
    private Integer id;
	//@ApiModelProperty(value="GY_SSDM表主键")
    /** GY_SSDM表主键 */
    private Integer ssnm;
	//@ApiModelProperty(value="手术名称")
    /** 手术名称 */
    private String ssmc;
	//@ApiModelProperty(value="手术属于哪个科室")
    /** 手术属于哪个科室 */
    private Integer ksdm;
	//@ApiModelProperty(value="手术属于哪个医生")
    /** 手术属于哪个医生 */
    private String ysdm;
    /** 查询全院 */
    private Integer isHospital;

    /** 设置:主键  */
    public void setId(Integer value) {
        this.id = value;
    }
    /** 获取:主键 */
    public Integer getId() {
        return id;
    }

    /** 设置:GY_SSDM表主键  */
    public void setSsnm(Integer value) {
        this.ssnm = value;
    }
    /** 获取:GY_SSDM表主键 */
    public Integer getSsnm() {
        return ssnm;
    }

    /** 设置:手术名称  */
    public void setSsmc(String value) {
        this.ssmc = value;
    }
    /** 获取:手术名称 */
    public String getSsmc() {
        return ssmc;
    }

    /** 设置:手术属于哪个科室  */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /** 获取:手术属于哪个科室 */
    public Integer getKsdm() {
        return ksdm;
    }

    /** 设置:手术属于哪个医生  */
    public void setYsdm(String value) {
        this.ysdm = value;
    }
    /** 获取:手术属于哪个医生 */
    public String getYsdm() {
        return ysdm;
    }


    public void setIsHospital(Integer isHospital) {
        this.isHospital = isHospital;
    }

    public Integer getIsHospital() {
        return isHospital;
    }
}
