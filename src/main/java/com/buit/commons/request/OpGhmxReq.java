
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * 类名称：OpGhmx<br>
 * 类描述：门诊_挂号明细表<br>
 * @author 老花生
 */
@ApiModel(value="挂号明细表")
public class OpGhmxReq  extends PageQuery {
    @ApiModelProperty(value="就诊卡号")
    private String jzkh;
    @NotNull(message = "就诊状态 不能为空")
    @ApiModelProperty(value="就诊状态 1：待诊、 2：暂挂、 3：已诊")
    private Integer patientType;
    @NotNull(message = "科室代码 | 挂号科室代码 不能为空")
    @ApiModelProperty(value="科室代码 | 挂号科室代码")
    private Integer ghks;
    @NotNull(message = "门诊科室代码不能为空")
    @ApiModelProperty(value="门诊科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="日期yyyy-mm-dd:开始")
    private String nowDate;
    @ApiModelProperty(value="日期yyyy-mm-dd:结束")
    private String nowDateEnd;
    @ApiModelProperty(value="患者姓名 模糊查询")
    private String hzxm;


    @ApiModelProperty(value="识别序号 | 唯一标示一次挂号的序号", hidden = true)
    private Integer sbxh;
    @ApiModelProperty(value="机构代码", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="病人ID号", hidden = true)
    private Integer brid;
    @ApiModelProperty(value="病人性质", hidden = true)
    private Integer brxz;
    @ApiModelProperty(value="挂号时间", hidden = true)
    private Timestamp ghsj;
    @ApiModelProperty(value="挂号类别 | 与GY_DMZD (DMLB = 25)关联", hidden = true)
    private Integer ghlb;
    @ApiModelProperty(value="医生代码 | 若所挂科室为专家科室，则该代码为专家医生代码，否则为空", hidden = true)
    private Integer ysdm;
    @ApiModelProperty(value="接诊医生 | 该字段院长查询使用，用于按医生统计挂号人数，导数据时根据处方、检查单及发票将医生写入到该字段中", hidden = true)
    private String jzys;
    @ApiModelProperty(value="就诊序号 | 表明病人所挂的号为该科室(或该专家)当天挂号的排位序号", hidden = true)
    private Integer jzxh;
    @ApiModelProperty(value="挂号次数 | 该条挂号信息挂该科室挂了几个号，现指定为1", hidden = true)
    private Integer ghcs;
    @ApiModelProperty(value="挂号金额 | 挂号金额、诊疗金额、专家费用、病历金额、该四项金额为总计部分，而非自负部分，前三项需在系统参数中设置对应的收费项目", hidden = true)
    private BigDecimal ghje;
    @ApiModelProperty(value="诊疗金额", hidden = true)
    private BigDecimal zlje;
    @ApiModelProperty(value="专家费用", hidden = true)
    private BigDecimal zjfy;
    @ApiModelProperty(value="病历金额", hidden = true)
    private BigDecimal blje;
    @ApiModelProperty(value="现金金额 | 若挂号金额+诊疗金额专+家费用+病历金额 = 现金金额+支票金额+帐户金额+货币误差+其它应收", hidden = true)
    private BigDecimal xjje;
    @ApiModelProperty(value="支票金额", hidden = true)
    private BigDecimal zpje;
    @ApiModelProperty(value="帐户金额", hidden = true)
    private BigDecimal zhje;
    @ApiModelProperty(value="货币误差", hidden = true)
    private BigDecimal hbwc;
    @ApiModelProperty(value="其他应收", hidden = true)
    private BigDecimal qtys;
    @ApiModelProperty(value="帐户类别 | 与MS_ZHLB中CODE关联", hidden = true)
    private Integer zhlb;
    @ApiModelProperty(value="就诊结束", hidden = true)
    private Boolean jzjs;
    @ApiModelProperty(value="诊断结果", hidden = true)
    private Integer zdjg;
    @ApiModelProperty(value="退号标志 | 0.正常挂号 1.退号 2.废号(因修改当前就诊号产生)", hidden = true)
    private Boolean thbz;
    @ApiModelProperty(value="操作工号", hidden = true)
    private String czgh;
    @ApiModelProperty(value="结帐日期 | 收费员个人结帐时间 表示该发票是否结帐", hidden = true)
    private Timestamp jzrq;
    @ApiModelProperty(value="汇总日期 | 收费处每日汇总时间，每日只能汇总一次", hidden = true)
    private Timestamp hzrq;
    @ApiModelProperty(value="初诊判别 | 1.初诊  该病人(MZHM或ID)的第一条挂号信息 0.非初诊", hidden = true)
    private Integer czpb;
    @ApiModelProperty(value="就诊号码 | 外部标识该次就诊的挂号信息", hidden = true)
    private String jzhm;
    @ApiModelProperty(value="门诊类别 | 0.门诊挂号 1.急诊挂号", hidden = true)
    private Integer mzlb;
    @ApiModelProperty(value="预约标志", hidden = true)
    private Boolean yybz;
    @ApiModelProperty(value="医生判别", hidden = true)
    private Boolean yspb;
    @ApiModelProperty(value="导诊识别 | 导诊识别标志,0表示导诊台未处理,1表示导诊台已经处理", hidden = true)
    private Boolean dzsb;
    @ApiModelProperty(value="收费方式", hidden = true)
    private Boolean sffs;
    @ApiModelProperty(value="就诊状态 | 0.挂号 1.就诊中 2.暂挂 9.就诊结束", hidden = true)
    private Boolean jzzt;
    @ApiModelProperty(value="移动挂号判别 | 0为移动挂号 其他为BS挂号", hidden = true)
    private String ydgh;
    @ApiModelProperty(value="诊断序号", hidden = true)
    private Integer zdxh;
    @ApiModelProperty(value="zhbz", hidden = true)
    private String zhbz;
    @ApiModelProperty(value="dbxm", hidden = true)
    private String dbxm;
    @ApiModelProperty(value="fjddffj", hidden = true)
    private BigDecimal fjddffj;
    @ApiModelProperty(value="tcdtc", hidden = true)
    private BigDecimal tcdtc;
    @ApiModelProperty(value="zfdlnzh", hidden = true)
    private BigDecimal zfdlnzh;
    @ApiModelProperty(value="zfddnzh", hidden = true)
    private BigDecimal zfddnzh;
    @ApiModelProperty(value="排队序号  序号最大值+1", hidden = true)
    private BigDecimal pdxh;
    @ApiModelProperty(value="当前序号  序号最大值", hidden = true)
    private BigDecimal dqxh;
    @ApiModelProperty(value="等待次数  当前最大值-老系统PD_JHLB中的PDXH最大值", hidden = true)
    private BigDecimal ddcs;
    @ApiModelProperty(value="预约序号（预约网同步过来），默认1", hidden = true)
    private BigDecimal yyxh;
    @ApiModelProperty(value="czsj", hidden = true)
    private Timestamp czsj;
    @ApiModelProperty(value="jkzsb", hidden = true)
    private Boolean jkzsb;
    @ApiModelProperty(value="登记ID", hidden = true)
    private String ghid;
    @ApiModelProperty(value="报销金额", hidden = true)
    private String bxje;
    @ApiModelProperty(value="农合编号", hidden = true)
    private String nhbh;
    @ApiModelProperty(value="农合报销ID", hidden = true)
    private String nhbxid;
    @ApiModelProperty(value="农合报销日期", hidden = true)
    private String nhbxrq;
    @ApiModelProperty(value="诊室ID", hidden = true)
    private String zsid;
    @ApiModelProperty(value="叫号号码", hidden = true)
    private String jhhm;
    @ApiModelProperty(value="业务类型(1：窗口挂号；2：窗口免挂；3：自助机挂号)", hidden = true)
    private Integer ywlx;
    @ApiModelProperty(value="转科标志(1是,0否)", hidden = true)
    private Boolean zkbz;
    @ApiModelProperty(value="排队(优先)号码", hidden = true)
    private String pdhm;
    @ApiModelProperty(value="hzys", hidden = true)
    private String hzys;
    @ApiModelProperty(value="真实发票号码", hidden = true)
    private String zsfphm;
    @ApiModelProperty(value="减免金额", hidden = true)
    private BigDecimal jmje;
    @ApiModelProperty(value="挂号类型（2:急诊）", hidden = true)
    private Integer ghlx;
    @ApiModelProperty(value="binvcode", hidden = true)
    private String binvcode;
    @ApiModelProperty(value="binvnr", hidden = true)
    private String binvnr;
    @ApiModelProperty(value="医保返回记录册号", hidden = true)
    private String jlch;
    @ApiModelProperty(value="行政区域代码", hidden = true)
    private String xzqhdm;
    @ApiModelProperty(value="大病标志 1  大病", hidden = true)
    private String dbbz;
    @ApiModelProperty(value="大病编码，大病诊断编码", hidden = true)
    private String dbbm;
    @ApiModelProperty(value="挂账单位名称:限支付方式为挂账时，录入的备注信息", hidden = true)
    private String gzdwmc;

    public String getNowDateEnd() {
        return nowDateEnd;
    }

    public void setNowDateEnd(String nowDateEnd) {
        this.nowDateEnd = nowDateEnd;
    }

    /**
     * 设置:识别序号 | 唯一标示一次挂号的序号
     */
    public void setSbxh(Integer value) {
        this.sbxh = value;
    }
    /**
     * 获取:识别序号 | 唯一标示一次挂号的序号
     */
    public Integer getSbxh() {
        return sbxh;
    }
    /**
     * 设置:机构代码
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:机构代码
     */
    public Integer getJgid() {
        return jgid;
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
     * 设置:病人性质
     */
    public void setBrxz(Integer value) {
        this.brxz = value;
    }
    /**
     * 获取:病人性质
     */
    public Integer getBrxz() {
        return brxz;
    }
    /**
     * 设置:挂号时间
     */
    public void setGhsj(Timestamp value) {
        this.ghsj = value;
    }
    /**
     * 获取:挂号时间
     */
    public Timestamp getGhsj() {
        return ghsj;
    }
    /**
     * 设置:挂号类别 | 与GY_DMZD (DMLB = 25)关联
     */
    public void setGhlb(Integer value) {
        this.ghlb = value;
    }
    /**
     * 获取:挂号类别 | 与GY_DMZD (DMLB = 25)关联
     */
    public Integer getGhlb() {
        return ghlb;
    }

    public Integer getGhks() {
        return ghks;
    }

    public void setGhks(Integer ghks) {
        this.ghks = ghks;
    }

    /**
     * 设置:医生代码 | 若所挂科室为专家科室，则该代码为专家医生代码，否则为空
     */
    public void setYsdm(Integer value) {
        this.ysdm = value;
    }
    /**
     * 获取:医生代码 | 若所挂科室为专家科室，则该代码为专家医生代码，否则为空
     */
    public Integer getYsdm() {
        return ysdm;
    }
    /**
     * 设置:接诊医生 | 该字段院长查询使用，用于按医生统计挂号人数，导数据时根据处方、检查单及发票将医生写入到该字段中
     */
    public void setJzys(String value) {
        this.jzys = value;
    }
    /**
     * 获取:接诊医生 | 该字段院长查询使用，用于按医生统计挂号人数，导数据时根据处方、检查单及发票将医生写入到该字段中
     */
    public String getJzys() {
        return jzys;
    }
    /**
     * 设置:就诊序号 | 表明病人所挂的号为该科室(或该专家)当天挂号的排位序号
     */
    public void setJzxh(Integer value) {
        this.jzxh = value;
    }
    /**
     * 获取:就诊序号 | 表明病人所挂的号为该科室(或该专家)当天挂号的排位序号
     */
    public Integer getJzxh() {
        return jzxh;
    }
    /**
     * 设置:挂号次数 | 该条挂号信息挂该科室挂了几个号，现指定为1
     */
    public void setGhcs(Integer value) {
        this.ghcs = value;
    }
    /**
     * 获取:挂号次数 | 该条挂号信息挂该科室挂了几个号，现指定为1
     */
    public Integer getGhcs() {
        return ghcs;
    }
    /**
     * 设置:挂号金额 | 挂号金额、诊疗金额、专家费用、病历金额、该四项金额为总计部分，而非自负部分，前三项需在系统参数中设置对应的收费项目
     */
    public void setGhje(BigDecimal value) {
        this.ghje = value;
    }
    /**
     * 获取:挂号金额 | 挂号金额、诊疗金额、专家费用、病历金额、该四项金额为总计部分，而非自负部分，前三项需在系统参数中设置对应的收费项目
     */
    public BigDecimal getGhje() {
        return ghje;
    }
    /**
     * 设置:诊疗金额
     */
    public void setZlje(BigDecimal value) {
        this.zlje = value;
    }
    /**
     * 获取:诊疗金额
     */
    public BigDecimal getZlje() {
        return zlje;
    }
    /**
     * 设置:专家费用
     */
    public void setZjfy(BigDecimal value) {
        this.zjfy = value;
    }
    /**
     * 获取:专家费用
     */
    public BigDecimal getZjfy() {
        return zjfy;
    }
    /**
     * 设置:病历金额
     */
    public void setBlje(BigDecimal value) {
        this.blje = value;
    }
    /**
     * 获取:病历金额
     */
    public BigDecimal getBlje() {
        return blje;
    }
    /**
     * 设置:现金金额 | 若挂号金额+诊疗金额专+家费用+病历金额 = 现金金额+支票金额+帐户金额+货币误差+其它应收
     */
    public void setXjje(BigDecimal value) {
        this.xjje = value;
    }
    /**
     * 获取:现金金额 | 若挂号金额+诊疗金额专+家费用+病历金额 = 现金金额+支票金额+帐户金额+货币误差+其它应收
     */
    public BigDecimal getXjje() {
        return xjje;
    }
    /**
     * 设置:支票金额
     */
    public void setZpje(BigDecimal value) {
        this.zpje = value;
    }
    /**
     * 获取:支票金额
     */
    public BigDecimal getZpje() {
        return zpje;
    }
    /**
     * 设置:帐户金额
     */
    public void setZhje(BigDecimal value) {
        this.zhje = value;
    }
    /**
     * 获取:帐户金额
     */
    public BigDecimal getZhje() {
        return zhje;
    }
    /**
     * 设置:货币误差
     */
    public void setHbwc(BigDecimal value) {
        this.hbwc = value;
    }
    /**
     * 获取:货币误差
     */
    public BigDecimal getHbwc() {
        return hbwc;
    }
    /**
     * 设置:其他应收
     */
    public void setQtys(BigDecimal value) {
        this.qtys = value;
    }
    /**
     * 获取:其他应收
     */
    public BigDecimal getQtys() {
        return qtys;
    }
    /**
     * 设置:帐户类别 | 与MS_ZHLB中CODE关联
     */
    public void setZhlb(Integer value) {
        this.zhlb = value;
    }
    /**
     * 获取:帐户类别 | 与MS_ZHLB中CODE关联
     */
    public Integer getZhlb() {
        return zhlb;
    }
    /**
     * 设置:就诊结束
     */
    public void setJzjs(Boolean value) {
        this.jzjs = value;
    }
    /**
     * 获取:就诊结束
     */
    public Boolean getJzjs() {
        return jzjs;
    }
    /**
     * 设置:诊断结果
     */
    public void setZdjg(Integer value) {
        this.zdjg = value;
    }
    /**
     * 获取:诊断结果
     */
    public Integer getZdjg() {
        return zdjg;
    }
    /**
     * 设置:退号标志 | 0.正常挂号 1.退号 2.废号(因修改当前就诊号产生)
     */
    public void setThbz(Boolean value) {
        this.thbz = value;
    }
    /**
     * 获取:退号标志 | 0.正常挂号 1.退号 2.废号(因修改当前就诊号产生)
     */
    public Boolean getThbz() {
        return thbz;
    }
    /**
     * 设置:操作工号
     */
    public void setCzgh(String value) {
        this.czgh = value;
    }
    /**
     * 获取:操作工号
     */
    public String getCzgh() {
        return czgh;
    }
    /**
     * 设置:结帐日期 | 收费员个人结帐时间 表示该发票是否结帐
     */
    public void setJzrq(Timestamp value) {
        this.jzrq = value;
    }
    /**
     * 获取:结帐日期 | 收费员个人结帐时间 表示该发票是否结帐
     */
    public Timestamp getJzrq() {
        return jzrq;
    }
    /**
     * 设置:汇总日期 | 收费处每日汇总时间，每日只能汇总一次
     */
    public void setHzrq(Timestamp value) {
        this.hzrq = value;
    }
    /**
     * 获取:汇总日期 | 收费处每日汇总时间，每日只能汇总一次
     */
    public Timestamp getHzrq() {
        return hzrq;
    }
    /**
     * 设置:初诊判别 | 1.初诊  该病人(MZHM或ID)的第一条挂号信息 0.非初诊
     */
    public void setCzpb(Integer value) {
        this.czpb = value;
    }
    /**
     * 获取:初诊判别 | 1.初诊  该病人(MZHM或ID)的第一条挂号信息 0.非初诊
     */
    public Integer getCzpb() {
        return czpb;
    }
    /**
     * 设置:就诊号码 | 外部标识该次就诊的挂号信息
     */
    public void setJzhm(String value) {
        this.jzhm = value;
    }
    /**
     * 获取:就诊号码 | 外部标识该次就诊的挂号信息
     */
    public String getJzhm() {
        return jzhm;
    }
    /**
     * 设置:门诊类别 | 0.门诊挂号 1.急诊挂号
     */
    public void setMzlb(Integer value) {
        this.mzlb = value;
    }
    /**
     * 获取:门诊类别 | 0.门诊挂号 1.急诊挂号
     */
    public Integer getMzlb() {
        return mzlb;
    }
    /**
     * 设置:预约标志
     */
    public void setYybz(Boolean value) {
        this.yybz = value;
    }
    /**
     * 获取:预约标志
     */
    public Boolean getYybz() {
        return yybz;
    }
    /**
     * 设置:医生判别
     */
    public void setYspb(Boolean value) {
        this.yspb = value;
    }
    /**
     * 获取:医生判别
     */
    public Boolean getYspb() {
        return yspb;
    }
    /**
     * 设置:导诊识别 | 导诊识别标志,0表示导诊台未处理,1表示导诊台已经处理
     */
    public void setDzsb(Boolean value) {
        this.dzsb = value;
    }
    /**
     * 获取:导诊识别 | 导诊识别标志,0表示导诊台未处理,1表示导诊台已经处理
     */
    public Boolean getDzsb() {
        return dzsb;
    }
    /**
     * 设置:收费方式
     */
    public void setSffs(Boolean value) {
        this.sffs = value;
    }
    /**
     * 获取:收费方式
     */
    public Boolean getSffs() {
        return sffs;
    }
    /**
     * 设置:就诊状态 | 0.挂号 1.就诊中 2.暂挂 9.就诊结束
     */
    public void setJzzt(Boolean value) {
        this.jzzt = value;
    }
    /**
     * 获取:就诊状态 | 0.挂号 1.就诊中 2.暂挂 9.就诊结束
     */
    public Boolean getJzzt() {
        return jzzt;
    }
    /**
     * 设置:移动挂号判别 | 0为移动挂号 其他为BS挂号
     */
    public void setYdgh(String value) {
        this.ydgh = value;
    }
    /**
     * 获取:移动挂号判别 | 0为移动挂号 其他为BS挂号
     */
    public String getYdgh() {
        return ydgh;
    }
    /**
     * 设置:诊断序号
     */
    public void setZdxh(Integer value) {
        this.zdxh = value;
    }
    /**
     * 获取:诊断序号
     */
    public Integer getZdxh() {
        return zdxh;
    }
    /**
     * 设置:zhbz
     */
    public void setZhbz(String value) {
        this.zhbz = value;
    }
    /**
     * 获取:zhbz
     */
    public String getZhbz() {
        return zhbz;
    }
    /**
     * 设置:dbxm
     */
    public void setDbxm(String value) {
        this.dbxm = value;
    }
    /**
     * 获取:dbxm
     */
    public String getDbxm() {
        return dbxm;
    }
    /**
     * 设置:fjddffj
     */
    public void setFjddffj(BigDecimal value) {
        this.fjddffj = value;
    }
    /**
     * 获取:fjddffj
     */
    public BigDecimal getFjddffj() {
        return fjddffj;
    }
    /**
     * 设置:tcdtc
     */
    public void setTcdtc(BigDecimal value) {
        this.tcdtc = value;
    }
    /**
     * 获取:tcdtc
     */
    public BigDecimal getTcdtc() {
        return tcdtc;
    }
    /**
     * 设置:zfdlnzh
     */
    public void setZfdlnzh(BigDecimal value) {
        this.zfdlnzh = value;
    }
    /**
     * 获取:zfdlnzh
     */
    public BigDecimal getZfdlnzh() {
        return zfdlnzh;
    }
    /**
     * 设置:zfddnzh
     */
    public void setZfddnzh(BigDecimal value) {
        this.zfddnzh = value;
    }
    /**
     * 获取:zfddnzh
     */
    public BigDecimal getZfddnzh() {
        return zfddnzh;
    }
    /**
     * 设置:排队序号  序号最大值+1
     */
    public void setPdxh(BigDecimal value) {
        this.pdxh = value;
    }
    /**
     * 获取:排队序号  序号最大值+1
     */
    public BigDecimal getPdxh() {
        return pdxh;
    }
    /**
     * 设置:当前序号  序号最大值
     */
    public void setDqxh(BigDecimal value) {
        this.dqxh = value;
    }
    /**
     * 获取:当前序号  序号最大值
     */
    public BigDecimal getDqxh() {
        return dqxh;
    }
    /**
     * 设置:等待次数  当前最大值-老系统PD_JHLB中的PDXH最大值
     */
    public void setDdcs(BigDecimal value) {
        this.ddcs = value;
    }
    /**
     * 获取:等待次数  当前最大值-老系统PD_JHLB中的PDXH最大值
     */
    public BigDecimal getDdcs() {
        return ddcs;
    }
    /**
     * 设置:预约序号（预约网同步过来），默认1
     */
    public void setYyxh(BigDecimal value) {
        this.yyxh = value;
    }
    /**
     * 获取:预约序号（预约网同步过来），默认1
     */
    public BigDecimal getYyxh() {
        return yyxh;
    }
    /**
     * 设置:czsj
     */
    public void setCzsj(Timestamp value) {
        this.czsj = value;
    }
    /**
     * 获取:czsj
     */
    public Timestamp getCzsj() {
        return czsj;
    }
    /**
     * 设置:jkzsb
     */
    public void setJkzsb(Boolean value) {
        this.jkzsb = value;
    }
    /**
     * 获取:jkzsb
     */
    public Boolean getJkzsb() {
        return jkzsb;
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
     * 设置:登记ID
     */
    public void setGhid(String value) {
        this.ghid = value;
    }
    /**
     * 获取:登记ID
     */
    public String getGhid() {
        return ghid;
    }
    /**
     * 设置:报销金额
     */
    public void setBxje(String value) {
        this.bxje = value;
    }
    /**
     * 获取:报销金额
     */
    public String getBxje() {
        return bxje;
    }
    /**
     * 设置:农合编号
     */
    public void setNhbh(String value) {
        this.nhbh = value;
    }
    /**
     * 获取:农合编号
     */
    public String getNhbh() {
        return nhbh;
    }
    /**
     * 设置:农合报销ID
     */
    public void setNhbxid(String value) {
        this.nhbxid = value;
    }
    /**
     * 获取:农合报销ID
     */
    public String getNhbxid() {
        return nhbxid;
    }
    /**
     * 设置:农合报销日期
     */
    public void setNhbxrq(String value) {
        this.nhbxrq = value;
    }
    /**
     * 获取:农合报销日期
     */
    public String getNhbxrq() {
        return nhbxrq;
    }
    /**
     * 设置:诊室ID
     */
    public void setZsid(String value) {
        this.zsid = value;
    }
    /**
     * 获取:诊室ID
     */
    public String getZsid() {
        return zsid;
    }
    /**
     * 设置:叫号号码
     */
    public void setJhhm(String value) {
        this.jhhm = value;
    }
    /**
     * 获取:叫号号码
     */
    public String getJhhm() {
        return jhhm;
    }
    /**
     * 设置:业务类型(1：窗口挂号；2：窗口免挂；3：自助机挂号)
     */
    public void setYwlx(Integer value) {
        this.ywlx = value;
    }
    /**
     * 获取:业务类型(1：窗口挂号；2：窗口免挂；3：自助机挂号)
     */
    public Integer getYwlx() {
        return ywlx;
    }
    /**
     * 设置:转科标志(1是,0否)
     */
    public void setZkbz(Boolean value) {
        this.zkbz = value;
    }
    /**
     * 获取:转科标志(1是,0否)
     */
    public Boolean getZkbz() {
        return zkbz;
    }
    /**
     * 设置:排队(优先)号码
     */
    public void setPdhm(String value) {
        this.pdhm = value;
    }
    /**
     * 获取:排队(优先)号码
     */
    public String getPdhm() {
        return pdhm;
    }
    /**
     * 设置:hzys
     */
    public void setHzys(String value) {
        this.hzys = value;
    }
    /**
     * 获取:hzys
     */
    public String getHzys() {
        return hzys;
    }
    /**
     * 设置:真实发票号码
     */
    public void setZsfphm(String value) {
        this.zsfphm = value;
    }
    /**
     * 获取:真实发票号码
     */
    public String getZsfphm() {
        return zsfphm;
    }
    /**
     * 设置:减免金额
     */
    public void setJmje(BigDecimal value) {
        this.jmje = value;
    }
    /**
     * 获取:减免金额
     */
    public BigDecimal getJmje() {
        return jmje;
    }
    /**
     * 设置:挂号类型（2:急诊）
     */
    public void setGhlx(Integer value) {
        this.ghlx = value;
    }
    /**
     * 获取:挂号类型（2:急诊）
     */
    public Integer getGhlx() {
        return ghlx;
    }
    /**
     * 设置:binvcode
     */
    public void setBinvcode(String value) {
        this.binvcode = value;
    }
    /**
     * 获取:binvcode
     */
    public String getBinvcode() {
        return binvcode;
    }
    /**
     * 设置:binvnr
     */
    public void setBinvnr(String value) {
        this.binvnr = value;
    }
    /**
     * 获取:binvnr
     */
    public String getBinvnr() {
        return binvnr;
    }
    /**
     * 设置:医保返回记录册号
     */
    public void setJlch(String value) {
        this.jlch = value;
    }
    /**
     * 获取:医保返回记录册号
     */
    public String getJlch() {
        return jlch;
    }
    /**
     * 设置:行政区域代码
     */
    public void setXzqhdm(String value) {
        this.xzqhdm = value;
    }
    /**
     * 获取:行政区域代码
     */
    public String getXzqhdm() {
        return xzqhdm;
    }
    /**
     * 设置:大病标志 1  大病
     */
    public void setDbbz(String value) {
        this.dbbz = value;
    }
    /**
     * 获取:大病标志 1  大病
     */
    public String getDbbz() {
        return dbbz;
    }
    /**
     * 设置:大病编码，大病诊断编码
     */
    public void setDbbm(String value) {
        this.dbbm = value;
    }
    /**
     * 获取:大病编码，大病诊断编码
     */
    public String getDbbm() {
        return dbbm;
    }
    /**
     * 设置:挂账单位名称:限支付方式为挂账时，录入的备注信息
     */
    public void setGzdwmc(String value) {
        this.gzdwmc = value;
    }
    /**
     * 获取:挂账单位名称:限支付方式为挂账时，录入的备注信息
     */
    public String getGzdwmc() {
        return gzdwmc;
    }

    public String getNowDate() {
        return nowDate;
    }

    public void setNowDate(String nowDate) {
        this.nowDate = nowDate;
    }

    public Integer getPatientType() {
        return patientType;
    }

    public void setPatientType(Integer patientType) {
        this.patientType = patientType;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public String getHzxm() {
        return hzxm;
    }

    public void setHzxm(String hzxm) {
        this.hzxm = hzxm;
    }
}
