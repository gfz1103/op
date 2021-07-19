package com.buit.commons.request;


import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：MpGlks<br>
 * 类描述：互联网科室HIS挂号科室关联表<br>
 * @author DESKTOP-1OEG1QM
 */
@ApiModel(value="互联网科室HIS挂号科室关联表")
public class MpGlksReq  extends  PageQuery{
    @ApiModelProperty(value="互联网挂号科室")
    private Integer ghks;
    @ApiModelProperty(value="his挂号科室")
    private Integer glks;
    @ApiModelProperty(value="机构id", hidden = true)
    private Integer jgid;
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

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }
}