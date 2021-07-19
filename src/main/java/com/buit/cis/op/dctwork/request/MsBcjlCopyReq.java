
package com.buit.cis.op.dctwork.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：MsBcjl<br>
 * 类描述：门诊_门诊病历 | 病程记录<br>
 * @author 老花生
 */
@ApiModel(value="门诊_门诊病历 | 病程记录-复制请求")
public class MsBcjlCopyReq extends  PageQuery{

    @ApiModelProperty(value="病人ID号")
    private Integer brid;
    @ApiModelProperty(value="就诊序号 | 就诊序号 类似于住院的住院号 每次就诊不一样")
    private Integer jzxh;

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }
}