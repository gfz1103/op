
package com.buit.cis.op.dctwork.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;


/**
 * 类名称：QueryShiftDeptReq<br>
 * 类描述：查询科室排班请求<br>
 * @author 老花生
 */
@ApiModel(value="查询科室排班请求")
public class QueryShiftDeptReq {
    @ApiModelProperty(value="科室类别")
    private Integer kslb;
    @ApiModelProperty(value="值班类别")
    private String zblb;
    @ApiModelProperty(value="挂号日期")
    private Date ghrq;

    public Integer getKslb() {
        return kslb;
    }

    public void setKslb(Integer kslb) {
        this.kslb = kslb;
    }

    public String getZblb() {
        return zblb;
    }

    public void setZblb(String zblb) {
        this.zblb = zblb;
    }

    public Date getGhrq() {
        return ghrq;
    }

    public void setGhrq(Date ghrq) {
        this.ghrq = ghrq;
    }
}