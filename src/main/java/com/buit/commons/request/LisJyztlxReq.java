package com.buit.commons.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：LisJyztlx<br>
 * 类描述：组套类型维护<br>
 * @author 老花生
 */
@ApiModel(value="组套类型维护")
public class LisJyztlxReq {
    @ApiModelProperty(value="组套类型名称")
    @NotBlank(message = "组套类型名称 不能为空")
    @Size(max = 200)
    private String name;
    public void setName(String value) {
        this.name = value;
    }
    /**
     * 获取:组套类型名称
     */
    public String getName() {
        return name;
    }
}
