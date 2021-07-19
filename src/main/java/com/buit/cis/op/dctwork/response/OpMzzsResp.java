package com.buit.cis.op.dctwork.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpMzzs<br>
 * 类描述：门诊诊室信息<br>
 * @author WY
 */
@ApiModel(value="门诊诊室信息")
public class OpMzzsResp  extends PageQuery {
    @ApiModelProperty(value = "识别序号")
    /** 识别序号 */
    private Integer sbxh;
    @ApiModelProperty(value = "挂号科室")
    /** 挂号科室 */
    private Integer ghks;
    @ApiModelProperty(value = "诊室ID")
    /** 诊室ID */
    private Integer zsid;
    @ApiModelProperty(value = "诊室名称")
    /** 诊室名称 */
    private String zsmc;
    @ApiModelProperty(value = "语音信息")
    /** 语音信息 */
    private String yyxx;
    @ApiModelProperty(value = "屏幕ID")
    /** 屏幕ID */
    private String pmid;
    @ApiModelProperty(value = "是否叫号(1是,2否) 标准：1:是 0：否")
    private String sfjh;
    @ApiModelProperty(value = "是否启用(1启用,2禁用) 标准：0:启用 1：停用")
    private String sfqy;
    @ApiModelProperty(value = "服务台ID")
    private Integer fwtid;
    @ApiModelProperty(value = "ip 逗号隔开")
    private String ip;

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public Integer getGhks() {
        return ghks;
    }

    public void setGhks(Integer ghks) {
        this.ghks = ghks;
    }

    public Integer getZsid() {
        return zsid;
    }

    public void setZsid(Integer zsid) {
        this.zsid = zsid;
    }

    public String getZsmc() {
        return zsmc;
    }

    public void setZsmc(String zsmc) {
        this.zsmc = zsmc;
    }

    public String getYyxx() {
        return yyxx;
    }

    public void setYyxx(String yyxx) {
        this.yyxx = yyxx;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public String getSfjh() {
        return sfjh;
    }

    public void setSfjh(String sfjh) {
        this.sfjh = sfjh;
    }

    public String getSfqy() {
        return sfqy;
    }

    public void setSfqy(String sfqy) {
        this.sfqy = sfqy;
    }

    public Integer getFwtid() {
        return fwtid;
    }

    public void setFwtid(Integer fwtid) {
        this.fwtid = fwtid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
