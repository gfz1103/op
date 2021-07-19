
package com.buit.commons.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpBrzdQueryResp<br>
 * 类描述：查询病人诊断信息-返回<br>
 * @author 老花生
 */
@ApiModel(value="查询病人诊断信息-返回")
public class OpBrzdQueryResp{

    @ApiModelProperty(value="诊断名称")
    private String zdmc;
    @ApiModelProperty(value="主诉")
    private String tztz;
    @ApiModelProperty(value="主诊断名称")
    private String mainZdmc;
    @ApiModelProperty(value="主诊断ICD10")
    private String mainIcd10;


    public String getZdmc() {
        return zdmc;
    }

    public void setZdmc(String zdmc) {
        this.zdmc = zdmc;
    }

    public String getTztz() {
        return tztz;
    }

    public void setTztz(String tztz) {
        this.tztz = tztz;
    }

    public String getMainZdmc() {
        return mainZdmc;
    }

    public void setMainZdmc(String mainZdmc) {
        this.mainZdmc = mainZdmc;
    }

    public String getMainIcd10() {
        return mainIcd10;
    }

    public void setMainIcd10(String mainIcd10) {
        this.mainIcd10 = mainIcd10;
    }
}
