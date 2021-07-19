package com.buit.commons.model;

import com.buit.commons.PageQuery;

/**
 * 类名称：WlKfdz<br> 
 * 类描述：
 * @author 老花生 
 * @ApiModel(value="")
 */
public class WlKfdz  extends  PageQuery{
	//@ApiModelProperty(value="kfxh")
    /** kfxh */
    private Integer kfxh;
	//@ApiModelProperty(value="ksdm")
    /** ksdm */
    private Integer ksdm;

    /** 设置:kfxh  */
    public void setKfxh(Integer value) {
        this.kfxh = value;
    }
    /** 获取:kfxh */
    public Integer getKfxh() {
        return kfxh;
    }

    /** 设置:ksdm  */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /** 获取:ksdm */
    public Integer getKsdm() {
        return ksdm;
    }


}