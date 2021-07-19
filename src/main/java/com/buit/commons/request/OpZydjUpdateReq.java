package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * 门诊住院登记分页更新状态请求
 * 类名称：OpZydjUpdateReq<br>
 * 类描述：<br>
 * @author 老花生
 */
@ApiModel(value="门诊住院登记分页更新请求")
public class OpZydjUpdateReq {

    @ApiModelProperty(value="登记ID")
    @NotNull(message = "登记ID 不能为空")
    private Integer djid;
    @ApiModelProperty(value="联系人姓名")
    private String lxrm;
    @ApiModelProperty(value="联系人地址")
    private String lxdz;
    @ApiModelProperty(value="联系电话")
    private String lxdh;
    @ApiModelProperty(value="入院目的")
    @NotBlank(message = "入院目的 不能为空")
    private String rymd;
    @ApiModelProperty(value="登记类型")
    @NotBlank(message = "登记类型 不能为空")
    private String djlx;
    @ApiModelProperty(value="拟收治病区")
    @NotBlank(message = "拟收治病区 不能为空")
    private String nszbq;
    @ApiModelProperty(value="特需标志")
    private Integer txbz;
    @ApiModelProperty(value="大病减负标志 1:尿毒症透析医疗费用,2:肾移植减负,3：精神病减负  其他：不减负")
    private String dbjfbz;
    @ApiModelProperty(value="拟收治科室")
    @NotNull(message = "拟收治科室 不能为空")
    private Integer nszks;
    @ApiModelProperty(value="联系人关系")
    private String lxrgx;

    public Integer getNszks() {
        return nszks;
    }

    public void setNszks(Integer nszks) {
        this.nszks = nszks;
    }

    public String getLxrgx() {
        return lxrgx;
    }

    public void setLxrgx(String lxrgx) {
        this.lxrgx = lxrgx;
    }

    public Integer getDjid() {
        return djid;
    }

    public void setDjid(Integer djid) {
        this.djid = djid;
    }

    public String getLxrm() {
        return lxrm;
    }

    public void setLxrm(String lxrm) {
        this.lxrm = lxrm;
    }

    public String getLxdz() {
        return lxdz;
    }

    public void setLxdz(String lxdz) {
        this.lxdz = lxdz;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getRymd() {
        return rymd;
    }

    public void setRymd(String rymd) {
        this.rymd = rymd;
    }

    public String getDjlx() {
        return djlx;
    }

    public void setDjlx(String djlx) {
        this.djlx = djlx;
    }

    public String getNszbq() {
        return nszbq;
    }

    public void setNszbq(String nszbq) {
        this.nszbq = nszbq;
    }

    public Integer getTxbz() {
        return txbz;
    }

    public void setTxbz(Integer txbz) {
        this.txbz = txbz;
    }

    public String getDbjfbz() {
        return dbjfbz;
    }

    public void setDbjfbz(String dbjfbz) {
        this.dbjfbz = dbjfbz;
    }
}
