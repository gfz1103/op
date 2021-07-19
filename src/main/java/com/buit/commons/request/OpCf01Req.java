
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


/**
 * 类名称：OpCf01<br>
 * 类描述：门诊_门诊处方表<br>
 * @author 老花生
 */
@ApiModel(value="门诊_门诊处方表")
public class OpCf01Req  extends PageQuery {
    @ApiModelProperty(value="处方号码 | 外部标示一张处方，不唯一")
    private String cfhm;
    @NotNull(message = "门诊就诊号 不能为空")
    @ApiModelProperty(value="门诊就诊")
    private Integer jzxh;
    @ApiModelProperty(value="开方日期")
    private Timestamp kfrq;
    @ApiModelProperty(value="处方类型 | 1：西药处方 2：中药处方 3：草药处方")
    private Integer cflx;
    @ApiModelProperty(value="科室代码 | 开单科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="医生代码 | 开单医生代码")
    private String ysdm;
    @ApiModelProperty(value="处方贴数")
    private Integer cfts;
    @ApiModelProperty(value="代煎标志")
    private Integer djbz;
    @ApiModelProperty(value="方名")
    private String fm;
    @ApiModelProperty(value="煎服法")
    private String jff;
    @ApiModelProperty(value="特殊要求")
    private String tsyq;


    @ApiModelProperty(value="处方识别 | 通过该字段和OP_CF02关联", hidden = true)
    private Integer cfsb;
    @ApiModelProperty(value="机构ID", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="发票号码 | 该处方所属的发票", hidden = true)
    private String fphm;
    @ApiModelProperty(value="门诊序号", hidden = true)
    private Integer mzxh;
    @ApiModelProperty(value="病人ID号", hidden = true)
    private Integer brid;
    @ApiModelProperty(value="病人姓名", hidden = true)
    private String brxm;
    @ApiModelProperty(value="发药日期", hidden = true)
    private Timestamp fyrq;
    @ApiModelProperty(value="发药窗口", hidden = true)
    private Integer fyck;
    @ApiModelProperty(value="划价工号", hidden = true)
    private String hjgh;
    @ApiModelProperty(value="配药工号", hidden = true)
    private String pygh;
    @ApiModelProperty(value="发药工号", hidden = true)
    private String fygh;
    @ApiModelProperty(value="配药标志 | -1：正在配药 0：未配药 1：已配完药", hidden = true)
    private Integer pybz;
    @ApiModelProperty(value="发药标志 | 0：未发药处方 1：已发药处方 3：退药处方", hidden = true)
    private Integer fybz;
    @ApiModelProperty(value="处方关联 | 该处方为退药处方，该处方所退的药为CFGL指向的处方 可以有几张处方的处方关联相同", hidden = true)
    private Integer cfgl;
    @ApiModelProperty(value="作废判别 | 0：有效处方  1：作废处方 该字段具有最高优先级，当ZFPB=1时， 其它各标志均无效", hidden = true)
    private Integer zfpb;
    @ApiModelProperty(value="打印标志", hidden = true)
    private Integer dybz;
    @ApiModelProperty(value="药房识别 | 该处方到哪个药房发药的标识，由门诊的配置文件决定", hidden = true)
    private Integer yfsb;
    @ApiModelProperty(value="特殊处方", hidden = true)
    private Integer tscf;
    @ApiModelProperty(value="特殊类型", hidden = true)
    private Integer tslx;
    @ApiModelProperty(value="退药标志", hidden = true)
    private Integer tybz;
    @ApiModelProperty(value="处方标志 | 该字段已经在4.3产品中作废,版本为bshrp4.3.01.3000", hidden = true)
    private Integer cfbz;
    @ApiModelProperty(value="优先处方", hidden = true)
    private Integer yxpb;
    @ApiModelProperty(value="就诊卡号", hidden = true)
    private String jzkh;
    @ApiModelProperty(value="代煎药标志", hidden = true)
    private Integer djybz;
    @ApiModelProperty(value="作废时间", hidden = true)
    private Timestamp zfsj;
    @ApiModelProperty(value="核对工号", hidden = true)
    private String hdgh;
    @ApiModelProperty(value="核对日期", hidden = true)
    private Timestamp hdrq;
    @ApiModelProperty(value="单据来源 | 1医生开单 2药房划价 3药房退药 4医技划价 5体检开单 6收费划价 7门诊退费", hidden = true)
    private Integer djly;
    @ApiModelProperty(value="上级发药机构", hidden = true)
    private String sjjg;
    @ApiModelProperty(value="上级发药药房", hidden = true)
    private Integer sjyf;
    @ApiModelProperty(value="上级发药标志", hidden = true)
    private Integer sjfybz;
    @ApiModelProperty(value="退药说明", hidden = true)
    private Integer tysm;
    @ApiModelProperty(value="送药地址", hidden = true)
    private String sydz;
    @ApiModelProperty(value="联系电话", hidden = true)
    private String lxdh;
    @ApiModelProperty(value="fwblsh", hidden = true)
    private String fwblsh;
    @ApiModelProperty(value="家庭地址", hidden = true)
    private String jtdz;
    @ApiModelProperty(value="家庭电话", hidden = true)
    private String jtdh;
    @ApiModelProperty(value="半自动发药机的发药状态", hidden = true)
    private Integer pybzJ;
    @ApiModelProperty(value="yscfhm", hidden = true)
    private String yscfhm;
    @ApiModelProperty(value="叫号号码", hidden = true)
    private Integer jhhm;
    @ApiModelProperty(value="启用叫号", hidden = true)
    private Integer qybz;
    @ApiModelProperty(value="叫号标志", hidden = true)
    private Integer jhbz;
    @ApiModelProperty(value="叫号窗口", hidden = true)
    private Integer jhck;
    @ApiModelProperty(value="djcfscid", hidden = true)
    private String djcfscid;
    @ApiModelProperty(value="门诊药房  发药清单标志0:未打印  1:已经打印", hidden = true)
    private Integer fydybz;
    @ApiModelProperty(value="就诊流水号", hidden = true)
    private String jzlsh;

    /** 审核状态 0：未审核、1：已审核 */
    @ApiModelProperty(value="审核状态 0：未审核、1：已审核")
    private String shzt;
    /** 审核时间 */
    @ApiModelProperty(value="审核时间", hidden = true)
    private Timestamp shsj;
    /** 审核医生代码 */
    @ApiModelProperty(value="审核医生代码", hidden = true)
    private String shys;
    /** 审核医生姓名 */
    @ApiModelProperty(value="审核医生姓名", hidden = true)
    private String shysxm;

    public String getShzt() {
        return shzt;
    }

    public void setShzt(String shzt) {
        this.shzt = shzt;
    }

    public Timestamp getShsj() {
        return shsj;
    }

    public void setShsj(Timestamp shsj) {
        this.shsj = shsj;
    }

    public String getShys() {
        return shys;
    }

    public void setShys(String shys) {
        this.shys = shys;
    }

    public String getShysxm() {
        return shysxm;
    }

    public void setShysxm(String shysxm) {
        this.shysxm = shysxm;
    }

    /**
     * 设置:处方识别 | 通过该字段和OP_CF02关联
     */
    public void setCfsb(Integer value) {
        this.cfsb = value;
    }
    /**
     * 获取:处方识别 | 通过该字段和OP_CF02关联
     */
    public Integer getCfsb() {
        return cfsb;
    }
    /**
     * 设置:机构ID
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:机构ID
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:处方号码 | 外部标示一张处方，不唯一
     */
    public void setCfhm(String value) {
        this.cfhm = value;
    }
    /**
     * 获取:处方号码 | 外部标示一张处方，不唯一
     */
    public String getCfhm() {
        return cfhm;
    }
    /**
     * 设置:发票号码 | 该处方所属的发票
     */
    public void setFphm(String value) {
        this.fphm = value;
    }
    /**
     * 获取:发票号码 | 该处方所属的发票
     */
    public String getFphm() {
        return fphm;
    }
    /**
     * 设置:门诊序号
     */
    public void setMzxh(Integer value) {
        this.mzxh = value;
    }
    /**
     * 获取:门诊序号
     */
    public Integer getMzxh() {
        return mzxh;
    }
    /**
     * 设置:处方类型 | 1：西药处方 2：中药处方 3：草药处方
     */
    public void setCflx(Integer value) {
        this.cflx = value;
    }
    /**
     * 获取:处方类型 | 1：西药处方 2：中药处方 3：草药处方
     */
    public Integer getCflx() {
        return cflx;
    }
    /**
     * 设置:病人ID号
     */
    public void setBrid(Integer value) {
        this.brid = value;
    }
    /**
     * 获取:病人ID号
     */
    public Integer getBrid() {
        return brid;
    }
    /**
     * 设置:病人姓名
     */
    public void setBrxm(String value) {
        this.brxm = value;
    }
    /**
     * 获取:病人姓名
     */
    public String getBrxm() {
        return brxm;
    }
    /**
     * 设置:开方日期
     */
    public void setKfrq(Timestamp value) {
        this.kfrq = value;
    }
    /**
     * 获取:开方日期
     */
    public Timestamp getKfrq() {
        return kfrq;
    }
    /**
     * 设置:处方贴数
     */
    public void setCfts(Integer value) {
        this.cfts = value;
    }
    /**
     * 获取:处方贴数
     */
    public Integer getCfts() {
        return cfts;
    }
    /**
     * 设置:科室代码 | 开单科室代码
     */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /**
     * 获取:科室代码 | 开单科室代码
     */
    public Integer getKsdm() {
        return ksdm;
    }
    /**
     * 设置:医生代码 | 开单医生代码
     */
    public void setYsdm(String value) {
        this.ysdm = value;
    }
    /**
     * 获取:医生代码 | 开单医生代码
     */
    public String getYsdm() {
        return ysdm;
    }
    /**
     * 设置:发药日期
     */
    public void setFyrq(Timestamp value) {
        this.fyrq = value;
    }
    /**
     * 获取:发药日期
     */
    public Timestamp getFyrq() {
        return fyrq;
    }
    /**
     * 设置:发药窗口
     */
    public void setFyck(Integer value) {
        this.fyck = value;
    }
    /**
     * 获取:发药窗口
     */
    public Integer getFyck() {
        return fyck;
    }
    /**
     * 设置:划价工号
     */
    public void setHjgh(String value) {
        this.hjgh = value;
    }
    /**
     * 获取:划价工号
     */
    public String getHjgh() {
        return hjgh;
    }
    /**
     * 设置:配药工号
     */
    public void setPygh(String value) {
        this.pygh = value;
    }
    /**
     * 获取:配药工号
     */
    public String getPygh() {
        return pygh;
    }
    /**
     * 设置:发药工号
     */
    public void setFygh(String value) {
        this.fygh = value;
    }
    /**
     * 获取:发药工号
     */
    public String getFygh() {
        return fygh;
    }
    /**
     * 设置:配药标志 | -1：正在配药 0：未配药 1：已配完药
     */
    public void setPybz(Integer value) {
        this.pybz = value;
    }
    /**
     * 获取:配药标志 | -1：正在配药 0：未配药 1：已配完药
     */
    public Integer getPybz() {
        return pybz;
    }
    /**
     * 设置:发药标志 | 0：未发药处方 1：已发药处方 3：退药处方
     */
    public void setFybz(Integer value) {
        this.fybz = value;
    }
    /**
     * 获取:发药标志 | 0：未发药处方 1：已发药处方 3：退药处方
     */
    public Integer getFybz() {
        return fybz;
    }
    /**
     * 设置:处方关联 | 该处方为退药处方，该处方所退的药为CFGL指向的处方 可以有几张处方的处方关联相同
     */
    public void setCfgl(Integer value) {
        this.cfgl = value;
    }
    /**
     * 获取:处方关联 | 该处方为退药处方，该处方所退的药为CFGL指向的处方 可以有几张处方的处方关联相同
     */
    public Integer getCfgl() {
        return cfgl;
    }
    /**
     * 设置:作废判别 | 0：有效处方  1：作废处方 该字段具有最高优先级，当ZFPB=1时， 其它各标志均无效
     */
    public void setZfpb(Integer value) {
        this.zfpb = value;
    }
    /**
     * 获取:作废判别 | 0：有效处方  1：作废处方 该字段具有最高优先级，当ZFPB=1时， 其它各标志均无效
     */
    public Integer getZfpb() {
        return zfpb;
    }
    /**
     * 设置:打印标志
     */
    public void setDybz(Integer value) {
        this.dybz = value;
    }
    /**
     * 获取:打印标志
     */
    public Integer getDybz() {
        return dybz;
    }
    /**
     * 设置:药房识别 | 该处方到哪个药房发药的标识，由门诊的配置文件决定
     */
    public void setYfsb(Integer value) {
        this.yfsb = value;
    }
    /**
     * 获取:药房识别 | 该处方到哪个药房发药的标识，由门诊的配置文件决定
     */
    public Integer getYfsb() {
        return yfsb;
    }
    /**
     * 设置:特殊处方
     */
    public void setTscf(Integer value) {
        this.tscf = value;
    }
    /**
     * 获取:特殊处方
     */
    public Integer getTscf() {
        return tscf;
    }
    /**
     * 设置:特殊类型
     */
    public void setTslx(Integer value) {
        this.tslx = value;
    }
    /**
     * 获取:特殊类型
     */
    public Integer getTslx() {
        return tslx;
    }
    /**
     * 设置:退药标志
     */
    public void setTybz(Integer value) {
        this.tybz = value;
    }
    /**
     * 获取:退药标志
     */
    public Integer getTybz() {
        return tybz;
    }
    /**
     * 设置:处方标志 | 该字段已经在4.3产品中作废,版本为bshrp4.3.01.3000
     */
    public void setCfbz(Integer value) {
        this.cfbz = value;
    }
    /**
     * 获取:处方标志 | 该字段已经在4.3产品中作废,版本为bshrp4.3.01.3000
     */
    public Integer getCfbz() {
        return cfbz;
    }
    /**
     * 设置:门诊就诊
     */
    public void setJzxh(Integer value) {
        this.jzxh = value;
    }
    /**
     * 获取:门诊就诊
     */
    public Integer getJzxh() {
        return jzxh;
    }
    /**
     * 设置:优先处方
     */
    public void setYxpb(Integer value) {
        this.yxpb = value;
    }
    /**
     * 获取:优先处方
     */
    public Integer getYxpb() {
        return yxpb;
    }
    /**
     * 设置:就诊卡号
     */
    public void setJzkh(String value) {
        this.jzkh = value;
    }
    /**
     * 获取:就诊卡号
     */
    public String getJzkh() {
        return jzkh;
    }
    /**
     * 设置:代煎药标志
     */
    public void setDjybz(Integer value) {
        this.djybz = value;
    }
    /**
     * 获取:代煎药标志
     */
    public Integer getDjybz() {
        return djybz;
    }
    /**
     * 设置:作废时间
     */
    public void setZfsj(Timestamp value) {
        this.zfsj = value;
    }
    /**
     * 获取:作废时间
     */
    public Timestamp getZfsj() {
        return zfsj;
    }
    /**
     * 设置:核对工号
     */
    public void setHdgh(String value) {
        this.hdgh = value;
    }
    /**
     * 获取:核对工号
     */
    public String getHdgh() {
        return hdgh;
    }
    /**
     * 设置:核对日期
     */
    public void setHdrq(Timestamp value) {
        this.hdrq = value;
    }
    /**
     * 获取:核对日期
     */
    public Timestamp getHdrq() {
        return hdrq;
    }
    /**
     * 设置:单据来源 | 1医生开单 2药房划价 3药房退药 4医技划价 5体检开单 6收费划价 7门诊退费
     */
    public void setDjly(Integer value) {
        this.djly = value;
    }
    /**
     * 获取:单据来源 | 1医生开单 2药房划价 3药房退药 4医技划价 5体检开单 6收费划价 7门诊退费
     */
    public Integer getDjly() {
        return djly;
    }
    /**
     * 设置:上级发药机构
     */
    public void setSjjg(String value) {
        this.sjjg = value;
    }
    /**
     * 获取:上级发药机构
     */
    public String getSjjg() {
        return sjjg;
    }
    /**
     * 设置:上级发药药房
     */
    public void setSjyf(Integer value) {
        this.sjyf = value;
    }
    /**
     * 获取:上级发药药房
     */
    public Integer getSjyf() {
        return sjyf;
    }
    /**
     * 设置:上级发药标志
     */
    public void setSjfybz(Integer value) {
        this.sjfybz = value;
    }
    /**
     * 获取:上级发药标志
     */
    public Integer getSjfybz() {
        return sjfybz;
    }
    /**
     * 设置:退药说明
     */
    public void setTysm(Integer value) {
        this.tysm = value;
    }
    /**
     * 获取:退药说明
     */
    public Integer getTysm() {
        return tysm;
    }
    /**
     * 设置:送药地址
     */
    public void setSydz(String value) {
        this.sydz = value;
    }
    /**
     * 获取:送药地址
     */
    public String getSydz() {
        return sydz;
    }
    /**
     * 设置:联系电话
     */
    public void setLxdh(String value) {
        this.lxdh = value;
    }
    /**
     * 获取:联系电话
     */
    public String getLxdh() {
        return lxdh;
    }
    /**
     * 设置:fwblsh
     */
    public void setFwblsh(String value) {
        this.fwblsh = value;
    }
    /**
     * 获取:fwblsh
     */
    public String getFwblsh() {
        return fwblsh;
    }
    /**
     * 设置:代煎标志
     */
    public void setDjbz(Integer value) {
        this.djbz = value;
    }
    /**
     * 获取:代煎标志
     */
    public Integer getDjbz() {
        return djbz;
    }
    /**
     * 设置:家庭地址
     */
    public void setJtdz(String value) {
        this.jtdz = value;
    }
    /**
     * 获取:家庭地址
     */
    public String getJtdz() {
        return jtdz;
    }
    /**
     * 设置:家庭电话
     */
    public void setJtdh(String value) {
        this.jtdh = value;
    }
    /**
     * 获取:家庭电话
     */
    public String getJtdh() {
        return jtdh;
    }
    /**
     * 设置:半自动发药机的发药状态
     */
    public void setPybzJ(Integer value) {
        this.pybzJ = value;
    }
    /**
     * 获取:半自动发药机的发药状态
     */
    public Integer getPybzJ() {
        return pybzJ;
    }
    /**
     * 设置:方名
     */
    public void setFm(String value) {
        this.fm = value;
    }
    /**
     * 获取:方名
     */
    public String getFm() {
        return fm;
    }
    /**
     * 设置:煎服法
     */
    public void setJff(String value) {
        this.jff = value;
    }
    /**
     * 获取:煎服法
     */
    public String getJff() {
        return jff;
    }
    /**
     * 设置:yscfhm
     */
    public void setYscfhm(String value) {
        this.yscfhm = value;
    }
    /**
     * 获取:yscfhm
     */
    public String getYscfhm() {
        return yscfhm;
    }
    /**
     * 设置:叫号号码
     */
    public void setJhhm(Integer value) {
        this.jhhm = value;
    }
    /**
     * 获取:叫号号码
     */
    public Integer getJhhm() {
        return jhhm;
    }
    /**
     * 设置:启用叫号
     */
    public void setQybz(Integer value) {
        this.qybz = value;
    }
    /**
     * 获取:启用叫号
     */
    public Integer getQybz() {
        return qybz;
    }
    /**
     * 设置:叫号标志
     */
    public void setJhbz(Integer value) {
        this.jhbz = value;
    }
    /**
     * 获取:叫号标志
     */
    public Integer getJhbz() {
        return jhbz;
    }
    /**
     * 设置:叫号窗口
     */
    public void setJhck(Integer value) {
        this.jhck = value;
    }
    /**
     * 获取:叫号窗口
     */
    public Integer getJhck() {
        return jhck;
    }
    /**
     * 设置:djcfscid
     */
    public void setDjcfscid(String value) {
        this.djcfscid = value;
    }
    /**
     * 获取:djcfscid
     */
    public String getDjcfscid() {
        return djcfscid;
    }
    /**
     * 设置:特殊要求
     */
    public void setTsyq(String value) {
        this.tsyq = value;
    }
    /**
     * 获取:特殊要求
     */
    public String getTsyq() {
        return tsyq;
    }
    /**
     * 设置:门诊药房  发药清单标志0:未打印  1:已经打印
     */
    public void setFydybz(Integer value) {
        this.fydybz = value;
    }
    /**
     * 获取:门诊药房  发药清单标志0:未打印  1:已经打印
     */
    public Integer getFydybz() {
        return fydybz;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }
}
