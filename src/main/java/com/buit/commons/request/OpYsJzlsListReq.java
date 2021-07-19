
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


/**
 * 类名称：OpYsJzls<br>
 * 类描述：门诊_就诊历史<br>
 * @author 老花生
 */
@ApiModel(value="门诊_就诊历史-就诊记录查询")
public class OpYsJzlsListReq extends PageQuery {
    @NotNull(message = "病人编号 不能为空")
    @ApiModelProperty(value="病人编号")
    private Integer brbh;
    @ApiModelProperty(value="开始时间")
    private Timestamp kssj;
    @ApiModelProperty(value="结束时间")
    private Timestamp jssj;
    @ApiModelProperty(value="门诊号码")
    private Integer ghxh;
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    /**
     * 设置:病人编号
     */
    public void setBrbh(Integer value) {
        this.brbh = value;
    }
    /**
     * 获取:病人编号
     */
    public Integer getBrbh() {
        return brbh;
    }
    /**
     * 设置:开始时间
     */
    public void setKssj(Timestamp value) {
        this.kssj = value;
    }
    /**
     * 获取:开始时间
     */
    public Timestamp getKssj() {
        return kssj;
    }
    /**
     * 设置:结束时间
     */
    public void setJssj(Timestamp value) {
        this.jssj = value;
    }
    /**
     * 获取:结束时间
     */
    public Timestamp getJssj() {
        return jssj;
    }

    public Integer getGhxh() {
        return ghxh;
    }

    public void setGhxh(Integer ghxh) {
        this.ghxh = ghxh;
    }
}
