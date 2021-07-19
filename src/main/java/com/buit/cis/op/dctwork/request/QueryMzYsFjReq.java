package com.buit.cis.op.dctwork.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName QueryMzYsFjReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/12 15:08
 */
public class QueryMzYsFjReq extends PageQuery {
    @ApiModelProperty(value="拼音代码")
    private String query;
    @ApiModelProperty(value="用户类型 门诊: MZSY 住院:ZYSY")
    private String useType;
    @ApiModelProperty(value="病人性质")
    private String brxz;
    @ApiModelProperty(value="门诊科室")
    private String mzks;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getBrxz() {
        return brxz;
    }

    public void setBrxz(String brxz) {
        this.brxz = brxz;
    }

    public String getMzks() {
        return mzks;
    }

    public void setMzks(String mzks) {
        this.mzks = mzks;
    }
}
