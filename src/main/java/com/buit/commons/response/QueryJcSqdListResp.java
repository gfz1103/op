package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName QueryJcSqdListResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/29 17:22
 */
@ApiModel(value="查询医技检查申请单列表返回")
public class QueryJcSqdListResp {

    @ApiModelProperty(value="医技序号")
    private Integer yjxh;
    @ApiModelProperty(value="申请医生")
    private String sqys;
    @ApiModelProperty(value="申请时间")
    private Timestamp sqsj;
    @ApiModelProperty(value="住院号码")
    private String zyhm;
    @ApiModelProperty(value="检查目的")
    private String jcmd;
    @ApiModelProperty(value="医技类型")
    private Integer yjlx;
    @ApiModelProperty(value="号码")
    private String hm;
    @ApiModelProperty(value="预约时间")
    private String yysj;
    @ApiModelProperty(value="检查状态")
    private Integer jczt;
    @ApiModelProperty(value="申请类型")
    private String sqlx;
    @ApiModelProperty(value="检查地点")
    private String jcdd;
    @ApiModelProperty(value="科室名称")
    private String ksmc;
    @ApiModelProperty(value="就诊序号")
    private Integer jzxh;
    @ApiModelProperty(value="预约状态")
    private Integer yyzt;
    @ApiModelProperty(value="设备名称")
    private String sbmc;
    @ApiModelProperty(value="性别")
    private Integer brxb;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="检查号")
    private String jch;
    @ApiModelProperty(value="预约时间")
    private Timestamp yyrq;
    @ApiModelProperty(value="病人姓名")
    private String jczt_text;
    @ApiModelProperty(value="病人床号")
    private String brch;
    @ApiModelProperty(value="病人id")
    private Integer brid;
    @ApiModelProperty(value="检查序号")
    private Integer jcxh;
    @ApiModelProperty(value="过敏反应")
    private String gmfy;
    @ApiModelProperty(value="检查项目")
    private String jcxm;
    @ApiModelProperty(value="检查费用")
    private BigDecimal jcfy;
    @ApiModelProperty(value="科室")
    private Integer brks;
    @ApiModelProperty(value="检查部位")
    private String jcbw;
    @ApiModelProperty(value="症状及体征")
    private String tztz;
    @ApiModelProperty(value="其他检查结果影像学及化验")
    private String qtjcjg;

    public Integer getYjxh() {
        return yjxh;
    }

    public void setYjxh(Integer yjxh) {
        this.yjxh = yjxh;
    }

    public String getSqys() {
        return sqys;
    }

    public void setSqys(String sqys) {
        this.sqys = sqys;
    }

    public Timestamp getSqsj() {
        return sqsj;
    }

    public void setSqsj(Timestamp sqsj) {
        this.sqsj = sqsj;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public String getJcmd() {
        return jcmd;
    }

    public void setJcmd(String jcmd) {
        this.jcmd = jcmd;
    }

    public Integer getYjlx() {
        return yjlx;
    }

    public void setYjlx(Integer yjlx) {
        this.yjlx = yjlx;
    }

    public String getHm() {
        return hm;
    }

    public void setHm(String hm) {
        this.hm = hm;
    }

    public String getYysj() {
        return yysj;
    }

    public void setYysj(String yysj) {
        this.yysj = yysj;
    }

    public Integer getJczt() {
        return jczt;
    }

    public void setJczt(Integer jczt) {
        this.jczt = jczt;
    }

    public String getSqlx() {
        return sqlx;
    }

    public void setSqlx(String sqlx) {
        this.sqlx = sqlx;
    }

    public String getJcdd() {
        return jcdd;
    }

    public void setJcdd(String jcdd) {
        this.jcdd = jcdd;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

    public Integer getYyzt() {
        return yyzt;
    }

    public void setYyzt(Integer yyzt) {
        this.yyzt = yyzt;
    }

    public String getSbmc() {
        return sbmc;
    }

    public void setSbmc(String sbmc) {
        this.sbmc = sbmc;
    }

    public Integer getBrxb() {
        return brxb;
    }

    public void setBrxb(Integer brxb) {
        this.brxb = brxb;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getJch() {
        return jch;
    }

    public void setJch(String jch) {
        this.jch = jch;
    }

    public Timestamp getYyrq() {
        return yyrq;
    }

    public void setYyrq(Timestamp yyrq) {
        this.yyrq = yyrq;
    }

    public String getJczt_text() {
        return jczt_text;
    }

    public void setJczt_text(String jczt_text) {
        this.jczt_text = jczt_text;
    }

    public String getBrch() {
        return brch;
    }

    public void setBrch(String brch) {
        this.brch = brch;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getJcxh() {
        return jcxh;
    }

    public void setJcxh(Integer jcxh) {
        this.jcxh = jcxh;
    }

    public String getGmfy() {
        return gmfy;
    }

    public void setGmfy(String gmfy) {
        this.gmfy = gmfy;
    }

    public String getJcxm() {
        return jcxm;
    }

    public void setJcxm(String jcxm) {
        this.jcxm = jcxm;
    }

    public BigDecimal getJcfy() {
        return jcfy;
    }

    public void setJcfy(BigDecimal jcfy) {
        this.jcfy = jcfy;
    }

    public Integer getBrks() {
        return brks;
    }

    public void setBrks(Integer brks) {
        this.brks = brks;
    }

    public String getJcbw() {
        return jcbw;
    }

    public void setJcbw(String jcbw) {
        this.jcbw = jcbw;
    }

    public String getTztz() {
        return tztz;
    }

    public void setTztz(String tztz) {
        this.tztz = tztz;
    }

    public String getQtjcjg() {
        return qtjcjg;
    }

    public void setQtjcjg(String qtjcjg) {
        this.qtjcjg = qtjcjg;
    }
}
