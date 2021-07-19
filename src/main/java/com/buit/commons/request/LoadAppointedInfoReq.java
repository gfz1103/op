package com.buit.commons.request;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName LoadAppointedInfoReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/2 13:46
 */
@ApiModel(value="加载预约信息-请求")
public class LoadAppointedInfoReq {
    @ApiModelProperty(value="开始时间")
    private String dateFrom;
    @ApiModelProperty(value="结束时间")
    private String dateTo;
    @ApiModelProperty(value="就诊卡号")
    private String jzkh;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="身份证号码")
    private String sfz;
    @ApiModelProperty(value="值班类型")
    private String zblx;
    @ApiModelProperty(value="科室类别")
    private Integer kslb;
    @ApiModelProperty(value="预约医生")
    private String yyys;
    @ApiModelProperty(value="预约标志集合")
    private List<Integer> ghbzs;

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
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

    public Integer getKslb() {
        return kslb;
    }

    public void setKslb(Integer kslb) {
        this.kslb = kslb;
    }

    public String getYyys() {
        return yyys;
    }

    public void setYyys(String yyys) {
        this.yyys = yyys;
    }

    public List<Integer> getGhbzs() {
        return ghbzs;
    }

    public void setGhbzs(List<Integer> ghbzs) {
        this.ghbzs = ghbzs;
    }
}
