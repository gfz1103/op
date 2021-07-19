package com.buit.commons.response;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName QueryYspbResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/14 11:10
 */
@ApiModel(value="查询医生排班-返回")
public class QueryYspbResp {
    @ApiModelProperty(value="预约日期")
    private Date yyrq;
    @ApiModelProperty(value="值班类别 | 值班类别：1.上午  2.下午")
    private String zblb;

    public Date getYyrq() {
        return yyrq;
    }

    public void setYyrq(Date yyrq) {
        this.yyrq = yyrq;
    }

    public String getZblb() {
        return zblb;
    }

    public void setZblb(String zblb) {
        this.zblb = zblb;
    }
}
