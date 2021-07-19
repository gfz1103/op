
package com.buit.cis.op.dctwork.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


/**
 * 类名称：OpBqzmPageReq<br>
 * 类描述：病区证明<br>
 * @author 老花生
 */
@ApiModel(value="病区证明-分页请求")
public class OpBqzmPageReq extends  PageQuery{
    @ApiModelProperty(value="类型:1 门诊 2 住院")
    @NotNull(message = "类型必传 1门诊 2住院")
    private Integer lx;

    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;
    @ApiModelProperty(value="住院号码")
    private String zyhm;

    @ApiModelProperty(value="门诊号码 取就诊流水号",hidden = true)
    private String mzhm;
    @ApiModelProperty(value="单据类型 1病情证明单 2疾病证明单",hidden = true)
    private String djlx;

    public String getDjlx() {
        return djlx;
    }

    public void setDjlx(String djlx) {
        this.djlx = djlx;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    /**
     * 设置:类型:1 门诊 2 住院
     */
    public void setLx(Integer value) {
        this.lx = value;
    }
    /**
     * 获取:类型:1 门诊 2 住院
     */
    public Integer getLx() {
        return lx;
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

}
