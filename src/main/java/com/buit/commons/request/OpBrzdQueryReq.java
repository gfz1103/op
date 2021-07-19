
package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpBrzdQueryReq<br>
 * 类描述：查询病人诊断信息-请求<br>
 * @author 老花生
 */
@ApiModel(value="查询病人诊断信息-请求")
public class OpBrzdQueryReq {

    @ApiModelProperty(value="就诊序号 | 每次就诊的唯一号")
    private Integer jzxh;
    @ApiModelProperty(value="申请类型 1 门诊、 2 住院")
    private Integer sqlx;
    @ApiModelProperty(value="住院号")
    private Integer zyh;

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

    public Integer getSqlx() {
        return sqlx;
    }

    public void setSqlx(Integer sqlx) {
        this.sqlx = sqlx;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }
}
