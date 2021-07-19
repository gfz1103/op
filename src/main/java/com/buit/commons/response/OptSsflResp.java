
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OptSsfl<br>
 * 类描述：<br>
 * @author 老花生
 */
@ApiModel(value="")
public class OptSsflResp  extends PageQuery {
    @ApiModelProperty(value="主键")
    private Integer id;
    @ApiModelProperty(value="GY_SSDM表主键")
    private Integer ssnm;
    @ApiModelProperty(value="手术名称")
    private String ssmc;
    @ApiModelProperty(value="手术属于哪个科室")
    private Integer ksdm;
    @ApiModelProperty(value="手术属于哪个医生")
    private String ysdm;
    @ApiModelProperty(value="费用单价")
    private BigDecimal fydj;
    @ApiModelProperty(value="费用归并")
    private Integer fygb;
    @ApiModelProperty(value="手术等级")
    private Integer ssdj;
    @ApiModelProperty(value="作废判别")
    private Integer zfpb;
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

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

    public Integer getSsdj() {
        return ssdj;
    }

    public void setSsdj(Integer ssdj) {
        this.ssdj = ssdj;
    }

    public Integer getZfpb() {
        return zfpb;
    }

    public void setZfpb(Integer zfpb) {
        this.zfpb = zfpb;
    }
}
