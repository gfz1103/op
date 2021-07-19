
package com.buit.commons.response;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OptSssqPageResp<br>
 * 类描述：手术申请-分页查询返回<br>
 * @author 老花生
 */
@ApiModel(value="手术申请-分页查询返回")
public class OptSssqPageResp extends  PageQuery{

    @ApiModelProperty(value="麻醉医师")
    private String mzys;
    @ApiModelProperty(value="申请医师")
    private String sqys;
    @ApiModelProperty(value="术前诊断")
    private String sqzd;
    @ApiModelProperty(value="麻醉代码")
    private Integer mzdm;
    @ApiModelProperty(value="门诊号码")
    private String mzhm;
    @ApiModelProperty(value="手术医师")
    private String ssys;
    @ApiModelProperty(value="手术等级")
    private Integer ssjb;
    @ApiModelProperty(value="病人性别 | GB/T 2261.1-2003 与gender.xml字典关联")
    private Integer brxb;
    @ApiModelProperty(value="麻醉名称")
    private String mzmc;
    @ApiModelProperty(value="手术二助")
    private String ssez;
    @ApiModelProperty(value="手术日期")
    private Timestamp ssrq;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="病人年龄")
    private int brnn;
    @ApiModelProperty(value="手术备注")
    private String ssbz;
    @ApiModelProperty(value="手术内码")
    private String ssnm;
    @ApiModelProperty(value="申请日期")
    private Timestamp sqrq;
    @ApiModelProperty(value="手术一助")
    private String ssyz;
    @ApiModelProperty(value="上级医生")
    private String sjys;
    @ApiModelProperty(value="病人科室")
    private Integer brks;
    @ApiModelProperty(value="手术三助")
    private String sssz;
    @ApiModelProperty(value="申请单号")
    private Integer sqdh;

    public String getMzys() {
        return mzys;
    }

    public void setMzys(String mzys) {
        this.mzys = mzys;
    }

    public String getSqys() {
        return sqys;
    }

    public void setSqys(String sqys) {
        this.sqys = sqys;
    }

    public String getSqzd() {
        return sqzd;
    }

    public void setSqzd(String sqzd) {
        this.sqzd = sqzd;
    }

    public Integer getMzdm() {
        return mzdm;
    }

    public void setMzdm(Integer mzdm) {
        this.mzdm = mzdm;
    }

    public String getMzhm() {
        return mzhm;
    }

    public void setMzhm(String mzhm) {
        this.mzhm = mzhm;
    }

    public String getSsys() {
        return ssys;
    }

    public void setSsys(String ssys) {
        this.ssys = ssys;
    }

    public Integer getSsjb() {
        return ssjb;
    }

    public void setSsjb(Integer ssjb) {
        this.ssjb = ssjb;
    }

    public Integer getBrxb() {
        return brxb;
    }

    public void setBrxb(Integer brxb) {
        this.brxb = brxb;
    }

    public String getMzmc() {
        return mzmc;
    }

    public void setMzmc(String mzmc) {
        this.mzmc = mzmc;
    }

    public String getSsez() {
        return ssez;
    }

    public void setSsez(String ssez) {
        this.ssez = ssez;
    }

    public Timestamp getSsrq() {
        return ssrq;
    }

    public void setSsrq(Timestamp ssrq) {
        this.ssrq = ssrq;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public int getBrnn() {
        return brnn;
    }

    public void setBrnn(int brnn) {
        this.brnn = brnn;
    }

    public String getSsbz() {
        return ssbz;
    }

    public void setSsbz(String ssbz) {
        this.ssbz = ssbz;
    }

    public String getSsnm() {
        return ssnm;
    }

    public void setSsnm(String ssnm) {
        this.ssnm = ssnm;
    }

    public Timestamp getSqrq() {
        return sqrq;
    }

    public void setSqrq(Timestamp sqrq) {
        this.sqrq = sqrq;
    }

    public String getSsyz() {
        return ssyz;
    }

    public void setSsyz(String ssyz) {
        this.ssyz = ssyz;
    }

    public String getSjys() {
        return sjys;
    }

    public void setSjys(String sjys) {
        this.sjys = sjys;
    }

    public Integer getBrks() {
        return brks;
    }

    public void setBrks(Integer brks) {
        this.brks = brks;
    }

    public String getSssz() {
        return sssz;
    }

    public void setSssz(String sssz) {
        this.sssz = sssz;
    }

    public Integer getSqdh() {
        return sqdh;
    }

    public void setSqdh(Integer sqdh) {
        this.sqdh = sqdh;
    }
}
