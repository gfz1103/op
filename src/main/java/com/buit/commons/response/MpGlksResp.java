package com.buit.commons.response;


import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：MpGlks<br>
 * 类描述：互联网科室HIS挂号科室关联表<br>
 * @author DESKTOP-1OEG1QM
 */
@ApiModel(value="互联网科室HIS挂号科室关联表")
public class MpGlksResp{
    @ApiModelProperty(value="互联网挂号科室")
    private Integer ghks;
    @ApiModelProperty(value="互联网挂号科室名称")
    private String ghksmc;
    @ApiModelProperty(value="his挂号科室")
    private Integer glks;
    @ApiModelProperty(value="his挂号科室名称")
    private String glksmc;
    /**
     * 设置:互联网挂号科室
     */
    public void setGhks(Integer value) {
        this.ghks = value;
    }
    /**
     * 获取:互联网挂号科室
     */
    public Integer getGhks() {
        return ghks;
    }

    public String getGhksmc() {
        return ghksmc;
    }

    public void setGhksmc(String ghksmc) {
        this.ghksmc = ghksmc;
    }

    /**
     * 设置:his挂号科室
     */
    public void setGlks(Integer value) {
        this.glks = value;
    }
    /**
     * 获取:his挂号科室
     */
    public Integer getGlks() {
        return glks;
    }

    public String getGlksmc() {
        return glksmc;
    }

    public void setGlksmc(String glksmc) {
        this.glksmc = glksmc;
    }
}