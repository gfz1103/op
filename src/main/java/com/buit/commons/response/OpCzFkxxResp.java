
package com.buit.commons.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpCzFkxx<br>
 * 类描述：充值_充值收费付款信息<br>
 * @author WY
 */
@ApiModel(value="充值_充值收费付款信息")
public class OpCzFkxxResp {
    @ApiModelProperty(value="记录序号")
    private Integer jlxh;
    @ApiModelProperty(value="cardid", hidden = true)
    private Integer cardid;
    @ApiModelProperty(value="机构代码", hidden = true)
    private Integer jgid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="充值日期")
    private Timestamp czrq;
    @ApiModelProperty(value="充值方式")
    private Integer czfs;
    @ApiModelProperty(value="充值金额")
    private BigDecimal czje;
    @ApiModelProperty(value="操作工号")
    private String czgh;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="结账日期")
    private Timestamp jzrq;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="汇总日期")
    private Timestamp hzrq;
    @ApiModelProperty(value="门诊类别")
    private Integer mzlb;
    @ApiModelProperty(value="门诊类别名称")
    private String mzmc;

    @ApiModelProperty(value="票据号码")
    private String czpj;
    @ApiModelProperty(value="档案号码")
    private String mzhm;
    @ApiModelProperty(value="就诊卡号")
    private String jzkh;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="患者性质")
    private String brxz;
    @ApiModelProperty(value="收费员姓名")
    private String czxm;

    /**
     * 设置:记录序号
     */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /**
     * 获取:记录序号
     */
    public Integer getJlxh() {
        return jlxh;
    }
    /**
     * 设置:cardid
     */
    public void setCardid(Integer value) {
        this.cardid = value;
    }
    /**
     * 获取:cardid
     */
    public Integer getCardid() {
        return cardid;
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
     * 设置:充值日期
     */
    public void setCzrq(Timestamp value) {
        this.czrq = value;
    }
    /**
     * 获取:充值日期
     */
    public Timestamp getCzrq() {
        return czrq;
    }
    /**
     * 设置:充值方式
     */
    public void setCzfs(Integer value) {
        this.czfs = value;
    }
    /**
     * 获取:充值方式
     */
    public Integer getCzfs() {
        return czfs;
    }
    /**
     * 设置:充值金额
     */
    public void setCzje(BigDecimal value) {
        this.czje = value;
    }
    /**
     * 获取:充值金额
     */
    public BigDecimal getCzje() {
        return czje;
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
     * 设置:结账日期
     */
    public void setJzrq(Timestamp value) {
        this.jzrq = value;
    }
    /**
     * 获取:结账日期
     */
    public Timestamp getJzrq() {
        return jzrq;
    }
    /**
     * 设置:汇总日期
     */
    public void setHzrq(Timestamp value) {
        this.hzrq = value;
    }
    /**
     * 获取:汇总日期
     */
    public Timestamp getHzrq() {
        return hzrq;
    }
    /**
     * 设置:mzlb
     */
    public void setMzlb(Integer value) {
        this.mzlb = value;
    }
    /**
     * 获取:mzlb
     */
    public Integer getMzlb() {
        return mzlb;
    }

    public String getCzpj() {
        return czpj;
    }

    public void setCzpj(String czpj) {
        this.czpj = czpj;
    }

    public String getMzhm() {
        return mzhm;
    }

    public void setMzhm(String mzhm) {
        this.mzhm = mzhm;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getBrxz() {
        return brxz;
    }

    public void setBrxz(String brxz) {
        this.brxz = brxz;
    }

    public String getCzxm() {
        return czxm;
    }

    public void setCzxm(String czxm) {
        this.czxm = czxm;
    }

    public String getMzmc() {
        return mzmc;
    }

    public void setMzmc(String mzmc) {
        this.mzmc = mzmc;
    }
}
