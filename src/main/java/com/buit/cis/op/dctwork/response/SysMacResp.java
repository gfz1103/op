package com.buit.cis.op.dctwork.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysMac<br>
 * 类描述：MAC信息表(用于mac地址维护)<br>
 * @author 韦靖
 */
@ApiModel(value="MAC信息表(用于mac地址维护)")
public class SysMacResp  extends  PageQuery{
    @ApiModelProperty(value="主键")
    private Integer id;
    @ApiModelProperty(value="机构ID")
    private Integer jgid;
    @ApiModelProperty(value="IP")
    private String ip;
    @ApiModelProperty(value="IP对应的MAC")
    private String mac;
    /**
     * 设置:主键
     */
    public void setId(Integer value) {
        this.id = value;
    }
    /**
     * 获取:主键
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置:机构ID
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:机构ID
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:IP
     */
    public void setIp(String value) {
        this.ip = value;
    }
    /**
     * 获取:IP
     */
    public String getIp() {
        return ip;
    }
    /**
     * 设置:IP对应的MAC
     */
    public void setMac(String value) {
        this.mac = value;
    }
    /**
     * 获取:IP对应的MAC
     */
    public String getMac() {
        return mac;
    }
}
