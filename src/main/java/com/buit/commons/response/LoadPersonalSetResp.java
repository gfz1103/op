package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @ClassName LoadPersonalSetResp
 * @Description 根据组套载入组套明细信息-返回
 * @Author 老花生
 * @Date 2020/7/16 9:41
 */
@ApiModel(value="根据组套载入组套明细信息-返回")
public class LoadPersonalSetResp {
    @ApiModelProperty(value="医保分类")
    private Integer ybfl;
    @ApiModelProperty(value="药品组号")
    private Integer ypzh;
    @ApiModelProperty(value="剂量")
    private BigDecimal ycjl;
    @ApiModelProperty(value="天数")
    private Integer yyts;
    @ApiModelProperty(value="数量")
    private Integer ypsl;
    @ApiModelProperty(value="使用频率")
    private String ypyf;
    @ApiModelProperty(value="使用频率_text")
    private String ypyf_text;
    @ApiModelProperty(value="途径")
    private String gytj;
    @ApiModelProperty(value="途径_text")
    private String gytj_text;
    @ApiModelProperty(value="备注名称")
    private String bzmc;
    @ApiModelProperty(value="每日次数")
    private Integer mrcs;
    @ApiModelProperty(value="使用频次")
    private String sypc;
    @ApiModelProperty(value="使用频次_text")
    private String sypc_text;
    @ApiModelProperty(value="自付比例")
    private String zfbl;
    @ApiModelProperty(value="错误码")
    private String errorCode;
    @ApiModelProperty(value="记录编号")
    private Integer jlbh;
    @ApiModelProperty(value="计量单位")
    private String jldw;
    @ApiModelProperty(value="脚注")
    private Integer jz;
    @ApiModelProperty(value="数量")
    private Integer xmsl;
    @ApiModelProperty(value="药品规格")
    private String ypgg;
    @ApiModelProperty(value="药品名称")
    private String ypmc;
    @ApiModelProperty(value="药品序号")
    private Integer ypxh;
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @ApiModelProperty(value="皮试判别")
    private Integer pspb;
    @ApiModelProperty(value="是否抗生素")
    private Integer ksbz;
    @ApiModelProperty(value="药品产地")
    private Integer ypcd;
    @ApiModelProperty(value="费用归并")
    private Integer fygb;
    @ApiModelProperty(value="发药药房")
    private Integer yfsb;
    @ApiModelProperty(value="发药方式")
    private Integer fyfs;
    @ApiModelProperty(value="药品剂量")
    private Integer ypjl;
    @ApiModelProperty(value="药品单位")
    private String ypdw;
    @ApiModelProperty(value="是否审批")
    private String sfsp;
    @ApiModelProperty(value="基本药物标志")
    private Integer jylx;
    @ApiModelProperty(value="零售价格")
    private double lsjg;
    @ApiModelProperty(value="药房规格")
    private String yfgg;
    @ApiModelProperty(value="药房单位")
    private String yfdw;
    @ApiModelProperty(value="药房包装")
    private Integer yfbz;
    @ApiModelProperty(value="类型")
    private Integer type;
    @ApiModelProperty(value="药品极限值")
    private String ypjxz;
    @ApiModelProperty(value="抗生素等级")
    private String kssdj;
    @ApiModelProperty(value="给药方法")
    private Integer gyff;
    @ApiModelProperty(value="药品单价")
    private double ypdj;
    @ApiModelProperty(value="越权使用方式")
    private String yqsyfs;
    @ApiModelProperty(value="药品类型")
    private Integer yplx;
    @ApiModelProperty(value="药品默认值")
    private String ypmrz;
    @ApiModelProperty(value="特殊药品")
    private Integer tsyp;
    @ApiModelProperty(value="几倍")
    private String jb;

    public String getJb() {
        return jb;
    }

    public void setJb(String jb) {
        this.jb = jb;
    }

    public Integer getYbfl() {
        return ybfl;
    }

    public void setYbfl(Integer ybfl) {
        this.ybfl = ybfl;
    }

    public Integer getYpzh() {
        return ypzh;
    }

    public void setYpzh(Integer ypzh) {
        this.ypzh = ypzh;
    }

    public BigDecimal getYcjl() {
        return ycjl;
    }

    public void setYcjl(BigDecimal ycjl) {
        this.ycjl = ycjl;
    }

    public Integer getYyts() {
        return yyts;
    }

    public void setYyts(Integer yyts) {
        this.yyts = yyts;
    }

    public Integer getYpsl() {
        return ypsl;
    }

    public void setYpsl(Integer ypsl) {
        this.ypsl = ypsl;
    }

    public String getYpyf() {
        return ypyf;
    }

    public void setYpyf(String ypyf) {
        this.ypyf = ypyf;
    }

    public String getYpyf_text() {
        return ypyf_text;
    }

    public void setYpyf_text(String ypyf_text) {
        this.ypyf_text = ypyf_text;
    }

    public String getGytj() {
        return gytj;
    }

    public void setGytj(String gytj) {
        this.gytj = gytj;
    }

    public String getGytj_text() {
        return gytj_text;
    }

    public void setGytj_text(String gytj_text) {
        this.gytj_text = gytj_text;
    }

    public String getBzmc() {
        return bzmc;
    }

    public void setBzmc(String bzmc) {
        this.bzmc = bzmc;
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

    public String getSypc_text() {
        return sypc_text;
    }

    public void setSypc_text(String sypc_text) {
        this.sypc_text = sypc_text;
    }

    public String getZfbl() {
        return zfbl;
    }

    public void setZfbl(String zfbl) {
        this.zfbl = zfbl;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public Integer getJz() {
        return jz;
    }

    public void setJz(Integer jz) {
        this.jz = jz;
    }

    public Integer getXmsl() {
        return xmsl;
    }

    public void setXmsl(Integer xmsl) {
        this.xmsl = xmsl;
    }

    public String getYpgg() {
        return ypgg;
    }

    public void setYpgg(String ypgg) {
        this.ypgg = ypgg;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public Integer getYpxh() {
        return ypxh;
    }

    public void setYpxh(Integer ypxh) {
        this.ypxh = ypxh;
    }

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
    }

    public Integer getPspb() {
        return pspb;
    }

    public void setPspb(Integer pspb) {
        this.pspb = pspb;
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

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

    public Integer getYfsb() {
        return yfsb;
    }

    public void setYfsb(Integer yfsb) {
        this.yfsb = yfsb;
    }

    public Integer getFyfs() {
        return fyfs;
    }

    public void setFyfs(Integer fyfs) {
        this.fyfs = fyfs;
    }

    public Integer getYpjl() {
        return ypjl;
    }

    public void setYpjl(Integer ypjl) {
        this.ypjl = ypjl;
    }

    public String getYpdw() {
        return ypdw;
    }

    public void setYpdw(String ypdw) {
        this.ypdw = ypdw;
    }

    public String getSfsp() {
        return sfsp;
    }

    public void setSfsp(String sfsp) {
        this.sfsp = sfsp;
    }

    public Integer getJylx() {
        return jylx;
    }

    public void setJylx(Integer jylx) {
        this.jylx = jylx;
    }

    public double getLsjg() {
        return lsjg;
    }

    public void setLsjg(double lsjg) {
        this.lsjg = lsjg;
    }

    public String getYfgg() {
        return yfgg;
    }

    public void setYfgg(String yfgg) {
        this.yfgg = yfgg;
    }

    public String getYfdw() {
        return yfdw;
    }

    public void setYfdw(String yfdw) {
        this.yfdw = yfdw;
    }

    public Integer getYfbz() {
        return yfbz;
    }

    public void setYfbz(Integer yfbz) {
        this.yfbz = yfbz;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getYpjxz() {
        return ypjxz;
    }

    public void setYpjxz(String ypjxz) {
        this.ypjxz = ypjxz;
    }

    public String getKssdj() {
        return kssdj;
    }

    public void setKssdj(String kssdj) {
        this.kssdj = kssdj;
    }

    public Integer getGyff() {
        return gyff;
    }

    public void setGyff(Integer gyff) {
        this.gyff = gyff;
    }

    public double getYpdj() {
        return ypdj;
    }

    public void setYpdj(double ypdj) {
        this.ypdj = ypdj;
    }

    public String getYqsyfs() {
        return yqsyfs;
    }

    public void setYqsyfs(String yqsyfs) {
        this.yqsyfs = yqsyfs;
    }

    public Integer getYplx() {
        return yplx;
    }

    public void setYplx(Integer yplx) {
        this.yplx = yplx;
    }

    public String getYpmrz() {
        return ypmrz;
    }

    public void setYpmrz(String ypmrz) {
        this.ypmrz = ypmrz;
    }

    public Integer getTsyp() {
        return tsyp;
    }

    public void setTsyp(Integer tsyp) {
        this.tsyp = tsyp;
    }
}
