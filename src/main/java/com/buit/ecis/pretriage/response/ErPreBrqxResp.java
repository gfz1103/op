
package com.buit.ecis.pretriage.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：ErPreBrqx<br>
 * 类描述：病人去向<br>
 * @author 朱智
 */
@ApiModel(value="病人去向-返回")
public class ErPreBrqxResp  extends  PageQuery{
    @ApiModelProperty(value="去向ID")
    private Integer qxid;
    @ApiModelProperty(value="机构ID")
    private Integer jgid;
    @ApiModelProperty(value="去向")
    private String qx;
    @ApiModelProperty(value="排序号")
    private Integer pxh;
    @ApiModelProperty(value="状态:0 停用/1 启用")
    private String zt;
    /**
     * 设置:去向ID
     */
    public void setQxid(Integer value) {
        this.qxid = value;
    }
    /**
     * 获取:去向ID
     */
    public Integer getQxid() {
        return qxid;
    }
    /**
     * 设置:机构ID
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:机构ID
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:去向
     */
    public void setQx(String value) {
        this.qx = value;
    }
    /**
     * 获取:去向
     */
    public String getQx() {
        return qx;
    }
    /**
     * 设置:排序号
     */
    public void setPxh(Integer value) {
        this.pxh = value;
    }
    /**
     * 获取:排序号
     */
    public Integer getPxh() {
        return pxh;
    }
    /**
     * 设置:状态:0 停用/1 启用
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:状态:0 停用/1 启用
     */
    public String getZt() {
        return zt;
    }
}