
package com.buit.cis.op.dctwork.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicZlxmQueryReq<br>
 * 类描述：查询诊疗项目列表-请求<br>
 * @author 老花生
 */
@ApiModel(value="查询诊疗项目列表-请求")
public class DicZlxmQueryReq extends  PageQuery{
    @ApiModelProperty(value="病人性质")
    private String brxz;
    @ApiModelProperty(value="医技类型")
    private Integer yjlx;

    public String getBrxz() {
        return brxz;
    }

    public void setBrxz(String brxz) {
        this.brxz = brxz;
    }

    public Integer getYjlx() {
        return yjlx;
    }

    public void setYjlx(Integer yjlx) {
        this.yjlx = yjlx;
    }
}
