
package com.buit.ecis.pretriage.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


/**
 * 类名称：ErPreZslb<br>
 * 类描述：主诉类别<br>
 * @author 朱智
 */
@ApiModel(value="主诉类别")
public class ErPreZslbResp  extends  PageQuery{
    @ApiModelProperty(value="主诉类别ID")
    private int zslbid;
    @ApiModelProperty(value="主诉类别")
    private String zslb;
    private List<ErPreZslbResp> children;

    public int getZslbid() {
        return zslbid;
    }

    public void setZslbid(int zslbid) {
        this.zslbid = zslbid;
    }

    public String getZslb() {
        return zslb;
    }

    public void setZslb(String zslb) {
        this.zslb = zslb;
    }

    public List<ErPreZslbResp> getChildren() {
        return children;
    }

    public void setChildren(List<ErPreZslbResp> children) {
        this.children = children;
    }
}