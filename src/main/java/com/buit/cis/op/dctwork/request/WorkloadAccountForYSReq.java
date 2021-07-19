package com.buit.cis.op.dctwork.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;


@ApiModel("医生工作量统计入参")
public class WorkloadAccountForYSReq extends PageQuery {
    @ApiModelProperty(value = "机构ID", hidden = true)
    private Integer jgid;

    @ApiModelProperty("关键字")
    private String keyword;

    @ApiModelProperty("科室代码")
    private Integer ksdm;

    @ApiModelProperty("查询开始时间")
    private String kssj;

    @ApiModelProperty("查询结束时间")
    private String jssj;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public String getKssj() {
        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    public String getJssj() {
        return jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj;
    }
}
