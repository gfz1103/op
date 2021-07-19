package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：DiccZlsfdz<br>
 * 类描述：诊疗收费对照<br>
 *
 * @author 老花生
 */
@ApiModel(value = "诊疗收费对照")
public class DiccZlsfdzResp {
    @ApiModelProperty(value = "主键记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "诊疗项目ID")
    private Integer zlxmid;
    @ApiModelProperty(value = "费用序号")
    private Integer fyxh;
    @ApiModelProperty(value = "费用数量")
    private Integer fysl;
    @ApiModelProperty(value = "费用名称")
    private String fymc;
    @ApiModelProperty(value = "商保价格")
    private BigDecimal sbjg;

    /**
     * 设置:主键记录序号
     */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }

    /**
     * 获取:主键记录序号
     */
    public Integer getJlxh() {
        return jlxh;
    }

    /**
     * 设置:诊疗项目ID
     */
    public void setZlxmid(Integer value) {
        this.zlxmid = value;
    }

    /**
     * 获取:诊疗项目ID
     */
    public Integer getZlxmid() {
        return zlxmid;
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
     * 设置:费用数量
     */
    public void setFysl(Integer value) {
        this.fysl = value;
    }

    /**
     * 获取:费用数量
     */
    public Integer getFysl() {
        return fysl;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public BigDecimal getSbjg() {
        return sbjg;
    }

    public void setSbjg(BigDecimal sbjg) {
        this.sbjg = sbjg;
    }
}
