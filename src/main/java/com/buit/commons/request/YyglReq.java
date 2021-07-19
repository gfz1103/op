
package com.buit.commons.request;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：YyglReq<br>
 * 类描述：预约管理-请求<br>
 * @author 老花生
 */
@ApiModel(value="预约管理-请求")
public class YyglReq extends PageQuery {
    @NotNull(message = "挂号日期 不能为空")
    @ApiModelProperty(value="挂号日期")
    private Date ghrq;
    //@NotNull(message = "科室类别 不能为空")
    @ApiModelProperty(value="科室类别")
    private Integer kslb;
    //@NotNull(message = "值班类别 不能为空")
    @ApiModelProperty(value="值班类别")
    private String zblb;
    @ApiModelProperty(value="拼音代码")
    private String pydm;

    public Date getGhrq() {
        return ghrq;
    }

    public void setGhrq(Date ghrq) {
        this.ghrq = ghrq;
    }

    public Integer getKslb() {
        return kslb;
    }

    public void setKslb(Integer kslb) {
        this.kslb = kslb;
    }

    public String getZblb() {
        return zblb;
    }

    public void setZblb(String zblb) {
        this.zblb = zblb;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }
}