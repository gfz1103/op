package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName LoadOutClinicInitParamsResp
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/1 13:52
 */
@ApiModel(value="获取处方录入模块公共信息参数返回")
public class LoadOutClinicInitParamsResp {
    @ApiModelProperty(value="医生姓名")
    private String ygxm;
    @ApiModelProperty(value="开处方权")
    private String kcfq;
    @ApiModelProperty(value="麻醉药权")
    private String mzyq;
    @ApiModelProperty(value="抗生素等级")
    private String kssqx;
    @ApiModelProperty(value="精神药")
    private String kjsy;

    public String getYgxm() {
        return ygxm;
    }

    public void setYgxm(String ygxm) {
        this.ygxm = ygxm;
    }

    public String getKcfq() {
        return kcfq;
    }

    public void setKcfq(String kcfq) {
        this.kcfq = kcfq;
    }

    public String getMzyq() {
        return mzyq;
    }

    public void setMzyq(String mzyq) {
        this.mzyq = mzyq;
    }

    public String getKssqx() {
        return kssqx;
    }

    public void setKssqx(String kssqx) {
        this.kssqx = kssqx;
    }

    public String getKjsy() {
        return kjsy;
    }

    public void setKjsy(String kjsy) {
        this.kjsy = kjsy;
    }
}
