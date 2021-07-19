
package com.buit.cis.op.dctwork.request;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpCfps<br>
 * 类描述：处方皮试<br>
 * @author 朱智
 */
@ApiModel(value="处方皮试-请求")
public class OpCfpsReq  extends  PageQuery{
    @ApiModelProperty(value="附加信息ID",hidden = true)
    private Integer id;
    @ApiModelProperty(value="就诊序号", hidden = true)
    private Integer jzxh;
    @ApiModelProperty(value="处方识别", hidden = true)
    private Integer cfsb;
    @ApiModelProperty(value="皮试ID")
    private Integer psid;
    @ApiModelProperty(value="皮试名称")
    private String psmc;
    @ApiModelProperty(value="皮试数量")
    private Integer pssl;
    @ApiModelProperty(value="皮试金额")
    private BigDecimal psje;
    /**
     * 设置:附加信息ID
     */
    public void setId(Integer value) {
        this.id = value;
    }
    /**
     * 获取:附加信息ID
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置:就诊序号
     */
    public void setJzxh(Integer value) {
        this.jzxh = value;
    }
    /**
     * 获取:就诊序号
     */
    public Integer getJzxh() {
        return jzxh;
    }
    /**
     * 设置:处方识别
     */
    public void setCfsb(Integer value) {
        this.cfsb = value;
    }
    /**
     * 获取:处方识别
     */
    public Integer getCfsb() {
        return cfsb;
    }
    /**
     * 设置:皮试ID
     */
    public void setPsid(Integer value) {
        this.psid = value;
    }
    /**
     * 获取:皮试ID
     */
    public Integer getPsid() {
        return psid;
    }
    /**
     * 设置:皮试名称
     */
    public void setPsmc(String value) {
        this.psmc = value;
    }
    /**
     * 获取:皮试名称
     */
    public String getPsmc() {
        return psmc;
    }
    /**
     * 设置:皮试数量
     */
    public void setPssl(Integer value) {
        this.pssl = value;
    }
    /**
     * 获取:皮试数量
     */
    public Integer getPssl() {
        return pssl;
    }
    /**
     * 设置:皮试金额
     */
    public void setPsje(BigDecimal value) {
        this.psje = value;
    }
    /**
     * 获取:皮试金额
     */
    public BigDecimal getPsje() {
        return psje;
    }
}