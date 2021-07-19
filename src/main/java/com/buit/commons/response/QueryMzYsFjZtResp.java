package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName QueryMzYsFjZtResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/12 13:18
 */
@ApiModel(value="门诊医生工作站-辅检查询-组套返回")
public class QueryMzYsFjZtResp {

    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @ApiModelProperty(value="组套名称")
    private String ztmc;
    @ApiModelProperty(value="项目类型")
    private Integer xmlx;
    @ApiModelProperty(value="所属类别 | 1.个人组套 2.科室组套 3.公用组套 4.个人常用药 5.科室常用 6.全院常用")
    private Integer sslb;

    public Integer getZtbh() {
        return ztbh;
    }

    public void setZtbh(Integer ztbh) {
        this.ztbh = ztbh;
    }

    public String getZtmc() {
        return ztmc;
    }

    public void setZtmc(String ztmc) {
        this.ztmc = ztmc;
    }

    public Integer getXmlx() {
        return xmlx;
    }

    public void setXmlx(Integer xmlx) {
        this.xmlx = xmlx;
    }

    public Integer getSslb() {
        return sslb;
    }

    public void setSslb(Integer sslb) {
        this.sslb = sslb;
    }
}
