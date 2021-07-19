
package com.buit.commons.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;


/**
 * 类名称：OpGhmxResp<br>
 * 类描述：挂号明细表-查询返回<br>
 * @author 老花生
 */
@ApiModel(value="挂号明细表-查询返回")
public class OpGhmxResp  extends PageQuery {
    @ApiModelProperty(value="hzys")
    private String hzys;
    @ApiModelProperty(value="业务类型(1：窗口挂号；2：窗口免挂；3：自助机挂号)")
    private Integer ywlx;
    @ApiModelProperty(value="医生代码 | 若所挂科室为专家科室，则该代码为专家医生代码，否则为空")
    private String ysdm;
    @ApiModelProperty(value="排队(优先)号码")
    private String pdhm;
    @ApiModelProperty(value="预约序号（预约网同步过来），默认1")
    private BigDecimal yyxh;
    @ApiModelProperty(value="诊室ID")
    private String zsid;
    @ApiModelProperty(value="等待次数  当前最大值-老系统PD_JHLB中的PDXH最大值")
    private BigDecimal ddcs;
    @ApiModelProperty(value="病人性质")
    private Integer brxz;
    @ApiModelProperty(value="叫号号码")
    private String jhhm;
    @ApiModelProperty(value="排队序号  序号最大值+1")
    private BigDecimal pdxh;
    @ApiModelProperty(value="就诊序号 | 表明病人所挂的号为该科室(或该专家)当天挂号的排位序号")
    private Integer jzxh;
    @ApiModelProperty(value="识别序号 | 唯一标示一次挂号的序号")
    private Integer sbxh;
    @ApiModelProperty(value="机构代码")
    private Integer jgid;
    @ApiModelProperty(value="病人ID号")
    private Integer brid;
    @ApiModelProperty(value="就诊号码 | 外部标识该次就诊的挂号信息")
    private String jzhm;
    @ApiModelProperty(value="挂号时间")
    private Timestamp ghsj;
    @ApiModelProperty(value="接诊医生 | 该字段院长查询使用，用于按医生统计挂号人数，导数据时根据处方、检查单及发票将医生写入到该字段中")
    private String jzys;
    @ApiModelProperty(value="就诊卡号")
    private String jzkh;
    @ApiModelProperty(value="当前序号  序号最大值")
    private BigDecimal dqxh;
    @ApiModelProperty(value="医保返回记录册号")
    private String jlch;
    @ApiModelProperty(value="出生年月")
    private Date csny;
    @ApiModelProperty(value="年龄")
    private String nl;
    @ApiModelProperty(value="EMPI | 对应mpi_demographicinfo表中的empiId字段 个人唯一索引")
    private String empiid;
    @ApiModelProperty(value="门诊号码 | 唯一一处记载病人门诊号码的地方，在程序中用于刷卡登记或查询相关记录使用")
    private String mzhm;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="病人性别 | GB/T 2261.1-2003 与gender.xml字典关联")
    private String brxb;
    @ApiModelProperty(value="挂号类型 0：人工挂号、1：自助挂号")
    private String ghtype;
    @ApiModelProperty(value="就诊状态 | 0.挂号 1.就诊中 2.暂挂 9.就诊结束")
    private Integer jzzt;
    @ApiModelProperty(value="身份证号")
    private String sfzh;
    @ApiModelProperty(value="联系人")
    private String lxrm;
    @ApiModelProperty(value="联系地址")
    private String lxdz;
    @ApiModelProperty(value="联系电话")
    private String lxdh;
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;
    @ApiModelProperty(value="皮试结果 1.敏")
    private String sfgm;
    @ApiModelProperty(value="联系人关系")
    private Integer lxgx;

    public Integer getLxgx() {
        return lxgx;
    }

    public void setLxgx(Integer lxgx) {
        this.lxgx = lxgx;
    }

    public String getSfgm() {
        return sfgm;
    }

    public void setSfgm(String sfgm) {
        this.sfgm = sfgm;
    }

    public String getHzys() {
        return hzys;
    }

    public void setHzys(String hzys) {
        this.hzys = hzys;
    }

    public Integer getYwlx() {
        return ywlx;
    }

    public void setYwlx(Integer ywlx) {
        this.ywlx = ywlx;
    }

    public String getYsdm() {
        return ysdm;
    }

    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }

    public String getPdhm() {
        return pdhm;
    }

    public void setPdhm(String pdhm) {
        this.pdhm = pdhm;
    }

    public BigDecimal getYyxh() {
        return yyxh;
    }

    public void setYyxh(BigDecimal yyxh) {
        this.yyxh = yyxh;
    }

    public String getZsid() {
        return zsid;
    }

    public void setZsid(String zsid) {
        this.zsid = zsid;
    }

    public BigDecimal getDdcs() {
        return ddcs;
    }

    public void setDdcs(BigDecimal ddcs) {
        this.ddcs = ddcs;
    }

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }

    public String getJhhm() {
        return jhhm;
    }

    public void setJhhm(String jhhm) {
        this.jhhm = jhhm;
    }

    public BigDecimal getPdxh() {
        return pdxh;
    }

    public void setPdxh(BigDecimal pdxh) {
        this.pdxh = pdxh;
    }

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

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

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public String getJzhm() {
        return jzhm;
    }

    public void setJzhm(String jzhm) {
        this.jzhm = jzhm;
    }

    public Timestamp getGhsj() {
        return ghsj;
    }

    public void setGhsj(Timestamp ghsj) {
        this.ghsj = ghsj;
    }

    public String getJzys() {
        return jzys;
    }

    public void setJzys(String jzys) {
        this.jzys = jzys;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public BigDecimal getDqxh() {
        return dqxh;
    }

    public void setDqxh(BigDecimal dqxh) {
        this.dqxh = dqxh;
    }

    public String getJlch() {
        return jlch;
    }

    public void setJlch(String jlch) {
        this.jlch = jlch;
    }

    public Date getCsny() {
        return csny;
    }

    public void setCsny(Date csny) {
        this.csny = csny;
    }

    public String getEmpiid() {
        return empiid;
    }

    public void setEmpiid(String empiid) {
        this.empiid = empiid;
    }

    public String getMzhm() {
        return mzhm;
    }

    public void setMzhm(String mzhm) {
        this.mzhm = mzhm;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getBrxb() {
        return brxb;
    }

    public void setBrxb(String brxb) {
        this.brxb = brxb;
    }

    public String getGhtype() {
        return ghtype;
    }

    public void setGhtype(String ghtype) {
        this.ghtype = ghtype;
    }

    public Integer getJzzt() {
        return jzzt;
    }

    public void setJzzt(Integer jzzt) {
        this.jzzt = jzzt;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getLxrm() {
        return lxrm;
    }

    public void setLxrm(String lxrm) {
        this.lxrm = lxrm;
    }

    public String getLxdz() {
        return lxdz;
    }

    public void setLxdz(String lxdz) {
        this.lxdz = lxdz;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }
}
