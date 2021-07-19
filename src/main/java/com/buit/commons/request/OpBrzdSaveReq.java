
package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


/**
 * 类名称：OpBrzd<br>
 * 类描述：病人诊断保存<br>
 * @author 老花生
 */
@ApiModel(value="门诊_病人诊断-保存")
public class OpBrzdSaveReq {

    @ApiModelProperty(value="病人ID")
    private Integer brid;
    @ApiModelProperty(value="就诊序号")
    private Integer jzxh;
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;
    @ApiModelProperty(value="诊断集合")
    private List<OpBrzdAddReq> brzdList;

    @ApiModelProperty(value = "客户机ip",hidden = true)
    private String ip;
    @ApiModelProperty(value = "mac地址",hidden = true)
    private String mac;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

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

    public List<OpBrzdAddReq> getBrzdList() {
        return brzdList;
    }

    public void setBrzdList(List<OpBrzdAddReq> brzdList) {
        this.brzdList = brzdList;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }
}
