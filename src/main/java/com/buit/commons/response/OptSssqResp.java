
package com.buit.commons.response;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OptSssq<br>
 * 类描述：手术申请<br>
 * @author 老花生
 */
@ApiModel(value="手术申请")
public class OptSssqResp  extends  PageQuery{
    @ApiModelProperty(value="申请单号")
    private Integer sqdh;
    @ApiModelProperty(value="机构ID")
    private Integer jgid;
    @ApiModelProperty(value="门诊号码")
    private String mzhm;
    @ApiModelProperty(value="手术科室")
    private Integer ssks;
    @ApiModelProperty(value="申请科室")
    private Integer sqks;
    @ApiModelProperty(value="申请医师")
    private String sqys;
    @ApiModelProperty(value="申请日期")
    private Timestamp sqrq;
    @ApiModelProperty(value="手术日期")
    private Timestamp ssrq;
    @ApiModelProperty(value="手术内码")
    private Integer ssnm;
    @ApiModelProperty(value="手术医师")
    private String ssys;
    @ApiModelProperty(value="手术一助")
    private String ssyz;
    @ApiModelProperty(value="手术二助")
    private String ssez;
    @ApiModelProperty(value="手术三助")
    private String sssz;
    @ApiModelProperty(value="麻醉代码")
    private Integer mzdm;
    @ApiModelProperty(value="麻醉医师")
    private String mzys;
    @ApiModelProperty(value="操作工号")
    private String czgh;
    @ApiModelProperty(value="拟手术名称")
    private String nssmc;
    @ApiModelProperty(value="手术等级")
    private Integer ssjb;
    @ApiModelProperty(value="手术备注")
    private String ssbz;
    @ApiModelProperty(value="上级医生")
    private String sjys;
    @ApiModelProperty(value="住院号码")
    private String zyhm;
    @ApiModelProperty(value="病人ID")
    private Integer brid;
    @ApiModelProperty(value="术前诊断")
    private String sqzd;
    @ApiModelProperty(value="病人科室")
    private Integer brks;
    @ApiModelProperty(value="申请类型")
    private Integer sqlx;
    @ApiModelProperty(value="住院号")
    private Integer zyh;
    @ApiModelProperty(value="费用序号")
    private Integer fyxh;
    @ApiModelProperty(value="麻醉名称")
    private String mzmc;
    @ApiModelProperty(value="手术名称")
    private String ssmc;
    /**
     * 设置:申请单号
     */
    public void setSqdh(Integer value) {
        this.sqdh = value;
    }
    /**
     * 获取:申请单号
     */
    public Integer getSqdh() {
        return sqdh;
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
     * 设置:门诊号码
     */
    public void setMzhm(String value) {
        this.mzhm = value;
    }
    /**
     * 获取:门诊号码
     */
    public String getMzhm() {
        return mzhm;
    }
    /**
     * 设置:手术科室
     */
    public void setSsks(Integer value) {
        this.ssks = value;
    }
    /**
     * 获取:手术科室
     */
    public Integer getSsks() {
        return ssks;
    }
    /**
     * 设置:申请科室
     */
    public void setSqks(Integer value) {
        this.sqks = value;
    }
    /**
     * 获取:申请科室
     */
    public Integer getSqks() {
        return sqks;
    }
    /**
     * 设置:申请医师
     */
    public void setSqys(String value) {
        this.sqys = value;
    }
    /**
     * 获取:申请医师
     */
    public String getSqys() {
        return sqys;
    }
    /**
     * 设置:申请日期
     */
    public void setSqrq(Timestamp value) {
        this.sqrq = value;
    }
    /**
     * 获取:申请日期
     */
    public Timestamp getSqrq() {
        return sqrq;
    }
    /**
     * 设置:手术日期
     */
    public void setSsrq(Timestamp value) {
        this.ssrq = value;
    }
    /**
     * 获取:手术日期
     */
    public Timestamp getSsrq() {
        return ssrq;
    }
    /**
     * 设置:手术内码
     */
    public void setSsnm(Integer value) {
        this.ssnm = value;
    }
    /**
     * 获取:手术内码
     */
    public Integer getSsnm() {
        return ssnm;
    }
    /**
     * 设置:手术医师
     */
    public void setSsys(String value) {
        this.ssys = value;
    }
    /**
     * 获取:手术医师
     */
    public String getSsys() {
        return ssys;
    }
    /**
     * 设置:手术一助
     */
    public void setSsyz(String value) {
        this.ssyz = value;
    }
    /**
     * 获取:手术一助
     */
    public String getSsyz() {
        return ssyz;
    }
    /**
     * 设置:手术二助
     */
    public void setSsez(String value) {
        this.ssez = value;
    }
    /**
     * 获取:手术二助
     */
    public String getSsez() {
        return ssez;
    }
    /**
     * 设置:手术三助
     */
    public void setSssz(String value) {
        this.sssz = value;
    }
    /**
     * 获取:手术三助
     */
    public String getSssz() {
        return sssz;
    }
    /**
     * 设置:麻醉代码
     */
    public void setMzdm(Integer value) {
        this.mzdm = value;
    }
    /**
     * 获取:麻醉代码
     */
    public Integer getMzdm() {
        return mzdm;
    }
    /**
     * 设置:麻醉医师
     */
    public void setMzys(String value) {
        this.mzys = value;
    }
    /**
     * 获取:麻醉医师
     */
    public String getMzys() {
        return mzys;
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
     * 设置:拟手术名称
     */
    public void setNssmc(String value) {
        this.nssmc = value;
    }
    /**
     * 获取:拟手术名称
     */
    public String getNssmc() {
        return nssmc;
    }
    /**
     * 设置:手术等级
     */
    public void setSsjb(Integer value) {
        this.ssjb = value;
    }
    /**
     * 获取:手术等级
     */
    public Integer getSsjb() {
        return ssjb;
    }
    /**
     * 设置:手术备注
     */
    public void setSsbz(String value) {
        this.ssbz = value;
    }
    /**
     * 获取:手术备注
     */
    public String getSsbz() {
        return ssbz;
    }
    /**
     * 设置:上级医生
     */
    public void setSjys(String value) {
        this.sjys = value;
    }
    /**
     * 获取:上级医生
     */
    public String getSjys() {
        return sjys;
    }
    /**
     * 设置:住院号码
     */
    public void setZyhm(String value) {
        this.zyhm = value;
    }
    /**
     * 获取:住院号码
     */
    public String getZyhm() {
        return zyhm;
    }
    /**
     * 设置:病人ID
     */
    public void setBrid(Integer value) {
        this.brid = value;
    }
    /**
     * 获取:病人ID
     */
    public Integer getBrid() {
        return brid;
    }
    /**
     * 设置:术前诊断
     */
    public void setSqzd(String value) {
        this.sqzd = value;
    }
    /**
     * 获取:术前诊断
     */
    public String getSqzd() {
        return sqzd;
    }
    /**
     * 设置:病人科室
     */
    public void setBrks(Integer value) {
        this.brks = value;
    }
    /**
     * 获取:病人科室
     */
    public Integer getBrks() {
        return brks;
    }
    /**
     * 设置:申请类型
     */
    public void setSqlx(Integer value) {
        this.sqlx = value;
    }
    /**
     * 获取:申请类型
     */
    public Integer getSqlx() {
        return sqlx;
    }
    /**
     * 设置:住院号
     */
    public void setZyh(Integer value) {
        this.zyh = value;
    }
    /**
     * 获取:住院号
     */
    public Integer getZyh() {
        return zyh;
    }
    /**
     * 设置:费用序号
     */
    public void setFyxh(Integer value) {
        this.fyxh = value;
    }
    /**
     * 获取:费用序号
     */
    public Integer getFyxh() {
        return fyxh;
    }
    /**
     * 设置:麻醉名称
     */
    public void setMzmc(String value) {
        this.mzmc = value;
    }
    /**
     * 获取:麻醉名称
     */
    public String getMzmc() {
        return mzmc;
    }
    /**
     * 设置:手术名称
     */
    public void setSsmc(String value) {
        this.ssmc = value;
    }
    /**
     * 获取:手术名称
     */
    public String getSsmc() {
        return ssmc;
    }
}
