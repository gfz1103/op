package com.buit.commons.model;

import java.sql.Timestamp;
import com.buit.commons.PageQuery;

/**
 * 类名称：MpGlks<br> 
 * 类描述：互联网科室HIS挂号科室关联表
 * @author DESKTOP-1OEG1QM 
 * @ApiModel(value="互联网科室HIS挂号科室关联表")
 */
public class MpGlks  extends  PageQuery{
	//@ApiModelProperty(value="互联网挂号科室")
    /** 互联网挂号科室 */
    private Integer ghks;
	//@ApiModelProperty(value="his挂号科室")
    /** his挂号科室 */
    private Integer glks;

    /** 设置:互联网挂号科室  */
    public void setGhks(Integer value) {
        this.ghks = value;
    }
    /** 获取:互联网挂号科室 */
    public Integer getGhks() {
        return ghks;
    }

    /** 设置:his挂号科室  */
    public void setGlks(Integer value) {
        this.glks = value;
    }
    /** 获取:his挂号科室 */
    public Integer getGlks() {
        return glks;
    }


}