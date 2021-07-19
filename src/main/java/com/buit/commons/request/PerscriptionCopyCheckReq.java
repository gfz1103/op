package com.buit.commons.request;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName PerscriptionCopyCheckReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/1 15:14
 */
@ApiModel(value="检验处方拷贝信息-请求")
public class PerscriptionCopyCheckReq {
    @ApiModelProperty(value="病人性质")
    private String brxz;
    @ApiModelProperty(value="处方集合")
    private List<Cf01> cf01List;
    @ApiModelProperty(value="处方明细集合")
    private List<Cf02> cf02List;

    public static class Cf01 {

        @ApiModelProperty(value="处方识别 | 通过该字段和OP_CF02关联")
        /** 处方识别 | 通过该字段和OP_CF02关联 */
        private Integer cfsb;
        @ApiModelProperty(value="机构ID")
        /** 机构ID */
        private Integer jgid;
        @ApiModelProperty(value="处方号码 | 外部标示一张处方，不唯一")
        /** 处方号码 | 外部标示一张处方，不唯一 */
        private String cfhm;
        @ApiModelProperty(value="发票号码 | 该处方所属的发票")
        /** 发票号码 | 该处方所属的发票 */
        private String fphm;
        @ApiModelProperty(value="门诊序号")
        /** 门诊序号 */
        private Integer mzxh;
        @ApiModelProperty(value="处方类型 | 1：西药处方 2：中药处方 3：草药处方")
        /** 处方类型 | 1：西药处方 2：中药处方 3：草药处方 */
        private Integer cflx;
        @ApiModelProperty(value="病人ID号")
        /** 病人ID号 */
        private Integer brid;
        @ApiModelProperty(value="病人姓名")
        /** 病人姓名 */
        private String brxm;
        @ApiModelProperty(value="开方日期")
        /** 开方日期 */
        private Date kfrq;
        @ApiModelProperty(value="处方贴数")
        /** 处方贴数 */
        private Integer cfts;
        @ApiModelProperty(value="科室代码 | 开单科室代码")
        /** 科室代码 | 开单科室代码 */
        private Integer ksdm;
        @ApiModelProperty(value="医生代码 | 开单医生代码")
        /** 医生代码 | 开单医生代码 */
        private String ysdm;
        @ApiModelProperty(value="发药日期")
        /** 发药日期 */
        private Timestamp fyrq;
        @ApiModelProperty(value="发药窗口")
        /** 发药窗口 */
        private Integer fyck;
        @ApiModelProperty(value="划价工号")
        /** 划价工号 */
        private String hjgh;
        @ApiModelProperty(value="配药工号")
        /** 配药工号 */
        private String pygh;
        @ApiModelProperty(value="发药工号")
        /** 发药工号 */
        private String fygh;
        @ApiModelProperty(value="配药标志 | -1：正在配药 0：未配药 1：已配完药")
        /** 配药标志 | -1：正在配药 0：未配药 1：已配完药 */
        private Integer pybz;
        @ApiModelProperty(value="发药标志 | 0：未发药处方 1：已发药处方 3：退药处方")
        /** 发药标志 | 0：未发药处方 1：已发药处方 3：退药处方 */
        private Integer fybz;
        @ApiModelProperty(value="处方关联 | 该处方为退药处方，该处方所退的药为CFGL指向的处方 可以有几张处方的处方关联相同")
        /** 处方关联 | 该处方为退药处方，该处方所退的药为CFGL指向的处方 可以有几张处方的处方关联相同 */
        private Integer cfgl;
        @ApiModelProperty(value="作废判别 | 0：有效处方  1：作废处方 该字段具有最高优先级，当ZFPB=1时， 其它各标志均无效")
        /** 作废判别 | 0：有效处方  1：作废处方 该字段具有最高优先级，当ZFPB=1时， 其它各标志均无效 */
        private Integer zfpb;
        @ApiModelProperty(value="打印标志")
        /** 打印标志 */
        private Integer dybz;
        @ApiModelProperty(value="药房识别 | 该处方到哪个药房发药的标识，由门诊的配置文件决定")
        /** 药房识别 | 该处方到哪个药房发药的标识，由门诊的配置文件决定 */
        private Integer yfsb;
        @ApiModelProperty(value="特殊处方")
        /** 特殊处方 */
        private Integer tscf;
        @ApiModelProperty(value="特殊类型")
        /** 特殊类型 */
        private Integer tslx;
        @ApiModelProperty(value="退药标志")
        /** 退药标志 */
        private Integer tybz;
        @ApiModelProperty(value="处方标志 | 该字段已经在4.3产品中作废,版本为bshrp4.3.01.3000")
        /** 处方标志 | 该字段已经在4.3产品中作废,版本为bshrp4.3.01.3000 */
        private Integer cfbz;
        @ApiModelProperty(value="门诊就诊")
        /** 门诊就诊 */
        private Integer jzxh;
        @ApiModelProperty(value="优先处方")
        /** 优先处方 */
        private Integer yxpb;
        @ApiModelProperty(value="就诊卡号")
        /** 就诊卡号 */
        private String jzkh;
        @ApiModelProperty(value="代煎药标志")
        /** 代煎药标志 */
        private Integer djybz;
        @ApiModelProperty(value="作废时间")
        /** 作废时间 */
        private Timestamp zfsj;
        @ApiModelProperty(value="核对工号")
        /** 核对工号 */
        private String hdgh;
        @ApiModelProperty(value="核对日期")
        /** 核对日期 */
        private Timestamp hdrq;
        @ApiModelProperty(value="单据来源 | 1医生开单 2药房划价 3药房退药 4医技划价 5体检开单 6收费划价 7门诊退费")
        /** 单据来源 | 1医生开单 2药房划价 3药房退药 4医技划价 5体检开单 6收费划价 7门诊退费 */
        private Integer djly;
        @ApiModelProperty(value="上级发药机构")
        /** 上级发药机构 */
        private String sjjg;
        @ApiModelProperty(value="上级发药药房")
        /** 上级发药药房 */
        private Integer sjyf;
        @ApiModelProperty(value="上级发药标志")
        /** 上级发药标志 */
        private Integer sjfybz;
        @ApiModelProperty(value="退药说明")
        /** 退药说明 */
        private Integer tysm;
        @ApiModelProperty(value="送药地址")
        /** 送药地址 */
        private String sydz;
        @ApiModelProperty(value="联系电话")
        /** 联系电话 */
        private String lxdh;
        @ApiModelProperty(value="fwblsh")
        /** fwblsh */
        private String fwblsh;
        @ApiModelProperty(value="代煎标志")
        /** 代煎标志 */
        private Integer djbz;
        @ApiModelProperty(value="家庭地址")
        /** 家庭地址 */
        private String jtdz;
        @ApiModelProperty(value="家庭电话")
        /** 家庭电话 */
        private String jtdh;
        @ApiModelProperty(value="半自动发药机的发药状态")
        /** 半自动发药机的发药状态 */
        private Integer pybzJ;
        @ApiModelProperty(value="方名")
        /** 方名 */
        private String fm;
        @ApiModelProperty(value="煎服法")
        /** 煎服法 */
        private String jff;
        @ApiModelProperty(value="yscfhm")
        /** yscfhm */
        private String yscfhm;
        @ApiModelProperty(value="叫号号码")
        /** 叫号号码 */
        private Integer jhhm;
        @ApiModelProperty(value="启用叫号")
        /** 启用叫号 */
        private Integer qybz;
        @ApiModelProperty(value="叫号标志")
        /** 叫号标志 */
        private Integer jhbz;
        @ApiModelProperty(value="叫号窗口")
        /** 叫号窗口 */
        private Integer jhck;
        @ApiModelProperty(value="djcfscid")
        /** djcfscid */
        private String djcfscid;
        @ApiModelProperty(value="特殊要求")
        /** 特殊要求 */
        private String tsyq;
        @ApiModelProperty(value="门诊药房  发药清单标志0:未打印  1:已经打印")
        /** 门诊药房  发药清单标志0:未打印  1:已经打印 */
        private Integer fydybz;

        public Integer getCfsb() {
            return cfsb;
        }

        public void setCfsb(Integer cfsb) {
            this.cfsb = cfsb;
        }

        public Integer getJgid() {
            return jgid;
        }

        public void setJgid(Integer jgid) {
            this.jgid = jgid;
        }

        public String getCfhm() {
            return cfhm;
        }

        public void setCfhm(String cfhm) {
            this.cfhm = cfhm;
        }

        public String getFphm() {
            return fphm;
        }

        public void setFphm(String fphm) {
            this.fphm = fphm;
        }

        public Integer getMzxh() {
            return mzxh;
        }

        public void setMzxh(Integer mzxh) {
            this.mzxh = mzxh;
        }

        public Integer getCflx() {
            return cflx;
        }

        public void setCflx(Integer cflx) {
            this.cflx = cflx;
        }

        public Integer getBrid() {
            return brid;
        }

        public void setBrid(Integer brid) {
            this.brid = brid;
        }

        public String getBrxm() {
            return brxm;
        }

        public void setBrxm(String brxm) {
            this.brxm = brxm;
        }

        public Date getKfrq() {
            return kfrq;
        }

        public void setKfrq(Date kfrq) {
            this.kfrq = kfrq;
        }

        public Integer getCfts() {
            return cfts;
        }

        public void setCfts(Integer cfts) {
            this.cfts = cfts;
        }

        public Integer getKsdm() {
            return ksdm;
        }

        public void setKsdm(Integer ksdm) {
            this.ksdm = ksdm;
        }

        public String getYsdm() {
            return ysdm;
        }

        public void setYsdm(String ysdm) {
            this.ysdm = ysdm;
        }

        public Timestamp getFyrq() {
            return fyrq;
        }

        public void setFyrq(Timestamp fyrq) {
            this.fyrq = fyrq;
        }

        public Integer getFyck() {
            return fyck;
        }

        public void setFyck(Integer fyck) {
            this.fyck = fyck;
        }

        public String getHjgh() {
            return hjgh;
        }

        public void setHjgh(String hjgh) {
            this.hjgh = hjgh;
        }

        public String getPygh() {
            return pygh;
        }

        public void setPygh(String pygh) {
            this.pygh = pygh;
        }

        public String getFygh() {
            return fygh;
        }

        public void setFygh(String fygh) {
            this.fygh = fygh;
        }

        public Integer getPybz() {
            return pybz;
        }

        public void setPybz(Integer pybz) {
            this.pybz = pybz;
        }

        public Integer getFybz() {
            return fybz;
        }

        public void setFybz(Integer fybz) {
            this.fybz = fybz;
        }

        public Integer getCfgl() {
            return cfgl;
        }

        public void setCfgl(Integer cfgl) {
            this.cfgl = cfgl;
        }

        public Integer getZfpb() {
            return zfpb;
        }

        public void setZfpb(Integer zfpb) {
            this.zfpb = zfpb;
        }

        public Integer getDybz() {
            return dybz;
        }

        public void setDybz(Integer dybz) {
            this.dybz = dybz;
        }

        public Integer getYfsb() {
            return yfsb;
        }

        public void setYfsb(Integer yfsb) {
            this.yfsb = yfsb;
        }

        public Integer getTscf() {
            return tscf;
        }

        public void setTscf(Integer tscf) {
            this.tscf = tscf;
        }

        public Integer getTslx() {
            return tslx;
        }

        public void setTslx(Integer tslx) {
            this.tslx = tslx;
        }

        public Integer getTybz() {
            return tybz;
        }

        public void setTybz(Integer tybz) {
            this.tybz = tybz;
        }

        public Integer getCfbz() {
            return cfbz;
        }

        public void setCfbz(Integer cfbz) {
            this.cfbz = cfbz;
        }

        public Integer getJzxh() {
            return jzxh;
        }

        public void setJzxh(Integer jzxh) {
            this.jzxh = jzxh;
        }

        public Integer getYxpb() {
            return yxpb;
        }

        public void setYxpb(Integer yxpb) {
            this.yxpb = yxpb;
        }

        public String getJzkh() {
            return jzkh;
        }

        public void setJzkh(String jzkh) {
            this.jzkh = jzkh;
        }

        public Integer getDjybz() {
            return djybz;
        }

        public void setDjybz(Integer djybz) {
            this.djybz = djybz;
        }

        public Timestamp getZfsj() {
            return zfsj;
        }

        public void setZfsj(Timestamp zfsj) {
            this.zfsj = zfsj;
        }

        public String getHdgh() {
            return hdgh;
        }

        public void setHdgh(String hdgh) {
            this.hdgh = hdgh;
        }

        public Timestamp getHdrq() {
            return hdrq;
        }

        public void setHdrq(Timestamp hdrq) {
            this.hdrq = hdrq;
        }

        public Integer getDjly() {
            return djly;
        }

        public void setDjly(Integer djly) {
            this.djly = djly;
        }

        public String getSjjg() {
            return sjjg;
        }

        public void setSjjg(String sjjg) {
            this.sjjg = sjjg;
        }

        public Integer getSjyf() {
            return sjyf;
        }

        public void setSjyf(Integer sjyf) {
            this.sjyf = sjyf;
        }

        public Integer getSjfybz() {
            return sjfybz;
        }

        public void setSjfybz(Integer sjfybz) {
            this.sjfybz = sjfybz;
        }

        public Integer getTysm() {
            return tysm;
        }

        public void setTysm(Integer tysm) {
            this.tysm = tysm;
        }

        public String getSydz() {
            return sydz;
        }

        public void setSydz(String sydz) {
            this.sydz = sydz;
        }

        public String getLxdh() {
            return lxdh;
        }

        public void setLxdh(String lxdh) {
            this.lxdh = lxdh;
        }

        public String getFwblsh() {
            return fwblsh;
        }

        public void setFwblsh(String fwblsh) {
            this.fwblsh = fwblsh;
        }

        public Integer getDjbz() {
            return djbz;
        }

        public void setDjbz(Integer djbz) {
            this.djbz = djbz;
        }

        public String getJtdz() {
            return jtdz;
        }

        public void setJtdz(String jtdz) {
            this.jtdz = jtdz;
        }

        public String getJtdh() {
            return jtdh;
        }

        public void setJtdh(String jtdh) {
            this.jtdh = jtdh;
        }

        public Integer getPybzJ() {
            return pybzJ;
        }

        public void setPybzJ(Integer pybzJ) {
            this.pybzJ = pybzJ;
        }

        public String getFm() {
            return fm;
        }

        public void setFm(String fm) {
            this.fm = fm;
        }

        public String getJff() {
            return jff;
        }

        public void setJff(String jff) {
            this.jff = jff;
        }

        public String getYscfhm() {
            return yscfhm;
        }

        public void setYscfhm(String yscfhm) {
            this.yscfhm = yscfhm;
        }

        public Integer getJhhm() {
            return jhhm;
        }

        public void setJhhm(Integer jhhm) {
            this.jhhm = jhhm;
        }

        public Integer getQybz() {
            return qybz;
        }

        public void setQybz(Integer qybz) {
            this.qybz = qybz;
        }

        public Integer getJhbz() {
            return jhbz;
        }

        public void setJhbz(Integer jhbz) {
            this.jhbz = jhbz;
        }

        public Integer getJhck() {
            return jhck;
        }

        public void setJhck(Integer jhck) {
            this.jhck = jhck;
        }

        public String getDjcfscid() {
            return djcfscid;
        }

        public void setDjcfscid(String djcfscid) {
            this.djcfscid = djcfscid;
        }

        public String getTsyq() {
            return tsyq;
        }

        public void setTsyq(String tsyq) {
            this.tsyq = tsyq;
        }

        public Integer getFydybz() {
            return fydybz;
        }

        public void setFydybz(Integer fydybz) {
            this.fydybz = fydybz;
        }
    }

    public static class Cf02 {
        @ApiModelProperty(value="识别序号 | 识别每条处方明细")
        /** 识别序号 | 识别每条处方明细 */
        private Integer sbxh;
        @ApiModelProperty(value="机构代码")
        /** 机构代码 */
        private Integer jgid;
        @ApiModelProperty(value="处方识别")
        /** 处方识别 */
        private Integer cfsb;
        @ApiModelProperty(value="药品序号")
        /** 药品序号 */
        private Integer ypxh;
        @ApiModelProperty(value="药品产地")
        /** 药品产地 */
        private Integer ypcd;
        @ApiModelProperty(value="项目类型 | 1：西药 2：成药3：草药")
        /** 项目类型 | 1：西药 2：成药3：草药 */
        private Integer xmlx;
        @ApiModelProperty(value="处方贴数")
        /** 处方贴数 */
        private Integer cfts;
        @ApiModelProperty(value="药品数量")
        /** 药品数量 */
        private BigDecimal ypsl;
        @ApiModelProperty(value="药品单价")
        /** 药品单价 */
        private BigDecimal ypdj;
        @ApiModelProperty(value="划价金额")
        /** 划价金额 */
        private BigDecimal hjje;
        @ApiModelProperty(value="草药服法")
        /** 草药服法 */
        private Integer ypzs;
        @ApiModelProperty(value="一次数量")
        /** 一次数量 */
        private String ycsl;
        @ApiModelProperty(value="费用归并 | 和DIC_SFXMLB的SFXM关联")
        /** 费用归并 | 和DIC_SFXMLB的SFXM关联 */
        private Integer fygb;
        @ApiModelProperty(value="自负比例")
        /** 自负比例 */
        private BigDecimal zfbl;
        @ApiModelProperty(value="给药途径")
        /** 给药途径 */
        private Integer gytj;
        @ApiModelProperty(value="药品用法")
        /** 药品用法 */
        private String ypyf;
        @ApiModelProperty(value="药品组号")
        /** 药品组号 */
        private Integer ypzh;
        @ApiModelProperty(value="药房规格")
        /** 药房规格 */
        private String yfgg;
        @ApiModelProperty(value="药房单位")
        /** 药房单位 */
        private String yfdw;
        @ApiModelProperty(value="药房包装")
        /** 药房包装 */
        private Integer yfbz;
        @ApiModelProperty(value="实际用量")
        /** 实际用量 */
        private String sjyl;
        @ApiModelProperty(value="皮试判别")
        /** 皮试判别 */
        private Integer pspb;
        @ApiModelProperty(value="用药天数")
        /** 用药天数 */
        private Integer yyts;
        @ApiModelProperty(value="一次用量")
        /** 一次用量 */
        private BigDecimal ycsl2;
        @ApiModelProperty(value="显示数量")
        /** 显示数量 */
        private BigDecimal xssl;
        @ApiModelProperty(value="每日次数")
        /** 每日次数 */
        private Integer mrcs;
        @ApiModelProperty(value="处方标志")
        /** 处方标志 */
        private String cfbz;
        @ApiModelProperty(value="一次剂量")
        /** 一次剂量 */
        private BigDecimal ycjl;
        @ApiModelProperty(value="皮试结果")
        /** 皮试结果 */
        private Integer psjg;
        @ApiModelProperty(value="排列序号")
        /** 排列序号 */
        private Integer plxh;
        @ApiModelProperty(value="输液标志 | 1 输液调入 0 或 NULL    未调入")
        /** 输液标志 | 1 输液调入 0 或 NULL    未调入 */
        private Integer sybz;
        @ApiModelProperty(value="备注信息")
        /** 备注信息 */
        private String bzxx;
        @ApiModelProperty(value="审方结果 | 0：未审核 1：审核通过 2：审核未通过")
        /** 审方结果 | 0：未审核 1：审核通过 2：审核未通过 */
        private Integer sfjg;
        @ApiModelProperty(value="审方工号")
        /** 审方工号 */
        private String sfgh;
        @ApiModelProperty(value="审方意见")
        /** 审方意见 */
        private String sfyj;
        @ApiModelProperty(value="备注名称(自备药)")
        /** 备注名称(自备药) */
        private String bzmc;
        @ApiModelProperty(value="自负判别")
        /** 自负判别 */
        private Integer zfpb;
        @ApiModelProperty(value="审批编号")
        /** 审批编号 */
        private Integer spbh;
        @ApiModelProperty(value="抗菌药物越权使用，1表示是，0表示否")
        /** 抗菌药物越权使用，1表示是，0表示否 */
        private Integer yqsy;
        @ApiModelProperty(value="抗菌药物授权医生")
        /** 抗菌药物授权医生 */
        private String sqys;
        @ApiModelProperty(value="抗菌药物使用原因")
        /** 抗菌药物使用原因 */
        private String syyy;
        @ApiModelProperty(value="自备药标识")
        /** 自备药标识 */
        private Integer zfyp;
        @ApiModelProperty(value="yhje")
        /** yhje */
        private BigDecimal yhje;
        @ApiModelProperty(value="jbyp")
        /** jbyp */
        private Integer jbyp;
        @ApiModelProperty(value="lcjbz")
        /** lcjbz */
        private Integer lcjbz;
        @ApiModelProperty(value="组套编号")
        /** 组套编号 */
        private Integer ztbh;
        @ApiModelProperty(value="煎法 冲服 2,另包 3,后下 4,先煎 5,另烊 6,另煎 7,包煎 8,代煎 9")
        /** 煎法 冲服 2,另包 3,后下 4,先煎 5,另烊 6,另煎 7,包煎 8,代煎 9 */
        private Integer jf;
        @ApiModelProperty(value="扫描标志")
        /** 扫描标志 */
        private Integer smbz;
        @ApiModelProperty(value="扫描时间")
        /** 扫描时间 */
        private Timestamp smsj;
        @ApiModelProperty(value="折扣比例")
        /** 折扣比例 */
        private BigDecimal zkbl;
        @ApiModelProperty(value="折扣金额")
        /** 折扣金额 */
        private BigDecimal zkje;
        @ApiModelProperty(value="折后金额")
        /** 折后金额 */
        private BigDecimal zhje;

        public Integer getSbxh() {
            return sbxh;
        }

        public void setSbxh(Integer sbxh) {
            this.sbxh = sbxh;
        }

        public Integer getJgid() {
            return jgid;
        }

        public void setJgid(Integer jgid) {
            this.jgid = jgid;
        }

        public Integer getCfsb() {
            return cfsb;
        }

        public void setCfsb(Integer cfsb) {
            this.cfsb = cfsb;
        }

        public Integer getYpxh() {
            return ypxh;
        }

        public void setYpxh(Integer ypxh) {
            this.ypxh = ypxh;
        }

        public Integer getYpcd() {
            return ypcd;
        }

        public void setYpcd(Integer ypcd) {
            this.ypcd = ypcd;
        }

        public Integer getXmlx() {
            return xmlx;
        }

        public void setXmlx(Integer xmlx) {
            this.xmlx = xmlx;
        }

        public Integer getCfts() {
            return cfts;
        }

        public void setCfts(Integer cfts) {
            this.cfts = cfts;
        }

        public BigDecimal getYpsl() {
            return ypsl;
        }

        public void setYpsl(BigDecimal ypsl) {
            this.ypsl = ypsl;
        }

        public BigDecimal getYpdj() {
            return ypdj;
        }

        public void setYpdj(BigDecimal ypdj) {
            this.ypdj = ypdj;
        }

        public BigDecimal getHjje() {
            return hjje;
        }

        public void setHjje(BigDecimal hjje) {
            this.hjje = hjje;
        }

        public Integer getYpzs() {
            return ypzs;
        }

        public void setYpzs(Integer ypzs) {
            this.ypzs = ypzs;
        }

        public String getYcsl() {
            return ycsl;
        }

        public void setYcsl(String ycsl) {
            this.ycsl = ycsl;
        }

        public Integer getFygb() {
            return fygb;
        }

        public void setFygb(Integer fygb) {
            this.fygb = fygb;
        }

        public BigDecimal getZfbl() {
            return zfbl;
        }

        public void setZfbl(BigDecimal zfbl) {
            this.zfbl = zfbl;
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

        public Integer getYpzh() {
            return ypzh;
        }

        public void setYpzh(Integer ypzh) {
            this.ypzh = ypzh;
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

        public String getSjyl() {
            return sjyl;
        }

        public void setSjyl(String sjyl) {
            this.sjyl = sjyl;
        }

        public Integer getPspb() {
            return pspb;
        }

        public void setPspb(Integer pspb) {
            this.pspb = pspb;
        }

        public Integer getYyts() {
            return yyts;
        }

        public void setYyts(Integer yyts) {
            this.yyts = yyts;
        }

        public BigDecimal getYcsl2() {
            return ycsl2;
        }

        public void setYcsl2(BigDecimal ycsl2) {
            this.ycsl2 = ycsl2;
        }

        public BigDecimal getXssl() {
            return xssl;
        }

        public void setXssl(BigDecimal xssl) {
            this.xssl = xssl;
        }

        public Integer getMrcs() {
            return mrcs;
        }

        public void setMrcs(Integer mrcs) {
            this.mrcs = mrcs;
        }

        public String getCfbz() {
            return cfbz;
        }

        public void setCfbz(String cfbz) {
            this.cfbz = cfbz;
        }

        public BigDecimal getYcjl() {
            return ycjl;
        }

        public void setYcjl(BigDecimal ycjl) {
            this.ycjl = ycjl;
        }

        public Integer getPsjg() {
            return psjg;
        }

        public void setPsjg(Integer psjg) {
            this.psjg = psjg;
        }

        public Integer getPlxh() {
            return plxh;
        }

        public void setPlxh(Integer plxh) {
            this.plxh = plxh;
        }

        public Integer getSybz() {
            return sybz;
        }

        public void setSybz(Integer sybz) {
            this.sybz = sybz;
        }

        public String getBzxx() {
            return bzxx;
        }

        public void setBzxx(String bzxx) {
            this.bzxx = bzxx;
        }

        public Integer getSfjg() {
            return sfjg;
        }

        public void setSfjg(Integer sfjg) {
            this.sfjg = sfjg;
        }

        public String getSfgh() {
            return sfgh;
        }

        public void setSfgh(String sfgh) {
            this.sfgh = sfgh;
        }

        public String getSfyj() {
            return sfyj;
        }

        public void setSfyj(String sfyj) {
            this.sfyj = sfyj;
        }

        public String getBzmc() {
            return bzmc;
        }

        public void setBzmc(String bzmc) {
            this.bzmc = bzmc;
        }

        public Integer getZfpb() {
            return zfpb;
        }

        public void setZfpb(Integer zfpb) {
            this.zfpb = zfpb;
        }

        public Integer getSpbh() {
            return spbh;
        }

        public void setSpbh(Integer spbh) {
            this.spbh = spbh;
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

        public String getSyyy() {
            return syyy;
        }

        public void setSyyy(String syyy) {
            this.syyy = syyy;
        }

        public Integer getZfyp() {
            return zfyp;
        }

        public void setZfyp(Integer zfyp) {
            this.zfyp = zfyp;
        }

        public BigDecimal getYhje() {
            return yhje;
        }

        public void setYhje(BigDecimal yhje) {
            this.yhje = yhje;
        }

        public Integer getJbyp() {
            return jbyp;
        }

        public void setJbyp(Integer jbyp) {
            this.jbyp = jbyp;
        }

        public Integer getLcjbz() {
            return lcjbz;
        }

        public void setLcjbz(Integer lcjbz) {
            this.lcjbz = lcjbz;
        }

        public Integer getZtbh() {
            return ztbh;
        }

        public void setZtbh(Integer ztbh) {
            this.ztbh = ztbh;
        }

        public Integer getJf() {
            return jf;
        }

        public void setJf(Integer jf) {
            this.jf = jf;
        }

        public Integer getSmbz() {
            return smbz;
        }

        public void setSmbz(Integer smbz) {
            this.smbz = smbz;
        }

        public Timestamp getSmsj() {
            return smsj;
        }

        public void setSmsj(Timestamp smsj) {
            this.smsj = smsj;
        }

        public BigDecimal getZkbl() {
            return zkbl;
        }

        public void setZkbl(BigDecimal zkbl) {
            this.zkbl = zkbl;
        }

        public BigDecimal getZkje() {
            return zkje;
        }

        public void setZkje(BigDecimal zkje) {
            this.zkje = zkje;
        }

        public BigDecimal getZhje() {
            return zhje;
        }

        public void setZhje(BigDecimal zhje) {
            this.zhje = zhje;
        }
    }

    public String getBrxz() {
        return brxz;
    }

    public void setBrxz(String brxz) {
        this.brxz = brxz;
    }

    public List<Cf01> getCf01List() {
        return cf01List;
    }

    public void setCf01List(List<Cf01> cf01List) {
        this.cf01List = cf01List;
    }

    public List<Cf02> getCf02List() {
        return cf02List;
    }

    public void setCf02List(List<Cf02> cf02List) {
        this.cf02List = cf02List;
    }
}
