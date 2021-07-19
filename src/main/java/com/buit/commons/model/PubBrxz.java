package com.buit.commons.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 类名称：PubBrxz<br>
 * 类描述：公用_病人性质 | 包括自费、公费、记帐等<br>
 *
 * @author "MLeo"
 */

public class PubBrxz extends PageQuery {
    @ApiModelProperty(value = "性质代码")
    private Integer brxz;
    @ApiModelProperty(value = "性质名称")
    private String xzmc;
    @ApiModelProperty(value = "上级性质 | 指明该类证号是否存在上级性质,及其上级代码")
    private Integer sjxz;
    @ApiModelProperty(value = "归属性质 | 归属于某最高级病人性质")
    private Integer gsxz;
    @ApiModelProperty(value = "拼音码")
    private String pydm;
    @ApiModelProperty(value = "证号判别 | 0.不需要 1.需要")
    private String zhpb;
    @ApiModelProperty(value = "保险判别 | 0.非保险 1.大病保险 2.医疗保险 9.其他保险")
    private Integer dbpb;
    @ApiModelProperty(value = "门诊使用")
    private Integer mzsy;
    @ApiModelProperty(value = "住院使用")
    private Integer zysy;
    @ApiModelProperty(value = "实收比例")
    private BigDecimal ssbl;
    @ApiModelProperty(value = "床费限价 | 某些病人床位限制在某金额才为公费，自动累加床位费时将超过的金额写入自负床位费")
    private BigDecimal cfxj;
    @ApiModelProperty(value = "处方限额")
    private BigDecimal cfxe;
    @ApiModelProperty(value = "排列顺序")
    private String plsx;
    @ApiModelProperty(value = "性质控制大类")
    private String xzdl;
    @ApiModelProperty(value = "退费分步交易")
    private Integer tffbjy;
    @ApiModelProperty(value = "妇幼儿童标志")
    private Integer fyetbz;
    @ApiModelProperty(value = "vipcwfy")
    private String vipcwfy;

    /**
     * 设置:性质代码
     */
    public void setBrxz(Integer value) {
        this.brxz = value;
    }

    /**
     * 获取:性质代码
     */
    public Integer getBrxz() {
        return brxz;
    }

    /**
     * 设置:性质名称
     */
    public void setXzmc(String value) {
        this.xzmc = value;
    }

    /**
     * 获取:性质名称
     */
    public String getXzmc() {
        return xzmc;
    }

    /**
     * 设置:上级性质 | 指明该类证号是否存在上级性质,及其上级代码
     */
    public void setSjxz(Integer value) {
        this.sjxz = value;
    }

    /**
     * 获取:上级性质 | 指明该类证号是否存在上级性质,及其上级代码
     */
    public Integer getSjxz() {
        return sjxz;
    }

    /**
     * 设置:归属性质 | 归属于某最高级病人性质
     */
    public void setGsxz(Integer value) {
        this.gsxz = value;
    }

    /**
     * 获取:归属性质 | 归属于某最高级病人性质
     */
    public Integer getGsxz() {
        return gsxz;
    }

    /**
     * 设置:拼音码
     */
    public void setPydm(String value) {
        this.pydm = value;
    }

    /**
     * 获取:拼音码
     */
    public String getPydm() {
        return pydm;
    }

    /**
     * 设置:证号判别 | 0.不需要 1.需要
     */
    public void setZhpb(String value) {
        this.zhpb = value;
    }

    /**
     * 获取:证号判别 | 0.不需要 1.需要
     */
    public String getZhpb() {
        return zhpb;
    }

    /**
     * 设置:保险判别 | 0.非保险 1.大病保险 2.医疗保险 9.其他保险
     */
    public void setDbpb(Integer value) {
        this.dbpb = value;
    }

    /**
     * 获取:保险判别 | 0.非保险 1.大病保险 2.医疗保险 9.其他保险
     */
    public Integer getDbpb() {
        return dbpb;
    }

    /**
     * 设置:门诊使用
     */
    public void setMzsy(Integer value) {
        this.mzsy = value;
    }

    /**
     * 获取:门诊使用
     */
    public Integer getMzsy() {
        return mzsy;
    }

    /**
     * 设置:住院使用
     */
    public void setZysy(Integer value) {
        this.zysy = value;
    }

    /**
     * 获取:住院使用
     */
    public Integer getZysy() {
        return zysy;
    }

    /**
     * 设置:实收比例
     */
    public void setSsbl(BigDecimal value) {
        this.ssbl = value;
    }

    /**
     * 获取:实收比例
     */
    public BigDecimal getSsbl() {
        return ssbl;
    }

    /**
     * 设置:床费限价 | 某些病人床位限制在某金额才为公费，自动累加床位费时将超过的金额写入自负床位费
     */
    public void setCfxj(BigDecimal value) {
        this.cfxj = value;
    }

    /**
     * 获取:床费限价 | 某些病人床位限制在某金额才为公费，自动累加床位费时将超过的金额写入自负床位费
     */
    public BigDecimal getCfxj() {
        return cfxj;
    }

    /**
     * 设置:处方限额
     */
    public void setCfxe(BigDecimal value) {
        this.cfxe = value;
    }

    /**
     * 获取:处方限额
     */
    public BigDecimal getCfxe() {
        return cfxe;
    }

    /**
     * 设置:排列顺序
     */
    public void setPlsx(String value) {
        this.plsx = value;
    }

    /**
     * 获取:排列顺序
     */
    public String getPlsx() {
        return plsx;
    }

    /**
     * 设置:性质控制大类
     */
    public void setXzdl(String value) {
        this.xzdl = value;
    }

    /**
     * 获取:性质控制大类
     */
    public String getXzdl() {
        return xzdl;
    }

    /**
     * 设置:退费分步交易
     */
    public void setTffbjy(Integer value) {
        this.tffbjy = value;
    }

    /**
     * 获取:退费分步交易
     */
    public Integer getTffbjy() {
        return tffbjy;
    }

    /**
     * 设置:妇幼儿童标志
     */
    public void setFyetbz(Integer value) {
        this.fyetbz = value;
    }

    /**
     * 获取:妇幼儿童标志
     */
    public Integer getFyetbz() {
        return fyetbz;
    }

    /**
     * 设置:vipcwfy
     */
    public void setVipcwfy(String value) {
        this.vipcwfy = value;
    }

    /**
     * 获取:vipcwfy
     */
    public String getVipcwfy() {
        return vipcwfy;
    }


}
