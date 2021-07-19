
package com.buit.commons.request;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OptSssqPageReq<br>
 * 类描述：手术申请-分页查询请求<br>
 * @author 老花生
 */
@ApiModel(value="手术申请-分页查询请求")
public class OptSssqPageReq extends  PageQuery{
    @ApiModelProperty(value="开始时间")
    private String beginDate;
    @ApiModelProperty(value="结束时间")
    private String endDate;
    @ApiModelProperty(value="手术医师")
    private String ssys;
    @ApiModelProperty(value="病人ID")
    private Integer brid;
    @ApiModelProperty(value="住院号")
    private Integer zyh;
    @ApiModelProperty(value="病人科室(kslb)")
    private Integer brks;
    @ApiModelProperty(value="申请类型(1=门诊 2=住院3=查询住院全部4=查询门诊全部)")
    private String sqlx;
    @ApiModelProperty(value="申请医生")
    private Integer sqys;

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSsys() {
        return ssys;
    }

    public void setSsys(String ssys) {
        this.ssys = ssys;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getBrks() {
        return brks;
    }

    public void setBrks(Integer brks) {
        this.brks = brks;
    }

    public String getSqlx() {
        return sqlx;
    }

    public void setSqlx(String sqlx) {
        this.sqlx = sqlx;
    }

    public Integer getSqys() {
        return sqys;
    }

    public void setSqys(Integer sqys) {
        this.sqys = sqys;
    }
}
