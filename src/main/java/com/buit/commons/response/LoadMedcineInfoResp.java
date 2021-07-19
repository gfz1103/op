package com.buit.commons.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName LoadMedcineInfoResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/16 10:33
 */
@ApiModel(value="根据药品序号获取药品信息-返回")
public class LoadMedcineInfoResp {

    @ApiModelProperty(value="药品极限值")
    private Object ypjxz;
    @ApiModelProperty(value="皮试判别")
    private Integer pspb;
    @ApiModelProperty(value="药品名称")
    private String ypmc;
    @ApiModelProperty(value="抗生素等级")
    private Integer kssdj;
    @ApiModelProperty(value="是否抗生素")
    private Integer ksbz;
    @ApiModelProperty(value="药品产地")
    private Integer ypcd;
    @ApiModelProperty(value="给药方法")
    private Integer gyff;
    @ApiModelProperty(value="医保分类")
    private Integer ybfl;
    @ApiModelProperty(value="越权使用方式")
    private Integer yqsyfs;
    @ApiModelProperty(value="单价")
    private BigDecimal ypdj;
    @ApiModelProperty(value="给药方法_text")
    private String gyff_text;
    @ApiModelProperty(value="药品序号")
    private Integer ypxh;
    @ApiModelProperty(value="剂量")
    private BigDecimal ypjl;
    @ApiModelProperty(value="药品单位")
    private String ypdw;
    @ApiModelProperty(value="零售价格")
    private BigDecimal lsjg;
    @ApiModelProperty(value="药房单位")
    private String yfdw;
    @ApiModelProperty(value="药房规格")
    private String yfgg;
    @ApiModelProperty(value="药房包装")
    private Integer yfbz;
    @ApiModelProperty(value="药品产地_text")
    private String ypcd_text;
    @ApiModelProperty(value="剂量")
    private BigDecimal ycjl;
    @ApiModelProperty(value="计量单位")
    private String jldw;
    @ApiModelProperty(value="药品默认值")
    private Integer ypmrz;
    @ApiModelProperty(value="特殊药品")
    private Integer tsyp;
    @ApiModelProperty(value="分类")
    private Integer type;
    @ApiModelProperty(value="自付比例")
    private BigDecimal zfbl;

    public Object getYpjxz() {
        return ypjxz;
    }

    public void setYpjxz(Object ypjxz) {
        this.ypjxz = ypjxz;
    }

    public Integer getPspb() {
        return pspb;
    }

    public void setPspb(Integer pspb) {
        this.pspb = pspb;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public Integer getKssdj() {
        return kssdj;
    }

    public void setKssdj(Integer kssdj) {
        this.kssdj = kssdj;
    }

    public Integer getKsbz() {
        return ksbz;
    }

    public void setKsbz(Integer ksbz) {
        this.ksbz = ksbz;
    }

    public Integer getYpcd() {
        return ypcd;
    }

    public void setYpcd(Integer ypcd) {
        this.ypcd = ypcd;
    }

    public Integer getGyff() {
        return gyff;
    }

    public void setGyff(Integer gyff) {
        this.gyff = gyff;
    }

    public Integer getYbfl() {
        return ybfl;
    }

    public void setYbfl(Integer ybfl) {
        this.ybfl = ybfl;
    }

    public Integer getYqsyfs() {
        return yqsyfs;
    }

    public void setYqsyfs(Integer yqsyfs) {
        this.yqsyfs = yqsyfs;
    }

    public BigDecimal getYpdj() {
        return ypdj;
    }

    public void setYpdj(BigDecimal ypdj) {
        this.ypdj = ypdj;
    }

    public String getGyff_text() {
        return gyff_text;
    }

    public void setGyff_text(String gyff_text) {
        this.gyff_text = gyff_text;
    }

    public Integer getYpxh() {
        return ypxh;
    }

    public void setYpxh(Integer ypxh) {
        this.ypxh = ypxh;
    }

    public BigDecimal getYpjl() {
        return ypjl;
    }

    public void setYpjl(BigDecimal ypjl) {
        this.ypjl = ypjl;
    }

    public String getYpdw() {
        return ypdw;
    }

    public void setYpdw(String ypdw) {
        this.ypdw = ypdw;
    }

    public BigDecimal getLsjg() {
        return lsjg;
    }

    public void setLsjg(BigDecimal lsjg) {
        this.lsjg = lsjg;
    }

    public String getYfdw() {
        return yfdw;
    }

    public void setYfdw(String yfdw) {
        this.yfdw = yfdw;
    }

    public String getYfgg() {
        return yfgg;
    }

    public void setYfgg(String yfgg) {
        this.yfgg = yfgg;
    }

    public Integer getYfbz() {
        return yfbz;
    }

    public void setYfbz(Integer yfbz) {
        this.yfbz = yfbz;
    }

    public String getYpcd_text() {
        return ypcd_text;
    }

    public void setYpcd_text(String ypcd_text) {
        this.ypcd_text = ypcd_text;
    }

    public BigDecimal getYcjl() {
        return ycjl;
    }

    public void setYcjl(BigDecimal ycjl) {
        this.ycjl = ycjl;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public Integer getYpmrz() {
        return ypmrz;
    }

    public void setYpmrz(Integer ypmrz) {
        this.ypmrz = ypmrz;
    }

    public Integer getTsyp() {
        return tsyp;
    }

    public void setTsyp(Integer tsyp) {
        this.tsyp = tsyp;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getZfbl() {
        return zfbl;
    }

    public void setZfbl(BigDecimal zfbl) {
        this.zfbl = zfbl;
    }
}
