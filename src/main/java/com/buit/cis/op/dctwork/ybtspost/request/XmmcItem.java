package com.buit.cis.op.dctwork.ybtspost.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author weijing
 * @Date 2021-04-09 14:11
 * @Description
 **/
public class XmmcItem {
    @ApiModelProperty(value = "组套内子项服务代码")
    private String ZXFWDM;

    @ApiModelProperty(value = "组套内检查部位子项代码")
    private String JCBWZXDM;

    @ApiModelProperty(value = "组套内检查部位子项名称")
    private String JCBWZX;

    public String getZXFWDM() {
        return ZXFWDM;
    }

    public void setZXFWDM(String ZXFWDM) {
        this.ZXFWDM = ZXFWDM;
    }

    public String getJCBWZXDM() {
        return JCBWZXDM;
    }

    public void setJCBWZXDM(String JCBWZXDM) {
        this.JCBWZXDM = JCBWZXDM;
    }

    public String getJCBWZX() {
        return JCBWZX;
    }

    public void setJCBWZX(String JCBWZX) {
        this.JCBWZX = JCBWZX;
    }
}
