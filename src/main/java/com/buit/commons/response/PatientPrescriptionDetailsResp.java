
package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：PatientPrescriptionDetailsResp<br>
 * 类描述：患者处方明细查询返回<br>
 * @author "MLeo"
 */
@ApiModel(value="患者处方明细查询返回")
public class PatientPrescriptionDetailsResp {
    @ApiModelProperty(value="用药标识  | 1.高血压、2.糖尿病、3.精神病、4.胰岛素")
    private Integer yybs;
    @ApiModelProperty(value="过敏药物类别  | 1.青霉素、2.磺胺、3.链霉素")
    private Integer gmywlb;
    @ApiModelProperty(value="发票号码 | 该处方所属的发票")
    private String fphm;
    @ApiModelProperty(value="基药类型 1.非基本药物,2国家基本药物,3.省基本药物,4.区自选")
    private Integer jylx;
    @ApiModelProperty(value="识别序号 | 唯一标示一次挂号的序号", hidden = true)
    private Integer sbxh;
    @ApiModelProperty(value="药品序号 | 本代码为内部代码，用户不可见")
    private Integer ypxh;
    @ApiModelProperty("处方识别")
    private Integer cfsb;
    @ApiModelProperty(value="药品组号")
    private Integer ypzh;
    @ApiModelProperty(value="药品名称")
    private String ypmc;
    @ApiModelProperty(value="同-药品名称")
    private String fymc;
    @ApiModelProperty(value="药房规格")
    private String yfgg;
    @ApiModelProperty(value="药房包装")
    private Integer yfbz;
    @ApiModelProperty("处方贴数")
    private Integer cfts;
    @ApiModelProperty(value="几倍 用于计算一次剂量")
    private String jb;
    @ApiModelProperty(value="一次剂量")
    private BigDecimal ycjl;
    @ApiModelProperty(value="剂量单位")
    private String jldw;
    @ApiModelProperty(value="药品剂量")
    private BigDecimal ypjl;
    @ApiModelProperty(value="ys一次计量")
    private String ysycjl;
    @ApiModelProperty(value="药品用法")
    private String ypyf;
    @ApiModelProperty(value="每日次数")
    private Integer mrcs;
    @ApiModelProperty(value="用药天数")
    private Integer yyts;
    @ApiModelProperty(value="ypsl")
    private Integer ypsl;
    @ApiModelProperty(value="药房单位")
    private String yfdw;
    @ApiModelProperty(value="给药途径")
    private Integer gytj;
    @ApiModelProperty(value="煎法")
    private Integer ypzs;
    @ApiModelProperty(value="药品产地")
    private Integer ypcd;
    @ApiModelProperty(value="发药单价")
    private BigDecimal ypdj;
    @ApiModelProperty(value = "自负比例")
    private BigDecimal zfbl;
    @ApiModelProperty(value="备注信息")
    private String bzxx;
    @ApiModelProperty(value = "合计金额")
    private BigDecimal hjje;
    @ApiModelProperty(value="皮试判别 | 皮试药品需要做皮试 0：非皮试类药品 1：皮试药品")
    private Integer pspb;
    @ApiModelProperty("皮试结果")
    private String psjg;
    @ApiModelProperty(value="费用归并")
    private Integer fygb;
    @ApiModelProperty(value="抗生素标志")
    private Integer ksbz;
    @ApiModelProperty(value="一次用量")
    private BigDecimal ycyl;
    @ApiModelProperty(value="药品类别 | 1：西药、2：中成药、3：中草药")
    private Integer type;
    @ApiModelProperty(value="特殊药品 | 对应GY_DMZD（DMSB=16）对应 1——麻醉、2——精神、3——贵重")
    private Integer tsyp;
    @ApiModelProperty(value="备注名称(自备药)")
    private String bzmc;
    @ApiModelProperty(value="审方结果 | 0：未审核 1：审核通过 2：审核未通过")
    private Integer sfjg;
    @ApiModelProperty(value="自负判别")
    private Integer zfpb;
    @ApiModelProperty(value="科室打印")
    private Integer kpdy;
    @ApiModelProperty(value="抗菌药物使用原因")
    private String syyy;
    @ApiModelProperty(value="抗菌药物越权使用，1表示是，0表示否")
    private Integer yqsy;
    @ApiModelProperty(value="抗菌药物授权医生")
    private String sqys;
    @ApiModelProperty(value="自备药标识")
    private Integer zfyp;
    @ApiModelProperty(value="自备药")
    private Integer zby;
    @ApiModelProperty(value="煎法 冲服 2,另包 3,后下 4,先煎 5,另烊 6,另煎 7,包煎 8,代煎 9")
    private Integer jf;
    @ApiModelProperty(value="药品默认值")
    private Integer ypmrz;
    @ApiModelProperty(value="药品极限值")
    private Integer ypjxz;
    @ApiModelProperty(value="药品档次 | 1.国产 2.合资 3.进口")
    private Integer ypdc;
    @ApiModelProperty(value="限定支付及备注")
    private String xdzfjbz;
    @ApiModelProperty(value="药品极限值天数")
    private Integer dcypjxzts;
    @ApiModelProperty(value="药品极限值总数")
    private Integer dcypjxzzs;

    public String getJb() {
        return jb;
    }

    public void setJb(String jb) {
        this.jb = jb;
    }

    public Integer getYybs() {
        return yybs;
    }

    public void setYybs(Integer yybs) {
        this.yybs = yybs;
    }

    public Integer getGmywlb() {
        return gmywlb;
    }

    public void setGmywlb(Integer gmywlb) {
        this.gmywlb = gmywlb;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public Integer getJylx() {
        return jylx;
    }

    public void setJylx(Integer jylx) {
        this.jylx = jylx;
    }

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public Integer getYpxh() {
        return ypxh;
    }

    public void setYpxh(Integer ypxh) {
        this.ypxh = ypxh;
    }

    public Integer getCfsb() {
        return cfsb;
    }

    public void setCfsb(Integer cfsb) {
        this.cfsb = cfsb;
    }

    public Integer getYpzh() {
        return ypzh;
    }

    public void setYpzh(Integer ypzh) {
        this.ypzh = ypzh;
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

    public Integer getYfbz() {
        return yfbz;
    }

    public void setYfbz(Integer yfbz) {
        this.yfbz = yfbz;
    }

    public Integer getCfts() {
        return cfts;
    }

    public void setCfts(Integer cfts) {
        this.cfts = cfts;
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

    public BigDecimal getYpjl() {
        return ypjl;
    }

    public void setYpjl(BigDecimal ypjl) {
        this.ypjl = ypjl;
    }

    public String getYsycjl() {
        return ysycjl;
    }

    public void setYsycjl(String ysycjl) {
        this.ysycjl = ysycjl;
    }

    public String getYpyf() {
        return ypyf;
    }

    public void setYpyf(String ypyf) {
        this.ypyf = ypyf;
    }

    public Integer getMrcs() {
        return mrcs;
    }

    public void setMrcs(Integer mrcs) {
        this.mrcs = mrcs;
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

    public String getYfdw() {
        return yfdw;
    }

    public void setYfdw(String yfdw) {
        this.yfdw = yfdw;
    }

    public Integer getGytj() {
        return gytj;
    }

    public void setGytj(Integer gytj) {
        this.gytj = gytj;
    }

    public Integer getYpzs() {
        return ypzs;
    }

    public void setYpzs(Integer ypzs) {
        this.ypzs = ypzs;
    }

    public Integer getYpcd() {
        return ypcd;
    }

    public void setYpcd(Integer ypcd) {
        this.ypcd = ypcd;
    }

    public BigDecimal getYpdj() {
        return ypdj;
    }

    public void setYpdj(BigDecimal ypdj) {
        this.ypdj = ypdj;
    }

    public BigDecimal getZfbl() {
        return zfbl;
    }

    public void setZfbl(BigDecimal zfbl) {
        this.zfbl = zfbl;
    }

    public String getBzxx() {
        return bzxx;
    }

    public void setBzxx(String bzxx) {
        this.bzxx = bzxx;
    }

    public BigDecimal getHjje() {
        return hjje;
    }

    public void setHjje(BigDecimal hjje) {
        this.hjje = hjje;
    }

    public Integer getPspb() {
        return pspb;
    }

    public void setPspb(Integer pspb) {
        this.pspb = pspb;
    }

    public String getPsjg() {
        return psjg;
    }

    public void setPsjg(String psjg) {
        this.psjg = psjg;
    }

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

    public Integer getKsbz() {
        return ksbz;
    }

    public void setKsbz(Integer ksbz) {
        this.ksbz = ksbz;
    }

    public BigDecimal getYcyl() {
        return ycyl;
    }

    public void setYcyl(BigDecimal ycyl) {
        this.ycyl = ycyl;
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

    public String getBzmc() {
        return bzmc;
    }

    public void setBzmc(String bzmc) {
        this.bzmc = bzmc;
    }

    public Integer getSfjg() {
        return sfjg;
    }

    public void setSfjg(Integer sfjg) {
        this.sfjg = sfjg;
    }

    public Integer getZfpb() {
        return zfpb;
    }

    public void setZfpb(Integer zfpb) {
        this.zfpb = zfpb;
    }

    public Integer getKpdy() {
        return kpdy;
    }

    public void setKpdy(Integer kpdy) {
        this.kpdy = kpdy;
    }

    public String getSyyy() {
        return syyy;
    }

    public void setSyyy(String syyy) {
        this.syyy = syyy;
    }

    public Integer getYqsy() {
        return yqsy;
    }

    public void setYqsy(Integer yqsy) {
        this.yqsy = yqsy;
    }

    public String getSqys() {
        return sqys;
    }

    public void setSqys(String sqys) {
        this.sqys = sqys;
    }

    public Integer getZfyp() {
        return zfyp;
    }

    public void setZfyp(Integer zfyp) {
        this.zfyp = zfyp;
    }

    public Integer getZby() {
        return zby;
    }

    public void setZby(Integer zby) {
        this.zby = zby;
    }

    public Integer getJf() {
        return jf;
    }

    public void setJf(Integer jf) {
        this.jf = jf;
    }

    public Integer getYpmrz() {
        return ypmrz;
    }

    public void setYpmrz(Integer ypmrz) {
        this.ypmrz = ypmrz;
    }

    public Integer getYpjxz() {
        return ypjxz;
    }

    public void setYpjxz(Integer ypjxz) {
        this.ypjxz = ypjxz;
    }

    public Integer getYpdc() {
        return ypdc;
    }

    public void setYpdc(Integer ypdc) {
        this.ypdc = ypdc;
    }

    public String getXdzfjbz() {
        return xdzfjbz;
    }

    public void setXdzfjbz(String xdzfjbz) {
        this.xdzfjbz = xdzfjbz;
    }

    public Integer getDcypjxzts() {
        return dcypjxzts;
    }

    public void setDcypjxzts(Integer dcypjxzts) {
        this.dcypjxzts = dcypjxzts;
    }

    public Integer getDcypjxzzs() {
        return dcypjxzzs;
    }

    public void setDcypjxzzs(Integer dcypjxzzs) {
        this.dcypjxzzs = dcypjxzzs;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }
}
