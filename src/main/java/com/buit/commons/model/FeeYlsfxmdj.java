package com.buit.commons.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 类名称：FeeYlsfxmdj<br>
 * 类描述：公用_医院医疗明细项目
 * @author 老花生
 * @ApiModel(value="公用_医院医疗明细项目")
 */
public class FeeYlsfxmdj extends PageQuery {
	@ApiModelProperty(value="机构代码")
    private Integer jgid;
	@ApiModelProperty(value="费用序号")
    private Integer fyxh;
	@ApiModelProperty(value="费用单价")
    private BigDecimal fydj;
	@ApiModelProperty(value="费用科室")
    private Integer fyks;
	@ApiModelProperty(value="作废判别")
    private Integer zfpb;
	@ApiModelProperty(value="打折比例")
    private BigDecimal dzbl;
	@ApiModelProperty(value="zdcr")
    private Integer zdcr;
	@ApiModelProperty(value="jgbz")
    private Integer jgbz;
	@ApiModelProperty(value="jfyz")
    private Integer jfyz;
	@ApiModelProperty(value="限制使用标志 | 0:不限制,1:限制")
    private Integer xzsy;
	@ApiModelProperty(value="限制使用为1时,此处填写限制次数")
    private Integer xzcs;
	@ApiModelProperty(value="限制使用为1时,此处填写限制天数")
    private Integer xzts;
	@ApiModelProperty(value="商保价格")
    private BigDecimal sbjg;
	@ApiModelProperty(value="CPT CODE")
    private String cptcode;
	@ApiModelProperty(value="英文名称")
    private String ywmc;

    /** 设置:机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构代码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:费用序号  */
    public void setFyxh(Integer value) {
        this.fyxh = value;
    }
    /** 获取:费用序号 */
    public Integer getFyxh() {
        return fyxh;
    }

    /** 设置:费用单价  */
    public void setFydj(BigDecimal value) {
        this.fydj = value;
    }
    /** 获取:费用单价 */
    public BigDecimal getFydj() {
        return fydj;
    }

    /** 设置:费用科室  */
    public void setFyks(Integer value) {
        this.fyks = value;
    }
    /** 获取:费用科室 */
    public Integer getFyks() {
        return fyks;
    }

    /** 设置:作废判别  */
    public void setZfpb(Integer value) {
        this.zfpb = value;
    }
    /** 获取:作废判别 */
    public Integer getZfpb() {
        return zfpb;
    }

    /** 设置:打折比例  */
    public void setDzbl(BigDecimal value) {
        this.dzbl = value;
    }
    /** 获取:打折比例 */
    public BigDecimal getDzbl() {
        return dzbl;
    }

    /** 设置:zdcr  */
    public void setZdcr(Integer value) {
        this.zdcr = value;
    }
    /** 获取:zdcr */
    public Integer getZdcr() {
        return zdcr;
    }

    /** 设置:jgbz  */
    public void setJgbz(Integer value) {
        this.jgbz = value;
    }
    /** 获取:jgbz */
    public Integer getJgbz() {
        return jgbz;
    }

    /** 设置:jfyz  */
    public void setJfyz(Integer value) {
        this.jfyz = value;
    }
    /** 获取:jfyz */
    public Integer getJfyz() {
        return jfyz;
    }

    /** 设置:限制使用标志 | 0:不限制,1:限制  */
    public void setXzsy(Integer value) {
        this.xzsy = value;
    }
    /** 获取:限制使用标志 | 0:不限制,1:限制 */
    public Integer getXzsy() {
        return xzsy;
    }

    /** 设置:限制使用为1时,此处填写限制次数  */
    public void setXzcs(Integer value) {
        this.xzcs = value;
    }
    /** 获取:限制使用为1时,此处填写限制次数 */
    public Integer getXzcs() {
        return xzcs;
    }

    /** 设置:限制使用为1时,此处填写限制天数  */
    public void setXzts(Integer value) {
        this.xzts = value;
    }
    /** 获取:限制使用为1时,此处填写限制天数 */
    public Integer getXzts() {
        return xzts;
    }

    /** 设置:商保价格  */
    public void setSbjg(BigDecimal value) {
        this.sbjg = value;
    }
    /** 获取:商保价格 */
    public BigDecimal getSbjg() {
        return sbjg;
    }

    /** 设置:CPT CODE  */
    public void setCptcode(String value) {
        this.cptcode = value;
    }
    /** 获取:CPT CODE */
    public String getCptcode() {
        return cptcode;
    }

    /** 设置:英文名称  */
    public void setYwmc(String value) {
        this.ywmc = value;
    }
    /** 获取:英文名称 */
    public String getYwmc() {
        return ywmc;
    }


}
