package com.buit.commons.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName YjQueryPageHelperReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/16 20:47
 */
@ApiModel(value="医技全部查询（助手方式）-请求")
public class YjQueryPageHelperReq extends PageQuery {
    @ApiModelProperty(value="拼音代码")
    private String pydm;

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }
}
