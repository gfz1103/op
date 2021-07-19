
package com.buit.ecis.pretriage.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.sql.Timestamp;


/**
 * 类名称：ErPreYjfz<br> 
 * 类描述：急诊预检分诊<br>
 * @author 朱智
 */
@ApiModel(value="急诊预检分诊-查询-请求")
public class ErPreYjfzQueryReq extends  PageQuery{

    @ApiModelProperty(value="病人评级1/2/3/4")
    private String brpj;
    @ApiModelProperty(value="姓名")
    private String xm;
    @ApiModelProperty(value="状态：1 在院/2 离院/3 取消 4/挂号")
    private String zt;
    @ApiModelProperty(value="来诊时间-开始")
    private Date lzsjStart;
    @ApiModelProperty(value="来诊时间-开始", hidden = true)
    private Timestamp lzsjStartTime;
    @ApiModelProperty(value="来诊时间-结束")
    private Date lzsjEnd;
    @ApiModelProperty(value="来诊时间-结束", hidden = true)
    private Timestamp lzsjEndTime;

    public String getBrpj() {
        return brpj;
    }

    public void setBrpj(String brpj) {
        this.brpj = brpj;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public Date getLzsjStart() {
        return lzsjStart;
    }

    public void setLzsjStart(Date lzsjStart) {
        this.lzsjStart = lzsjStart;
    }

    public Date getLzsjEnd() {
        return lzsjEnd;
    }

    public void setLzsjEnd(Date lzsjEnd) {
        this.lzsjEnd = lzsjEnd;
    }

    public Timestamp getLzsjStartTime() {
        return lzsjStartTime;
    }

    public void setLzsjStartTime(Timestamp lzsjStartTime) {
        this.lzsjStartTime = lzsjStartTime;
    }

    public Timestamp getLzsjEndTime() {
        return lzsjEndTime;
    }

    public void setLzsjEndTime(Timestamp lzsjEndTime) {
        this.lzsjEndTime = lzsjEndTime;
    }
}