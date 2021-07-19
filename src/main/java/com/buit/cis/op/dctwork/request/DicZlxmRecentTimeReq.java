
package com.buit.cis.op.dctwork.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicZlxmQueryReq<br>
 * 类描述：查询诊疗项目列表-请求<br>
 * @author 老花生
 */
@ApiModel(value="查询设备指定日期最近的号源-请求")
public class DicZlxmRecentTimeReq {
    @ApiModelProperty(value="接口类型")
    private String jklx;

    public String getJklx() {
        return jklx;
    }

    public void setJklx(String jklx) {
        this.jklx = jklx;
    }
}
