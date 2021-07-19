
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


/**
 * 类名称：DrugsTypk<br>
 * 类描述：药库_药品基本库分页<br>
 * @author "MLeo"
 */
@ApiModel(value="药库_药品基本库分页")
public class DrugsTypkPackageSelfPageReq extends PageQuery{

    @NotNull(message = "药库识别不能为空")
    @ApiModelProperty(value="药库识别",required = true)
    private Integer yksb;

    @ApiModelProperty(value="机构代码",hidden = true)
    private Integer jgid;

    @ApiModelProperty(value="拼音代码")
    private String pydm;
    @ApiModelProperty(value="角形代码")
    private String jxdm;


    public Integer getYksb() {
        return yksb;
    }

    public void setYksb(Integer yksb) {
        this.yksb = yksb;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }

    public String getJxdm() {
        return jxdm;
    }

    public void setJxdm(String jxdm) {
        this.jxdm = jxdm;
    }
}
