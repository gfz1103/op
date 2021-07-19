package com.buit.commons.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName PerscriptionCopyCheckResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/1 15:46
 */
@ApiModel(value="检验处方拷贝信息-返回")
public class PerscriptionCopyCheckResp {
    @ApiModelProperty(value="一次记录")
    private BigDecimal ycjl;
    @ApiModelProperty(value="药品序号")
    private Integer ypxh;
    @ApiModelProperty(value="药品名称")
    private String ypmc;
    @ApiModelProperty(value="药房规格")
    private String yfgg;
    @ApiModelProperty(value="药品单位")
    private String ypdw;
    @ApiModelProperty(value="皮试判别")
    private Integer pspb;
    @ApiModelProperty(value="剂量单位")
    private String jldw;
    @ApiModelProperty(value="计量单位")
    private String ypjl;
    @ApiModelProperty(value="给药方法")
    private String gyff;
    @ApiModelProperty(value="药房包装")
    private Integer yfbz;
    @ApiModelProperty(value="零售价格")
    private BigDecimal lsjg;
    @ApiModelProperty(value="药品产地")
    private String ypcd;
    @ApiModelProperty(value="药品类别 | 1：西药 2：中成药 3：中草药")
    private Integer type;
    @ApiModelProperty(value="特殊药品")
    private Integer tsyp;
    @ApiModelProperty(value="药房单位")
    private String yfdw;
    @ApiModelProperty(value="药品单价")
    private BigDecimal ypdj;
    @ApiModelProperty(value="费用归并")
    private Integer fygb;
    @ApiModelProperty(value="是否抗生素")
    private String ksbz;
    @ApiModelProperty(value="抗生素等级")
    private Integer kssdj;
    @ApiModelProperty(value="越权使用方式")
    private Integer yqsyfs;
    @ApiModelProperty(value="基药类型")
    private Integer jylx;
    @ApiModelProperty(value="每日次数")
    private Integer mrcs;
    @ApiModelProperty(value="给药频次")
    private String sypc;
    @ApiModelProperty(value="给药途径")
    private Integer gytj;
    @ApiModelProperty(value="频次")
    private String ypyf;
    @ApiModelProperty(value="备注名称")
    private String bzmc;
    @ApiModelProperty(value="医嘱组号")
    private Integer ypzh;
    @ApiModelProperty(value="总量")
    private BigDecimal ypsl;
    @ApiModelProperty(value="天数")
    private Integer yyts;
    @ApiModelProperty(value="自负比例")
    private BigDecimal zfbl;
    @ApiModelProperty(value="煎法")
    private Integer jf;

    public BigDecimal getYcjl() {
        return ycjl;
    }

    public void setYcjl(BigDecimal ycjl) {
        this.ycjl = ycjl;
    }

    public Integer getYpxh() {
        return ypxh;
    }

    public void setYpxh(Integer ypxh) {
        this.ypxh = ypxh;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getYfgg() {
        return yfgg;
    }

    public void setYfgg(String yfgg) {
        this.yfgg = yfgg;
    }

    public String getYpdw() {
        return ypdw;
    }

    public void setYpdw(String ypdw) {
        this.ypdw = ypdw;
    }

    public Integer getPspb() {
        return pspb;
    }

    public void setPspb(Integer pspb) {
        this.pspb = pspb;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public String getYpjl() {
        return ypjl;
    }

    public void setYpjl(String ypjl) {
        this.ypjl = ypjl;
    }

    public String getGyff() {
        return gyff;
    }

    public void setGyff(String gyff) {
        this.gyff = gyff;
    }

    public Integer getYfbz() {
        return yfbz;
    }

    public void setYfbz(Integer yfbz) {
        this.yfbz = yfbz;
    }

    public BigDecimal getLsjg() {
        return lsjg;
    }

    public void setLsjg(BigDecimal lsjg) {
        this.lsjg = lsjg;
    }

    public String getYpcd() {
        return ypcd;
    }

    public void setYpcd(String ypcd) {
        this.ypcd = ypcd;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTsyp() {
        return tsyp;
    }

    public void setTsyp(Integer tsyp) {
        this.tsyp = tsyp;
    }

    public String getYfdw() {
        return yfdw;
    }

    public void setYfdw(String yfdw) {
        this.yfdw = yfdw;
    }

    public BigDecimal getYpdj() {
        return ypdj;
    }

    public void setYpdj(BigDecimal ypdj) {
        this.ypdj = ypdj;
    }

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

    public String getKsbz() {
        return ksbz;
    }

    public void setKsbz(String ksbz) {
        this.ksbz = ksbz;
    }

    public Integer getKssdj() {
        return kssdj;
    }

    public void setKssdj(Integer kssdj) {
        this.kssdj = kssdj;
    }

    public Integer getYqsyfs() {
        return yqsyfs;
    }

    public void setYqsyfs(Integer yqsyfs) {
        this.yqsyfs = yqsyfs;
    }

    public Integer getJylx() {
        return jylx;
    }

    public void setJylx(Integer jylx) {
        this.jylx = jylx;
    }

    public Integer getMrcs() {
        return mrcs;
    }

    public void setMrcs(Integer mrcs) {
        this.mrcs = mrcs;
    }

    public String getSypc() {
        return sypc;
    }

    public void setSypc(String sypc) {
        this.sypc = sypc;
    }

    public Integer getGytj() {
        return gytj;
    }

    public void setGytj(Integer gytj) {
        this.gytj = gytj;
    }

    public String getYpyf() {
        return ypyf;
    }

    public void setYpyf(String ypyf) {
        this.ypyf = ypyf;
    }

    public String getBzmc() {
        return bzmc;
    }

    public void setBzmc(String bzmc) {
        this.bzmc = bzmc;
    }

    public Integer getYpzh() {
        return ypzh;
    }

    public void setYpzh(Integer ypzh) {
        this.ypzh = ypzh;
    }

    public BigDecimal getYpsl() {
        return ypsl;
    }

    public void setYpsl(BigDecimal ypsl) {
        this.ypsl = ypsl;
    }

    public Integer getYyts() {
        return yyts;
    }

    public void setYyts(Integer yyts) {
        this.yyts = yyts;
    }

    public BigDecimal getZfbl() {
        return zfbl;
    }

    public void setZfbl(BigDecimal zfbl) {
        this.zfbl = zfbl;
    }

    public Integer getJf() {
        return jf;
    }

    public void setJf(Integer jf) {
        this.jf = jf;
    }
}
