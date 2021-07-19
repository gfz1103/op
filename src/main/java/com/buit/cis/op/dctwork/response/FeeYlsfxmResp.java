
package com.buit.cis.op.dctwork.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：FeeYlsfxm<br>
 * 类描述：公用_医疗收费<br>
 * @author 老花生
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="手术信息-返回")
public class FeeYlsfxmResp extends PageQuery {
	private static final long serialVersionUID = -3066408716209314159L;
	@ApiModelProperty(value="费用序号")
    private Integer fyxh;
    @ApiModelProperty(value="费用名称")
    private String fymc;
    @ApiModelProperty(value="fydj")
    private BigDecimal fydj;
    @ApiModelProperty(value="拼音代码")
    private String pydm;
    @ApiModelProperty(value = "费用单位")
    private String fydw;
    @ApiModelProperty(value="费用归并")
    private Integer fygb;
    @ApiModelProperty(value="手术内码")
    private Integer ssnm;
    

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }

    public String getFydw() {
        return fydw;
    }

    public void setFydw(String fydw) {
        this.fydw = fydw;
    }

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

	public Integer getSsnm() {
		return ssnm;
	}

	public void setSsnm(Integer ssnm) {
		this.ssnm = ssnm;
	}
    
    
}
