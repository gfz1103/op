
package com.buit.cis.op.dctwork.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


/**
 * 类名称：DiccZlsfdz<br>
 * 类描述：诊疗收费对照<br>
 *
 * @author 老花生
 */
@ApiModel(value = "诊疗收费对照")
public class DiccZlsfdzAddReq {
    @ApiModelProperty(value = "诊疗项目ID",required = true)
    private Integer zlxmid;
    @NotNull(message = "费用序号不能为空")
    @ApiModelProperty(value = "费用序号",required = true)
    private Integer fyxh;
    @ApiModelProperty(value = "费用数量")
    private Integer fysl;

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
}
