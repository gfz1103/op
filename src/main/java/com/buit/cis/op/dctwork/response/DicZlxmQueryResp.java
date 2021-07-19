
package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：DicZlxmQueryResp<br>
 * 类描述：查询诊疗项目列表-返回<br>
 * @author 老花生
 */
@ApiModel(value="查询诊疗项目列表-返回")
public class DicZlxmQueryResp {

    @ApiModelProperty(value="检查知情同意书")
    private String jczqtys;
    @ApiModelProperty(value="诊疗项目 ID")
    private Integer zlxmid;
    @ApiModelProperty(value="执行科室")
    private Integer zxks;
    @ApiModelProperty(value="注意事项")
    private String zysx;
    @ApiModelProperty(value="项目名称")
    private String xmmc;
    @ApiModelProperty(value="费用单价")
    private BigDecimal fydj;

    public String getJczqtys() {
        return jczqtys;
    }

    public void setJczqtys(String jczqtys) {
        this.jczqtys = jczqtys;
    }

    public Integer getZlxmid() {
        return zlxmid;
    }

    public void setZlxmid(Integer zlxmid) {
        this.zlxmid = zlxmid;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }

    public String getZysx() {
        return zysx;
    }

    public void setZysx(String zysx) {
        this.zysx = zysx;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }
}
