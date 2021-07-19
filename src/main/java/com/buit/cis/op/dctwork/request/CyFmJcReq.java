package com.buit.cis.op.dctwork.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 类名称：CyFmJcReq<br>
 * 类描述：草药房名、煎法-请求<br>
 * @author 老花生
 */
@ApiModel(value = "草药房名、煎法-请求")
public class CyFmJcReq extends PageQuery {
    @NotNull(message = "代码类别 不能为空")
    @ApiModelProperty(value="primarydataId 825煎法、824方明")
    private Integer primarydataId;
    @ApiModelProperty(value="拼音代码")
    private String pyCode;

    public Integer getPrimarydataId() {
        return primarydataId;
    }

    public void setPrimarydataId(Integer primarydataId) {
        this.primarydataId = primarydataId;
    }

    public String getPyCode() {
        return pyCode;
    }

    public void setPyCode(String pyCode) {
        this.pyCode = pyCode;
    }
}
