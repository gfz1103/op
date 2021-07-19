package com.buit.commons.model;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

/**
 * 类名称：YbSh04<br> 
 * 类描述：医保挂号
 * @author WY 
 * @ApiModel(value="医保挂号")
 */
public class YbSh04  extends  PageQuery{
	//@ApiModelProperty(value="中心流水号")
    /** 中心流水号 */
    private String zxlsh;
	//@ApiModelProperty(value="计算申请序号")
    /** 计算申请序号 */
    private String jssqxh;
	//@ApiModelProperty(value="记录册号")
    /** 记录册号 */
    private String jlch;
	//@ApiModelProperty(value="机构ID")
    /** 机构ID */
    private Integer jgid;
	//@ApiModelProperty(value="挂号序号")
    /** 挂号序号 */
    private String ghxh;
	//@ApiModelProperty(value="挂号时间")
    /** 挂号时间 */
    private String ghsj;
	//@ApiModelProperty(value="卡类型标志")
    /** 卡类型标志 */
    private String klbbz;
	//@ApiModelProperty(value="卡号")
    /** 卡号 */
    private String brkh;
	//@ApiModelProperty(value="交易费用总额")
    /** 交易费用总额 */
    private BigDecimal jyfyze;
	//@ApiModelProperty(value="当年帐户支付数")
    /** 当年帐户支付数 */
    private BigDecimal dnzhzfs;
	//@ApiModelProperty(value="历年帐户支付数")
    /** 历年帐户支付数 */
    private BigDecimal lnzhzfs;
	//@ApiModelProperty(value="自负段现金支付数")
    /** 自负段现金支付数 */
    private BigDecimal zfdxjzfs;
	//@ApiModelProperty(value="统筹段现金支付数")
    /** 统筹段现金支付数 */
    private BigDecimal tcdxjzfs;
	//@ApiModelProperty(value="统筹支付数")
    /** 统筹支付数 */
    private BigDecimal tczfs;
	//@ApiModelProperty(value="附加段现金支付数")
    /** 附加段现金支付数 */
    private BigDecimal fjdxjzfs;
	//@ApiModelProperty(value="附加支付数")
    /** 附加支付数 */
    private BigDecimal fjzfs;
	//@ApiModelProperty(value="当年帐户余额")
    /** 当年帐户余额 */
    private BigDecimal dnzhye;
	//@ApiModelProperty(value="历年帐户余额")
    /** 历年帐户余额 */
    private BigDecimal lnzhye;
	//@ApiModelProperty(value="医保结算范围费用总额")
    /** 医保结算范围费用总额 */
    private BigDecimal ybjsfwfyze;
	//@ApiModelProperty(value="非医保结算范围个人自费")
    /** 非医保结算范围个人自费 */
    private BigDecimal fybjsfwgrzf;
	//@ApiModelProperty(value="减免结算标志")
    /** 减免结算标志 */
    private String jmjsbz;
	//@ApiModelProperty(value="状态")
    /** 状态 */
    private String zt;
	//@ApiModelProperty(value="作废判别")
    /** 作废判别 */
    private String zfpb;
	//@ApiModelProperty(value="统筹段帐户支付数 (大病医保增加的字段)")
    /** 统筹段帐户支付数 (大病医保增加的字段) */
    private BigDecimal tcdzhzfs;
	//@ApiModelProperty(value="附加段帐户支付数 (大病医保增加的字段)")
    /** 附加段帐户支付数 (大病医保增加的字段) */
    private BigDecimal fjdzhzfs;
	//@ApiModelProperty(value="大病标志 1 大病")
    /** 大病标志 1 大病 */
    private String dbbz;

    /** 设置:中心流水号  */
    public void setZxlsh(String value) {
        this.zxlsh = value;
    }
    /** 获取:中心流水号 */
    public String getZxlsh() {
        return zxlsh;
    }

    /** 设置:计算申请序号  */
    public void setJssqxh(String value) {
        this.jssqxh = value;
    }
    /** 获取:计算申请序号 */
    public String getJssqxh() {
        return jssqxh;
    }

    /** 设置:记录册号  */
    public void setJlch(String value) {
        this.jlch = value;
    }
    /** 获取:记录册号 */
    public String getJlch() {
        return jlch;
    }

    /** 设置:机构ID  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构ID */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:挂号序号  */
    public void setGhxh(String value) {
        this.ghxh = value;
    }
    /** 获取:挂号序号 */
    public String getGhxh() {
        return ghxh;
    }

    /** 设置:挂号时间  */
    public void setGhsj(String value) {
        this.ghsj = value;
    }
    /** 获取:挂号时间 */
    public String getGhsj() {
        return ghsj;
    }

    /** 设置:卡类型标志  */
    public void setKlbbz(String value) {
        this.klbbz = value;
    }
    /** 获取:卡类型标志 */
    public String getKlbbz() {
        return klbbz;
    }

    /** 设置:卡号  */
    public void setBrkh(String value) {
        this.brkh = value;
    }
    /** 获取:卡号 */
    public String getBrkh() {
        return brkh;
    }

    /** 设置:交易费用总额  */
    public void setJyfyze(BigDecimal value) {
        this.jyfyze = value;
    }
    /** 获取:交易费用总额 */
    public BigDecimal getJyfyze() {
        return jyfyze;
    }

    /** 设置:当年帐户支付数  */
    public void setDnzhzfs(BigDecimal value) {
        this.dnzhzfs = value;
    }
    /** 获取:当年帐户支付数 */
    public BigDecimal getDnzhzfs() {
        return dnzhzfs;
    }

    /** 设置:历年帐户支付数  */
    public void setLnzhzfs(BigDecimal value) {
        this.lnzhzfs = value;
    }
    /** 获取:历年帐户支付数 */
    public BigDecimal getLnzhzfs() {
        return lnzhzfs;
    }

    /** 设置:自负段现金支付数  */
    public void setZfdxjzfs(BigDecimal value) {
        this.zfdxjzfs = value;
    }
    /** 获取:自负段现金支付数 */
    public BigDecimal getZfdxjzfs() {
        return zfdxjzfs;
    }

    /** 设置:统筹段现金支付数  */
    public void setTcdxjzfs(BigDecimal value) {
        this.tcdxjzfs = value;
    }
    /** 获取:统筹段现金支付数 */
    public BigDecimal getTcdxjzfs() {
        return tcdxjzfs;
    }

    /** 设置:统筹支付数  */
    public void setTczfs(BigDecimal value) {
        this.tczfs = value;
    }
    /** 获取:统筹支付数 */
    public BigDecimal getTczfs() {
        return tczfs;
    }

    /** 设置:附加段现金支付数  */
    public void setFjdxjzfs(BigDecimal value) {
        this.fjdxjzfs = value;
    }
    /** 获取:附加段现金支付数 */
    public BigDecimal getFjdxjzfs() {
        return fjdxjzfs;
    }

    /** 设置:附加支付数  */
    public void setFjzfs(BigDecimal value) {
        this.fjzfs = value;
    }
    /** 获取:附加支付数 */
    public BigDecimal getFjzfs() {
        return fjzfs;
    }

    /** 设置:当年帐户余额  */
    public void setDnzhye(BigDecimal value) {
        this.dnzhye = value;
    }
    /** 获取:当年帐户余额 */
    public BigDecimal getDnzhye() {
        return dnzhye;
    }

    /** 设置:历年帐户余额  */
    public void setLnzhye(BigDecimal value) {
        this.lnzhye = value;
    }
    /** 获取:历年帐户余额 */
    public BigDecimal getLnzhye() {
        return lnzhye;
    }

    /** 设置:医保结算范围费用总额  */
    public void setYbjsfwfyze(BigDecimal value) {
        this.ybjsfwfyze = value;
    }
    /** 获取:医保结算范围费用总额 */
    public BigDecimal getYbjsfwfyze() {
        return ybjsfwfyze;
    }

    /** 设置:非医保结算范围个人自费  */
    public void setFybjsfwgrzf(BigDecimal value) {
        this.fybjsfwgrzf = value;
    }
    /** 获取:非医保结算范围个人自费 */
    public BigDecimal getFybjsfwgrzf() {
        return fybjsfwgrzf;
    }

    /** 设置:减免结算标志  */
    public void setJmjsbz(String value) {
        this.jmjsbz = value;
    }
    /** 获取:减免结算标志 */
    public String getJmjsbz() {
        return jmjsbz;
    }

    /** 设置:状态  */
    public void setZt(String value) {
        this.zt = value;
    }
    /** 获取:状态 */
    public String getZt() {
        return zt;
    }

    /** 设置:作废判别  */
    public void setZfpb(String value) {
        this.zfpb = value;
    }
    /** 获取:作废判别 */
    public String getZfpb() {
        return zfpb;
    }

    /** 设置:统筹段帐户支付数 (大病医保增加的字段)  */
    public void setTcdzhzfs(BigDecimal value) {
        this.tcdzhzfs = value;
    }
    /** 获取:统筹段帐户支付数 (大病医保增加的字段) */
    public BigDecimal getTcdzhzfs() {
        return tcdzhzfs;
    }

    /** 设置:附加段帐户支付数 (大病医保增加的字段)  */
    public void setFjdzhzfs(BigDecimal value) {
        this.fjdzhzfs = value;
    }
    /** 获取:附加段帐户支付数 (大病医保增加的字段) */
    public BigDecimal getFjdzhzfs() {
        return fjdzhzfs;
    }

    /** 设置:大病标志 1 大病  */
    public void setDbbz(String value) {
        this.dbbz = value;
    }
    /** 获取:大病标志 1 大病 */
    public String getDbbz() {
        return dbbz;
    }


}