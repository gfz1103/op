package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @ClassName YjLoadPersonalSetResp
 * @Description 医技根据组套载入组套明细信息-返回
 * @Author 老花生
 * @Date 2020/7/24 15:13
 */
@ApiModel(value="医技根据组套载入组套明细信息-返回")
public class YjLoadPersonalSetResp {
    @ApiModelProperty(value="门诊使用")
    private Integer mzsy;
    @ApiModelProperty(value="药品组号")
    private Integer ypzh;
    @ApiModelProperty(value="记录编号")
    private Integer jlbh;
    @ApiModelProperty(value="限制使用")
    private Integer xzsy;
    @ApiModelProperty(value="费用归并")
    private Integer fygb;
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @ApiModelProperty(value="费用单位")
    private String FYDW;
    @ApiModelProperty(value="项目数量")
    private Integer xmsl;
    @ApiModelProperty(value="费用科室")
    private Integer FYKS;
    @ApiModelProperty(value="限制周期")
    private Integer XZTS;
    @ApiModelProperty(value="服药序号")
    private Integer fyxh;
    @ApiModelProperty(value="限制次数")
    private Integer XZCS;
    @ApiModelProperty(value="费用单价")
    private BigDecimal fydj;
    @ApiModelProperty(value="项目名称")
    private String xmmc;
    @ApiModelProperty(value="医保编码")
    private String ybbm;
    @ApiModelProperty(value="自负判别")
    private Integer zfpb;
    @ApiModelProperty(value="项目类型")
    private Integer xmlx;
    @ApiModelProperty(value="错误消息")
    private String errorMsg;
    @ApiModelProperty(value="自付比例")
    private String zfbl;
    @ApiModelProperty(value="打折比例")
    private String dzbl;

    public Integer getMzsy() {
        return mzsy;
    }

    public void setMzsy(Integer mzsy) {
        this.mzsy = mzsy;
    }

    public Integer getYpzh() {
        return ypzh;
    }

    public void setYpzh(Integer ypzh) {
        this.ypzh = ypzh;
    }

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
    }

    public Integer getXzsy() {
        return xzsy;
    }

    public void setXzsy(Integer xzsy) {
        this.xzsy = xzsy;
    }

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
    }

    public String getFYDW() {
        return FYDW;
    }

    public void setFYDW(String FYDW) {
        this.FYDW = FYDW;
    }

    public Integer getXmsl() {
        return xmsl;
    }

    public void setXmsl(Integer xmsl) {
        this.xmsl = xmsl;
    }

    public Integer getFYKS() {
        return FYKS;
    }

    public void setFYKS(Integer FYKS) {
        this.FYKS = FYKS;
    }

    public Integer getXZTS() {
        return XZTS;
    }

    public void setXZTS(Integer XZTS) {
        this.XZTS = XZTS;
    }

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }

    public Integer getXZCS() {
        return XZCS;
    }

    public void setXZCS(Integer XZCS) {
        this.XZCS = XZCS;
    }

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getYbbm() {
        return ybbm;
    }

    public void setYbbm(String ybbm) {
        this.ybbm = ybbm;
    }

    public Integer getZfpb() {
        return zfpb;
    }

    public void setZfpb(Integer zfpb) {
        this.zfpb = zfpb;
    }

    public Integer getXmlx() {
        return xmlx;
    }

    public void setXmlx(Integer xmlx) {
        this.xmlx = xmlx;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getZfbl() {
        return zfbl;
    }

    public void setZfbl(String zfbl) {
        this.zfbl = zfbl;
    }

    public String getDzbl() {
        return dzbl;
    }

    public void setDzbl(String dzbl) {
        this.dzbl = dzbl;
    }
}
