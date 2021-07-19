package com.buit.commons.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 类名称：OpCf02<br>
 * 类描述：门诊_门诊处方明细表
 * @author yueyu
 * @ApiModel(value="门诊_门诊处方明细表")
 */
public class OpCf02SaveReq extends  PageQuery{
    @ApiModelProperty(value="识别序号 | 识别每条处方明细")
    private Integer sbxh;
    @ApiModelProperty(value="机构代码")
    private Integer jgid;
    @ApiModelProperty(value="处方识别")
    private Integer cfsb;
    @ApiModelProperty(value="药品序号")
    private Integer ypxh;
    @ApiModelProperty(value="药品产地")
    private Integer ypcd;
    @ApiModelProperty(value="项目类型 | 1：西药 2：成药3：草药")
    private Integer xmlx;
    @ApiModelProperty(value="处方贴数")
    private Integer cfts;
    @ApiModelProperty(value="药品数量")
    private BigDecimal ypsl;
    @ApiModelProperty(value="药品单价")
    private BigDecimal ypdj;
    @ApiModelProperty(value="划价金额")
    private BigDecimal hjje;
    @ApiModelProperty(value="草药服法")
    private Integer ypzs;
    @ApiModelProperty(value="一次数量")
    private String ycsl;
    @ApiModelProperty(value="费用归并 | 和DIC_SFXMLB的SFXM关联")
    private Integer fygb;
    @ApiModelProperty(value="自负比例")
    private BigDecimal zfbl;
    @ApiModelProperty(value="给药途径")
    private Integer gytj;
    @ApiModelProperty(value="药品用法")
    private String ypyf;
    @ApiModelProperty(value="药品组号")
    private Integer ypzh;
    @ApiModelProperty(value="药房规格")
    private String yfgg;
    @ApiModelProperty(value="药房单位")
    private String yfdw;
    @ApiModelProperty(value="药房包装")
    private Integer yfbz;
    @ApiModelProperty(value="实际用量")
    private String sjyl;
    @ApiModelProperty(value="皮试判别")
    private Integer pspb;
    @ApiModelProperty(value="用药天数")
    private Integer yyts;
    @ApiModelProperty(value="一次用量")
    private BigDecimal ycsl2;
    @ApiModelProperty(value="显示数量")
    private BigDecimal xssl;
    @ApiModelProperty(value="每日次数")
    private Integer mrcs;
    @ApiModelProperty(value="处方标志")
    private String cfbz;
    @ApiModelProperty(value="几倍 用于计算一次剂量")
    private String jb;
    @ApiModelProperty(value="一次剂量")
    private BigDecimal ycjl;
    @ApiModelProperty(value="皮试结果")
    private Integer psjg;
    @ApiModelProperty(value="排列序号")
    private Integer plxh;
    @ApiModelProperty(value="输液标志 | 1 输液调入 0 或 NULL    未调入")
    private Integer sybz;
    @ApiModelProperty(value="备注信息")
    private String bzxx;
    @ApiModelProperty(value="审方结果 | 0：未审核 1：审核通过 2：审核未通过")
    private Integer sfjg;
    @ApiModelProperty(value="审方工号")
    private String sfgh;
    @ApiModelProperty(value="审方意见")
    private String sfyj;
    @ApiModelProperty(value="备注名称(自备药)")
    private String bzmc;
    @ApiModelProperty(value="自负判别")
    private Integer zfpb;
    @ApiModelProperty(value="审批编号")
    private Integer spbh;
    @ApiModelProperty(value="抗菌药物越权使用，1表示是，0表示否")
    private Integer yqsy;
    @ApiModelProperty(value="抗菌药物授权医生")
    private String sqys;
    @ApiModelProperty(value="抗菌药物使用原因")
    private String syyy;
    @ApiModelProperty(value="自备药标识")
    private Integer zfyp;
    @ApiModelProperty(value="yhje")
    private BigDecimal yhje;
    @ApiModelProperty(value="jbyp")
    private Integer jbyp;
    @ApiModelProperty(value="lcjbz")
    private Integer lcjbz;
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @ApiModelProperty(value="煎法 冲服 2,另包 3,后下 4,先煎 5,另烊 6,另煎 7,包煎 8,代煎 9")
    private Integer jf;
    @ApiModelProperty(value="扫描标志")
    private Integer smbz;
    @ApiModelProperty(value="扫描时间")
    private Timestamp smsj;
    @ApiModelProperty(value="折扣比例")
    private BigDecimal zkbl;
    @ApiModelProperty(value="折扣金额")
    private BigDecimal zkje;
    @ApiModelProperty(value="折后金额")
    private BigDecimal zhje;
    @ApiModelProperty(value="附加项目关联字段")
    private Integer uniqueId;
    @ApiModelProperty(value="药品类型")
    private Integer type;
    @ApiModelProperty(value="皮试信息")
    private Integer saveSkinTest;
    @ApiModelProperty(value="费用名称（药品名称）")
    private String fymc;
    @ApiModelProperty(value = "抗生标志 1是 0 否")
    private String ksbz;


    public String getJb() {
        return jb;
    }

    public void setJb(String jb) {
        this.jb = jb;
    }

    public String getKsbz() {
        return ksbz;
    }

    public void setKsbz(String ksbz) {
        this.ksbz = ksbz;
    }

    /** 设置:识别序号 | 识别每条处方明细  */
    public void setSbxh(Integer value) {
        this.sbxh = value;
    }
    /** 获取:识别序号 | 识别每条处方明细 */
    public Integer getSbxh() {
        return sbxh;
    }

    /** 设置:机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构代码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:处方识别  */
    public void setCfsb(Integer value) {
        this.cfsb = value;
    }
    /** 获取:处方识别 */
    public Integer getCfsb() {
        return cfsb;
    }

    /** 设置:药品序号  */
    public void setYpxh(Integer value) {
        this.ypxh = value;
    }
    /** 获取:药品序号 */
    public Integer getYpxh() {
        return ypxh;
    }

    /** 设置:药品产地  */
    public void setYpcd(Integer value) {
        this.ypcd = value;
    }
    /** 获取:药品产地 */
    public Integer getYpcd() {
        return ypcd;
    }

    /** 设置:项目类型 | 1：西药 2：成药3：草药  */
    public void setXmlx(Integer value) {
        this.xmlx = value;
    }
    /** 获取:项目类型 | 1：西药 2：成药3：草药 */
    public Integer getXmlx() {
        return xmlx;
    }

    /** 设置:处方贴数  */
    public void setCfts(Integer value) {
        this.cfts = value;
    }
    /** 获取:处方贴数 */
    public Integer getCfts() {
        return cfts;
    }

    /** 设置:药品数量  */
    public void setYpsl(BigDecimal value) {
        this.ypsl = value;
    }
    /** 获取:药品数量 */
    public BigDecimal getYpsl() {
        return ypsl;
    }

    /** 设置:药品单价  */
    public void setYpdj(BigDecimal value) {
        this.ypdj = value;
    }
    /** 获取:药品单价 */
    public BigDecimal getYpdj() {
        return ypdj;
    }

    /** 设置:划价金额  */
    public void setHjje(BigDecimal value) {
        this.hjje = value;
    }
    /** 获取:划价金额 */
    public BigDecimal getHjje() {
        return hjje;
    }

    /** 设置:草药服法  */
    public void setYpzs(Integer value) {
        this.ypzs = value;
    }
    /** 获取:草药服法 */
    public Integer getYpzs() {
        return ypzs;
    }

    /** 设置:一次数量  */
    public void setYcsl(String value) {
        this.ycsl = value;
    }
    /** 获取:一次数量 */
    public String getYcsl() {
        return ycsl;
    }

    /** 设置:费用归并 | 和DIC_SFXMLB的SFXM关联  */
    public void setFygb(Integer value) {
        this.fygb = value;
    }
    /** 获取:费用归并 | 和DIC_SFXMLB的SFXM关联 */
    public Integer getFygb() {
        return fygb;
    }

    /** 设置:自负比例  */
    public void setZfbl(BigDecimal value) {
        this.zfbl = value;
    }
    /** 获取:自负比例 */
    public BigDecimal getZfbl() {
        return zfbl;
    }

    /** 设置:给药途径  */
    public void setGytj(Integer value) {
        this.gytj = value;
    }
    /** 获取:给药途径 */
    public Integer getGytj() {
        return gytj;
    }

    /** 设置:药品用法  */
    public void setYpyf(String value) {
        this.ypyf = value;
    }
    /** 获取:药品用法 */
    public String getYpyf() {
        return ypyf;
    }

    /** 设置:药品组号  */
    public void setYpzh(Integer value) {
        this.ypzh = value;
    }
    /** 获取:药品组号 */
    public Integer getYpzh() {
        return ypzh;
    }

    /** 设置:药房规格  */
    public void setYfgg(String value) {
        this.yfgg = value;
    }
    /** 获取:药房规格 */
    public String getYfgg() {
        return yfgg;
    }

    /** 设置:药房单位  */
    public void setYfdw(String value) {
        this.yfdw = value;
    }
    /** 获取:药房单位 */
    public String getYfdw() {
        return yfdw;
    }

    /** 设置:药房包装  */
    public void setYfbz(Integer value) {
        this.yfbz = value;
    }
    /** 获取:药房包装 */
    public Integer getYfbz() {
        return yfbz;
    }

    /** 设置:实际用量  */
    public void setSjyl(String value) {
        this.sjyl = value;
    }
    /** 获取:实际用量 */
    public String getSjyl() {
        return sjyl;
    }

    /** 设置:皮试判别  */
    public void setPspb(Integer value) {
        this.pspb = value;
    }
    /** 获取:皮试判别 */
    public Integer getPspb() {
        return pspb;
    }

    /** 设置:用药天数  */
    public void setYyts(Integer value) {
        this.yyts = value;
    }
    /** 获取:用药天数 */
    public Integer getYyts() {
        return yyts;
    }

    /** 设置:一次用量  */
    public void setYcsl2(BigDecimal value) {
        this.ycsl2 = value;
    }
    /** 获取:一次用量 */
    public BigDecimal getYcsl2() {
        return ycsl2;
    }

    /** 设置:显示数量  */
    public void setXssl(BigDecimal value) {
        this.xssl = value;
    }
    /** 获取:显示数量 */
    public BigDecimal getXssl() {
        return xssl;
    }

    /** 设置:每日次数  */
    public void setMrcs(Integer value) {
        this.mrcs = value;
    }
    /** 获取:每日次数 */
    public Integer getMrcs() {
        return mrcs;
    }

    /** 设置:处方标志  */
    public void setCfbz(String value) {
        this.cfbz = value;
    }
    /** 获取:处方标志 */
    public String getCfbz() {
        return cfbz;
    }

    /** 设置:一次剂量  */
    public void setYcjl(BigDecimal value) {
        this.ycjl = value;
    }
    /** 获取:一次剂量 */
    public BigDecimal getYcjl() {
        return ycjl;
    }

    /** 设置:皮试结果  */
    public void setPsjg(Integer value) {
        this.psjg = value;
    }
    /** 获取:皮试结果 */
    public Integer getPsjg() {
        return psjg;
    }

    /** 设置:排列序号  */
    public void setPlxh(Integer value) {
        this.plxh = value;
    }
    /** 获取:排列序号 */
    public Integer getPlxh() {
        return plxh;
    }

    /** 设置:输液标志 | 1 输液调入 0 或 NULL    未调入  */
    public void setSybz(Integer value) {
        this.sybz = value;
    }
    /** 获取:输液标志 | 1 输液调入 0 或 NULL    未调入 */
    public Integer getSybz() {
        return sybz;
    }

    /** 设置:备注信息  */
    public void setBzxx(String value) {
        this.bzxx = value;
    }
    /** 获取:备注信息 */
    public String getBzxx() {
        return bzxx;
    }

    /** 设置:审方结果 | 0：未审核 1：审核通过 2：审核未通过  */
    public void setSfjg(Integer value) {
        this.sfjg = value;
    }
    /** 获取:审方结果 | 0：未审核 1：审核通过 2：审核未通过 */
    public Integer getSfjg() {
        return sfjg;
    }

    /** 设置:审方工号  */
    public void setSfgh(String value) {
        this.sfgh = value;
    }
    /** 获取:审方工号 */
    public String getSfgh() {
        return sfgh;
    }

    /** 设置:审方意见  */
    public void setSfyj(String value) {
        this.sfyj = value;
    }
    /** 获取:审方意见 */
    public String getSfyj() {
        return sfyj;
    }

    /** 设置:备注名称(自备药)  */
    public void setBzmc(String value) {
        this.bzmc = value;
    }
    /** 获取:备注名称(自备药) */
    public String getBzmc() {
        return bzmc;
    }

    /** 设置:自负判别  */
    public void setZfpb(Integer value) {
        this.zfpb = value;
    }
    /** 获取:自负判别 */
    public Integer getZfpb() {
        return zfpb;
    }

    /** 设置:审批编号  */
    public void setSpbh(Integer value) {
        this.spbh = value;
    }
    /** 获取:审批编号 */
    public Integer getSpbh() {
        return spbh;
    }

    /** 设置:抗菌药物越权使用，1表示是，0表示否  */
    public void setYqsy(Integer value) {
        this.yqsy = value;
    }
    /** 获取:抗菌药物越权使用，1表示是，0表示否 */
    public Integer getYqsy() {
        return yqsy;
    }

    /** 设置:抗菌药物授权医生  */
    public void setSqys(String value) {
        this.sqys = value;
    }
    /** 获取:抗菌药物授权医生 */
    public String getSqys() {
        return sqys;
    }

    /** 设置:抗菌药物使用原因  */
    public void setSyyy(String value) {
        this.syyy = value;
    }
    /** 获取:抗菌药物使用原因 */
    public String getSyyy() {
        return syyy;
    }

    /** 设置:自备药标识  */
    public void setZfyp(Integer value) {
        this.zfyp = value;
    }
    /** 获取:自备药标识 */
    public Integer getZfyp() {
        return zfyp;
    }

    /** 设置:yhje  */
    public void setYhje(BigDecimal value) {
        this.yhje = value;
    }
    /** 获取:yhje */
    public BigDecimal getYhje() {
        return yhje;
    }

    /** 设置:jbyp  */
    public void setJbyp(Integer value) {
        this.jbyp = value;
    }
    /** 获取:jbyp */
    public Integer getJbyp() {
        return jbyp;
    }

    /** 设置:lcjbz  */
    public void setLcjbz(Integer value) {
        this.lcjbz = value;
    }
    /** 获取:lcjbz */
    public Integer getLcjbz() {
        return lcjbz;
    }

    /** 设置:组套编号  */
    public void setZtbh(Integer value) {
        this.ztbh = value;
    }
    /** 获取:组套编号 */
    public Integer getZtbh() {
        return ztbh;
    }

    /** 设置:煎法 冲服 2,另包 3,后下 4,先煎 5,另烊 6,另煎 7,包煎 8,代煎 9  */
    public void setJf(Integer value) {
        this.jf = value;
    }
    /** 获取:煎法 冲服 2,另包 3,后下 4,先煎 5,另烊 6,另煎 7,包煎 8,代煎 9 */
    public Integer getJf() {
        return jf;
    }

    /** 设置:扫描标志  */
    public void setSmbz(Integer value) {
        this.smbz = value;
    }
    /** 获取:扫描标志 */
    public Integer getSmbz() {
        return smbz;
    }

    /** 设置:扫描时间  */
    public void setSmsj(Timestamp value) {
        this.smsj = value;
    }
    /** 获取:扫描时间 */
    public Timestamp getSmsj() {
        return smsj;
    }

    /** 设置:折扣比例  */
    public void setZkbl(BigDecimal value) {
        this.zkbl = value;
    }
    /** 获取:折扣比例 */
    public BigDecimal getZkbl() {
        return zkbl;
    }

    /** 设置:折扣金额  */
    public void setZkje(BigDecimal value) {
        this.zkje = value;
    }
    /** 获取:折扣金额 */
    public BigDecimal getZkje() {
        return zkje;
    }

    /** 设置:折后金额  */
    public void setZhje(BigDecimal value) {
        this.zhje = value;
    }
    /** 获取:折后金额 */
    public BigDecimal getZhje() {
        return zhje;
    }

    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSaveSkinTest() {
        return saveSkinTest;
    }

    public void setSaveSkinTest(Integer saveSkinTest) {
        this.saveSkinTest = saveSkinTest;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }
}
