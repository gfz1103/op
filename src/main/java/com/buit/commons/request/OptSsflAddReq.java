
package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OptSsfl<br>
 * 类描述：<br>
 * @author 老花生
 */
@ApiModel(value="新增手术-请求")
public class OptSsflAddReq {
    @ApiModelProperty(value="主键", hidden = true)
    private Integer id;
    @ApiModelProperty(value="GY_SSDM表主键")
    private Integer ssnm;
    @ApiModelProperty(value="手术名称")
    private String ssmc;
    @ApiModelProperty(value="手术属于哪个科室")
    private Integer ksdm;
    @ApiModelProperty(value="手术属于哪个医生", hidden = true)
    private String ysdm;
    /**
     * 设置:主键
     */
    public void setId(Integer value) {
        this.id = value;
    }
    /**
     * 获取:主键
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置:GY_SSDM表主键
     */
    public void setSsnm(Integer value) {
        this.ssnm = value;
    }
    /**
     * 获取:GY_SSDM表主键
     */
    public Integer getSsnm() {
        return ssnm;
    }
    /**
     * 设置:手术名称
     */
    public void setSsmc(String value) {
        this.ssmc = value;
    }
    /**
     * 获取:手术名称
     */
    public String getSsmc() {
        return ssmc;
    }
    /**
     * 设置:手术属于哪个科室
     */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /**
     * 获取:手术属于哪个科室
     */
    public Integer getKsdm() {
        return ksdm;
    }
    /**
     * 设置:手术属于哪个医生
     */
    public void setYsdm(String value) {
        this.ysdm = value;
    }
    /**
     * 获取:手术属于哪个医生
     */
    public String getYsdm() {
        return ysdm;
    }
}
