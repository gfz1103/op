package com.buit.commons.request;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckInventoryReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/8/31 10:41
 */
@ApiModel(value="查询预约科室医生-请求")
public class QueryYyksYsInfoReq {
    @NotNull(message = "挂号科室 不能为空")
    @ApiModelProperty(value="挂号科室")
    private Integer ksdm;
    @NotNull(message = "工作日期 不能为空")
    @ApiModelProperty(value="工作日期")
    private Date gzrq;
    @NotNull(message = "值班类别 不能为空")
    @ApiModelProperty(value="值班类别")
    private String zblb;

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Date getGzrq() {
        return gzrq;
    }

    public void setGzrq(Date gzrq) {
        this.gzrq = gzrq;
    }

    public String getZblb() {
        return zblb;
    }

    public void setZblb(String zblb) {
        this.zblb = zblb;
    }
}
