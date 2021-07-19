package com.buit.cis.op.dctwork.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryCfAllYpxxReq<br>
 * 类描述：查询全部药品-请求<br>
 * @author 老花生
 */
@ApiModel(value="查询全部药品-请求")
public class QueryCfAllYpxxReq extends PageQuery {
    @ApiModelProperty(value="拼音代码")
    private String pydm;
    @ApiModelProperty(value="处方类型 1：西药、2：中成药、3：草药")
    private Integer cflx;

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }

    public Integer getCflx() {
        return cflx;
    }

    public void setCflx(Integer cflx) {
        this.cflx = cflx;
    }
}
