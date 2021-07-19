
package com.buit.ecis.pretriage.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * 类名称：ErPreZsjl<br>
 * 类描述：主诉记录<br>
 * @author 朱智
 */
@ApiModel(value="主诉记录-新增-请求")
public class ErPreZsjlEditReq extends  PageQuery{
    @NotNull(message = "主诉描述ID 不能为空")
    @ApiModelProperty(value="主诉描述ID")
    private Integer zsmsid;
    @ApiModelProperty(value="医疗机构代码", hidden = true)
    private Integer jgid;
    @NotBlank(message = "主诉描述 不能为空")
    @ApiModelProperty(value="主诉描述")
    private String zsms;
    @NotBlank(message = "病情分级 不能为空")
    @ApiModelProperty(value="病情分级")
    private String bqfj;
    @ApiModelProperty(value="拼音码")
    private String pym;
    @ApiModelProperty(value="五笔码")
    private String wbm;
    @NotNull(message = "主诉类别ID 不能为空")
    @ApiModelProperty(value="主诉类别ID")
    private Integer zslbid;
    /**
     * 设置:主诉描述ID
     */
    public void setZsmsid(Integer value) {
        this.zsmsid = value;
    }
    /**
     * 获取:主诉描述ID
     */
    public Integer getZsmsid() {
        return zsmsid;
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
     * 设置:主诉描述
     */
    public void setZsms(String value) {
        this.zsms = value;
    }
    /**
     * 获取:主诉描述
     */
    public String getZsms() {
        return zsms;
    }
    /**
     * 设置:病情分级
     */
    public void setBqfj(String value) {
        this.bqfj = value;
    }
    /**
     * 获取:病情分级
     */
    public String getBqfj() {
        return bqfj;
    }
    /**
     * 设置:拼音码
     */
    public void setPym(String value) {
        this.pym = value;
    }
    /**
     * 获取:拼音码
     */
    public String getPym() {
        return pym;
    }
    /**
     * 设置:五笔码
     */
    public void setWbm(String value) {
        this.wbm = value;
    }
    /**
     * 获取:五笔码
     */
    public String getWbm() {
        return wbm;
    }
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
}