
package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpYyghQueryReq<br>
 * 类描述：门诊_预约挂号-查询请求<br>
 * @author WY
 */
@ApiModel(value="门诊_预约挂号-查询请求")
public class OpYyghQueryReq {
    @ApiModelProperty(value="预约时间-开始")
    private String appointedDateFrom;
    @ApiModelProperty(value="预约时间-结束")
    private String appointedDateTo;
    @ApiModelProperty(value="就诊卡号")
    private String jzkh;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="身份证号")
    private String sfz;
    @ApiModelProperty(value="值班类型")
    private String zblx;
    @ApiModelProperty(value="科室类别")
    private String kslb;
    @ApiModelProperty(value="预约医生")
    private String yyys;

    public String getAppointedDateFrom() {
        return appointedDateFrom;
    }

    public void setAppointedDateFrom(String appointedDateFrom) {
        this.appointedDateFrom = appointedDateFrom;
    }

    public String getAppointedDateTo() {
        return appointedDateTo;
    }

    public void setAppointedDateTo(String appointedDateTo) {
        this.appointedDateTo = appointedDateTo;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    public String getZblx() {
        return zblx;
    }

    public void setZblx(String zblx) {
        this.zblx = zblx;
    }

    public String getKslb() {
        return kslb;
    }

    public void setKslb(String kslb) {
        this.kslb = kslb;
    }

    public String getYyys() {
        return yyys;
    }

    public void setYyys(String yyys) {
        this.yyys = yyys;
    }
}
