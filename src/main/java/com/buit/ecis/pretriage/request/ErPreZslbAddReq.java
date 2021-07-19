
package com.buit.ecis.pretriage.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


/**
 * 类名称：ErPreZslb<br>
 * 类描述：主诉类别<br>
 * @author 朱智
 */
@ApiModel(value="主诉类别-请求")
public class ErPreZslbAddReq{
    @ApiModelProperty(value="主诉类别ID", hidden = true)
    private Integer zslbid;
    @ApiModelProperty(value="医疗机构代码", hidden = true)
    private Integer jgid;
    @NotNull(message = "主诉类别 不能为空")
    @ApiModelProperty(value="主诉类别")
    private String zslb;
    @NotNull(message = "父ID 不能为空")
    @ApiModelProperty(value="父ID， 顶级传0")
    private Integer fid;
    /**
     * 设置:主诉类别ID
     */
    public void setZslbid(Integer value) {
        this.zslbid = value;
    }
    /**
     * 获取:主诉类别ID
     */
    public Integer getZslbid() {
        return zslbid;
    }
    /**
     * 设置:医疗机构代码
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:医疗机构代码
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:主诉类别
     */
    public void setZslb(String value) {
        this.zslb = value;
    }
    /**
     * 获取:主诉类别
     */
    public String getZslb() {
        return zslb;
    }
    /**
     * 设置:父ID
     */
    public void setFid(Integer value) {
        this.fid = value;
    }
    /**
     * 获取:父ID
     */
    public Integer getFid() {
        return fid;
    }
}